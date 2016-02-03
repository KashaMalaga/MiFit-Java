package com.d.a.a;

import android.support.v4.view.a.C0113o;
import android.util.Log;
import com.xiaomi.channel.relationservice.data.a;
import com.xiaomi.channel.relationservice.data.b;
import com.xiaomi.hm.health.t;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class G implements HttpEntity {
    private static final String a = "JsonStreamerEntity";
    private static final UnsupportedOperationException b = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final int c = 4096;
    private static final StringBuilder e = new StringBuilder(C0113o.h);
    private static final byte[] f = "true".getBytes();
    private static final byte[] g = "false".getBytes();
    private static final byte[] h = "null".getBytes();
    private static final byte[] i = a("name");
    private static final byte[] j = a(a.h);
    private static final byte[] k = a("contents");
    private static final byte[] l = a("_elapsed");
    private static final Header m = new BasicHeader("Content-Type", "application/json");
    private static final Header n = new BasicHeader("Content-Encoding", C1012a.g);
    private final byte[] d = new byte[c];
    private final Map<String, Object> o = new HashMap();
    private final Header p;
    private final S q;

    public G(S s, boolean z) {
        this.q = s;
        this.p = z ? n : null;
    }

    private void a(OutputStream outputStream) {
        outputStream.write(34);
    }

    private void a(OutputStream outputStream, Q q) {
        a(outputStream, q.a.getName(), q.b);
        int length = (int) q.a.length();
        InputStream fileInputStream = new FileInputStream(q.a);
        OutputStream c1025o = new C1025o(outputStream, 18);
        int i = 0;
        while (true) {
            int read = fileInputStream.read(this.d);
            if (read != -1) {
                c1025o.write(this.d, 0, read);
                i += read;
                this.q.sendProgressMessage(i, length);
            } else {
                C1012a.a(c1025o);
                a(outputStream);
                C1012a.a(fileInputStream);
                return;
            }
        }
    }

    private void a(OutputStream outputStream, R r) {
        a(outputStream, r.b, r.c);
        OutputStream c1025o = new C1025o(outputStream, 18);
        while (true) {
            int read = r.a.read(this.d);
            if (read == -1) {
                break;
            }
            c1025o.write(this.d, 0, read);
        }
        C1012a.a(c1025o);
        a(outputStream);
        if (r.d) {
            C1012a.a(r.a);
        }
    }

    private void a(OutputStream outputStream, String str, String str2) {
        outputStream.write(i);
        outputStream.write(58);
        outputStream.write(a(str));
        outputStream.write(44);
        outputStream.write(j);
        outputStream.write(58);
        outputStream.write(a(str2));
        outputStream.write(44);
        outputStream.write(k);
        outputStream.write(58);
        outputStream.write(34);
    }

    static byte[] a(String str) {
        if (str == null) {
            return h;
        }
        e.append('\"');
        int length = str.length();
        int i = -1;
        while (true) {
            int i2 = i + 1;
            if (i2 < length) {
                char charAt = str.charAt(i2);
                switch (charAt) {
                    case kankan.wheel.widget.a.ba /*8*/:
                        e.append("\\b");
                        break;
                    case kankan.wheel.widget.a.bo /*9*/:
                        e.append("\\t");
                        break;
                    case kankan.wheel.widget.a.bd /*10*/:
                        e.append("\\n");
                        break;
                    case kankan.wheel.widget.a.be /*12*/:
                        e.append("\\f");
                        break;
                    case t.WeightView_wv_bmi_size /*13*/:
                        e.append("\\r");
                        break;
                    case b.I /*34*/:
                        e.append("\\\"");
                        break;
                    case '\\':
                        e.append("\\\\");
                        break;
                    default:
                        if ((charAt >= '\u0000' && charAt <= '\u001f') || ((charAt >= '\u007f' && charAt <= '\u009f') || (charAt >= '\u2000' && charAt <= '\u20ff'))) {
                            String toHexString = Integer.toHexString(charAt);
                            e.append("\\u");
                            int length2 = 4 - toHexString.length();
                            for (i = 0; i < length2; i++) {
                                e.append('0');
                            }
                            e.append(toHexString.toUpperCase(Locale.US));
                            break;
                        }
                        e.append(charAt);
                        break;
                }
                i = i2;
            } else {
                e.append('\"');
                try {
                    byte[] bytes = e.toString().getBytes();
                    return bytes;
                } finally {
                    e.setLength(0);
                }
            }
        }
    }

    public void a(String str, Object obj) {
        this.o.put(str, obj);
    }

    public void consumeContent() {
    }

    public InputStream getContent() {
        throw b;
    }

    public Header getContentEncoding() {
        return this.p;
    }

    public long getContentLength() {
        return -1;
    }

    public Header getContentType() {
        return m;
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.p != null) {
            outputStream = new GZIPOutputStream(outputStream, c);
        }
        outputStream.write(123);
        for (String str : this.o.keySet()) {
            Object obj = this.o.get(str);
            if (obj != null) {
                outputStream.write(a(str));
                outputStream.write(58);
                boolean z = obj instanceof Q;
                if (z || (obj instanceof R)) {
                    outputStream.write(123);
                    if (z) {
                        a(outputStream, (Q) obj);
                    } else {
                        a(outputStream, (R) obj);
                    }
                    outputStream.write(125);
                } else if (obj instanceof Boolean) {
                    outputStream.write(((Boolean) obj).booleanValue() ? f : g);
                } else if (obj instanceof Long) {
                    outputStream.write((((Number) obj).longValue() + com.xiaomi.e.a.f).getBytes());
                } else if (obj instanceof Double) {
                    outputStream.write((((Number) obj).doubleValue() + com.xiaomi.e.a.f).getBytes());
                } else if (obj instanceof Float) {
                    outputStream.write((((Number) obj).floatValue() + com.xiaomi.e.a.f).getBytes());
                } else if (obj instanceof Integer) {
                    outputStream.write((((Number) obj).intValue() + com.xiaomi.e.a.f).getBytes());
                } else {
                    outputStream.write(obj.toString().getBytes());
                }
                outputStream.write(44);
            }
        }
        outputStream.write(l);
        outputStream.write(58);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        outputStream.write((currentTimeMillis2 + "}").getBytes());
        Log.i(a, "Uploaded JSON in " + Math.floor((double) (currentTimeMillis2 / 1000)) + " seconds");
        outputStream.flush();
        C1012a.a(outputStream);
    }
}
