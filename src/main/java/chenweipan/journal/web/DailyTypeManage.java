package chenweipan.journal.web;

import chenweipan.journal.model.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("daily_type")
public class DailyTypeManage {

    private static final Logger logger = LoggerFactory.getLogger(DailyTypeManage.class);

    public CommonResult createDailyType(){
        return null;
    }
}
