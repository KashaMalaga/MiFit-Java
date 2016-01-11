package cn.com.smartdevices.bracelet.c;

import android.annotation.SuppressLint;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.services.O;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.xiaomi.account.openauth.h;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

@SuppressLint({"Assert"})
public class c {
    static final /* synthetic */ boolean l = (!c.class.desiredAssertionStatus());
    protected final File a;
    protected final File b;
    protected File c;
    protected final File d;
    protected final File e;
    protected final File f;
    protected final String g;
    protected String h;
    protected boolean i;
    protected final boolean j;
    protected final e k;

    public c(String str, e eVar, boolean z) {
        this.a = new File(str);
        if (!this.a.exists()) {
            this.a.mkdir();
        }
        this.k = eVar;
        switch (d.a[eVar.ordinal()]) {
            case l.a /*1*/:
                this.g = "acc";
                break;
            case a.k /*2*/:
                this.g = GeocodeSearch.GPS;
                break;
            case a.l /*3*/:
                this.g = O.j;
                break;
            default:
                this.g = h.P;
                break;
        }
        this.b = new File(this.a.getAbsolutePath(), this.g + "_cs_all.bin");
        this.c = new File(this.a.getAbsolutePath(), this.g + "_cs_temp.bin");
        this.d = new File(this.a.getAbsolutePath(), this.g + "_cs_all.txt");
        this.e = new File(this.a.getAbsolutePath(), this.g + "_cs_test.txt");
        this.f = new File(this.a.getAbsolutePath(), this.g + "_cs_feature.txt");
        this.j = z;
    }

    public int a() {
        if (this.b.exists()) {
            FileInputStream fileInputStream = new FileInputStream(this.b);
            int available = fileInputStream.available();
            fileInputStream.read(new byte[available]);
            fileInputStream.close();
            return available;
        }
        throw new FileNotFoundException(this.b.getAbsolutePath());
    }

    public void a(String str, String str2, String str3, String str4) {
        this.h = "Activity Name: " + str2 + "/" + str3 + "\n" + "UserID: " + str + "\n" + "StartTime: " + str4 + "\n";
        if (this.k == e.ACCELERATION) {
            this.h += "x\ty\tz\n";
        } else if (this.k == e.GPS) {
            this.h += "TimeStamp, Longitude, Latitude, Altitude, Accuracy\n";
        }
        if (this.j) {
            this.c = new File(this.a.getAbsolutePath(), this.g + "_cs_" + str + "_" + str2 + "_" + str4 + ".sbin");
        }
        this.i = false;
    }

    public void a(String str, boolean z) {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(d(), z));
        dataOutputStream.writeUTF(str);
        dataOutputStream.flush();
        dataOutputStream.close();
        C0596r.b(getClass().getSimpleName(), "[" + str + "] has been successfully written for TAG");
    }

    public void a(String str, boolean z, File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file, z);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public void a(List list) {
        C0596r.b(getClass().getSimpleName(), "Writing TAG data to sbin, with header added?[" + this.h + "]");
        if (!this.i) {
            a(this.h, false);
            this.i = true;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(d(), true));
        if (l || list.size() > 0) {
            switch (d.a[this.k.ordinal()]) {
                case l.a /*1*/:
                    if (!(l || list.size() % 3 == 0)) {
                        throw new AssertionError();
                    }
                case a.k /*2*/:
                    if (!(l || list.size() % 5 == 0)) {
                        throw new AssertionError();
                    }
            }
            for (int i = 0; i < list.size(); i++) {
                switch (d.a[this.k.ordinal()]) {
                    case l.a /*1*/:
                        dataOutputStream.writeShort(((Short) list.get(i)).shortValue());
                        break;
                    case a.k /*2*/:
                        int i2 = i % 5;
                        if (i2 != 0) {
                            if (i2 != 4) {
                                dataOutputStream.writeDouble(((Double) list.get(i)).doubleValue());
                                break;
                            } else {
                                dataOutputStream.writeFloat(((Float) list.get(i)).floatValue());
                                break;
                            }
                        }
                        dataOutputStream.writeLong(((Long) list.get(i)).longValue());
                        break;
                    default:
                        break;
                }
            }
            dataOutputStream.flush();
            dataOutputStream.close();
            return;
        }
        throw new AssertionError();
    }

    public void a(boolean z) {
        this.i = z;
    }

    public File b() {
        return this.b;
    }

    public File c() {
        return this.d;
    }

    public File d() {
        return this.c;
    }

    public File e() {
        return this.e;
    }

    public File f() {
        return this.f;
    }

    public void g() {
        if (this.b.exists()) {
            this.b.delete();
        }
        if (this.d.exists()) {
            this.d.delete();
        }
        if (this.c.exists()) {
            this.c.delete();
        }
        if (this.e.exists()) {
            this.e.delete();
        }
        if (this.f.exists()) {
            this.f.delete();
        }
    }

    public void h() {
        if (this.k == e.ACCELERATION) {
            List arrayList = new ArrayList();
            arrayList.add(Short.valueOf((short) 4095));
            arrayList.add(Short.valueOf((short) 4095));
            arrayList.add(Short.valueOf((short) 4095));
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            arrayList.add(Short.valueOf((short) (currentTimeMillis & 4095)));
            currentTimeMillis >>= 12;
            arrayList.add(Short.valueOf((short) (currentTimeMillis & 4095)));
            arrayList.add(Short.valueOf((short) ((currentTimeMillis >> 12) & 4095)));
            a(arrayList);
        }
        if (!this.j) {
            FileInputStream fileInputStream = new FileInputStream(this.c);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.b, true));
            dataOutputStream.write(bArr);
            switch (d.a[this.k.ordinal()]) {
                case l.a /*1*/:
                    dataOutputStream.writeShort(-32768);
                    break;
                case a.k /*2*/:
                    dataOutputStream.writeLong(-1);
                    break;
            }
            dataOutputStream.flush();
            dataOutputStream.close();
        }
    }

    public File i() {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.b));
        FileOutputStream fileOutputStream = new FileOutputStream(this.d);
        Object obj = 1;
        while (dataInputStream.available() >= 6) {
            if (obj == null) {
                switch (d.a[this.k.ordinal()]) {
                    case l.a /*1*/:
                        short readShort = dataInputStream.readShort();
                        if (readShort != Short.MIN_VALUE) {
                            short readShort2 = dataInputStream.readShort();
                            fileOutputStream.write((readShort + "\t" + readShort2 + "\t" + dataInputStream.readShort() + "\n").getBytes());
                            break;
                        }
                        fileOutputStream.write("\n".getBytes());
                        obj = 1;
                        break;
                    case a.k /*2*/:
                        try {
                            long readLong = dataInputStream.readLong();
                            if (readLong != -1) {
                                double readDouble = dataInputStream.readDouble();
                                double readDouble2 = dataInputStream.readDouble();
                                double readDouble3 = dataInputStream.readDouble();
                                fileOutputStream.write((readLong + ", " + readDouble + ", " + readDouble2 + ", " + readDouble3 + ", " + dataInputStream.readFloat() + "\n").getBytes());
                                break;
                            }
                            fileOutputStream.write("\n".getBytes());
                            obj = 1;
                            break;
                        } catch (IOException e) {
                            throw e;
                        }
                    default:
                        break;
                }
            }
            fileOutputStream.write(dataInputStream.readUTF().getBytes());
            obj = null;
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        dataInputStream.close();
        return this.d;
    }
}
