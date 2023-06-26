package jp.co.axa.apidemo.common;

/**
 * APIレスポンスコードインタフェース
 * Created by liu on 2023/6/19.
 */
public interface StatusCode {
    /**
     * レスポンスコード
     */
    long getCode();

    /**
     * レスポンスメッセージ
     */
    String getMessage();
}
