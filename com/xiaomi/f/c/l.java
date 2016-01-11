package com.xiaomi.f.c;

public class l {
    public static final l a = new l("internal-server-error");
    public static final l b = new l("forbidden");
    public static final l c = new l("bad-request");
    public static final l d = new l("conflict");
    public static final l e = new l("feature-not-implemented");
    public static final l f = new l("gone");
    public static final l g = new l("item-not-found");
    public static final l h = new l("jid-malformed");
    public static final l i = new l("not-acceptable");
    public static final l j = new l("not-allowed");
    public static final l k = new l("not-authorized");
    public static final l l = new l("payment-required");
    public static final l m = new l("recipient-unavailable");
    public static final l n = new l("redirect");
    public static final l o = new l("registration-required");
    public static final l p = new l("remote-server-error");
    public static final l q = new l("remote-server-not-found");
    public static final l r = new l("remote-server-timeout");
    public static final l s = new l("resource-constraint");
    public static final l t = new l("service-unavailable");
    public static final l u = new l("subscription-required");
    public static final l v = new l("undefined-condition");
    public static final l w = new l("unexpected-request");
    public static final l x = new l("request-timeout");
    private String y;

    public l(String str) {
        this.y = str;
    }

    public String toString() {
        return this.y;
    }
}
