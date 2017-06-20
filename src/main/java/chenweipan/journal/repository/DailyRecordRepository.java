package chenweipan.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chenweipan.journal.po.DailyRecord;

public interface DailyRecordRepository extends JpaRepository<DailyRecord, Long> {

}
