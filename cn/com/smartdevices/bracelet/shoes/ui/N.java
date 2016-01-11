package cn.com.smartdevices.bracelet.shoes.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.shoes.sync.J;
import java.io.File;

public class N {
    private N() {
    }

    public static Drawable a(Context context, e eVar, int i) {
        if (context == null || eVar == null) {
            throw new IllegalArgumentException();
        }
        String str = eVar.m;
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            C0596r.e(N.class.getName(), "localUri is empty");
            J.a(context, eVar);
            return context.getResources().getDrawable(i);
        }
        Drawable createFromPath = Drawable.createFromPath(str);
        if (createFromPath != null) {
            return createFromPath;
        }
        C0596r.e(N.class.getName(), "decoded icon is null");
        J.a(context, eVar);
        return context.getResources().getDrawable(i);
    }
}
