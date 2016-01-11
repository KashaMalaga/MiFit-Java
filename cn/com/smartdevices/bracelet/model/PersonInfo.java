package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.a.r;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;
import com.xiaomi.hm.health.bt.profile.a.i;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.ArrayList;
import java.util.Calendar;

public class PersonInfo {
    public static final int COMPATIABLE_VALUE = 1000;
    public static final int INCOMING_CALL_DEFAULT = 258;
    public static final int INCOMING_CALL_DEFAULT_SEC = 2;
    public static final int INCOMING_CALL_DISABLE_BIT = 256;
    public static final int SYNC_AVATAR_NEEDED = 1;
    public static final int SYNC_OK = 0;
    public static final int SYNC_PERSON_NEEDED = 2;
    private static final String TAG = "PersonInfo";
    @Deprecated
    public int age = -1;
    public ArrayList<AlarmClockItem> alarmClockItems = new ArrayList();
    public String avatarPath = a.f;
    public String avatarUrl = a.f;
    public String birthday = a.f;
    public String createTime = a.f;
    public String deviceId = a.f;
    public int gender = -1;
    public int gid = -1;
    public int height = -1;
    public String lastLoginTime = a.f;
    public UserLocationData location = new UserLocationData();
    public MiliConfig miliConfig = new MiliConfig();
    private boolean miliSleepAssist;
    private int needSyncServer = SYNC_OK;
    public String nickname = a.f;
    public String personSignature = a.f;
    public String pinyin = "#";
    public String sh = a.f;
    public String source = a.f;
    public int state = SYNC_OK;
    public float targetWeight = GroundOverlayOptions.NO_DIMENSION;
    public UserTotalSportData totalSportData = new UserTotalSportData();
    public long uid = -1;
    private int version = SYNC_OK;
    public float weight = GroundOverlayOptions.NO_DIMENSION;

    public static ArrayList<AlarmClockItem> parseAlarmClockItems(String str) {
        try {
            return (ArrayList) Utils.c().a(str, new com.c.a.c.a<ArrayList<AlarmClockItem>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clearNeedSyncServer() {
        this.needSyncServer = SYNC_OK;
    }

    public void disableInComingCallTime() {
        this.miliConfig.inComingCallNotifyTime = getInComingCallTime() | INCOMING_CALL_DISABLE_BIT;
        C0596r.e(TAG, "disable incoming = " + this.miliConfig.inComingCallNotifyTime);
    }

    public void enableAlarmNotify(boolean z) {
        this.miliConfig.alarmNotifyEnabled = z;
    }

    public void enableConnectedBtAdv(boolean z) {
        this.miliConfig.enableConnectedBtAdv = z;
    }

    public void enableInComingCallTime() {
        this.miliConfig.inComingCallNotifyTime = getInComingCallTime() & HeartRateInfo.HR_EMPTY_VALUE;
        C0596r.e(TAG, "enable incoming = " + this.miliConfig.inComingCallNotifyTime);
    }

    public void enableSmsNotify(boolean z) {
        this.miliConfig.smsNotifyEnabled = z;
    }

    public int getAge() {
        return this.age;
    }

    public ArrayList<AlarmClockItem> getAlarmClockItems() {
        if (this.alarmClockItems == null) {
            this.alarmClockItems = new ArrayList();
        }
        if (this.alarmClockItems.size() < 3) {
            ArrayList readMorningAlarms = Keeper.readMorningAlarms();
            int i = SYNC_OK;
            int size = this.alarmClockItems.size();
            while (size < 3) {
                int i2;
                AlarmClockItem alarmClockItem = new AlarmClockItem();
                if (readMorningAlarms == null || readMorningAlarms.size() <= i) {
                    i2 = i;
                } else {
                    alarmClockItem.setCalendar((Calendar) readMorningAlarms.get(i));
                    i2 = i + SYNC_AVATAR_NEEDED;
                }
                this.alarmClockItems.add(alarmClockItem);
                size += SYNC_AVATAR_NEEDED;
                i = i2;
            }
            Keeper.keepPersonInfo(this);
            C0596r.e(TAG, "add new alarm size=" + this.alarmClockItems.size());
        }
        return this.alarmClockItems;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public int getDaySportGoalSteps() {
        return this.miliConfig.goalStepsCount;
    }

    public Calendar getFirstUseDate() {
        return this.miliConfig.firstUseDate;
    }

    public int getInComingCallTime() {
        return this.miliConfig.inComingCallNotifyTime & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public i getMiLiHwConfig() {
        int i = r.c;
        i iVar = new i();
        if (getDaySportGoalSteps() > 0) {
            iVar.b = getDaySportGoalSteps();
        } else {
            C0596r.e(TAG, "day sport goals is inValid!");
        }
        iVar.c = getAlarmClockItems();
        if (this.miliConfig == null || this.miliConfig.lightColor == null) {
            C0596r.b(TAG, "miliConfig is null or lightColor is null");
        } else {
            String str = this.miliConfig.lightColor;
            if (!str.equals(MiliConfig.BLUE)) {
                if (str.equals(MiliConfig.GREEN)) {
                    i = r.e;
                } else if (str.equals(MiliConfig.RED)) {
                    i = r.f;
                } else if (str.equals(MiliConfig.ORANGE)) {
                    i = r.d;
                }
            }
            iVar.d = i;
        }
        if (this.miliConfig == null || this.miliConfig.wearHand == null) {
            C0596r.b(TAG, "miliConfig is null or wearHand is null");
        } else {
            String str2 = this.miliConfig.wearHand;
            byte b = str2.equals(MiliConfig.LEFT_HAND) ? (byte) 0 : str2.equals(MiliConfig.RIGHT_HAND) ? (byte) 1 : str2.equals(MiliConfig.ONBODY) ? (byte) 2 : (byte) 0;
            iVar.f = b;
        }
        if (this.miliConfig != null) {
            iVar.h = this.miliConfig.sleepAssist;
        }
        if (this.miliConfig != null) {
            iVar.g = this.miliConfig.enableConnectedBtAdv;
        }
        return iVar;
    }

    public String getMiliColor() {
        return this.miliConfig.lightColor;
    }

    public MiliConfig getMiliConfig() {
        return this.miliConfig;
    }

    public int getMiliDisconnectedReminder() {
        return this.miliConfig.disconnectedReminder;
    }

    public boolean getMiliSleepAssist() {
        return this.miliConfig.sleepAssist;
    }

    public boolean getMiliVibrate() {
        return this.miliConfig.vibrate;
    }

    public String getMiliWearHand() {
        return this.miliConfig.wearHand;
    }

    public int getNeedSyncServer() {
        return this.needSyncServer;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getPersonInfoUnit() {
        return this.miliConfig.unit;
    }

    public float getTargetWeight() {
        return this.targetWeight;
    }

    public int getTotalDistance() {
        return this.totalSportData != null ? this.totalSportData.getDistance() : SYNC_OK;
    }

    public UserTotalSportData getTotalSportData() {
        return this.totalSportData;
    }

    public int getUnit() {
        return this.miliConfig.unit;
    }

    public int getVersion() {
        return this.version;
    }

    public float getWeight() {
        return this.weight;
    }

    public int getWeightUnit() {
        return this.miliConfig.weightUnit;
    }

    public boolean hasBinded1S() {
        return this.miliConfig.hasHeartRate;
    }

    public boolean isAlarmNotifyEnabled() {
        return this.miliConfig.alarmNotifyEnabled;
    }

    public boolean isEnableConnectedBtAdv() {
        return this.miliConfig.enableConnectedBtAdv;
    }

    public boolean isInComingCallEnabled() {
        boolean z = (this.miliConfig.inComingCallNotifyTime & INCOMING_CALL_DISABLE_BIT) == 0;
        C0596r.e(TAG, "isInComingCallEnabled = " + z);
        return z;
    }

    public boolean isSmsNotifyEnabled() {
        return this.miliConfig.smsNotifyEnabled;
    }

    public boolean isValid() {
        return (this.uid == -1 || this.gender == -1 || this.height == -1 || this.weight == GroundOverlayOptions.NO_DIMENSION || this.age == -1 || getDaySportGoalSteps() <= 0) ? false : true;
    }

    public void setAge(int i) {
        this.age = i;
        C0596r.e(TAG, "setAge = " + i);
    }

    public void setBinded1S(boolean z) {
        this.miliConfig.hasHeartRate = z;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setDaySportGoals(int i) {
        this.miliConfig.goalStepsCount = i;
    }

    public void setFirstUseDate(Calendar calendar) {
        this.miliConfig.firstUseDate = calendar;
    }

    public void setInComingCallTime(int i) {
        this.miliConfig.inComingCallNotifyTime = (this.miliConfig.inComingCallNotifyTime & INCOMING_CALL_DISABLE_BIT) | i;
        C0596r.e(TAG, "set incoming = " + this.miliConfig.inComingCallNotifyTime);
    }

    public void setMiliColor(String str) {
        this.miliConfig.lightColor = str;
    }

    public void setMiliConfig(MiliConfig miliConfig) {
        this.miliConfig = miliConfig;
    }

    public void setMiliDisconnectedReminder(int i) {
        this.miliConfig.disconnectedReminder = i;
    }

    public void setMiliSleepAssist(boolean z) {
        this.miliConfig.sleepAssist = z;
    }

    public void setMiliVibrate(boolean z) {
        this.miliConfig.vibrate = z;
    }

    public void setMiliWearHand(String str) {
        this.miliConfig.wearHand = str;
    }

    public void setNeedSyncServer(int i) {
        this.needSyncServer |= i;
    }

    public void setTargetWeight(float f) {
        this.targetWeight = f;
    }

    public void setUnit(int i) {
        this.miliConfig.unit = i;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setWeight(float f) {
        this.weight = f;
    }

    public String toString() {
        return Utils.c().b((Object) this);
    }
}
