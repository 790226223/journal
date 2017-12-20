package chenweipan.journal.model;


/**
 * 操作码
 *
 * @author Kevin
 */
public enum Code {

    SUCCESS("运行成功", 200),

    SERVER_ERROR("服务器内部错误", 420),

    PARAM_ERROR("参数错误", 421),

    NAME_PWD_ERROR("登录失败，请重新登录", 401),

    NOT_LOGIN("用户未登录", 411);


    private String message;
    private int status;

    Code(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }
}
