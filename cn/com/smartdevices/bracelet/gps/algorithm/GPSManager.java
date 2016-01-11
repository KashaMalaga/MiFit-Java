package cn.com.smartdevices.bracelet.gps.algorithm;

import android.annotation.SuppressLint;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.c.c;
import cn.com.smartdevices.bracelet.c.e;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.d.a.a.h;
import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressLint({"Assert"})
public class GPSManager {
    static final /* synthetic */ boolean $assertionsDisabled = (!GPSManager.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    public static final int FILTERED_POINT = 1;
    public static final int RING_SIZE = mGPSAlgorithm.getRingSize();
    public static final int SPORT_STATUS_ACTIVE = 1;
    public static final int SPORT_STATUS_INACTIVE = 0;
    public static final int STEP_SIZE = mGPSAlgorithm.getStepSize();
    private static final String TAG = "GPSManager";
    public static final int VALID_POINT_NO_WAVELET = 2;
    public static final int VALID_POINT_WAVELET = 4;
    static final GPSAlgorithm mGPSAlgorithm = new GPSAlgorithm();
    c mCrowdManager;
    boolean mIsError = $assertionsDisabled;
    boolean mIsRunning = $assertionsDisabled;
    ArrayList<cn.com.smartdevices.bracelet.gps.model.c> mPointRing;
    TrackStatistics mTrackStatistics;

    public GPSManager(String str) {
        int i = STEP_SIZE;
        this.mCrowdManager = new c(str, e.GPS, $assertionsDisabled);
        this.mTrackStatistics = new TrackStatistics();
        this.mPointRing = new ArrayList();
        this.mIsRunning = $assertionsDisabled;
        while (i < RING_SIZE) {
            this.mPointRing.add(new cn.com.smartdevices.bracelet.gps.model.c());
            i += SPORT_STATUS_ACTIVE;
        }
    }

    private boolean updatePoint(int i, int i2, int i3) {
        cn.com.smartdevices.bracelet.gps.model.c cVar = (cn.com.smartdevices.bracelet.gps.model.c) this.mPointRing.get(i % i3);
        boolean z = $assertionsDisabled;
        int globalIndex = mGPSAlgorithm.getGlobalIndex(i2);
        double longitude = mGPSAlgorithm.getLongitude(i2);
        double latitude = mGPSAlgorithm.getLatitude(i2);
        if (cVar.d() != globalIndex) {
            cVar.c(globalIndex);
            z = true;
        }
        if (cVar.q != longitude) {
            cVar.q = longitude;
            z = true;
        }
        if (cVar.p == latitude) {
            return z;
        }
        cVar.p = latitude;
        return true;
    }

    public void FreeAllMemory() {
        try {
            if (GaoceptUtils.IS_DEBUG) {
                this.mCrowdManager.h();
            }
            if (!mGPSAlgorithm.endToFreeSpaces()) {
                throw new Exception("memory leak in C");
            }
        } catch (Exception e) {
            C0596r.e("gpsjava", e.getMessage());
        }
    }

    public void cleanStorage() {
        this.mCrowdManager.g();
    }

    public ArrayList<cn.com.smartdevices.bracelet.gps.model.c> end(boolean z) {
        C0596r.e("gpsjava", "end-in");
        ArrayList<cn.com.smartdevices.bracelet.gps.model.c> arrayList = new ArrayList();
        try {
            if (this.mIsRunning) {
                if (mGPSAlgorithm.getLength() > 0) {
                    mGPSAlgorithm.stop();
                    int relStartIndex = mGPSAlgorithm.getRelStartIndex();
                    int ringSize = mGPSAlgorithm.getRingSize();
                    int length = mGPSAlgorithm.getLength();
                    for (int i = STEP_SIZE; i < length; i += SPORT_STATUS_ACTIVE) {
                        int i2 = (relStartIndex + i) % ringSize;
                        int globalIndex = mGPSAlgorithm.getGlobalIndex(i2);
                        if (updatePoint(globalIndex, i2, ringSize)) {
                            arrayList.add(this.mPointRing.get(globalIndex % ringSize));
                        }
                    }
                }
                if (!z) {
                    this.mIsRunning = $assertionsDisabled;
                }
                C0596r.e("gpsjava", "end-out");
                return arrayList;
            }
            throw new Exception("End a sport when there is no sport");
        } catch (Exception e) {
            C0596r.e("gpsjava", e.getMessage());
            if (!z) {
                this.mIsRunning = $assertionsDisabled;
            }
            C0596r.e("gpsjava", "end-out");
        } catch (Throwable th) {
            if (!z) {
                this.mIsRunning = $assertionsDisabled;
            }
            C0596r.e("gpsjava", "end-out");
        }
    }

    public File getAllFile() {
        return this.mCrowdManager.b();
    }

    public int getAllFileLength() {
        return this.mCrowdManager.a();
    }

    public File getAllNormFile() {
        return this.mCrowdManager.c();
    }

    public float getDistance() {
        return mGPSAlgorithm.getTotalDistance();
    }

    public boolean getIsRunning() {
        return this.mIsRunning;
    }

    public long getLatestTimestamp() {
        return mGPSAlgorithm.getLatestTimestamp();
    }

    public File getTempFile() {
        return this.mCrowdManager.d();
    }

    public File getTestFile() {
        return this.mCrowdManager.e();
    }

    public TrackStatistics getTrackParameter(boolean z) {
        float[] fArr;
        int i;
        int i2 = STEP_SIZE;
        if (z) {
            mGPSAlgorithm.getTrackStatistics(this.mTrackStatistics);
        }
        if (this.mTrackStatistics.mMaxKilometer > 0 && (this.mTrackStatistics.mKilometerPaces == null || this.mTrackStatistics.mKilometerPaces.length != this.mTrackStatistics.mMaxKilometer)) {
            fArr = new float[this.mTrackStatistics.mMaxKilometer];
            i = STEP_SIZE;
            while (i < this.mTrackStatistics.mMaxKilometer) {
                if (this.mTrackStatistics.mKilometerPaces == null || i >= this.mTrackStatistics.mLastKilometerNum || i >= this.mTrackStatistics.mKilometerPaces.length) {
                    fArr[i] = 0.0f;
                } else {
                    fArr[i] = this.mTrackStatistics.mKilometerPaces[i];
                }
                i += SPORT_STATUS_ACTIVE;
            }
            this.mTrackStatistics.mKilometerPaces = fArr;
        }
        if (this.mTrackStatistics.mMaxKilometer > 0 && (this.mTrackStatistics.mKilometerSpeeds == null || this.mTrackStatistics.mKilometerSpeeds.length != this.mTrackStatistics.mMaxKilometer)) {
            fArr = new float[this.mTrackStatistics.mMaxKilometer];
            i = STEP_SIZE;
            while (i < this.mTrackStatistics.mMaxKilometer) {
                if (this.mTrackStatistics.mKilometerSpeeds == null || i >= this.mTrackStatistics.mLastKilometerNum || i >= this.mTrackStatistics.mKilometerSpeeds.length) {
                    fArr[i] = 0.0f;
                } else {
                    fArr[i] = this.mTrackStatistics.mKilometerSpeeds[i];
                }
                i += SPORT_STATUS_ACTIVE;
            }
            this.mTrackStatistics.mKilometerSpeeds = fArr;
        }
        if (this.mTrackStatistics.mMaxKilometer > 0 && (this.mTrackStatistics.mKilometerTimestamps == null || this.mTrackStatistics.mKilometerTimestamps.length != this.mTrackStatistics.mMaxKilometer)) {
            long[] jArr = new long[this.mTrackStatistics.mMaxKilometer];
            i = STEP_SIZE;
            while (i < this.mTrackStatistics.mMaxKilometer) {
                if (this.mTrackStatistics.mKilometerTimestamps == null || i >= this.mTrackStatistics.mLastKilometerNum || i >= this.mTrackStatistics.mKilometerTimestamps.length) {
                    jArr[i] = 0;
                } else {
                    jArr[i] = this.mTrackStatistics.mKilometerTimestamps[i];
                }
                i += SPORT_STATUS_ACTIVE;
            }
            this.mTrackStatistics.mKilometerTimestamps = jArr;
        }
        if (this.mTrackStatistics.mMaxMile > 0 && (this.mTrackStatistics.mMilePaces == null || this.mTrackStatistics.mMilePaces.length != this.mTrackStatistics.mMaxMile)) {
            fArr = new float[this.mTrackStatistics.mMaxMile];
            i = STEP_SIZE;
            while (i < this.mTrackStatistics.mMaxMile) {
                if (this.mTrackStatistics.mMilePaces == null || i >= this.mTrackStatistics.mLastMileNum || i >= this.mTrackStatistics.mMilePaces.length) {
                    fArr[i] = 0.0f;
                } else {
                    fArr[i] = this.mTrackStatistics.mMilePaces[i];
                }
                i += SPORT_STATUS_ACTIVE;
            }
            this.mTrackStatistics.mMilePaces = fArr;
        }
        if (this.mTrackStatistics.mMaxMile > 0 && (this.mTrackStatistics.mMileSpeeds == null || this.mTrackStatistics.mMileSpeeds.length != this.mTrackStatistics.mMaxMile)) {
            fArr = new float[this.mTrackStatistics.mMaxMile];
            i = STEP_SIZE;
            while (i < this.mTrackStatistics.mMaxMile) {
                if (this.mTrackStatistics.mMileSpeeds == null || i >= this.mTrackStatistics.mLastMileNum || i >= this.mTrackStatistics.mMileSpeeds.length) {
                    fArr[i] = 0.0f;
                } else {
                    fArr[i] = this.mTrackStatistics.mMileSpeeds[i];
                }
                i += SPORT_STATUS_ACTIVE;
            }
            this.mTrackStatistics.mMileSpeeds = fArr;
        }
        if (this.mTrackStatistics.mMaxMile > 0 && (this.mTrackStatistics.mMileTimestamps == null || this.mTrackStatistics.mMileTimestamps.length != this.mTrackStatistics.mMaxMile)) {
            long[] jArr2 = new long[this.mTrackStatistics.mMaxMile];
            while (i2 < this.mTrackStatistics.mMaxMile) {
                if (this.mTrackStatistics.mMileTimestamps == null || i2 >= this.mTrackStatistics.mLastMileNum || i2 >= this.mTrackStatistics.mMileTimestamps.length) {
                    jArr2[i2] = 0;
                } else {
                    jArr2[i2] = this.mTrackStatistics.mMileTimestamps[i2];
                }
                i2 += SPORT_STATUS_ACTIVE;
            }
            this.mTrackStatistics.mMileTimestamps = jArr2;
        }
        return this.mTrackStatistics;
    }

    public ArrayList<cn.com.smartdevices.bracelet.gps.model.c> pauseRunning() {
        return end(true);
    }

    public int receivePoint(cn.com.smartdevices.bracelet.gps.model.c cVar, boolean z, ArrayList<cn.com.smartdevices.bracelet.gps.model.c> arrayList) {
        C0596r.e("gpsjava", "receiveSample-in, index: " + cVar.d());
        arrayList.clear();
        try {
            if (this.mIsRunning) {
                if (this.mCrowdManager != null && z) {
                    List arrayList2 = new ArrayList();
                    arrayList2.add(Long.valueOf(cVar.e()));
                    arrayList2.add(Double.valueOf(cVar.q));
                    arrayList2.add(Double.valueOf(cVar.p));
                    arrayList2.add(Double.valueOf(cVar.o));
                    arrayList2.add(Float.valueOf(cVar.v));
                    this.mCrowdManager.a(arrayList2);
                }
                String str = GeocodeSearch.GPS;
                Object[] objArr = new Object[VALID_POINT_WAVELET];
                objArr[STEP_SIZE] = Double.valueOf(cVar.q);
                objArr[SPORT_STATUS_ACTIVE] = Double.valueOf(cVar.p);
                objArr[VALID_POINT_NO_WAVELET] = Double.valueOf(cVar.o);
                objArr[3] = Long.valueOf(cVar.r);
                cn.com.smartdevices.bracelet.gps.h.e.a(str, String.format("receivePoint-new sample to c, lon:%f, lat:%f, alt:%f, time:%d", objArr));
                int receiveSample = mGPSAlgorithm.receiveSample(cVar.q, cVar.p, cVar.o, cVar.r, cVar.v);
                int length = mGPSAlgorithm.getLength();
                int relStartIndex = mGPSAlgorithm.getRelStartIndex();
                int ringSize = mGPSAlgorithm.getRingSize();
                int i;
                int i2;
                if (receiveSample == VALID_POINT_WAVELET) {
                    for (i = STEP_SIZE; i < length; i += SPORT_STATUS_ACTIVE) {
                        i2 = (relStartIndex + i) % ringSize;
                        int globalIndex = mGPSAlgorithm.getGlobalIndex(i2);
                        if (updatePoint(globalIndex, i2, ringSize)) {
                            arrayList.add(((cn.com.smartdevices.bracelet.gps.model.c) this.mPointRing.get(globalIndex % ringSize)).a());
                        }
                    }
                    return receiveSample;
                } else if (receiveSample != VALID_POINT_NO_WAVELET) {
                    return SPORT_STATUS_ACTIVE;
                } else {
                    i2 = ((relStartIndex + length) - 1) % ringSize;
                    i = mGPSAlgorithm.getGlobalIndex(i2);
                    if (updatePoint(i, i2, ringSize)) {
                        arrayList.add(((cn.com.smartdevices.bracelet.gps.model.c) this.mPointRing.get(i % ringSize)).a());
                    }
                    return receiveSample;
                }
            }
            throw new Exception("receive sample when not running, index: " + cVar.d());
        } catch (Exception e) {
            C0596r.e("gpsjava", e.getMessage());
            this.mIsError = true;
            return STEP_SIZE;
        }
    }

    public boolean recoverFromCrash(String str, String str2, TrackStatistics trackStatistics) {
        C0596r.e("gpsjava", "recoverFromCrash-in");
        if (trackStatistics == null) {
            C0596r.d(TAG, "orgTrack should not be null, recover failed");
            return $assertionsDisabled;
        }
        int i;
        if (trackStatistics.mMilePaces == null) {
            C0596r.d(TAG, "mMilePaces is null");
            i = SPORT_STATUS_ACTIVE;
        } else {
            i = $assertionsDisabled;
        }
        if (trackStatistics.mMileSpeeds == null) {
            C0596r.d(TAG, "mMileSpeeds is null");
            i = SPORT_STATUS_ACTIVE;
        }
        if (trackStatistics.mMileTimestamps == null) {
            C0596r.d(TAG, "mMileTimestamps is null");
            i = SPORT_STATUS_ACTIVE;
        }
        if (i != 0 || (trackStatistics.mMilePaces.length == trackStatistics.mMileSpeeds.length && trackStatistics.mMilePaces.length == trackStatistics.mMileTimestamps.length)) {
            try {
                this.mCrowdManager.a("userID", "GPS", str2, GaoceptUtils.DateFormat.format(new Date()));
                this.mCrowdManager.a(trackStatistics.mRealtimeSampleCount > 0 ? true : $assertionsDisabled);
                for (int i2 = STEP_SIZE; i2 < this.mPointRing.size(); i2 += SPORT_STATUS_ACTIVE) {
                    ((cn.com.smartdevices.bracelet.gps.model.c) this.mPointRing.get(i2)).c(-1);
                }
                this.mIsRunning = true;
                C0596r.e("gpsjava", "start-call c recoverFromCrash");
                mGPSAlgorithm.recoverFromCrash(trackStatistics);
                C0596r.e("gpsjava", "start-end call c recoverFromCrash");
                return true;
            } catch (Exception e) {
                C0596r.e("gpsjava", e.getMessage());
                this.mIsRunning = $assertionsDisabled;
                C0596r.e("gpsjava", "recoverFromCrash-out");
                return $assertionsDisabled;
            }
        }
        C0596r.d(TAG, String.format("mMilePaces length : %d, mMileSpeeds length : %d, mMileTimestamps length : %d, is not the same value, recover failed", new Object[]{Integer.valueOf(trackStatistics.mMilePaces.length), Integer.valueOf(trackStatistics.mMileSpeeds.length), Integer.valueOf(trackStatistics.mMileTimestamps.length)}));
        return $assertionsDisabled;
    }

    public void resumeRunning() {
        mGPSAlgorithm.start(true);
    }

    public void setMaxAccuracy(int i) {
        mGPSAlgorithm.setMaxAccuracy(i);
    }

    public void start(String str, String str2) {
        C0596r.e("gpsjava", "start-in");
        try {
            if (this.mIsRunning) {
                throw new Exception("start a new sport when there is already one");
            }
            this.mCrowdManager.a("userID", "GPS", str2, GaoceptUtils.DateFormat.format(new Date()));
            for (int i = STEP_SIZE; i < this.mPointRing.size(); i += SPORT_STATUS_ACTIVE) {
                cn.com.smartdevices.bracelet.gps.model.c cVar = (cn.com.smartdevices.bracelet.gps.model.c) this.mPointRing.get(i);
                cVar.q = 0.0d;
                cVar.p = 0.0d;
                cVar.o = 0.0d;
                cVar.c(-1);
            }
            this.mIsRunning = true;
            C0596r.e("gpsjava", "start-call c start");
            mGPSAlgorithm.start($assertionsDisabled);
            C0596r.e("gpsjava", "start-end call c start");
            C0596r.e("gpsjava", "start-out");
        } catch (Exception e) {
            C0596r.e("gpsjava", e.getMessage());
            this.mIsRunning = $assertionsDisabled;
        }
    }

    public int statusEstimation(int i, int i2) {
        return mGPSAlgorithm.statusEstimation(i, i2);
    }

    public int test() {
        Exception exception;
        if (this.mCrowdManager.b().exists()) {
            this.mCrowdManager.i();
        }
        if (!this.mCrowdManager.c().exists()) {
            return -1;
        }
        InputStream fileInputStream = new FileInputStream(this.mCrowdManager.c());
        Reader inputStreamReader = new InputStreamReader(fileInputStream, h.DEFAULT_CHARSET);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = a.f;
        int i = -1;
        int i2 = STEP_SIZE;
        int i3 = STEP_SIZE;
        int ringSize = mGPSAlgorithm.getRingSize();
        if ($assertionsDisabled || ringSize == this.mPointRing.size()) {
            int length;
            int i4;
            cn.com.smartdevices.bracelet.gps.model.c cVar;
            int length2;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                try {
                    int i5;
                    if (readLine == "\n" || readLine == a.f || readLine.length() <= 0) {
                        i5 = i3;
                        i3 = i;
                    } else if (readLine.startsWith("Activity")) {
                        if (i > 0) {
                            mGPSAlgorithm.stop();
                            length = mGPSAlgorithm.getLength();
                            r7 = mGPSAlgorithm.getRelStartIndex();
                            for (i4 = STEP_SIZE; i4 < length; i4 += SPORT_STATUS_ACTIVE) {
                                int i6 = (r7 + i4) % ringSize;
                                cVar = (cn.com.smartdevices.bracelet.gps.model.c) this.mPointRing.get(mGPSAlgorithm.getGlobalIndex(i6) % ringSize);
                                cVar.q = mGPSAlgorithm.getLongitude(i6);
                                cVar.p = mGPSAlgorithm.getLatitude(i6);
                                this.mCrowdManager.a(cVar.e() + ", " + cVar.q + ", " + cVar.p + ", " + cVar.o + ", " + cVar.v + ", " + cVar.s + ", " + cVar.f() + ", " + cVar.d() + "\n", true, this.mCrowdManager.e());
                            }
                            if (!mGPSAlgorithm.endToFreeSpaces()) {
                                C0596r.e("gaocept", "memory leak in C");
                            }
                        }
                        C0596r.e("gpsjava", "start-call c start");
                        mGPSAlgorithm.start($assertionsDisabled);
                        C0596r.e("gpsjava", "start-end call c start");
                        C0596r.e("gpsjava", "start test activity: " + readLine.split("[:]")[SPORT_STATUS_ACTIVE] + "/");
                        str = (readLine + "\n" + bufferedReader.readLine()) + "\n" + bufferedReader.readLine();
                        bufferedReader.readLine();
                        this.mCrowdManager.a((str + "\nTimeStamp, Longitude, Latitude, Altitude, Accuracy, Speed, Distance, Index") + "\n", i > 0 ? true : $assertionsDisabled, this.mCrowdManager.e());
                        i5 = STEP_SIZE;
                        try {
                            C0596r.e("gpsjava", "receive test gps samples");
                            i3 = i2;
                        } catch (Exception e) {
                            i = i2;
                            exception = e;
                            i3 = STEP_SIZE;
                        }
                    } else {
                        String[] split = readLine.split(f.i);
                        cVar = (cn.com.smartdevices.bracelet.gps.model.c) this.mPointRing.get(i3 % ringSize);
                        cVar.c(i3);
                        cVar.a((long) Double.parseDouble(split[STEP_SIZE].trim()));
                        cVar.q = Double.parseDouble(split[SPORT_STATUS_ACTIVE].trim());
                        cVar.p = Double.parseDouble(split[VALID_POINT_NO_WAVELET].trim());
                        cVar.o = Double.parseDouble(split[3].trim());
                        cVar.v = Float.parseFloat(split[VALID_POINT_WAVELET].trim());
                        int i7 = i3 + SPORT_STATUS_ACTIVE;
                        try {
                            cn.com.smartdevices.bracelet.gps.model.c cVar2;
                            if (mGPSAlgorithm.getLatestTimestamp() > 0 && cVar.e() - mGPSAlgorithm.getLatestTimestamp() > 300) {
                                pauseRunning();
                                length2 = mGPSAlgorithm.getLength();
                                length = mGPSAlgorithm.getRelStartIndex();
                                for (i4 = STEP_SIZE; i4 < length2; i4 += SPORT_STATUS_ACTIVE) {
                                    r7 = (length + i4) % ringSize;
                                    cVar2 = (cn.com.smartdevices.bracelet.gps.model.c) this.mPointRing.get(mGPSAlgorithm.getGlobalIndex(r7) % ringSize);
                                    cVar2.q = mGPSAlgorithm.getLongitude(r7);
                                    cVar2.p = mGPSAlgorithm.getLatitude(r7);
                                    this.mCrowdManager.a(cVar2.e() + ", " + cVar2.q + ", " + cVar2.p + ", " + cVar2.o + ", " + cVar2.v + ", " + cVar2.s + ", " + cVar2.f() + ", " + cVar2.d() + "\n", true, this.mCrowdManager.e());
                                }
                                resumeRunning();
                            }
                            if (i7 == 73) {
                                length2 = mGPSAlgorithm.getLength();
                                length = mGPSAlgorithm.getRelStartIndex();
                                for (i4 = STEP_SIZE; i4 < length2; i4 += SPORT_STATUS_ACTIVE) {
                                    r7 = (length + i4) % ringSize;
                                    cVar2 = (cn.com.smartdevices.bracelet.gps.model.c) this.mPointRing.get(r7);
                                    cVar2.r = mGPSAlgorithm.getTimestamp(r7);
                                    cVar2.q = mGPSAlgorithm.getLongitude(r7);
                                    cVar2.p = mGPSAlgorithm.getLatitude(r7);
                                    cVar2.o = mGPSAlgorithm.getAltitude(r7);
                                    this.mCrowdManager.a(cVar2.e() + ", " + cVar2.q + ", " + cVar2.p + ", " + cVar2.o + ", " + cVar2.v + ", " + cVar2.s + ", " + cVar2.f() + ", " + cVar2.d() + "\n", true, this.mCrowdManager.e());
                                }
                                mGPSAlgorithm.getTrackStatistics(this.mTrackStatistics);
                                mGPSAlgorithm.recoverFromCrash(this.mTrackStatistics);
                            }
                            if (mGPSAlgorithm.receiveSample(cVar.q, cVar.p, cVar.o, cVar.r, cVar.v) == VALID_POINT_WAVELET) {
                                i5 = mGPSAlgorithm.getLength();
                                i4 = mGPSAlgorithm.getStepSize();
                                length2 = mGPSAlgorithm.getRelStartIndex();
                                if (i5 == ringSize) {
                                    for (i3 = STEP_SIZE; i3 < i4; i3 += SPORT_STATUS_ACTIVE) {
                                        length = (length2 + i3) % ringSize;
                                        cVar = (cn.com.smartdevices.bracelet.gps.model.c) this.mPointRing.get(length);
                                        cVar.r = mGPSAlgorithm.getTimestamp(length);
                                        cVar.q = mGPSAlgorithm.getLongitude(length);
                                        cVar.p = mGPSAlgorithm.getLatitude(length);
                                        cVar.o = mGPSAlgorithm.getAltitude(length);
                                        this.mCrowdManager.a(cVar.e() + ", " + cVar.q + ", " + cVar.p + ", " + cVar.o + ", " + cVar.v + ", " + cVar.s + ", " + cVar.f() + ", " + cVar.d() + "\n", true, this.mCrowdManager.e());
                                    }
                                }
                            }
                            i5 = i7;
                            i3 = i;
                        } catch (Exception e2) {
                            exception = e2;
                            i3 = i7;
                        }
                    }
                    i2 += SPORT_STATUS_ACTIVE;
                    i = i3;
                    i3 = i5;
                } catch (Exception e3) {
                    exception = e3;
                }
            }
            if (i3 > 0) {
                mGPSAlgorithm.stop();
                i4 = mGPSAlgorithm.getLength();
                length2 = mGPSAlgorithm.getRelStartIndex();
                for (i3 = STEP_SIZE; i3 < i4; i3 += SPORT_STATUS_ACTIVE) {
                    length = (length2 + i3) % ringSize;
                    cVar = (cn.com.smartdevices.bracelet.gps.model.c) this.mPointRing.get(length);
                    cVar.r = mGPSAlgorithm.getTimestamp(length);
                    cVar.q = mGPSAlgorithm.getLongitude(length);
                    cVar.p = mGPSAlgorithm.getLatitude(length);
                    cVar.o = mGPSAlgorithm.getAltitude(length);
                    this.mCrowdManager.a(cVar.e() + ", " + cVar.q + ", " + cVar.p + ", " + cVar.o + ", " + cVar.v + ", " + cVar.s + ", " + cVar.f() + ", " + cVar.d() + "\n", true, this.mCrowdManager.e());
                }
                mGPSAlgorithm.getTrackStatistics(this.mTrackStatistics);
                if (!mGPSAlgorithm.endToFreeSpaces()) {
                    C0596r.e("gaocept", "memory leak in C");
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            C0596r.e("gpsjava", "finish gps test");
            return i;
        }
        throw new AssertionError();
        C0596r.e("gpsjava", exception.getMessage());
    }
}
