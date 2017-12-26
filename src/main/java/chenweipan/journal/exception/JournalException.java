package chenweipan.journal.exception;

import chenweipan.journal.model.Code;

public class JournalException extends Throwable {

    public JournalException(Code code) {
        this.errorCode = code;
    }

    private Code errorCode;

    public Code getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Code errorCode) {
        this.errorCode = errorCode;
    }
}
