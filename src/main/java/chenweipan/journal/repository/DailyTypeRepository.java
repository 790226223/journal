package chenweipan.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chenweipan.journal.po.DailyType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DailyTypeRepository extends JpaRepository<DailyType, Long>, JpaSpecificationExecutor<DailyType> {

    public Page<DailyType> findAll(Pageable page);

    public Page<DailyType> findByUserId(Long userId, Pageable page);
}
