package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.h.b;
import cn.com.smartdevices.bracelet.gps.model.k;
import cn.com.smartdevices.bracelet.gps.model.n;
import cn.com.smartdevices.bracelet.gps.services.C0466z;
import cn.com.smartdevices.bracelet.gps.services.O;
import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.gps.services.az;
import com.xiaomi.e.a;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C0481o {
    public static final int a = -1;
    public static final int b = -2;
    public static final int c = 3;

    static n a(C0466z c0466z) {
        int i = 0;
        boolean H = c0466z.H();
        JSONArray a = c0466z.a();
        if (!H) {
            return new n(c0466z.b().toString(), a.toString());
        }
        int length = a.length();
        if (length == 0) {
            return new n(c0466z.b().toString(), a.f);
        }
        try {
            byte[] bArr = new byte[(length * 24)];
            int i2 = 0;
            while (i < length) {
                JSONObject jSONObject = a.getJSONObject(i);
                b.a(bArr, jSONObject.getInt(ay.F), i2);
                i2 += 4;
                b.a(bArr, jSONObject.getInt(ay.b), i2);
                i2 += 4;
                b.a(bArr, Float.valueOf(jSONObject.getString(O.c)).floatValue(), i2);
                i2 += 4;
                b.a(bArr, Float.valueOf(jSONObject.getString(O.b)).floatValue(), i2);
                i2 += 4;
                b.a(bArr, Float.valueOf(jSONObject.getString(az.B)).floatValue(), i2);
                i2 += 4;
                b.a(bArr, jSONObject.getInt(O.j), i2);
                i2 += 4;
                i++;
            }
            return new n(c0466z.b().toString(), bArr);
        } catch (JSONException e) {
            C0596r.e("Sync", e.getMessage());
            return new n(c0466z.b().toString(), a.f);
        }
    }

    static C0482p a(Context context, List<n> list) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        C0482p c0482p = new C0482p(list.size());
        boolean z = true;
        for (n nVar : list) {
            long f = nVar.f();
            int g = nVar.g();
            c0482p.a(f);
            if (String.valueOf(f).equals(nVar.b()) || !nVar.b().contains("-")) {
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(1000 * f);
                nVar.a(new k(instance).b());
            }
            C0466z c0466z = new C0466z(g, f, nVar.b());
            c0466z.a(f, g, nVar.b(), nVar.e());
            if (c0466z.H()) {
                c0466z.a(f, C0481o.a(nVar.d()).toString());
            } else {
                c0466z.a(f, new String(nVar.d()));
            }
            boolean b = p.b(context, c0466z);
            if (b) {
                p.i(context, f, g);
            }
            z = b & z;
        }
        c0482p.a = z;
        return c0482p;
    }

    static JSONArray a(byte[] bArr) {
        int i = 0;
        try {
            int length = bArr.length / 24;
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            while (i < length) {
                int c = b.c(bArr, i2);
                i2 += 4;
                int c2 = b.c(bArr, i2);
                i2 += 4;
                float b = b.b(bArr, i2);
                i2 += 4;
                float b2 = b.b(bArr, i2);
                i2 += 4;
                float b3 = b.b(bArr, i2);
                i2 += 4;
                int c3 = b.c(bArr, i2);
                i2 += 4;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ay.F, c);
                jSONObject.put(ay.b, c2);
                jSONObject.put(O.c, (double) b);
                jSONObject.put(O.b, (double) b2);
                jSONObject.put(az.B, (double) b3);
                jSONObject.put(O.j, c3);
                jSONArray.put(jSONObject);
                i++;
            }
            return jSONArray;
        } catch (Exception e) {
            C0596r.a("Sync", e.getMessage());
            return new JSONArray();
        }
    }
}
