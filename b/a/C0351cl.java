package b.a;

import com.activeandroid.b;
import com.d.a.a.C1012a;
import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class C0351cl {
    public static int a;

    public static String a(byte[] bArr, String str) {
        byte[] b = C0351cl.b(bArr);
        return b != null ? new String(b, str) : null;
    }

    public static byte[] a(String str, String str2) {
        return C0352cm.d(str) ? null : C0351cl.a(str.getBytes(str2));
    }

    public static byte[] a(byte[] bArr) {
        Throwable th;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[C1012a.e];
        a = 0;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    a += deflate;
                    byteArrayOutputStream.write(bArr2, 0, deflate);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            deflater.end();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            Throwable th4 = th3;
            byteArrayOutputStream = null;
            th = th4;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }

    public static byte[] b(byte[] bArr) {
        int i = 0;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Inflater inflater = new Inflater();
        inflater.setInput(bArr, 0, bArr.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[b.a];
        while (!inflater.needsInput()) {
            int inflate = inflater.inflate(bArr2);
            byteArrayOutputStream.write(bArr2, i, inflate);
            i += inflate;
        }
        inflater.end();
        return byteArrayOutputStream.toByteArray();
    }
}
