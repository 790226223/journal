package chenweipan.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chenweipan.journal.po.DailyRecord;

import java.util.List;

public interface DailyRecordRepository extends JpaRepository<DailyRecord, Long> {

    public List<DailyRecord> findByTitle(String title);
}
