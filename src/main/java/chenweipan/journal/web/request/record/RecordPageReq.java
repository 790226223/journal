package chenweipan.journal.web.request.record;

import chenweipan.journal.web.request.PageReq;

public class RecordPageReq extends PageReq {
    private Long type;

    private  String title;

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

    @Override
    public String toString() {
        return "RecordPageReq{" +
                "type=" + type +
                ", title='" + title + '\'' +
                '}';
    }
}
