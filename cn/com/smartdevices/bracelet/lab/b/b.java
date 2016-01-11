package cn.com.smartdevices.bracelet.lab.b;

import android.util.Log;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;

public final class b {
    private static final String b = "MD5Helper";
    private static final char[] c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final b d = new b();
    private MessageDigest a = null;

    private b() {
        try {
            this.a = MessageDigest.getInstance("MD5");
        } catch (Throwable e) {
            Log.e(b, e.getMessage(), e);
        }
    }

    private static b a() {
        return d;
    }

    public static String a(String str) {
        return str == null ? null : a().b(str.getBytes());
    }

    private String a(ByteBuffer byteBuffer) {
        String b;
        synchronized (this.a) {
            c(byteBuffer);
            b = b();
        }
        return b;
    }

    public static String a(byte[] bArr) {
        return bArr == null ? null : a().b(bArr);
    }

    public static byte[] a(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] a = a(fileInputStream);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                }
                return a;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static byte[] a(FileInputStream fileInputStream) {
        return a().b(fileInputStream.getChannel().map(MapMode.READ_ONLY, 0, (long) fileInputStream.available()));
    }

    private String b() {
        if (this.a == null) {
            Log.d(b, "MessageDigest for MD5 initialization failed.");
            return null;
        }
        byte[] digest = this.a.digest();
        StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
        for (byte b : digest) {
            char c = c[(b & RunningReminderInfo.b) >> 4];
            char c2 = c[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }

    public static String b(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String b = b(fileInputStream);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                }
                return b;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static String b(FileInputStream fileInputStream) {
        return a().a(fileInputStream.getChannel().map(MapMode.READ_ONLY, 0, (long) fileInputStream.available()));
    }

    private String b(byte[] bArr) {
        String b;
        synchronized (this.a) {
            c(bArr);
            b = b();
        }
        return b;
    }

    private byte[] b(ByteBuffer byteBuffer) {
        if (this.a == null) {
            Log.d(b, "MessageDigest for MD5 initialization failed.");
            return null;
        }
        byte[] digest;
        synchronized (this.a) {
            c(byteBuffer);
            digest = this.a.digest();
        }
        return digest;
    }

    private void c(ByteBuffer byteBuffer) {
        if (this.a != null) {
            this.a.update(byteBuffer);
        } else {
            Log.d(b, "MessageDigest for MD5 initialization failed.");
        }
    }

    private void c(byte[] bArr) {
        if (this.a != null) {
            this.a.update(bArr);
        } else {
            Log.d(b, "MessageDigest for MD5 initialization failed.");
        }
    }
}
