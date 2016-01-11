package cn.com.smartdevices.bracelet.shoes.model;

import android.util.Base64;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.d;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StepsInfo;

public class h {
    private static final String g = "SDM";
    private static final int h = -1;
    private String a = a.f;
    private int b = d.a;
    private DateRawData c = null;
    private i d = null;
    private int e = k.SYNC_STATE_DEFAULT.a();
    private c f = null;
    private long i = -1;

    public h(c cVar, String str, int i, boolean z) {
        this.b = i;
        this.f = cVar;
        this.a = str;
        this.d = new i();
        if (z) {
            this.c = new DateRawData(SportDay.fromString(this.a));
        }
    }

    public h(c cVar, String str, boolean z) {
        this.f = cVar;
        this.a = str;
        this.d = new i();
        if (z) {
            this.c = new DateRawData(SportDay.fromString(this.a));
        }
    }

    public boolean A() {
        return this.i == -1;
    }

    public boolean B() {
        StepsInfo stepsInfo = this.c.getStepsInfo();
        if (stepsInfo == null) {
            return false;
        }
        this.d.h(stepsInfo.getRunTimeCount());
        this.d.j(stepsInfo.getStepsTimeCount());
        this.d.i(stepsInfo.getStepsCount());
        this.d.c(stepsInfo.getforefootSteps());
        this.d.f(stepsInfo.getRunDistance());
        this.d.b(stepsInfo.getDistance());
        this.d.e(stepsInfo.getRunCalories());
        this.d.a(stepsInfo.getCalories());
        C0596r.e(g, "updateSummary = " + this.d.toString());
        return true;
    }

    public com.xiaomi.hm.health.bt.model.d a(int i) {
        if (this.c != null) {
            return this.c.getMinuteData(i);
        }
        throw new IllegalStateException("DateDataBinary is null");
    }

    public String a() {
        return this.d.a().toString();
    }

    public void a(byte[] bArr) {
        if (this.c == null) {
            throw new IllegalStateException();
        }
        this.c.setRawData(bArr);
    }

    public boolean a(int i, com.xiaomi.hm.health.bt.model.d dVar) {
        if (this.c != null) {
            return this.c.setMinuteData(i, dVar);
        }
        throw new IllegalStateException();
    }

    public boolean a(h hVar) {
        boolean z = false;
        if (hVar == null || this.c == null) {
            C0596r.d(g, "mergeRawData srcdatedata is null || mdatedatabinary is null");
        } else {
            DateRawData dateRawData = hVar.c;
            if (dateRawData == null) {
                C0596r.d(g, "mergeRawData srcdatedata mdatedatabinary is null");
            } else {
                int dataSize = dateRawData.getDataSize();
                for (int i = 0; i < dataSize; i++) {
                    if (this.c.getMinuteData(i) == null) {
                        com.xiaomi.hm.health.bt.model.d minuteData = dateRawData.getMinuteData(i);
                        if (minuteData != null) {
                            this.c.setMinuteData(i, minuteData);
                        }
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public boolean a(String str) {
        return this.d.a(str);
    }

    public int b() {
        return this.d.b();
    }

    public String b(int i) {
        return null;
    }

    public DateRawData c() {
        return this.c;
    }

    public void c(int i) {
        this.d.a(i);
    }

    public int d() {
        return this.c == null ? 0 : this.c.getDataSize();
    }

    public void d(int i) {
        this.d.b(i);
    }

    public String e() {
        return this.a;
    }

    public void e(int i) {
        this.d.d(i);
    }

    public String f() {
        if (this.f != null) {
            return this.f.a();
        }
        throw new IllegalStateException("Indentity is null");
    }

    public void f(int i) {
        this.i = (long) i;
    }

    public int g() {
        return this.d.c();
    }

    public void g(int i) {
        this.d.e(i);
    }

    public String h() {
        return this.c == null ? a.f : Base64.encodeToString(this.c.getBinaryData(), 2);
    }

    public void h(int i) {
        this.d.f(i);
    }

    public int i() {
        return this.d.d();
    }

    public void i(int i) {
        this.d.g(i);
    }

    public long j() {
        return this.i;
    }

    public void j(int i) {
        this.d.h(i);
    }

    public c k() {
        return this.f;
    }

    public void k(int i) {
        this.d.i(i);
    }

    public String l() {
        if (this.f != null) {
            return this.f.b();
        }
        throw new IllegalStateException("Indentity is null");
    }

    public void l(int i) {
        this.e = i;
    }

    public void m(int i) {
        this.d.j(i);
    }

    public byte[] m() {
        return this.c == null ? null : this.c.getBinaryData();
    }

    public int n() {
        return this.d.f();
    }

    public int o() {
        return this.d.g();
    }

    public int p() {
        return this.d.h();
    }

    public int q() {
        return this.d.i();
    }

    public String r() {
        if (this.f != null) {
            return this.f.c();
        }
        throw new IllegalStateException("Indentity is null");
    }

    public String s() {
        if (this.f != null) {
            return this.f.d();
        }
        throw new IllegalStateException("Indentity is null");
    }

    public SportDay t() {
        return this.c == null ? SportDay.fromString(this.a) : this.c.getSportDay();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShoesDateData date:").append(this.a).append(",mac:").append(this.f).append(",syncedState:").append(this.e).append(",mId:").append(this.i).append(",summary:").append(this.d.toString());
        return stringBuilder.toString();
    }

    public int u() {
        return this.d.l();
    }

    public StepsInfo v() {
        return this.c == null ? null : this.c.getStepsInfo();
    }

    public i w() {
        return this.d;
    }

    public int x() {
        return this.e;
    }

    public int y() {
        return this.d.n();
    }

    public boolean z() {
        return this.c == null ? false : this.c.isNeedParseData();
    }
}
