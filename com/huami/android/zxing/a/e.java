package com.huami.android.zxing.a;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.xiaomi.account.openauth.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@TargetApi(15)
public final class e {
    private static final String a = "CameraConfiguration";
    private static final Pattern b = Pattern.compile(";");
    private static final int c = 153600;
    private static final float d = 1.5f;
    private static final float e = 0.0f;
    private static final double f = 0.15d;
    private static final int g = 10;
    private static final int h = 20;
    private static final int i = 400;

    private e() {
    }

    public static Point a(Parameters parameters, Point point) {
        Collection supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        Size previewSize;
        if (supportedPreviewSizes == null) {
            Log.w(a, "Device returned no supported preview sizes; using default");
            previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        Size size;
        List<Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new f());
        if (Log.isLoggable(a, 4)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Size size2 : arrayList) {
                stringBuilder.append(size2.width).append('x').append(size2.height).append(' ');
            }
            Log.i(a, "Supported preview sizes: " + stringBuilder);
        }
        double d = ((double) point.x) / ((double) point.y);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            size2 = (Size) it.next();
            int i = size2.width;
            int i2 = size2.height;
            if (i * i2 < c) {
                it.remove();
            } else {
                int i3 = i < i2 ? 1 : 0;
                int i4 = i3 != 0 ? i2 : i;
                i3 = i3 != 0 ? i : i2;
                if (Math.abs((((double) i4) / ((double) i3)) - d) > f) {
                    it.remove();
                } else if (i4 == point.x && i3 == point.y) {
                    Point point2 = new Point(i, i2);
                    Log.i(a, "Found preview size exactly matching screen size: " + point2);
                    return point2;
                }
            }
        }
        if (arrayList.isEmpty()) {
            previewSize = parameters.getPreviewSize();
            if (previewSize == null) {
                throw new IllegalStateException("Parameters contained no preview size!");
            }
            point2 = new Point(previewSize.width, previewSize.height);
            Log.i(a, "No suitable preview sizes, using default: " + point2);
            return point2;
        }
        size2 = (Size) arrayList.get(0);
        Point point3 = new Point(size2.width, size2.height);
        Log.i(a, "Using largest suitable preview size: " + point3);
        return point3;
    }

    public static String a(CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder(h.E);
        stringBuilder.append("BOARD=").append(Build.BOARD).append('\n');
        stringBuilder.append("BRAND=").append(Build.BRAND).append('\n');
        stringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append('\n');
        stringBuilder.append("DEVICE=").append(Build.DEVICE).append('\n');
        stringBuilder.append("DISPLAY=").append(Build.DISPLAY).append('\n');
        stringBuilder.append("FINGERPRINT=").append(Build.FINGERPRINT).append('\n');
        stringBuilder.append("HOST=").append(Build.HOST).append('\n');
        stringBuilder.append("ID=").append(Build.ID).append('\n');
        stringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append('\n');
        stringBuilder.append("MODEL=").append(Build.MODEL).append('\n');
        stringBuilder.append("PRODUCT=").append(Build.PRODUCT).append('\n');
        stringBuilder.append("TAGS=").append(Build.TAGS).append('\n');
        stringBuilder.append("TIME=").append(Build.TIME).append('\n');
        stringBuilder.append("TYPE=").append(Build.TYPE).append('\n');
        stringBuilder.append("USER=").append(Build.USER).append('\n');
        stringBuilder.append("VERSION.CODENAME=").append(VERSION.CODENAME).append('\n');
        stringBuilder.append("VERSION.INCREMENTAL=").append(VERSION.INCREMENTAL).append('\n');
        stringBuilder.append("VERSION.RELEASE=").append(VERSION.RELEASE).append('\n');
        stringBuilder.append("VERSION.SDK_INT=").append(VERSION.SDK_INT).append('\n');
        if (charSequence != null) {
            String[] split = b.split(charSequence);
            Arrays.sort(split);
            for (String append : split) {
                stringBuilder.append(append).append('\n');
            }
        }
        return stringBuilder.toString();
    }

    private static String a(Iterable<Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Area area : iterable) {
            stringBuilder.append(area.rect).append(':').append(area.weight).append(' ');
        }
        return stringBuilder.toString();
    }

    private static String a(String str, Collection<String> collection, String... strArr) {
        Log.i(a, "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i(a, "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i(a, "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i(a, "No supported values match");
        return null;
    }

    private static String a(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            stringBuilder.append(Arrays.toString((int[]) it.next()));
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private static List<Area> a(int i) {
        return Collections.singletonList(new Area(new Rect(-i, -i, i, i), 1));
    }

    public static void a(Parameters parameters) {
        a(parameters, (int) g, (int) h);
    }

    public static void a(Parameters parameters, double d) {
        if (parameters.isZoomSupported()) {
            Integer b = b(parameters, d);
            if (b != null) {
                if (parameters.getZoom() == b.intValue()) {
                    Log.i(a, "Zoom is already set to " + b);
                    return;
                }
                Log.i(a, "Setting zoom to " + b);
                parameters.setZoom(b.intValue());
                return;
            }
            return;
        }
        Log.i(a, "Zoom is not supported");
    }

    public static void a(Parameters parameters, int i, int i2) {
        Collection<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Log.i(a, "Supported FPS ranges: " + a((Collection) supportedPreviewFpsRange));
        if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
            for (int[] iArr : supportedPreviewFpsRange) {
                int i3 = iArr[0];
                int i4 = iArr[1];
                if (i3 >= i * h.E && i4 <= i2 * h.E) {
                    break;
                }
            }
            int[] iArr2 = null;
            if (iArr2 == null) {
                Log.i(a, "No suitable FPS range?");
                return;
            }
            int[] iArr3 = new int[2];
            parameters.getPreviewFpsRange(iArr3);
            if (Arrays.equals(iArr3, iArr2)) {
                Log.i(a, "FPS range already set to " + Arrays.toString(iArr2));
                return;
            }
            Log.i(a, "Setting FPS range to " + Arrays.toString(iArr2));
            parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
        }
    }

    public static void a(Parameters parameters, boolean z) {
        String a;
        Collection supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            a = a("flash mode", supportedFlashModes, "torch", "on");
        } else {
            a = a("flash mode", supportedFlashModes, "off");
        }
        if (a == null) {
            return;
        }
        if (a.equals(parameters.getFlashMode())) {
            Log.i(a, "Flash mode already set to " + a);
            return;
        }
        Log.i(a, "Setting flash mode to " + a);
        parameters.setFlashMode(a);
    }

    public static void a(Parameters parameters, boolean z, boolean z2, boolean z3) {
        Collection supportedFocusModes = parameters.getSupportedFocusModes();
        String str = null;
        if (z) {
            if (z3 || z2) {
                str = a("focus mode", supportedFocusModes, "auto");
            } else {
                str = a("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto");
            }
        }
        if (!z3 && r0 == null) {
            str = a("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (str == null) {
            return;
        }
        if (str.equals(parameters.getFocusMode())) {
            Log.i(a, "Focus mode already set to " + str);
        } else {
            parameters.setFocusMode(str);
        }
    }

    private static Integer b(Parameters parameters, double d) {
        List zoomRatios = parameters.getZoomRatios();
        Log.i(a, "Zoom ratios: " + zoomRatios);
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
            Log.w(a, "Invalid zoom ratios!");
            return null;
        }
        double d2 = 100.0d * d;
        double d3 = Double.POSITIVE_INFINITY;
        int i = 0;
        for (int i2 = 0; i2 < zoomRatios.size(); i2++) {
            double abs = Math.abs(((double) ((Integer) zoomRatios.get(i2)).intValue()) - d2);
            if (abs < d3) {
                i = i2;
                d3 = abs;
            }
        }
        Log.i(a, "Chose zoom ratio of " + (((double) ((Integer) zoomRatios.get(i)).intValue()) / 100.0d));
        return Integer.valueOf(i);
    }

    public static void b(Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            Log.i(a, "Old focus areas: " + a(parameters.getFocusAreas()));
            Iterable a = a((int) i);
            Log.i(a, "Setting focus area to : " + a(a));
            parameters.setFocusAreas(a);
            return;
        }
        Log.i(a, "Device does not support focus areas");
    }

    public static void b(Parameters parameters, boolean z) {
        float f = e;
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (!(minExposureCompensation == 0 && maxExposureCompensation == 0) && exposureCompensationStep > e) {
            if (!z) {
                f = d;
            }
            int round = Math.round(f / exposureCompensationStep);
            exposureCompensationStep *= (float) round;
            round = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
            if (parameters.getExposureCompensation() == round) {
                Log.i(a, "Exposure compensation already set to " + round + " / " + exposureCompensationStep);
                return;
            }
            Log.i(a, "Setting exposure compensation to " + round + " / " + exposureCompensationStep);
            parameters.setExposureCompensation(round);
            return;
        }
        Log.i(a, "Camera does not support exposure compensation");
    }

    public static void c(Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            Log.i(a, "Old metering areas: " + parameters.getMeteringAreas());
            Iterable a = a((int) i);
            Log.i(a, "Setting metering area to : " + a(a));
            parameters.setMeteringAreas(a);
            return;
        }
        Log.i(a, "Device does not support metering areas");
    }

    public static void d(Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            Log.i(a, "This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            Log.i(a, "Video stabilization already enabled");
        } else {
            Log.i(a, "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static void e(Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i(a, "Barcode scene mode already set");
            return;
        }
        String a = a("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (a != null) {
            parameters.setSceneMode(a);
        }
    }

    public static void f(Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i(a, "Negative effect already set");
            return;
        }
        String a = a("color effect", parameters.getSupportedColorEffects(), "negative");
        if (a != null) {
            parameters.setColorEffect(a);
        }
    }

    public static String g(Parameters parameters) {
        return a(parameters.flatten());
    }
}
