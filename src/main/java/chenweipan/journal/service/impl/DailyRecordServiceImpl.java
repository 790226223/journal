package chenweipan.journal.service.impl;

import chenweipan.journal.po.DailyRecord;
import chenweipan.journal.repository.DailyRecordRepository;
import chenweipan.journal.service.DailyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service()
@Transactional
public class DailyRecordServiceImpl implements DailyRecordService {

	@Autowired
	DailyRecordRepository dailyRecordRepository;

	public void createNewJournal(String dayTime, String things, String descript, Integer count, String unit,
			String start, String end) {
//		System.out.println("dayTime:" + dayTime.toString() + ",start:" + start + ",end:" + end);
//		DailyRecord record = new DailyRecord();
//		record.setDayTime(dayTime);
//		record.setDescript(descript);
//		record.setCount(count);
//		record.setUnits(unit);
//		record.setStartTime(start);
//		record.setEndTime(end);
//		dailyRecordRepository.saveAndFlush(record);

	}

}
