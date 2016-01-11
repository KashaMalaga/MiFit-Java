package android.support.v4.app;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

public class C0041bR extends ca {
    public static final String a = "android.remoteinput.results";
    public static final String b = "android.remoteinput.resultsData";
    public static final cb c = new C0042bS();
    private static final String d = "RemoteInput";
    private static final bU j;
    private final String e;
    private final CharSequence f;
    private final CharSequence[] g;
    private final boolean h;
    private final Bundle i;

    static {
        if (VERSION.SDK_INT >= 20) {
            j = new bV();
        } else if (VERSION.SDK_INT >= 16) {
            j = new bX();
        } else {
            j = new bW();
        }
    }

    C0041bR(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.e = str;
        this.f = charSequence;
        this.g = charSequenceArr;
        this.h = z;
        this.i = bundle;
    }

    public static Bundle a(Intent intent) {
        return j.a(intent);
    }

    public static void a(C0041bR[] c0041bRArr, Intent intent, Bundle bundle) {
        j.a(c0041bRArr, intent, bundle);
    }

    public String a() {
        return this.e;
    }

    public CharSequence b() {
        return this.f;
    }

    public CharSequence[] c() {
        return this.g;
    }

    public boolean d() {
        return this.h;
    }

    public Bundle e() {
        return this.i;
    }
}
