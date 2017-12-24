package chenweipan.journal.web.response;

import java.util.List;

public class PageResp<T> {
    private int total;
    private int items;
    private int page;
    private int totalPages;
    private List<T> content;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PageResp{" +
                "total=" + total +
                ", items=" + items +
                ", page=" + page +
                ", totalPages=" + totalPages +
                ", content=" + content +
                '}';
    }
}
