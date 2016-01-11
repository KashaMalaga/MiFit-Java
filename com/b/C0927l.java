package com.b;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.d.a.a.C1012a;
import com.xiaomi.account.openauth.h;
import com.xiaomi.market.sdk.o;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class C0927l {
    private Context a;
    private int b = 0;
    private int c = 0;
    private int d = 0;

    protected C0927l(Context context) {
        this.a = context;
        a(768);
    }

    private static int a(int i, int i2) {
        return i < i2 ? i : i2;
    }

    protected static C0920e a(Location location, C0930o c0930o, int i, byte b, long j, boolean z) {
        C0920e c0920e = new C0920e();
        if (i <= 0 || i > 3 || c0930o == null) {
            return null;
        }
        int i2;
        int i3;
        Object obj = (i == 1 || i == 3) ? 1 : null;
        Object obj2 = (i == 2 || i == 3) ? 1 : null;
        Object bytes = c0930o.p().getBytes();
        System.arraycopy(bytes, 0, c0920e.c, 0, C0927l.a(bytes.length, c0920e.c.length));
        bytes = c0930o.f().getBytes();
        System.arraycopy(bytes, 0, c0920e.g, 0, C0927l.a(bytes.length, c0920e.g.length));
        bytes = c0930o.g().getBytes();
        System.arraycopy(bytes, 0, c0920e.a, 0, C0927l.a(bytes.length, c0920e.a.length));
        bytes = c0930o.h().getBytes();
        System.arraycopy(bytes, 0, c0920e.b, 0, C0927l.a(bytes.length, c0920e.b.length));
        c0920e.d = (short) c0930o.q();
        c0920e.e = (short) c0930o.r();
        c0920e.f = (byte) c0930o.s();
        bytes = c0930o.t().getBytes();
        System.arraycopy(bytes, 0, c0920e.h, 0, C0927l.a(bytes.length, c0920e.h.length));
        long j2 = j / 1000;
        bytes = (location == null || !c0930o.e()) ? null : 1;
        as asVar;
        if (bytes != null) {
            asVar = new as();
            asVar.b = (int) j2;
            au auVar = new au();
            auVar.a = (int) (location.getLongitude() * 1000000.0d);
            auVar.b = (int) (location.getLatitude() * 1000000.0d);
            auVar.c = (int) location.getAltitude();
            auVar.d = (int) location.getAccuracy();
            auVar.e = (int) location.getSpeed();
            auVar.f = (short) ((int) location.getBearing());
            if (Build.MODEL.equals(o.w) || (C0930o.b(c0930o.y()) && at.b)) {
                auVar.g = (byte) 1;
            } else {
                auVar.g = (byte) 0;
            }
            auVar.h = b;
            auVar.i = System.currentTimeMillis();
            auVar.j = c0930o.o();
            asVar.c = auVar;
            i2 = 1;
            c0920e.j.add(asVar);
        } else if (!z) {
            return null;
        } else {
            asVar = new as();
            asVar.b = (int) j2;
            C0922g c0922g = new C0922g();
            c0922g.a = c0930o.x();
            for (i2 = 0; i2 < c0922g.a; i2++) {
                C0923h c0923h = new C0923h();
                c0923h.a = (byte) c0930o.a(i2).length();
                System.arraycopy(c0930o.a(i2).getBytes(), 0, c0923h.b, 0, c0923h.a);
                c0923h.c = c0930o.b(i2);
                c0923h.d = c0930o.c(i2);
                c0923h.e = c0930o.d(i2);
                c0923h.f = c0930o.e(i2);
                c0923h.g = c0930o.f(i2);
                c0923h.h = (byte) c0930o.g(i2).length();
                System.arraycopy(c0930o.g(i2).getBytes(), 0, c0923h.i, 0, c0923h.h);
                c0923h.j = c0930o.h(i2);
                c0922g.b.add(c0923h);
            }
            asVar.g = c0922g;
            i2 = 1;
            c0920e.j.add(asVar);
        }
        if (!(!c0930o.c() || c0930o.i() || obj == null || z)) {
            as asVar2 = new as();
            asVar2.b = (int) j2;
            aq aqVar = new aq();
            List a = c0930o.a(location.getSpeed());
            if (a != null && a.size() >= 3) {
                aqVar.a = (short) ((Integer) a.get(0)).intValue();
                aqVar.b = ((Integer) a.get(1)).intValue();
            }
            aqVar.c = c0930o.l();
            List m = c0930o.m();
            aqVar.d = (byte) m.size();
            for (i3 = 0; i3 < m.size(); i3++) {
                C0929n c0929n = new C0929n();
                c0929n.a = (short) ((NeighboringCellInfo) m.get(i3)).getLac();
                c0929n.b = ((NeighboringCellInfo) m.get(i3)).getCid();
                c0929n.c = (byte) ((NeighboringCellInfo) m.get(i3)).getRssi();
                aqVar.e.add(c0929n);
            }
            asVar2.d = aqVar;
            i2 = 2;
            c0920e.j.add(asVar2);
        }
        i3 = i2;
        if (c0930o.c() && c0930o.i() && obj != null && !z) {
            as asVar3 = new as();
            asVar3.b = (int) j2;
            C0928m c0928m = new C0928m();
            List b2 = c0930o.b(location.getSpeed());
            if (b2 != null && b2.size() >= 6) {
                c0928m.a = ((Integer) b2.get(3)).intValue();
                c0928m.b = ((Integer) b2.get(4)).intValue();
                c0928m.c = (short) ((Integer) b2.get(0)).intValue();
                c0928m.d = (short) ((Integer) b2.get(1)).intValue();
                c0928m.e = ((Integer) b2.get(2)).intValue();
                c0928m.f = c0930o.l();
            }
            asVar3.e = c0928m;
            i3++;
            c0920e.j.add(asVar3);
        }
        if (!(!c0930o.d() || obj2 == null || z)) {
            asVar2 = new as();
            C0924i c0924i = new C0924i();
            List u = c0930o.u();
            asVar2.b = (int) (((Long) u.get(0)).longValue() / 1000);
            c0924i.a = (byte) (u.size() - 1);
            for (int i4 = 1; i4 < u.size(); i4++) {
                List list = (List) u.get(i4);
                if (list != null && list.size() >= 3) {
                    C0925j c0925j = new C0925j();
                    bytes = ((String) list.get(0)).getBytes();
                    System.arraycopy(bytes, 0, c0925j.a, 0, C0927l.a(bytes.length, c0925j.a.length));
                    c0925j.b = (short) ((Integer) list.get(1)).intValue();
                    bytes = ((String) list.get(2)).getBytes();
                    System.arraycopy(bytes, 0, c0925j.c, 0, C0927l.a(bytes.length, c0925j.c.length));
                    c0924i.b.add(c0925j);
                }
            }
            asVar2.f = c0924i;
            i3++;
            c0920e.j.add(asVar2);
        }
        c0920e.i = (short) i3;
        return (i3 >= 2 || z) ? c0920e : null;
    }

    protected static File a(Context context) {
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/files/"));
    }

    public static Object a(Object obj, String str, Object... objArr) {
        Class cls = obj.getClass();
        Class[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(obj, objArr);
    }

    private static ArrayList a(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < fileArr.length) {
            if (fileArr[i].isFile() && fileArr[i].getName().length() == 10 && TextUtils.isDigitsOnly(fileArr[i].getName())) {
                arrayList.add(fileArr[i]);
            }
            i++;
        }
        return arrayList;
    }

    protected static byte[] a(BitSet bitSet) {
        byte[] bArr = new byte[(bitSet.size() / 8)];
        for (int i = 0; i < bitSet.size(); i++) {
            int i2 = i / 8;
            bArr[i2] = (byte) (((bitSet.get(i) ? 1 : 0) << (7 - (i % 8))) | bArr[i2]);
        }
        return bArr;
    }

    protected static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e) {
            return bArr2;
        }
    }

    protected static byte[] a(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int indexOf = new String(bArr).indexOf(0);
        if (indexOf <= 0) {
            i = 1;
        } else if (indexOf + 1 <= i) {
            i = indexOf + 1;
        }
        Object obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        obj[i - 1] = null;
        return obj;
    }

    public static int b(Object obj, String str, Object... objArr) {
        Class cls = obj.getClass();
        Class[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, objArr)).intValue();
    }

    protected static BitSet b(byte[] bArr) {
        BitSet bitSet = new BitSet(bArr.length << 3);
        int i = 0;
        for (byte b : bArr) {
            int i2 = 7;
            while (i2 >= 0) {
                int i3 = i + 1;
                bitSet.set(i, ((b & (1 << i2)) >> i2) == 1);
                i2--;
                i = i3;
            }
        }
        return bitSet;
    }

    private File c(long j) {
        boolean z = false;
        if (Process.myUid() == h.E) {
            return null;
        }
        File file;
        boolean equals;
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = z;
        }
        if (!C0927l.c() || r0) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) <= ((long) (this.c / 2))) {
                return null;
            }
            File file2 = new File(C0927l.a(this.a).getPath() + File.separator + "carrierdata");
            if (!(file2.exists() && file2.isDirectory())) {
                file2.mkdirs();
            }
            file = new File(file2.getPath() + File.separator + j);
            try {
                z = file.createNewFile();
            } catch (IOException e2) {
            }
        } else {
            file = null;
        }
        return !z ? null : file;
    }

    protected static boolean c() {
        if (VERSION.SDK_INT >= 9) {
            try {
                return ((Boolean) Environment.class.getMethod("isExternalStorageRemovable", null).invoke(null, null)).booleanValue();
            } catch (Exception e) {
            }
        }
        return true;
    }

    private File d() {
        if (Process.myUid() == h.E) {
            return null;
        }
        File file;
        boolean equals;
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = false;
        }
        if (!C0927l.c() || r0) {
            File file2 = new File(C0927l.a(this.a).getPath() + File.separator + "carrierdata");
            if (file2.exists() && file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    ArrayList a = C0927l.a(listFiles);
                    if (a.size() == 1) {
                        if (((File) a.get(0)).length() < ((long) this.d)) {
                            file = (File) a.get(0);
                            return file;
                        }
                    } else if (a.size() >= 2) {
                        file = (File) a.get(0);
                        File file3 = (File) a.get(1);
                        if (file.getName().compareTo(file3.getName()) <= 0) {
                            file = file3;
                        }
                        return file;
                    }
                }
            }
        }
        file = null;
        return file;
    }

    private int e() {
        boolean equals;
        if (Process.myUid() == h.E) {
            return 0;
        }
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = false;
        }
        if (C0927l.c() && !r0) {
            return 0;
        }
        File file = new File(C0927l.a(this.a).getPath() + File.separator + "carrierdata");
        if (!file.exists() || !file.isDirectory()) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return 0;
        }
        ArrayList a = C0927l.a(listFiles);
        return a.size() == 1 ? ((File) a.get(0)).length() <= 0 ? 10 : 1 : a.size() >= 2 ? 2 : 0;
    }

    private File f() {
        if (Process.myUid() == h.E) {
            return null;
        }
        File file;
        boolean equals;
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = false;
        }
        if (!C0927l.c() || r0) {
            File a = C0927l.a(this.a);
            if (a != null) {
                File file2 = new File(a.getPath() + File.separator + "carrierdata");
                if (file2.exists() && file2.isDirectory()) {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        ArrayList a2 = C0927l.a(listFiles);
                        if (a2.size() >= 2) {
                            a = (File) a2.get(0);
                            file = (File) a2.get(1);
                            if (a.getName().compareTo(file.getName()) <= 0) {
                                file = a;
                            }
                            return file;
                        }
                    }
                }
            }
        }
        file = null;
        return file;
    }

    protected int a() {
        return this.b;
    }

    protected synchronized File a(long j) {
        File d;
        d = d();
        if (d == null) {
            d = c(j);
        }
        return d;
    }

    protected void a(int i) {
        this.b = i;
        this.c = (((this.b << 3) * C1012a.d) + this.b) + 4;
        if (this.b == PersonInfo.INCOMING_CALL_DISABLE_BIT || this.b == 768) {
            this.d = this.c / 100;
        } else if (this.b == 8736) {
            this.d = this.c - 5000;
        }
    }

    protected File b() {
        return f();
    }

    protected synchronized boolean b(long j) {
        boolean z = false;
        synchronized (this) {
            int e = e();
            if (e != 0) {
                if (e == 1) {
                    if (c(j) != null) {
                        z = true;
                    }
                } else if (e == 2) {
                    z = true;
                }
            }
        }
        return z;
    }
}
