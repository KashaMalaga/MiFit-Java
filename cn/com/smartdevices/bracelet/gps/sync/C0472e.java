package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import android.util.Base64;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.n;
import cn.com.smartdevices.bracelet.gps.services.C0454m;
import cn.com.smartdevices.bracelet.gps.services.C0466z;
import cn.com.smartdevices.bracelet.gps.services.O;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class C0472e {
    C0472e() {
    }

    static C0471d a(int i, List<c> list) {
        int i2;
        C0471d c0471d = new C0471d();
        int a = C0466z.a(i);
        byte[] bArr = i < 60 ? new byte[(i * 64)] : new byte[3840];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            Object obj;
            if (i3 <= 0 || i < 60 || i3 % 60 != 0) {
                obj = r1;
                i2 = i4;
            } else {
                i4++;
                c0471d.a.put(new n((byte[]) r1).c());
                if (i4 + 1 >= a) {
                    obj = new byte[((i - i3) * 64)];
                    i2 = i4;
                } else {
                    obj = new byte[3840];
                    i2 = i4;
                }
            }
            Object a2 = C0472e.a((c) list.get(i3));
            System.arraycopy(a2, 0, r2, (i3 % 60) * 64, a2.length);
            i4 = i3 + 1;
            if (i4 >= i) {
                break;
            }
            i3 = i4;
            i4 = i2;
            bArr = r2;
        }
        if (i2 < a) {
            c0471d.a.put(new n(r2).c());
            i2++;
        }
        c0471d.b = i2;
        return c0471d;
    }

    static List<HeartRateItem> a(String str) {
        List<HeartRateItem> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(b.a) != 1) {
                return null;
            }
            JSONArray jSONArray = jSONObject.getJSONArray(b.b);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                jSONObject = jSONArray.getJSONObject(i);
                byte[] decode = Base64.decode(jSONObject.getString(O.j), 2);
                if (decode != null && decode.length > 0) {
                    long j = jSONObject.getLong(g.f);
                    for (int i2 = 0; i2 < decode.length; i2++) {
                        if (decode[i2] != (byte) 0) {
                            HeartRateItem heartRateItem = new HeartRateItem();
                            heartRateItem.type = 1;
                            heartRateItem.time = ((long) i2) + j;
                            heartRateItem.hr = decode[i2] & HeartRateInfo.HR_EMPTY_VALUE;
                            arrayList.add(heartRateItem);
                        }
                    }
                }
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    static boolean a(Context context, long j, List<n> list) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (list == null || list.size() <= 0) {
            return true;
        } else {
            boolean z = true;
            for (n d : list) {
                byte[] d2 = d.d();
                int length = d2.length / 64;
                List arrayList = new ArrayList(length);
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    c cVar = new c();
                    cVar.p = cn.com.smartdevices.bracelet.gps.h.b.a(d2, i);
                    i += 8;
                    cVar.q = cn.com.smartdevices.bracelet.gps.h.b.a(d2, i);
                    i += 8;
                    cVar.o = cn.com.smartdevices.bracelet.gps.h.b.a(d2, i);
                    i += 8;
                    cVar.r = cn.com.smartdevices.bracelet.gps.h.b.d(d2, i);
                    i += 8;
                    cVar.t = cn.com.smartdevices.bracelet.gps.h.b.c(d2, i);
                    i += 4;
                    cVar.s = cn.com.smartdevices.bracelet.gps.h.b.b(d2, i);
                    i += 4;
                    cVar.v = cn.com.smartdevices.bracelet.gps.h.b.b(d2, i);
                    i += 4;
                    cVar.u = cn.com.smartdevices.bracelet.gps.h.b.b(d2, i);
                    i += 4;
                    cVar.b(cn.com.smartdevices.bracelet.gps.h.b.c(d2, i));
                    i = (i + 4) + 12;
                    arrayList.add(cVar);
                }
                z = p.a(context, arrayList, j) | z;
            }
            return z;
        }
    }

    static byte[] a(c cVar) {
        byte[] bArr = new byte[64];
        cn.com.smartdevices.bracelet.gps.h.b.a(bArr, cVar.p, 0);
        cn.com.smartdevices.bracelet.gps.h.b.a(bArr, cVar.q, 8);
        cn.com.smartdevices.bracelet.gps.h.b.a(bArr, cVar.o, 16);
        cn.com.smartdevices.bracelet.gps.h.b.a(bArr, cVar.r, 24);
        try {
            JSONObject c = cVar.c();
            cn.com.smartdevices.bracelet.gps.h.b.a(bArr, c.getInt(c.a), 32);
            cn.com.smartdevices.bracelet.gps.h.b.a(bArr, Float.valueOf(c.getString(GroupItemBaseInfo.KEY_START_TIME)).floatValue(), 36);
            cn.com.smartdevices.bracelet.gps.h.b.a(bArr, Float.valueOf(c.getString(c.b)).floatValue(), 40);
            cn.com.smartdevices.bracelet.gps.h.b.a(bArr, Float.valueOf(c.getString(c.d)).floatValue(), 44);
            cn.com.smartdevices.bracelet.gps.h.b.a(bArr, c.getInt(C0454m.c), 48);
        } catch (JSONException e) {
            C0596r.a("Sync", e.getMessage());
        }
        return bArr;
    }
}
