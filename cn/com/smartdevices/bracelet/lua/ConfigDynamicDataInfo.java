package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.model.ReportData;
import com.c.a.C0993k;
import com.xiaomi.hm.health.dataprocess.ActiveItem;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import java.util.ArrayList;

public class ConfigDynamicDataInfo {
    private static final String TAG = "ConfigDynamicDataInfo";
    public static ConfigDynamicDataInfo __instance = null;
    private int AQILevel;
    private ActiveItem activeItem = null;
    private ArrayList<ActiveItem> activeItems = null;
    private String apkVersion = null;
    private int battery = 30;
    private int bonus;
    private Boolean connectStatus = Boolean.valueOf(false);
    private int continueDay = 0;
    private ReportData continueReport = null;
    private Boolean dirty = Boolean.valueOf(false);
    private Boolean forceRefresh = Boolean.valueOf(false);
    private int goal;
    private Boolean isBind = Boolean.valueOf(true);
    private boolean isBindSensorHub;
    private boolean isSetScreenUnlock;
    private boolean isShoesBound;
    private boolean isSupportSensorHub;
    private LuaAction luaAction = null;
    private String mDataStr;
    private String mGameInfo;
    private String mLuaVersion;
    private ReportData monthReport = null;
    private int monthStep = 0;
    private ReportData newRecordReport = null;
    private boolean newUser = true;
    private Boolean noData = Boolean.valueOf(true);
    private int percentMonth = 50;
    private int percentWeek = 50;
    private int recordContinue = 0;
    private String recordDate = "2014-06-12";
    private int recordStep = 0;
    private String right;
    private long serverTimeStamp;
    private Boolean showActivity = Boolean.valueOf(false);
    private Boolean showBattery = Boolean.valueOf(false);
    private Boolean showContinue = Boolean.valueOf(false);
    private Boolean showDayComplete = Boolean.valueOf(false);
    private Boolean showMonthReport = Boolean.valueOf(false);
    private Boolean showNewRecord = Boolean.valueOf(false);
    private Boolean showNoFound = Boolean.valueOf(false);
    private Boolean showSleep = Boolean.valueOf(false);
    private Boolean showUnlockInfo = Boolean.valueOf(true);
    private Boolean showWeekReport = Boolean.valueOf(false);
    private int sleepAverageDeepTime = 0;
    SleepInfo sleepInfo = null;
    private int sleepPercent = 0;
    private String subTitle;
    private Boolean supportUnlock = Boolean.valueOf(true);
    private long timeStamp;
    private long timeStamp1;
    private long timeStamp2;
    private String title;
    private int totalSteps = 0;
    private String type;
    private String url;
    private ReportData weekReport = null;
    private int weekStep = 0;
    private boolean weightBinded;

    public static ConfigDynamicDataInfo getInstance() {
        if (__instance == null) {
            ConfigDynamicDataInfo configDynamicDataInfo = new ConfigDynamicDataInfo();
            configDynamicDataInfo.apkVersion = Keeper.readApkVersion();
            __instance = configDynamicDataInfo;
        }
        return __instance;
    }

    public void genConfigDynamicDataInfo() {
    }

    public int getAQILevel() {
        return this.AQILevel;
    }

    public ActiveItem getActiveItem() {
        return this.activeItem;
    }

    public ArrayList<ActiveItem> getActiveItems() {
        return this.activeItems;
    }

    public String getApkVersion() {
        return this.apkVersion;
    }

    public int getBattery() {
        return this.battery;
    }

    public int getBonus() {
        return this.bonus;
    }

    public Boolean getConnecteStatus() {
        return this.connectStatus;
    }

    public int getContinueDay() {
        return this.continueDay;
    }

    public ReportData getContinueReport() {
        return this.continueReport;
    }

    public String getDataStr() {
        return this.mDataStr;
    }

    public Boolean getDirty() {
        return this.dirty;
    }

    public Boolean getForceRefresh() {
        return this.forceRefresh;
    }

    public String getGameInfo() {
        return this.mGameInfo;
    }

    public int getGoal() {
        return this.goal;
    }

    public boolean getIsBind() {
        return this.isBind.booleanValue();
    }

    public LuaAction getLuaAction() {
        return this.luaAction;
    }

    public String getLuaVersion() {
        return this.mLuaVersion;
    }

    public ReportData getMonthReport() {
        return this.monthReport;
    }

    public int getMonthStep() {
        return this.monthStep;
    }

    public ReportData getNewRecordReport() {
        return this.newRecordReport;
    }

    public boolean getNewUser() {
        return this.newUser;
    }

    public Boolean getNoData() {
        return this.noData;
    }

    public int getPercentMonth() {
        return this.percentMonth;
    }

    public int getPercentWeek() {
        return this.percentWeek;
    }

    public int getRecordContinue() {
        return this.recordContinue;
    }

    public String getRecordDate() {
        return this.recordDate;
    }

    public int getRecordStep() {
        return this.recordStep;
    }

    public String getRight() {
        return this.right;
    }

    public long getServerTimeStamp() {
        return this.serverTimeStamp;
    }

    public boolean getShoesBound() {
        return this.isShoesBound;
    }

    public Boolean getShowActivity() {
        return this.showActivity;
    }

    public Boolean getShowBattery() {
        return this.showBattery;
    }

    public Boolean getShowContinue() {
        return this.showContinue;
    }

    public Boolean getShowDayComplete() {
        return this.showDayComplete;
    }

    public Boolean getShowMonthReport() {
        return this.showMonthReport;
    }

    public Boolean getShowNewRecord() {
        return this.showNewRecord;
    }

    public Boolean getShowNoFound() {
        return this.showNoFound;
    }

    public Boolean getShowSleep() {
        return this.showSleep;
    }

    public Boolean getShowUnlockInfo() {
        return this.showUnlockInfo;
    }

    public Boolean getShowWeekReport() {
        return this.showWeekReport;
    }

    public int getSleepAverageDeepTime() {
        return this.sleepAverageDeepTime;
    }

    public SleepInfo getSleepInfo() {
        return this.sleepInfo;
    }

    public int getSleepPercent() {
        return this.sleepPercent;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public Boolean getSupportUnlock() {
        return this.supportUnlock;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public long getTimeStamp1() {
        return this.timeStamp1;
    }

    public long getTimeStamp2() {
        return this.timeStamp2;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTotalSteps() {
        return this.totalSteps;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public ReportData getWeekReport() {
        return this.weekReport;
    }

    public int getWeekStep() {
        return this.weekStep;
    }

    public boolean getWeightBinded() {
        return this.weightBinded;
    }

    public boolean isBindSensorHub() {
        return this.isBindSensorHub;
    }

    public boolean isSetScreenUnlock() {
        return this.isSetScreenUnlock;
    }

    public boolean isShoesSupported() {
        return b.h().t.a.booleanValue();
    }

    public boolean isSupportSensorHub() {
        return this.isSupportSensorHub;
    }

    public boolean isSupportWeight() {
        return b.h().l.a.booleanValue();
    }

    public boolean isWeightBinded() {
        return this.weightBinded;
    }

    public void save() {
        C0993k c0993k = new C0993k();
        a aVar = new a(this);
        aVar.a = Boolean.valueOf(this.newUser);
        C0596r.e(TAG, "newUser = " + aVar.a);
        aVar.b = this.showUnlockInfo;
        aVar.c = this.showUnlockInfo;
        Keeper.keepConfigDynamicDataInfo(c0993k.b(aVar, a.class));
    }

    public void setAQILevel(int i) {
        this.AQILevel = i;
    }

    public void setActiveItem(ActiveItem activeItem) {
        this.activeItem = activeItem;
    }

    public void setActiveItems(ArrayList<ActiveItem> arrayList) {
        this.activeItems = arrayList;
    }

    public void setApkVersion(String str) {
        this.apkVersion = str;
    }

    public void setBattery(int i) {
        this.battery = i;
    }

    public void setBindSensorHub(boolean z) {
        this.isBindSensorHub = z;
    }

    public void setBonus(int i) {
        this.bonus = i;
    }

    public void setConnectStatus(Boolean bool) {
        this.connectStatus = bool;
    }

    public void setContinueDay(int i) {
        this.continueDay = i;
    }

    public void setContinueReport(ReportData reportData) {
        this.continueReport = reportData;
    }

    public void setDataStr(String str) {
        this.mDataStr = str;
    }

    public void setDirty(Boolean bool) {
        this.dirty = bool;
    }

    public void setForceRefresh(Boolean bool) {
        this.forceRefresh = bool;
    }

    public void setGameInfo(String str) {
        this.mGameInfo = str;
    }

    public void setGoal(int i) {
        this.goal = i;
    }

    public void setIsBind(boolean z) {
        this.isBind = Boolean.valueOf(z);
    }

    public void setIsBindSensorHub(boolean z) {
        this.isBindSensorHub = z;
    }

    public void setIsSupportSensorHub(boolean z) {
        this.isSupportSensorHub = z;
    }

    public void setLuaAction(Context context) {
        LuaAction luaAction = this.luaAction;
        this.luaAction = LuaAction.getInstance(context);
    }

    public void setLuaVersion(String str) {
        this.mLuaVersion = str;
    }

    public void setMonthReport(ReportData reportData) {
        this.monthReport = reportData;
    }

    public void setMonthStep(int i) {
        this.monthStep = i;
    }

    public void setNewRecordReport(ReportData reportData) {
        this.newRecordReport = reportData;
    }

    public void setNewUser(boolean z) {
        C0596r.e(TAG, "setNewUser :" + z);
        this.newUser = z;
    }

    public void setNoData(Boolean bool) {
        this.noData = bool;
    }

    public void setPercentMonth(int i) {
        this.percentMonth = i;
    }

    public void setPercentWeek(int i) {
        this.percentWeek = i;
    }

    public void setRecordContinue(int i) {
        this.recordContinue = i;
    }

    public void setRecordDate(String str) {
        this.recordDate = str;
    }

    public void setRecordStep(int i) {
        this.recordStep = i;
    }

    public void setRight(String str) {
        this.right = str;
    }

    public void setScreenUnlock(boolean z) {
        this.isSetScreenUnlock = z;
    }

    public void setServerTimeStamp(long j) {
        this.serverTimeStamp = j;
    }

    public void setShoesBound(boolean z) {
        this.isShoesBound = z;
    }

    public void setShowActivity(Boolean bool) {
        this.showActivity = bool;
    }

    public void setShowBattery(Boolean bool) {
        this.showBattery = bool;
    }

    public void setShowContinue(Boolean bool) {
        this.showContinue = bool;
    }

    public void setShowDayComplete(Boolean bool) {
        this.showDayComplete = bool;
    }

    public void setShowMonthReport(Boolean bool) {
        this.showMonthReport = bool;
    }

    public void setShowNewRecord(Boolean bool) {
        this.showNewRecord = bool;
    }

    public void setShowNoFound(Boolean bool) {
        this.showNoFound = bool;
    }

    public void setShowSleep(Boolean bool) {
        this.showSleep = bool;
    }

    public void setShowUnlockInfo(Boolean bool) {
        this.showUnlockInfo = bool;
    }

    public void setShowWeekReport(Boolean bool) {
        this.showWeekReport = bool;
    }

    public void setSleepAverageDeepTime(int i) {
        this.sleepAverageDeepTime = i;
    }

    public void setSleepInfo(SleepInfo sleepInfo) {
        this.sleepInfo = sleepInfo;
    }

    public void setSleepPercent(int i) {
        this.sleepPercent = i;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setSupportUnlock(Boolean bool) {
        this.supportUnlock = bool;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public void setTimeStamp1(long j) {
        this.timeStamp1 = j;
    }

    public void setTimeStamp2(long j) {
        this.timeStamp2 = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalSteps(int i) {
        this.totalSteps = i;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setWeekReport(ReportData reportData) {
        this.weekReport = reportData;
    }

    public void setWeekStep(int i) {
        this.weekStep = i;
    }

    public void setWeightBinded(boolean z) {
        this.weightBinded = z;
    }
}
