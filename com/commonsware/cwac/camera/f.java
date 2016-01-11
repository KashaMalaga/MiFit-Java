package com.commonsware.cwac.camera;

import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import java.util.Collections;
import java.util.List;

public class f {
    private static final double a = 0.1d;

    public static Size a(int i, int i2, int i3, Parameters parameters) {
        double d = ((double) i2) / ((double) i3);
        List<Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        double d2 = Double.MAX_VALUE;
        double d3 = (i == 90 || i == 270) ? ((double) i3) / ((double) i2) : d;
        Size size = null;
        for (Size size2 : supportedPreviewSizes) {
            if (Math.abs((((double) size2.width) / ((double) size2.height)) - d3) <= a && ((double) Math.abs(size2.height - i3)) < r6) {
                d2 = (double) Math.abs(size2.height - i3);
                size = size2;
            }
        }
        if (size == null) {
            d3 = Double.MAX_VALUE;
            for (Size size22 : supportedPreviewSizes) {
                if (((double) Math.abs(size22.height - i3)) < d3) {
                    d3 = (double) Math.abs(size22.height - i3);
                    size = size22;
                }
            }
        }
        return size;
    }

    public static Size a(int i, int i2, int i3, Parameters parameters, double d) {
        double d2 = Double.MAX_VALUE;
        double d3 = (i == 90 || i == 270) ? ((double) i3) / ((double) i2) : ((double) i2) / ((double) i3);
        List<Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        Collections.sort(supportedPreviewSizes, Collections.reverseOrder(new g()));
        Size size = null;
        for (Size size2 : supportedPreviewSizes) {
            Size size3;
            double abs;
            double d4 = ((double) size2.width) / ((double) size2.height);
            if (Math.abs(d4 - d3) < d2) {
                size3 = size2;
                abs = Math.abs(d4 - d3);
            } else {
                double d5 = d2;
                size3 = size;
                abs = d5;
            }
            if (abs < d) {
                return size3;
            }
            size = size3;
            d2 = abs;
        }
        return size;
    }

    public static Size a(Parameters parameters) {
        Size size = null;
        for (Size size2 : parameters.getSupportedPictureSizes()) {
            if (size == null) {
                size = size2;
            } else if (size2.width * size2.height < size.width * size.height) {
                size = size2;
            }
        }
        return size;
    }

    public static Size a(b bVar, Parameters parameters) {
        return a(bVar, parameters, true);
    }

    public static Size a(b bVar, Parameters parameters, boolean z) {
        Size size = null;
        for (Size size2 : parameters.getSupportedPictureSizes()) {
            if (!z || (size2.height <= bVar.f().d() && size2.height >= bVar.f().c())) {
                if (size == null) {
                    size = size2;
                } else if (size2.width * size2.height > size.width * size.height) {
                    size = size2;
                }
            }
        }
        return (size == null && z) ? a(bVar, parameters, false) : size;
    }

    public static String a(Parameters parameters, String... strArr) {
        List supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            for (String str : strArr) {
                if (supportedFlashModes.contains(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    public static Size b(int i, int i2, int i3, Parameters parameters) {
        return a(i, i2, i3, parameters, 0.0d);
    }
}
