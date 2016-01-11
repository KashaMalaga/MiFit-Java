package com.amap.api.mapcore.util;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class bw implements X509TrustManager {
    bw() {
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
