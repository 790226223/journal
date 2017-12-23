package chenweipan.journal.web;

import chenweipan.journal.model.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("daily_record")
public class DailyRecordController {

    private static final Logger logger = LoggerFactory.getLogger(DailyRecordController.class);

    @RequestMapping(value = "/record_page.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult queryRecordByPage(){
        return null;
    }

    @RequestMapping(value = "/record_info.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult recordInfo(){
        return null;
    }

    @RequestMapping(value = "/new_record.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createRecord(){
        return null;
    }

    @RequestMapping(value = "/update_record.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult changeRecord(){
        return null;
    }

    @RequestMapping(value = "/del_record.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteRecord(){
        return null;
    }
}
