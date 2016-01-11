package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Utils;
import com.xiaomi.e.a;

public class UserTotalSportData {
    public int avgSleepEndTime = 0;
    public int avgSleepStartTime = 0;
    public int highestStep = 0;
    public String highestStepDay = a.f;
    public int iAverageSteps = 0;
    public int iDistance = 0;
    public int iSteps = 0;
    public int iTotalwearingdays = 0;
    private int lazyDaySkips;
    public String longestSleepDay = a.f;
    public int longestSleepDeepMin = 0;
    public int longestSleepMin = 0;
    public int maxContinueRecord = 0;
    public String maxContinueRecordDay = a.f;
    private ReportData reportData;
    @com.c.a.a.a
    public String startUseDay = a.f;
    public int totalRunDist = 0;
    private ReportData weekReportData;

    public static UserTotalSportData fromJsonStr(String str) {
        UserTotalSportData userTotalSportData = (UserTotalSportData) Utils.c().a(str, UserTotalSportData.class);
        return userTotalSportData == null ? new UserTotalSportData() : userTotalSportData;
    }

    public void clear() {
    }

    public int getDistance() {
        return this.iDistance;
    }

    public ReportData getReportData() {
        return this.reportData;
    }

    public ReportData getWeekReportData() {
        return this.weekReportData;
    }

    public boolean isValid() {
        return this.iAverageSteps > 0 && this.iDistance > 0 && this.iTotalwearingdays > 0 && this.weekReportData != null;
    }

    public void setReportData(ReportData reportData) {
        this.reportData = reportData;
    }

    public void setWeekReportData(ReportData reportData) {
        this.weekReportData = reportData;
    }

    public String toString() {
        String b = Utils.c().b((Object) this);
        return b == null ? null : b.toString();
    }
}
