package chenweipan.journal.web;

import chenweipan.journal.exception.JournalException;
import chenweipan.journal.model.Code;
import chenweipan.journal.model.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler({JournalException.class})
    @ResponseBody
    public CommonResult catchJournalException(JournalException ex) {
        logger.error("JournalException:{}", ex);
        CommonResult result = new CommonResult();
        result.setCode(ex.getErrorCode().name());
        result.setDetail(ex.getErrorCode().getMessage());
        return result;
    }
}
