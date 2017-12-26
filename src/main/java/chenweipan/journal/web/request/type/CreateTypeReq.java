package chenweipan.journal.web.request.type;

public class CreateTypeReq {
    private String typeName;

    private String desc;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "CreateTypeReq{" +
                "typeName='" + typeName + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
