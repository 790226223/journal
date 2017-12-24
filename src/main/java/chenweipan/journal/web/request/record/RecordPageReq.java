package chenweipan.journal.web.request.record;

import chenweipan.journal.web.request.PageReq;

public class RecordPageReq extends PageReq {
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+"RecordPageReq{" +
                "type=" + type +
                '}';
    }
}
