package chenweipan.journal.business;

import chenweipan.journal.exception.JournalException;
import chenweipan.journal.model.Code;
import chenweipan.journal.po.DailyType;
import chenweipan.journal.po.JournalUser;
import chenweipan.journal.service.DailyTypeService;
import chenweipan.journal.web.request.PageReq;
import chenweipan.journal.web.request.type.ChangeTypeReq;
import chenweipan.journal.web.request.type.CreateTypeReq;
import chenweipan.journal.web.response.PageResp;
import chenweipan.journal.web.response.type.TypePageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Component
public class DailyTypeBusiness {

    private static final Logger logger = LoggerFactory.getLogger(DailyTypeBusiness.class);

    @Autowired
    DailyTypeService typeService;

    public void createType(CreateTypeReq req, JournalUser operator) {
        logger.info("req:{},operator:{}", req, operator.getUsername());
        typeService.createType(req.getTypeName(), req.getDesc(), operator.getId());
    }

    public PageResp<TypePageInfo> queryType(PageReq req, JournalUser operator) {
        logger.info("req:{},operator:{}", req, operator.getUsername());
        PageRequest pageRequest = new PageRequest(req.getPage() - 1, req.getRows(), Sort.Direction.DESC, "id");
        Page<DailyType> pageResp = typeService.queryTypeByPage(pageRequest, operator.getId());
        PageResp<TypePageInfo> result = toPageResp(pageResp);
        result.setPage(req.getPage());
        logger.info("result:{}", result);
        return result;
    }

    public PageResp<TypePageInfo> toPageResp(Page<DailyType> pageResp) {
        logger.info("req:{}", pageResp);
        PageResp<TypePageInfo> result = new PageResp<TypePageInfo>();
        List<DailyType> lists = pageResp.getContent();
        List<TypePageInfo> typeLists = new ArrayList<TypePageInfo>();
        for (int i = 0; i < lists.size(); i++) {
            typeLists.add(toTypePageInfo(lists.get(i)));
        }
        result.setContent(typeLists);
        result.setItems(lists.size());
        result.setTotal(pageResp.getTotalElements());
        result.setTotalPages(pageResp.getTotalPages());
        logger.info("result:{}", result);
        return result;
    }

    public TypePageInfo toTypePageInfo(DailyType type) {
        TypePageInfo info = new TypePageInfo();
        info.setId(type.getId());
        info.setTypeName(type.getTypeName());
        info.setDesc(type.getDescript());
        return info;
    }

    public void changeType(ChangeTypeReq req, Long operator) throws JournalException {
        DailyType type = typeService.findById(new Integer(req.getId()).longValue());
        if(type==null){
            throw new JournalException(Code.TYPE_NOT_FOUND);
        }
        if (!type.getUserId().equals(operator)) {
            throw new JournalException(Code.PERMITTED_ERROR);
        }
        typeService.changeType(type, req.getTypeName(), req.getDesc());
    }
}
