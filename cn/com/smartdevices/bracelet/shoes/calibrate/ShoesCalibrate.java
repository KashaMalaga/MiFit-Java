package cn.com.smartdevices.bracelet.shoes.calibrate;

public class ShoesCalibrate {
    static {
        System.loadLibrary("shoes_calibration");
    }

    public native double getPhi();

    public native double getPsi();

    public native double getTheta();

    public native int receiveSamples(short[] sArr, short[] sArr2, short[] sArr3, int i);
}
