package chenweipan.journal.web.request;

public class IdReq {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdReq{" +
                "id=" + id +
                '}';
    }
}
