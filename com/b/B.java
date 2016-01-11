package com.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Process;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import com.d.a.a.C1012a;
import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.mistatistic.sdk.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.json.JSONObject;

public final class B {
    private Context a = null;
    private boolean b = true;
    private int c = 1270;
    private int d = 310;
    private int e = 4;
    private int f = v.C;
    private int g = 1;
    private int h = 0;
    private int i = 0;
    private long j = 0;
    private A k = null;

    private B(Context context) {
        this.a = context;
    }

    private static int a(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 4) {
            i3 += (bArr[i2 + i] & HeartRateInfo.HR_EMPTY_VALUE) << (i2 << 3);
            i2++;
        }
        return i3;
    }

    protected static B a(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        B b = new B(context);
        b.h = 0;
        b.i = 0;
        b.j = ((System.currentTimeMillis() + 28800000) / d.h) * d.h;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(b(context) + File.separator + "data_carrier_status"));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[32];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                if (toByteArray != null && toByteArray.length >= 22) {
                    b.b = toByteArray[0] != (byte) 0;
                    b.c = (toByteArray[1] * 10) << 10;
                    b.d = (toByteArray[2] * 10) << 10;
                    b.e = toByteArray[3];
                    b.f = toByteArray[4] * 10;
                    b.g = toByteArray[5];
                    long b2 = b(toByteArray, 14);
                    if (b.j - b2 < d.h) {
                        b.j = b2;
                        b.h = a(toByteArray, 6);
                        b.i = a(toByteArray, 10);
                    }
                }
                byteArrayOutputStream.close();
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return b;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileInputStream2 = fileInputStream;
                th = th3;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return b;
        } catch (Throwable th4) {
            th = th4;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
        return b;
    }

    private static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) ((j >> (i << 3)) & 255));
        }
        return bArr;
    }

    private static long b(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 8) {
            i3 += (bArr[i2 + 14] & HeartRateInfo.HR_EMPTY_VALUE) << (i2 << 3);
            i2++;
        }
        return (long) i3;
    }

    private static String b(Context context) {
        boolean z = false;
        File file = null;
        if (Process.myUid() != h.E) {
            file = C0927l.a(context);
        }
        try {
            z = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
        }
        return ((z || !C0927l.c()) && file != null) ? file.getPath() : context.getFilesDir().getPath();
    }

    private static byte[] c(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >> (i2 << 3));
        }
        return bArr;
    }

    private void g() {
        long currentTimeMillis = System.currentTimeMillis() + 28800000;
        if (currentTimeMillis - this.j > d.h) {
            this.j = (currentTimeMillis / d.h) * d.h;
            this.h = 0;
            this.i = 0;
        }
    }

    protected final void a(int i) {
        g();
        if (i < 0) {
            i = 0;
        }
        this.h = i;
    }

    protected final void a(A a) {
        this.k = a;
    }

    protected final boolean a() {
        g();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? this.b : activeNetworkInfo.getType() == 1 ? this.b && this.h < this.c : this.b && this.i < this.d;
    }

    protected final boolean a(String str) {
        boolean z;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        int i = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(GroupItemBaseInfo.KEY_END_TIME)) {
                this.b = jSONObject.getInt(GroupItemBaseInfo.KEY_END_TIME) != 0;
            }
            if (jSONObject.has("d")) {
                int i2 = jSONObject.getInt("d");
                this.c = ((i2 & android.support.v4.media.h.j) * 10) << 10;
                this.d = (((i2 & 3968) >> 7) * 10) << 10;
                this.e = (520192 & i2) >> 12;
                this.f = ((66584576 & i2) >> 19) * 10;
                this.g = (i2 & 2080374784) >> 26;
                if (this.g == 31) {
                    this.g = C1012a.d;
                }
                if (this.k != null) {
                    this.k.a();
                }
            }
            z = jSONObject.has("u") ? jSONObject.getInt("u") != 0 : false;
        } catch (Exception e) {
            z = false;
        }
        try {
            g();
            fileOutputStream = new FileOutputStream(new File(b(this.a) + File.separator + "data_carrier_status"));
            try {
                byte[] c = c(this.h);
                byte[] c2 = c(this.i);
                byte[] a = a(this.j);
                byte[] bArr = new byte[22];
                if (!this.b) {
                    i = 0;
                }
                bArr[0] = (byte) i;
                bArr[1] = (byte) (this.c / 10240);
                bArr[2] = (byte) (this.d / 10240);
                bArr[3] = (byte) this.e;
                bArr[4] = (byte) (this.f / 10);
                bArr[5] = (byte) this.g;
                bArr[6] = c[0];
                bArr[7] = c[1];
                bArr[8] = c[2];
                bArr[9] = c[3];
                bArr[10] = c2[0];
                bArr[11] = c2[1];
                bArr[12] = c2[2];
                bArr[13] = c2[3];
                bArr[14] = a[0];
                bArr[15] = a[1];
                bArr[16] = a[2];
                bArr[17] = a[3];
                bArr[18] = a[4];
                bArr[19] = a[5];
                bArr[20] = a[6];
                bArr[21] = a[7];
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            fileOutputStream2 = null;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        return z;
    }

    protected final int b() {
        return this.e;
    }

    protected final void b(int i) {
        g();
        if (i < 0) {
            i = 0;
        }
        this.i = i;
    }

    protected final int c() {
        return this.f;
    }

    protected final int d() {
        return this.g;
    }

    protected final int e() {
        g();
        return this.h;
    }

    protected final int f() {
        g();
        return this.i;
    }
}
