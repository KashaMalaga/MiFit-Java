package cn.com.smartdevices.bracelet.tag.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.HandlerThread;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.c.a;
import cn.com.smartdevices.bracelet.c.e;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.lab.b.b;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.bt.d.f;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.profile.a.j;
import com.xiaomi.hm.health.bt.profile.a.o;
import com.xiaomi.hm.health.bt.profile.c.d;
import com.xiaomi.hm.health.bt.profile.c.g;
import com.xiaomi.hm.health.bt.profile.c.h;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.r;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class c extends HandlerThread implements f, com.xiaomi.hm.health.bt.profile.c.f {
    private static final int A = 4102;
    private static final int B = 4104;
    public static final String a = "BraceletManager";
    public static final b[] b = new b[]{new b(r.action_sleep, k.ic_sleep, k.ic_sleep_big, Friend.f), new b(r.action_bath, k.ic_bath, k.ic_bath_big, "bath"), new b(r.action_brush_tooth, k.ic_brush_tooth, k.ic_brush_tooth_big, "tooth"), new b(r.action_run, k.ic_run, k.ic_run_big, NativeInterface.RUN), new b(r.action_bike, k.ic_bike, k.ic_bike_big, "bike"), new b(r.action_walk, k.ic_walk, k.ic_walk_big, "walk"), new b(r.action_badminton, k.ic_badminton, k.ic_badminton_big, "badminton"), new b(r.action_basketball, k.ic_basketball, k.ic_basketball_big, "basketball"), new b(r.action_pingpong, k.ic_pingpong, k.ic_pingpong_big, "pingpong"), new b(r.action_sit, k.ic_sit, k.ic_sit_big, "sit"), new b(r.action_stand, k.ic_stand, k.ic_stand_big, "stand"), new b(r.action_bus, k.ic_bus, k.ic_bus_big, "bus")};
    private static final String c = "tag";
    private static final String d = "tag_record";
    private static final int w = 4097;
    private static final int x = 4098;
    private static final int y = 4099;
    private static final int z = 4101;
    private final Context e;
    private f f;
    private File g;
    private cn.com.smartdevices.bracelet.c.c h;
    private a i;
    private j j;
    private int k = -1;
    private i l;
    private boolean m = false;
    private String n = null;
    private d o = null;
    private com.xiaomi.hm.health.bt.profile.b.j p = null;
    private final List<Integer> q = new ArrayList();
    private SharedPreferences r = null;
    private final List<Short> s = new ArrayList();
    private LoginData t = null;
    private String u = null;
    private o v = null;

    public c(Context context, String str) {
        boolean z = false;
        super(a);
        this.e = context;
        this.j = com.xiaomi.hm.health.bt.bleservice.a.a();
        this.u = str;
        this.t = cn.com.smartdevices.bracelet.e.a.f(context);
        this.r = context.getSharedPreferences(d, 0);
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = new File(Environment.getExternalStorageDirectory(), "Android/data/" + context.getPackageName() + "/");
            }
            this.g = new File(externalCacheDir, c);
            z = !this.g.exists() ? this.g.mkdirs() : true;
        }
        if (z) {
            this.h = new cn.com.smartdevices.bracelet.c.c(this.g.toString(), e.ACCELERATION, true);
            this.i = new a(this.g.toString());
        }
    }

    private void a(a aVar) {
        C0596r.b(a, "appendRecord|historyItem:" + aVar);
        try {
            FileWriter fileWriter = new FileWriter(new File(this.g, d), true);
            fileWriter.append(aVar.toString() + "\n");
            fileWriter.flush();
            fileWriter.close();
            a(aVar.b, a(aVar.b) + 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void a(boolean z) {
        C0596r.b(a, "clearDirtyData|exitWithException:" + z);
        this.s.clear();
        File d = this.h.d();
        if (d != null && d.exists() && z) {
            d.delete();
        }
    }

    private void b(String str) {
        g gVar = new g(str);
        gVar.a(true).a(com.xiaomi.hm.health.bt.b.c.SHOES).a((com.xiaomi.hm.health.bt.profile.c.f) this).a(1, 60000);
        this.p = (com.xiaomi.hm.health.bt.profile.b.j) this.o.a(this.e, gVar);
    }

    private void c(int i) {
        C0596r.b(a, "sendCommand|command:" + i);
        if (this.f == null) {
            this.q.add(Integer.valueOf(i));
        } else {
            this.f.sendEmptyMessage(i);
        }
    }

    private void j() {
        k();
        if (this.m) {
            this.o = d.a();
        } else {
            this.v = new o(com.xiaomi.hm.health.bt.bleservice.a.a());
        }
    }

    private void k() {
        cn.com.smartdevices.bracelet.shoes.model.a e = t.e(this.e);
        if (e != null && e.t()) {
            this.m = true;
            this.n = e.j();
        }
    }

    private void l() {
        C0596r.b(a, "enableGetSensorData");
        if (this.p != null) {
            this.p.a((f) this);
        } else if (this.v != null) {
            this.v.a(true, (f) this);
        }
    }

    private void m() {
        if (this.p != null) {
            this.p.d();
        } else if (this.v != null) {
            this.v.a(false, (f) this);
        }
    }

    private void n() {
        C0596r.b(a, "stopWithException");
        if (this.p != null) {
            this.p.d();
        } else if (this.j != null) {
            this.j.c(false);
        }
        if (this.p == null && this.j == null) {
            b(0);
        } else if (this.p.f() || this.j.u()) {
            b(4);
        } else {
            b(0);
        }
    }

    private void o() {
        C0596r.b(a, "connectDevice");
        if (this.m && this.p == null) {
            b(this.n);
        } else if (this.j != null) {
            C0596r.b(a, "mProfile is not null");
            com.xiaomi.hm.health.bt.bleservice.a.a(this.j.f(), true, Utils.p());
        } else {
            C0596r.b(a, "mProfile is not null");
            b(0);
        }
    }

    private void p() {
        if (this.p != null && this.o != null) {
            this.o.a(this.p);
        }
    }

    public int a() {
        return this.k;
    }

    public int a(String str) {
        return this.r.getInt(str + "_count", 0);
    }

    public void a(int i) {
        if (i == 1) {
            b(4);
        } else if (i == 0) {
            String str = (System.currentTimeMillis() / 1000) + com.xiaomi.e.a.f;
            C0596r.b(a, "timestamp : " + str);
            this.h.a(this.t == null ? Constants.VIA_RESULT_SUCCESS : this.t.uid + com.xiaomi.e.a.f, this.u, com.xiaomi.e.a.f, str);
            b(3);
        } else if (i == 2) {
            b(5);
        } else if (i == 3) {
            b(0);
        }
    }

    public void a(g gVar) {
        C0596r.b(a, "uploadUserData|observer:" + gVar);
        try {
            if (!cn.com.smartdevices.bracelet.lab.b.c.f(this.e)) {
                C0596r.b(a, "current network is not wifi");
                if (gVar != null) {
                    gVar.a("\u5f53\u524d\u7f51\u7edc\u4e0d\u662fwifi\uff0c\u6682\u505c\u4e0a\u4f20");
                }
            } else if (this.k == 3) {
                C0596r.b(a, "not allowed to upload during tagging");
                if (gVar != null) {
                    gVar.a("not allowed to upload during tagging");
                }
            } else if (this.i != null) {
                List<File> a = this.i.a();
                if (a != null && a.size() != 0) {
                    if (gVar != null) {
                        gVar.a((List) a);
                    }
                    for (File file : a) {
                        String name = file.getName();
                        name = name.substring(0, name.indexOf(46));
                        String[] split = name.split("_");
                        if (split.length == 5) {
                            String str = split[3];
                            String str2 = split[4];
                            File file2 = new File(this.g, name + ".sbin");
                            l.a(this.t, file, str, str2, b.b(file), new d(this, gVar, file, file2));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(i iVar) {
        this.l = iVar;
    }

    public void a(HwConnStatus hwConnStatus) {
        int i;
        C0596r.b(a, "onConnectStatusChanged");
        C0596r.b(a, hwConnStatus == null ? "null" : hwConnStatus.toString());
        if (hwConnStatus == null || hwConnStatus.k()) {
            i = 2;
            this.j = com.xiaomi.hm.health.bt.bleservice.a.a();
        } else {
            i = (hwConnStatus.g() || hwConnStatus.e()) ? 1 : 0;
        }
        b(i);
    }

    public void a(h hVar) {
        int i;
        switch (e.a[hVar.ordinal()]) {
            case kankan.wheel.widget.l.a /*1*/:
            case kankan.wheel.widget.a.k /*2*/:
                i = -1;
                break;
            case kankan.wheel.widget.a.l /*3*/:
                i = 2;
                break;
            case kankan.wheel.widget.a.aQ /*4*/:
                i = 1;
                break;
            default:
                i = 0;
                break;
        }
        b(i);
    }

    public void a(String str, int i) {
        Editor edit = this.r.edit();
        edit.putInt(str + "_count", i);
        edit.apply();
    }

    public void a(short s, short s2, short s3) {
        C0596r.b(a, "process|x:" + s + ",y:" + s2 + ",z:" + s3);
        if (this.k == 3) {
            this.s.add(Short.valueOf(s));
            this.s.add(Short.valueOf(s2));
            this.s.add(Short.valueOf(s3));
            if (this.s.size() > com.xiaomi.account.openauth.h.E) {
                C0596r.b(a, "write data " + this.s.size());
                try {
                    this.h.a(this.s);
                    this.s.clear();
                } catch (IOException e) {
                    c((int) A);
                }
            }
        }
    }

    public void b() {
        j();
        o();
        int i = ((this.p == null || !this.p.f()) && (this.j == null || !this.j.u())) ? 0 : 2;
        b(i);
        start();
    }

    public void b(int i) {
        C0596r.b(a, "notifyStatusChanged|mTagStatus:" + this.k + ",status:" + i);
        switch (this.k) {
            case kankan.wheel.widget.a.i /*0*/:
                if (i == 2) {
                    this.k = 6;
                    break;
                }
            case kankan.wheel.widget.a.b.a /*-1*/:
            case kankan.wheel.widget.l.a /*1*/:
            case kankan.wheel.widget.a.k /*2*/:
            case kankan.wheel.widget.a.aQ /*4*/:
            case kankan.wheel.widget.a.X /*5*/:
            case kankan.wheel.widget.a.bt /*6*/:
                this.k = i;
                break;
            case kankan.wheel.widget.a.l /*3*/:
                if (i != 2 && i != 3 && i != 6) {
                    if (i != 5) {
                        a(true);
                        if (!this.j.u()) {
                            this.k = 0;
                            break;
                        } else {
                            this.k = 4;
                            break;
                        }
                    }
                    try {
                        this.h.a(this.s);
                        this.h.h();
                        this.s.clear();
                        i();
                        a(new a(this.u, System.currentTimeMillis()));
                        this.k = 2;
                        break;
                    } catch (IOException e) {
                        a(true);
                        if (!this.j.u()) {
                            this.k = 0;
                            break;
                        } else {
                            this.k = 4;
                            break;
                        }
                    }
                }
                this.k = 3;
                break;
                break;
        }
        if (this.l != null) {
            this.l.b(this.k);
        }
    }

    public void c() {
        c((int) y);
        p();
    }

    public List<a> d() {
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        List arrayList = new ArrayList();
        File file = new File(this.g, d);
        if (file.exists()) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String readLine;
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String[] split = readLine.split(" ");
                            if (split.length != 2) {
                                continue;
                            } else {
                                arrayList.add(new a(split[0], Long.parseLong(split[1])));
                                continue;
                            }
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    } catch (IOException e4) {
                        e2 = e4;
                    }
                } while (readLine != null);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e22) {
                        C0596r.a(a, e22.getMessage());
                    }
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                bufferedReader = null;
                try {
                    C0596r.a(a, e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e222) {
                            C0596r.a(a, e222.getMessage());
                        }
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2222) {
                            C0596r.a(a, e2222.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e2222 = e6;
                bufferedReader = null;
                C0596r.a(a, e2222.getMessage());
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e22222) {
                        C0596r.a(a, e22222.getMessage());
                    }
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
        return arrayList;
    }

    public void e() {
        C0596r.b(a, "abortRecord");
        c((int) B);
        a(true);
        if (this.p != null) {
            this.p.d();
        } else if (this.j != null) {
            this.j.c(false);
        }
    }

    public void f() {
        C0596r.b(a, "beginDataTransfer");
        c((int) w);
    }

    public void g() {
        C0596r.b(a, "stopDataTransfer");
        c((int) x);
    }

    public void h() {
        C0596r.b(a, "connect");
        c((int) z);
    }

    public void i() {
        a(null);
    }

    protected void onLooperPrepared() {
        this.f = new f(this);
        if (this.q.size() > 0) {
            for (Integer intValue : this.q) {
                this.f.sendMessage(this.f.obtainMessage(intValue.intValue()));
            }
        }
    }

    public boolean quit() {
        boolean z = false;
        C0596r.b(a, "quit");
        if (this.p != null) {
            this.p.d();
        } else if (this.j != null) {
            this.j.c(false);
        }
        if (this.k == 3) {
            z = true;
        }
        a(z);
        return super.quit();
    }
}
