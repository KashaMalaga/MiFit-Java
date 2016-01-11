package com.xiaomi.c.a;

import java.util.HashMap;
import java.util.Map;

final class C1089t {
    static final C1089t a = C1089t.a("bad-request", "The format of an HTTP header or binding element received from the client is unacceptable (e.g., syntax error).", Integer.valueOf(400));
    static final C1089t b = C1089t.a("host-gone", "The target domain specified in the 'to' attribute or the target host or port specified in the 'route' attribute is no longer serviced by the connection manager.");
    static final C1089t c = C1089t.a("host-unknown", "The target domain specified in the 'to' attribute or the target host or port specified in the 'route' attribute is unknown to the connection manager.");
    static final C1089t d = C1089t.a("improper-addressing", "The initialization element lacks a 'to' or 'route' attribute (or the attribute has no value) but the connection manager requires one.");
    static final C1089t e = C1089t.a("internal-server-error", "The connection manager has experienced an internal error that prevents it from servicing the request.");
    static final C1089t f = C1089t.a("item-not-found", "(1) 'sid' is not valid, (2) 'stream' is not valid, (3) 'rid' is larger than the upper limit of the expected window, (4) connection manager is unable to resend response, (5) 'key' sequence is invalid.", Integer.valueOf(404));
    static final C1089t g = C1089t.a("other-request", "Another request being processed at the same time as this request caused the session to terminate.");
    static final C1089t h = C1089t.a("policy-violation", "The client has broken the session rules (polling too frequently, requesting too frequently, sending too many simultaneous requests).", Integer.valueOf(403));
    static final C1089t i = C1089t.a("remote-connection-failed", "The connection manager was unable to connect to, or unable to connect securely to, or has lost its connection to, the server.");
    static final C1089t j = C1089t.a("remote-stream-error", "Encapsulated transport protocol error.");
    static final C1089t k = C1089t.a("see-other-uri", "The connection manager does not operate at this URI (e.g., the connection manager accepts only SSL or TLS connections at some https: URI rather than the http: URI requested by the client).");
    static final C1089t l = C1089t.a("system-shutdown", "The connection manager is being shut down. All active HTTP sessions are being terminated. No new sessions can be created.");
    static final C1089t m = C1089t.a("undefined-condition", "Unknown or undefined error condition.");
    private static final Map<String, C1089t> n = new HashMap();
    private static final Map<Integer, C1089t> o = new HashMap();
    private final String p;
    private final String q;

    private C1089t(String str, String str2) {
        this.p = str;
        this.q = str2;
    }

    static C1089t a(int i) {
        return (C1089t) o.get(Integer.valueOf(i));
    }

    static C1089t a(String str) {
        return (C1089t) n.get(str);
    }

    private static C1089t a(String str, String str2) {
        return C1089t.a(str, str2, null);
    }

    private static C1089t a(String str, String str2, Integer num) {
        if (str == null) {
            throw new IllegalArgumentException("condition may not be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("message may not be null");
        } else if (n.get(str) != null) {
            throw new IllegalStateException("Multiple definitions of condition: " + str);
        } else {
            C1089t c1089t = new C1089t(str, str2);
            n.put(str, c1089t);
            if (num != null) {
                if (o.get(num) != null) {
                    throw new IllegalStateException("Multiple definitions of code: " + num);
                }
                o.put(num, c1089t);
            }
            return c1089t;
        }
    }

    String a() {
        return this.p;
    }

    String b() {
        return this.q;
    }
}
