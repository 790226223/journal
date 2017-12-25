package chenweipan.journal.repository;

import chenweipan.journal.po.RecordWithType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordWithTypeRepository extends JpaRepository<RecordWithType, Long> {
}
