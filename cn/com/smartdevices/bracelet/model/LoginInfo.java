package cn.com.smartdevices.bracelet.model;

import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;
import java.io.Serializable;

public class LoginInfo implements Serializable {
    public String access_token = a.f;
    public String aliasNick = a.f;
    public String expiresIn = a.f;
    public String friends = a.f;
    public String mac_algorithm = a.f;
    public String mac_key = a.f;
    public String miliaoIcon = a.f;
    public String miliaoIcon_320 = a.f;
    public String miliaoNick = a.f;
    public String refresh_token;
    public String tokeyType = a.f;
    public long userid;

    public String toString() {
        return "access_token = " + this.access_token + f.i + "\nmac algo = " + this.mac_algorithm + "\nmackey = " + this.mac_key + "\n refresh_token = " + this.refresh_token + "\n expiresIn = " + this.expiresIn;
    }
}
