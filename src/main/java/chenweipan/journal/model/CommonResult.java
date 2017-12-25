package chenweipan.journal.model;


import java.io.Serializable;

/**
 * 统一返回值数据格式
 *
 * @author CWP
 */
public class CommonResult implements Serializable {

    private static final long serialVersionUID = 8222887432287833694L;

    /**
     * 信息码
     */
    private String code = Code.SUCCESS.name();

    /**
     * 返回数据 |信息码描述信息
     */
    private Object detail;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCode(Code code) {
        this.code = code.name();
        this.detail = code.getMessage();
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "CommonResult [code=" + code + ", detail=" + detail + "]";
    }

}
