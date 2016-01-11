package com.xiaomi.mistatistic.sdk;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

final class h implements URLStreamHandlerFactory {
    h() {
    }

    public URLStreamHandler createURLStreamHandler(String str) {
        return e.a.containsKey(str) ? new i((URLStreamHandler) e.a.get(str)) : null;
    }
}
