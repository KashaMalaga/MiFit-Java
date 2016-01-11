package cn.com.smartdevices.bracelet.gps.algorithm;

import com.amap.api.services.geocoder.GeocodeSearch;

public class GPSAlgorithm {
    static {
        System.loadLibrary(GeocodeSearch.GPS);
    }

    public native boolean endToFreeSpaces();

    public native double getAltitude(int i);

    public native int getGlobalIndex(int i);

    public native int getKilometerNum();

    public native float getKilometerPace(int i);

    public native float getKilometerSpeed(int i);

    public native long getKilometerTimestamp(int i);

    public native long getLatestGlobalIndex();

    public native long getLatestTimestamp();

    public native double getLatitude(int i);

    public native int getLength();

    public native double getLongitude(int i);

    public native float getRealtimePace();

    public native float getRealtimeSpeed();

    public native int getRelStartIndex();

    public native int getRingSize();

    public native int getStepSize();

    public native long getTimestamp(int i);

    public native float getTotalDistance();

    public native float getTotalPace();

    public native long getTotalPauseTime();

    public native float getTotalSpeed();

    public native long getTotalTime();

    public native void getTrackStatistics(TrackStatistics trackStatistics);

    public native int receiveSample(double d, double d2, double d3, long j, float f);

    public native void recoverFromCrash(TrackStatistics trackStatistics);

    public native void setMaxAccuracy(int i);

    public native void start(boolean z);

    public native int statusEstimation(int i, int i2);

    public native void stop();

    public native void transferFromKilometerToMile(TrackStatistics trackStatistics);

    public native void transferFromMileToKilometer(TrackStatistics trackStatistics);
}
