package b.a;

import android.content.Context;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ds {
    private static final String a = ".imprint";
    private static final byte[] b = "pbl0".getBytes();
    private C0300as c = null;
    private Context d;

    public ds(Context context) {
        this.d = context;
    }

    private C0300as a(C0300as c0300as, C0300as c0300as2) {
        if (c0300as2 != null) {
            Map d = c0300as.d();
            for (Entry entry : c0300as2.d().entrySet()) {
                if (((C0306ay) entry.getValue()).e()) {
                    d.put((String) entry.getKey(), (C0306ay) entry.getValue());
                } else {
                    d.remove(entry.getKey());
                }
            }
            c0300as.a(c0300as2.h());
            c0300as.a(a(c0300as));
        }
        return c0300as;
    }

    private boolean c(C0300as c0300as) {
        if (!c0300as.k().equals(a(c0300as))) {
            return false;
        }
        for (C0306ay c0306ay : c0300as.d().values()) {
            byte[] b = C0356cr.b(c0306ay.j());
            byte[] a = a(c0306ay);
            for (int i = 0; i < 4; i++) {
                if (b[i] != a[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public synchronized C0300as a() {
        return this.c;
    }

    public String a(C0300as c0300as) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : new TreeMap(c0300as.d()).entrySet()) {
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(((C0306ay) entry.getValue()).c());
            stringBuilder.append(((C0306ay) entry.getValue()).f());
            stringBuilder.append(((C0306ay) entry.getValue()).j());
        }
        stringBuilder.append(c0300as.b);
        return C0352cm.a(stringBuilder.toString()).toLowerCase(Locale.US);
    }

    public byte[] a(C0306ay c0306ay) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(c0306ay.f());
        byte[] array = allocate.array();
        byte[] bArr = b;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (array[i] ^ bArr[i]);
        }
        return bArr2;
    }

    public void b() {
        InputStream openFileInput;
        byte[] b;
        Exception e;
        cq c0300as;
        Throwable th;
        InputStream inputStream = null;
        if (new File(this.d.getFilesDir(), a).exists()) {
            try {
                openFileInput = this.d.openFileInput(a);
                try {
                    b = C0352cm.b(openFileInput);
                    C0352cm.c(openFileInput);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        C0352cm.c(openFileInput);
                        if (b == null) {
                            try {
                                c0300as = new C0300as();
                                new C0360cv().a(c0300as, b);
                                this.c = c0300as;
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = openFileInput;
                        C0352cm.c(inputStream);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e3 = e4;
                openFileInput = inputStream;
                e3.printStackTrace();
                C0352cm.c(openFileInput);
                if (b == null) {
                    c0300as = new C0300as();
                    new C0360cv().a(c0300as, b);
                    this.c = c0300as;
                }
            } catch (Throwable th3) {
                th = th3;
                C0352cm.c(inputStream);
                throw th;
            }
            if (b == null) {
                c0300as = new C0300as();
                new C0360cv().a(c0300as, b);
                this.c = c0300as;
            }
        }
    }

    public void b(C0300as c0300as) {
        if (c0300as != null && c(c0300as)) {
            synchronized (this) {
                C0300as c0300as2 = this.c;
                if (c0300as2 != null) {
                    c0300as = a(c0300as2, c0300as);
                }
                this.c = c0300as;
            }
        }
    }

    public void c() {
        if (this.c != null) {
            try {
                C0352cm.a(new File(this.d.getFilesDir(), a), new cB().a(this.c));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean d() {
        return new File(this.d.getFilesDir(), a).delete();
    }
}
