package cn.com.smartdevices.bracelet.shoes.sync.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.d;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.h;
import cn.com.smartdevices.bracelet.shoes.model.k;
import cn.com.smartdevices.bracelet.shoes.sync.B;
import cn.com.smartdevices.bracelet.shoes.sync.c.b;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.SportDay;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;

public class m {
    public static final int a = 0;
    public static final int b = -1;
    private ArrayList<h> c = null;
    private int d = b;
    private long e = 0;
    private String f = a.f;

    public m(String str) {
        this.f = str;
        this.c = new ArrayList();
    }

    public static boolean a(long j) {
        return j != -1;
    }

    public ArrayList<h> a() {
        return this.c;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length > 0) {
            this.c.ensureCapacity(length);
            String str = a.f;
            String str2 = a.f;
            byte[] bArr = null;
            int i = b;
            String str3 = a.f;
            String str4 = a.f;
            int i2 = a;
            while (i2 < length) {
                byte[] bArr2;
                String str5;
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                int i3 = !jSONObject.isNull(com.xiaomi.channel.relationservice.data.a.h) ? jSONObject.getInt(com.xiaomi.channel.relationservice.data.a.h) : i;
                if (i3 != d.a) {
                    C0596r.d(B.a, "Skip wrong server type:" + i3);
                    bArr2 = bArr;
                    str5 = str2;
                    str2 = str;
                } else {
                    String string = !jSONObject.isNull(g.t) ? jSONObject.getString(g.t) : str3;
                    if (TextUtils.isEmpty(string) || !(TextUtils.isEmpty(this.f) || this.f.equals(string))) {
                        C0596r.d(B.a, "Skip wrong server deviceId:" + string + ",targetDeviceId:" + this.f);
                        str3 = string;
                        bArr2 = bArr;
                        str5 = str2;
                        str2 = str;
                    } else {
                        if (!jSONObject.isNull(g.a)) {
                            str2 = jSONObject.getString(g.a);
                        }
                        if (TextUtils.isEmpty(str2)) {
                            C0596r.d(B.a, "Skip wrong server date:" + str2);
                            str3 = string;
                            bArr2 = bArr;
                            str5 = str2;
                            str2 = str;
                        } else {
                            String a;
                            CharSequence a2 = cn.com.smartdevices.bracelet.shoes.sync.c.d.a(str2);
                            if (TextUtils.isEmpty(a2) && cn.com.smartdevices.bracelet.shoes.sync.c.d.b(str2)) {
                                a = b.a(str2);
                            } else {
                                CharSequence charSequence = a2;
                            }
                            if (TextUtils.isEmpty(a)) {
                                C0596r.d(B.a, "Skip wrong server convertedDate:" + a + ",date:" + str2);
                                str3 = string;
                                bArr2 = bArr;
                                str5 = str2;
                                str2 = str;
                            } else {
                                if (!jSONObject.isNull(SocialConstants.PARAM_SUMMARY)) {
                                    str = jSONObject.getString(SocialConstants.PARAM_SUMMARY);
                                }
                                if (!jSONObject.isNull(com.xiaomi.channel.gamesdk.b.b)) {
                                    try {
                                        bArr = Base64.decode(jSONObject.getString(com.xiaomi.channel.gamesdk.b.b), 2);
                                    } catch (IllegalArgumentException e) {
                                        C0596r.d(B.a, e.getMessage());
                                    }
                                }
                                if (!jSONObject.isNull(g.p)) {
                                    str4 = jSONObject.getString(g.p);
                                }
                                String a3 = cn.com.smartdevices.bracelet.shoes.sync.c.a.a(string);
                                if (cn.com.smartdevices.bracelet.shoes.sync.c.a.b(a3)) {
                                    boolean z = bArr != null;
                                    h hVar = new h(new c(a3, str4, string), a, i3, z);
                                    hVar.a(str);
                                    if (z) {
                                        hVar.a(bArr);
                                    }
                                    hVar.l(k.STATE_SYNCED_FROM_SERVER.a());
                                    this.c.add(hVar);
                                    str3 = string;
                                    bArr2 = bArr;
                                    str5 = str2;
                                    str2 = str;
                                } else {
                                    C0596r.d(B.a, "Failed to convert deviceid = " + string + ",mac = " + a3);
                                    str3 = string;
                                    bArr2 = bArr;
                                    str5 = str2;
                                    str2 = str;
                                }
                            }
                        }
                    }
                }
                i2++;
                str = str2;
                str2 = str5;
                bArr = bArr2;
                i = i3;
            }
        }
    }

    public long b() {
        return this.e;
    }

    public void b(long j) {
        this.e = j;
        if (a(j)) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(1000 * j);
            C0596r.e(B.a, "nextToDateTimestamp = " + j + ",date = " + new SportDay(instance).getKey());
            return;
        }
        C0596r.a(B.a, "No more data in server");
    }

    public int c() {
        return this.d;
    }
}
