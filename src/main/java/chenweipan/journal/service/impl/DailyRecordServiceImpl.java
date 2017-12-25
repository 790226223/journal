package chenweipan.journal.service.impl;

import chenweipan.journal.po.DailyRecord;
import chenweipan.journal.po.RecordType;
import chenweipan.journal.po.SportInfo;
import chenweipan.journal.repository.DailyRecordRepository;
import chenweipan.journal.repository.RecordTypeRepository;
import chenweipan.journal.repository.SportInfoRepository;
import chenweipan.journal.service.DailyRecordService;
import chenweipan.journal.util.DateUtil;
import chenweipan.journal.util.StringUtil;
import chenweipan.journal.web.request.record.AddRecordReq;
import chenweipan.journal.web.request.record.ChangeRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.text.ParseException;
import java.util.Date;

@Service()
@Transactional(rollbackFor = Exception.class)
public class DailyRecordServiceImpl implements DailyRecordService {

    private static final Logger logger = LoggerFactory.getLogger(DailyRecordServiceImpl.class);

    @Autowired
    DailyRecordRepository dailyRecordRepository;

    @Autowired
    RecordTypeRepository recordTypeRepository;

    @Autowired
    SportInfoRepository sportInfoRepository;

    @Override
    public void addRecord(AddRecordReq req, Long operator) throws ParseException {
        logger.info("req:{},operator:{}", req, operator);
        DailyRecord dailyRecord = saveRecord(req.getTitle(), req.getDescript(), operator);
        saveRecordType(req.getType(), dailyRecord.getId());
        if (StringUtil.isNotEmpty(req.getThings())) {
            SportInfo sportInfo = saveSportInfo(req);
            setSportId(dailyRecord, sportInfo.getId());
        }
    }

    public void saveRecordType(Long typeId, Long recordId) {
        logger.info("typeId:{},recordId:{}", typeId, recordId);
        RecordType recordType = new RecordType();
        recordType.setTypeId(typeId);
        recordType.setRecordId(recordId);
        recordTypeRepository.saveAndFlush(recordType);
    }

    @Override
    public DailyRecord findById(Long id) {
        logger.info("id:{}", id);
        return dailyRecordRepository.findOne(id);
    }

    @Override
    public void updateRecord(ChangeRecord req, Long operator) throws ParseException {
        logger.info("req:{},operator:{}", req, operator);
        DailyRecord record = findById(req.getId());
        RecordType recordType = recordTypeRepository.findByRecordId(record.getId());
        recordType.setTypeId(req.getType());
        recordTypeRepository.saveAndFlush(recordType);
        record.setTitle(req.getTitle());
        record.setDescript(req.getDescript());
        if (StringUtil.isNotEmpty(req.getThings())) {
            SportInfo sport = null;
            if(record.getSportId()==null){
                sport = new SportInfo();
            }else{
                sport = sportInfoRepository.findOne(record.getSportId());
            }
            sport.setThings(req.getThings());
            sport.setCount(req.getCount());
            sport.setUnits(req.getUnits());
            sport.setStartTime(new Time(DateUtil.TIME_FORMAT.parse(req.getStartTime()).getTime()));
            sport.setEndTime(new Time(DateUtil.TIME_FORMAT.parse(req.getEndTime()).getTime()));
            sport = sportInfoRepository.saveAndFlush(sport);
            record.setSportId(sport.getId());
        } else {
            if(record.getSportId()!=null){
                sportInfoRepository.delete(record.getSportId());
            }
            record.setSportId(null);
        }
        dailyRecordRepository.saveAndFlush(record);
    }

    private void setSportId(DailyRecord dailyRecord, Long sportId) {
        logger.info("record:{},sportId:{}", dailyRecord, sportId);
        dailyRecord.setSportId(sportId);
        dailyRecordRepository.saveAndFlush(dailyRecord);
    }

    private SportInfo saveSportInfo(AddRecordReq req) throws ParseException {
        logger.info("sport info:{}", req);
        SportInfo sportInfo = new SportInfo();
        sportInfo.setCount(req.getCount());
        sportInfo.setStartTime(new Time(DateUtil.TIME_FORMAT.parse(req.getStartTime()).getTime()));
        sportInfo.setEndTime(new Time(DateUtil.TIME_FORMAT.parse(req.getEndTime()).getTime()));
        sportInfo.setThings(req.getThings());
        sportInfo.setUnits(req.getUnits());
        sportInfo = sportInfoRepository.saveAndFlush(sportInfo);
        return sportInfo;
    }

    public DailyRecord saveRecord(String title, String desc, Long operator) {
        logger.info("title :{},desc:{},operaotr:{}", title, desc, operator);
        DailyRecord dailyRecord = new DailyRecord();
        dailyRecord.setDayTime(new Date());
        dailyRecord.setDescript(desc);
        dailyRecord.setUserId(operator);
        dailyRecord.setTitle(title);
        dailyRecord = dailyRecordRepository.saveAndFlush(dailyRecord);
        return dailyRecord;
    }
}
