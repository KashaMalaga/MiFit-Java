package com.amap.api.services.core;

import android.content.Context;
import com.xiaomi.e.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class h {
    public static PublicKey a(Context context) {
        try {
            InputStream open = context.getAssets().open("search_public_key.der");
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

    public static byte[] a(byte[] bArr) {
        byte[] toByteArray;
        Exception e;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return toByteArray;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            toByteArray = null;
            e = exception;
            e.printStackTrace();
            return toByteArray;
        }
        return toByteArray;
    }

    public static byte[] a(byte[] bArr, Key key) {
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

    public static String b(byte[] bArr) {
        return bArr != null ? a.a(bArr) : a.f;
    }
}
