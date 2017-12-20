package chenweipan.journal.web;

import chenweipan.journal.model.CommonResult;
import chenweipan.journal.service.DailyRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("test")
public class Test {

	private static final Logger logger = LoggerFactory.getLogger(Test.class);

	@Autowired
	DailyRecordService dailyRecordService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(value = "/test.json", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult test(@RequestBody JournalRequest request) throws ParseException
	{
		logger.info("this is log info");
		CommonResult result = new CommonResult();
		dailyRecordService.createNewJournal(request.getDayTime(), request.getThing(), request.getDescript(),
				request.getCount(), request.getUnit(), request.getStart(), request.getEnd());
		result.setCode("200");
		result.setDetail("SUCCESS");
		return result;
	}

	@RequestMapping(value = "/gettest.json", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult getTest() throws ParseException {
		logger.info("this is log info");
		CommonResult result = new CommonResult();
		result.setCode("200");
		result.setDetail("SUCCESS");
		return result;
	}
}
