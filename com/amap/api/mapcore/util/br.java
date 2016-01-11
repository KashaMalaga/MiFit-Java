package com.amap.api.mapcore.util;

import android.os.Build.VERSION;
import com.activeandroid.b;
import com.d.a.a.h;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.b.v;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class br {
    private static bs a;
    private static TrustManager g = new bw();
    private int b;
    private int c;
    private boolean d;
    private SSLContext e;
    private Proxy f;

    br(int i, int i2, Proxy proxy) {
        this(i, i2, proxy, false);
    }

    br(int i, int i2, Proxy proxy, boolean z) {
        this.b = i;
        this.c = i2;
        this.f = proxy;
        this.d = z;
        if (z) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, new TrustManager[]{g}, null);
                this.e = instance;
            } catch (Throwable e) {
                az.a(e, "HttpUrlUtil", "HttpUrlUtil");
                e.printStackTrace();
            } catch (Throwable e2) {
                az.a(e2, "HttpUrlUtil", "HttpUrlUtil");
                e2.printStackTrace();
            } catch (Throwable e22) {
                az.a(e22, "HttpUtil", "HttpUtil");
                e22.printStackTrace();
            }
        }
    }

    private String a(Map<String, String> map) {
        List linkedList = new LinkedList();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                linkedList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        return linkedList.size() > 0 ? URLEncodedUtils.format(linkedList, h.DEFAULT_CHARSET) : null;
    }

    private HttpURLConnection a(URL url) {
        HttpURLConnection httpURLConnection;
        if (this.f != null) {
            URLConnection openConnection = url.openConnection(this.f);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (this.d) {
            httpURLConnection = (HttpsURLConnection) openConnection;
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.e.getSocketFactory());
        } else {
            httpURLConnection = (HttpURLConnection) openConnection;
        }
        if (VERSION.SDK != null && VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        return httpURLConnection;
    }

    public static void a(bs bsVar) {
        a = bsVar;
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, (String) map.get(str));
            }
        }
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.c);
    }

    private byte[] a(HttpURLConnection httpURLConnection) {
        IOException e;
        Throwable th;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != v.C) {
                throw new v("\u7f51\u7edc\u5f02\u5e38\u539f\u56e0\uff1a" + httpURLConnection.getResponseMessage() + " \u7f51\u7edc\u5f02\u5e38\u72b6\u6001\u7801\uff1a" + responseCode);
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStream = httpURLConnection.getInputStream();
                InputStream pushbackInputStream = new PushbackInputStream(inputStream, 2);
                byte[] bArr = new byte[2];
                pushbackInputStream.read(bArr);
                pushbackInputStream.unread(bArr);
                InputStream gZIPInputStream = (bArr[0] == (byte) 31 && bArr[1] == (byte) -117) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                byte[] bArr2 = new byte[b.a];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                if (a != null) {
                    a.a();
                }
                bArr = byteArrayOutputStream.toByteArray();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e2) {
                        az.a(e2, "HttpUrlUtil", "parseResult");
                        e2.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        az.a(e3, "HttpUrlUtil", "parseResult");
                        e3.printStackTrace();
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e32) {
                        az.a(e32, "HttpUrlUtil", "parseResult");
                        e32.printStackTrace();
                    }
                }
                return bArr;
            } catch (IOException e4) {
                e = e4;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (IOException e5) {
            e = e5;
            byteArrayOutputStream = inputStream;
            throw e;
        } catch (Throwable th3) {
            th = th3;
            Object obj = inputStream;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e22) {
                    az.a(e22, "HttpUrlUtil", "parseResult");
                    e22.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e322) {
                    az.a(e322, "HttpUrlUtil", "parseResult");
                    e322.printStackTrace();
                }
            }
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable e3222) {
                    az.a(e3222, "HttpUrlUtil", "parseResult");
                    e3222.printStackTrace();
                }
            }
            throw th;
        }
    }

    byte[] a(String str, Map<String, String> map, Map<String, String> map2) {
        try {
            String a = a((Map) map2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            if (a != null) {
                stringBuffer.append("?").append(a);
            }
            HttpURLConnection a2 = a(new URL(stringBuffer.toString()));
            a(map, a2);
            a2.setRequestMethod(Constants.HTTP_GET);
            a2.setDoInput(true);
            a2.connect();
            return a(a2);
        } catch (Throwable e) {
            az.a(e, "HttpUrlUtil", "getRequest");
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            az.a(e2, "HttpUrlUtil", "getRequest");
            e2.printStackTrace();
            return null;
        } catch (Throwable e22) {
            az.a(e22, "HttpUrlUtil", "getRequest");
            e22.printStackTrace();
            return null;
        }
    }

    byte[] a(String str, Map<String, String> map, HttpEntity httpEntity) {
        InputStream content;
        Throwable e;
        Exception e2;
        Throwable th;
        byte[] bArr = null;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                content = httpEntity.getContent();
                try {
                    byte[] bArr2 = new byte[b.a];
                    while (true) {
                        int read = content.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = a(str, (Map) map, byteArrayOutputStream.toByteArray());
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e3) {
                            az.a(e3, "HttpUrlUtil", "postRequest2");
                            e3.printStackTrace();
                        }
                    }
                    if (content != null) {
                        try {
                            content.close();
                        } catch (Exception e4) {
                            e2 = e4;
                            az.a((Throwable) e2, "HttpUrlUtil", "postRequest2");
                            e2.printStackTrace();
                            return bArr;
                        }
                    }
                } catch (IllegalStateException e5) {
                    e3 = e5;
                    try {
                        az.a(e3, "HttpUrlUtil", "postRequest2");
                        e3.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e32) {
                                az.a(e32, "HttpUrlUtil", "postRequest2");
                                e32.printStackTrace();
                            }
                        }
                        if (content != null) {
                            try {
                                content.close();
                            } catch (Exception e6) {
                                e32 = e6;
                                az.a(e32, "HttpUrlUtil", "postRequest2");
                                e2.printStackTrace();
                                return bArr;
                            }
                        }
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e322) {
                                az.a(e322, "HttpUrlUtil", "postRequest2");
                                e322.printStackTrace();
                            }
                        }
                        if (content != null) {
                            try {
                                content.close();
                            } catch (Throwable e3222) {
                                az.a(e3222, "HttpUrlUtil", "postRequest2");
                                e3222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e3222 = e7;
                    az.a(e3222, "HttpUrlUtil", "postRequest2");
                    e3222.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e32222) {
                            az.a(e32222, "HttpUrlUtil", "postRequest2");
                            e32222.printStackTrace();
                        }
                    }
                    if (content != null) {
                        try {
                            content.close();
                        } catch (Exception e8) {
                            e32222 = e8;
                            az.a(e32222, "HttpUrlUtil", "postRequest2");
                            e2.printStackTrace();
                            return bArr;
                        }
                    }
                    return bArr;
                } catch (Throwable th3) {
                    e32222 = th3;
                    az.a(e32222, "HttpUrlUtil", "postRequest2");
                    e32222.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e322222) {
                            az.a(e322222, "HttpUrlUtil", "postRequest2");
                            e322222.printStackTrace();
                        }
                    }
                    if (content != null) {
                        try {
                            content.close();
                        } catch (Exception e9) {
                            e322222 = e9;
                            az.a(e322222, "HttpUrlUtil", "postRequest2");
                            e2.printStackTrace();
                            return bArr;
                        }
                    }
                    return bArr;
                }
            } catch (IllegalStateException e10) {
                e322222 = e10;
                content = bArr;
                az.a(e322222, "HttpUrlUtil", "postRequest2");
                e322222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (content != null) {
                    content.close();
                }
                return bArr;
            } catch (IOException e11) {
                e322222 = e11;
                content = bArr;
                az.a(e322222, "HttpUrlUtil", "postRequest2");
                e322222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (content != null) {
                    content.close();
                }
                return bArr;
            } catch (Throwable e3222222) {
                content = bArr;
                th = e3222222;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (content != null) {
                    content.close();
                }
                throw th;
            }
        } catch (IllegalStateException e12) {
            e3222222 = e12;
            content = bArr;
            byteArrayOutputStream = bArr;
            az.a(e3222222, "HttpUrlUtil", "postRequest2");
            e3222222.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (content != null) {
                content.close();
            }
            return bArr;
        } catch (IOException e13) {
            e3222222 = e13;
            content = bArr;
            byteArrayOutputStream = bArr;
            az.a(e3222222, "HttpUrlUtil", "postRequest2");
            e3222222.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (content != null) {
                content.close();
            }
            return bArr;
        } catch (Throwable e32222222) {
            content = bArr;
            byteArrayOutputStream = bArr;
            th = e32222222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (content != null) {
                content.close();
            }
            throw th;
        }
        return bArr;
    }

    byte[] a(String str, Map<String, String> map, byte[] bArr) {
        try {
            HttpURLConnection a = a(new URL(str));
            a(map, a);
            a.setRequestMethod(Constants.HTTP_POST);
            a.setUseCaches(false);
            a.setDoInput(true);
            a.setDoOutput(true);
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(a.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            }
            a.connect();
            return a(a);
        } catch (Throwable e) {
            az.a(e, "HttpUrlUtil", "postRequest");
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            az.a(e2, "HttpUrlUtil", "postRequest");
            e2.printStackTrace();
            return null;
        } catch (Throwable e22) {
            az.a(e22, "HttpUrlUtil", "postRequest");
            e22.printStackTrace();
            return null;
        }
    }

    byte[] b(String str, Map<String, String> map, Map<String, String> map2) {
        String a = a((Map) map2);
        if (a == null) {
            return a(str, (Map) map, new byte[0]);
        }
        try {
            return a(str, (Map) map, a.getBytes(h.DEFAULT_CHARSET));
        } catch (Throwable e) {
            az.a(e, "HttpUrlUtil", "postRequest1");
            e.printStackTrace();
            return a(str, (Map) map, a.getBytes());
        }
    }
}
