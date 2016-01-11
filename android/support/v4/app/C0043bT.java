package android.support.v4.app;

import android.os.Bundle;

public final class C0043bT {
    private final String a;
    private CharSequence b;
    private CharSequence[] c;
    private boolean d = true;
    private Bundle e = new Bundle();

    public C0043bT(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Result key can't be null");
        }
        this.a = str;
    }

    public Bundle a() {
        return this.e;
    }

    public C0043bT a(Bundle bundle) {
        if (bundle != null) {
            this.e.putAll(bundle);
        }
        return this;
    }

    public C0043bT a(CharSequence charSequence) {
        this.b = charSequence;
        return this;
    }

    public C0043bT a(boolean z) {
        this.d = z;
        return this;
    }

    public C0043bT a(CharSequence[] charSequenceArr) {
        this.c = charSequenceArr;
        return this;
    }

    public C0041bR b() {
        return new C0041bR(this.a, this.b, this.c, this.d, this.e);
    }
}
