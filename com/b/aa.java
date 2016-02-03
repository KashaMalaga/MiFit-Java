package com.b;

import android.content.Context;
import android.database.Cursor;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.support.v4.view.a.C0113o;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.d.C0430g;
import cn.com.smartdevices.bracelet.gps.services.ay;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.c;
import com.amap.api.location.core.d;
import com.amap.api.services.core.AMapException;
import com.d.a.a.C1012a;
import com.d.a.a.O;
import com.d.a.a.h;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.b.v;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import kankan.wheel.widget.a;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

public class aa {
    private static aa a = null;

    private aa() {
    }

    public static int a(NetworkInfo networkInfo) {
        return (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) ? networkInfo.getType() : -1;
    }

    public static aa a() {
        if (a == null) {
            a = new aa();
        }
        return a;
    }

    public static String a(TelephonyManager telephonyManager) {
        int i = 0;
        if (telephonyManager != null) {
            i = telephonyManager.getNetworkType();
        }
        return (String) Q.l.get(i, "UNKNOWN");
    }

    public static HttpClient a(Context context, NetworkInfo networkInfo) {
        boolean z;
        Object obj;
        String toLowerCase;
        String b;
        int i;
        SchemeRegistry schemeRegistry;
        Throwable th;
        Throwable e;
        boolean z2 = true;
        Cursor cursor = null;
        HttpParams basicHttpParams = new BasicHttpParams();
        if (networkInfo.getType() == 0) {
            Cursor query;
            String string;
            try {
                query = context.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            string = query.getString(query.getColumnIndex("apn"));
                            if (string != null) {
                                string = string.toLowerCase(Locale.US);
                                ao.a("nm|found apn:", string);
                            }
                            if (string != null && string.contains("ctwap")) {
                                string = b();
                                if (TextUtils.isEmpty(string) || string.equals("null")) {
                                    z = false;
                                    obj = null;
                                } else {
                                    z = true;
                                }
                                if (!z) {
                                    try {
                                        string = "10.0.0.200";
                                    } catch (SecurityException e2) {
                                        cursor = query;
                                        try {
                                            if (networkInfo.getExtraInfo() != null) {
                                                toLowerCase = networkInfo.getExtraInfo().toLowerCase(Locale.US);
                                                b = b();
                                                if (toLowerCase.indexOf("ctwap") == -1) {
                                                    if (!TextUtils.isEmpty(b)) {
                                                    }
                                                    z2 = false;
                                                    if (!z2) {
                                                        string = "10.0.0.200";
                                                    }
                                                    b = string;
                                                    i = 80;
                                                } else if (toLowerCase.indexOf("wap") != -1) {
                                                    if (!TextUtils.isEmpty(b)) {
                                                    }
                                                    z = false;
                                                    if (!z) {
                                                        string = "10.0.0.200";
                                                    }
                                                    b = string;
                                                    i = 80;
                                                }
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                if (a(b, i)) {
                                                    basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(b, i, "http"));
                                                }
                                                ao.a(basicHttpParams, (int) a.as);
                                                HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                                                schemeRegistry = new SchemeRegistry();
                                                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                                                return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                                            }
                                            b = string;
                                            i = -1;
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (a(b, i)) {
                                                basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(b, i, "http"));
                                            }
                                            ao.a(basicHttpParams, (int) a.as);
                                            HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                                            schemeRegistry = new SchemeRegistry();
                                            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                                            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            query = cursor;
                                            if (query != null) {
                                                query.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        try {
                                            ao.a(e);
                                            if (query != null) {
                                                query.close();
                                            }
                                            b = string;
                                            i = -1;
                                            if (a(b, i)) {
                                                basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(b, i, "http"));
                                            }
                                            ao.a(basicHttpParams, (int) a.as);
                                            HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                                            schemeRegistry = new SchemeRegistry();
                                            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                                            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (query != null) {
                                                query.close();
                                            }
                                            throw th;
                                        }
                                    }
                                }
                                b = string;
                                i = 80;
                                if (query != null) {
                                    query.close();
                                }
                            } else if (string != null) {
                                if (string.contains("wap")) {
                                    string = b();
                                    if (TextUtils.isEmpty(string) || string.equals("null")) {
                                        z = false;
                                        obj = null;
                                    } else {
                                        z = true;
                                    }
                                    if (!z) {
                                        string = "10.0.0.172";
                                    }
                                    b = string;
                                    i = 80;
                                    if (query != null) {
                                        query.close();
                                    }
                                }
                            }
                        }
                    } catch (SecurityException e4) {
                        obj = null;
                        cursor = query;
                        if (networkInfo.getExtraInfo() != null) {
                            toLowerCase = networkInfo.getExtraInfo().toLowerCase(Locale.US);
                            b = b();
                            if (toLowerCase.indexOf("ctwap") == -1) {
                                if (TextUtils.isEmpty(b) || b.equals("null")) {
                                    z2 = false;
                                } else {
                                    string = b;
                                }
                                if (z2) {
                                    string = "10.0.0.200";
                                }
                                b = string;
                                i = 80;
                            } else if (toLowerCase.indexOf("wap") != -1) {
                                if (TextUtils.isEmpty(b) || b.equals("null")) {
                                    z = false;
                                } else {
                                    string = b;
                                    z = true;
                                }
                                if (z) {
                                    string = "10.0.0.200";
                                }
                                b = string;
                                i = 80;
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (a(b, i)) {
                                basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(b, i, "http"));
                            }
                            ao.a(basicHttpParams, (int) a.as);
                            HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                            schemeRegistry = new SchemeRegistry();
                            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                        }
                        b = string;
                        i = -1;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a(b, i)) {
                            basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(b, i, "http"));
                        }
                        ao.a(basicHttpParams, (int) a.as);
                        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                        schemeRegistry = new SchemeRegistry();
                        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                    } catch (Throwable th4) {
                        e = th4;
                        string = null;
                        ao.a(e);
                        if (query != null) {
                            query.close();
                        }
                        b = string;
                        i = -1;
                        if (a(b, i)) {
                            basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(b, i, "http"));
                        }
                        ao.a(basicHttpParams, (int) a.as);
                        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                        schemeRegistry = new SchemeRegistry();
                        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                    }
                }
                i = -1;
                b = null;
                if (query != null) {
                    query.close();
                }
            } catch (SecurityException e5) {
                string = null;
                if (networkInfo.getExtraInfo() != null) {
                    toLowerCase = networkInfo.getExtraInfo().toLowerCase(Locale.US);
                    b = b();
                    if (toLowerCase.indexOf("ctwap") == -1) {
                        if (TextUtils.isEmpty(b)) {
                        }
                        z2 = false;
                        if (z2) {
                            string = "10.0.0.200";
                        }
                        b = string;
                        i = 80;
                    } else if (toLowerCase.indexOf("wap") != -1) {
                        if (TextUtils.isEmpty(b)) {
                        }
                        z = false;
                        if (z) {
                            string = "10.0.0.200";
                        }
                        b = string;
                        i = 80;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a(b, i)) {
                        basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(b, i, "http"));
                    }
                    ao.a(basicHttpParams, (int) a.as);
                    HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                    schemeRegistry = new SchemeRegistry();
                    schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                    return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                }
                b = string;
                i = -1;
                if (cursor != null) {
                    cursor.close();
                }
                if (a(b, i)) {
                    basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(b, i, "http"));
                }
                ao.a(basicHttpParams, (int) a.as);
                HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
            } catch (Throwable th42) {
                e = th42;
                query = null;
                string = null;
                ao.a(e);
                if (query != null) {
                    query.close();
                }
                b = string;
                i = -1;
                if (a(b, i)) {
                    basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(b, i, "http"));
                }
                ao.a(basicHttpParams, (int) a.as);
                HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
            } catch (Throwable th5) {
                th42 = th5;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th42;
            }
        }
        i = -1;
        b = null;
        if (a(b, i)) {
            basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(b, i, "http"));
        }
        ao.a(basicHttpParams, (int) a.as);
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    private static boolean a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    private static boolean a(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        return firstHeader != null && firstHeader.getValue().equalsIgnoreCase(C1012a.g);
    }

    public static String[] a(JSONObject jSONObject) {
        String[] strArr = new String[]{null, null, null, null, null};
        if (jSONObject == null || c.j().length() == 0) {
            strArr[0] = "false";
        } else {
            try {
                CharSequence string = jSONObject.getString(C0430g.b);
                String string2 = jSONObject.getString("X-INFO");
                String string3 = jSONObject.getString("X-BIZ");
                CharSequence string4 = jSONObject.getString("User-Agent");
                if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string4))) {
                    strArr[0] = "true";
                    strArr[1] = string;
                    strArr[2] = string2;
                    strArr[3] = string3;
                    strArr[4] = string4;
                }
            } catch (JSONException e) {
            }
            if (strArr[0] == null || !strArr[0].equals("true")) {
                strArr[0] = "true";
            }
        }
        return strArr;
    }

    private static String b() {
        String defaultHost;
        try {
            defaultHost = Proxy.getDefaultHost();
        } catch (Throwable th) {
            th.printStackTrace();
            defaultHost = null;
        }
        return defaultHost == null ? "null" : defaultHost;
    }

    public String a(Context context, String str, byte[] bArr, String str2) {
        InputStream content;
        GZIPInputStream gZIPInputStream;
        InputStreamReader inputStreamReader;
        HttpClient httpClient;
        Throwable th;
        BufferedReader bufferedReader;
        Throwable th2;
        Object obj;
        HttpPost httpPost;
        if (TextUtils.isEmpty(str) || bArr == null) {
            return null;
        }
        HttpClient b = ao.b(context);
        if (a((NetworkInfo) b) == -1) {
            return null;
        }
        HttpPost httpPost2 = null;
        HttpPost httpPost3 = null;
        InputStream inputStream = null;
        GZIPInputStream gZIPInputStream2 = null;
        InputStreamReader inputStreamReader2 = null;
        BufferedReader bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        String str3 = com.xiaomi.e.a.f;
        try {
            b = a(context, (NetworkInfo) b);
            try {
                httpPost2 = new HttpPost(str);
                try {
                    Object stringBuffer2;
                    HttpEntity byteArrayEntity = new ByteArrayEntity(bArr);
                    httpPost2.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    httpPost2.addHeader("User-Agent", "AMAP Location SDK Android 1.3.1");
                    httpPost2.addHeader(C1012a.f, C1012a.g);
                    httpPost2.addHeader("Connection", "Keep-Alive");
                    httpPost2.addHeader("X-INFO", c.a(null).a(str2));
                    httpPost2.addHeader("ia", Constants.VIA_TO_TYPE_QQ_GROUP);
                    httpPost2.addHeader(C0430g.b, c.a());
                    stringBuffer.delete(0, stringBuffer.length());
                    httpPost2.setEntity(byteArrayEntity);
                    HttpResponse execute = b.execute(httpPost2);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    String str4;
                    if (statusCode == v.C) {
                        content = execute.getEntity().getContent();
                        try {
                            str3 = execute.getEntity().getContentType().getValue();
                            CharSequence charSequence = com.xiaomi.e.a.f;
                            int indexOf = str3.indexOf("charset=");
                            if (indexOf != -1) {
                                charSequence = str3.substring(indexOf + 8);
                            }
                            if (TextUtils.isEmpty(charSequence)) {
                                str3 = h.DEFAULT_CHARSET;
                            } else {
                                CharSequence charSequence2 = charSequence;
                            }
                            if (a(execute)) {
                                gZIPInputStream = new GZIPInputStream(content);
                            } else {
                                inputStream = null;
                            }
                            if (gZIPInputStream != null) {
                                try {
                                    inputStreamReader = new InputStreamReader(gZIPInputStream, str3);
                                } catch (UnknownHostException e) {
                                    gZIPInputStream2 = gZIPInputStream;
                                    inputStream = content;
                                    httpPost3 = httpPost2;
                                    httpClient = b;
                                    try {
                                        throw new AMapLocException(AMapException.ERROR_UNKNOW_HOST);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        b = httpClient;
                                        httpPost2 = httpPost3;
                                        content = inputStream;
                                        gZIPInputStream = gZIPInputStream2;
                                        inputStreamReader = inputStreamReader2;
                                        bufferedReader = bufferedReader2;
                                        th2 = th;
                                        if (httpPost2 != null) {
                                            httpPost2.abort();
                                        }
                                        if (b != null) {
                                            b.getConnectionManager().shutdown();
                                        }
                                        if (gZIPInputStream != null) {
                                            try {
                                                gZIPInputStream.close();
                                            } catch (Throwable th4) {
                                            }
                                        }
                                        if (content != null) {
                                            try {
                                                content.close();
                                            } catch (Throwable th5) {
                                                th5.printStackTrace();
                                            }
                                        }
                                        if (inputStreamReader != null) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable th6) {
                                                th6.printStackTrace();
                                            }
                                        }
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable th7) {
                                                th7.printStackTrace();
                                            }
                                        }
                                        throw th2;
                                    }
                                } catch (SocketException e2) {
                                    gZIPInputStream2 = gZIPInputStream;
                                    inputStream = content;
                                    throw new AMapLocException(AMapException.ERROR_SOCKET);
                                } catch (SocketTimeoutException e3) {
                                    gZIPInputStream2 = gZIPInputStream;
                                    inputStream = content;
                                    throw new AMapLocException(AMapException.ERROR_SOCKE_TIME_OUT);
                                } catch (ConnectTimeoutException e4) {
                                    gZIPInputStream2 = gZIPInputStream;
                                    inputStream = content;
                                    throw new AMapLocException(AMapException.ERROR_CONNECTION);
                                } catch (Throwable th62) {
                                    th = th62;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    th2 = th;
                                    if (httpPost2 != null) {
                                        httpPost2.abort();
                                    }
                                    if (b != null) {
                                        b.getConnectionManager().shutdown();
                                    }
                                    if (gZIPInputStream != null) {
                                        gZIPInputStream.close();
                                    }
                                    if (content != null) {
                                        content.close();
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    throw th2;
                                }
                            }
                            inputStreamReader = new InputStreamReader(content, str3);
                        } catch (UnknownHostException e5) {
                            inputStream = content;
                            httpPost3 = httpPost2;
                            httpClient = b;
                            throw new AMapLocException(AMapException.ERROR_UNKNOW_HOST);
                        } catch (SocketException e6) {
                            inputStream = content;
                            throw new AMapLocException(AMapException.ERROR_SOCKET);
                        } catch (SocketTimeoutException e7) {
                            inputStream = content;
                            throw new AMapLocException(AMapException.ERROR_SOCKE_TIME_OUT);
                        } catch (ConnectTimeoutException e8) {
                            inputStream = content;
                            throw new AMapLocException(AMapException.ERROR_CONNECTION);
                        } catch (Throwable th52) {
                            th = th52;
                            gZIPInputStream = null;
                            inputStreamReader = null;
                            bufferedReader = null;
                            th2 = th;
                            if (httpPost2 != null) {
                                httpPost2.abort();
                            }
                            if (b != null) {
                                b.getConnectionManager().shutdown();
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (content != null) {
                                content.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th2;
                        }
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader, C0113o.l);
                            try {
                                str4 = com.xiaomi.e.a.f;
                                while (true) {
                                    str4 = bufferedReader.readLine();
                                    if (str4 == null) {
                                        break;
                                    }
                                    stringBuffer.append(str4);
                                }
                                stringBuffer2 = stringBuffer.toString();
                                stringBuffer.delete(0, stringBuffer.length());
                            } catch (UnknownHostException e9) {
                                bufferedReader2 = bufferedReader;
                                inputStreamReader2 = inputStreamReader;
                                gZIPInputStream2 = gZIPInputStream;
                                inputStream = content;
                                httpPost3 = httpPost2;
                                httpClient = b;
                                throw new AMapLocException(AMapException.ERROR_UNKNOW_HOST);
                            } catch (SocketException e10) {
                                bufferedReader2 = bufferedReader;
                                inputStreamReader2 = inputStreamReader;
                                gZIPInputStream2 = gZIPInputStream;
                                inputStream = content;
                                throw new AMapLocException(AMapException.ERROR_SOCKET);
                            } catch (SocketTimeoutException e11) {
                                bufferedReader2 = bufferedReader;
                                inputStreamReader2 = inputStreamReader;
                                gZIPInputStream2 = gZIPInputStream;
                                inputStream = content;
                                throw new AMapLocException(AMapException.ERROR_SOCKE_TIME_OUT);
                            } catch (ConnectTimeoutException e12) {
                                bufferedReader2 = bufferedReader;
                                inputStreamReader2 = inputStreamReader;
                                gZIPInputStream2 = gZIPInputStream;
                                inputStream = content;
                                throw new AMapLocException(AMapException.ERROR_CONNECTION);
                            } catch (Throwable th8) {
                                th2 = th8;
                                th2.printStackTrace();
                                throw new AMapLocException(AMapException.ERROR_UNKNOWN);
                            }
                        } catch (UnknownHostException e13) {
                            inputStreamReader2 = inputStreamReader;
                            gZIPInputStream2 = gZIPInputStream;
                            inputStream = content;
                            httpPost3 = httpPost2;
                            httpClient = b;
                            throw new AMapLocException(AMapException.ERROR_UNKNOW_HOST);
                        } catch (SocketException e14) {
                            inputStreamReader2 = inputStreamReader;
                            gZIPInputStream2 = gZIPInputStream;
                            inputStream = content;
                            throw new AMapLocException(AMapException.ERROR_SOCKET);
                        } catch (SocketTimeoutException e15) {
                            inputStreamReader2 = inputStreamReader;
                            gZIPInputStream2 = gZIPInputStream;
                            inputStream = content;
                            throw new AMapLocException(AMapException.ERROR_SOCKE_TIME_OUT);
                        } catch (ConnectTimeoutException e16) {
                            inputStreamReader2 = inputStreamReader;
                            gZIPInputStream2 = gZIPInputStream;
                            inputStream = content;
                            throw new AMapLocException(AMapException.ERROR_CONNECTION);
                        } catch (Throwable th72) {
                            th = th72;
                            bufferedReader = null;
                            th2 = th;
                            if (httpPost2 != null) {
                                httpPost2.abort();
                            }
                            if (b != null) {
                                b.getConnectionManager().shutdown();
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (content != null) {
                                content.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th2;
                        }
                    } else if (statusCode == 404) {
                        throw new AMapLocException(AMapException.ERROR_UNKNOW_SERVICE);
                    } else {
                        content = null;
                        gZIPInputStream = null;
                        inputStreamReader = null;
                        bufferedReader = null;
                        str4 = str3;
                    }
                    if (httpPost2 != null) {
                        httpPost2.abort();
                    }
                    if (b != null) {
                        b.getConnectionManager().shutdown();
                    }
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Throwable th9) {
                        }
                    }
                    if (content != null) {
                        try {
                            content.close();
                        } catch (Throwable th522) {
                            th522.printStackTrace();
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Throwable th622) {
                            th622.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th722) {
                            th722.printStackTrace();
                        }
                    }
                    return TextUtils.isEmpty(stringBuffer2) ? null : stringBuffer2;
                } catch (UnknownHostException e17) {
                    httpPost3 = httpPost2;
                    httpClient = b;
                    throw new AMapLocException(AMapException.ERROR_UNKNOW_HOST);
                } catch (SocketException e18) {
                    throw new AMapLocException(AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e19) {
                    throw new AMapLocException(AMapException.ERROR_SOCKE_TIME_OUT);
                } catch (ConnectTimeoutException e20) {
                    throw new AMapLocException(AMapException.ERROR_CONNECTION);
                } catch (Throwable th10) {
                    th = th10;
                    content = null;
                    gZIPInputStream = null;
                    inputStreamReader = null;
                    bufferedReader = null;
                    th2 = th;
                    if (httpPost2 != null) {
                        httpPost2.abort();
                    }
                    if (b != null) {
                        b.getConnectionManager().shutdown();
                    }
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    if (content != null) {
                        content.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th2;
                }
            } catch (UnknownHostException e21) {
                httpClient = b;
                throw new AMapLocException(AMapException.ERROR_UNKNOW_HOST);
            } catch (SocketException e22) {
                httpPost2 = null;
                throw new AMapLocException(AMapException.ERROR_SOCKET);
            } catch (SocketTimeoutException e23) {
                obj = null;
                throw new AMapLocException(AMapException.ERROR_SOCKE_TIME_OUT);
            } catch (ConnectTimeoutException e24) {
                obj = null;
                throw new AMapLocException(AMapException.ERROR_CONNECTION);
            } catch (Throwable th11) {
                th = th11;
                httpPost2 = null;
                content = null;
                gZIPInputStream = null;
                inputStreamReader = null;
                bufferedReader = null;
                th2 = th;
                if (httpPost2 != null) {
                    httpPost2.abort();
                }
                if (b != null) {
                    b.getConnectionManager().shutdown();
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (content != null) {
                    content.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th2;
            }
        } catch (UnknownHostException e25) {
            throw new AMapLocException(AMapException.ERROR_UNKNOW_HOST);
        } catch (SocketException e26) {
            b = null;
            httpPost2 = null;
            throw new AMapLocException(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException e27) {
            httpPost = null;
            obj = null;
            throw new AMapLocException(AMapException.ERROR_SOCKE_TIME_OUT);
        } catch (ConnectTimeoutException e28) {
            httpPost = null;
            obj = null;
            throw new AMapLocException(AMapException.ERROR_CONNECTION);
        } catch (Throwable th102) {
            th = th102;
            content = inputStream;
            gZIPInputStream = gZIPInputStream2;
            inputStreamReader = inputStreamReader2;
            bufferedReader = bufferedReader2;
            th2 = th;
            if (httpPost2 != null) {
                httpPost2.abort();
            }
            if (b != null) {
                b.getConnectionManager().shutdown();
            }
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            if (content != null) {
                content.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th2;
        }
    }

    public String a(byte[] bArr, Context context) {
        HttpClient a;
        HttpPost httpPost;
        Reader inputStreamReader;
        HttpPost httpPost2;
        String str;
        BufferedReader bufferedReader;
        InputStream inputStream;
        HttpClient httpClient;
        BufferedReader bufferedReader2;
        Throwable th;
        BufferedReader bufferedReader3;
        Reader reader;
        String str2 = com.xiaomi.e.a.f;
        NetworkInfo b = ao.b(context);
        if (a(b) == -1) {
            return null;
        }
        HttpClient httpClient2 = null;
        HttpPost httpPost3 = null;
        InputStream inputStream2 = null;
        InputStreamReader inputStreamReader2 = null;
        BufferedReader bufferedReader4 = null;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("http://cgicol.amap.com/collection/writedata?ver=v1.0_ali&");
        stringBuffer2.append("zei=").append(Q.a);
        stringBuffer2.append("&zsi=").append(Q.b);
        int i = 0;
        Object obj = null;
        StringBuffer stringBuffer3 = stringBuffer;
        String str3 = str2;
        while (i < 1 && r1 == null) {
            try {
                a = a(context, b);
                try {
                    httpPost = new HttpPost(stringBuffer2.toString());
                    try {
                        stringBuffer3.delete(0, stringBuffer3.length());
                        stringBuffer3.append("application/soap+xml;charset=");
                        stringBuffer3.append(h.DEFAULT_CHARSET);
                        stringBuffer3.delete(0, stringBuffer3.length());
                        httpPost.addHeader("gzipped", Constants.VIA_TO_TYPE_QQ_GROUP);
                        HttpEntity byteArrayEntity = new ByteArrayEntity(ao.a(bArr));
                        byteArrayEntity.setContentType(O.a);
                        httpPost.setEntity(byteArrayEntity);
                        HttpResponse execute = a.execute(httpPost);
                        if (execute.getStatusLine().getStatusCode() == v.C) {
                            InputStream content = execute.getEntity().getContent();
                            try {
                                inputStreamReader = new InputStreamReader(content, h.DEFAULT_CHARSET);
                            } catch (UnknownHostException e) {
                                httpPost2 = httpPost;
                                str = str3;
                                bufferedReader = bufferedReader4;
                                inputStream = content;
                                httpClient = a;
                                if (httpPost2 != null) {
                                    httpPost2.abort();
                                    httpPost2 = null;
                                }
                                if (httpClient != null) {
                                    httpClient.getConnectionManager().shutdown();
                                    httpClient = null;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (SocketException e2) {
                                str = str3;
                                bufferedReader = bufferedReader4;
                                inputStream = content;
                                if (httpPost == null) {
                                    httpPost.abort();
                                    httpPost2 = null;
                                } else {
                                    httpPost2 = httpPost;
                                }
                                if (a == null) {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                } else {
                                    httpClient = a;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (SocketTimeoutException e3) {
                                str = str3;
                                bufferedReader = bufferedReader4;
                                inputStream = content;
                                if (httpPost == null) {
                                    httpPost.abort();
                                    httpPost2 = null;
                                } else {
                                    httpPost2 = httpPost;
                                }
                                if (a == null) {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                } else {
                                    httpClient = a;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (ConnectTimeoutException e4) {
                                str = str3;
                                bufferedReader = bufferedReader4;
                                inputStream = content;
                                if (httpPost == null) {
                                    httpPost.abort();
                                    httpPost2 = null;
                                } else {
                                    httpPost2 = httpPost;
                                }
                                if (a == null) {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                } else {
                                    httpClient = a;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = content;
                            }
                            try {
                                bufferedReader3 = new BufferedReader(inputStreamReader, C0113o.l);
                            } catch (UnknownHostException e5) {
                                reader = inputStreamReader;
                                str = str3;
                                httpPost2 = httpPost;
                                bufferedReader = bufferedReader4;
                                inputStream = content;
                                httpClient = a;
                                if (httpPost2 != null) {
                                    httpPost2.abort();
                                    httpPost2 = null;
                                }
                                if (httpClient != null) {
                                    httpClient.getConnectionManager().shutdown();
                                    httpClient = null;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (SocketException e6) {
                                reader = inputStreamReader;
                                str = str3;
                                bufferedReader = bufferedReader4;
                                inputStream = content;
                                if (httpPost == null) {
                                    httpPost2 = httpPost;
                                } else {
                                    httpPost.abort();
                                    httpPost2 = null;
                                }
                                if (a == null) {
                                    httpClient = a;
                                } else {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (SocketTimeoutException e7) {
                                reader = inputStreamReader;
                                str = str3;
                                bufferedReader = bufferedReader4;
                                inputStream = content;
                                if (httpPost == null) {
                                    httpPost2 = httpPost;
                                } else {
                                    httpPost.abort();
                                    httpPost2 = null;
                                }
                                if (a == null) {
                                    httpClient = a;
                                } else {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (ConnectTimeoutException e8) {
                                reader = inputStreamReader;
                                str = str3;
                                bufferedReader = bufferedReader4;
                                inputStream = content;
                                if (httpPost == null) {
                                    httpPost2 = httpPost;
                                } else {
                                    httpPost.abort();
                                    httpPost2 = null;
                                }
                                if (a == null) {
                                    httpClient = a;
                                } else {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                reader = inputStreamReader;
                                inputStream2 = content;
                            }
                            try {
                                String str4 = com.xiaomi.e.a.f;
                                while (true) {
                                    str4 = bufferedReader3.readLine();
                                    if (str4 == null) {
                                        break;
                                    }
                                    stringBuffer3.append(str4);
                                }
                                str3 = stringBuffer3.toString();
                                stringBuffer3.delete(0, stringBuffer3.length());
                                stringBuffer3 = null;
                                obj = 1;
                                inputStream = content;
                                str = str3;
                                bufferedReader = bufferedReader3;
                                inputStreamReader2 = inputStreamReader;
                            } catch (UnknownHostException e9) {
                                inputStream = content;
                                str = str3;
                                bufferedReader = bufferedReader3;
                                httpClient = a;
                                inputStreamReader2 = inputStreamReader;
                                httpPost2 = httpPost;
                                if (httpPost2 != null) {
                                    httpPost2.abort();
                                    httpPost2 = null;
                                }
                                if (httpClient != null) {
                                    httpClient.getConnectionManager().shutdown();
                                    httpClient = null;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (SocketException e10) {
                                inputStream = content;
                                str = str3;
                                bufferedReader = bufferedReader3;
                                inputStreamReader2 = inputStreamReader;
                                if (httpPost == null) {
                                    httpPost.abort();
                                    httpPost2 = null;
                                } else {
                                    httpPost2 = httpPost;
                                }
                                if (a == null) {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                } else {
                                    httpClient = a;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (SocketTimeoutException e11) {
                                inputStream = content;
                                str = str3;
                                bufferedReader = bufferedReader3;
                                inputStreamReader2 = inputStreamReader;
                                if (httpPost == null) {
                                    httpPost.abort();
                                    httpPost2 = null;
                                } else {
                                    httpPost2 = httpPost;
                                }
                                if (a == null) {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                } else {
                                    httpClient = a;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (ConnectTimeoutException e12) {
                                inputStream = content;
                                str = str3;
                                bufferedReader = bufferedReader3;
                                inputStreamReader2 = inputStreamReader;
                                if (httpPost == null) {
                                    httpPost.abort();
                                    httpPost2 = null;
                                } else {
                                    httpPost2 = httpPost;
                                }
                                if (a == null) {
                                    a.getConnectionManager().shutdown();
                                    httpClient = null;
                                } else {
                                    httpClient = a;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    inputStream = null;
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                    inputStreamReader2 = null;
                                }
                                if (bufferedReader == null) {
                                    bufferedReader.close();
                                    bufferedReader = null;
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                } else {
                                    i++;
                                    bufferedReader2 = bufferedReader;
                                    str3 = str;
                                    httpClient2 = httpClient;
                                    httpPost3 = httpPost2;
                                    inputStream2 = inputStream;
                                    bufferedReader4 = bufferedReader2;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedReader4 = bufferedReader3;
                                inputStreamReader2 = inputStreamReader;
                                inputStream2 = content;
                            }
                        } else {
                            str = str3;
                            bufferedReader = bufferedReader4;
                            inputStream = inputStream2;
                        }
                        if (httpPost != null) {
                            httpPost.abort();
                            httpPost2 = null;
                        } else {
                            httpPost2 = httpPost;
                        }
                        if (a != null) {
                            a.getConnectionManager().shutdown();
                            httpClient = null;
                        } else {
                            httpClient = a;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            inputStream = null;
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                            inputStreamReader2 = null;
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                            bufferedReader = null;
                            i++;
                            bufferedReader2 = bufferedReader;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader2;
                        } else {
                            i++;
                            bufferedReader2 = bufferedReader;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader2;
                        }
                    } catch (UnknownHostException e13) {
                        httpClient = a;
                        str = str3;
                        bufferedReader = bufferedReader4;
                        inputStream = inputStream2;
                        httpPost2 = httpPost;
                        if (httpPost2 != null) {
                            httpPost2.abort();
                            httpPost2 = null;
                        }
                        if (httpClient != null) {
                            httpClient.getConnectionManager().shutdown();
                            httpClient = null;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            inputStream = null;
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                            inputStreamReader2 = null;
                        }
                        if (bufferedReader == null) {
                            i++;
                            bufferedReader2 = bufferedReader;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader2;
                        } else {
                            bufferedReader.close();
                            bufferedReader = null;
                            i++;
                            bufferedReader2 = bufferedReader;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader2;
                        }
                    } catch (SocketException e14) {
                        str = str3;
                        bufferedReader = bufferedReader4;
                        inputStream = inputStream2;
                        if (httpPost == null) {
                            httpPost2 = httpPost;
                        } else {
                            httpPost.abort();
                            httpPost2 = null;
                        }
                        if (a == null) {
                            httpClient = a;
                        } else {
                            a.getConnectionManager().shutdown();
                            httpClient = null;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            inputStream = null;
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                            inputStreamReader2 = null;
                        }
                        if (bufferedReader == null) {
                            i++;
                            bufferedReader2 = bufferedReader;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader2;
                        } else {
                            bufferedReader.close();
                            bufferedReader = null;
                            i++;
                            bufferedReader2 = bufferedReader;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader2;
                        }
                    } catch (SocketTimeoutException e15) {
                        str = str3;
                        bufferedReader = bufferedReader4;
                        inputStream = inputStream2;
                        if (httpPost == null) {
                            httpPost2 = httpPost;
                        } else {
                            httpPost.abort();
                            httpPost2 = null;
                        }
                        if (a == null) {
                            httpClient = a;
                        } else {
                            a.getConnectionManager().shutdown();
                            httpClient = null;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            inputStream = null;
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                            inputStreamReader2 = null;
                        }
                        if (bufferedReader == null) {
                            i++;
                            bufferedReader2 = bufferedReader;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader2;
                        } else {
                            bufferedReader.close();
                            bufferedReader = null;
                            i++;
                            bufferedReader2 = bufferedReader;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader2;
                        }
                    } catch (ConnectTimeoutException e16) {
                        str = str3;
                        bufferedReader = bufferedReader4;
                        inputStream = inputStream2;
                        if (httpPost == null) {
                            httpPost2 = httpPost;
                        } else {
                            httpPost.abort();
                            httpPost2 = null;
                        }
                        if (a == null) {
                            httpClient = a;
                        } else {
                            a.getConnectionManager().shutdown();
                            httpClient = null;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            inputStream = null;
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                            inputStreamReader2 = null;
                        }
                        if (bufferedReader == null) {
                            i++;
                            bufferedReader2 = bufferedReader;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader2;
                        } else {
                            bufferedReader.close();
                            bufferedReader = null;
                            i++;
                            bufferedReader2 = bufferedReader;
                            str3 = str;
                            httpClient2 = httpClient;
                            httpPost3 = httpPost2;
                            inputStream2 = inputStream;
                            bufferedReader4 = bufferedReader2;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (UnknownHostException e17) {
                    str = str3;
                    bufferedReader = bufferedReader4;
                    inputStream = inputStream2;
                    httpPost2 = httpPost3;
                    httpClient = a;
                    if (httpPost2 != null) {
                        httpPost2.abort();
                        httpPost2 = null;
                    }
                    if (httpClient != null) {
                        httpClient.getConnectionManager().shutdown();
                        httpClient = null;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        inputStream = null;
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                        inputStreamReader2 = null;
                    }
                    if (bufferedReader == null) {
                        bufferedReader.close();
                        bufferedReader = null;
                        i++;
                        bufferedReader2 = bufferedReader;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader2;
                    } else {
                        i++;
                        bufferedReader2 = bufferedReader;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader2;
                    }
                } catch (SocketException e18) {
                    httpPost = httpPost3;
                    str = str3;
                    bufferedReader = bufferedReader4;
                    inputStream = inputStream2;
                    if (httpPost == null) {
                        httpPost.abort();
                        httpPost2 = null;
                    } else {
                        httpPost2 = httpPost;
                    }
                    if (a == null) {
                        a.getConnectionManager().shutdown();
                        httpClient = null;
                    } else {
                        httpClient = a;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        inputStream = null;
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                        inputStreamReader2 = null;
                    }
                    if (bufferedReader == null) {
                        bufferedReader.close();
                        bufferedReader = null;
                        i++;
                        bufferedReader2 = bufferedReader;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader2;
                    } else {
                        i++;
                        bufferedReader2 = bufferedReader;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader2;
                    }
                } catch (SocketTimeoutException e19) {
                    httpPost = httpPost3;
                    str = str3;
                    bufferedReader = bufferedReader4;
                    inputStream = inputStream2;
                    if (httpPost == null) {
                        httpPost.abort();
                        httpPost2 = null;
                    } else {
                        httpPost2 = httpPost;
                    }
                    if (a == null) {
                        a.getConnectionManager().shutdown();
                        httpClient = null;
                    } else {
                        httpClient = a;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        inputStream = null;
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                        inputStreamReader2 = null;
                    }
                    if (bufferedReader == null) {
                        bufferedReader.close();
                        bufferedReader = null;
                        i++;
                        bufferedReader2 = bufferedReader;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader2;
                    } else {
                        i++;
                        bufferedReader2 = bufferedReader;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader2;
                    }
                } catch (ConnectTimeoutException e20) {
                    httpPost = httpPost3;
                    str = str3;
                    bufferedReader = bufferedReader4;
                    inputStream = inputStream2;
                    if (httpPost == null) {
                        httpPost.abort();
                        httpPost2 = null;
                    } else {
                        httpPost2 = httpPost;
                    }
                    if (a == null) {
                        a.getConnectionManager().shutdown();
                        httpClient = null;
                    } else {
                        httpClient = a;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        inputStream = null;
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                        inputStreamReader2 = null;
                    }
                    if (bufferedReader == null) {
                        bufferedReader.close();
                        bufferedReader = null;
                        i++;
                        bufferedReader2 = bufferedReader;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader2;
                    } else {
                        i++;
                        bufferedReader2 = bufferedReader;
                        str3 = str;
                        httpClient2 = httpClient;
                        httpPost3 = httpPost2;
                        inputStream2 = inputStream;
                        bufferedReader4 = bufferedReader2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    httpPost = httpPost3;
                }
            } catch (UnknownHostException e21) {
                bufferedReader2 = bufferedReader4;
                inputStream = inputStream2;
                httpPost2 = httpPost3;
                httpClient = httpClient2;
                str = str3;
                bufferedReader = bufferedReader2;
                if (httpPost2 != null) {
                    httpPost2.abort();
                    httpPost2 = null;
                }
                if (httpClient != null) {
                    httpClient.getConnectionManager().shutdown();
                    httpClient = null;
                }
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                    inputStreamReader2 = null;
                }
                if (bufferedReader == null) {
                    i++;
                    bufferedReader2 = bufferedReader;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader2;
                } else {
                    bufferedReader.close();
                    bufferedReader = null;
                    i++;
                    bufferedReader2 = bufferedReader;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader2;
                }
            } catch (SocketException e22) {
                httpPost = httpPost3;
                a = httpClient2;
                str = str3;
                bufferedReader = bufferedReader4;
                inputStream = inputStream2;
                if (httpPost == null) {
                    httpPost2 = httpPost;
                } else {
                    httpPost.abort();
                    httpPost2 = null;
                }
                if (a == null) {
                    httpClient = a;
                } else {
                    a.getConnectionManager().shutdown();
                    httpClient = null;
                }
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                    inputStreamReader2 = null;
                }
                if (bufferedReader == null) {
                    i++;
                    bufferedReader2 = bufferedReader;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader2;
                } else {
                    bufferedReader.close();
                    bufferedReader = null;
                    i++;
                    bufferedReader2 = bufferedReader;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader2;
                }
            } catch (SocketTimeoutException e23) {
                httpPost = httpPost3;
                a = httpClient2;
                str = str3;
                bufferedReader = bufferedReader4;
                inputStream = inputStream2;
                if (httpPost == null) {
                    httpPost2 = httpPost;
                } else {
                    httpPost.abort();
                    httpPost2 = null;
                }
                if (a == null) {
                    httpClient = a;
                } else {
                    a.getConnectionManager().shutdown();
                    httpClient = null;
                }
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                    inputStreamReader2 = null;
                }
                if (bufferedReader == null) {
                    i++;
                    bufferedReader2 = bufferedReader;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader2;
                } else {
                    bufferedReader.close();
                    bufferedReader = null;
                    i++;
                    bufferedReader2 = bufferedReader;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader2;
                }
            } catch (ConnectTimeoutException e24) {
                httpPost = httpPost3;
                a = httpClient2;
                str = str3;
                bufferedReader = bufferedReader4;
                inputStream = inputStream2;
                if (httpPost == null) {
                    httpPost2 = httpPost;
                } else {
                    httpPost.abort();
                    httpPost2 = null;
                }
                if (a == null) {
                    httpClient = a;
                } else {
                    a.getConnectionManager().shutdown();
                    httpClient = null;
                }
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                    inputStreamReader2 = null;
                }
                if (bufferedReader == null) {
                    i++;
                    bufferedReader2 = bufferedReader;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader2;
                } else {
                    bufferedReader.close();
                    bufferedReader = null;
                    i++;
                    bufferedReader2 = bufferedReader;
                    str3 = str;
                    httpClient2 = httpClient;
                    httpPost3 = httpPost2;
                    inputStream2 = inputStream;
                    bufferedReader4 = bufferedReader2;
                }
            } catch (Throwable th7) {
                th = th7;
                httpPost = httpPost3;
                a = httpClient2;
            }
        }
        stringBuffer2.delete(0, stringBuffer2.length());
        return str3.equals(com.xiaomi.e.a.f) ? null : str3;
        if (httpPost != null) {
            httpPost.abort();
        }
        if (a != null) {
            a.getConnectionManager().shutdown();
        }
        if (inputStream2 != null) {
            inputStream2.close();
        }
        if (inputStreamReader2 != null) {
            inputStreamReader2.close();
        }
        if (bufferedReader4 != null) {
            bufferedReader4.close();
        }
        throw th;
    }

    public String a(byte[] bArr, Context context, JSONObject jSONObject) {
        HttpClient a;
        HttpPost httpPost;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        GZIPInputStream gZIPInputStream;
        InputStream inputStream;
        HttpPost httpPost2;
        Throwable th;
        NetworkInfo b = ao.b(context);
        if (a(b) == -1) {
            throw new AMapLocException(AMapException.ERROR_CONNECTION);
        }
        HttpPost httpPost3 = null;
        GZIPInputStream gZIPInputStream2 = null;
        BufferedReader bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        Object obj = null;
        int i = 0;
        String str = com.xiaomi.e.a.f;
        InputStreamReader inputStreamReader2 = null;
        InputStream inputStream2 = null;
        HttpClient httpClient = null;
        while (i < 1 && obj == null) {
            try {
                a = a(context, b);
                try {
                    String[] a2 = a(jSONObject);
                    httpPost = new HttpPost(c.j());
                    try {
                        Object obj2;
                        GZIPInputStream gZIPInputStream3;
                        StringBuffer stringBuffer2;
                        InputStream inputStream3;
                        InputStreamReader inputStreamReader3;
                        String str2;
                        String str3 = h.DEFAULT_CHARSET;
                        HttpEntity byteArrayEntity = new ByteArrayEntity(ao.a(bArr));
                        byteArrayEntity.setContentType(O.a);
                        httpPost.addHeader(C1012a.f, C1012a.g);
                        httpPost.addHeader("gzipped", Constants.VIA_TO_TYPE_QQ_GROUP);
                        httpPost.addHeader("X-INFO", a2[2]);
                        httpPost.addHeader("X-BIZ", a2[3]);
                        httpPost.addHeader("KEY", a2[1]);
                        httpPost.addHeader("ec", Constants.VIA_TO_TYPE_QQ_GROUP);
                        httpPost.addHeader("enginever", "4.2");
                        if (a2[4] != null && a2[4].length() > 0) {
                            httpPost.addHeader("User-Agent", a2[4]);
                        }
                        String a3 = d.a();
                        String a4 = d.a(a3, "key=" + a2[1]);
                        httpPost.addHeader(ay.H, a3);
                        httpPost.addHeader("scode", a4);
                        stringBuffer.delete(0, stringBuffer.length());
                        httpPost.setEntity(byteArrayEntity);
                        HttpResponse execute = a.execute(httpPost);
                        int statusCode = execute.getStatusLine().getStatusCode();
                        String str4;
                        if (statusCode == v.C) {
                            inputStream2 = execute.getEntity().getContent();
                            String value = execute.getEntity().getContentType().getValue();
                            CharSequence charSequence = com.xiaomi.e.a.f;
                            statusCode = value.indexOf("charset=");
                            if (statusCode != -1) {
                                charSequence = value.substring(statusCode + 8);
                            }
                            if (!TextUtils.isEmpty(charSequence)) {
                                CharSequence charSequence2 = charSequence;
                            }
                            if (a(execute)) {
                                gZIPInputStream2 = new GZIPInputStream(inputStream2);
                            }
                            inputStreamReader2 = gZIPInputStream2 != null ? new InputStreamReader(gZIPInputStream2, str3) : new InputStreamReader(inputStream2, str3);
                            bufferedReader = new BufferedReader(inputStreamReader2, C0113o.l);
                            try {
                                String str5 = com.xiaomi.e.a.f;
                                while (true) {
                                    str5 = bufferedReader.readLine();
                                    if (str5 == null) {
                                        break;
                                    }
                                    stringBuffer.append(str5);
                                }
                                str3 = stringBuffer.toString();
                                stringBuffer.delete(0, stringBuffer.length());
                                obj2 = 1;
                                str4 = str3;
                                gZIPInputStream3 = gZIPInputStream2;
                                stringBuffer2 = null;
                                inputStream3 = inputStream2;
                                inputStreamReader3 = inputStreamReader2;
                                str2 = str4;
                            } catch (UnknownHostException e) {
                                inputStreamReader = inputStreamReader2;
                                gZIPInputStream = gZIPInputStream2;
                                inputStream = inputStream2;
                                httpPost2 = httpPost;
                                httpClient = a;
                            } catch (SocketException e2) {
                                bufferedReader2 = bufferedReader;
                            } catch (SocketTimeoutException e3) {
                                bufferedReader2 = bufferedReader;
                            } catch (ConnectTimeoutException e4) {
                                bufferedReader2 = bufferedReader;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } else if (statusCode == 404) {
                            throw new AMapLocException(AMapException.ERROR_UNKNOW_SERVICE);
                        } else {
                            gZIPInputStream3 = gZIPInputStream2;
                            stringBuffer2 = stringBuffer;
                            str4 = str;
                            bufferedReader = bufferedReader2;
                            obj2 = obj;
                            inputStream3 = inputStream2;
                            inputStreamReader3 = inputStreamReader2;
                            str2 = str4;
                        }
                        if (httpPost != null) {
                            httpPost.abort();
                            httpPost = null;
                        }
                        if (a != null) {
                            a.getConnectionManager().shutdown();
                            a = null;
                        }
                        if (gZIPInputStream3 != null) {
                            try {
                                gZIPInputStream3.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                            gZIPInputStream3 = null;
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                            inputStream3 = null;
                        }
                        if (inputStreamReader3 != null) {
                            inputStreamReader3.close();
                            inputStreamReader3 = null;
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                            bufferedReader = null;
                        }
                        i++;
                        stringBuffer = stringBuffer2;
                        gZIPInputStream2 = gZIPInputStream3;
                        httpPost3 = httpPost;
                        httpClient = a;
                        InputStreamReader inputStreamReader4 = inputStreamReader3;
                        inputStream2 = inputStream3;
                        obj = obj2;
                        bufferedReader2 = bufferedReader;
                        str = str2;
                        inputStreamReader2 = inputStreamReader4;
                    } catch (UnknownHostException e5) {
                        bufferedReader = bufferedReader2;
                        inputStreamReader = inputStreamReader2;
                        gZIPInputStream = gZIPInputStream2;
                        inputStream = inputStream2;
                        httpPost2 = httpPost;
                        httpClient = a;
                    } catch (SocketException e6) {
                    } catch (SocketTimeoutException e7) {
                    } catch (ConnectTimeoutException e8) {
                    } catch (Throwable th5) {
                    }
                } catch (UnknownHostException e9) {
                    bufferedReader = bufferedReader2;
                    httpClient = a;
                    inputStreamReader = inputStreamReader2;
                    gZIPInputStream = gZIPInputStream2;
                    inputStream = inputStream2;
                    httpPost2 = httpPost3;
                } catch (SocketException e10) {
                    httpPost = httpPost3;
                } catch (SocketTimeoutException e11) {
                    httpPost = httpPost3;
                } catch (ConnectTimeoutException e12) {
                    httpPost = httpPost3;
                } catch (Throwable th6) {
                    th = th6;
                    httpPost = httpPost3;
                }
            } catch (UnknownHostException e13) {
                bufferedReader = bufferedReader2;
                inputStreamReader = inputStreamReader2;
                gZIPInputStream = gZIPInputStream2;
                inputStream = inputStream2;
                httpPost2 = httpPost3;
            } catch (SocketException e14) {
                a = httpClient;
                httpPost = httpPost3;
            } catch (SocketTimeoutException e15) {
                a = httpClient;
                httpPost = httpPost3;
            } catch (ConnectTimeoutException e16) {
                a = httpClient;
                httpPost = httpPost3;
            } catch (Throwable th7) {
                th = th7;
                a = httpClient;
                httpPost = httpPost3;
            }
        }
        return TextUtils.isEmpty(str) ? null : str;
        throw new AMapLocException(AMapException.ERROR_SOCKE_TIME_OUT);
        try {
            throw new AMapLocException(AMapException.ERROR_UNKNOW_HOST);
        } catch (Throwable th32) {
            a = httpClient;
            httpPost = httpPost2;
            inputStream2 = inputStream;
            gZIPInputStream2 = gZIPInputStream;
            inputStreamReader2 = inputStreamReader;
            bufferedReader2 = bufferedReader;
            th = th32;
            if (httpPost != null) {
                httpPost.abort();
            }
            if (a != null) {
                a.getConnectionManager().shutdown();
            }
            if (gZIPInputStream2 != null) {
                try {
                    gZIPInputStream2.close();
                } catch (Throwable th8) {
                    th8.printStackTrace();
                }
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Throwable th82) {
                    th82.printStackTrace();
                }
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        throw new AMapLocException(AMapException.ERROR_SOCKET);
        throw new AMapLocException(AMapException.ERROR_CONNECTION);
        throw new AMapLocException(AMapException.ERROR_CONNECTION);
    }
}
