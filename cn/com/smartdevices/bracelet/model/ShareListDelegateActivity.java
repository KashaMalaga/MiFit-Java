package cn.com.smartdevices.bracelet.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.eventbus.EventUseManualLazyDay;
import cn.com.smartdevices.bracelet.g.e;
import cn.com.smartdevices.bracelet.g.h;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.lab.sync.l;
import cn.com.smartdevices.bracelet.model.ShareData.TimeType;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import cn.com.smartdevices.bracelet.ui.ShareActivity;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ShareListDelegateActivity extends Activity {
    public static final String REF_REPORT_DATA = "REF_REPORT_DATA";
    public static final String SHARE_TYPE_CONTIUE_REACH_GOAL = "SHARE_TYPE_CONTIUE_REACH_GOAL";
    public static final String SHARE_TYPE_CONTIUE_REACH_GOAL_MANUAL = "SHARE_TYPE_CONTIUE_REACH_GOAL_MANUAL";
    public static final String SHARE_TYPE_LAST_MONTH = "SHARE_TYPE_LAST_MONTH";
    public static final String SHARE_TYPE_LAST_WEEK = "SHARE_TYPE_LAST_WEEK";
    public static final String SHARE_TYPE_MAIN_UI_SHARE = "SHARE_TYPE_MAIN_UI_SHARE";
    public static final String SHARE_TYPE_NEW_RECORD = "SHARE_TYPE_NEW_RECORD";
    private static final String TAG = "ShareListDelegateActivity";
    private int mNewRecordSteps;
    private ReportData mReportData;
    private String mShareType;

    private SportDay getSportDayFromDateStr(String str) {
        SportDay sportDay;
        String[] split = str.split("-");
        try {
            sportDay = new SportDay(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue() - 1, Integer.valueOf(split[2]).intValue());
        } catch (Exception e) {
            e.printStackTrace();
            sportDay = null;
        }
        if (sportDay != null) {
            return sportDay;
        }
        sportDay = new SportDay(Calendar.getInstance());
        C0401a.b(this, "(ShareListDelegateActivity) Wrong sportday format: " + str);
        return sportDay;
    }

    protected void onCreate(Bundle bundle) {
        SportDay sportDayFromDateStr;
        SportDay sportDayFromDateStr2;
        ShareData shareData;
        Date date;
        int i;
        String[] a;
        String str;
        int continueDays;
        DaySportData g;
        StepsInfo stepsInfo;
        Bundle bundle2;
        SportDay sportDay = null;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str2 = a.f;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(REF_REPORT_DATA);
            if (stringExtra != null) {
                this.mReportData = ReportData.fromJsonStr(stringExtra);
                if (this.mReportData == null) {
                    finish();
                    return;
                }
                C0596r.e(TAG, "mReportData = " + this.mReportData.toString());
                this.mShareType = this.mReportData.type;
                if (SHARE_TYPE_LAST_WEEK.equals(this.mShareType) || SHARE_TYPE_LAST_MONTH.equals(this.mShareType)) {
                    sportDayFromDateStr = getSportDayFromDateStr(this.mReportData.timeFrom);
                    sportDayFromDateStr2 = getSportDayFromDateStr(this.mReportData.timeTo);
                    SportDay sportDayFromDateStr3 = getSportDayFromDateStr(this.mReportData.maxDateStr);
                    String str3 = a.f;
                    if (sportDayFromDateStr3 != null) {
                        str3 = Utils.d(sportDayFromDateStr3);
                    }
                    str2 = str3;
                    sportDay = sportDayFromDateStr2;
                    sportDayFromDateStr2 = sportDayFromDateStr;
                    shareData = new ShareData();
                    sportDayFromDateStr = new SportDay();
                    if (!SHARE_TYPE_LAST_MONTH.equals(this.mShareType)) {
                        date = new Date();
                        date.setMonth(sportDayFromDateStr2.mon);
                        shareData.title = getString(r.in) + new SimpleDateFormat(getString(r.date_month)).format(date) + getString(r.share_step_walk);
                        shareData.setType(6);
                        shareData.description = Utils.a((Context) this, this.mReportData.steps, this.mReportData.distance, this.mReportData.calories, str2, this.mReportData.maxDateStep, this.mReportData.runDistance);
                        i = this.mReportData.steps;
                        shareData.contentUnit = getString(r.unit_step);
                        shareData.time = Utils.n();
                        shareData.ranking = new e().a((Context) this, i);
                        shareData.mExtraData = Utils.a(this.mNewRecordSteps, new SportDay(), TimeType.MONTH.ordinal());
                    } else if (!SHARE_TYPE_LAST_WEEK.equals(this.mShareType)) {
                        shareData.title = getString(r.one_week) + getString(r.share_step_walk);
                        shareData.setType(7);
                        shareData.description = Utils.a(this, this.mReportData.distance, this.mReportData.calories, str2, this.mReportData.maxDateStep, this.mReportData.runDistance);
                        i = this.mReportData.steps;
                        shareData.contentUnit = getString(r.unit_step);
                        shareData.time = Utils.o();
                        shareData.ranking = new h().a((Context) this, i);
                        shareData.mExtraData = Utils.a(this.mNewRecordSteps, new SportDay(), TimeType.WEEK.ordinal());
                    } else if (!SHARE_TYPE_NEW_RECORD.equals(this.mShareType)) {
                        shareData.setType(5);
                        shareData.title = getString(r.new_record_born);
                        i = this.mNewRecordSteps;
                        shareData.contentUnit = getString(r.unit_step);
                        sportDayFromDateStr2 = new SportDay();
                        shareData.time = Utils.c(sportDayFromDateStr2);
                        a = ChartData.a((Context) this, this.mReportData.getDistance());
                        str = a[0] + a[1];
                        str2 = a.f + this.mReportData.getCalories();
                        shareData.description = getString(r.new_record_format_str, new Object[]{str, str2});
                        shareData.mExtraData = Utils.a(this.mNewRecordSteps, sportDayFromDateStr2);
                    } else if (!SHARE_TYPE_CONTIUE_REACH_GOAL_MANUAL.equals(this.mShareType)) {
                        EventBus.getDefault().post(new EventUseManualLazyDay());
                        finish();
                        return;
                    } else if (SHARE_TYPE_CONTIUE_REACH_GOAL.equals(this.mShareType)) {
                        C0596r.e(TAG, "Continue status = " + this.mReportData.getContinueStatus());
                        if (this.mReportData.getContinueDays() > this.mReportData.getMaxContinueDays()) {
                            shareData.setType(10);
                            shareData.title = getString(r.continue_reach_goal_new_record);
                        } else {
                            shareData.setType(8);
                            shareData.title = getString(r.continue_reach_goal);
                        }
                        continueDays = this.mReportData.getContinueDays();
                        shareData.contentUnit = getString(r.day);
                        shareData.time = getString(r.until_hit_goals, new Object[]{Utils.d(sportDay)});
                        shareData.time_tips = a.f;
                        shareData.description = Utils.a((Context) this, this.mReportData);
                        i = continueDays;
                    } else {
                        if (SHARE_TYPE_MAIN_UI_SHARE.equals(this.mShareType)) {
                            sportDayFromDateStr = C0591m.a().m();
                            g = C0591m.a().g(sportDayFromDateStr);
                            if (g == null) {
                                C0596r.e(TAG, "cur day is null");
                                g = new DaySportData(Calendar.getInstance());
                            }
                            stepsInfo = g.getStepsInfo();
                            if (stepsInfo == null) {
                                stepsInfo = new StepsInfo();
                            }
                            bundle2 = new Bundle();
                            bundle2.putInt(f.ax, TimeType.DAY.ordinal());
                            bundle2.putInt(l.c, 0);
                            bundle2.putInt(f.aw, stepsInfo.getStepsCount());
                            bundle2.putString(g.a, sportDayFromDateStr.toString());
                            shareData.mExtraData = bundle2;
                            Utils.a((Context) this, g, shareData);
                            C0596r.e(TAG, "picture = " + this.mReportData.picture_url);
                            intent.putExtra(kankan.wheel.widget.a.ca, this.mReportData.picture_url);
                        }
                        i = 0;
                    }
                    shareData.content = a.f + i;
                    intent.setClass(this, ShareActivity.class);
                    intent.putExtra("share_data", shareData);
                    startActivity(intent);
                    C0401a.a((Context) this, C0401a.aZ, C0401a.cv);
                    finish();
                }
                if (SHARE_TYPE_NEW_RECORD.equals(this.mShareType)) {
                    this.mNewRecordSteps = this.mReportData.getSteps();
                    sportDayFromDateStr2 = null;
                } else if (SHARE_TYPE_CONTIUE_REACH_GOAL.equals(this.mShareType)) {
                    sportDayFromDateStr2 = getSportDayFromDateStr(this.mReportData.timeFrom);
                    sportDay = getSportDayFromDateStr(this.mReportData.timeTo);
                }
                shareData = new ShareData();
                sportDayFromDateStr = new SportDay();
                if (!SHARE_TYPE_LAST_MONTH.equals(this.mShareType)) {
                    date = new Date();
                    date.setMonth(sportDayFromDateStr2.mon);
                    shareData.title = getString(r.in) + new SimpleDateFormat(getString(r.date_month)).format(date) + getString(r.share_step_walk);
                    shareData.setType(6);
                    shareData.description = Utils.a((Context) this, this.mReportData.steps, this.mReportData.distance, this.mReportData.calories, str2, this.mReportData.maxDateStep, this.mReportData.runDistance);
                    i = this.mReportData.steps;
                    shareData.contentUnit = getString(r.unit_step);
                    shareData.time = Utils.n();
                    shareData.ranking = new e().a((Context) this, i);
                    shareData.mExtraData = Utils.a(this.mNewRecordSteps, new SportDay(), TimeType.MONTH.ordinal());
                } else if (!SHARE_TYPE_LAST_WEEK.equals(this.mShareType)) {
                    shareData.title = getString(r.one_week) + getString(r.share_step_walk);
                    shareData.setType(7);
                    shareData.description = Utils.a(this, this.mReportData.distance, this.mReportData.calories, str2, this.mReportData.maxDateStep, this.mReportData.runDistance);
                    i = this.mReportData.steps;
                    shareData.contentUnit = getString(r.unit_step);
                    shareData.time = Utils.o();
                    shareData.ranking = new h().a((Context) this, i);
                    shareData.mExtraData = Utils.a(this.mNewRecordSteps, new SportDay(), TimeType.WEEK.ordinal());
                } else if (!SHARE_TYPE_NEW_RECORD.equals(this.mShareType)) {
                    shareData.setType(5);
                    shareData.title = getString(r.new_record_born);
                    i = this.mNewRecordSteps;
                    shareData.contentUnit = getString(r.unit_step);
                    sportDayFromDateStr2 = new SportDay();
                    shareData.time = Utils.c(sportDayFromDateStr2);
                    a = ChartData.a((Context) this, this.mReportData.getDistance());
                    str = a[0] + a[1];
                    str2 = a.f + this.mReportData.getCalories();
                    shareData.description = getString(r.new_record_format_str, new Object[]{str, str2});
                    shareData.mExtraData = Utils.a(this.mNewRecordSteps, sportDayFromDateStr2);
                } else if (!SHARE_TYPE_CONTIUE_REACH_GOAL_MANUAL.equals(this.mShareType)) {
                    EventBus.getDefault().post(new EventUseManualLazyDay());
                    finish();
                    return;
                } else if (SHARE_TYPE_CONTIUE_REACH_GOAL.equals(this.mShareType)) {
                    if (SHARE_TYPE_MAIN_UI_SHARE.equals(this.mShareType)) {
                        sportDayFromDateStr = C0591m.a().m();
                        g = C0591m.a().g(sportDayFromDateStr);
                        if (g == null) {
                            C0596r.e(TAG, "cur day is null");
                            g = new DaySportData(Calendar.getInstance());
                        }
                        stepsInfo = g.getStepsInfo();
                        if (stepsInfo == null) {
                            stepsInfo = new StepsInfo();
                        }
                        bundle2 = new Bundle();
                        bundle2.putInt(f.ax, TimeType.DAY.ordinal());
                        bundle2.putInt(l.c, 0);
                        bundle2.putInt(f.aw, stepsInfo.getStepsCount());
                        bundle2.putString(g.a, sportDayFromDateStr.toString());
                        shareData.mExtraData = bundle2;
                        Utils.a((Context) this, g, shareData);
                        C0596r.e(TAG, "picture = " + this.mReportData.picture_url);
                        intent.putExtra(kankan.wheel.widget.a.ca, this.mReportData.picture_url);
                    }
                    i = 0;
                } else {
                    C0596r.e(TAG, "Continue status = " + this.mReportData.getContinueStatus());
                    if (this.mReportData.getContinueDays() > this.mReportData.getMaxContinueDays()) {
                        shareData.setType(8);
                        shareData.title = getString(r.continue_reach_goal);
                    } else {
                        shareData.setType(10);
                        shareData.title = getString(r.continue_reach_goal_new_record);
                    }
                    continueDays = this.mReportData.getContinueDays();
                    shareData.contentUnit = getString(r.day);
                    shareData.time = getString(r.until_hit_goals, new Object[]{Utils.d(sportDay)});
                    shareData.time_tips = a.f;
                    shareData.description = Utils.a((Context) this, this.mReportData);
                    i = continueDays;
                }
                shareData.content = a.f + i;
                intent.setClass(this, ShareActivity.class);
                intent.putExtra("share_data", shareData);
                startActivity(intent);
                C0401a.a((Context) this, C0401a.aZ, C0401a.cv);
                finish();
            }
            C0596r.e(TAG, "intent of mReportData is null");
            finish();
            return;
        }
        sportDayFromDateStr2 = null;
        shareData = new ShareData();
        sportDayFromDateStr = new SportDay();
        if (!SHARE_TYPE_LAST_MONTH.equals(this.mShareType)) {
            date = new Date();
            date.setMonth(sportDayFromDateStr2.mon);
            shareData.title = getString(r.in) + new SimpleDateFormat(getString(r.date_month)).format(date) + getString(r.share_step_walk);
            shareData.setType(6);
            shareData.description = Utils.a((Context) this, this.mReportData.steps, this.mReportData.distance, this.mReportData.calories, str2, this.mReportData.maxDateStep, this.mReportData.runDistance);
            i = this.mReportData.steps;
            shareData.contentUnit = getString(r.unit_step);
            shareData.time = Utils.n();
            shareData.ranking = new e().a((Context) this, i);
            shareData.mExtraData = Utils.a(this.mNewRecordSteps, new SportDay(), TimeType.MONTH.ordinal());
        } else if (!SHARE_TYPE_LAST_WEEK.equals(this.mShareType)) {
            shareData.title = getString(r.one_week) + getString(r.share_step_walk);
            shareData.setType(7);
            shareData.description = Utils.a(this, this.mReportData.distance, this.mReportData.calories, str2, this.mReportData.maxDateStep, this.mReportData.runDistance);
            i = this.mReportData.steps;
            shareData.contentUnit = getString(r.unit_step);
            shareData.time = Utils.o();
            shareData.ranking = new h().a((Context) this, i);
            shareData.mExtraData = Utils.a(this.mNewRecordSteps, new SportDay(), TimeType.WEEK.ordinal());
        } else if (!SHARE_TYPE_NEW_RECORD.equals(this.mShareType)) {
            shareData.setType(5);
            shareData.title = getString(r.new_record_born);
            i = this.mNewRecordSteps;
            shareData.contentUnit = getString(r.unit_step);
            sportDayFromDateStr2 = new SportDay();
            shareData.time = Utils.c(sportDayFromDateStr2);
            a = ChartData.a((Context) this, this.mReportData.getDistance());
            str = a[0] + a[1];
            str2 = a.f + this.mReportData.getCalories();
            shareData.description = getString(r.new_record_format_str, new Object[]{str, str2});
            shareData.mExtraData = Utils.a(this.mNewRecordSteps, sportDayFromDateStr2);
        } else if (!SHARE_TYPE_CONTIUE_REACH_GOAL_MANUAL.equals(this.mShareType)) {
            EventBus.getDefault().post(new EventUseManualLazyDay());
            finish();
            return;
        } else if (SHARE_TYPE_CONTIUE_REACH_GOAL.equals(this.mShareType)) {
            C0596r.e(TAG, "Continue status = " + this.mReportData.getContinueStatus());
            if (this.mReportData.getContinueDays() > this.mReportData.getMaxContinueDays()) {
                shareData.setType(10);
                shareData.title = getString(r.continue_reach_goal_new_record);
            } else {
                shareData.setType(8);
                shareData.title = getString(r.continue_reach_goal);
            }
            continueDays = this.mReportData.getContinueDays();
            shareData.contentUnit = getString(r.day);
            shareData.time = getString(r.until_hit_goals, new Object[]{Utils.d(sportDay)});
            shareData.time_tips = a.f;
            shareData.description = Utils.a((Context) this, this.mReportData);
            i = continueDays;
        } else {
            if (SHARE_TYPE_MAIN_UI_SHARE.equals(this.mShareType)) {
                sportDayFromDateStr = C0591m.a().m();
                g = C0591m.a().g(sportDayFromDateStr);
                if (g == null) {
                    C0596r.e(TAG, "cur day is null");
                    g = new DaySportData(Calendar.getInstance());
                }
                stepsInfo = g.getStepsInfo();
                if (stepsInfo == null) {
                    stepsInfo = new StepsInfo();
                }
                bundle2 = new Bundle();
                bundle2.putInt(f.ax, TimeType.DAY.ordinal());
                bundle2.putInt(l.c, 0);
                bundle2.putInt(f.aw, stepsInfo.getStepsCount());
                bundle2.putString(g.a, sportDayFromDateStr.toString());
                shareData.mExtraData = bundle2;
                Utils.a((Context) this, g, shareData);
                C0596r.e(TAG, "picture = " + this.mReportData.picture_url);
                intent.putExtra(kankan.wheel.widget.a.ca, this.mReportData.picture_url);
            }
            i = 0;
        }
        shareData.content = a.f + i;
        intent.setClass(this, ShareActivity.class);
        intent.putExtra("share_data", shareData);
        startActivity(intent);
        C0401a.a((Context) this, C0401a.aZ, C0401a.cv);
        finish();
    }
}
