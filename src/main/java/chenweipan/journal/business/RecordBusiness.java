package chenweipan.journal.business;

import chenweipan.journal.exception.JournalException;
import chenweipan.journal.model.Code;
import chenweipan.journal.po.*;
import chenweipan.journal.repository.DailyTypeRepository;
import chenweipan.journal.repository.RecordAndTypeRepository;
import chenweipan.journal.repository.RecordTypeRepository;
import chenweipan.journal.repository.SportInfoRepository;
import chenweipan.journal.service.DailyRecordService;
import chenweipan.journal.service.DailyTypeService;
import chenweipan.journal.spec.RecordTypeSpecification;
import chenweipan.journal.util.DateUtil;
import chenweipan.journal.web.request.record.AddRecordReq;
import chenweipan.journal.web.request.record.ChangeRecord;
import chenweipan.journal.web.request.record.RecordPageReq;
import chenweipan.journal.web.response.PageResp;
import chenweipan.journal.web.response.record.RecordDetailResp;
import chenweipan.journal.web.response.record.RecordPageInfo;
import chenweipan.journal.web.response.type.TypePageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RecordBusiness {

    private static final Logger logger = LoggerFactory.getLogger(RecordBusiness.class);

    @Autowired
    DailyRecordService dailyRecordService;

    @Autowired
    DailyTypeService dailyTypeService;

    @Autowired
    RecordAndTypeRepository recordAndTypeRepository;

    @Autowired
    SportInfoRepository sportInfoRepository;

    @Autowired
    RecordTypeRepository recordTypeRepository;

    @Autowired
    DailyTypeRepository dailyTypeRepository;

    public void newRecord(AddRecordReq req, Long operator) throws ParseException, JournalException {
        logger.info("req:{},operator:{}", req, operator);
        checkTypeExist(req.getType());
        dailyRecordService.addRecord(req, operator);
    }

    private void checkTypeExist(Long type2) throws JournalException {
        logger.info("id:{}", type2);
        DailyType type = dailyTypeService.findById(type2);
        if (type == null) {
            throw new JournalException(Code.TYPE_NOT_FOUND);
        }
    }

    public void updateRecord(ChangeRecord req, Long operator) throws JournalException, ParseException {
        logger.info("req:{},operator:{}", req, operator);
        checkRecordExist(req.getId());
        checkRecordOwern(req.getId(), operator);
        checkTypeExist(req.getType());
        dailyRecordService.updateRecord(req, operator);
    }

    public void checkRecordExist(Long recordId) throws JournalException {
        logger.info("recordId:{}", recordId);
        DailyRecord record = dailyRecordService.findById(recordId);
        if (record == null) {
            throw new JournalException(Code.RECORD_NOT_FOUND);
        }
    }

    public void checkRecordOwern(Long recordId, Long operatorId) throws JournalException {
        logger.info("recordId:{},operator:{}", recordId, operatorId);
        DailyRecord record = dailyRecordService.findById(recordId);
        if (!record.getUserId().equals(operatorId)) {
            throw new JournalException(Code.PERMITTED_ERROR);
        }
    }

    public PageResp<RecordPageInfo> findByPage(RecordPageReq req, Long operator) {
        logger.info("req:{},operator:{}", req, operator);
        RecordTypeSpecification spec = new RecordTypeSpecification(operator, req.getType());
        PageRequest request = new PageRequest(req.getPage() - 1, req.getRows(), Sort.Direction.DESC, "recordId.id");
        Page<RecordAndType> pageInfo = recordAndTypeRepository.findAll(spec, request);
        PageResp<RecordPageInfo> result = toPageResp(pageInfo);
        result.setPage(req.getPage());
        logger.info("result:{}", result);
        return result;
    }

    public PageResp<RecordPageInfo> toPageResp(Page<RecordAndType> pageInfo) {
        logger.info("req:{}", pageInfo);
        PageResp<RecordPageInfo> result = new PageResp<RecordPageInfo>();
        List<RecordAndType> lists = pageInfo.getContent();
        List<RecordPageInfo> recordLists = new ArrayList<RecordPageInfo>();
        for (int i = 0; i < lists.size(); i++) {
            recordLists.add(toRecordPageInfo(lists.get(i)));
        }
        result.setContent(recordLists);
        result.setItems(lists.size());
        result.setTotal(pageInfo.getTotalElements());
        result.setTotalPages(pageInfo.getTotalPages());
        logger.info("result:{}", result);
        return result;
    }

    public RecordPageInfo toRecordPageInfo(RecordAndType recordAndType) {
        logger.info("recordAndType:{}", recordAndType);
        RecordPageInfo recordPageInfo = new RecordPageInfo();
        recordPageInfo.setId(recordAndType.getRecordId().getId());
        recordPageInfo.setDayTime(DateUtil.DATE_FORMAT.format(recordAndType.getRecordId().getDayTime()));
        recordPageInfo.setTitle(recordAndType.getRecordId().getTitle());
        recordPageInfo.setDesc(recordAndType.getRecordId().getDescript());
        recordPageInfo.setType(recordAndType.getTypeId().getTypeName());
        return recordPageInfo;
    }

    public RecordDetailResp getDetail(Long id){
        RecordDetailResp result = new RecordDetailResp();
        DailyRecord record = dailyRecordService.findById(id);
        RecordType recordType = recordTypeRepository.findByRecordId(record.getId());
        DailyType type = dailyTypeRepository.findOne(recordType.getTypeId());
        result.setId(record.getId());
        result.setTitle(record.getTitle());
        result.setDescript(record.getDescript());
        result.setType(type.getTypeName());
        result.setTypeDesc(type.getDescript());
        result.setDayTime(DateUtil.DATE_FORMAT.format(record.getDayTime()));
        if(record.getSportId()!=null){
            SportInfo sportInfo = sportInfoRepository.findOne(record.getSportId());
            result.setThings(sportInfo.getThings());
            result.setCount(sportInfo.getCount());
            result.setUnits(sportInfo.getUnits());
            result.setStartTime(DateUtil.TIME_FORMAT.format(new Date(sportInfo.getStartTime().getTime())));
            result.setEndTime(DateUtil.TIME_FORMAT.format(new Date(sportInfo.getEndTime().getTime())));
        }
        return result;
    }
}
