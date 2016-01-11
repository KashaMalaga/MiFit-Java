package com.huami.android.zxing.a.a;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.util.Log;

public final class a {
    public static final int a = -1;
    private static final String b = a.class.getName();

    private a() {
    }

    public static Camera a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(b, "No cameras!");
            return null;
        }
        int i2 = i >= 0 ? 1 : 0;
        if (i2 == 0) {
            i = 0;
            while (i < numberOfCameras) {
                CameraInfo cameraInfo = new CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i++;
            }
        }
        if (i < numberOfCameras) {
            Log.i(b, "Opening camera #" + i);
            return Camera.open(i);
        } else if (i2 != 0) {
            Log.w(b, "Requested camera does not exist: " + i);
            return null;
        } else {
            Log.i(b, "No camera facing back; returning camera #0");
            return Camera.open(0);
        }
    }
}
