package chenweipan.journal.repository;

import chenweipan.journal.po.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordTypeRepository extends JpaRepository<RecordType, Long> {

    public RecordType findByRecordId(Long recordId);
}
