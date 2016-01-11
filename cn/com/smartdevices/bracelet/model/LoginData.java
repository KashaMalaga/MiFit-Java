package cn.com.smartdevices.bracelet.model;

import android.support.v7.widget.af;
import android.text.TextUtils;

public class LoginData {
    public final int LOGIN_DATA_INVALID = af.a;
    public String security = null;
    public long uid = -1;

    public boolean isValid() {
        return this.uid > 0 && !TextUtils.isEmpty(this.security);
    }

    public String toString() {
        return "LoginData: uid:" + this.uid + ", security:" + this.security;
    }
}
