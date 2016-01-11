package com.amap.api.services.core;

import cn.com.smartdevices.bracelet.d.C0430g;
import com.d.a.a.C1012a;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.b.v;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import kankan.wheel.widget.a;

public class j {
    public static HttpURLConnection a(String str, Proxy proxy) {
        if (str == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = proxy != null ? (HttpURLConnection) url.openConnection(proxy) : (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(Constants.HTTP_GET);
            httpURLConnection.setConnectTimeout(a.as);
            httpURLConnection.setReadTimeout(50000);
            httpURLConnection.setRequestProperty(C1012a.f, C1012a.g);
            httpURLConnection.setRequestProperty("User-Agent", "AMAP SDK Android Search 2.3.0");
            httpURLConnection.setRequestProperty("X-INFO", d.a(null).a());
            httpURLConnection.setRequestProperty("ia", Constants.VIA_TO_TYPE_QQ_GROUP);
            httpURLConnection.setRequestProperty("ec", Constants.VIA_TO_TYPE_QQ_GROUP);
            httpURLConnection.setRequestProperty(C0430g.b, d.a(null).f());
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == v.C) {
                return httpURLConnection;
            }
            throw new AMapException(AMapException.ERROR_CONNECTION);
        } catch (UnknownHostException e) {
            throw new AMapException(AMapException.ERROR_UNKNOW_HOST);
        } catch (MalformedURLException e2) {
            throw new AMapException(AMapException.ERROR_URL);
        } catch (ProtocolException e3) {
            throw new AMapException(AMapException.ERROR_PROTOCOL);
        } catch (SocketTimeoutException e4) {
            throw new AMapException(AMapException.ERROR_SOCKE_TIME_OUT);
        } catch (IOException e5) {
            throw new AMapException(AMapException.ERROR_IO);
        }
    }

    public static HttpURLConnection a(String str, byte[] bArr, Proxy proxy) {
        if (str == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = proxy != null ? (HttpURLConnection) url.openConnection(proxy) : (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(a.as);
            httpURLConnection.setReadTimeout(50000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
            httpURLConnection.setRequestProperty(C1012a.f, C1012a.g);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("User-Agent", "AMAP SDK Android Search 2.3.0");
            httpURLConnection.setRequestProperty("X-INFO", d.a(null).a());
            httpURLConnection.setRequestProperty("ia", Constants.VIA_TO_TYPE_QQ_GROUP);
            httpURLConnection.setRequestProperty("ec", Constants.VIA_TO_TYPE_QQ_GROUP);
            httpURLConnection.setRequestProperty(C0430g.b, d.a(null).f());
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
            if (httpURLConnection.getResponseCode() == v.C) {
                return httpURLConnection;
            }
            throw new AMapException(AMapException.ERROR_CONNECTION);
        } catch (UnknownHostException e) {
            throw new AMapException(AMapException.ERROR_UNKNOW_HOST);
        } catch (MalformedURLException e2) {
            throw new AMapException(AMapException.ERROR_URL);
        } catch (ProtocolException e3) {
            throw new AMapException(AMapException.ERROR_PROTOCOL);
        } catch (SocketTimeoutException e4) {
            e4.printStackTrace();
            throw new AMapException(AMapException.ERROR_SOCKE_TIME_OUT);
        } catch (IOException e5) {
            throw new AMapException(AMapException.ERROR_IO);
        }
    }
}
