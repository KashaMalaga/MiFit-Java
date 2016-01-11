package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.algorithm.TrackStatistics;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ay implements Serializable {
    public static final String A = "maxmn";
    public static final String B = "mmpsarray";
    public static final String C = "mspmarray";
    public static final String D = "mtsarray";
    public static final String E = "state";
    public static final String F = "index";
    public static final String G = "gidx";
    public static final String H = "ts";
    public static final String b = "ct";
    public static final String c = "dis";
    public static final String d = "avmps";
    public static final String e = "avspm";
    public static final String f = "utppt";
    public static final String g = "bppd";
    public static final String h = "aprt";
    public static final String i = "aprd";
    public static final String j = "aprst";
    public static final String k = "rtscnt";
    public static final String l = "rtt";
    public static final String m = "rtd";
    public static final String n = "rtmps";
    public static final String o = "rtspm";
    public static final String p = "pct";
    public static final String q = "uppscnt";
    public static final String r = "lpts";
    public static final String s = "lkmn";
    private static final long serialVersionUID = 1;
    public static final String t = "lkmts";
    public static final String u = "maxkmn";
    public static final String v = "kmspmarray";
    public static final String w = "kmmpsarray";
    public static final String x = "kmctarray";
    public static final String y = "pmn";
    public static final String z = "pmts";
    int I;
    int J;
    private long K;
    TrackStatistics a;

    public ay(long j) {
        this.a = null;
        this.I = -1;
        this.J = -1;
        this.K = 0;
        this.a = new TrackStatistics();
        this.K = j;
    }

    private JSONArray a(float[] fArr) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (float f : fArr) {
                jSONArray.put((double) f);
            }
        } catch (JSONException e) {
            C0596r.e("DB", e.getMessage());
        }
        return jSONArray;
    }

    private JSONArray a(long[] jArr) {
        JSONArray jSONArray = new JSONArray();
        for (long put : jArr) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    private float[] a(JSONArray jSONArray) {
        int length = jSONArray.length();
        float[] fArr = new float[length];
        int i = 0;
        while (i < length) {
            try {
                fArr[i] = Float.valueOf(jSONArray.getString(i)).floatValue();
                i++;
            } catch (JSONException e) {
                C0596r.e("DB", e.getMessage());
            }
        }
        return fArr;
    }

    private long[] b(JSONArray jSONArray) {
        int length = jSONArray.length();
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            try {
                jArr[i] = jSONArray.getLong(i);
                i++;
            } catch (JSONException e) {
                C0596r.e("DB", e.getMessage());
            }
        }
        return jArr;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(E, this.I);
            jSONObject.put(F, this.J);
            jSONObject.put(b, this.a.mTotalTime);
            jSONObject.put(c, (double) this.a.mTotalDistance);
            jSONObject.put(d, (double) this.a.mTotalSpeed);
            jSONObject.put(e, (double) this.a.mTotalPace);
            jSONObject.put(f, this.a.mFormerSubTime);
            jSONObject.put(g, (double) this.a.mFormerSubDistance);
            jSONObject.put(h, this.a.mCurSubTime);
            jSONObject.put(i, (double) this.a.mCurSubDistance);
            jSONObject.put(j, this.a.mCurSubStartTimetamp);
            jSONObject.put(k, this.a.mRealtimeSampleCount);
            jSONObject.put(l, this.a.mRealtimeTime);
            jSONObject.put(m, (double) this.a.mRealtimeDistance);
            jSONObject.put(n, (double) this.a.mRealtimeSpeed);
            jSONObject.put(o, (double) this.a.mRealtimePace);
            jSONObject.put(p, this.a.mTotalPauseTime);
            jSONObject.put(q, this.a.mLastPauseSampleCount);
            jSONObject.put(r, this.a.mLastPauseTimestamp);
            jSONObject.put(s, this.a.mLastKilometerNum);
            jSONObject.put(t, this.a.mLastKilometerTimestamp);
            jSONObject.put(u, this.a.mMaxKilometer);
            jSONObject.put(y, this.a.mLastMileNum);
            jSONObject.put(z, this.a.mLastMileTimestamp);
            jSONObject.put(A, this.a.mMaxMile);
            jSONObject.put(G, this.a.mCurGloIndex);
            jSONObject.put(H, this.a.mCurTimestamp);
            if (this.a.mKilometerSpeeds != null) {
                jSONObject.put(v, a(this.a.mKilometerSpeeds));
            }
            if (this.a.mKilometerPaces != null) {
                jSONObject.put(w, a(this.a.mKilometerPaces));
            }
            if (this.a.mKilometerTimestamps != null) {
                jSONObject.put(x, a(this.a.mKilometerTimestamps));
            }
            if (this.a.mMileSpeeds != null) {
                jSONObject.put(B, a(this.a.mMileSpeeds));
            }
            if (this.a.mMileTimestamps != null) {
                jSONObject.put(D, a(this.a.mMileTimestamps));
            }
            if (this.a.mMilePaces != null) {
                jSONObject.put(C, a(this.a.mMilePaces));
            }
        } catch (JSONException e) {
            C0596r.e("DB", e.getMessage());
        }
        return jSONObject;
    }

    void a(int i, int i2) {
        this.I = i;
        this.J = i2;
    }

    public boolean a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.I = jSONObject.getInt(E);
            this.J = jSONObject.getInt(F);
            this.a.mTotalTime = jSONObject.getLong(b);
            this.a.mTotalDistance = Float.valueOf(jSONObject.getString(c)).floatValue();
            this.a.mTotalSpeed = Float.valueOf(jSONObject.getString(d)).floatValue();
            this.a.mTotalPace = Float.valueOf(jSONObject.getString(e)).floatValue();
            this.a.mFormerSubTime = jSONObject.getLong(f);
            this.a.mFormerSubDistance = Float.valueOf(jSONObject.getString(g)).floatValue();
            this.a.mCurSubTime = jSONObject.getLong(h);
            this.a.mCurSubDistance = Float.valueOf(jSONObject.getString(i)).floatValue();
            this.a.mCurSubStartTimetamp = jSONObject.getLong(j);
            this.a.mRealtimeSampleCount = jSONObject.getInt(k);
            this.a.mRealtimeTime = jSONObject.getLong(l);
            this.a.mRealtimeDistance = Float.valueOf(jSONObject.getString(m)).floatValue();
            this.a.mRealtimeSpeed = Float.valueOf(jSONObject.getString(n)).floatValue();
            this.a.mRealtimePace = Float.valueOf(jSONObject.getString(o)).floatValue();
            this.a.mTotalPauseTime = jSONObject.getLong(p);
            this.a.mLastPauseSampleCount = jSONObject.getInt(q);
            this.a.mLastPauseTimestamp = jSONObject.getLong(r);
            this.a.mLastKilometerNum = jSONObject.getInt(s);
            this.a.mLastKilometerTimestamp = jSONObject.getLong(t);
            this.a.mMaxKilometer = jSONObject.getInt(u);
            this.a.mLastMileNum = jSONObject.getInt(y);
            this.a.mLastMileTimestamp = jSONObject.getLong(z);
            this.a.mMaxMile = jSONObject.getInt(A);
            this.a.mCurGloIndex = jSONObject.getInt(G);
            this.a.mCurTimestamp = jSONObject.getLong(H);
            if (!jSONObject.isNull(v)) {
                this.a.mKilometerSpeeds = a(jSONObject.getJSONArray(v));
            }
            if (!jSONObject.isNull(w)) {
                this.a.mKilometerPaces = a(jSONObject.getJSONArray(w));
            }
            if (!jSONObject.isNull(x)) {
                this.a.mKilometerTimestamps = b(jSONObject.getJSONArray(x));
            }
            if (!jSONObject.isNull(B)) {
                this.a.mMileSpeeds = a(jSONObject.getJSONArray(B));
            }
            if (!jSONObject.isNull(C)) {
                this.a.mMilePaces = a(jSONObject.getJSONArray(C));
            }
            if (!jSONObject.isNull(D)) {
                this.a.mMileTimestamps = b(jSONObject.getJSONArray(D));
            }
            return true;
        } catch (JSONException e) {
            C0596r.e("DB", "parseJsonSummary: " + e.getMessage());
            return false;
        }
    }

    public long b() {
        return this.K;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Now mTotalTime:").append(this.a.mTotalTime).append(",mTotalDistance:").append(this.a.mTotalDistance).append(",mTotalSpeed:").append(this.a.mTotalSpeed).append(",mTotalPace:").append(this.a.mTotalPace).append(",mFormerSubTime:").append(this.a.mFormerSubTime).append(",mFormerSubDistance:").append(this.a.mFormerSubDistance).append(",mCurSubTime:").append(this.a.mCurSubTime).append(",mCurSubDistance:").append(this.a.mCurSubDistance).append(",mCurSubStartTimetamp:").append(this.a.mCurSubStartTimetamp).append(",mRealtimeSampleCount:").append(this.a.mRealtimeSampleCount).append(",mRealtimeTime:").append(this.a.mRealtimeTime).append(",mRealtimeDistance:").append(this.a.mRealtimeDistance).append(",mRealtimeSpeed:").append(this.a.mRealtimeSpeed).append(",mRealtimePace:").append(this.a.mRealtimePace).append(",mTotalPauseTime:").append(this.a.mTotalPauseTime).append(",mLastPauseSampleCount:").append(this.a.mLastPauseSampleCount).append(",mLastPauseTimestamp:").append(this.a.mLastPauseTimestamp).append(",mLastKilometerNum:").append(this.a.mLastKilometerNum).append(",mLastKilometerTimestamp:").append(this.a.mLastKilometerTimestamp).append(",mMaxKilometer:").append(this.a.mMaxKilometer).append(",mLastMileNum:").append(this.a.mLastMileNum).append(",mLastMileTimestamp:").append(this.a.mLastMileTimestamp).append(",mMaxMile:").append(this.a.mMaxMile).append(",mKilometerSpeeds:").append(this.a.mKilometerSpeeds).append(",mKilometerPaces:").append(this.a.mKilometerPaces).append(",mKilometerTimestamps:").append(this.a.mKilometerTimestamps).append(",mMileSpeeds:").append(this.a.mMileSpeeds).append(",mMilePaces:").append(this.a.mMilePaces).append(",mMileTimestamps:").append(this.a.mMileTimestamps).append(",mCurGloIndex:").append(this.a.mCurGloIndex).append(",mCurTimestamp:").append(this.a.mCurTimestamp);
        return stringBuilder.toString();
    }
}
