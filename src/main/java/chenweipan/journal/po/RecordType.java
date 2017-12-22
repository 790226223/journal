package chenweipan.journal.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "record_type")
public class RecordType implements Serializable {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "record_id")
    private Integer recordId;

    @Column(name = "type_id")
    private Integer typeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
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
