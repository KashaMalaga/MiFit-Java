package com.e.c;

import android.view.View;

final class b {
    private b() {
    }

    static float a(View view) {
        return view.getAlpha();
    }

    static void a(View view, float f) {
        view.setAlpha(f);
    }

    static void a(View view, int i) {
        view.setScrollX(i);
    }

    static float b(View view) {
        return view.getPivotX();
    }

    static void b(View view, float f) {
        view.setPivotX(f);
    }

    static void b(View view, int i) {
        view.setScrollY(i);
    }

    static float c(View view) {
        return view.getPivotY();
    }

    static void c(View view, float f) {
        view.setPivotY(f);
    }

    static float d(View view) {
        return view.getRotation();
    }

    static void d(View view, float f) {
        view.setRotation(f);
    }

    static float e(View view) {
        return view.getRotationX();
    }

    static void e(View view, float f) {
        view.setRotationX(f);
    }

    static float f(View view) {
        return view.getRotationY();
    }

    static void f(View view, float f) {
        view.setRotationY(f);
    }

    static float g(View view) {
        return view.getScaleX();
    }

    static void g(View view, float f) {
        view.setScaleX(f);
    }

    static float h(View view) {
        return view.getScaleY();
    }

    static void h(View view, float f) {
        view.setScaleY(f);
    }

    static float i(View view) {
        return (float) view.getScrollX();
    }

    static void i(View view, float f) {
        view.setTranslationX(f);
    }

    static float j(View view) {
        return (float) view.getScrollY();
    }

    static void j(View view, float f) {
        view.setTranslationY(f);
    }

    static float k(View view) {
        return view.getTranslationX();
    }

    static void k(View view, float f) {
        view.setX(f);
    }

    static float l(View view) {
        return view.getTranslationY();
    }

    static void l(View view, float f) {
        view.setY(f);
    }

    static float m(View view) {
        return view.getX();
    }

    static float n(View view) {
        return view.getY();
    }
}
