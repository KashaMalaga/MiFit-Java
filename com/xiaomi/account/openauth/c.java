package com.xiaomi.account.openauth;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.d;
import java.io.File;
import java.net.URLEncoder;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kankan.wheel.widget.a;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class c {
    public static final boolean a = new File("/data/system/oauth_staging_preview").exists();
    public static final String b = (a ? "http://account.preview.n.xiaomi.net" : "https://account.xiaomi.com");
    private static final String c = "HmacSHA1";
    private static final String d = "UTF-8";
    private static Random e = new Random();

    protected static String a() {
        return e.nextLong() + a.ci + ((int) (System.currentTimeMillis() / d.g));
    }

    protected static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (c.equalsIgnoreCase(str7)) {
            StringBuilder stringBuilder = new StringBuilder(com.xiaomi.e.a.f);
            stringBuilder.append(str + "\n");
            stringBuilder.append(str2.toUpperCase() + "\n");
            stringBuilder.append(str3 + "\n");
            stringBuilder.append(str4 + "\n");
            if (!TextUtils.isEmpty(str5)) {
                StringBuffer stringBuffer = new StringBuffer();
                List arrayList = new ArrayList();
                URLEncodedUtils.parse(arrayList, new Scanner(str5), d);
                Collections.sort(arrayList, new d());
                stringBuffer.append(URLEncodedUtils.format(arrayList, d));
                stringBuilder.append(stringBuffer.toString() + "\n");
            }
            return a(a(stringBuilder.toString().getBytes(d), str6.getBytes(d)));
        }
        throw new NoSuchAlgorithmException("error mac algorithm : " + str7);
    }

    protected static String a(String str, List<NameValuePair> list) {
        if (list == null || list.size() <= 0) {
            return str;
        }
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (NameValuePair nameValuePair : list) {
            buildUpon.appendQueryParameter(nameValuePair.getName(), nameValuePair.getValue());
        }
        return buildUpon.build().toString();
    }

    protected static String a(byte[] bArr) {
        return new String(com.xiaomi.account.openauth.a.a.b(bArr));
    }

    protected static HashMap<String, String> a(String str, String str2, String str3) {
        String format = String.format("MAC access_token=\"%s\", nonce=\"%s\",mac=\"%s\"", new Object[]{URLEncoder.encode(str, d), URLEncoder.encode(str2, d), URLEncoder.encode(str3, d)});
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("Authorization", format);
        return hashMap;
    }

    protected static byte[] a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, c);
        Mac instance = Mac.getInstance(c);
        instance.init(secretKeySpec);
        instance.update(bArr);
        return instance.doFinal();
    }
}
