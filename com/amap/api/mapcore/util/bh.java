package com.amap.api.mapcore.util;

import android.content.Context;
import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.mipush.sdk.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;
import org.json.JSONObject;

abstract class bh {
    private bl a;

    protected bh(Context context) {
        try {
            this.a = a(context, a());
        } catch (Throwable th) {
            az.a(th, "LogProcessor", "LogUpDateProcessor");
            th.printStackTrace();
        }
    }

    public static bh a(Context context, int i) {
        switch (i) {
            case a.i /*0*/:
                return new bc(context);
            case l.a /*1*/:
                return new be(context);
            case a.k /*2*/:
                return new ba(context);
            default:
                return null;
        }
    }

    private bl a(Context context, String str) {
        bl blVar = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append(bg.a);
            stringBuilder.append(str);
            File file = new File(stringBuilder.toString());
            if (file.exists() || file.mkdirs()) {
                blVar = bl.a(file, 1, 1, 20480);
            }
        } catch (Throwable e) {
            az.a(e, "LogProcessor", "initDiskLru");
            e.printStackTrace();
        } catch (Throwable e2) {
            az.a(e2, "LogProcessor", "initDiskLru");
            e2.printStackTrace();
        }
        return blVar;
    }

    private String a(List<an> list, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"pinfo\":\"").append(c(context)).append("\",\"els\":[");
        Object obj = 1;
        for (an anVar : list) {
            Object obj2;
            String c = c(anVar.b());
            if (c != null) {
                if (com.xiaomi.e.a.f.equals(c)) {
                    obj2 = obj;
                    obj = obj2;
                } else {
                    String str = c + "||" + anVar.d();
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append(f.i);
                    }
                    stringBuilder.append("{\"log\":\"").append(str).append("\"}");
                }
            }
            obj2 = obj;
            obj = obj2;
        }
        if (obj != null) {
            return null;
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }

    private void a(al alVar, int i) {
        try {
            a(alVar.a(2, i), alVar, i);
        } catch (Throwable th) {
            az.a(th, "LogProcessor", "processDeleteFail");
            th.printStackTrace();
        }
    }

    private void a(List<an> list, al alVar, int i) {
        if (list != null && list.size() > 0) {
            for (an anVar : list) {
                if (a(anVar.b())) {
                    alVar.a(anVar.b(), i);
                } else {
                    anVar.a(2);
                    alVar.a(anVar, anVar.a());
                }
            }
        }
    }

    private boolean a(String str) {
        boolean z = false;
        if (this.a != null) {
            try {
                z = this.a.c(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    private int b(String str) {
        int i = 0;
        try {
            byte[] a = bt.a(false).a(new bi(ae.b(str.getBytes())));
            if (a != null) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(a));
                    String str2 = b.a;
                    if (jSONObject.has(str2)) {
                        i = jSONObject.getInt(str2);
                    }
                } catch (Throwable e) {
                    az.a(e, "LogProcessor", "processUpdate");
                    e.printStackTrace();
                }
            }
        } catch (Throwable e2) {
            az.a(e2, "LogProcessor", "processUpdate");
            e2.printStackTrace();
        }
        return i;
    }

    private String c(Context context) {
        String str = null;
        try {
            String a = y.a(context);
            if (!com.xiaomi.e.a.f.equals(a)) {
                str = y.b(context, a.getBytes(h.DEFAULT_CHARSET));
            }
        } catch (Throwable e) {
            az.a(e, "LogProcessor", "getPublicInfo");
            e.printStackTrace();
        } catch (Throwable e2) {
            az.a(e2, "LogProcessor", "getPublicInfo");
            e2.printStackTrace();
        }
        return str;
    }

    private String c(String str) {
        Throwable e;
        IOException iOException;
        InputStream a;
        Throwable th;
        Object obj;
        String str2 = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            if (this.a == null) {
                if (str2 != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e2) {
                        az.a(e2, "LogProcessor", "readLog1");
                        e2.printStackTrace();
                    }
                }
                if (str2 != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        az.a(e, "LogProcessor", "readLog2");
                        iOException.printStackTrace();
                        return str2;
                    }
                }
                return str2;
            }
            bl.b a2 = this.a.a(str);
            if (a2 == null) {
                if (str2 != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e22) {
                        az.a(e22, "LogProcessor", "readLog1");
                        e22.printStackTrace();
                    }
                }
                if (str2 != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        iOException = e4;
                        az.a((Throwable) iOException, "LogProcessor", "readLog2");
                        iOException.printStackTrace();
                        return str2;
                    }
                }
                return str2;
            }
            a = a2.a(0);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[com.activeandroid.b.a];
                    while (true) {
                        int read = a.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str2 = byteArrayOutputStream.toString(a.bO);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e5) {
                            az.a(e5, "LogProcessor", "readLog1");
                            e5.printStackTrace();
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                        } catch (IOException e6) {
                            e5 = e6;
                            az.a(e5, "LogProcessor", "readLog2");
                            iOException.printStackTrace();
                            return str2;
                        }
                    }
                } catch (IOException e7) {
                    e5 = e7;
                    try {
                        az.a(e5, "LogProcessor", "readLog");
                        e5.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e52) {
                                az.a(e52, "LogProcessor", "readLog1");
                                e52.printStackTrace();
                            }
                        }
                        if (a != null) {
                            try {
                                a.close();
                            } catch (IOException e8) {
                                e52 = e8;
                                az.a(e52, "LogProcessor", "readLog2");
                                iOException.printStackTrace();
                                return str2;
                            }
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e522) {
                                az.a(e522, "LogProcessor", "readLog1");
                                e522.printStackTrace();
                            }
                        }
                        if (a != null) {
                            try {
                                a.close();
                            } catch (Throwable e5222) {
                                az.a(e5222, "LogProcessor", "readLog2");
                                e5222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    e5222 = th3;
                    az.a(e5222, "LogProcessor", "readLog");
                    e5222.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e52222) {
                            az.a(e52222, "LogProcessor", "readLog1");
                            e52222.printStackTrace();
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                        } catch (IOException e9) {
                            e52222 = e9;
                            az.a(e52222, "LogProcessor", "readLog2");
                            iOException.printStackTrace();
                            return str2;
                        }
                    }
                    return str2;
                }
            } catch (IOException e10) {
                e52222 = e10;
                obj = str2;
                az.a(e52222, "LogProcessor", "readLog");
                e52222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (a != null) {
                    a.close();
                }
                return str2;
            } catch (Throwable e522222) {
                obj = str2;
                th = e522222;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (a != null) {
                    a.close();
                }
                throw th;
            }
            return str2;
        } catch (IOException e11) {
            e522222 = e11;
            obj = str2;
            Object obj2 = str2;
            az.a(e522222, "LogProcessor", "readLog");
            e522222.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (a != null) {
                a.close();
            }
            return str2;
        } catch (Throwable e5222222) {
            byteArrayOutputStream = str2;
            a = str2;
            th = e5222222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    protected abstract String a();

    protected abstract boolean a(Context context);

    protected abstract int b();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void b(android.content.Context r6) {
        /*
        r5 = this;
        r0 = r5.a(r6);	 Catch:{ Throwable -> 0x002e }
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r1 = android.os.Looper.getMainLooper();	 Catch:{ Throwable -> 0x002e }
        monitor-enter(r1);	 Catch:{ Throwable -> 0x002e }
        r0 = new com.amap.api.mapcore.util.al;	 Catch:{ all -> 0x002b }
        r0.<init>(r6);	 Catch:{ all -> 0x002b }
        r2 = r5.b();	 Catch:{ all -> 0x002b }
        r5.a(r0, r2);	 Catch:{ all -> 0x002b }
        r2 = 0;
        r3 = r5.b();	 Catch:{ all -> 0x002b }
        r2 = r0.a(r2, r3);	 Catch:{ all -> 0x002b }
        if (r2 == 0) goto L_0x0029;
    L_0x0023:
        r3 = r2.size();	 Catch:{ all -> 0x002b }
        if (r3 != 0) goto L_0x003a;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0006;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        throw r0;	 Catch:{ Throwable -> 0x002e }
    L_0x002e:
        r0 = move-exception;
        r1 = "LogProcessor";
        r2 = "processUpdateLog";
        com.amap.api.mapcore.util.az.a(r0, r1, r2);
        r0.printStackTrace();
        goto L_0x0006;
    L_0x003a:
        r3 = r5.a(r2, r6);	 Catch:{ all -> 0x002b }
        if (r3 != 0) goto L_0x0042;
    L_0x0040:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0006;
    L_0x0042:
        r3 = r5.b(r3);	 Catch:{ all -> 0x002b }
        r4 = 1;
        if (r3 != r4) goto L_0x0050;
    L_0x0049:
        r3 = r5.b();	 Catch:{ all -> 0x002b }
        r5.a(r2, r0, r3);	 Catch:{ all -> 0x002b }
    L_0x0050:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bh.b(android.content.Context):void");
    }

    void c() {
        if (this.a != null && !this.a.a()) {
            try {
                this.a.close();
            } catch (Throwable e) {
                az.a(e, "LogProcessor", "closeDiskLru");
                e.printStackTrace();
            } catch (Throwable e2) {
                az.a(e2, "LogProcessor", "closeDiskLru");
                e2.printStackTrace();
            }
        }
    }
}
