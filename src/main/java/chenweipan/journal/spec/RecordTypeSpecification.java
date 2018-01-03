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

    private String title;

    public RecordTypeSpecification(Long userId, Long typeId, String title) {
        this.typeId = typeId;
        this.userId = userId;
        this.title = title;
    }

    @Override
    public Predicate toPredicate(Root<RecordAndType> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> list = new ArrayList<Predicate>();
        if (userId != null) {
            List<Long> values = new ArrayList<Long>();
            values.add(userId);
            list.add(criteriaBuilder.and(root.<Boolean>get("recordId").<Boolean>get("userId").in(values)));
        }
        if (typeId != null) {
            List<Long> values = new ArrayList<Long>();
            values.add(typeId);
            list.add(criteriaBuilder.and(root.<Boolean>get("typeId").get("id").in(values)));
        }
        if (title != null) {
            list.add(criteriaBuilder.like(root.<String>get("recordId").<String>get("title").as(String.class), "%"+title+"%"));
        }
        return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
    }
}
