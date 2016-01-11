package cn.com.smartdevices.bracelet.shoes.sync.a;

import android.content.Context;
import android.support.v7.widget.af;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.d;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.B;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.d.a.a.O;
import com.d.a.a.S;
import com.d.a.a.h;
import java.net.URLEncoder;
import org.apache.http.Header;

public class a extends e {
    private static final String a = "huami.health.updatedevicedata.json";

    public static b a(Context context, c cVar) {
        if (context == null || cVar == null) {
            throw new IllegalArgumentException();
        }
        b d = b.d(context);
        String str = com.xiaomi.e.a.f;
        Object a = !TextUtils.isEmpty(cVar.a()) ? cVar.a() : cn.com.smartdevices.bracelet.shoes.c.b(context, cVar.b());
        Object d2 = cVar.d();
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(d2)) {
            return null;
        }
        d.j = d2;
        d.b = cVar.b();
        d.h = cn.com.smartdevices.bracelet.shoes.c.a(context, cVar.b());
        d.a = a;
        return d;
    }

    public static void a(Context context, b bVar, int i, h hVar) {
        if (context == null || bVar == null) {
            C0596r.e(B.a, "syncSystemDeviceInfoToServerSynced info is null");
            throw new IllegalArgumentException();
        }
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.a(g.t, bVar.a);
            a.a(g.p, bVar.j);
            a.a(g.q, URLEncoder.encode(bVar.b));
            a.a(f.aa, com.xiaomi.e.a.f + i);
            a.a(f.ab, bVar.d);
            a.a(f.ac, bVar.c);
            a.a(f.ad, bVar.e);
            a.a(f.ae, bVar.f);
            a.a(f.af, bVar.g);
            a.a(f.ag, bVar.h);
            a.a(f.ak, bVar.i);
            String b = cn.com.smartdevices.bracelet.j.h.b(e.a(a), a.c(f.c));
            C0596r.e(B.a, "\n syncSystemDeviceInfoToServerSynced  hm = " + a + ",url = " + b);
            d.b.c(b, a, (S) hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }
}
