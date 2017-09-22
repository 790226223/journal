package chenweipan.journal.service;

public interface DailyRecordService {

	public void createNewJournal(String dayTime, String things, String descript, Integer count, String unit,
			String start, String end);
}
