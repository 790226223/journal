package chenweipan.journal.web.response.type;

public class TypePageInfo {
    private Long id;
    private String typeName;
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "TypePageInfo{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
