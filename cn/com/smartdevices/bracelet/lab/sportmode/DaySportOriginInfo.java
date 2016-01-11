package cn.com.smartdevices.bracelet.lab.sportmode;

import cn.com.smartdevices.bracelet.C0596r;
import org.json.JSONException;
import org.json.JSONObject;

public class DaySportOriginInfo {
    public static final String KEY_CAL_OF_DAY = "cal";
    public static final String KEY_TOTAL_COUNT_OF_DAY = "cnt";
    protected int mCalOfDay = 0;
    protected int mCalOfLatestGroup = 0;
    protected int mCostTimeOfLatestGroup = 0;
    protected int mCountOfLatestGroup = 0;
    protected int mEndTimeOfLatestGroup = 0;
    protected long mGroupCostTimeOfPB = 0;
    protected int mGroupCountOfPB = -1;
    protected long mRoundCostTimeOfPB = 0;
    protected int mRoundCountOfPB = -1;
    protected int mRoundPBCountOfDay = 0;
    protected int mSportType = -1;
    protected int mStartTimeOfLatestGroup = 0;
    protected int mTotalCountOfDay = 0;

    public DaySportOriginInfo(int i) {
        this.mSportType = i;
    }

    public int getCalOfDay() {
        return this.mCalOfDay;
    }

    public int getCalOfLatestGroup() {
        return this.mCalOfLatestGroup;
    }

    public int getCostTimeOfLatestGroup() {
        return this.mCostTimeOfLatestGroup;
    }

    public int getCountOfLatestGroup() {
        return this.mCountOfLatestGroup;
    }

    public int getEndTimeOfLatestGroup() {
        return this.mEndTimeOfLatestGroup;
    }

    public long getGroupCostTimeOfPB() {
        return this.mGroupCostTimeOfPB;
    }

    public int getGroupCountOfPB() {
        return this.mGroupCountOfPB;
    }

    public long getRoundCostTimeOfPB() {
        return this.mRoundCostTimeOfPB;
    }

    public int getRoundCountOfPB() {
        return this.mRoundCountOfPB;
    }

    public int getRoundPBCountOfDay() {
        return this.mRoundPBCountOfDay;
    }

    public int getSportType() {
        return this.mSportType;
    }

    public int getStartTimeOfLatestGroup() {
        return this.mStartTimeOfLatestGroup;
    }

    public JSONObject getSummeryJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_CAL_OF_DAY, this.mCalOfDay);
            jSONObject.put(KEY_TOTAL_COUNT_OF_DAY, this.mTotalCountOfDay);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SportBaseInfo.KEY_ROUND_COUNT_OF_PB, this.mRoundCountOfPB);
            jSONObject2.put(SportBaseInfo.KEY_ROUND_COST_TIME_OF_PB, this.mRoundCostTimeOfPB);
            jSONObject2.put(SportBaseInfo.KEY_COUNT_IN_GROUP_OF_PB, this.mGroupCountOfPB);
            jSONObject2.put(SportBaseInfo.KEY_COST_TIME_IN_GROUP_OF_PB, this.mGroupCostTimeOfPB);
            jSONObject.put(SportBaseInfo.KEY_PB, jSONObject2);
            jSONObject.put(SportBaseInfo.VERSION, 1);
        } catch (JSONException e) {
            C0596r.a("SportSummeryBaseInfo", e.getMessage());
        }
        return jSONObject;
    }

    public int getTotalCountOfDay() {
        return this.mTotalCountOfDay;
    }

    public void setCalOfDay(int i) {
        this.mCalOfDay = i;
    }

    public void setCalOfLatestGroup(int i) {
        this.mCalOfLatestGroup = i;
    }

    public void setCostTimeOfLatestGroup(int i) {
        this.mCostTimeOfLatestGroup = i;
    }

    public void setCountOfLatestGroup(int i) {
        this.mCountOfLatestGroup = i;
    }

    public void setEndTimeOfLatestGroup(int i) {
        this.mEndTimeOfLatestGroup = i;
    }

    public void setGroupCostTimeOfPB(long j) {
        this.mGroupCostTimeOfPB = j;
    }

    public void setGroupCountOfPB(int i) {
        this.mGroupCountOfPB = i;
    }

    public void setGroupPBCountOfDay(int i) {
        this.mRoundPBCountOfDay = i;
    }

    public void setRoundCostTimeOfPB(long j) {
        this.mRoundCostTimeOfPB = j;
    }

    public void setRoundCountOfPB(int i) {
        this.mRoundCountOfPB = i;
    }

    public void setStartTimeOfLatestGroup(int i) {
        this.mStartTimeOfLatestGroup = i;
    }

    public void setTotalCountOfDay(int i) {
        this.mTotalCountOfDay = i;
    }
}
