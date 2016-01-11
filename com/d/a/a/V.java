package com.d.a.a;

import android.util.Log;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class V implements HttpEntity {
    private static final String a = "SimpleMultipartEntity";
    private static final String b = "\r\n";
    private static final byte[] c = b.getBytes();
    private static final byte[] d = "Content-Transfer-Encoding: binary\r\n".getBytes();
    private static final char[] e = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final String f;
    private final byte[] g;
    private final byte[] h;
    private boolean i;
    private final List<W> j = new ArrayList();
    private final ByteArrayOutputStream k = new ByteArrayOutputStream();
    private final S l;
    private int m;
    private int n;

    public V(S s) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            stringBuilder.append(e[random.nextInt(e.length)]);
        }
        this.f = stringBuilder.toString();
        this.g = ("--" + this.f + b).getBytes();
        this.h = ("--" + this.f + "--" + b).getBytes();
        this.l = s;
    }

    private String a(String str) {
        return str == null ? O.a : str;
    }

    private void a(int i) {
        this.m += i;
        this.l.sendProgressMessage(this.m, this.n);
    }

    private byte[] b(String str) {
        return ("Content-Type: " + a(str) + b).getBytes();
    }

    private byte[] b(String str, String str2) {
        return ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"" + b).getBytes();
    }

    private byte[] c(String str) {
        return ("Content-Disposition: form-data; name=\"" + str + "\"" + b).getBytes();
    }

    public void a(String str, File file) {
        a(str, file, null);
    }

    public void a(String str, File file, String str2) {
        this.j.add(new W(this, str, file, a(str2)));
    }

    public void a(String str, String str2) {
        a(str, str2, "text/plain; charset=UTF-8");
    }

    public void a(String str, String str2, InputStream inputStream, String str3) {
        this.k.write(this.g);
        this.k.write(b(str, str2));
        this.k.write(b(str3));
        this.k.write(d);
        this.k.write(c);
        byte[] bArr = new byte[ChartData.d];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                this.k.write(bArr, 0, read);
            } else {
                this.k.write(c);
                this.k.flush();
                C1012a.a(this.k);
                return;
            }
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            this.k.write(this.g);
            this.k.write(c(str));
            this.k.write(b(str3));
            this.k.write(c);
            this.k.write(str2.getBytes());
            this.k.write(c);
        } catch (Throwable e) {
            Log.e(a, "addPart ByteArrayOutputStream exception", e);
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() {
        throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        long size = (long) this.k.size();
        long j = size;
        for (W a : this.j) {
            size = a.a();
            if (size < 0) {
                return -1;
            }
            j = size + j;
        }
        return ((long) this.h.length) + j;
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.f);
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return this.i;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        this.m = 0;
        this.n = (int) getContentLength();
        this.k.writeTo(outputStream);
        a(this.k.size());
        for (W a : this.j) {
            a.a(outputStream);
        }
        outputStream.write(this.h);
        a(this.h.length);
    }
}
