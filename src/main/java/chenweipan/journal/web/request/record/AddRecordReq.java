package chenweipan.journal.web.request.record;

public class AddRecordReq {
    private Long type;
    private String title;
    private String descript;
    private String things;
    private Integer count;
    private String units;
    private String startTime;
    private String endTime;
    private boolean titleSame = false;

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
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

    public boolean isTitleSame() {
        return titleSame;
    }

    public void setTitleSame(boolean titleSame) {
        this.titleSame = titleSame;
    }

    @Override
    public String toString() {
        return "AddRecordReq{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", descript='" + descript + '\'' +
                ", things='" + things + '\'' +
                ", count=" + count +
                ", units='" + units + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", titleSame=" + titleSame +
                '}';
    }
}
