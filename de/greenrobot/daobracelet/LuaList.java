package de.greenrobot.daobracelet;

public class LuaList {
    private String date;
    private String expireTime;
    private Long id;
    private String index;
    private String jsonString;
    private String luaActionScript;
    private String right;
    private String scriptVersion;
    private String start;
    private String stop;
    private String text1;
    private String text2;
    private String time;
    private String type;

    public LuaList(Long l) {
        this.id = l;
    }

    public LuaList(Long l, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.id = l;
        this.date = str;
        this.time = str2;
        this.type = str3;
        this.right = str4;
        this.index = str5;
        this.jsonString = str6;
        this.scriptVersion = str7;
        this.luaActionScript = str8;
        this.text1 = str9;
        this.text2 = str10;
        this.start = str11;
        this.stop = str12;
        this.expireTime = str13;
    }

    public String getDate() {
        return this.date;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public Long getId() {
        return this.id;
    }

    public String getIndex() {
        return this.index;
    }

    public String getJsonString() {
        return this.jsonString;
    }

    public String getLuaActionScript() {
        return this.luaActionScript;
    }

    public String getRight() {
        return this.right;
    }

    public String getScriptVersion() {
        return this.scriptVersion;
    }

    public String getStart() {
        return this.start;
    }

    public String getStop() {
        return this.stop;
    }

    public String getText1() {
        return this.text1;
    }

    public String getText2() {
        return this.text2;
    }

    public String getTime() {
        return this.time;
    }

    public String getType() {
        return this.type;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setExpireTime(String str) {
        this.expireTime = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIndex(String str) {
        this.index = str;
    }

    public void setJsonString(String str) {
        this.jsonString = str;
    }

    public void setLuaActionScript(String str) {
        this.luaActionScript = str;
    }

    public void setRight(String str) {
        this.right = str;
    }

    public void setScriptVersion(String str) {
        this.scriptVersion = str;
    }

    public void setStart(String str) {
        this.start = str;
    }

    public void setStop(String str) {
        this.stop = str;
    }

    public void setText1(String str) {
        this.text1 = str;
    }

    public void setText2(String str) {
        this.text2 = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
