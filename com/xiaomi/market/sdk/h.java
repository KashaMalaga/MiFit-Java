package com.xiaomi.market.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.activeandroid.b;
import com.d.a.a.C1012a;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.b.v;
import com.xiaomi.e.a;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class h {
    protected static final String a = "http";
    private static final String l = "MarketConnection";
    private static final int m = 10000;
    private static final int n = 10000;
    private static final int o = 30000;
    protected JSONObject b;
    protected URL c;
    protected m d;
    protected String e;
    protected boolean f;
    protected boolean g;
    protected boolean h;
    protected boolean i;
    protected boolean j;
    protected boolean k;

    public h(String str) {
        this(str, false);
    }

    public h(String str, String str2) {
        this(a(str, str2), false);
    }

    public h(String str, boolean z) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            Log.e(l, "URL error: " + e);
            url = null;
        }
        b(url);
        this.k = z;
    }

    private l a(int i) {
        if (i == v.C) {
            return l.OK;
        }
        Log.e(l, "Network Error : " + i);
        return l.SERVER_ERROR;
    }

    private l a(String str, String str2, boolean z, boolean z2, n nVar) {
        Object e;
        Throwable th;
        HttpURLConnection httpURLConnection;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            HttpURLConnection a;
            String str3 = (String) it.next();
            if (x.b) {
                Log.d(l, "hosted connection url: " + str3);
            }
            try {
                URL url = new URL(str3);
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(n);
                        if (x.d(d.b())) {
                            httpURLConnection2.setReadTimeout(n);
                        } else {
                            httpURLConnection2.setReadTimeout(o);
                        }
                        if (z) {
                            httpURLConnection2.setRequestMethod(Constants.HTTP_GET);
                            httpURLConnection2.setDoOutput(false);
                        } else {
                            httpURLConnection2.setRequestMethod(Constants.HTTP_POST);
                            httpURLConnection2.setDoOutput(true);
                        }
                        try {
                            a = a(httpURLConnection2);
                            try {
                                a.connect();
                                if (!(z || TextUtils.isEmpty(str2))) {
                                    OutputStream outputStream = a.getOutputStream();
                                    outputStream.write(str2.getBytes());
                                    if (x.b) {
                                        Log.d(l, "[post]" + str2);
                                    }
                                    outputStream.close();
                                }
                                l a2 = a(a.getResponseCode());
                                if (a2 == l.OK && nVar != null) {
                                    BufferedInputStream bufferedInputStream;
                                    try {
                                        bufferedInputStream = new BufferedInputStream(a.getInputStream(), C1012a.e);
                                        try {
                                            byte[] bArr = new byte[b.a];
                                            while (true) {
                                                int read = bufferedInputStream.read(bArr, 0, b.a);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                nVar.write(bArr, 0, read);
                                            }
                                            nVar.flush();
                                            if (bufferedInputStream != null) {
                                                bufferedInputStream.close();
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        bufferedInputStream = null;
                                        try {
                                            Log.e(l, "Connection Exception for " + url.getHost() + " : read file stream error " + e);
                                            nVar.a();
                                            if (bufferedInputStream != null) {
                                                bufferedInputStream.close();
                                            }
                                            if (a != null) {
                                                a.disconnect();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (bufferedInputStream != null) {
                                                bufferedInputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        bufferedInputStream = null;
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                        }
                                        throw th;
                                    }
                                }
                                if (a == null) {
                                    return a2;
                                }
                                a.disconnect();
                                return a2;
                            } catch (Exception e4) {
                                e = e4;
                                httpURLConnection = a;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (i e5) {
                            l lVar = e5.a;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            return lVar;
                        }
                    } catch (Exception e6) {
                        Exception exception = e6;
                        httpURLConnection = httpURLConnection2;
                        e = exception;
                    } catch (Throwable th5) {
                        a = httpURLConnection2;
                        th = th5;
                    }
                } catch (Exception e7) {
                    e = e7;
                    httpURLConnection = null;
                    try {
                        Log.e(l, "Connection Exception for " + url.getHost() + " :" + e);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        a = httpURLConnection;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    a = null;
                }
            } catch (MalformedURLException e8) {
                Log.e(l, " URL error :" + e8);
            }
        }
        return l.NETWORK_ERROR;
        if (a != null) {
            a.disconnect();
        }
        throw th;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        Object substring;
        if (str.charAt(str.length() - 1) == '/') {
            substring = str.substring(0, str.length() - 1);
        }
        if (str2.charAt(0) == '/') {
            str2 = str2.substring(1);
        }
        return new StringBuilder(String.valueOf(substring)).append("/").append(str2).toString();
    }

    private void b(URL url) {
        this.f = true;
        this.g = false;
        this.h = true;
        this.i = true;
        this.j = true;
        if (a(url)) {
            this.c = url;
        }
    }

    protected l a(n nVar) {
        if (this.c == null) {
            return l.URL_ERROR;
        }
        if (!x.c(d.b())) {
            return l.NETWORK_ERROR;
        }
        if (this.d == null) {
            getClass();
            this.d = new m(this);
        }
        m mVar = this.d;
        try {
            String url;
            m a = a(this.d);
            String url2 = this.c.toString();
            if (this.g && !a.a()) {
                CharSequence query = this.c.getQuery();
                url = this.c.toString();
                url2 = TextUtils.isEmpty(query) ? new StringBuilder(String.valueOf(url)).append("?").append(a.toString()).toString() : new StringBuilder(String.valueOf(url)).append("&").append(a.toString()).toString();
            }
            try {
                url = a(url2, a);
                if (x.b) {
                    Log.d(l, "connection url: " + url);
                }
                String str = a.f;
                if (!this.g) {
                    str = a.toString();
                }
                long currentTimeMillis = System.currentTimeMillis();
                l a2 = a(url, str, this.g, false, nVar);
                if (!x.b) {
                    return a2;
                }
                Log.d(l, "Time(ms) spent in request: " + (System.currentTimeMillis() - currentTimeMillis) + ", " + url);
                return a2;
            } catch (i e) {
                return e.a;
            }
        } catch (i e2) {
            return e2.a;
        }
    }

    public l a(File file) {
        if (file == null) {
            throw new IllegalArgumentException();
        }
        try {
            n jVar = new j(this, file);
            l a = a(jVar);
            try {
                jVar.close();
                if (a != l.OK) {
                    Log.e(l, "Connection failed : " + a);
                    file.delete();
                }
            } catch (IOException e) {
            }
            return a;
        } catch (FileNotFoundException e2) {
            Log.e(l, "File not found: " + e2);
            throw e2;
        }
    }

    protected m a(m mVar) {
        return mVar;
    }

    protected String a(String str, m mVar) {
        return str;
    }

    protected HttpURLConnection a(HttpURLConnection httpURLConnection) {
        return httpURLConnection;
    }

    public JSONObject a() {
        return this.b;
    }

    public void a(boolean z) {
        this.g = z;
    }

    protected boolean a(URL url) {
        return url != null && TextUtils.equals(url.getProtocol(), a);
    }

    public String b() {
        return this.e;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public m c() {
        return this.d;
    }

    public void c(boolean z) {
        this.h = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.xiaomi.market.sdk.l d() {
        /*
        r5 = this;
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r0 = new com.xiaomi.market.sdk.k;
        r0.<init>(r5, r1);
        r0 = r5.a(r0);
        r2 = com.xiaomi.market.sdk.l.OK;	 Catch:{ JSONException -> 0x0036 }
        if (r0 != r2) goto L_0x0021;
    L_0x0012:
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0036 }
        r3 = r1.toString();	 Catch:{ JSONException -> 0x0036 }
        r2.<init>(r3);	 Catch:{ JSONException -> 0x0036 }
        r5.b = r2;	 Catch:{ JSONException -> 0x0036 }
    L_0x001d:
        r1.close();	 Catch:{ IOException -> 0x005a }
    L_0x0020:
        return r0;
    L_0x0021:
        r2 = "MarketConnection";
        r3 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0036 }
        r4 = "Connection failed : ";
        r3.<init>(r4);	 Catch:{ JSONException -> 0x0036 }
        r3 = r3.append(r0);	 Catch:{ JSONException -> 0x0036 }
        r3 = r3.toString();	 Catch:{ JSONException -> 0x0036 }
        android.util.Log.e(r2, r3);	 Catch:{ JSONException -> 0x0036 }
        goto L_0x001d;
    L_0x0036:
        r0 = move-exception;
        r2 = "MarketConnection";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0053 }
        r4 = "JSON error: ";
        r3.<init>(r4);	 Catch:{ all -> 0x0053 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x0053 }
        r0 = r0.toString();	 Catch:{ all -> 0x0053 }
        android.util.Log.e(r2, r0);	 Catch:{ all -> 0x0053 }
        r0 = com.xiaomi.market.sdk.l.RESULT_ERROR;	 Catch:{ all -> 0x0053 }
        r1.close();	 Catch:{ IOException -> 0x0051 }
        goto L_0x0020;
    L_0x0051:
        r1 = move-exception;
        goto L_0x0020;
    L_0x0053:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0058 }
    L_0x0057:
        throw r0;
    L_0x0058:
        r1 = move-exception;
        goto L_0x0057;
    L_0x005a:
        r1 = move-exception;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.market.sdk.h.d():com.xiaomi.market.sdk.l");
    }

    public void d(boolean z) {
        this.i = z;
    }

    public l e() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l a = a(new k(this, byteArrayOutputStream));
        if (a == l.OK) {
            this.e = byteArrayOutputStream.toString();
        } else {
            Log.e(l, "Connection failed : " + a);
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
        }
        return a;
    }

    public void e(boolean z) {
        this.j = z;
    }
}
