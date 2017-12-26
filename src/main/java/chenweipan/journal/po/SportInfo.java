package chenweipan.journal.po;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "sport_info")
public class SportInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "things", nullable = false)
    private String things;

    @Column(name = "count")
    private Integer count;

    @Column(name = "units")
    private String units;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "SportInfo{" +
                "id=" + id +
                ", things='" + things + '\'' +
                ", count=" + count +
                ", units='" + units + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
