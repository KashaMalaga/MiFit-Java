package cn.com.smartdevices.bracelet.chart.typeface;

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

public class c {
    private static final c a = new c();
    private final HashMap<d, WeakReference<Typeface>> b = new HashMap();
    private final HashSet<e> c = new HashSet();

    private c() {
    }

    public static c a() {
        return a;
    }

    public static void a(e eVar) {
        a.c.add(eVar);
    }

    public Typeface a(Context context, d dVar) {
        Typeface typeface;
        Typeface typeface2 = null;
        if (dVar != null) {
            if (this.b.containsKey(dVar)) {
                typeface2 = (Typeface) ((WeakReference) this.b.get(dVar)).get();
                if (typeface2 == null) {
                    typeface = typeface2;
                }
            } else {
                typeface = null;
            }
            try {
                typeface2 = Typeface.createFromAsset(context.getAssets(), dVar.a());
            } catch (Exception e) {
                e.printStackTrace();
                typeface2 = typeface;
            }
            if (typeface2 != null) {
                this.b.put(dVar, new WeakReference(typeface2));
            }
        }
        return typeface2;
    }

    public Typeface a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                d a = ((e) it.next()).a(str);
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

    public void a(TextView textView, d dVar) {
        Typeface a = a(textView.getContext(), dVar);
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
