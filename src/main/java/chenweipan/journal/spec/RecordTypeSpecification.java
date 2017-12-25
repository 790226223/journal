package chenweipan.journal.spec;

import chenweipan.journal.po.RecordAndType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RecordTypeSpecification implements Specification<RecordAndType> {

    private Long userId;

    private Long typeId;

    public RecordTypeSpecification(Long userId, Long typeId){
        this.typeId = typeId;
        this.userId = userId;
    }

    @Override
    public Predicate toPredicate(Root<RecordAndType> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> list = new ArrayList<Predicate>();
        if(userId!=null){
            List<Long> values = new ArrayList<Long>();
            values.add(userId);
            list.add(criteriaBuilder.and(root.<Boolean>get("recordId").<Boolean>get("userId").in(values)));
        }
        if(typeId!=null){
            List<Long> values = new ArrayList<Long>();
            values.add(typeId);
            list.add(criteriaBuilder.and(root.<Boolean>get("typeId").<Boolean>get("").in(values)));
        }
        return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
    }
}
