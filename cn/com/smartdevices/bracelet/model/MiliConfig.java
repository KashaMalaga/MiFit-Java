package cn.com.smartdevices.bracelet.model;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.ui.AlarmActivity;
import com.c.a.z;
import java.util.Calendar;
import kankan.wheel.widget.a;
import org.json.JSONException;
import org.json.JSONObject;

public class MiliConfig {
    public static final String BLUE = "BLUE";
    public static final String GREEN = "GREEN";
    public static final String LEFT_HAND = "LEFT_HAND";
    public static final String ONBODY = "ONBODY";
    public static final String ORANGE = "ORANGE";
    public static final String RED = "RED";
    public static final String RIGHT_HAND = "RIGHT_HAND";
    private static final String TAG = "MiliConfig";
    public boolean alarmNotifyEnabled = false;
    public String dayReportNoti = C0401a.fH;
    public int disconnectedReminder = 0;
    public boolean enableConnectedBtAdv = false;
    public Calendar firstUseDate;
    public int goalStepsCount = a.bS;
    public boolean hasHeartRate = false;
    public int inComingCallNotifyTime = PersonInfo.INCOMING_CALL_DEFAULT;
    public boolean incallContactNotifyEnabled = false;
    public boolean incallNotifyEnabled = false;
    public String lightColor = BLUE;
    public boolean mOpenSleepNotify = false;
    public boolean sleepAssist = false;
    public boolean smsContactNotifyEnabled = false;
    public boolean smsNotifyEnabled = false;
    public int unit = 0;
    public boolean vibrate = false;
    public String wearHand = LEFT_HAND;
    private boolean weightMergeResult = false;
    public int weightUnit = 0;

    private static String formatJsonStr(String str) {
        z zVar = new z();
        try {
            JSONObject jSONObject = new JSONObject(str);
            zVar.a("alarmNotifyEnabled", Boolean.valueOf(jSONObject.getString("alarmNotifyEnabled")));
            zVar.a("dayReportNoti", jSONObject.getString("dayReportNoti"));
            try {
                zVar.a("disconnectedReminder", Integer.valueOf(jSONObject.getString("disconnectedReminder")));
            } catch (Exception e) {
                zVar.a("disconnectedReminder", Byte.valueOf((byte) 0));
            }
            zVar.a("enableConnectedBtAdv", Boolean.valueOf(jSONObject.getBoolean("enableConnectedBtAdv")));
            zVar.a("goalStepsCount", Integer.valueOf(jSONObject.getInt("goalStepsCount")));
            zVar.a("lightColor", jSONObject.getString("lightColor"));
            zVar.a("inComingCallNotifyTime", Integer.valueOf(jSONObject.getInt("inComingCallNotifyTime")));
            zVar.a("mOpenSleepNotify", Boolean.valueOf(jSONObject.getBoolean("mOpenSleepNotify")));
            zVar.a("smsNotifyEnabled", Boolean.valueOf(jSONObject.getBoolean("smsNotifyEnabled")));
            zVar.a("incallNotifyEnabled", Boolean.valueOf(jSONObject.getBoolean("incallNotifyEnabled")));
            zVar.a("unit", Integer.valueOf(jSONObject.getInt("unit")));
            zVar.a(AlarmActivity.i, Boolean.valueOf(jSONObject.getBoolean(AlarmActivity.i)));
            zVar.a("wearHand", jSONObject.getString("wearHand"));
            zVar.a("weightMergeResult", Boolean.valueOf(jSONObject.getBoolean("weightMergeResult")));
            zVar.a("weightUnit", Integer.valueOf(jSONObject.getInt("weightUnit")));
            zVar.a("smsContactNotifyEnabled", Boolean.valueOf(jSONObject.getBoolean("smsContactNotifyEnabled")));
            zVar.a("incallContactNotifyEnabled", Boolean.valueOf(jSONObject.getBoolean("incallContactNotifyEnabled")));
            zVar.a("sleepAssist", Boolean.valueOf(jSONObject.optBoolean("sleepAssist")));
            zVar.a("hasHeartRate", Boolean.valueOf(jSONObject.optBoolean("hasHeartRate")));
            return zVar.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static MiliConfig fromJsonStr(String str) {
        MiliConfig miliConfig;
        C0596r.e("SCORPIONEAL", "the MiliConfig fromString is " + str);
        try {
            miliConfig = (MiliConfig) Utils.c().a(str, MiliConfig.class);
        } catch (Exception e) {
            try {
                miliConfig = (MiliConfig) Utils.c().a(formatJsonStr(str), MiliConfig.class);
            } catch (Exception e2) {
                miliConfig = new MiliConfig();
            }
        }
        return miliConfig == null ? new MiliConfig() : miliConfig;
    }

    public boolean getDailySleepNofity() {
        return this.mOpenSleepNotify;
    }

    public String getDailySportNofity() {
        return this.dayReportNoti;
    }

    public boolean getWeightMergeResult() {
        return this.weightMergeResult;
    }

    public boolean isValid() {
        boolean z = !TextUtils.isEmpty(this.lightColor) && !TextUtils.isEmpty(this.wearHand) && this.goalStepsCount > 0 && (this.inComingCallNotifyTime == -1 || this.inComingCallNotifyTime >= 0);
        C0596r.e(TAG, "isValid=" + z + ", " + this);
        return z;
    }

    public void setDailySleepNotify(boolean z) {
        this.mOpenSleepNotify = z;
    }

    public void setDailySportNotify(String str) {
        this.dayReportNoti = str;
    }

    public void setWeightMergeResult(boolean z) {
        this.weightMergeResult = z;
    }

    public String toString() {
        String b = Utils.c().b((Object) this);
        if (b == null) {
            return null;
        }
        C0596r.e("SCORPIONEAL", "the MiliConfig ---toString--- is " + b.toString());
        return b.toString();
    }
}
