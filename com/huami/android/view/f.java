package com.huami.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class f {
    private static final f a = new f();
    private final HashMap<g, WeakReference<Typeface>> b = new HashMap();
    private final HashSet<h> c = new HashSet();

    private f() {
    }

    public static f a() {
        return a;
    }

    public static void a(h hVar) {
        a.c.add(hVar);
    }

    public Typeface a(Context context, g gVar) {
        Typeface typeface;
        Typeface typeface2 = null;
        if (gVar != null) {
            if (this.b.containsKey(gVar)) {
                typeface2 = (Typeface) ((WeakReference) this.b.get(gVar)).get();
                if (typeface2 == null) {
                    typeface = typeface2;
                }
            } else {
                typeface = null;
            }
            try {
                typeface2 = Typeface.createFromAsset(context.getAssets(), gVar.b());
            } catch (Exception e) {
                e.printStackTrace();
                typeface2 = typeface;
            }
            if (typeface2 != null) {
                this.b.put(gVar, new WeakReference(typeface2));
            }
        }
        return typeface2;
    }

    public Typeface a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                g a = ((h) it.next()).a(str);
                if (a != null) {
                    return a(context, a);
                }
            }
        }
        return null;
    }

    public void a(TextView textView, Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843692});
        a(textView, obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
    }

    public void a(TextView textView, g gVar) {
        Typeface a = a(textView.getContext(), gVar);
        if (a != null) {
            textView.setTypeface(a);
        }
    }

    public void a(TextView textView, String str) {
        Typeface a = a(textView.getContext(), str);
        if (a != null) {
            textView.setTypeface(a);
        }
    }
}
