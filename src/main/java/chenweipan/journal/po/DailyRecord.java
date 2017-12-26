package chenweipan.journal.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "daily_record")
public class DailyRecord implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5030238457924472593L;

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

    @Override
    public String toString() {
        return "DailyRecord{" +
                "id=" + id +
                ", dayTime='" + dayTime + '\'' +
                ", title='" + title + '\'' +
                ", descript='" + descript + '\'' +
                ", userId=" + userId +
                ", sportId=" + sportId +
                '}';
    }
}
