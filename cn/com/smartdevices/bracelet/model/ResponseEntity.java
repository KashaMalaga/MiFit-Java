package cn.com.smartdevices.bracelet.model;

public class ResponseEntity {
    public int code = -1;
    private Object data;
    public String msg;
    public boolean state = true;

    public Object getData() {
        return this.data;
    }

    public void setData(Object obj) {
        this.data = obj;
    }
}
