package com.xiaomi.market.sdk;

import android.text.TextUtils;
import android.util.Base64;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.tencent.connect.common.Constants;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class g {
    static final String a = "AES/CBC/PKCS5Padding";
    private static final String[] b = new String[]{Constants.VIA_RESULT_SUCCESS, Constants.VIA_TO_TYPE_QQ_GROUP, Constants.VIA_SSO_LOGIN, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP, Constants.VIA_TO_TYPE_QZONE, Constants.VIA_SHARE_TYPE_TEXT, Constants.VIA_SHARE_TYPE_INFO, "7", "8", "9", c.b, c.d, GroupItemBaseInfo.KEY_COUNT, "d", GroupItemBaseInfo.KEY_END_TIME, "f"};

    private static String a(byte b) {
        int i;
        if (b < (byte) 0) {
            i = b + PersonInfo.INCOMING_CALL_DISABLE_BIT;
        }
        return new StringBuilder(String.valueOf(b[i / 16])).append(b[i % 16]).toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final java.lang.String a(java.io.File r6) {
        /*
        r0 = 0;
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0022 }
        r2.<init>(r6);	 Catch:{ FileNotFoundException -> 0x0022 }
        r3 = "MD5";
        r3 = java.security.MessageDigest.getInstance(r3);	 Catch:{ NoSuchAlgorithmException -> 0x002c, IOException -> 0x0039 }
    L_0x0010:
        r4 = r2.read(r1);	 Catch:{ NoSuchAlgorithmException -> 0x002c, IOException -> 0x0039 }
        if (r4 > 0) goto L_0x0027;
    L_0x0016:
        r2.close();	 Catch:{ IOException -> 0x0050 }
    L_0x0019:
        r0 = r3.digest();
        r0 = b(r0);
    L_0x0021:
        return r0;
    L_0x0022:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0021;
    L_0x0027:
        r5 = 0;
        r3.update(r1, r5, r4);	 Catch:{ NoSuchAlgorithmException -> 0x002c, IOException -> 0x0039 }
        goto L_0x0010;
    L_0x002c:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0046 }
        r2.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x0021;
    L_0x0034:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0021;
    L_0x0039:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0046 }
        r2.close();	 Catch:{ IOException -> 0x0041 }
        goto L_0x0021;
    L_0x0041:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0021;
    L_0x0046:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x004b }
    L_0x004a:
        throw r0;
    L_0x004b:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x004a;
    L_0x0050:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.market.sdk.g.a(java.io.File):java.lang.String");
    }

    static final String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return b(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str2;
        }
    }

    static final String a(String str, String str2) {
        String str3 = null;
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            byte[] g = g(str2);
            if (g != null && g.length == 16) {
                Key secretKeySpec = new SecretKeySpec(g, "AES");
                try {
                    Cipher instance = Cipher.getInstance(a);
                    instance.init(1, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
                    str3 = a(instance.doFinal(str.getBytes()));
                } catch (NoSuchAlgorithmException e) {
                } catch (NoSuchPaddingException e2) {
                } catch (InvalidKeyException e3) {
                } catch (InvalidAlgorithmParameterException e4) {
                } catch (IllegalBlockSizeException e5) {
                } catch (BadPaddingException e6) {
                }
            }
        }
        return str3;
    }

    static final String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    static final String b(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA");
            instance.update(str.getBytes());
            return b(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str2;
        }
    }

    static final String b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] g = g(str2);
        if (g == null || g.length != 16) {
            return null;
        }
        Key secretKeySpec = new SecretKeySpec(g, "AES");
        try {
            Cipher instance = Cipher.getInstance(a);
            instance.init(2, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
            byte[] g2 = g(str);
            return g2 != null ? new String(instance.doFinal(g2)) : null;
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (NoSuchPaddingException e2) {
            return null;
        } catch (InvalidKeyException e3) {
            return null;
        } catch (InvalidAlgorithmParameterException e4) {
            return null;
        } catch (IllegalBlockSizeException e5) {
            return null;
        } catch (BadPaddingException e6) {
            return null;
        }
    }

    private static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte a : bArr) {
            stringBuffer.append(a(a));
        }
        return stringBuffer.toString();
    }

    static final byte[] c(String str) {
        byte[] bArr = null;
        if (TextUtils.isEmpty(str)) {
            return bArr;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA");
            instance.update(str.getBytes());
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return bArr;
        }
    }

    static final String d(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    static final byte[] e(String str) {
        return Base64.encode(str.getBytes(), 2);
    }

    static final String f(String str) {
        return new String(Base64.decode(str, 0));
    }

    static final byte[] g(String str) {
        return Base64.decode(str, 0);
    }
}
