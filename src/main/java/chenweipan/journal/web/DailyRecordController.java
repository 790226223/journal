package chenweipan.journal.web;

import chenweipan.journal.business.RecordBusiness;
import chenweipan.journal.exception.JournalException;
import chenweipan.journal.model.Code;
import chenweipan.journal.model.CommonResult;
import chenweipan.journal.po.JournalUser;
import chenweipan.journal.web.request.IdReq;
import chenweipan.journal.web.request.record.AddRecordReq;
import chenweipan.journal.web.request.record.ChangeRecord;
import chenweipan.journal.web.request.record.RecordPageReq;
import chenweipan.journal.web.request.type.ChangeTypeReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

@Controller
@RequestMapping("daily_record")
public class DailyRecordController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DailyRecordController.class);

    @Autowired
    RecordBusiness recordBusiness;

    @RequestMapping(value = "/record_page.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult queryRecordByPage(@RequestBody RecordPageReq req) {
        logger.info("req:{}", req);
        CommonResult result = new CommonResult();
        JournalUser operator = (JournalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        result.setDetail(recordBusiness.findByPage(req, operator.getId()));
        logger.info("result:{}", result);
        return result;
    }

    @RequestMapping(value = "/record_info.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult recordInfo(@RequestBody IdReq req) {
        logger.info("req:{}", req);
        CommonResult result = new CommonResult();
        result.setDetail(recordBusiness.getDetail(req.getId()));
        logger.info("result:{}", result);
        return result;
    }

    @RequestMapping(value = "/new_record.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createRecord(@RequestBody AddRecordReq req) throws JournalException, ParseException {
        logger.info("req:{}", req);
        CommonResult result = new CommonResult();
        JournalUser operator = (JournalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        recordBusiness.newRecord(req, operator.getId());
        logger.info("result:{}", result);
        return result;
    }

    @RequestMapping(value = "/update_record.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult changeRecord(@RequestBody ChangeRecord req) throws JournalException, ParseException {
        logger.info("req:{}", req);
        CommonResult result = new CommonResult();
        JournalUser operator = (JournalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        recordBusiness.updateRecord(req, operator.getId());
        logger.info("result:{}", result);
        return result;
    }

    @RequestMapping(value = "/del_record.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteRecord(@RequestBody IdReq req) {
        return notOpenResult(req);
    }


}
