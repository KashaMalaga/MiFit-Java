package cn.com.smartdevices.bracelet.lab.sportmode;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kankan.wheel.widget.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SportBaseInfo {
    public static final String KEY_COST_TIME_IN_GROUP_OF_PB = "gltc";
    public static final String KEY_COUNT_IN_GROUP_OF_PB = "glbr";
    public static final String KEY_END_TIME = "ed";
    public static final String KEY_PB = "pb";
    public static final String KEY_ROUND_COST_TIME_OF_PB = "tc";
    public static final String KEY_ROUND_COUNT_OF_PB = "br";
    public static final String KEY_START_TIME = "st";
    public static final String VERSION = "v";
    public static final int VERSION_CODE = 1;
    protected int mDataParserType = VERSION_CODE;
    protected long mEndSecondTimeInDay;
    protected long mGroupCostTimeOfPB = 0;
    protected int mGroupCountOfPB = 0;
    protected List<GroupItemBaseInfo> mGroupItemInfoList = null;
    protected boolean mIsGroupType = false;
    protected long mRoundCostTimeOfPB = 0;
    protected int mRoundCountOfPB = 0;
    protected int mSavedGroupCountOfPB = -1;
    protected int mSavedRoundCountOfPB = -1;
    protected SportDay mSportDay;
    protected long mSportDayStartMilis = 0;
    protected int mSportType = -1;
    protected long mStartSecondTimeInDay;
    protected int mTotalCount = 0;

    public SportBaseInfo(int i, boolean z) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        this.mSportDayStartMilis = instance.getTimeInMillis();
        this.mSportDay = new SportDay(instance);
        this.mStartSecondTimeInDay = getSecondInDay(System.currentTimeMillis());
        this.mEndSecondTimeInDay = getSecondInDay(System.currentTimeMillis());
        this.mIsGroupType = z;
        this.mSportType = i;
        if (this.mIsGroupType) {
            this.mGroupItemInfoList = new ArrayList();
        }
    }

    private JSONObject createASampleJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.mStartSecondTimeInDay).append(a.ci).append(this.mEndSecondTimeInDay);
            jSONObject.put(stringBuilder.toString(), createGroupJson());
        } catch (JSONException e) {
            C0596r.a("SportBaseInfo", e.getMessage());
        }
        return jSONObject;
    }

    private JSONArray createGroupJson() {
        JSONArray jSONArray = new JSONArray();
        if (this.mGroupItemInfoList != null && this.mGroupItemInfoList.size() > 0) {
            for (GroupItemBaseInfo jsonObject : this.mGroupItemInfoList) {
                jSONArray.put(jsonObject.getJsonObject());
            }
        }
        return jSONArray;
    }

    private long getSecondInDay(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return (instance.getTimeInMillis() - this.mSportDayStartMilis) / 1000;
    }

    public void addGroupItem(GroupItemBaseInfo groupItemBaseInfo) {
        if (groupItemBaseInfo == null) {
            throw new IllegalArgumentException("Argument cant be null");
        } else if (groupItemBaseInfo.getType() != this.mSportType) {
            throw new IllegalArgumentException("This GroupBaseInfo is not type:" + this.mSportType);
        } else if (!this.mIsGroupType || this.mGroupItemInfoList == null) {
            throw new IllegalStateException("The initialization is not group");
        } else if (groupItemBaseInfo.getCount() > 0) {
            this.mGroupItemInfoList.add(groupItemBaseInfo);
        }
    }

    public int calculteTotalCount() {
        if (this.mGroupItemInfoList == null || this.mGroupItemInfoList.size() <= 0) {
            return 0;
        }
        int i = 0;
        for (GroupItemBaseInfo count : this.mGroupItemInfoList) {
            i = count.getCount() + i;
        }
        return i;
    }

    public void clear() {
        if (this.mGroupItemInfoList != null) {
            this.mGroupItemInfoList.clear();
        }
    }

    public JSONObject createJsonForDbData(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bArr == null || bArr.length == 0) {
            stringBuilder.append(createASampleJson().toString());
        } else {
            stringBuilder.append(createASampleJson().toString()).deleteCharAt(stringBuilder.length() - 1).append(f.i).append(new String(bArr).substring(VERSION_CODE));
        }
        try {
            return new JSONObject(stringBuilder.toString());
        } catch (JSONException e) {
            C0596r.a("Lab", e.getMessage());
            return null;
        }
    }

    public SportDay getDay() {
        return this.mSportDay;
    }

    public long getEndDate() {
        return this.mEndSecondTimeInDay;
    }

    public long getGroupCostTime() {
        long j = 0;
        for (GroupItemBaseInfo groupItemBaseInfo : this.mGroupItemInfoList) {
            j = (groupItemBaseInfo.mEndSecondTimeInDay - groupItemBaseInfo.mStartSecondTimeInDay) + j;
        }
        return j;
    }

    public long getGroupCostTimeOfPB() {
        return this.mGroupCostTimeOfPB;
    }

    public int getGroupCountOfPB() {
        return this.mGroupCountOfPB;
    }

    public int getGroupSize() {
        return this.mGroupItemInfoList == null ? 0 : this.mGroupItemInfoList.size();
    }

    public long[] getGroupSumInfo() {
        long j = 0;
        long j2 = 0;
        for (GroupItemBaseInfo groupItemBaseInfo : this.mGroupItemInfoList) {
            j2 += groupItemBaseInfo.mEndSecondTimeInDay - groupItemBaseInfo.mStartSecondTimeInDay;
            j = ((long) groupItemBaseInfo.mCount) + j;
        }
        return new long[]{j, j2};
    }

    public JSONObject getPBSummeryObject() {
        if (this.mRoundCountOfPB <= this.mSavedRoundCountOfPB && this.mGroupCountOfPB <= this.mSavedGroupCountOfPB) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_ROUND_COUNT_OF_PB, this.mRoundCountOfPB);
            jSONObject2.put(KEY_ROUND_COST_TIME_OF_PB, this.mRoundCostTimeOfPB);
            jSONObject2.put(KEY_COUNT_IN_GROUP_OF_PB, this.mGroupCountOfPB);
            jSONObject2.put(KEY_COST_TIME_IN_GROUP_OF_PB, this.mGroupCostTimeOfPB);
            jSONObject.put(KEY_PB, jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            C0596r.a("Lab", e.getMessage());
            return null;
        }
    }

    public long getRoundCostTimeOfPB() {
        return this.mRoundCostTimeOfPB;
    }

    public int getRoundCountOfPB() {
        return this.mRoundCountOfPB;
    }

    public int getSavedGroupCountOfPB() {
        return this.mSavedGroupCountOfPB;
    }

    public int getSavedRoundCountOfPB() {
        return this.mSavedRoundCountOfPB;
    }

    public int getSportType() {
        return this.mSportType;
    }

    public long getStartDate() {
        return this.mStartSecondTimeInDay;
    }

    public int getTotalCount() {
        return this.mTotalCount;
    }

    public long getTotalTimeSpent() {
        int i = 0;
        long j = 0;
        long j2 = 0;
        for (GroupItemBaseInfo groupItemBaseInfo : this.mGroupItemInfoList) {
            if (i == 0) {
                j2 = groupItemBaseInfo.mStartSecondTimeInDay;
                j = groupItemBaseInfo.mEndSecondTimeInDay;
            }
            i += VERSION_CODE;
            j2 = Math.min(j2, groupItemBaseInfo.mStartSecondTimeInDay);
            j = Math.max(j, groupItemBaseInfo.mEndSecondTimeInDay);
        }
        long j3 = j - j2;
        return j3 > 0 ? j3 : 0;
    }

    public boolean isGroupType() {
        return this.mIsGroupType;
    }

    public void loadPBInfo(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int i = jSONObject.getInt(KEY_ROUND_COUNT_OF_PB);
                long j = jSONObject.getLong(KEY_ROUND_COST_TIME_OF_PB);
                int i2 = jSONObject.getInt(KEY_COUNT_IN_GROUP_OF_PB);
                long j2 = jSONObject.getLong(KEY_COST_TIME_IN_GROUP_OF_PB);
                setSavedRoundCountOfPB(i);
                setRoundCountOfPB(i);
                setRoundCostTimeOfPB(j);
                setSavedGroupCountOfPB(i2);
                setGroupCountOfPB(i2);
                setGroupCostTimeOfPB(j2);
            } catch (JSONException e) {
                C0596r.a("Lab", e.getMessage());
            }
        }
    }

    public void removeGroupItem(GroupItemBaseInfo groupItemBaseInfo) {
        if (groupItemBaseInfo == null) {
            throw new IllegalArgumentException();
        } else if (groupItemBaseInfo.getType() != this.mSportType) {
            throw new IllegalArgumentException("This GroupBaseInfo is not type:" + this.mSportType);
        } else if (!this.mIsGroupType || this.mGroupItemInfoList == null) {
            throw new IllegalStateException("The initialization is not group");
        } else {
            this.mGroupItemInfoList.remove(groupItemBaseInfo);
        }
    }

    public void setEndTime() {
        this.mEndSecondTimeInDay = getSecondInDay(System.currentTimeMillis());
    }

    public void setGroupCostTimeOfPB(long j) {
        this.mGroupCostTimeOfPB = j;
    }

    public void setGroupCountOfPB(int i) {
        this.mGroupCountOfPB = i;
    }

    public void setGroupItemInfoList(List<GroupItemBaseInfo> list) {
        if (list == null) {
            throw new IllegalArgumentException("Argument cant be null");
        } else if (this.mIsGroupType) {
            this.mGroupItemInfoList = list;
        } else {
            throw new IllegalStateException("The initialization is not group");
        }
    }

    public void setRoundCostTimeOfPB(long j) {
        this.mRoundCostTimeOfPB = j;
    }

    public void setRoundCountOfPB(int i) {
        this.mRoundCountOfPB = i;
    }

    public void setSavedGroupCountOfPB(int i) {
        this.mSavedGroupCountOfPB = i;
    }

    public void setSavedRoundCountOfPB(int i) {
        this.mSavedRoundCountOfPB = i;
    }

    public void setStartDate() {
        this.mStartSecondTimeInDay = getSecondInDay(System.currentTimeMillis());
    }

    public void setTotalCount(int i) {
        this.mTotalCount = i;
    }

    public void updateGroupCostTimeOfPB() {
        this.mGroupCostTimeOfPB = getGroupCostTime();
    }
}
