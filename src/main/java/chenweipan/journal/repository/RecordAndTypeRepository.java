package chenweipan.journal.repository;

import chenweipan.journal.po.RecordAndType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecordAndTypeRepository extends JpaRepository<RecordAndType, Long>,JpaSpecificationExecutor<RecordAndType> {
}
