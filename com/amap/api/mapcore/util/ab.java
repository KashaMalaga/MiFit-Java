package com.amap.api.mapcore.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kankan.wheel.widget.a;

public class ab {
    public static String a(String str) {
        return str == null ? null : ae.c(c(str));
    }

    public static String a(byte[] bArr) {
        return ae.c(b(bArr));
    }

    public static String b(String str) {
        return ae.d(d(str));
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            bArr2 = instance.digest();
        } catch (Throwable e) {
            az.a(e, "MD5", "getMd5Bytes");
            e.printStackTrace();
        } catch (Throwable e2) {
            az.a(e2, "MD5", "getMd5Bytes1");
            e2.printStackTrace();
        }
        return bArr2;
    }

    public static byte[] c(String str) {
        try {
            return e(str);
        } catch (Throwable e) {
            az.a(e, "MD5", "getMd5Bytes");
            e.printStackTrace();
            return new byte[0];
        } catch (Throwable e2) {
            az.a(e2, "MD5", "getMd5Bytes");
            e2.printStackTrace();
            return new byte[0];
        } catch (Throwable e22) {
            az.a(e22, "MD5", "getMd5Bytes");
            e22.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] d(String str) {
        try {
            return e(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return new byte[0];
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] e(String str) {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(str.getBytes(a.bO));
        return instance.digest();
    }
}
