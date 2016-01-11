package com.f.a.c;

import android.graphics.Bitmap;
import com.f.a.a.b.c;
import com.f.a.b.a.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class g {
    private static final String a = "_";
    private static final String b = "x";

    private g() {
    }

    public static String a(String str, f fVar) {
        return a + fVar.a() + b + fVar.b();
    }

    public static Comparator<String> a() {
        return new h();
    }

    public static List<Bitmap> a(String str, c cVar) {
        List<Bitmap> arrayList = new ArrayList();
        for (String str2 : cVar.a()) {
            if (str2.startsWith(str)) {
                arrayList.add(cVar.b(str2));
            }
        }
        return arrayList;
    }

    public static List<String> b(String str, c cVar) {
        List<String> arrayList = new ArrayList();
        for (String str2 : cVar.a()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static void c(String str, c cVar) {
        List<String> arrayList = new ArrayList();
        for (String str2 : cVar.a()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        for (String str22 : arrayList) {
            cVar.a(str22);
        }
    }
}
