package chenweipan.journal.po;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "record_type")
public class RecordAndType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private DailyRecord recordId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private DailyType typeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DailyRecord getRecordId() {
        return recordId;
    }

    public void setRecordId(DailyRecord recordId) {
        this.recordId = recordId;
    }

    public DailyType getTypeId() {
        return typeId;
    }

    public void setTypeId(DailyType typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "RecordAndType{" +
                "id=" + id +
                ", recordId=" + recordId +
                ", typeId=" + typeId +
                '}';
    }
}
