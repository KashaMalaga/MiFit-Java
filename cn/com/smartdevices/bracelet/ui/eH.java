package cn.com.smartdevices.bracelet.ui;

import android.text.TextUtils;

public class eH {
    private String a = null;

    public eH(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof eH)) {
            return false;
        }
        return !TextUtils.isEmpty(this.a) ? this.a.equals(((eH) obj).a()) : false;
    }
}
