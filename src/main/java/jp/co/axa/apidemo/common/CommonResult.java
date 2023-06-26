package jp.co.axa.apidemo.common;

/**
 * レスポンスクラス
 * Created by Liu on 2023/4/19.
 */
public class CommonResult<T> {
    /**
     * ステータスコード
     */
    private long code;
    /**
     * メッセージ
     */
    private String message;
    /**
     * レスポンスデータ
     */
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 処理成功
     * @param data レスポンスデータ
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 処理成功、カスタマイズメッセージを返す
     * @param data レスポンスデータ
     * @param  message レスポンスメッセージ
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 処理失敗、カスタマイズエラーコードとデフォルトメッセージを返す
     * @param errorCode エラーコード
     */
    public static <T> CommonResult<T> failed(StatusCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 処理失敗、カスタマイズエラーコードとメッセージを返す
     * @param errorCode エラーコード
     * @param message エラーメッセージ
     */
    public static <T> CommonResult<T> failed(StatusCode errorCode, String message) {
        return new CommonResult<T>(errorCode.getCode(), message, null);
    }

    /**
     * 処理失敗、デフォルトエラーコードとステータスコードを返す
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * パラメータチェック失敗
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * パラメータチェック失敗、カスタマイズエラーメッセージを返す
     * @param message エラーメッセージ
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 認証失敗
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * アクセス権限がない
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
