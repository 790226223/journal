package chenweipan.journal.web.request;

public class IdReq {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdReq{" +
                "id=" + id +
                '}';
    }
}
