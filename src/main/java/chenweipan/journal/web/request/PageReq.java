package chenweipan.journal.web.request;

public class PageReq {
    private int page;
    private int rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageReq{" +
                "page=" + page +
                ", rows=" + rows +
                '}';
    }
}
