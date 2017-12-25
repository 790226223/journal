package chenweipan.journal.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class RecordWithType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "day_time", nullable = false)
    private Date dayTime;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "descript")
    private String descript;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "sport_id")
    private Long sportId;

    @ManyToMany
    @JoinTable(
            name="record_type",
            joinColumns=@JoinColumn(name="record_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="type_id", referencedColumnName="id"))
    private List<DailyType> types;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDayTime() {
        return dayTime;
    }

    public void setDayTime(Date dayTime) {
        this.dayTime = dayTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public List<DailyType> getTypes() {
        return types;
    }

    public void setTypes(List<DailyType> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "RecordWithType{" +
                "id=" + id +
                ", dayTime=" + dayTime +
                ", title='" + title + '\'' +
                ", descript='" + descript + '\'' +
                ", userId=" + userId +
                ", sportId=" + sportId +
                ", types=" + types +
                '}';
    }
}
