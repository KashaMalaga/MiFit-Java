package de.greenrobot.daobracelet;

public class LuaZipFile {
    private String date;
    private Long id;
    private String version;
    private byte[] zipFile;

    public LuaZipFile(Long l) {
        this.id = l;
    }

    public LuaZipFile(Long l, String str, String str2, byte[] bArr) {
        this.id = l;
        this.version = str;
        this.date = str2;
        this.zipFile = bArr;
    }

    public String getDate() {
        return this.date;
    }

    public Long getId() {
        return this.id;
    }

    public String getVersion() {
        return this.version;
    }

    public byte[] getZipFile() {
        return this.zipFile;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setZipFile(byte[] bArr) {
        this.zipFile = bArr;
    }
}
