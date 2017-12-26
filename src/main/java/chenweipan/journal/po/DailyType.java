package chenweipan.journal.po;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "daily_type")
public class DailyType implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8298710068437139612L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "type_name", nullable = false)
    private String typeName;

    @Column(name = "descript")
    private String descript;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DailyType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", descript='" + descript + '\'' +
                ", userId=" + userId +
                '}';
    }
}
