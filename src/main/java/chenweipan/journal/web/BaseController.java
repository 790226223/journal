package chenweipan.journal.web;

import chenweipan.journal.exception.JournalException;
import chenweipan.journal.model.Code;
import chenweipan.journal.model.CommonResult;
import chenweipan.journal.web.request.IdReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

@Controller
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler({JournalException.class})
    @ResponseBody
    public CommonResult catchJournalException(JournalException ex) {
        logger.error("JournalException:{}", ex);
        CommonResult result = new CommonResult();
        result.setCode(ex.getErrorCode());
        return result;
    }

    @ExceptionHandler({ParseException.class})
    @ResponseBody
    public CommonResult catchPraseException(ParseException ex) {
        logger.error("ParseException:{}", ex);
        CommonResult result = new CommonResult();
        result.setCode(Code.PARAM_ERROR);
        return result;
    }

    static CommonResult notOpenResult(@RequestBody IdReq req) {
        logger.info("req:{}", req);
        CommonResult result = new CommonResult();
        result.setCode(Code.NOT_OPEN);
        logger.info("result:{}", result);
        return result;
    }
}
