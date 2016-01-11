package cn.com.smartdevices.bracelet.shoes.model;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.shoes.d;
import com.xiaomi.e.a;
import java.io.Serializable;

public class c implements Serializable {
    private static final long serialVersionUID = 1;
    private String a;
    private String b;
    private String c;
    private String d;
    private final int e;

    public c() {
        this.a = a.f;
        this.b = a.f;
        this.c = a.f;
        this.d = a.f;
        this.e = d.a;
    }

    public c(String str) {
        this(str, a.f, a.f, a.f);
    }

    public c(String str, String str2) {
        this(str, str2, a.f, a.f);
    }

    public c(String str, String str2, String str3) {
        this(str, str2, str3, a.f);
    }

    public c(String str, String str2, String str3, String str4) {
        this.a = a.f;
        this.b = a.f;
        this.c = a.f;
        this.d = a.f;
        this.e = d.a;
        this.b = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = a.f;
        }
        this.c = str2;
        this.a = TextUtils.isEmpty(str3) ? a.f : str3;
        if (TextUtils.isEmpty(str4)) {
            str3 = a.f;
        }
        this.d = str3;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.d = str;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.c;
    }

    public boolean e() {
        return TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof c) || TextUtils.isEmpty(this.b)) {
            return false;
        }
        c cVar = (c) obj;
        return (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(cVar.c)) ? this.b.equals(cVar.b) : this.b.equals(cVar.b) && this.c.equals(cVar.c);
    }

    public boolean f() {
        return TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShoesIdentity mac:").append(this.b).append(",deviceid:").append(this.a).append(",sn:").append(this.c);
        return stringBuilder.toString();
    }
}
