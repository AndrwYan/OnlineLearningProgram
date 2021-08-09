package com.andrew.server.dto;


public class ResponseDto<T> {
    /*
    *
    * 业务上的成功还是失败
    *状态标识
    *
    * */
    private boolean success=true;

    /*
    * 返回码
    *
    * */
    private String code;

    /*
    *
    * 返回信息message
    *
    **/

    private String message;
    /*
    *
    * 返回泛型信息，自定义的类型
    * */
    private T content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "ResponseDto{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
