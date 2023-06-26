package jp.co.axa.apidemo.common;

/**
 * APIレスポンスコード
 * Created by liu on 2023/6/19.
 */
public enum ResultCode implements StatusCode {
    SUCCESS(200, "成功"),
    FAILED(500, "処理失敗"),
    VALIDATE_FAILED(404, "パラメーター不正"),
    UNAUTHORIZED(401, "認証失敗"),
    FORBIDDEN(403, "権限がありません");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
