package cn.com.smartdevices.bracelet.model;

import com.xiaomi.e.a;

public class ThirdLoginState {
    public static final int BIND_INVALID = -1;
    public static final int BIND_VALID = 1;
    public static final int UNBIND = 0;
    public String accessToken = a.f;
    public String appId = a.f;
    public int bindState = 0;
    public long expiresIn;
    public String expiresTime = a.f;
    public String nickName = a.f;
    public String refreshToken = a.f;
    public String uid = a.f;

    public ThirdLoginState(String str, String str2) {
        this.uid = str;
        this.accessToken = str2;
    }

    public boolean isSessionValid() {
        if (!(a.f.equals(this.uid) || a.f.equals(this.accessToken))) {
            try {
                if (this.expiresIn > 0) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String toString() {
        return "ThirdLoginState [uid=" + this.uid + ", accessToken=" + this.accessToken + ", expiresTime=" + this.expiresTime + ", refreshToken=" + this.refreshToken + ", expiresIn=" + this.expiresIn + ", nickName=" + this.nickName + ", bindState=" + this.bindState + "]";
    }
}
