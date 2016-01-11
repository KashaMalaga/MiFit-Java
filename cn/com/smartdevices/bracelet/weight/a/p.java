package cn.com.smartdevices.bracelet.weight.a;

import cn.com.smartdevices.bracelet.i.a.a.a;
import cn.com.smartdevices.bracelet.i.a.g;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.model.LoginData;
import com.d.a.a.O;

public class p extends g<String, String> {
    public LoginData a;
    public String b;

    public p(LoginData loginData, String str) {
        this.a = loginData;
        this.b = str;
    }

    public String a(String str) {
        O a = f.a(this.a);
        a.a("jsondata", str);
        a.a(f.aa, 1);
        return new a(this.b).b(a);
    }
}
