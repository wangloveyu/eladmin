package admin.xxx.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 接口基础响应
 */
public class BaseResponse implements Serializable {

    /**
     * 响应码
     */
    @JsonProperty("code")
    private String code;
    /**
     * 响应码描述
     */
    @JsonProperty("msg")
    private String msg;
    /**
     * 响应数据
     */
    @JsonProperty("data")
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
