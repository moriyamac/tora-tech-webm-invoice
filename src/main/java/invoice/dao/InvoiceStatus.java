package invoice.dao;

import java.util.HashMap;

public enum InvoiceStatus {

    /** 申請待ち */
    PENDING("10","申請待ち"),
    /** 申請済 */
    COMPLITED("20", "申請済");

    private String status;
    private String code;

    private InvoiceStatus(final String status, final String code) {
        this.status = status;
        this.code = code;
    }

    private static final HashMap<String, String> codeMap = new HashMap<>();

    static {
        for (InvoiceStatus entry : values()) {
            codeMap.put(entry.getStatus(), entry.getCode());
        }
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    /**
     * ステータスに対応するコードを返す。
     *
     * @param status ステータス
     * @return コード
     */
    public static String ofCode(final String status) {
        return codeMap.get(status);
    }
}