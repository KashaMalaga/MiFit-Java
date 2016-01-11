package com.g.a.c;

import android.text.TextUtils;
import com.d.a.a.C1012a;
import com.f.a.b.d.a;
import com.g.a.p;
import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.b.v;
import com.xiaomi.channel.gamesdk.b;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public abstract class s {
    private static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), C1012a.e);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            try {
                stringBuilder.append(new StringBuilder(String.valueOf(readLine)).append("\n").toString());
            } catch (Exception e) {
                stringBuilder = p.e;
                r.b(stringBuilder, "Caught IOException in convertStreamToString()", e);
                return null;
            } finally {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    r.b(p.e, "Caught IOException in convertStreamToString()", e2);
                    return null;
                }
            }
        }
        return stringBuilder.toString();
    }

    protected static String a(String str) {
        int nextInt = new Random().nextInt(h.E);
        try {
            String property = System.getProperty("line.separator");
            if (str.length() <= 1) {
                r.b(p.e, new StringBuilder(String.valueOf(nextInt)).append(":\tInvalid baseUrl.").toString());
                return null;
            }
            HttpUriRequest httpGet = new HttpGet(str);
            r.a(p.e, new StringBuilder(String.valueOf(nextInt)).append(": GET_URL: ").append(str).toString());
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, C1012a.b);
            HttpConnectionParams.setSoTimeout(basicHttpParams, a.b);
            HttpResponse execute = new DefaultHttpClient(basicHttpParams).execute(httpGet);
            if (execute.getStatusLine().getStatusCode() == v.C) {
                HttpEntity entity = execute.getEntity();
                if (entity == null) {
                    return null;
                }
                InputStream gZIPInputStream;
                InputStream content = entity.getContent();
                Header firstHeader = execute.getFirstHeader("Content-Encoding");
                if (firstHeader != null && firstHeader.getValue().equalsIgnoreCase(C1012a.g)) {
                    r.a(p.e, new StringBuilder(String.valueOf(nextInt)).append("  Use GZIPInputStream get data....").toString());
                    gZIPInputStream = new GZIPInputStream(content);
                } else if (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("deflate")) {
                    gZIPInputStream = content;
                } else {
                    r.a(p.e, new StringBuilder(String.valueOf(nextInt)).append("  Use InflaterInputStream get data....").toString());
                    gZIPInputStream = new InflaterInputStream(content);
                }
                String a = a(gZIPInputStream);
                r.a(p.e, new StringBuilder(String.valueOf(nextInt)).append(":\tresponse: ").append(property).append(a).toString());
                return a != null ? a : null;
            } else {
                r.a(p.e, new StringBuilder(String.valueOf(nextInt)).append(":\tFailed to get message.").append(str).toString());
                return null;
            }
        } catch (Exception e) {
            r.c(p.e, new StringBuilder(String.valueOf(nextInt)).append(":\tClientProtocolException,Failed to send message.").append(str).toString(), e);
            return null;
        } catch (Exception e2) {
            r.c(p.e, new StringBuilder(String.valueOf(nextInt)).append(":\tIOException,Failed to send message.").append(str).toString(), e2);
            return null;
        }
    }

    protected static String a(String str, String str2) {
        int nextInt = new Random().nextInt(h.E);
        String property = System.getProperty("line.separator");
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, C1012a.b);
        HttpConnectionParams.setSoTimeout(basicHttpParams, a.b);
        HttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        r.a(p.e, new StringBuilder(String.valueOf(nextInt)).append(": POST_URL: ").append(str).toString());
        try {
            HttpUriRequest httpPost = new HttpPost(str);
            if (!TextUtils.isEmpty(str2)) {
                r.a(p.e, new StringBuilder(String.valueOf(nextInt)).append(": POST_BODY: ").append(str2).toString());
                List arrayList = new ArrayList(1);
                arrayList.add(new BasicNameValuePair(b.b, str2));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, com.d.a.a.h.DEFAULT_CHARSET));
            }
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == v.C) {
                HttpEntity entity = execute.getEntity();
                if (entity == null) {
                    return null;
                }
                InputStream content = entity.getContent();
                Header firstHeader = execute.getFirstHeader("Content-Encoding");
                InputStream inflaterInputStream = (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("deflate")) ? content : new InflaterInputStream(content);
                String a = a(inflaterInputStream);
                r.a(p.e, new StringBuilder(String.valueOf(nextInt)).append(":\tresponse: ").append(property).append(a).toString());
                return a == null ? null : a;
            } else {
                r.c(p.e, new StringBuilder(String.valueOf(nextInt)).append(":\tFailed to send message.").append(str).toString());
                return null;
            }
        } catch (Exception e) {
            r.c(p.e, new StringBuilder(String.valueOf(nextInt)).append(":\tClientProtocolException,Failed to send message.").append(str).toString(), e);
            return null;
        } catch (Exception e2) {
            r.c(p.e, new StringBuilder(String.valueOf(nextInt)).append(":\tIOException,Failed to send message.").append(str).toString(), e2);
            return null;
        }
    }
}
