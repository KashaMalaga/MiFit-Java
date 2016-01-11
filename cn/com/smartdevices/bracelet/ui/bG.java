package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import com.xiaomi.e.a;

public class bG {
    String a;
    String b;
    String c;

    public bG(Context context, int i, int i2, int i3) {
        this.a = context.getString(i);
        this.b = i2 == 0 ? a.f : context.getString(i2);
        this.c = i3 == 0 ? a.f : context.getString(i3);
    }
}
