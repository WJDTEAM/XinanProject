package tqm.bianfeng.com.xinanproject.pojo;

/**
 * Created by johe on 2017/4/24.
 *  "success": true,
 "code": null,
 "message": null,
 */

public class ZTResult {
    Boolean  success;
    int code;
    String message;
    ZTData data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ZTData getData() {
        return data;
    }

    public void setData(ZTData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ZTResult{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
