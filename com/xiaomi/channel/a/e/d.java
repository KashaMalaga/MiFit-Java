package com.xiaomi.channel.a.e;

import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.d.a.a.h;
import com.xiaomi.e.a;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class d {
    public static String a(int i) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".length())));
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(b(str));
            BigInteger bigInteger = new BigInteger(1, instance.digest());
            return String.format("%1$032X", new Object[]{bigInteger});
        } catch (NoSuchAlgorithmException e) {
            return str;
        }
    }

    public static String a(Collection<?> collection, String str) {
        return collection == null ? null : a(collection.iterator(), str);
    }

    public static String a(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return a.f;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return next.toString();
        }
        StringBuffer stringBuffer = new StringBuffer(PersonInfo.INCOMING_CALL_DISABLE_BIT);
        if (next != null) {
            stringBuffer.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                stringBuffer.append(str);
            }
            next = it.next();
            if (next != null) {
                stringBuffer.append(next);
            }
        }
        return stringBuffer.toString();
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes(h.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }
}
