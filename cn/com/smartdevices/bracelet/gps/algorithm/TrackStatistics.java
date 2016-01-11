package cn.com.smartdevices.bracelet.gps.algorithm;

public class TrackStatistics {
    public int mCurGloIndex;
    public float mCurSubDistance;
    public long mCurSubStartTimetamp;
    public long mCurSubTime;
    public long mCurTimestamp;
    public float mFormerSubDistance;
    public long mFormerSubTime;
    public float[] mKilometerPaces;
    public float[] mKilometerSpeeds;
    public long[] mKilometerTimestamps;
    public int mLastKilometerNum;
    public long mLastKilometerTimestamp;
    public int mLastMileNum;
    public long mLastMileTimestamp;
    public int mLastPauseSampleCount;
    public long mLastPauseTimestamp;
    public int mMaxKilometer;
    public int mMaxMile;
    public float[] mMilePaces;
    public float[] mMileSpeeds;
    public long[] mMileTimestamps;
    public float mRealtimeDistance;
    public float mRealtimePace;
    public int mRealtimeSampleCount;
    public float mRealtimeSpeed;
    public long mRealtimeTime;
    public float mTotalDistance;
    public float mTotalPace;
    public long mTotalPauseTime;
    public float mTotalSpeed;
    public long mTotalTime;
}
