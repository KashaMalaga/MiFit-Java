package cn.com.smartdevices.bracelet.i.a.a;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.i.a.h;
import cn.com.smartdevices.bracelet.j.n;

public class d extends h<String> {
    private Context a;

    public d(Context context) {
        this.a = context;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            failure();
            return;
        }
        n a = n.a(this.a, str);
        if (a.c() || a.a()) {
            success();
            if (a.a()) {
                passon();
                return;
            }
            return;
        }
        failure();
    }

    public /* synthetic */ void check(Object obj) {
        a((String) obj);
    }
}
