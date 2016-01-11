package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Utils;

public class LuaItem {
    public static final String JSON_ICON_URI = "iconUri";
    public static final String JSON_TXT_COLOR = "txtColor";
    private long expire;
    private String right;
    private String script;
    private String styleJson;
    private String stype;
    private String t1;
    private String t2;

    public long getExpire() {
        return this.expire;
    }

    public String getRight() {
        return this.right;
    }

    public String getScript() {
        return this.script;
    }

    public String getStyleJson() {
        return this.styleJson;
    }

    public String getStype() {
        return this.stype;
    }

    public String getT1() {
        return this.t1;
    }

    public String getT2() {
        return this.t2;
    }

    public void setExpire(long j) {
        this.expire = j;
    }

    public void setRight(String str) {
        this.right = str;
    }

    public void setScript(String str) {
        this.script = str;
    }

    public void setStyleJson(String str) {
        this.styleJson = str;
    }

    public void setStype(String str) {
        this.stype = str;
    }

    public void setT1(String str) {
        this.t1 = str;
    }

    public void setT2(String str) {
        this.t2 = str;
    }

    public String toString() {
        return Utils.c().b((Object) this).toString();
    }
}
