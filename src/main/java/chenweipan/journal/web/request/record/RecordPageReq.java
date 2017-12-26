package chenweipan.journal.web.request.record;

import chenweipan.journal.web.request.PageReq;

public class RecordPageReq extends PageReq {
    private Long type;

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+"RecordPageReq{" +
                "type=" + type +
                '}';
    }
}
