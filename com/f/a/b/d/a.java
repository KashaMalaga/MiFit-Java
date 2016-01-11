package com.f.a.b.d;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import cn.com.smartdevices.bracelet.location.e;
import com.f.a.c.d;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import kankan.wheel.widget.l;

public class a implements c {
    public static final int a = 5000;
    public static final int b = 20000;
    protected static final int c = 32768;
    protected static final String d = "@#&=*+-_.,:!?()/~'%";
    protected static final int e = 5;
    protected static final String f = "content://com.android.contacts/";
    private static final String j = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    protected final Context g;
    protected final int h;
    protected final int i;

    public a(Context context) {
        this.g = context.getApplicationContext();
        this.h = a;
        this.i = b;
    }

    public a(Context context, int i, int i2) {
        this.g = context.getApplicationContext();
        this.h = i;
        this.i = i2;
    }

    public InputStream a(String str, Object obj) {
        switch (b.a[d.a(str).ordinal()]) {
            case l.a /*1*/:
            case kankan.wheel.widget.a.k /*2*/:
                return b(str, obj);
            case kankan.wheel.widget.a.l /*3*/:
                return d(str, obj);
            case kankan.wheel.widget.a.aQ /*4*/:
                return e(str, obj);
            case e /*5*/:
                return f(str, obj);
            case kankan.wheel.widget.a.bt /*6*/:
                return g(str, obj);
            default:
                return h(str, obj);
        }
    }

    protected InputStream b(String str, Object obj) {
        HttpURLConnection c = c(str, obj);
        int i = 0;
        while (c.getResponseCode() / 100 == 3 && i < e) {
            c = c(c.getHeaderField(e.e), obj);
            i++;
        }
        try {
            return new com.f.a.b.a.a(new BufferedInputStream(c.getInputStream(), c), c.getContentLength());
        } catch (IOException e) {
            d.a(c.getErrorStream());
            throw e;
        }
    }

    protected HttpURLConnection c(String str, Object obj) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, d)).openConnection();
        httpURLConnection.setConnectTimeout(this.h);
        httpURLConnection.setReadTimeout(this.i);
        return httpURLConnection;
    }

    protected InputStream d(String str, Object obj) {
        String c = d.FILE.c(str);
        return new com.f.a.b.a.a(new BufferedInputStream(new FileInputStream(c), c), (int) new File(c).length());
    }

    protected InputStream e(String str, Object obj) {
        ContentResolver contentResolver = this.g.getContentResolver();
        Uri parse = Uri.parse(str);
        return str.startsWith(f) ? Contacts.openContactPhotoInputStream(contentResolver, parse) : contentResolver.openInputStream(parse);
    }

    protected InputStream f(String str, Object obj) {
        return this.g.getAssets().open(d.ASSETS.c(str));
    }

    protected InputStream g(String str, Object obj) {
        return this.g.getResources().openRawResource(Integer.parseInt(d.DRAWABLE.c(str)));
    }

    protected InputStream h(String str, Object obj) {
        throw new UnsupportedOperationException(String.format(j, new Object[]{str}));
    }
}
