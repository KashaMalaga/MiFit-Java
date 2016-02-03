package cn.com.smartdevices.bracelet.lab.ui;

import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.lab.b.b;
import cn.com.smartdevices.bracelet.lab.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class af {
    private static final String a = "bumping_tone.ogg";
    private static final String b = "bumping_tone_well_done.ogg";
    private static final String c = "bumping_tone_great.ogg";
    private static final int m = 0;
    private static final int n = 1;
    private static final int o = 2;
    private ah d = null;
    private Uri e = null;
    private Uri f = null;
    private Uri g = null;
    private V h = null;
    private V i = null;
    private V j = null;
    private c k = null;
    private Context l = null;

    private af() {
    }

    public af(Context context) {
        this.l = context;
        this.k = new c(context);
        this.d = new ah();
        this.h = new V("rhythm");
        this.i = new V("great");
        this.j = new V("wellDone");
        this.e = a(context, (int) m);
        this.f = a(context, (int) n);
        this.g = a(context, (int) o);
    }

    private Uri a(Context context, int i) {
        Uri uri = null;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        String str;
        c cVar = new c(context);
        if (i == 0) {
            uri = cVar.b();
            str = a;
        } else if (n == i) {
            uri = cVar.a();
            str = c;
        } else if (o == i) {
            uri = cVar.c();
            str = b;
        } else {
            str = null;
        }
        if (uri == null || !new File(uri.getPath()).exists()) {
            uri = a(context, str);
        }
        return uri == null ? RingtoneManager.getDefaultUri(o) : uri;
    }

    public static Uri a(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        String str2 = context.getFilesDir() + "/tone/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        str2 = str2 + str;
        if (new File(str2).exists()) {
            return Uri.parse(str2);
        }
        boolean a = C0566a.a(context, str, str2);
        C0596r.e("Lab", " isSucceeded = " + a);
        return a ? Uri.parse(str2) : null;
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
            }
        }
    }

    private static boolean a(Context context, String str, String str2) {
        Exception e;
        OutputStream outputStream;
        Throwable th;
        Object obj = null;
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        Object a;
        InputStream open;
        try {
            open = context.getResources().getAssets().open(str2);
            try {
                a = b.a(new byte[open.available()]);
                a(open, (OutputStream) obj);
            } catch (Exception e2) {
                e = e2;
                try {
                    C0596r.a("Lab", e.getMessage());
                    a(open, (OutputStream) obj);
                    outputStream = obj;
                    if (!TextUtils.isEmpty(a)) {
                        return false;
                    }
                    try {
                        obj = b.b(file);
                    } catch (IOException e3) {
                        C0596r.a("Lab", e3.getMessage());
                    }
                    return a.equals(obj);
                } catch (Throwable th2) {
                    th = th2;
                    a(open, (OutputStream) obj);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            open = obj;
            C0596r.a("Lab", e.getMessage());
            a(open, (OutputStream) obj);
            outputStream = obj;
            if (!TextUtils.isEmpty(a)) {
                return false;
            }
            obj = b.b(file);
            return a.equals(obj);
        } catch (Throwable th3) {
            th = th3;
            open = obj;
            a(open, (OutputStream) obj);
            throw th;
        }
        if (!TextUtils.isEmpty(a)) {
            return false;
        }
        obj = b.b(file);
        return a.equals(obj);
    }

    public void a() {
        if (this.d != null) {
            this.d.a();
        }
    }

    public void a(int i, boolean z) {
        Message obtainMessage = this.d.obtainMessage();
        obtainMessage.what = o;
        if (z) {
            obtainMessage.arg1 = n;
        } else if (i % 30 == 0) {
            obtainMessage.arg1 = o;
        } else {
            obtainMessage.arg1 = m;
        }
        this.d.sendMessage(obtainMessage);
    }

    public void a(Uri uri) {
        if (uri != null) {
            this.e = uri;
        }
    }

    public void stop() {
        if (this.h != null) {
            this.h.stop();
        }
        if (this.i != null) {
            this.i.stop();
        }
        if (this.j != null) {
            this.j.stop();
        }
        if (this.k != null) {
            this.k.a(this.e);
            this.k.b(this.g);
            this.k.c(this.f);
        }
    }
}
