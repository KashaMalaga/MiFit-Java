package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.h;
import cn.com.smartdevices.bracelet.shoes.sync.b.i;
import cn.com.smartdevices.bracelet.shoes.sync.b.j;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.mipush.sdk.f;
import java.util.List;

class K {
    private K() {
    }

    private static O a(Context context, i iVar, String str, int i) {
        O o = new O();
        if (iVar.o.isValid()) {
            C0641r.a(iVar, str, new N(i, o, iVar, context));
        } else {
            o.a(false);
        }
        return o;
    }

    static O a(Context context, String str, String str2, boolean z, int i, c cVar) {
        int i2 = 1;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        i iVar = new i(context);
        String[] a = a(str, str2);
        iVar.k = a[0];
        iVar.l = a[1];
        if (!z) {
            i2 = 0;
        }
        iVar.e = i2;
        if (cVar != null) {
            if (!TextUtils.isEmpty(cVar.a())) {
                iVar.i = cVar.a();
            } else if (!TextUtils.isEmpty(cVar.b())) {
                iVar.i = cn.com.smartdevices.bracelet.shoes.c.b(context, cVar.b());
            }
            if (!TextUtils.isEmpty(cVar.d())) {
                iVar.g = cVar.d();
            }
        }
        C0596r.e(B.a, "toDate = " + iVar.l + ",fromDate = " + iVar.k + ",type = " + i + ",data ?= " + iVar.e + ",deviceid:" + iVar.i + ",indentity:" + cVar);
        return a(context, iVar, e.a(C0641r.d), i);
    }

    static T a(Context context, int i, c cVar) {
        if (context == null || cVar == null) {
            throw new IllegalArgumentException();
        }
        List<h> b = t.b(context, cVar);
        if (b == null || b.size() == 0) {
            C0596r.e(B.a, "syncDeviceDataToServer no data mac = " + cVar);
            return T.NONE;
        }
        i iVar = new i(context);
        cn.com.smartdevices.bracelet.shoes.sync.b.h hVar = new cn.com.smartdevices.bracelet.shoes.sync.b.h();
        if (!TextUtils.isEmpty(cVar.d())) {
            iVar.g = cVar.d();
        }
        if (!TextUtils.isEmpty(cVar.a())) {
            iVar.i = cVar.a();
        }
        for (h hVar2 : b) {
            if (TextUtils.isEmpty(iVar.i)) {
                if (!TextUtils.isEmpty(hVar2.f())) {
                    iVar.i = hVar2.f();
                } else if (!TextUtils.isEmpty(hVar2.l())) {
                    iVar.i = cn.com.smartdevices.bracelet.shoes.c.b(context, hVar2.l());
                }
            }
            if (TextUtils.isEmpty(iVar.g) && !TextUtils.isEmpty(hVar2.s())) {
                iVar.g = hVar2.s();
            }
            iVar.r = hVar2.e();
            C0596r.e(B.a, "syncDeviceDataToServer devicedId:" + iVar.i + ",date = " + iVar.r + ",uuid:" + cn.com.smartdevices.bracelet.shoes.b.c.h() + ",sn" + iVar.g);
            if (!iVar.o.isValid()) {
                return T.ERROR;
            }
            C0641r.a(iVar, e.a(C0641r.e), hVar2.h(), hVar2.a(), new M(hVar, i, context, cVar, hVar2));
        }
        return hVar.b() ? T.OK : T.ERROR;
    }

    static j a(Context context, String str, String str2, int i, c cVar) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        i iVar = new i(context);
        String[] a = a(str, str2);
        iVar.k = a[0];
        iVar.l = a[1];
        if (cVar != null) {
            if (!TextUtils.isEmpty(cVar.a())) {
                iVar.i = cVar.a();
            } else if (!TextUtils.isEmpty(cVar.b())) {
                iVar.i = cn.com.smartdevices.bracelet.shoes.c.b(context, cVar.b());
            }
            if (!TextUtils.isEmpty(cVar.d())) {
                iVar.g = cVar.d();
            }
        }
        C0596r.e(B.a, "tDate:" + iVar.l + ",fDate:" + iVar.k + ",type:" + i + ",deviceid:" + iVar.i + ",sn" + iVar.g);
        j jVar = new j(iVar.i);
        if (iVar.o.isValid()) {
            C0641r.a(iVar, e.a(C0641r.g), new L(i, jVar, context, cVar));
        } else {
            jVar.a(false);
        }
        return jVar;
    }

    static boolean a(Context context, List<String> list, boolean z, int i, c cVar) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (list.size() <= 0) {
            return true;
        } else {
            i iVar = new i(context);
            StringBuilder stringBuilder = new StringBuilder();
            if (list.size() == 1) {
                iVar.f = (String) list.get(0);
            } else {
                for (String append : list) {
                    stringBuilder.append(append).append(f.i);
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                iVar.f = stringBuilder.toString();
            }
            if (cVar != null) {
                if (!TextUtils.isEmpty(cVar.a())) {
                    iVar.i = cVar.a();
                } else if (!TextUtils.isEmpty(cVar.b())) {
                    iVar.i = cn.com.smartdevices.bracelet.shoes.c.b(context, cVar.b());
                }
                if (!TextUtils.isEmpty(cVar.d())) {
                    iVar.g = cVar.d();
                }
            }
            iVar.e = z ? 1 : 0;
            C0596r.e(B.a, "type:" + i + ",data ?= " + iVar.e + ",deviceId:" + iVar.i + ",dates:" + iVar.f + ",sn" + iVar.g);
            return a(context, iVar, e.a(C0641r.h), i).b();
        }
    }

    private static String[] a(String str, String str2) {
        CharSequence charSequence;
        String str3 = a.f;
        String str4 = a.f;
        if (TextUtils.isEmpty(str2)) {
            str2 = new SportDay().getKey();
        }
        if (TextUtils.isEmpty(str)) {
            Object obj = str3;
        }
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = str2;
        }
        return new String[]{charSequence, str2};
    }
}
