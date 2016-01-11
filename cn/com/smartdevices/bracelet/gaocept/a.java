package cn.com.smartdevices.bracelet.gaocept;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.c.c;
import cn.com.smartdevices.bracelet.c.e;
import cn.com.smartdevices.bracelet.lab.k;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.d.a.a.h;
import com.xiaomi.channel.b.v;
import com.xiaomi.mipush.sdk.f;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class a {
    private final GaoceptAlgorithm a;
    private final c b;
    private final int c = v.C;
    private final int d = 25;
    private int e = 0;
    private final int[] f = new int[v.C];
    private final int[] g = new int[v.C];
    private final int[] h = new int[v.C];
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private String l = com.xiaomi.e.a.f;

    public a(String str) {
        this.b = new c(str, e.ACCELERATION, false);
        this.a = new GaoceptAlgorithm();
    }

    public int a(boolean z) {
        boolean z2 = true;
        if (this.b.b().exists()) {
            this.b.i();
        }
        if (!this.b.c().exists()) {
            return -1;
        }
        InputStream fileInputStream = new FileInputStream(this.b.c().getAbsolutePath());
        Reader inputStreamReader = new InputStreamReader(fileInputStream, h.DEFAULT_CHARSET);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = com.xiaomi.e.a.f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            } else if (readLine != com.xiaomi.e.a.f) {
                int specifiedAxis;
                if (readLine.startsWith("Activity")) {
                    if (i2 > 0 && i == 0) {
                        C0596r.e("gaocept", "print test feature");
                        this.b.a(this.l + "\n" + this.a.getFeatureString(), i2 > 1, this.b.f());
                    }
                    String[] split = readLine.split("[:/]");
                    C0596r.e("gaocept", "start test activity: " + split[1]);
                    if (split[1].contains("Footwalk")) {
                        i3 = 16;
                        i = 0;
                    } else if (split[1].contains(k.b)) {
                        i = 0;
                        i3 = 2;
                    } else if (split[1].contains("Situp")) {
                        i3 = 4;
                        i = 0;
                    } else if (split[1].contains("Pushup")) {
                        i3 = 8;
                        i = 0;
                    } else if (split[1].contains("DoubleClick")) {
                        i3 = PersonInfo.INCOMING_CALL_DISABLE_BIT;
                        i = 0;
                    } else {
                        boolean z3 = true;
                    }
                    if (i == 0) {
                        this.l = readLine;
                        this.l += "\n" + bufferedReader.readLine();
                        this.l += "\n" + bufferedReader.readLine();
                        bufferedReader.readLine();
                        this.a.initializeSpecifiedSport(i3);
                        specifiedAxis = this.a.getSpecifiedAxis();
                        if (specifiedAxis == 0) {
                            i = true;
                        } else {
                            readLine = this.l + "\nno.\tA\tx\ty\tz\tAk\txk\tyk\tzk\tAa\txa\tya\tza\tvalid";
                            if ((specifiedAxis & 1) > 0) {
                                readLine = readLine + "\tva\tca\tpa\tsa";
                            }
                            if ((specifiedAxis & 2) > 0) {
                                readLine = readLine + "\tvx\tcx\tpx\tsx";
                            }
                            if ((specifiedAxis & 4) > 0) {
                                readLine = readLine + "\tvy\tcy\tpy\tsy";
                            }
                            if ((specifiedAxis & 8) > 0) {
                                readLine = readLine + "\tvz\tcz\tpz\tsz";
                            }
                            this.b.a((readLine + "\tstdevRatio") + "\n", i2 > 0, this.b.e());
                            i2++;
                            C0596r.e("gaocept", "receive test samples");
                        }
                    }
                } else if (i == 0) {
                    String[] split2 = readLine.split("\t");
                    if (split2.length == 3) {
                        specifiedAxis = Integer.parseInt(split2[0]);
                        int parseInt = Integer.parseInt(split2[1]);
                        int parseInt2 = Integer.parseInt(split2[2]);
                        if (specifiedAxis == 4095 && parseInt == 4095 && parseInt2 == 4095) {
                            i = true;
                        } else {
                            this.b.a(this.a.getDebugString(this.a.receive(specifiedAxis, parseInt, parseInt2)), true, this.b.e());
                        }
                    }
                }
            }
        }
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
        C0596r.e("gaocept", "finish test");
        if (i2 > 0 && i == 0) {
            c cVar = this.b;
            String str2 = this.l + "\n" + this.a.getFeatureString();
            if (i2 <= 1) {
                z2 = false;
            }
            cVar.a(str2, z2, this.b.f());
        }
        i = this.a.getTotalMotionCount();
        if (this.a.endToFreeSpaces()) {
            return i;
        }
        C0596r.e("gaocept", "memory leak in C");
        return i;
    }

    public void a() {
        this.b.g();
    }

    public boolean a(int i, int i2, int i3) {
        boolean z = false;
        try {
            if (this.k) {
                this.f[this.e] = i;
                this.g[this.e] = i2;
                this.h[this.e] = i3;
                this.e++;
                if (this.b != null && this.e > 25) {
                    List arrayList = new ArrayList();
                    for (int i4 = 0; i4 < this.e; i4++) {
                        arrayList.add(Short.valueOf((short) this.f[i4]));
                        arrayList.add(Short.valueOf((short) this.g[i4]));
                        arrayList.add(Short.valueOf((short) this.h[i4]));
                    }
                    this.b.a(arrayList);
                    this.e = 0;
                }
                if (!this.j) {
                    z = this.a.receive(i, i2, i3);
                }
                return z;
            }
            throw new Exception("receive sample when there is not sport");
        } catch (Exception e) {
            C0596r.e("gaocept", e.getMessage());
            this.i = true;
        }
    }

    public void b() {
        try {
            C0596r.e("gaocept", "end-in");
            if (this.k) {
                this.b.h();
                return;
            }
            throw new Exception("End a sport when there is no sport");
        } catch (Exception e) {
            C0596r.e("gaocept", e.getMessage());
        } finally {
            this.k = false;
            if (!this.a.endToFreeSpaces()) {
                C0596r.e("gaocept", "memory leak in C");
            }
            C0596r.e("gaocept", "end-out");
        }
    }

    public int c() {
        return this.k ? this.a.getTotalMotionCount() : 0;
    }

    public int d() {
        return this.b.a();
    }

    public String e() {
        return this.b.b().getAbsolutePath();
    }

    public void f() {
        if (this.k) {
            this.a.reset();
        }
    }

    public boolean g() {
        return this.k ? this.a.checkCheat() : false;
    }

    public void h() {
        if (this.k) {
            this.a.zeroClear();
        }
    }

    public boolean i() {
        return this.i;
    }

    public boolean j() {
        return true;
    }

    public void start(String str, String str2, String str3, String str4) {
        try {
            if (this.k) {
                throw new Exception("start a new sport when there is already one");
            }
            C0596r.e("gaocept", "start: " + str);
            this.j = false;
            if (str.contains("Footwalk")) {
                this.a.initializeSpecifiedSport(16);
            } else if (str.contains(k.b)) {
                this.a.initializeSpecifiedSport(2);
            } else if (str.contains("Situp")) {
                this.a.initializeSpecifiedSport(4);
            } else if (str.contains("Pushup")) {
                this.a.initializeSpecifiedSport(8);
            } else if (str.contains("DoubleClick")) {
                this.a.initializeSpecifiedSport(PersonInfo.INCOMING_CALL_DISABLE_BIT);
            } else {
                this.j = true;
            }
            this.i = false;
            this.k = true;
            cn.com.smartdevices.bracelet.lab.a.a.a = false;
            String format = b.c.format(new Date());
            this.l = "Activity Name: " + str + "/" + str4 + "\n" + str2 + f.i + str3 + "\n" + format + "\nx\ty\tz\n";
            this.b.a("userID", str, str4, format);
            C0596r.e("gaocept", "start: out");
        } catch (Exception e) {
            C0596r.e("gaocept", e.getMessage());
            this.k = false;
        }
    }
}
