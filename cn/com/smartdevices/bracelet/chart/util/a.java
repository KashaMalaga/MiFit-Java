package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import kankan.wheel.widget.l;

public class a {
    public static final int a = 600;
    public static final int b = 600;
    public static final int c = 20;
    public static final int d = 800;
    public static final int e = 3500;
    public static final int f = 300;
    public static final int g = 650;
    public static final int h = 550;
    private static final String i = "Chart.AnimUtil";
    private static LayoutTransition j;
    private static LayoutTransition k;

    public static long a(AnimatorSet animatorSet) {
        Iterator it = animatorSet.getChildAnimations().iterator();
        long j = 0;
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            long duration = animator.getDuration() + animator.getStartDelay();
            if (duration <= j) {
                duration = j;
            }
            j = duration;
        }
        return j;
    }

    public static Animator a(float f, float f2, int i, TextView textView) {
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new n(textView, i));
        return ofFloat;
    }

    public static Animator a(int i, int i2, TextView textView) {
        int i3;
        int i4 = i2 - i;
        String valueOf = String.valueOf(Math.abs(i4));
        int[] iArr = new int[valueOf.length()];
        for (i3 = 0; i3 < valueOf.length(); i3++) {
            iArr[i3] = valueOf.charAt((valueOf.length() - i3) - 1) - 48;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(b(i));
        int i5 = 1;
        for (int valueOf2 : iArr) {
            int valueOf22;
            int intValue = Integer.valueOf(valueOf22).intValue();
            for (valueOf22 = 0; valueOf22 < intValue; valueOf22++) {
                if (i4 > 0) {
                    i += i5;
                } else if (i4 < 0) {
                    i -= i5;
                }
                arrayList.add(b(i));
            }
            i5 *= 10;
        }
        arrayList.add(b(i2));
        Keyframe[] keyframeArr = new Keyframe[(arrayList.size() + 1)];
        i3 = 0;
        while (i3 <= arrayList.size()) {
            keyframeArr[i3] = Keyframe.ofObject(((float) i3) * (1.0f / ((float) arrayList.size())), arrayList.get(i3 == 0 ? 0 : i3 - 1));
            i3++;
        }
        Animator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("Text", keyframeArr)});
        ofPropertyValuesHolder.setEvaluator(new i());
        ofPropertyValuesHolder.addUpdateListener(new j(textView));
        ofPropertyValuesHolder.setDuration((long) (keyframeArr.length * c));
        return ofPropertyValuesHolder;
    }

    public static Animator a(int i, int i2, p pVar, View... viewArr) {
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new o(Color.red(i2), Color.red(i), Color.green(i2), Color.green(i), Color.blue(i2), Color.blue(i), viewArr, pVar));
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(500);
        return ofFloat;
    }

    public static Animator a(int i, int i2, View... viewArr) {
        return a(i, i2, null, viewArr);
    }

    public static Animator a(int i, View view) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, (float) (-i)});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("alpha", new float[]{0.7f, 0.0f});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2});
    }

    public static Animator a(AnimatorUpdateListener animatorUpdateListener) {
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(animatorUpdateListener);
        return ofFloat;
    }

    public static Animator a(View view) {
        Animator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.3f, 1.0f});
        ofFloat.setInterpolator(new AccelerateInterpolator());
        return ofFloat;
    }

    public static Animator a(View view, float f, float f2) {
        return ObjectAnimator.ofFloat(view, "alpha", new float[]{f, f2});
    }

    public static Animator a(String str, String str2, TextView textView, TextView textView2) {
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addListener(new b(textView, str, textView2, str2));
        ofFloat.addUpdateListener(new h(textView, textView2));
        ofFloat.setDuration(600);
        return ofFloat;
    }

    private static LayoutTransition a() {
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setDuration(90);
        layoutTransition.setInterpolator(2, new AccelerateDecelerateInterpolator());
        layoutTransition.setInterpolator(3, new AccelerateDecelerateInterpolator());
        Animator duration = ObjectAnimator.ofFloat(null, "rotationX", new float[]{90.0f, 0.0f}).setDuration(layoutTransition.getDuration(2));
        layoutTransition.setAnimator(2, duration);
        duration.addListener(new f());
        duration = ObjectAnimator.ofFloat(null, "rotationX", new float[]{0.0f, -90.0f}).setDuration(layoutTransition.getDuration(3));
        layoutTransition.setAnimator(3, duration);
        duration.addListener(new g());
        return layoutTransition;
    }

    public static String a(int i) {
        String valueOf = String.valueOf(i);
        if (i == 0) {
            return "0000";
        }
        if (valueOf.length() >= 4) {
            return valueOf;
        }
        switch (valueOf.length()) {
            case l.a /*1*/:
                return "000" + valueOf;
            case kankan.wheel.widget.a.k /*2*/:
                return "00" + valueOf;
            case kankan.wheel.widget.a.l /*3*/:
                return Constants.VIA_RESULT_SUCCESS + valueOf;
            default:
                return valueOf;
        }
    }

    private static String a(String str, String str2, int i, int i2) {
        C0596r.e(i, "Change Digital Index : " + i + " , " + i2);
        String str3 = com.xiaomi.e.a.f;
        int length;
        int i3;
        if (str.length() < str2.length()) {
            length = str2.length() - str.length();
            for (i3 = 0; i3 < length; i3++) {
                str = '0' + str;
            }
        } else if (str2.length() < str.length()) {
            length = str.length() - str2.length();
            for (i3 = 0; i3 < length; i3++) {
                str2 = '0' + str2;
            }
        }
        str3 = Integer.valueOf((i == str.length() + -1 ? com.xiaomi.e.a.f : str2.substring(0, (str.length() - i) - 1)) + i2 + (i == 0 ? com.xiaomi.e.a.f : str.substring(str2.length() - i, str2.length()))).toString();
        C0596r.e(i, "Show Num : " + str3);
        return str3;
    }

    public static void a(AnimatorSet animatorSet, long j) {
        if (animatorSet != null) {
            if (animatorSet.isStarted()) {
                animatorSet.end();
            }
            Iterator it = animatorSet.getChildAnimations().iterator();
            while (it.hasNext()) {
                Animator animator = (Animator) it.next();
                long startDelay = j - animator.getStartDelay();
                if (startDelay < 0) {
                    startDelay = 0;
                }
                if (animator instanceof ValueAnimator) {
                    ((ValueAnimator) animator).setCurrentPlayTime(startDelay);
                }
            }
        }
    }

    public static void a(ValueAnimator valueAnimator, float f) {
        valueAnimator.setCurrentPlayTime((long) (((float) valueAnimator.getDuration()) * f));
    }

    @SuppressLint({"NewApi"})
    public static void a(View view, AnimatorSet animatorSet, long j) {
        a(animatorSet, j);
        view.postInvalidateOnAnimation();
    }

    public static void a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.isEnabled()) {
                childAt.setVisibility(4);
            }
        }
        viewGroup.setVisibility(8);
    }

    public static void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        viewGroup.setLayoutTransition(null);
        viewGroup2.setLayoutTransition(null);
        a(viewGroup);
        b(viewGroup2);
    }

    public static Animator b(int i, int i2, TextView textView) {
        int i3;
        int i4;
        String valueOf = String.valueOf(i);
        int[] iArr = new int[valueOf.length()];
        for (i3 = 0; i3 < valueOf.length(); i3++) {
            iArr[(valueOf.length() - i3) - 1] = valueOf.charAt(i3) - 48;
            C0596r.e(i, "Num : " + iArr[(valueOf.length() - i3) - 1]);
        }
        String valueOf2 = String.valueOf(i2);
        int[] iArr2 = new int[valueOf2.length()];
        for (i3 = 0; i3 < valueOf2.length(); i3++) {
            iArr2[(valueOf2.length() - i3) - 1] = valueOf2.charAt(i3) - 48;
            C0596r.e(i, "Num : " + iArr2[(valueOf2.length() - i3) - 1]);
        }
        ArrayList arrayList = new ArrayList();
        int length = iArr2.length - 1;
        while (length >= 0) {
            int i5 = iArr2[length];
            i4 = iArr.length > length ? iArr[length] : 0;
            if (i5 > i4) {
                for (i3 = 0; i3 < (i5 - i4) + 1; i3++) {
                    arrayList.add(a(valueOf, valueOf2, length, i4 + i3));
                }
            } else if (i5 < i4) {
                for (i3 = 0; i3 < (i4 - i5) + 1; i3++) {
                    arrayList.add(a(valueOf, valueOf2, length, i4 - i3));
                }
            } else {
                arrayList.add(a(valueOf, valueOf2, length, i4));
            }
            length--;
        }
        Keyframe[] keyframeArr = new Keyframe[(arrayList.size() + 1)];
        Iterator it = arrayList.iterator();
        i4 = 0;
        while (it.hasNext()) {
            i4++;
            keyframeArr[i4] = Keyframe.ofObject((1.0f / ((float) arrayList.size())) * ((float) i4), (String) it.next());
        }
        keyframeArr[0] = keyframeArr[1];
        Animator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("Text", keyframeArr)});
        ofPropertyValuesHolder.setEvaluator(new k());
        ofPropertyValuesHolder.addUpdateListener(new l(textView));
        ofPropertyValuesHolder.setDuration(20);
        return ofPropertyValuesHolder;
    }

    public static Animator b(int i, View view) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{(float) i, 0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("alpha", new float[]{0.3f, 1.0f});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2});
    }

    public static Animator b(View view, float f, float f2) {
        return ObjectAnimator.ofFloat(view, "scaleX", new float[]{f, f2});
    }

    public static CharSequence b(int i) {
        if (Utils.m()) {
            return String.valueOf(i);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-1711276033);
        String valueOf = String.valueOf(i);
        Object obj = com.xiaomi.e.a.f;
        if (i != 0) {
            if (valueOf.length() < 4) {
                switch (valueOf.length()) {
                    case l.a /*1*/:
                        obj = "000";
                        break;
                    case kankan.wheel.widget.a.k /*2*/:
                        obj = "00";
                        break;
                    case kankan.wheel.widget.a.l /*3*/:
                        obj = Constants.VIA_RESULT_SUCCESS;
                        break;
                    default:
                        break;
                }
            }
        }
        obj = "0000";
        CharSequence spannableString = new SpannableString(obj);
        spannableString.setSpan(foregroundColorSpan, 0, obj.length(), 33);
        CharSequence spannableString2 = new SpannableString(valueOf);
        if (i == 0) {
            spannableStringBuilder.append(spannableString);
        } else {
            spannableStringBuilder.append(spannableString).append(spannableString2);
        }
        return spannableStringBuilder;
    }

    public static void b(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.isEnabled()) {
                childAt.setVisibility(0);
            }
        }
        viewGroup.setVisibility(0);
    }

    public static void b(ViewGroup viewGroup, ViewGroup viewGroup2) {
        int i;
        int i2 = 0;
        if (j == null) {
            j = a();
        }
        if (k == null) {
            k = a();
        }
        viewGroup.setLayoutTransition(j);
        viewGroup2.setLayoutTransition(k);
        viewGroup2.setVisibility(0);
        int childCount = viewGroup.getChildCount();
        int i3 = 0;
        for (i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((100 - (i * 10)) * i > i3) {
                i3 = (100 - (i * 10)) * i;
            }
            if (childAt.isEnabled()) {
                viewGroup.postDelayed(new c(childAt), (long) i3);
            }
            if (i == childCount - 1) {
                viewGroup.postDelayed(new d(viewGroup), (long) (i3 + 90));
            }
        }
        i = viewGroup2.getChildCount();
        i3 = 0;
        while (i2 < i) {
            View childAt2 = viewGroup2.getChildAt(i2);
            if ((100 - (i2 * 10)) * i2 > i3) {
                i3 = (100 - (i2 * 10)) * i2;
            }
            if (childAt2.isEnabled()) {
                viewGroup2.postDelayed(new e(childAt2), (long) i3);
            }
            i2++;
        }
    }

    public static Animator c(int i, int i2, TextView textView) {
        Animator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new m(textView));
        ofInt.setDuration(500);
        return ofInt;
    }
}
