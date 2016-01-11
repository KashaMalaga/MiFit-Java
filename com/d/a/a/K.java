package com.d.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.mipush.sdk.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

public class K implements CookieStore {
    private static final String a = "PersistentCookieStore";
    private static final String b = "CookiePrefsFile";
    private static final String c = "names";
    private static final String d = "cookie_";
    private boolean e = false;
    private final ConcurrentHashMap<String, Cookie> f;
    private final SharedPreferences g;

    public K(Context context) {
        int i = 0;
        this.g = context.getSharedPreferences(b, 0);
        this.f = new ConcurrentHashMap();
        String string = this.g.getString(c, null);
        if (string != null) {
            String[] split = TextUtils.split(string, f.i);
            int length = split.length;
            while (i < length) {
                String str = split[i];
                String string2 = this.g.getString(d + str, null);
                if (string2 != null) {
                    Cookie a = a(string2);
                    if (a != null) {
                        this.f.put(str, a);
                    }
                }
                i++;
            }
            clearExpired(new Date());
        }
    }

    protected String a(U u) {
        if (u == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(u);
            return a(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            return null;
        }
    }

    protected String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & HeartRateInfo.HR_EMPTY_VALUE;
            if (i < 16) {
                stringBuilder.append('0');
            }
            stringBuilder.append(Integer.toHexString(i));
        }
        return stringBuilder.toString().toUpperCase(Locale.US);
    }

    protected Cookie a(String str) {
        try {
            return ((U) new ObjectInputStream(new ByteArrayInputStream(b(str))).readObject()).a();
        } catch (Throwable e) {
            Log.d(a, "decodeCookie failed", e);
            return null;
        }
    }

    public void a(Cookie cookie) {
        String name = cookie.getName();
        this.f.remove(name);
        Editor edit = this.g.edit();
        edit.remove(d + name);
        edit.commit();
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void addCookie(Cookie cookie) {
        if (!this.e || cookie.isPersistent()) {
            String str = cookie.getName() + cookie.getDomain();
            if (cookie.isExpired(new Date())) {
                this.f.remove(str);
            } else {
                this.f.put(str, cookie);
            }
            Editor edit = this.g.edit();
            edit.putString(c, TextUtils.join(f.i, this.f.keySet()));
            edit.putString(d + str, a(new U(cookie)));
            edit.commit();
        }
    }

    protected byte[] b(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public void clear() {
        Editor edit = this.g.edit();
        for (String str : this.f.keySet()) {
            edit.remove(d + str);
        }
        edit.remove(c);
        edit.commit();
        this.f.clear();
    }

    public boolean clearExpired(Date date) {
        Editor edit = this.g.edit();
        boolean z = false;
        for (Entry entry : this.f.entrySet()) {
            boolean z2;
            String str = (String) entry.getKey();
            if (((Cookie) entry.getValue()).isExpired(date)) {
                this.f.remove(str);
                edit.remove(d + str);
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        if (z) {
            edit.putString(c, TextUtils.join(f.i, this.f.keySet()));
        }
        edit.commit();
        return z;
    }

    public List<Cookie> getCookies() {
        return new ArrayList(this.f.values());
    }
}
