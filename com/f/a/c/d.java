package com.f.a.c;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d {
    public static final int a = 32768;
    public static final int b = 75;

    private d() {
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
        }
    }

    public static void a(InputStream inputStream) {
        while (true) {
            try {
                if (inputStream.read(new byte[a], 0, a) == -1) {
                    break;
                }
            } catch (IOException e) {
            } finally {
                a((Closeable) inputStream);
            }
        }
    }

    private static boolean a(e eVar, int i, int i2) {
        return (eVar == null || eVar.a(i, i2) || (i * 100) / i2 >= b) ? false : true;
    }

    public static boolean a(InputStream inputStream, OutputStream outputStream, e eVar) {
        return a(inputStream, outputStream, eVar, a);
    }

    public static boolean a(InputStream inputStream, OutputStream outputStream, e eVar, int i) {
        int available = inputStream.available();
        byte[] bArr = new byte[i];
        if (a(eVar, 0, available)) {
            return false;
        }
        int i2 = 0;
        do {
            int read = inputStream.read(bArr, 0, i);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i2 += read;
            } else {
                outputStream.flush();
                return true;
            }
        } while (!a(eVar, i2, available));
        return false;
    }
}
