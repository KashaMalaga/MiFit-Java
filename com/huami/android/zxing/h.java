package com.huami.android.zxing;

import android.content.Intent;
import android.net.Uri;
import com.c.b.a;
import com.xiaomi.mipush.sdk.f;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

final class h {
    static final Set<a> a = EnumSet.of(a.UPC_A, new a[]{a.UPC_E, a.EAN_13, a.EAN_8, a.RSS_14, a.RSS_EXPANDED});
    static final Set<a> b = EnumSet.of(a.CODE_39, a.CODE_93, a.CODE_128, a.ITF, a.CODABAR);
    static final Set<a> c = EnumSet.of(a.QR_CODE);
    static final Set<a> d = EnumSet.of(a.DATA_MATRIX);
    static final Set<a> e = EnumSet.of(a.AZTEC);
    static final Set<a> f = EnumSet.of(a.PDF_417);
    private static final Pattern g = Pattern.compile(f.i);
    private static final Set<a> h = EnumSet.copyOf(a);
    private static final Map<String, Set<a>> i = new HashMap();

    static {
        h.addAll(b);
        i.put(v.d, h);
        i.put(v.c, a);
        i.put(v.e, c);
        i.put(v.f, d);
        i.put(v.g, e);
        i.put(v.h, f);
    }

    private h() {
    }

    static Set<a> a(Intent intent) {
        Iterable iterable = null;
        CharSequence stringExtra = intent.getStringExtra(v.i);
        if (stringExtra != null) {
            iterable = Arrays.asList(g.split(stringExtra));
        }
        return a(iterable, intent.getStringExtra(v.b));
    }

    static Set<a> a(Uri uri) {
        Iterable queryParameters = uri.getQueryParameters(v.i);
        if (!(queryParameters == null || queryParameters.size() != 1 || queryParameters.get(0) == null)) {
            queryParameters = Arrays.asList(g.split((CharSequence) queryParameters.get(0)));
        }
        return a(queryParameters, uri.getQueryParameter(v.b));
    }

    private static Set<a> a(Iterable<String> iterable, String str) {
        if (iterable != null) {
            Set<a> noneOf = EnumSet.noneOf(a.class);
            try {
                for (String valueOf : iterable) {
                    noneOf.add(a.valueOf(valueOf));
                }
                return noneOf;
            } catch (IllegalArgumentException e) {
            }
        }
        return str != null ? (Set) i.get(str) : null;
    }
}
