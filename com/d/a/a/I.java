package com.d.a.a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class I extends SSLSocketFactory {
    SSLContext a = SSLContext.getInstance("TLS");

    public I(KeyStore keyStore) {
        super(keyStore);
        J j = new J(this);
        this.a.init(null, new TrustManager[]{j}, null);
    }

    public static KeyStore a(InputStream inputStream) {
        InputStream bufferedInputStream;
        Certificate generateCertificate;
        CertificateException e;
        Object obj;
        KeyStore instance;
        Exception exception;
        KeyStore keyStore;
        Exception exception2;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            CertificateFactory instance2 = CertificateFactory.getInstance("X.509");
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                generateCertificate = instance2.generateCertificate(bufferedInputStream);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (CertificateException e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            obj = inputStream2;
                        }
                    }
                    obj = inputStream2;
                    instance = KeyStore.getInstance(KeyStore.getDefaultType());
                    try {
                        instance.load(null, null);
                        instance.setCertificateEntry("ca", generateCertificate);
                        return instance;
                    } catch (Exception e5) {
                        exception = e5;
                        keyStore = instance;
                        exception2 = exception;
                        exception2.printStackTrace();
                        return keyStore;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = bufferedInputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (CertificateException e7) {
            e = e7;
            bufferedInputStream = inputStream2;
            e.printStackTrace();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            obj = inputStream2;
            instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(null, null);
            instance.setCertificateEntry("ca", generateCertificate);
            return instance;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
        try {
            instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(null, null);
            instance.setCertificateEntry("ca", generateCertificate);
            return instance;
        } catch (Exception e52) {
            exception = e52;
            keyStore = inputStream2;
            exception2 = exception;
            exception2.printStackTrace();
            return keyStore;
        }
    }

    public static DefaultHttpClient a(KeyStore keyStore) {
        try {
            SocketFactory i = new I(keyStore);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", i, 443));
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, h.DEFAULT_CHARSET);
            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    public static KeyStore b() {
        KeyStore instance;
        Throwable th;
        try {
            instance = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                instance.load(null, null);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return instance;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            instance = null;
            th = th4;
            th.printStackTrace();
            return instance;
        }
        return instance;
    }

    public static SSLSocketFactory c() {
        try {
            SSLSocketFactory i = new I(b());
            i.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return i;
        } catch (Throwable th) {
            th.printStackTrace();
            return SSLSocketFactory.getSocketFactory();
        }
    }

    public void a() {
        HttpsURLConnection.setDefaultSSLSocketFactory(this.a.getSocketFactory());
    }

    public Socket createSocket() {
        return this.a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.a.getSocketFactory().createSocket(socket, str, i, z);
    }
}
