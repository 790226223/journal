package chenweipan.journal.business;

import chenweipan.journal.service.DailyTypeService;
import chenweipan.journal.web.request.type.CreateTypeReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DailyTypeBusiness {

    private static final Logger logger = LoggerFactory.getLogger(DailyTypeBusiness.class);

    @Autowired
    DailyTypeService typeService;

    public void createType(CreateTypeReq req){
        typeService.createType(req.getTypeName(), req.getDesc());
    }
}
