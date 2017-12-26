package chenweipan.journal.web.request.record;

public class ChangeRecord {
    private Long id;
    private Long type;
    private String title;
    private String descript;
    private String things;
    private Integer count;
    private String units;
    private String startTime;
    private String endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ChangeRecord{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", descript='" + descript + '\'' +
                ", things='" + things + '\'' +
                ", counter=" + count +
                ", units='" + units + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
