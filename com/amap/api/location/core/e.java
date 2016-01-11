package com.amap.api.location.core;

import android.content.Context;
import com.d.a.a.h;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import kankan.wheel.widget.a;

public class e {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static String a(String str) {
        String str2 = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    str2 = b("MD5", b("SHA1", str) + str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str2;
    }

    static String a(String str, String str2) {
        byte[] b;
        try {
            b = b(str);
        } catch (Exception e) {
            e.printStackTrace();
            b = null;
        }
        byte[] a = a(b, str2);
        if (a == null) {
            return null;
        }
        try {
            return new String(a, h.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr) {
        int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(a[(bArr[i] >> 4) & 15]);
            stringBuilder.append(a[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }

    static PublicKey a(Context context) {
        try {
            InputStream open = context.getAssets().open("location_public_key.der");
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            KeyFactory instance2 = KeyFactory.getInstance("RSA");
            Certificate generateCertificate = instance.generateCertificate(open);
            open.close();
            return instance2.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
        } catch (IOException e) {
            return null;
        } catch (CertificateException e2) {
            return null;
        } catch (NoSuchAlgorithmException e3) {
            throw new Exception("\u65e0\u6b64\u7b97\u6cd5");
        } catch (InvalidKeySpecException e4) {
            throw new Exception("\u516c\u94a5\u975e\u6cd5");
        } catch (NullPointerException e5) {
            throw new Exception("\u516c\u94a5\u6570\u636e\u4e3a\u7a7a");
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            Key c = c(str);
            Cipher instance = Cipher.getInstance("AES/ECB/ZeroBytePadding");
            instance.init(2, c);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static byte[] a(byte[] bArr, Key key) {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        try {
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, secretKeySpec);
            bArr3 = instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bArr3;
    }

    private static String b(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(str2.getBytes(a.bO));
            return a(instance.digest());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] b(String str) {
        int i = 0;
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String toLowerCase = str.toLowerCase();
        int length = toLowerCase.length() / 2;
        byte[] bArr = new byte[length];
        while (i < length) {
            bArr[i] = (byte) (Integer.parseInt(toLowerCase.substring(i * 2, (i * 2) + 2), 16) & HeartRateInfo.HR_EMPTY_VALUE);
            i++;
        }
        return bArr;
    }

    private static SecretKeySpec c(String str) {
        byte[] bArr = null;
        if (str == null) {
            str = com.xiaomi.e.a.f;
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append(Constants.VIA_RESULT_SUCCESS);
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes(h.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new SecretKeySpec(bArr, "AES");
    }
}
