package com.amap.api.maps;

public class AMapNativeRenderer {
    static {
        try {
            System.loadLibrary("amapv304ex");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static native void nativeDrawArrowLineWithPoints(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10);

    public static native void nativeDrawLineByTextureID(float[] fArr, int i, float f, int i2, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2);
}
