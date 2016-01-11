package cn.com.smartdevices.bracelet.model;

public class ResponseResult<T> {
    private int code;
    private T data;
    private String message;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
