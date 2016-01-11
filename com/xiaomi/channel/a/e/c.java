package com.xiaomi.channel.a.e;

import android.support.v4.media.h;
import android.support.v4.view.a.C0113o;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c {
    private static String a(byte b) {
        int i = (b & h.j) + (b < (byte) 0 ? C0113o.h : 0);
        return (i < 16 ? Constants.VIA_RESULT_SUCCESS : a.f) + Integer.toHexString(i).toLowerCase();
    }

    public static String a(String str) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            while (i < digest.length) {
                stringBuffer.append(a(digest[i]));
                i++;
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String b(String str) {
        return a(str).subSequence(8, 24).toString();
    }
}
