package chenweipan.journal.service;

import chenweipan.journal.po.DailyRecord;
import chenweipan.journal.web.request.record.AddRecordReq;
import chenweipan.journal.web.request.record.ChangeRecord;

import java.text.ParseException;
import java.util.List;

public interface DailyRecordService {

    public void addRecord(AddRecordReq req, Long operator) throws ParseException;

    public DailyRecord findById(Long id);

    public void updateRecord(ChangeRecord req, Long operator) throws ParseException;

    public List<DailyRecord> findByTitle(String title);
}
