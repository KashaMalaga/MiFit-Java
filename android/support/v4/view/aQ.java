package android.support.v4.view;

import android.view.View;

class aQ {
    aQ() {
    }

    public static String a(View view) {
        return view.getTransitionName();
    }

    public static void a(View view, float f) {
        view.setElevation(f);
    }

    public static void a(View view, C0130ad c0130ad) {
        view.setOnApplyWindowInsetsListener(new aR(c0130ad));
    }

    public static void a(View view, String str) {
        view.setTransitionName(str);
    }

    public static void b(View view) {
        view.requestApplyInsets();
    }

    public static void b(View view, float f) {
        view.setTranslationZ(f);
    }

    public static float c(View view) {
        return view.getElevation();
    }

    public static float d(View view) {
        return view.getTranslationZ();
    }
}
