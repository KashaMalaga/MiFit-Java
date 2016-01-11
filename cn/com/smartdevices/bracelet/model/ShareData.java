package cn.com.smartdevices.bracelet.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.e.a;

public class ShareData implements Parcelable {
    private static final int COLOR_ACTIVITY_STEP = -16740656;
    private static final int COLOR_CONTINUE_SUCC = -1754044;
    private static final int COLOR_CONTINUE_SUCC_NEW_RECORD = -691920;
    private static final int COLOR_GOAL_FAILED = -16740656;
    private static final int COLOR_GOAL_SUCC = -691920;
    private static final int COLOR_LAB_SPORT_ACCUMULATE = -16750792;
    private static final int COLOR_LAB_SPORT_NEW_RECORD = -691920;
    private static final int COLOR_LAST_NIGHT_SLEEP = -13157004;
    private static final int COLOR_MONTH_SLEEP = -11982228;
    private static final int COLOR_MONTH_STEP = -15228318;
    private static final int COLOR_NEW_RECORD = -1157324;
    private static final int COLOR_WEEK_SLEEP = -11982228;
    private static final int COLOR_WEEK_STEP = -15228318;
    public static final Creator<ShareData> CREATOR = new Creator<ShareData>() {
        public ShareData createFromParcel(Parcel parcel) {
            ShareData shareData = new ShareData();
            shareData.title = parcel.readString();
            shareData.content = parcel.readString();
            shareData.contentUnit = parcel.readString();
            shareData.time = parcel.readString();
            shareData.time_tips = parcel.readString();
            shareData.description = parcel.readString();
            shareData.ranking = parcel.readString();
            shareData.url = parcel.readString();
            shareData.color = parcel.readInt();
            shareData.type = parcel.readInt();
            shareData.fuid = parcel.readInt();
            shareData.weightTitle = parcel.readString();
            shareData.weightValue = parcel.readString();
            shareData.weightTips = parcel.readString();
            shareData.weightFigure = parcel.readString();
            shareData.weightBMI = parcel.readString();
            shareData.babyMonthsStr = parcel.readString();
            shareData.babyRefWeights = parcel.readString();
            shareData.mExtraData = parcel.readBundle();
            return shareData;
        }

        public ShareData[] newArray(int i) {
            return null;
        }
    };
    public static final int SHARE_TYPE_ACTIVITY_STEP = 9;
    public static final int SHARE_TYPE_CONTINUE_SUCC = 8;
    public static final int SHARE_TYPE_CONTINUE_SUCC_NEW_RECORD = 10;
    public static final int SHARE_TYPE_EVENT = 11;
    public static final int SHARE_TYPE_GOAL_FAILED = 1;
    public static final int SHARE_TYPE_GOAL_SUCC = 0;
    public static final int SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE = 101;
    public static final int SHARE_TYPE_LAB_ROPE_SKIPPING_NEW_RECORD = 100;
    public static final int SHARE_TYPE_LAB_SITUP_ACCUMULATE = 103;
    public static final int SHARE_TYPE_LAB_SITUP_NEW_RECORD = 102;
    public static final int SHARE_TYPE_LAST_NIGHT_SLEEP = 2;
    public static final int SHARE_TYPE_MONTH_AVE_STEPS = 6;
    public static final int SHARE_TYPE_MONTH_SLEEP = 4;
    public static final int SHARE_TYPE_NEW_RECORD = 5;
    public static final int SHARE_TYPE_SERVICE = 13;
    public static final int SHARE_TYPE_SPORT_INFO = 12;
    public static final int SHARE_TYPE_WEEK_AVE_STEPS = 7;
    public static final int SHARE_TYPE_WEEK_SLEEP = 3;
    public static final int SHARE_TYPE_WEIGHT_REPORT_SHARE = 200;
    public String babyMonthsStr = a.f;
    public String babyRefWeights;
    public int color = SHARE_TYPE_GOAL_SUCC;
    public String content = a.f;
    public String contentUnit = a.f;
    public String description = a.f;
    public int fuid = -1;
    public Bundle mExtraData = null;
    public String ranking = a.f;
    public String time = a.f;
    public String time_tips = a.f;
    public String title = a.f;
    public int type = SHARE_TYPE_GOAL_SUCC;
    public String url = a.f;
    public String weightBMI = a.f;
    public String weightFigure = a.f;
    public String weightTips = a.f;
    public String weightTitle = a.f;
    public String weightValue = a.f;

    public enum TimeType {
        DAY,
        WEEK,
        MONTH
    }

    public ShareData(int i) {
        setType(i);
    }

    public int describeContents() {
        return SHARE_TYPE_GOAL_SUCC;
    }

    public String getBabyMonthsStr() {
        return this.babyMonthsStr;
    }

    public String getBabyRefWeights() {
        return this.babyRefWeights;
    }

    public int getColor() {
        return this.color;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentUnit() {
        return this.contentUnit;
    }

    public String getDescription() {
        return this.description;
    }

    public int getFuid() {
        return this.fuid;
    }

    public String getRanking() {
        return this.ranking;
    }

    public String getTime() {
        return this.time;
    }

    public String getTimeTips() {
        return this.time_tips;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getWeightBMI() {
        return this.weightBMI;
    }

    public String getWeightFigure() {
        return this.weightFigure;
    }

    public String getWeightTips() {
        return this.weightTips;
    }

    public String getWeightTitle() {
        return this.weightTitle;
    }

    public String getWeightValue() {
        return this.weightValue;
    }

    public boolean isSleepType() {
        return this.type == SHARE_TYPE_LAST_NIGHT_SLEEP || this.type == SHARE_TYPE_MONTH_SLEEP || this.type == SHARE_TYPE_WEEK_SLEEP;
    }

    public void setBabyMonthsStr(String str) {
        this.babyMonthsStr = str;
    }

    public void setBabyRefWeights(String str) {
        this.babyRefWeights = str;
    }

    public void setType(int i) {
        this.type = i;
        switch (i) {
            case SHARE_TYPE_GOAL_SUCC /*0*/:
                this.color = COLOR_LAB_SPORT_NEW_RECORD;
                return;
            case SHARE_TYPE_GOAL_FAILED /*1*/:
                this.color = COLOR_GOAL_FAILED;
                return;
            case SHARE_TYPE_LAST_NIGHT_SLEEP /*2*/:
                this.color = COLOR_LAST_NIGHT_SLEEP;
                return;
            case SHARE_TYPE_WEEK_SLEEP /*3*/:
                this.color = COLOR_WEEK_SLEEP;
                return;
            case SHARE_TYPE_MONTH_SLEEP /*4*/:
                this.color = COLOR_WEEK_SLEEP;
                return;
            case SHARE_TYPE_NEW_RECORD /*5*/:
                this.color = COLOR_NEW_RECORD;
                return;
            case SHARE_TYPE_MONTH_AVE_STEPS /*6*/:
                this.color = COLOR_WEEK_STEP;
                return;
            case SHARE_TYPE_WEEK_AVE_STEPS /*7*/:
                this.color = COLOR_WEEK_STEP;
                return;
            case SHARE_TYPE_CONTINUE_SUCC /*8*/:
                this.color = COLOR_CONTINUE_SUCC;
                return;
            case SHARE_TYPE_ACTIVITY_STEP /*9*/:
                this.color = COLOR_GOAL_FAILED;
                return;
            case SHARE_TYPE_CONTINUE_SUCC_NEW_RECORD /*10*/:
                this.color = COLOR_LAB_SPORT_NEW_RECORD;
                return;
            case SHARE_TYPE_LAB_ROPE_SKIPPING_NEW_RECORD /*100*/:
            case SHARE_TYPE_LAB_SITUP_NEW_RECORD /*102*/:
                this.color = COLOR_LAB_SPORT_NEW_RECORD;
                return;
            case SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE /*101*/:
            case SHARE_TYPE_LAB_SITUP_ACCUMULATE /*103*/:
                this.color = COLOR_LAB_SPORT_ACCUMULATE;
                return;
            default:
                return;
        }
    }

    public String toString() {
        return "type:" + this.type + "\n" + "title:" + this.title + "\n" + "content:" + this.content + "\n" + "contentUnit:" + this.contentUnit + "\n" + "time:" + this.time + "\n" + "time_tips:" + this.time_tips + "\n" + "description:" + this.description + "\n" + "ranking:" + this.ranking + "\n" + "color:" + this.color + "\nurl:" + this.url + "\nfuid:" + this.fuid + "\nweightTitle:" + this.weightTitle + "\nweightValue:" + this.weightValue + "\nweightTips:" + this.weightTips + "\nweightFigure:" + this.weightFigure + "\nweightBMI:" + this.weightBMI;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.contentUnit);
        parcel.writeString(this.time);
        parcel.writeString(this.time_tips);
        parcel.writeString(this.description);
        parcel.writeString(this.ranking);
        parcel.writeString(this.url);
        parcel.writeInt(this.color);
        parcel.writeInt(this.type);
        parcel.writeInt(this.fuid);
        parcel.writeString(this.weightTitle);
        parcel.writeString(this.weightValue);
        parcel.writeString(this.weightTips);
        parcel.writeString(this.weightFigure);
        parcel.writeString(this.weightBMI);
        parcel.writeString(this.babyMonthsStr);
        parcel.writeString(this.babyRefWeights);
        parcel.writeBundle(this.mExtraData);
    }
}
