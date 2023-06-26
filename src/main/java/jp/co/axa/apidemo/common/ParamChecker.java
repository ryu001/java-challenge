package jp.co.axa.apidemo.common;

/**
 * リクエストパラメータチェッカー
 */
public class ParamChecker {
    /**
     * 長さチェック
     * @param target チェック対象
     * @param maxLen 最大長さ
     * @return
     */
    public static boolean lengthCheckErr(String target, int maxLen) {
        if (target.length() > maxLen) return true;
        else return false;
    }
}
