package com.d.a.a;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class J implements X509TrustManager {
    final /* synthetic */ I a;

    J(I i) {
        this.a = i;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
