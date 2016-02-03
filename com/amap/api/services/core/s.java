package com.amap.api.services.core;

import com.xiaomi.e.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.zip.GZIPInputStream;

public abstract class s<T, V> {
    protected int maxTry = 1;
    protected Proxy proxy;
    protected String recommandURL = a.f;
    protected T task;

    public s(T t, Proxy proxy) {
        a(t, proxy);
    }

    public s(Proxy proxy) {
        a(null, proxy);
    }

    private V a() {
        AMapException e;
        Throwable th;
        int i = 0;
        V v = null;
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        while (i < this.maxTry) {
            InputStream sendRequest;
            try {
                this.recommandURL = getUrl();
                byte[] makeProtobufRequestBytes = makeProtobufRequestBytes();
                httpURLConnection = makeProtobufRequestBytes == null ? j.a(this.recommandURL, this.proxy) : j.a(this.recommandURL, makeProtobufRequestBytes, this.proxy);
                sendRequest = sendRequest(httpURLConnection);
                try {
                    v = a(sendRequest);
                    i = this.maxTry;
                    if (sendRequest != null) {
                        try {
                            sendRequest.close();
                            inputStream = null;
                        } catch (IOException e2) {
                            throw new AMapException(AMapException.ERROR_IO);
                        }
                    }
                    inputStream = sendRequest;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        httpURLConnection = null;
                    }
                } catch (AMapException e3) {
                    e = e3;
                    i++;
                    try {
                        if (i < this.maxTry) {
                            throw new AMapException(e.getErrorMessage());
                        }
                        if (sendRequest == null) {
                            try {
                                sendRequest.close();
                                inputStream = null;
                            } catch (IOException e4) {
                                throw new AMapException(AMapException.ERROR_IO);
                            }
                        }
                        inputStream = sendRequest;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            httpURLConnection = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = sendRequest;
                    }
                }
            } catch (AMapException e5) {
                AMapException aMapException = e5;
                sendRequest = inputStream;
                e = aMapException;
                i++;
                if (i < this.maxTry) {
                    if (sendRequest == null) {
                        inputStream = sendRequest;
                    } else {
                        sendRequest.close();
                        inputStream = null;
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        httpURLConnection = null;
                    }
                } else {
                    throw new AMapException(e.getErrorMessage());
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return v;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e6) {
                throw new AMapException(AMapException.ERROR_IO);
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        throw th;
    }

    private V a(InputStream inputStream) {
        return loadData(inputStream);
    }

    private void a(T t, Proxy proxy) {
        this.task = t;
        this.proxy = proxy;
        this.maxTry = 1;
    }

    public V getData() {
        return this.task != null ? a() : null;
    }

    protected byte[] getProtoBufferRequest() {
        try {
            return getRequestStr().getBytes(kankan.wheel.widget.a.bO);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String getRequestStr() {
        return e.a(getRequestString(false), getRequestString(true));
    }

    protected abstract String getRequestString(boolean z);

    protected abstract String getUrl();

    protected V loadData(InputStream inputStream) {
        String str;
        try {
            str = new String(e.a(inputStream), kankan.wheel.widget.a.bO);
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null || str.equals(a.f)) {
            return null;
        }
        e.b(str);
        return paseJSON(str);
    }

    protected byte[] makeProtobufRequestBytes() {
        return getProtoBufferRequest();
    }

    protected V onExceptionOccur() {
        return null;
    }

    protected abstract V paseJSON(String str);

    protected InputStream sendRequest(HttpURLConnection httpURLConnection) {
        try {
            InputStream pushbackInputStream = new PushbackInputStream(httpURLConnection.getInputStream(), 2);
            byte[] bArr = new byte[2];
            if (pushbackInputStream.read(bArr) != 2) {
                return pushbackInputStream;
            }
            pushbackInputStream.unread(bArr);
            return (bArr[0] == (byte) 31 && bArr[1] == (byte) -117) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
        } catch (ProtocolException e) {
            throw new AMapException(AMapException.ERROR_PROTOCOL);
        } catch (UnknownHostException e2) {
            throw new AMapException(AMapException.ERROR_UNKNOW_HOST);
        } catch (UnknownServiceException e3) {
            throw new AMapException(AMapException.ERROR_UNKNOW_SERVICE);
        } catch (IOException e4) {
            throw new AMapException(AMapException.ERROR_IO);
        }
    }

    protected String strEncoder(String str, boolean z) {
        String str2 = a.f;
        if (!z) {
            return str;
        }
        try {
            return URLEncoder.encode(str, kankan.wheel.widget.a.bO);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str2;
        } catch (Exception e2) {
            return str2;
        }
    }
}
