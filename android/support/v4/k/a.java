package android.support.v4.k;

import java.util.Locale;

public final class a {
    private static j a = k.c;
    private static final char b = '\u202a';
    private static final char c = '\u202b';
    private static final char d = '\u202c';
    private static final char e = '\u200e';
    private static final char f = '\u200f';
    private static final String g = Character.toString(e);
    private static final String h = Character.toString(f);
    private static final String i = "";
    private static final int j = 2;
    private static final int k = 2;
    private static final a l = new a(false, k, a);
    private static final a m = new a(true, k, a);
    private static final int q = -1;
    private static final int r = 0;
    private static final int s = 1;
    private final boolean n;
    private final int o;
    private final j p;

    private a(boolean z, int i, j jVar) {
        this.n = z;
        this.o = i;
        this.p = jVar;
    }

    public static a a() {
        return new c().a();
    }

    public static a a(Locale locale) {
        return new c(locale).a();
    }

    public static a a(boolean z) {
        return new c(z).a();
    }

    private String b(String str, j jVar) {
        boolean a = jVar.a((CharSequence) str, (int) r, str.length());
        return (this.n || !(a || c(str) == s)) ? (!this.n || (a && c(str) != q)) ? i : h : g;
    }

    private static int c(String str) {
        return new d(str, false).b();
    }

    private String c(String str, j jVar) {
        boolean a = jVar.a((CharSequence) str, (int) r, str.length());
        return (this.n || !(a || d(str) == s)) ? (!this.n || (a && d(str) != q)) ? i : h : g;
    }

    private static boolean c(Locale locale) {
        return s.a(locale) == s;
    }

    private static int d(String str) {
        return new d(str, false).a();
    }

    public String a(String str, j jVar) {
        return a(str, jVar, true);
    }

    public String a(String str, j jVar, boolean z) {
        boolean a = jVar.a((CharSequence) str, (int) r, str.length());
        StringBuilder stringBuilder = new StringBuilder();
        if (c() && z) {
            stringBuilder.append(c(str, a ? k.b : k.a));
        }
        if (a != this.n) {
            stringBuilder.append(a ? c : b);
            stringBuilder.append(str);
            stringBuilder.append(d);
        } else {
            stringBuilder.append(str);
        }
        if (z) {
            stringBuilder.append(b(str, a ? k.b : k.a));
        }
        return stringBuilder.toString();
    }

    public String a(String str, boolean z) {
        return a(str, this.p, z);
    }

    public boolean a(String str) {
        return this.p.a((CharSequence) str, (int) r, str.length());
    }

    public String b(String str) {
        return a(str, this.p, true);
    }

    public boolean b() {
        return this.n;
    }

    public boolean c() {
        return (this.o & k) != 0;
    }
}
