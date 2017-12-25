package chenweipan.journal.web;

import chenweipan.journal.business.DailyTypeBusiness;
import chenweipan.journal.business.UserInfoBusiness;
import chenweipan.journal.exception.JournalException;
import chenweipan.journal.model.Code;
import chenweipan.journal.model.CommonResult;
import chenweipan.journal.po.JournalUser;
import chenweipan.journal.service.UserInfoService;
import chenweipan.journal.web.request.IdReq;
import chenweipan.journal.web.request.PageReq;
import chenweipan.journal.web.request.type.ChangeTypeReq;
import chenweipan.journal.web.request.type.CreateTypeReq;
import chenweipan.journal.web.response.type.TypePageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    UserInfoBusiness userInfoBusiness;

    @RequestMapping(value = "/page_query.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult queryTypeByPage(@RequestBody PageReq req) {
        logger.info("req:{}", req);
        CommonResult result = new CommonResult();
        JournalUser operator = (JournalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        result.setDetail(typeBusiness.queryType(req, operator));
        logger.info("result:{}", result);
        return result;
    }

    @RequestMapping(value = "/add_type.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addType(@RequestBody CreateTypeReq req) {
        logger.info("req:{}", req);
        CommonResult result = new CommonResult();
        JournalUser operator = (JournalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        typeBusiness.createType(req, operator);
        logger.info("result:{}", result);
        return result;
    }

    @RequestMapping(value = "/change_type.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult changeType(@RequestBody ChangeTypeReq req) throws JournalException {
        logger.info("req:{}", req);
        JournalUser operator = (JournalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CommonResult result = new CommonResult();
        typeBusiness.changeType(req, operator.getId());
        logger.info("result:{}", result);
        return result;
    }

    @RequestMapping(value = "/del_type.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delType() {
        CommonResult result = new CommonResult();
        result.setCode(Code.NOT_OPEN);
        return result;
    }

    @RequestMapping(value = "/set_default_type.json", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult setDefaultType(@RequestBody IdReq req) {
        logger.info("req:{}",req);
        CommonResult result = new CommonResult();
        JournalUser operator = (JournalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userInfoBusiness.setDefaultType(req.getId(), operator.getId());
        return result;
    }

    @RequestMapping(value = "/default_type.json", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult defaultType() {
        CommonResult result = new CommonResult();
        JournalUser operator = (JournalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        TypePageInfo info = userInfoBusiness.getDefaultType(operator.getId());
        result.setDetail(info);
        return result;
    }
}
