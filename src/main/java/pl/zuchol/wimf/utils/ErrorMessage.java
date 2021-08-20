package pl.zuchol.wimf.utils;

public class ErrorMessage {

    private String code;
    private Integer codeNumber;
    private String message;

    public ErrorMessage(String code, Integer codeNumber, String message) {
        this.code = code;
        this.codeNumber = codeNumber;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public Integer getCodeNumber() {
        return codeNumber;
    }

    public String getMessage() {
        return message;
    }
}
