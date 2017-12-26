package chenweipan.journal.po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "record_type")
public class RecordType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "type_id")
    private Long typeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "RecordType{" +
                "id=" + id +
                ", recordId=" + recordId +
                ", typeId=" + typeId +
                '}';
    }
}
