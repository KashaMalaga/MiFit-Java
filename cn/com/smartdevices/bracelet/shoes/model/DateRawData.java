package cn.com.smartdevices.bracelet.shoes.model;

import android.support.v4.media.h;
import android.util.SparseArray;
import com.xiaomi.hm.health.bt.model.d;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import kankan.wheel.widget.a;

public class DateRawData {
    private static final int DAY_SPORT_LEN = 1440;
    private static final String TAG = "DRD";
    private SparseArray<d> mIndexedDateRawData = null;
    private boolean mIsInParsedState = false;
    private SportDay mSportDay = null;
    private final StepsInfo mStepsInfo = new StepsInfo();

    public DateRawData(SportDay sportDay) {
        this.mSportDay = sportDay;
        this.mIndexedDateRawData = new SparseArray(DAY_SPORT_LEN);
        for (int i = 0; i < DAY_SPORT_LEN; i++) {
            this.mIndexedDateRawData.put(i, new d(a.ac, (byte) 0, (byte) 0));
        }
    }

    private d getValidIndexData(int i) {
        d dVar = (d) this.mIndexedDateRawData.get(i);
        return dVar.e() != h.i ? dVar : null;
    }

    private void setParsedState(boolean z) {
        this.mIsInParsedState = z;
    }

    public byte[] getBinaryData() {
        int size = this.mIndexedDateRawData.size();
        byte[] bArr = new byte[(size * 3)];
        byte[] bArr2 = new byte[3];
        for (int i = 0; i < size; i++) {
            bArr2 = ((d) this.mIndexedDateRawData.get(i)).f();
            bArr[i * 3] = bArr2[0];
            bArr[(i * 3) + 1] = bArr2[1];
            bArr[(i * 3) + 2] = bArr2[2];
        }
        return bArr;
    }

    public int getDataSize() {
        return this.mIndexedDateRawData.size();
    }

    public int getDay() {
        return this.mSportDay.day;
    }

    public d getMinuteData(int i) {
        return getValidIndexData(i);
    }

    public int getMonth() {
        return this.mSportDay.mon;
    }

    public SleepInfo getSleepInfo() {
        return null;
    }

    public SportDay getSportDay() {
        return this.mSportDay;
    }

    public StepsInfo getStepsInfo() {
        return this.mStepsInfo;
    }

    public long getTimestamp() {
        return this.mSportDay.getTimestamp();
    }

    public int getYear() {
        return this.mSportDay.year;
    }

    public boolean isNeedParseData() {
        return !this.mIsInParsedState;
    }

    public void setInfos(StepsInfo stepsInfo, SleepInfo sleepInfo, int i) {
        this.mStepsInfo.copy(stepsInfo);
        setParsedState(true);
    }

    public boolean setMinuteData(int i, d dVar) {
        if (getValidIndexData(i) != null || dVar == null) {
            return false;
        }
        this.mIndexedDateRawData.put(i, dVar);
        setParsedState(false);
        return true;
    }

    public boolean setRawData(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        int length = bArr.length;
        if (length % 3 != 0) {
            return false;
        }
        for (int i = 0; i < length; i += 3) {
            this.mIndexedDateRawData.put(i / 3, new d(bArr[i], bArr[i + 1], bArr[i + 2]));
        }
        setParsedState(false);
        return true;
    }

    public void setSleepInfo(SleepInfo sleepInfo) {
    }

    public void setStepsInfo(StepsInfo stepsInfo) {
        this.mStepsInfo.copy(stepsInfo);
        setParsedState(true);
    }
}
