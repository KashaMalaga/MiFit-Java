package cn.com.smartdevices.bracelet.shoes.data;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.shoes.model.a;
import cn.com.smartdevices.bracelet.shoes.model.d;

public class c {
    public static a a(String str, int i, cn.com.smartdevices.bracelet.shoes.model.c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            throw new IllegalArgumentException();
        } else if (str.startsWith(d.k, 0)) {
            a dVar = new d(cVar.b(), cVar.d(), cVar.a(), cVar.c());
            dVar.e(i);
            return dVar;
        } else {
            throw new IllegalArgumentException("Unsupported brand");
        }
    }
}
