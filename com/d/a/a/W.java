package com.d.a.a;

import android.util.Log;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

class W {
    public File a;
    public byte[] b;
    final /* synthetic */ V c;

    public W(V v, String str, File file, String str2) {
        this.c = v;
        this.b = a(str, file.getName(), str2);
        this.a = file;
    }

    private byte[] a(String str, String str2, String str3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.c.g);
            byteArrayOutputStream.write(this.c.b(str, str2));
            byteArrayOutputStream.write(this.c.b(str3));
            byteArrayOutputStream.write(V.d);
            byteArrayOutputStream.write(V.c);
        } catch (Throwable e) {
            Log.e("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public long a() {
        return (this.a.length() + ((long) V.c.length)) + ((long) this.b.length);
    }

    public void a(OutputStream outputStream) {
        outputStream.write(this.b);
        this.c.a(this.b.length);
        InputStream fileInputStream = new FileInputStream(this.a);
        byte[] bArr = new byte[ChartData.d];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                this.c.a(read);
            } else {
                outputStream.write(V.c);
                this.c.a(V.c.length);
                outputStream.flush();
                C1012a.a(fileInputStream);
                return;
            }
        }
    }
}
