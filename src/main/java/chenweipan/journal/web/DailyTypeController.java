package chenweipan.journal.web;

import chenweipan.journal.business.DailyTypeBusiness;
import chenweipan.journal.model.CommonResult;
import chenweipan.journal.web.request.type.CreateTypeReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("daily_type")
public class DailyTypeController {

    private static final Logger logger = LoggerFactory.getLogger(DailyTypeController.class);

    @Autowired
    DailyTypeBusiness typeBusiness;

    @RequestMapping(value = "/page_query.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult queryTypeByPage(){
        return null;
    }

    @RequestMapping(value = "/add_type.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addType(@RequestBody CreateTypeReq req){
        CommonResult result = new CommonResult();
        typeBusiness.createType(req);
        return result;
    }

    @RequestMapping(value = "/change_type.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult changeType(){
        return null;
    }

    @RequestMapping(value = "/del_type.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delType(){
        return null;
    }

    @RequestMapping(value = "/default_type.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult setDefaultType(){
        return null;
    }
}
