package com.b;

import com.amap.api.location.core.b;
import com.d.a.a.h;
import com.xiaomi.e.a;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class E {
    private String a = "AES/CBC/PKCS5Padding";
    private Cipher b = null;

    E() {
        try {
            Key secretKeySpec = new SecretKeySpec("#a@u!t*o(n)a&v^i".getBytes(h.DEFAULT_CHARSET), "AES");
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec("_a+m-a=p?a>p<s%3".getBytes(h.DEFAULT_CHARSET));
            this.b = Cipher.getInstance(this.a);
            this.b.init(2, secretKeySpec, ivParameterSpec);
        } catch (Throwable th) {
            th.printStackTrace();
            ao.a(th);
        }
    }

    public static String a(byte[] bArr) {
        String str = a.f;
        if (bArr != null) {
            try {
                str = b.a(bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str;
    }

    private byte[] a(String str) {
        byte[] bArr = null;
        if (!(str == null || str.length() == 0 || str.length() % 2 != 0)) {
            try {
                bArr = new byte[(str.length() / 2)];
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < str.length(); i += 2) {
                    stringBuilder.delete(0, stringBuilder.length());
                    stringBuilder.append("0X");
                    stringBuilder.append(str.substring(i, i + 2));
                    bArr[i / 2] = (byte) Integer.decode(stringBuilder.toString()).intValue();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                ao.a(th);
            }
        }
        return bArr;
    }

    String a(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return new String(this.b.doFinal(a(str)), str2);
        } catch (Throwable e) {
            ao.a(e);
            return null;
        }
    }
}
