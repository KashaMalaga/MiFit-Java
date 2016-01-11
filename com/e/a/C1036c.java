package com.e.a;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class C1036c {
    private static final int[] a;
    private static final int b = 0;
    private static final int[] c;
    private static final int d = 0;
    private static final int[] e = new int[]{16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;
    private static final int k = 5;
    private static final int l = 6;
    private static final int m = 7;
    private static final int n = 0;
    private static final int o = 0;

    static {
        int[] iArr = new int[g];
        iArr[f] = 16843490;
        a = iArr;
        iArr = new int[g];
        iArr[f] = 16843489;
        c = iArr;
    }

    private static R a(Context context, AttributeSet attributeSet, R r) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
        long j = (long) obtainStyledAttributes.getInt(g, f);
        long j2 = (long) obtainStyledAttributes.getInt(h, f);
        int i = obtainStyledAttributes.getInt(m, f);
        if (r == null) {
            r = new R();
        }
        Object obj = i == 0 ? g : null;
        TypedValue peekValue = obtainStyledAttributes.peekValue(k);
        Object obj2 = peekValue != null ? g : f;
        int i2 = obj2 != null ? peekValue.type : f;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(l);
        Object obj3 = peekValue2 != null ? g : f;
        int i3 = obj3 != null ? peekValue2.type : f;
        if ((obj2 != null && i2 >= 28 && i2 <= 31) || (obj3 != null && i3 >= 28 && i3 <= 31)) {
            obj = null;
            r.a(new C1045l());
        }
        if (obj != null) {
            if (obj2 != null) {
                float dimension = i2 == k ? obtainStyledAttributes.getDimension(k, 0.0f) : obtainStyledAttributes.getFloat(k, 0.0f);
                if (obj3 != null) {
                    float dimension2 = i3 == k ? obtainStyledAttributes.getDimension(l, 0.0f) : obtainStyledAttributes.getFloat(l, 0.0f);
                    float[] fArr = new float[h];
                    fArr[f] = dimension;
                    fArr[g] = dimension2;
                    r.a(fArr);
                } else {
                    float[] fArr2 = new float[g];
                    fArr2[f] = dimension;
                    r.a(fArr2);
                }
            } else {
                float[] fArr3 = new float[g];
                fArr3[f] = i3 == k ? obtainStyledAttributes.getDimension(l, 0.0f) : obtainStyledAttributes.getFloat(l, 0.0f);
                r.a(fArr3);
            }
        } else if (obj2 != null) {
            i2 = i2 == k ? (int) obtainStyledAttributes.getDimension(k, 0.0f) : (i2 < 28 || i2 > 31) ? obtainStyledAttributes.getInt(k, f) : obtainStyledAttributes.getColor(k, f);
            if (obj3 != null) {
                i = i3 == k ? (int) obtainStyledAttributes.getDimension(l, 0.0f) : (i3 < 28 || i3 > 31) ? obtainStyledAttributes.getInt(l, f) : obtainStyledAttributes.getColor(l, f);
                int[] iArr = new int[h];
                iArr[f] = i2;
                iArr[g] = i;
                r.a(iArr);
            } else {
                int[] iArr2 = new int[g];
                iArr2[f] = i2;
                r.a(iArr2);
            }
        } else if (obj3 != null) {
            i = i3 == k ? (int) obtainStyledAttributes.getDimension(l, 0.0f) : (i3 < 28 || i3 > 31) ? obtainStyledAttributes.getInt(l, f) : obtainStyledAttributes.getColor(l, f);
            int[] iArr3 = new int[g];
            iArr3[f] = i;
            r.a(iArr3);
        }
        r.d(j);
        r.a(j2);
        if (obtainStyledAttributes.hasValue(i)) {
            r.a(obtainStyledAttributes.getInt(i, f));
        }
        if (obtainStyledAttributes.hasValue(j)) {
            r.b(obtainStyledAttributes.getInt(j, g));
        }
        i = obtainStyledAttributes.getResourceId(f, f);
        if (i > 0) {
            r.a(AnimationUtils.loadInterpolator(context, i));
        }
        obtainStyledAttributes.recycle();
        return r;
    }

    public static C1034a a(Context context, int i) {
        NotFoundException notFoundException;
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = context.getResources().getAnimation(i);
            C1034a a = C1036c.a(context, (XmlPullParser) xmlResourceParser);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return a;
        } catch (Throwable e) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (Throwable e2) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static C1034a a(Context context, XmlPullParser xmlPullParser) {
        return C1036c.a(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, f);
    }

    private static C1034a a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, C1038e c1038e, int i) {
        int i2 = f;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        C1034a c1034a = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != i || xmlPullParser.getDepth() > depth) && next != g) {
                if (next == h) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        c1034a = C1036c.a(context, attributeSet);
                    } else if (name.equals("animator")) {
                        c1034a = C1036c.a(context, attributeSet, null);
                    } else if (name.equals("set")) {
                        c1034a = new C1038e();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(f, typedValue);
                        C1036c.a(context, xmlPullParser, attributeSet, (C1038e) c1034a, typedValue.type == 16 ? typedValue.data : f);
                        obtainStyledAttributes.recycle();
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (c1038e != null) {
                        ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(c1034a);
                        arrayList = arrayList2;
                    }
                }
            }
        }
        if (!(c1038e == null || arrayList == null)) {
            C1034a[] c1034aArr = new C1034a[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int i3 = i2 + g;
                c1034aArr[i2] = (C1034a) it.next();
                i2 = i3;
            }
            if (i == 0) {
                c1038e.a(c1034aArr);
            } else {
                c1038e.b(c1034aArr);
            }
        }
        return c1034a;
    }

    private static C1055v a(Context context, AttributeSet attributeSet) {
        R c1055v = new C1055v();
        C1036c.a(context, attributeSet, c1055v);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c);
        c1055v.a(obtainStyledAttributes.getString(f));
        obtainStyledAttributes.recycle();
        return c1055v;
    }
}
