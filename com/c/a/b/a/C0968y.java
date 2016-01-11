package com.c.a.b.a;

import com.c.a.N;
import com.c.a.P;
import com.c.a.c.a;
import com.c.a.w;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;

public final class C0968y {
    public static final N<StringBuffer> A = new H();
    public static final P B = C0968y.a(StringBuffer.class, A);
    public static final N<URL> C = new I();
    public static final P D = C0968y.a(URL.class, C);
    public static final N<URI> E = new J();
    public static final P F = C0968y.a(URI.class, E);
    public static final N<InetAddress> G = new L();
    public static final P H = C0968y.b(InetAddress.class, G);
    public static final N<UUID> I = new M();
    public static final P J = C0968y.a(UUID.class, I);
    public static final P K = new N();
    public static final N<Calendar> L = new P();
    public static final P M = C0968y.b(Calendar.class, GregorianCalendar.class, L);
    public static final N<Locale> N = new Q();
    public static final P O = C0968y.a(Locale.class, N);
    public static final N<w> P = new R();
    public static final P Q = C0968y.b(w.class, P);
    public static final P R = C0968y.a();
    public static final N<Class> a = new C0969z();
    public static final P b = C0968y.a(Class.class, a);
    public static final N<BitSet> c = new K();
    public static final P d = C0968y.a(BitSet.class, c);
    public static final N<Boolean> e = new W();
    public static final N<Boolean> f = new aa();
    public static final P g = C0968y.a(Boolean.TYPE, Boolean.class, e);
    public static final N<Number> h = new ab();
    public static final P i = C0968y.a(Byte.TYPE, Byte.class, h);
    public static final N<Number> j = new ac();
    public static final P k = C0968y.a(Short.TYPE, Short.class, j);
    public static final N<Number> l = new ad();
    public static final P m = C0968y.a(Integer.TYPE, Integer.class, l);
    public static final N<Number> n = new ae();
    public static final N<Number> o = new af();
    public static final N<Number> p = new A();
    public static final N<Number> q = new B();
    public static final P r = C0968y.a(Number.class, q);
    public static final N<Character> s = new C();
    public static final P t = C0968y.a(Character.TYPE, Character.class, s);
    public static final N<String> u = new D();
    public static final N<BigDecimal> v = new E();
    public static final N<BigInteger> w = new F();
    public static final P x = C0968y.a(String.class, u);
    public static final N<StringBuilder> y = new G();
    public static final P z = C0968y.a(StringBuilder.class, y);

    private C0968y() {
    }

    public static P a() {
        return new S();
    }

    public static <TT> P a(a<TT> aVar, N<TT> n) {
        return new T(aVar, n);
    }

    public static <TT> P a(Class<TT> cls, N<TT> n) {
        return new U(cls, n);
    }

    public static <TT> P a(Class<TT> cls, Class<TT> cls2, N<? super TT> n) {
        return new V(cls, cls2, n);
    }

    public static <TT> P b(Class<TT> cls, N<TT> n) {
        return new Y(cls, n);
    }

    public static <TT> P b(Class<TT> cls, Class<? extends TT> cls2, N<? super TT> n) {
        return new X(cls, cls2, n);
    }
}
