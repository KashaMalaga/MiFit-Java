package cn.com.smartdevices.bracelet.lab.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class a {
    public static boolean a = false;
    private static final int b = 20971520;
    private static final File c = cn.com.smartdevices.bracelet.a.a.d(".MISportLab");
    private static final File d = new File(c.getAbsoluteFile(), "blue.pkg.txt");
    private static final File e = new File(c.getAbsoluteFile(), "blue.pkg.sample.txt");
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static int g = -1;
    private static int h = 0;
    private static boolean i = false;
    private static String j = com.xiaomi.e.a.f;
    private static ArrayList<String> k = new ArrayList();

    private a() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a() {
        /*
        r5 = 0;
        r1 = -1;
        r4 = 1;
        r0 = d;
        r0 = r0.exists();
        if (r0 == 0) goto L_0x003e;
    L_0x000b:
        r6 = new java.io.FileInputStream;
        r0 = d;
        r6.<init>(r0);
        r7 = new java.io.InputStreamReader;
        r0 = "UTF-8";
        r7.<init>(r6, r0);
        r8 = new java.io.BufferedReader;
        r8.<init>(r7);
        r0 = "";
        r0 = r1;
        r3 = r4;
    L_0x0022:
        r2 = r8.readLine();
        if (r2 == 0) goto L_0x006e;
    L_0x0028:
        r9 = "\t";
        r2 = r2.split(r9);
        r9 = r2.length;
        r10 = 4;
        if (r9 == r10) goto L_0x003f;
    L_0x0032:
        r8.close();
        r7.close();
        r6.close();
        if (r4 == 0) goto L_0x003e;
    L_0x003d:
        r1 = r3;
    L_0x003e:
        return r1;
    L_0x003f:
        r9 = 2;
        r2 = r2[r9];
        r9 = ",";
        r2 = r2.split(r9);
        r9 = r2[r5];
        r10 = r2.length;
        r10 = r10 + -1;
        r10 = r2[r10];
        r2 = java.lang.Integer.parseInt(r9);
        r9 = "NotEven";
        r9 = r10.contains(r9);
        if (r9 != 0) goto L_0x0032;
    L_0x005b:
        r9 = "Fragment";
        r9 = r10.contains(r9);
        if (r9 != 0) goto L_0x0032;
    L_0x0063:
        if (r2 == 0) goto L_0x0069;
    L_0x0065:
        r0 = r0 + 1;
        if (r2 != r0) goto L_0x0032;
    L_0x0069:
        r0 = r3 + 1;
        r3 = r0;
        r0 = r2;
        goto L_0x0022;
    L_0x006e:
        r4 = r5;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.lab.a.a.a():int");
    }

    private static int a(byte b, byte b2) {
        return (b & HeartRateInfo.HR_EMPTY_VALUE) | ((b2 & HeartRateInfo.HR_EMPTY_VALUE) << 8);
    }

    public static void a(String str, byte[] bArr, String str2) {
        if (C0596r.b()) {
            String str3 = com.xiaomi.e.a.f;
            for (int i = 0; i < bArr.length; i += 2) {
                if (i + 1 < bArr.length) {
                    int a = a(bArr[i], bArr[i + 1]);
                    str3 = str3 == com.xiaomi.e.a.f ? str3 + Integer.toString(a) : str3 + ", " + Integer.toString(a);
                } else {
                    str3 = str3 + ", NotEven(" + Integer.toString(bArr[i] & HeartRateInfo.HR_EMPTY_VALUE) + ")";
                    a = true;
                }
            }
            if ((bArr.length - 2) % 6 != 0) {
                str3 = str3 + ", Fragment";
                a = true;
            }
            if (i) {
                d();
                i = false;
                h = 0;
                k.clear();
            }
            str3 = c() + "\t" + str + "\t" + bArr.length + "\t" + str3;
            k.add(!str2.equals(com.xiaomi.e.a.f) ? str3 + "\t" + str2 + "\n" : str3 + "\n");
            h += (bArr.length - 2) / 6;
        }
    }

    public static void b() {
        if (d.exists()) {
            d.delete();
        }
        if (e.exists()) {
            e.delete();
        }
    }

    private static String c() {
        Date date = new Date();
        if (date.getSeconds() != g) {
            g = date.getSeconds();
            i = true;
            j = f.format(date);
        }
        return f.format(date);
    }

    private static void d() {
        FileWriter fileWriter;
        IOException e;
        Throwable th;
        FileWriter fileWriter2 = null;
        if (!c.exists()) {
            c.mkdir();
        }
        if (d.exists() && d.length() > 20971520) {
            d.delete();
        }
        FileWriter fileWriter3;
        try {
            fileWriter3 = new FileWriter(d, true);
            try {
                fileWriter = new FileWriter(e, true);
                try {
                    Iterator it = k.iterator();
                    while (it.hasNext()) {
                        fileWriter3.write((String) it.next());
                    }
                    fileWriter.write(j + "\t" + h + "\n");
                    if (fileWriter3 != null) {
                        try {
                            fileWriter3.close();
                        } catch (IOException e2) {
                            C0596r.a("Lab", e2.getMessage());
                        }
                    }
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e22) {
                            C0596r.a("Lab", e22.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e22 = e3;
                    fileWriter2 = fileWriter3;
                    try {
                        C0596r.a("Lab", e22.getMessage());
                        if (fileWriter2 != null) {
                            try {
                                fileWriter2.close();
                            } catch (IOException e222) {
                                C0596r.a("Lab", e222.getMessage());
                            }
                        }
                        if (fileWriter == null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e2222) {
                                C0596r.a("Lab", e2222.getMessage());
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileWriter3 = fileWriter2;
                        if (fileWriter3 != null) {
                            try {
                                fileWriter3.close();
                            } catch (IOException e4) {
                                C0596r.a("Lab", e4.getMessage());
                            }
                        }
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e5) {
                                C0596r.a("Lab", e5.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileWriter3 != null) {
                        fileWriter3.close();
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e2222 = e6;
                fileWriter = null;
                fileWriter2 = fileWriter3;
                C0596r.a("Lab", e2222.getMessage());
                if (fileWriter2 != null) {
                    fileWriter2.close();
                }
                if (fileWriter == null) {
                    fileWriter.close();
                }
            } catch (Throwable th4) {
                th = th4;
                fileWriter = null;
                if (fileWriter3 != null) {
                    fileWriter3.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw th;
            }
        } catch (IOException e7) {
            e2222 = e7;
            fileWriter = null;
            C0596r.a("Lab", e2222.getMessage());
            if (fileWriter2 != null) {
                fileWriter2.close();
            }
            if (fileWriter == null) {
                fileWriter.close();
            }
        } catch (Throwable th5) {
            th = th5;
            fileWriter = null;
            fileWriter3 = null;
            if (fileWriter3 != null) {
                fileWriter3.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw th;
        }
    }
}
