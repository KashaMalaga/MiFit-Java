package b.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.a.a.a.C0910s;
import com.a.a.a.C0912u;
import com.activeandroid.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class C0352cm {
    public static final String a = System.getProperty("line.separator");
    private static final String b = "helper";

    public static String a() {
        return C0352cm.a(new Date());
    }

    public static String a(Context context, long j) {
        String str = a.f;
        return j < 1000 ? ((int) j) + "B" : j < 1000000 ? new StringBuilder(String.valueOf(Math.round(((double) ((float) j)) / 1000.0d))).append(C0910s.a).toString() : j < 1000000000 ? new StringBuilder(String.valueOf(new DecimalFormat("#0.0").format(((double) ((float) j)) / 1000000.0d))).append(C0912u.b).toString() : new StringBuilder(String.valueOf(new DecimalFormat("#0.00").format(((double) ((float) j)) / 1.0E9d))).append("G").toString();
    }

    public static String a(File file) {
        byte[] bArr = new byte[b.a];
        try {
            if (!file.isFile()) {
                return a.f;
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, b.a);
                if (read == -1) {
                    fileInputStream.close();
                    BigInteger bigInteger = new BigInteger(1, instance.digest());
                    return String.format("%1$032x", new Object[]{bigInteger});
                }
                instance.update(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[b.a];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bytes);
            bytes = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bytes[i])}));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", a.f);
        }
    }

    public static String a(Date date) {
        return date == null ? a.f : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
    }

    public static void a(Context context, String str) {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
    }

    public static void a(File file, String str) {
        C0352cm.a(file, str.getBytes());
    }

    public static void a(File file, byte[] bArr) {
        OutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
        } finally {
            C0352cm.a(fileOutputStream);
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public static String b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString(b & HeartRateInfo.HR_EMPTY_VALUE));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            bX.a(b, "getMD5 error", e);
            return a.f;
        }
    }

    public static boolean b(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[b.a];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String c(String str) {
        String str2 = a.f;
        try {
            long longValue = Long.valueOf(str).longValue();
            return longValue < PlaybackStateCompat.k ? ((int) longValue) + "B" : longValue < 1048576 ? new StringBuilder(String.valueOf(new DecimalFormat("#0.00").format(((double) ((float) longValue)) / 1024.0d))).append(C0910s.a).toString() : longValue < 1073741824 ? new StringBuilder(String.valueOf(new DecimalFormat("#0.00").format(((double) ((float) longValue)) / 1048576.0d))).append(C0912u.b).toString() : new StringBuilder(String.valueOf(new DecimalFormat("#0.00").format(((double) ((float) longValue)) / 1.073741824E9d))).append("G").toString();
        } catch (NumberFormatException e) {
            return str;
        }
    }

    public static void c(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public static boolean d(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean e(String str) {
        if (C0352cm.d(str)) {
            return false;
        }
        String toLowerCase = str.trim().toLowerCase(Locale.US);
        return toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://");
    }
}
