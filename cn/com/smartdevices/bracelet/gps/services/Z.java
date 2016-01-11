package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.algorithm.TrackStatistics;
import cn.com.smartdevices.bracelet.gps.f.C;
import cn.com.smartdevices.bracelet.gps.f.g;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.services.a.b;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;
import com.d.a.a.h;
import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Z extends g {
    public c k;
    public c l;
    private OnLocationChangedListener m;
    private cn.com.smartdevices.bracelet.gps.model.g n;
    private cn.com.smartdevices.bracelet.gps.model.g o;

    public Z(Context context, C c, String str) {
        super(context, c);
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.o = new cn.com.smartdevices.bracelet.gps.model.g(true);
        this.n = new cn.com.smartdevices.bracelet.gps.model.g(false);
    }

    private void a(File file, int i) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), h.DEFAULT_CHARSET));
        String str = a.f;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (i3 >= i && readLine != a.f && readLine != "\n" && readLine.length() > 0) {
                    if (readLine.startsWith("Activity")) {
                        bufferedReader.readLine();
                        bufferedReader.readLine();
                        bufferedReader.readLine();
                        this.f.n();
                    } else {
                        String[] split = readLine.split(f.i);
                        c cVar = new c();
                        i2++;
                        cVar.c(i2);
                        cVar.a((long) Double.parseDouble(split[0].trim()));
                        cVar.q = Double.parseDouble(split[1].trim());
                        cVar.p = Double.parseDouble(split[2].trim());
                        cVar.o = Double.parseDouble(split[3].trim());
                        cVar.v = Float.parseFloat(split[4].trim());
                        arrayList.add(cVar);
                        if (i2 == 73) {
                            this.f.a(this.f.d());
                        }
                        List arrayList2 = new ArrayList();
                        this.f.a(cVar, (ArrayList) arrayList2);
                        cn.com.smartdevices.bracelet.gps.model.g gVar = new cn.com.smartdevices.bracelet.gps.model.g(true, false);
                        gVar.f = false;
                        gVar.d = false;
                        a(arrayList2, gVar);
                        arrayList2.clear();
                    }
                }
                i3++;
            } else {
                List i4 = this.f.i();
                cn.com.smartdevices.bracelet.gps.model.g gVar2 = new cn.com.smartdevices.bracelet.gps.model.g(true, true);
                gVar2.f = false;
                gVar2.d = true;
                a(i4, gVar2);
                return;
            }
        }
    }

    private void a(File file, int i, boolean z) {
        boolean z2 = false;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String str = a.f;
        List arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            if (i2 >= i && readLine != a.f && readLine != "\n" && readLine.length() > 0) {
                if (readLine.startsWith("Activity")) {
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                } else {
                    String[] split = readLine.split(f.i);
                    c cVar = new c();
                    cVar.c(0);
                    cVar.a((long) Double.parseDouble(split[0].trim()));
                    cVar.q = Double.parseDouble(split[1].trim());
                    cVar.p = Double.parseDouble(split[2].trim());
                    cVar.o = Double.parseDouble(split[3].trim());
                    cVar.v = Float.parseFloat(split[4].trim());
                    arrayList.add(cVar);
                }
            }
            i2++;
        }
        cn.com.smartdevices.bracelet.gps.model.g gVar = new cn.com.smartdevices.bracelet.gps.model.g(z, true);
        if (!z) {
            z2 = true;
        }
        gVar.f = z2;
        gVar.d = true;
        a(arrayList, gVar);
    }

    public void a(c cVar) {
        if (!(this.m == null || cVar == null)) {
            this.m.onLocationChanged(c.a(cVar));
        }
        super.a(cVar);
        List arrayList = new ArrayList();
        arrayList.add(cVar);
        a(arrayList, this.n);
    }

    public void a(List<c> list, cn.com.smartdevices.bracelet.gps.model.g gVar) {
        if (list != null && list.size() > 0) {
            super.a(list, gVar);
        }
    }

    public void b(int i) {
    }

    public boolean l() {
        try {
            C0596r.e("gpsjava", "cleanStorage-in");
            this.f.h();
            C0596r.e("gpsjava", "cleanStorage-out");
            return true;
        } catch (Exception e) {
            C0596r.e("gpsjava", "service is not ready");
            C0596r.e("gpsjava", "cleanStorage-out");
            return false;
        } catch (Throwable th) {
            C0596r.e("gpsjava", "cleanStorage-out");
            return false;
        }
    }

    public boolean m() {
        try {
            C0596r.e("gpsjava", "end-in");
            this.f.f(0);
            C0596r.e("gpsjava", "end-out");
            return true;
        } catch (Exception e) {
            C0596r.e("gpsjava", "service is not ready");
            C0596r.e("gpsjava", "end-out");
            return false;
        } catch (Throwable th) {
            C0596r.e("gpsjava", "end-out");
            return false;
        }
    }

    public int n() {
        int i = -1;
        try {
            C0596r.e("gpsjava", "getAllFileLength-in");
            i = this.f.l();
            C0596r.e("gpsjava", "getAllFileLength-out");
        } catch (Exception e) {
            C0596r.e("gpsjava", "service is not ready");
            C0596r.e("gpsjava", "getAllFileLength-out");
        } catch (Throwable th) {
            C0596r.e("gpsjava", "getAllFileLength-out");
        }
        return i;
    }

    public TrackStatistics o() {
        TrackStatistics trackStatistics = null;
        k();
        try {
            C0596r.e("gpsjava", "test-in");
            int o = this.f.o();
            if (o >= 0) {
                a(this.f.j(), o, false);
                a(this.f.m(), o, true);
                trackStatistics = this.f.d();
            }
        } catch (Exception e) {
            C0596r.e("gpsjava", e.getMessage());
        }
        return trackStatistics;
    }

    public TrackStatistics p() {
        k();
        try {
            C0596r.e("gpsjava", "test_online-in");
            a(this.f.j(), this.f.o());
            return this.f.d();
        } catch (Exception e) {
            C0596r.e("gpsjava", e.getMessage());
            return null;
        }
    }

    public void start(String str, String str2) {
        if (this.f != null) {
            k();
            this.f.a((b) this, 4);
        }
    }
}
