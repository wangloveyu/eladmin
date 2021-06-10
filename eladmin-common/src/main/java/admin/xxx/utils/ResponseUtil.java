package admin.xxx.utils;

import admin.xxx.base.BaseResponse;

public class ResponseUtil {

    public static BaseResponse getResponse(String code ,String msg, Object data){
        BaseResponse response = new BaseResponse();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

}
