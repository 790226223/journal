package chenweipan.journal.po;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "default_type")
    private Long defaultType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDefaultType() {
        return defaultType;
    }

    public void setDefaultType(Long defaultType) {
        this.defaultType = defaultType;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", defaultType=" + defaultType +
                '}';
    }
}
