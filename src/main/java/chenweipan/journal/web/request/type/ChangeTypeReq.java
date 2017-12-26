package chenweipan.journal.web.request.type;

public class ChangeTypeReq {
    private int id;
    private String typeName;
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return "ChangeTypeReq{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
