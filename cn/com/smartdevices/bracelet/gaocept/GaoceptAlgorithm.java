package cn.com.smartdevices.bracelet.gaocept;

public class GaoceptAlgorithm {
    static {
        System.loadLibrary("gaocept");
    }

    public native boolean checkCheat();

    public native boolean endToFreeSpaces();

    public native String getDebugString(boolean z);

    public native String getFeatureString();

    public native int getSpecifiedAxis();

    public native int getTotalMotionCount();

    public native void initializeSpecifiedSport(int i);

    public native boolean receive(int i, int i2, int i3);

    public native void reset();

    public native void zeroClear();
}
