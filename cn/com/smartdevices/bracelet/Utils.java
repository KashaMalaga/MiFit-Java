package cn.com.smartdevices.bracelet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.DialogFragment;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.support.v4.view.a.C0113o;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.activity.WebActivity;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.d.C0425b;
import cn.com.smartdevices.bracelet.d.C0432i;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.eventbus.EventApkupgrade;
import cn.com.smartdevices.bracelet.g.d;
import cn.com.smartdevices.bracelet.gps.h.h;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.location.Location;
import cn.com.smartdevices.bracelet.location.Location.Address;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.ShareData.TimeType;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import cn.com.smartdevices.bracelet.partner.Partner;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import cn.com.smartdevices.bracelet.ui.C0766do;
import cn.com.smartdevices.bracelet.ui.C0810j;
import cn.com.smartdevices.bracelet.view.O;
import cn.com.smartdevices.bracelet.weight.C0873k;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.ah;
import cn.com.smartdevices.bracelet.weight.goal.WeightGoal;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.c.a.C0993k;
import com.d.a.a.C1012a;
import com.huami.android.view.c;
import com.huami.android.widget.share.m;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.tencent.connect.common.Constants;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;
import com.xiaomi.hm.health.bt.model.BraceletBtInfo;
import com.xiaomi.hm.health.bt.model.UserInfo;
import com.xiaomi.hm.health.bt.profile.a.i;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.DaySportData.Summary;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportData;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.r;
import com.xiaomi.market.sdk.C1123b;
import com.xiaomi.mipush.sdk.f;
import de.greenrobot.event.EventBus;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils {
    public static final String a = "REF_DEVICE_TYPE";
    public static final String b = "TYPE_BAND";
    public static final String c = "TYPE_WEIGHT";
    public static final String d = "TYPE_WEIGHT_PAIR";
    public static final String e = "TYPE_UNLOCK_SCREEN";
    public static final String f = "0";
    public static final String g = "CHANGE_LOG";
    public static final String h = "VERSION_NAME";
    public static final String i = "APK_PATH";
    public static final boolean j = true;
    public static final boolean k = true;
    private static final String l = "Utils";
    private static C0993k m = null;
    private static final String[] n = new String[]{"MI 2", "MI 2S"};
    private static final String[] o = new String[]{"jt>", "aku", "blv", "cmw", "dnx", "eoy", "fpz", "gq!", "hr(", "is)"};
    private static final String p = "Millelet";
    private static long q = System.currentTimeMillis();
    private static int[] r = new int[]{Color.parseColor("#1094bf"), Color.parseColor("#575fbe"), Color.parseColor("#bc58b1"), Color.parseColor("#ff5b45"), Color.parseColor("#e98d25"), Color.parseColor("#7ea800")};

    private Utils() {
    }

    public static String A(Context context) {
        Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(height).append("x").append(width);
        return stringBuffer.toString();
    }

    public static void B(Context context) {
        int activeHistory = Keeper.getActiveHistory();
        if (context != null && Keeper.getActiveHistory() != 0) {
            LoginData f = a.f(context);
            if (f.isValid()) {
                l.a(context, f, 2, new T(activeHistory));
                Keeper.setActiveHistory(0);
                return;
            }
            C0596r.d(l, "postActiveHistory loginData not valid,return.");
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean C(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure();
    }

    private static boolean D(Context context) {
        int i;
        SettingNotFoundException e;
        try {
            i = Secure.getInt(context.getContentResolver(), "bluetooth_unlock_status");
            try {
                C0596r.e(l, "isUseUnlock:" + i + ", unlockAddress:" + Secure.getString(context.getContentResolver(), "bluetooth_address_to_unlock"));
            } catch (SettingNotFoundException e2) {
                e = e2;
                e.printStackTrace();
                return i == 1 ? false : k;
            }
        } catch (SettingNotFoundException e3) {
            e = e3;
            i = 0;
            e.printStackTrace();
            if (i == 1) {
            }
        }
        if (i == 1) {
        }
    }

    public static double a(float f) {
        return 3.28d * ((double) f);
    }

    public static int a(float f, Context context) {
        return (int) (((double) (context.getResources().getDisplayMetrics().scaledDensity * f)) + 0.5d);
    }

    public static int a(int i) {
        return (int) Math.round(0.394d * ((double) i));
    }

    public static int a(Context context, float f) {
        return (int) (0.5f + (context.getResources().getDisplayMetrics().density * f));
    }

    public static int a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int round = Math.round(((float) i3) / ((float) i2));
        i3 = Math.round(((float) i4) / ((float) i));
        return round > i3 ? round : i3;
    }

    public static int a(Summary summary) {
        int b = b(summary.getSleepStartTime());
        return b > 720 ? b - 1440 : b;
    }

    public static int a(Calendar calendar) {
        return (calendar.get(1) * 365) + calendar.get(6);
    }

    public static int a(byte[] bArr) {
        return ((((bArr[1059] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[1058] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[1057] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | (bArr[1056] & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static Bitmap a(String str, int i, int i2) {
        Bitmap bitmap = null;
        Options options = new Options();
        options.inJustDecodeBounds = k;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i, i2);
        options.inJustDecodeBounds = false;
        try {
            bitmap = BitmapFactory.decodeFile(str, options);
        } catch (Exception e) {
        }
        C0596r.e("WPJ", "createImageSafely:" + bitmap.getWidth() + f.i + bitmap.getHeight() + "==" + options.inSampleSize);
        return bitmap;
    }

    public static Bitmap a(byte[] bArr, int i, int i2) {
        int i3 = 1;
        Options options = new Options();
        options.inJustDecodeBounds = k;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        options.inPreferredConfig = Config.RGB_565;
        if (i4 > i2) {
            i3 = Math.round(((float) i4) / ((float) i2));
        }
        if (i5 / i3 > i) {
            i3 = Math.round(((float) i5) / ((float) i));
        }
        options.inSampleSize = i3;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bundle a(int i, SportDay sportDay) {
        return a(i, sportDay, TimeType.DAY.ordinal());
    }

    public static Bundle a(int i, SportDay sportDay, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(cn.com.smartdevices.bracelet.j.f.ax, i2);
        bundle.putInt(cn.com.smartdevices.bracelet.lab.sync.l.c, 0);
        bundle.putInt(cn.com.smartdevices.bracelet.j.f.aw, i);
        bundle.putString(g.a, sportDay.toString());
        return bundle;
    }

    public static ShareData a(Context context, int i, int i2, int i3, int i4, SportDay sportDay, ShareData shareData) {
        int daySportGoalSteps = Keeper.readPersonInfo().getDaySportGoalSteps();
        String[] a = ChartData.a(context, i2);
        String str = a[0] + a[1];
        if (i3 > 0) {
            a = ChartData.a(context, i2 - i3);
            str = a[0] + a[1];
            String[] a2 = ChartData.a(context, i3);
            str = context.getString(r.share_step_description_run, new Object[]{str, a2[0] + a2[1], Integer.valueOf(i4)});
        } else {
            str = context.getString(r.share_step_description, new Object[]{str, Integer.valueOf(i4)});
        }
        if (daySportGoalSteps > i) {
            shareData.setType(1);
            shareData.title = context.getString(r.share_step_goal_failed_title);
            str = str + context.getString(r.share_goal_tips_fail);
        } else {
            shareData.setType(0);
            shareData.title = context.getString(r.share_step_goal_succ_title);
            str = str + context.getString(r.share_goal_tips_succ);
        }
        shareData.content = com.xiaomi.e.a.f + i;
        shareData.description = str;
        shareData.contentUnit = context.getString(r.unit_step);
        shareData.mExtraData = a(i, sportDay);
        return shareData;
    }

    public static UserInfo a(PersonInfo personInfo) {
        int i = 10;
        Object bytes = personInfo.nickname.getBytes();
        if (bytes.length <= 10) {
            i = bytes.length;
        }
        Object obj = new byte[i];
        System.arraycopy(bytes, 0, obj, 0, i);
        return new UserInfo((int) personInfo.uid, (byte) personInfo.gender, (byte) personInfo.age, (byte) personInfo.height, (byte) ((int) personInfo.weight), obj);
    }

    public static String a(Context context) {
        return j(context) + "/MiBand_" + Calendar.getInstance().getTimeInMillis() + "_" + kankan.wheel.widget.a.cb;
    }

    public static String a(Context context, double d) {
        C0596r.e(l, "get ranking percent : " + d);
        Resources resources = context.getResources();
        if (d == 0.0d) {
            return Html.fromHtml(resources.getString(r.sport_ranking_desc_poor, new Object[]{com.xiaomi.e.a.f})).toString();
        } else if (d >= 99.99d) {
            return Html.fromHtml(resources.getString(r.sport_ranking_desc_great)).toString();
        } else {
            String str = com.xiaomi.e.a.f;
            str = d <= 99.0d ? h.b(d, 1) : h.b(d, 2);
            return resources.getString(r.share_step_ranking, new Object[]{str + resources.getString(r.percent_mark)});
        }
    }

    public static String a(Context context, int i) {
        if (!a(Keeper.readSyncTime(C0591m.a().r()))) {
            return context.getString(r.dynamic_pull_not_sync_today);
        }
        return context.getString(i, new Object[]{cn.com.smartdevices.bracelet.f.f.a(new Date(Keeper.readSyncTime(C0591m.a().r())))});
    }

    public static String a(Context context, int i, int i2) {
        if (!a(Keeper.readSyncTime(i2))) {
            return context.getString(r.dynamic_pull_not_sync_today);
        }
        return context.getString(i, new Object[]{cn.com.smartdevices.bracelet.f.f.a(new Date(Keeper.readSyncTime(i2)))});
    }

    public static String a(Context context, int i, int i2, int i3, String str, int i4, int i5) {
        String str2 = com.xiaomi.e.a.f;
        String[] a = ChartData.a(context, i2);
        str2 = a[0] + a[1];
        String b = b(i2);
        String e = e(context, i2);
        if (i5 > 0) {
            a = ChartData.a(context, i5);
            str2 = a[0] + a[1];
            String[] a2 = ChartData.a(context, i2 - i5);
            return context.getString(r.share_step_description_monthly_run, new Object[]{a2[0] + a2[1], str2, e, b, str, i4 + com.xiaomi.e.a.f});
        }
        return context.getString(r.share_step_description_monthly, new Object[]{str2, e, Integer.valueOf(i3), b, str, i4 + com.xiaomi.e.a.f});
    }

    public static String a(Context context, int i, int i2, String str, int i3, int i4) {
        String[] a = ChartData.a(context, i);
        String str2 = a[0] + a[1];
        Object e = e(context, i);
        String str3 = com.xiaomi.e.a.f;
        if (i4 <= 0) {
            if (!TextUtils.isEmpty(e)) {
                e = ", " + e;
            }
            return context.getString(r.share_step_description_weekly, new Object[]{str2, e, Integer.valueOf(i2), str, i3 + com.xiaomi.e.a.f});
        }
        String[] a2 = ChartData.a(context, i - i4);
        str2 = a2[0] + a2[1];
        String[] a3 = ChartData.a(context, i4);
        str3 = a3[0] + a3[1];
        return context.getString(r.share_step_description_weekly_run, new Object[]{str2, str3, e, str, i3 + com.xiaomi.e.a.f});
    }

    public static String a(Context context, ReportData reportData) {
        int steps = reportData.getSteps();
        int distance = reportData.getDistance();
        int continueDays = reportData.getContinueDays();
        int runDistance = reportData.getRunDistance();
        String e = e(context, distance);
        String str = (steps / continueDays) + com.xiaomi.e.a.f;
        String[] stringArray = context.getResources().getStringArray(com.xiaomi.hm.health.f.fortune);
        String str2 = com.xiaomi.e.a.f;
        int length = stringArray.length;
        if (length >= 0) {
            str2 = stringArray[Calendar.getInstance().get(6) % length];
        }
        stringArray = ChartData.a(context, distance);
        String str3 = stringArray[0] + stringArray[1];
        if (runDistance <= 0) {
            return context.getString(r.share_continue_goal_format, new Object[]{str3, str, e, str2});
        }
        String[] a = ChartData.a(context, runDistance);
        str = a[0] + a[1];
        String[] a2 = ChartData.a(context, distance - runDistance);
        return context.getString(r.share_continue_goal_format_run, new Object[]{a2[0] + a2[1], str, e, str2});
    }

    public static String a(Context context, AlarmClockItem alarmClockItem) {
        StringBuilder stringBuilder = new StringBuilder();
        int days = alarmClockItem.getDays();
        if (days == AlarmClockItem.ALARM_ONCE) {
            return context.getString(r.alarm_once);
        }
        if (days == AlarmClockItem.ALARM_EVERY_DAY) {
            return context.getString(r.everyday);
        }
        if (days == AlarmClockItem.ALARM_MON_2_FRI) {
            return context.getString(r.mon_fri);
        }
        if (days == AlarmClockItem.ALARM_MON_2_SAT) {
            return context.getString(r.mon_sat);
        }
        int i = 0;
        for (int i2 = days; i2 > 0; i2 >>= 1) {
            if ((i2 & 1) == 1) {
                i++;
            }
        }
        String[] stringArray = context.getResources().getStringArray(com.xiaomi.hm.health.f.weeks_short);
        String[] stringArray2 = context.getResources().getStringArray(com.xiaomi.hm.health.f.weeks);
        if (i <= 1) {
            stringArray = stringArray2;
        }
        int i3 = i;
        for (int i4 = 0; i4 < 7; i4++) {
            if (((1 << i4) & days) != 0) {
                stringBuilder.append(stringArray[i4]);
                i3--;
                if (i3 > 0) {
                    stringBuilder.append(" ");
                }
            }
        }
        if (stringBuilder.length() > 0 && i > 1) {
            stringBuilder.insert(0, context.getResources().getString(r.week));
        }
        return stringBuilder.toString();
    }

    public static String a(Context context, String str) {
        String str2 = com.xiaomi.e.a.f;
        try {
            Class loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod("get", new Class[]{String.class}).invoke(loadClass, new Object[]{str});
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e2) {
            return com.xiaomi.e.a.f;
        }
    }

    public static String a(Bitmap bitmap) {
        return a(bitmap, 100);
    }

    public static String a(Bitmap bitmap, int i) {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tmp.jpg";
        a(str, bitmap, i);
        return str;
    }

    public static String a(View view, Context context) {
        String a = a(context);
        view.buildDrawingCache();
        return a(a, view.getDrawingCache(), 85) ? a : com.xiaomi.e.a.f;
    }

    public static String a(AlarmClockItem alarmClockItem) {
        return a(alarmClockItem, false);
    }

    public static String a(AlarmClockItem alarmClockItem, boolean z) {
        int i = 12;
        int i2 = alarmClockItem.getCalendar().get(11);
        int i3 = alarmClockItem.getCalendar().get(12);
        if (z) {
            i = i2;
        } else {
            i2 = alarmClockItem.getCalendar().get(10);
            if (i2 != 0) {
                i = i2;
            }
        }
        return (i < 10 ? f + i : Integer.valueOf(i)) + kankan.wheel.widget.a.ci + (i3 < 10 ? f + i3 : Integer.valueOf(i3));
    }

    public static String a(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date parse = simpleDateFormat.parse(str);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str3, Locale.getDefault());
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat2.format(Long.valueOf(parse.getTime()));
        } catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<String> a(SportDay sportDay) {
        ArrayList arrayList;
        ArrayList<String> d = d();
        if (d == null) {
            arrayList = new ArrayList();
        } else {
            ArrayList<String> arrayList2 = d;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (sportDay.toString().equals((String) it.next())) {
                break;
            }
        }
        arrayList.add(sportDay.toString());
        c(arrayList);
        return arrayList;
    }

    public static ArrayList<SportData> a(ArrayList<SportData> arrayList) {
        ArrayList<SportData> arrayList2 = new ArrayList(arrayList.size());
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((SportData) it.next()).copy());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            arrayList2.clear();
        }
        return arrayList2;
    }

    public static void a(Activity activity) {
        if (activity != null) {
            try {
                DialogFragment dialogFragment = (DialogFragment) activity.getFragmentManager().findFragmentByTag(C0766do.class.getName());
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
            } catch (Exception e) {
            }
        }
    }

    public static void a(Activity activity, int i) {
        a(activity, i, (boolean) k);
    }

    public static void a(Activity activity, int i, boolean z) {
        if (activity != null) {
            a(activity);
            try {
                Bundle bundle = new Bundle();
                bundle.putString(kankan.wheel.widget.a.bA, activity.getString(i));
                bundle.putBoolean(kankan.wheel.widget.a.bB, z);
                c.showPanel(activity, C0766do.class, bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Activity activity, boolean z) {
        l.a(a.f(activity), b.b(), new U(z, activity));
    }

    public static void a(Context context, Bundle bundle, d dVar) {
        if (bundle == null) {
            bundle = new Bundle();
            bundle.putInt(cn.com.smartdevices.bracelet.j.f.ax, TimeType.DAY.ordinal());
            bundle.putString(g.a, new SportDay().toString());
        }
        if (bundle != null) {
            int i = -1;
            if (bundle.containsKey(cn.com.smartdevices.bracelet.j.f.ax)) {
                i = bundle.getInt(cn.com.smartdevices.bracelet.j.f.ax);
            }
            if (i == TimeType.DAY.ordinal()) {
                Object a = C0425b.a(context.getApplicationContext()).a(cn.com.smartdevices.bracelet.f.b.a, (boolean) k);
                if (!TextUtils.isEmpty(a)) {
                    try {
                        JSONObject jSONObject = new JSONObject(a);
                        String string = jSONObject.getString(g.a);
                        String string2 = bundle.getString(g.a);
                        int i2 = jSONObject.getInt(cn.com.smartdevices.bracelet.j.f.aw);
                        int i3 = bundle.getInt(cn.com.smartdevices.bracelet.j.f.aw);
                        int i4 = jSONObject.getInt(cn.com.smartdevices.bracelet.j.f.ax);
                        if (string != null && string.equals(string2) && i2 / 100 == i3 / 100 && i4 == i) {
                            dVar.a(Double.valueOf(jSONObject.getString(C0432i.b)).doubleValue());
                            return;
                        }
                    } catch (JSONException e) {
                        C0596r.d(l, "rank:" + e.getMessage());
                    }
                }
                b(context, bundle, dVar);
            }
        }
    }

    public static void a(Context context, d dVar) {
        a(context, null, dVar);
    }

    public static void a(Context context, Location location) {
        C0596r.e(l, "Location : " + location.b() + "  " + location.a());
        Address c = location.c();
        if (c != null) {
            C0596r.e(l, "cityCode : " + c.i() + ", countryCode: " + c.b());
            String i = c.i();
            Object obj = null;
            if (!(TextUtils.isEmpty(i) || i.equals(Keeper.readCityCode()))) {
                Keeper.keepCityCode(i);
                obj = 1;
            }
            String b = c.b();
            if (!(TextUtils.isEmpty(b) || b.equals(Keeper.readCountryCode()))) {
                Keeper.keepCountryCode(b);
                obj = 1;
            }
            if (obj != null) {
                a(context, Keeper.readPersonInfo());
            }
        }
    }

    public static void a(Context context, PersonInfo personInfo) {
        if (personInfo.isValid()) {
            l.a(a.f(context), personInfo, new Z(personInfo, context));
        } else {
            C0596r.e(l, "personInfo is inValid!");
        }
    }

    public static void a(Context context, PersonInfo personInfo, HashMap<String, String> hashMap, ag agVar) {
        l.a(a.f(context), (HashMap) hashMap, new aa(agVar, context, personInfo));
    }

    public static void a(Context context, WeightGoal weightGoal, ae aeVar) {
        C0596r.e(l, "Keeper.readLoginData().uid " + a.f(context).uid);
        C0596r.e(l, "weight " + weightGoal.currentVal);
        C0596r.e(l, WidgetRequestParam.REQ_PARAM_ATTENTION_FUID + weightGoal.fuid);
        C0596r.e(l, "targetWeigt " + weightGoal.goal);
        C0596r.e(l, "height " + weightGoal.height);
        C0596r.e(l, "timestamp " + weightGoal.datetime);
        l.a(context, a.f(context).uid + com.xiaomi.e.a.f, weightGoal.fuid + com.xiaomi.e.a.f, 1, weightGoal.currentVal, weightGoal.goal, weightGoal.height, weightGoal.datetime, new O(aeVar, weightGoal));
    }

    public static void a(Context context, DaySportData daySportData, ShareData shareData) {
        if (daySportData != null && shareData != null) {
            int u = ChartData.a().u();
            String a;
            String str;
            String string;
            String string2;
            if (u == 1) {
                StepsInfo stepsInfo = daySportData.getStepsInfo();
                if (stepsInfo == null) {
                    stepsInfo = new StepsInfo();
                }
                a = cn.com.smartdevices.bracelet.f.f.a(context, stepsInfo.getStepsTimeCount() + stepsInfo.getRunTimeCount());
                str = com.xiaomi.e.a.f;
                if (stepsInfo.getRunTimeCount() > 0) {
                    str = ", " + context.getString(r.ran) + cn.com.smartdevices.bracelet.f.f.a(context, stepsInfo.getRunTimeCount());
                }
                string = context.getString(r.share_goal_tips_fail);
                shareData.setType(1);
                if (stepsInfo.getStepsCount() >= Keeper.readPersonInfo().getDaySportGoalSteps()) {
                    string2 = context.getString(r.share_goal_tips_succ);
                    shareData.setType(0);
                } else {
                    string2 = string;
                }
                shareData.description = context.getString(r.main_ui_share_tips, new Object[]{a, str, string2});
            } else if (u == 16) {
                SleepInfo sleepInfo = daySportData.getSleepInfo();
                if (sleepInfo == null) {
                    sleepInfo = new SleepInfo();
                }
                string = cn.com.smartdevices.bracelet.f.f.a(sleepInfo.getStartDateMin());
                a = cn.com.smartdevices.bracelet.f.f.a(sleepInfo.getStopDateMin());
                String a2 = cn.com.smartdevices.bracelet.f.f.a(context, sleepInfo.getRemCount());
                C0596r.e(l, "awake num = " + sleepInfo.getAwakeNum() + ", count = " + sleepInfo.getAwakeCount());
                str = com.xiaomi.e.a.f;
                int awakeNum = sleepInfo.getAwakeNum();
                if (awakeNum == 1) {
                    string2 = context.getString(r.awake_format_1);
                } else if (awakeNum > 1) {
                    string2 = context.getString(r.awake_format, new Object[]{Integer.valueOf(sleepInfo.getAwakeNum())});
                } else {
                    string2 = str;
                }
                shareData.description = context.getString(r.main_ui_sleep_share_tips, new Object[]{a2, string2, string, a});
            }
        }
    }

    public static void a(Context context, StepsInfo stepsInfo, ShareData shareData) {
        a(context, stepsInfo.getStepsCount(), stepsInfo.getDistance(), stepsInfo.getRunDistance(), stepsInfo.getCalories(), stepsInfo.getSportDay(), shareData);
    }

    public static void a(Context context, String str, long j, ac acVar) {
        C0596r.e(l, "Keeper.readLoginData().uid " + a.f(context).uid);
        C0596r.e(l, WidgetRequestParam.REQ_PARAM_ATTENTION_FUID + str);
        C0596r.e(l, "timestamp " + j);
        l.a(context, a.f(context).uid + com.xiaomi.e.a.f, str, 1, j, new P(acVar));
    }

    public static void a(Context context, String str, long j, ad adVar) {
        l.a(context, a.f(context).uid + com.xiaomi.e.a.f, str, 1, j + com.xiaomi.e.a.f, 1, new Q(context, adVar));
    }

    public static void a(Context context, String str, String str2, String str3, af afVar) {
        C0596r.e(l, "Keeper.readLoginData().uid " + a.f(context).uid);
        C0596r.e(l, WidgetRequestParam.REQ_PARAM_ATTENTION_FUID + str);
        C0596r.e(l, "stime " + str2);
        C0596r.e(l, "etime " + str3);
        l.a(context, a.f(context).uid + com.xiaomi.e.a.f, str, 1, str2, str3, new ab(context, afVar));
    }

    public static void a(TextView textView, SpannableString spannableString) {
        textView.setHighlightColor(0);
        textView.append(" ");
        textView.append(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setOnLongClickListener(new N());
    }

    @SuppressLint({"NewApi"})
    public static void a(PersonInfo personInfo, ImageView imageView) {
        Bitmap bitmap = null;
        if (!(personInfo.avatarPath == null || personInfo.avatarPath.equals(com.xiaomi.e.a.f))) {
            bitmap = C0544h.a().a(Uri.fromFile(new File(personInfo.avatarPath)).toString());
            C0596r.e(l, "path=" + personInfo.avatarPath + " avatarBitmap=" + bitmap);
            if (bitmap != null) {
                imageView.setBackground(new BitmapDrawable(O.a(bitmap)));
            }
        }
        if (bitmap == null) {
            C0596r.e(l, "avatar Url =" + personInfo.avatarUrl);
            C0544h.a().b(personInfo.avatarUrl, imageView);
            C0596r.e(l, "after load avatar Url =" + personInfo.avatarUrl);
            return;
        }
        bitmap.recycle();
    }

    @SuppressLint({"NewApi"})
    public static void a(cn.com.smartdevices.bracelet.weight.UserInfo userInfo, ImageView imageView) {
        if (userInfo != null) {
            if (userInfo.uid == -1) {
                Bitmap bitmap;
                PersonInfo readPersonInfoForScale = Keeper.readPersonInfoForScale();
                C0596r.e(l, "read the person info avatarPath is " + readPersonInfoForScale.avatarPath);
                if (readPersonInfoForScale.avatarPath == null || readPersonInfoForScale.avatarPath.isEmpty()) {
                    bitmap = null;
                } else {
                    bitmap = C0544h.a().a(Uri.fromFile(new File(readPersonInfoForScale.avatarPath)).toString());
                }
                if (bitmap != null) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        userInfo.avatarSource = byteArrayOutputStream.toByteArray();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (Exception e2) {
                        C0596r.a(l, e2.getMessage());
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (Throwable th) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                    }
                    bitmap.recycle();
                }
            }
            if (null == null && userInfo.avatarSource != null && userInfo.avatarSource.length > 0) {
                byte[] bArr = userInfo.avatarSource;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                C0596r.e(l, "path=" + userInfo.avatarUrl + " avatarBitmap=" + decodeByteArray);
                if (decodeByteArray != null) {
                    imageView.setBackground(new BitmapDrawable(O.a(decodeByteArray)));
                    decodeByteArray.recycle();
                    C0596r.e(l, "set background from avatarSource");
                    return;
                }
                imageView.setBackgroundResource(k.default_userinfo);
                return;
            } else if (!(userInfo.avatarUrl == null || userInfo.avatarUrl.equals(com.xiaomi.e.a.f))) {
                imageView.setBackgroundResource(k.default_userinfo);
                C0596r.e(l, "avatar Url =" + userInfo.avatarUrl);
                C0544h.a().b(userInfo.avatarUrl, imageView);
                return;
            }
        }
        imageView.setBackgroundResource(k.default_userinfo);
    }

    public static void a(String str, int i, Activity activity) {
        a(str, i, (Context) activity, 2);
    }

    public static void a(String str, int i, Context context, int i2) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(kankan.wheel.widget.a.d, i2);
        intent.putExtra(kankan.wheel.widget.a.e, str);
        intent.putExtra(Constant.aS, i);
        context.startActivity(intent);
    }

    public static void a(String str, String str2, byte[] bArr) {
        int length = bArr.length;
        C0596r.e(str, "=============================" + str2 + "============================i");
        for (int i = 0; i < length; i += 3) {
            com.xiaomi.hm.health.bt.model.a aVar = new com.xiaomi.hm.health.bt.model.a(bArr[i + 1], bArr[i + 2], bArr[i]);
            C0596r.e(str, new SportData(i / 3, aVar.e & HeartRateInfo.HR_EMPTY_VALUE, aVar.c & HeartRateInfo.HR_EMPTY_VALUE, aVar.d & HeartRateInfo.HR_EMPTY_VALUE).toString());
        }
        C0596r.e(str, "=============================" + str2 + "============================o");
    }

    public static void a(boolean z) {
        if (a(Keeper.readLastCheckUpdateDate(), Calendar.getInstance()) || z) {
            Keeper.keepCheckUpdateApkDate();
            EventBus.getDefault().post(new EventApkupgrade(z));
            return;
        }
        C0596r.d(l, "Today has checked upgrade.");
    }

    public static void a(boolean z, String str) {
        if (z) {
            q = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        C0596r.e("Debug", str + ": " + (currentTimeMillis - q));
        q = currentTimeMillis;
    }

    public static boolean a() {
        String str = Build.MODEL;
        C0596r.e(l, "model:" + str);
        for (String equals : n) {
            if (equals.equals(str)) {
                return k;
            }
        }
        return false;
    }

    public static boolean a(long j) {
        Time time = new Time();
        time.set(j);
        int i = time.year;
        int i2 = time.month;
        int i3 = time.monthDay;
        time.set(System.currentTimeMillis());
        return (i == time.year && i2 == time.month && i3 == time.monthDay) ? k : false;
    }

    public static boolean a(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return (i < i3 || i > i3 + view.getWidth() || i2 < i4 || i2 > i4 + view.getHeight()) ? false : k;
    }

    public static boolean a(InputStream inputStream, File file) {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[com.activeandroid.b.a];
                while (true) {
                    int read = inputStream.read(bArr, 0, com.activeandroid.b.a);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return k;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            try {
                e.printStackTrace();
                if (fileOutputStream == null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e52) {
                        e52.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static boolean a(Class<BluetoothDevice> cls, BluetoothDevice bluetoothDevice) {
        try {
            return ((Boolean) cls.getMethod("removeBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return BraceletApp.a().getPackageManager().getApplicationInfo(str, C1012a.e) != null ? k : false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean a(String str, Bitmap bitmap) {
        return a(str, bitmap, 100);
    }

    public static boolean a(String str, Bitmap bitmap, int i) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        boolean z = false;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                z = bitmap.compress(CompressFormat.JPEG, i, fileOutputStream);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C0596r.a(l, e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            C0596r.a(l, e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        return z;
    }

    public static boolean a(String str, String str2) {
        if (str.indexOf(58) <= 0 || str2.indexOf(58) <= 0) {
            return false;
        }
        try {
            try {
                return Integer.parseInt(str2.split(kankan.wheel.widget.a.ci)[0]) > Integer.parseInt(str.split(kankan.wheel.widget.a.ci)[0]) ? k : false;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean a(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            return k;
        }
        int i = calendar.get(1);
        i = (i * 365) + calendar.get(6);
        int i2 = (calendar2.get(1) * 365) + calendar2.get(6);
        C0596r.e(l, "totalA =" + i + ", totalB=" + i2);
        return i >= i2 ? false : k;
    }

    public static String[] a(int i, int i2, int i3) {
        String[][] a = C0873k.a().a(i3, i2);
        return (i < 0 || i > 11) ? i <= 83 ? a[((i / 3) + 8) + 1] : new String[0] : a[i + 1];
    }

    public static float b(float f, Context context) {
        return (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f;
    }

    public static int b(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return instance.get(12) + (instance.get(11) * 60);
    }

    private static int b(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            i3 /= 2;
            i4 /= 2;
            while (i3 / i5 > i2 && i4 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static int b(Summary summary) {
        int b = b(summary.getSleepStartTime());
        int b2 = b(summary.getSleepRiseTime());
        return b2 >= b ? b2 - b : (1440 - b) + b2;
    }

    public static int b(Calendar calendar) {
        return calendar.get(7) == 1 ? 7 : calendar.get(7) - 1;
    }

    public static long b(Calendar calendar, Calendar calendar2) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(calendar.get(1), calendar.get(2), calendar.get(5));
        Calendar instance2 = Calendar.getInstance();
        instance2.clear();
        instance2.set(calendar2.get(1), calendar2.get(2), calendar2.get(5));
        return (instance2.getTimeInMillis() - instance.getTimeInMillis()) / com.xiaomi.mistatistic.sdk.d.h;
    }

    public static String b(int i) {
        return new DecimalFormat("#.#").format((double) (((float) i) * 1.0E-4f));
    }

    public static String b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            String str2 = packageInfo.packageName;
            return i + kankan.wheel.widget.a.ci + str;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(Context context, String str) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), C0113o.h).metaData.getString(str);
            C0596r.e(l, "hm_channel=" + string);
            return string;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return Constant.f;
        }
    }

    public static String b(byte[] bArr) {
        String str = com.xiaomi.e.a.f;
        if (bArr == null || bArr.length <= 0) {
            return str;
        }
        try {
            return new String(bArr);
        } catch (Exception e) {
            C0596r.e("chenee", "Utils.java getStringFromBytes error:" + e.getMessage());
            return str;
        }
    }

    public static ArrayList<String> b(SportDay sportDay) {
        ArrayList<String> d = d();
        if (d == null) {
            return null;
        }
        Iterator it = d.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (sportDay.toString().equals(str)) {
                d.remove(str);
            }
        }
        c((ArrayList) d);
        return d;
    }

    public static ArrayList<SportData> b(ArrayList<SportData> arrayList) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(arrayList);
            return (ArrayList) new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (Exception e) {
            e.printStackTrace();
            C0596r.e("WPJ", e.getMessage());
            return new ArrayList();
        }
    }

    public static void b(Activity activity) {
        DownloadManager downloadManager = (DownloadManager) activity.getSystemService("download");
        Query query = new Query();
        long readDownloadApkId = Keeper.readDownloadApkId();
        query.setFilterById(new long[]{readDownloadApkId});
        Cursor query2 = downloadManager.query(query);
        if (query2.moveToFirst()) {
            switch (query2.getInt(query2.getColumnIndex(LocationManagerProxy.KEY_STATUS_CHANGED))) {
                case kankan.wheel.widget.l.a /*1*/:
                    break;
                case kankan.wheel.widget.a.k /*2*/:
                    break;
                case kankan.wheel.widget.a.aQ /*4*/:
                    C0596r.d(l, "STATUS_PAUSED");
                    break;
                case kankan.wheel.widget.a.ba /*8*/:
                    C0596r.d(l, "STATUS_SUCCESSFUL download_id=" + readDownloadApkId);
                    Uri uriForDownloadedFile = downloadManager.getUriForDownloadedFile(readDownloadApkId);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(uriForDownloadedFile, "application/vnd.android.package-archive");
                    intent.setFlags(268435456);
                    activity.startActivity(intent);
                    com.huami.android.view.b.a((Context) activity, (int) r.apk_download_ok, 1).show();
                    Keeper.keepDownloadApkId(-1);
                    return;
                case kankan.wheel.widget.a.bp /*16*/:
                    C0596r.d(l, "STATUS_FAILED");
                    downloadManager.remove(new long[]{Keeper.readDownloadApkId()});
                    Keeper.keepDownloadApkId(-1);
                    com.huami.android.view.b.a((Context) activity, (int) r.download_failed, 1).show();
                    return;
                default:
                    return;
            }
            C0596r.d(l, "STATUS_PENDING");
            C0596r.d(l, "STATUS_RUNNING");
        }
    }

    public static void b(Activity activity, boolean z) {
        C0596r.d(l, "checkXiaomiApkUpdate");
        com.xiaomi.market.sdk.d.a(false);
        com.xiaomi.market.sdk.d.a(new V(activity, z));
        com.xiaomi.market.sdk.d.a((Context) activity);
    }

    public static void b(Context context, int i) {
        SwitchOperator switchOperator = new SwitchOperator();
        switchOperator.type = i;
        switchOperator.enableClearData = k;
        switchOperator.enableSteps = k;
        switchOperator.lastUid = a.f(context).uid;
        switchOperator.lastMacAddress = Keeper.readBraceletBtInfo().b;
        SportDay sportDay = new SportDay();
        switchOperator.date = sportDay.getKey();
        Summary c = C0591m.a().c(sportDay);
        if (c != null) {
            switchOperator.steps = c.getSteps();
            C0596r.d(l, "summary steps:" + switchOperator.steps);
        } else {
            C0596r.d(l, "no summary steps!!!");
        }
        Keeper.keepSwitchOperator(switchOperator);
    }

    public static void b(Context context, Bundle bundle, d dVar) {
        String string = bundle.getString(g.a);
        int i = bundle.getInt(cn.com.smartdevices.bracelet.j.f.aw);
        int i2 = bundle.getInt(cn.com.smartdevices.bracelet.j.f.ax);
        l.a(a.f(context), i, bundle.getInt(cn.com.smartdevices.bracelet.lab.sync.l.c), i2, new R(dVar, string, i, i2, context));
    }

    @SuppressLint({"NewApi"})
    public static void b(cn.com.smartdevices.bracelet.weight.UserInfo userInfo, ImageView imageView) {
        if (userInfo != null) {
            if (userInfo.uid == -1) {
                Bitmap bitmap;
                PersonInfo readPersonInfoForScale = Keeper.readPersonInfoForScale();
                C0596r.e(l, "read the person info avatarPath is " + readPersonInfoForScale.avatarPath);
                if (readPersonInfoForScale.avatarPath == null || readPersonInfoForScale.avatarPath.isEmpty()) {
                    bitmap = null;
                } else {
                    bitmap = C0544h.a().a(Uri.fromFile(new File(readPersonInfoForScale.avatarPath)).toString());
                }
                if (bitmap != null) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        userInfo.avatarSource = byteArrayOutputStream.toByteArray();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (Exception e2) {
                        C0596r.a(l, e2.getMessage());
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (Throwable th) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                    }
                    bitmap.recycle();
                }
            }
            if (null == null && userInfo.avatarSource != null && userInfo.avatarSource.length > 0) {
                byte[] bArr = userInfo.avatarSource;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                C0596r.e(l, "path=" + userInfo.avatarUrl);
                if (decodeByteArray != null) {
                    imageView.setBackground(new BitmapDrawable(O.a(decodeByteArray)));
                    C0596r.e(l, "set background from avatarSource");
                    decodeByteArray.recycle();
                    return;
                }
                imageView.setBackgroundResource(k.person_avatar_default_blue);
                return;
            } else if (!(userInfo.avatarUrl == null || userInfo.avatarUrl.equals(com.xiaomi.e.a.f))) {
                imageView.setBackgroundResource(k.person_avatar_default_blue);
                C0596r.e(l, "avatar Url =" + userInfo.avatarUrl);
                C0544h.a().b(userInfo.avatarUrl, imageView);
                return;
            }
        }
        imageView.setBackgroundResource(k.person_avatar_default_blue);
    }

    private static void b(C1123b c1123b, Activity activity) {
        if (activity == null || c1123b == null) {
            C0596r.d(l, "showUpdateDlg return with NULL pointer!");
            return;
        }
        String str = com.xiaomi.e.a.f;
        if (!TextUtils.isEmpty(c1123b.a)) {
            C0596r.d(l, "mi shop updateLog=" + c1123b.a);
            str = c1123b.a;
        }
        Bundle bundle = new Bundle();
        bundle.putString(h, c1123b.b);
        bundle.putString(g, str);
        bundle.putString(i, c1123b.d);
        c.showPanel(activity, C0810j.class, bundle);
    }

    public static final boolean b() {
        C0596r.e(l, "Sdk : " + VERSION.SDK_INT + " model:" + Build.MODEL);
        return VERSION.SDK_INT >= 18 ? k : false;
    }

    public static boolean b(String str) {
        return (str != null && str.length() >= 1 && str.length() <= 20) ? k : false;
    }

    public static boolean b(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        boolean z = false;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                z = bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C0596r.a(l, e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            C0596r.a(l, e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        return z;
    }

    public static float c(float f, Context context) {
        return f / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public static int c(int i) {
        return r[(i + 1) % 6];
    }

    public static C0993k c() {
        if (m == null) {
            synchronized (Utils.class) {
                if (m == null) {
                    m = new com.c.a.r().i();
                }
            }
        }
        return m;
    }

    public static String c(SportDay sportDay) {
        Date date = new Date();
        date.setYear(sportDay.year - 1900);
        date.setMonth(sportDay.mon);
        date.setDate(sportDay.day);
        return new SimpleDateFormat(BraceletApp.a().getString(r.date_year_month_day)).format(date);
    }

    public static String c(String str) {
        return (str == null || str.equals("null")) ? com.xiaomi.e.a.f : str;
    }

    public static void c(Context context) {
        l.c(context, new X(context));
    }

    public static void c(Context context, int i) {
        b(context, i);
        com.xiaomi.hm.health.bt.bleservice.a.b();
        Intent intent = new Intent();
        intent.setAction(Constant.aX);
        context.sendBroadcast(intent);
    }

    private static void c(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONException e;
        if (arrayList != null) {
            try {
                jSONObject = new JSONObject(Keeper.readLazyDays());
                try {
                    jSONObject.put(kankan.wheel.widget.a.cl, c().b((Object) arrayList));
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (jSONObject != null) {
                        Keeper.keepLazyDays(jSONObject.toString());
                    }
                    C0596r.e(l, "after cope with lazy days: " + jSONObject);
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = null;
                e.printStackTrace();
                if (jSONObject != null) {
                    Keeper.keepLazyDays(jSONObject.toString());
                }
                C0596r.e(l, "after cope with lazy days: " + jSONObject);
            }
            if (jSONObject != null) {
                Keeper.keepLazyDays(jSONObject.toString());
            }
            C0596r.e(l, "after cope with lazy days: " + jSONObject);
        }
    }

    public static boolean c(Activity activity) {
        List runningTasks = ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            if (componentName.getPackageName().equals(activity.getPackageName()) && componentName.getClassName().equals(activity.getComponentName().getClassName())) {
                return k;
            }
        }
        return false;
    }

    public static String d(Context context) {
        return a(context, "ro.build.date.utc");
    }

    public static String d(Context context, int i) {
        int i2 = i / 12;
        int i3 = i - ((i / 12) * 12);
        if (i2 != 0 && i3 != 0) {
            return context.getString(r.baby_weight_report_monthyear_templates0, new Object[]{i2 + com.xiaomi.e.a.f, i3 + com.xiaomi.e.a.f});
        } else if (i2 != 0) {
            return i2 + context.getString(r.year);
        } else {
            if (i3 != 0) {
                return context.getString(r.baby_weight_report_monthyear_templates1, new Object[]{i3 + com.xiaomi.e.a.f});
            }
            return context.getString(r.baby_weight_report_monthyear_templates1, new Object[]{f});
        }
    }

    public static String d(SportDay sportDay) {
        Date date = new Date();
        date.setYear(sportDay.year - 1900);
        date.setMonth(sportDay.mon);
        date.setDate(sportDay.day);
        return new SimpleDateFormat(BraceletApp.a().getString(r.date_month_day)).format(date);
    }

    public static String d(String str) {
        String replace = str.replace("+", com.xiaomi.e.a.f);
        if (replace.startsWith("86")) {
            replace = replace.substring(2, replace.length());
        }
        String str2 = com.xiaomi.e.a.f;
        int i = 0;
        while (i < replace.length()) {
            try {
                int random = (int) (Math.random() * 3.0d);
                str2 = str2 + o[Integer.valueOf(replace.charAt(i) + com.xiaomi.e.a.f).intValue()].charAt(random);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str2;
    }

    public static ArrayList<String> d() {
        String optString;
        try {
            optString = new JSONObject(URLDecoder.decode(Keeper.readLazyDays())).optString(kankan.wheel.widget.a.cl);
        } catch (JSONException e) {
            e.printStackTrace();
            optString = null;
        }
        if (optString == null) {
            return null;
        }
        ArrayList<String> arrayList;
        try {
            arrayList = (ArrayList) c().a(optString, new W().getType());
        } catch (Exception e2) {
            e2.printStackTrace();
            arrayList = null;
        }
        return arrayList;
    }

    public static String e(Context context) {
        return a(context, "ro.build.version.incremental");
    }

    private static String e(Context context, int i) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String str = com.xiaomi.e.a.f;
        str = f;
        float f = ((float) i) / kankan.wheel.widget.a.bQ;
        float round = (float) Math.round(f);
        if (round > f) {
            round -= 0.5f;
        }
        String format;
        if (((float) i) > kankan.wheel.widget.a.bQ) {
            format = decimalFormat.format((double) round);
            if (((double) Math.abs(round - f)) < 0.1d) {
                str = context.getString(r.marathon_format_0, new Object[]{format});
            } else {
                str = context.getString(r.marathon_format_1, new Object[]{format});
            }
        } else if (Math.abs(i - 21000) < kankan.wheel.widget.a.aB) {
            str = context.getString(r.half_marathon_format_0, new Object[]{Constants.VIA_TO_TYPE_QQ_GROUP});
        } else if (i > 21000) {
            str = context.getString(r.half_marathon_format_1);
        } else {
            f = ((float) i) / kankan.wheel.widget.a.bP;
            round = (float) Math.round(f);
            if (round > f) {
                round -= 0.5f;
            }
            format = decimalFormat.format((double) round);
            if (round == 0.0f) {
                str = com.xiaomi.e.a.f;
            } else {
                str = context.getString(r.share_play_ground_format, new Object[]{format});
            }
        }
        C0596r.e(l, "maraton:" + i + ", str=" + str);
        return str;
    }

    public static String e(SportDay sportDay) {
        return (sportDay.mon + 1) + "/" + sportDay.day;
    }

    public static String e(String str) {
        C0596r.e(l, "\n====>         before purge json :" + str);
        String replace = str.replace("\"[", "[").replace("]\"", "]").replace("}\"", "}").replace("\"{", "{").replace("\\\"", "\"").replace("\\/", "/");
        C0596r.e(l, "\n====>         after purge json([], {},\\\", \\/) :" + replace);
        return replace;
    }

    public static boolean e() {
        return DeviceSource.hasBindBracelet();
    }

    private static long f(SportDay sportDay) {
        return sportDay.calendar.getTimeInMillis() / 1000;
    }

    public static String f(Context context) {
        return a(context, "ro.miui.ui.version.code");
    }

    public static String f(String str) {
        try {
            str = URLDecoder.decode(str, kankan.wheel.widget.a.bO);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static boolean f() {
        return Keeper.readPersonInfoBaseConfig().isInComingCallEnabled();
    }

    public static String g(Context context) {
        return a(context, "ro.miui.ui.version.name");
    }

    public static boolean g() {
        BraceletBtInfo readBraceletBtInfo = Keeper.readBraceletBtInfo();
        return (readBraceletBtInfo == null || TextUtils.isEmpty(readBraceletBtInfo.b)) ? false : k;
    }

    public static boolean g(String str) {
        return (((str.contains("'") | str.contains("\"")) | str.contains("\\")) | str.contains("/")) == 0 ? k : false;
    }

    public static String h(Context context) {
        String line1Number = ((TelephonyManager) context.getSystemService("phone")).getLine1Number();
        C0596r.e(l, "get tel =" + line1Number);
        return line1Number == null ? com.xiaomi.e.a.f : line1Number;
    }

    public static String h(String str) {
        if (str.length() > 10) {
            str = str.substring(0, 10) + "...";
        }
        C0596r.e(l, str);
        return str;
    }

    public static boolean h() {
        return Build.DEVICE.equalsIgnoreCase("virgo");
    }

    public static String i(Context context) {
        LoginData f = a.f(context);
        String str = com.xiaomi.e.a.f;
        if (f == null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(g.f, com.xiaomi.e.a.f + f.uid);
        hashMap.put(kankan.wheel.widget.a.o, f.security);
        hashMap.put(Friend.c, Keeper.readUserName());
        return cn.com.smartdevices.bracelet.j.g.a(hashMap);
    }

    public static String i(String str) {
        float f = GroundOverlayOptions.NO_DIMENSION;
        try {
            f = Float.parseFloat(str);
        } catch (Exception e) {
        }
        return f < 0.0f ? com.xiaomi.e.a.f : f + com.xiaomi.e.a.f;
    }

    public static boolean i() {
        return Build.DEVICE.equalsIgnoreCase("leo");
    }

    public static String j(Context context) {
        String externalStorageState = Environment.getExternalStorageState();
        C0596r.e(l, "ext state =" + externalStorageState);
        File externalFilesDir = "mounted".equals(externalStorageState) ? context.getExternalFilesDir(p) : context.getFilesDir();
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        if (externalFilesDir == null) {
            return Environment.getExternalStorageDirectory().getPath() + "/" + p;
        }
        externalStorageState = externalFilesDir.getPath();
        C0596r.e(l, "getStoragePath:" + externalStorageState);
        return externalStorageState;
    }

    public static boolean j() {
        int daySportGoalSteps = Keeper.readPersonInfo().getDaySportGoalSteps();
        DaySportData g = C0591m.a().g(C0591m.a().m());
        return (g == null || g.getStepsInfo() == null || g.getStepsInfo().getStepsCount() < daySportGoalSteps) ? false : k;
    }

    public static String k(Context context) {
        String readUUID = Keeper.readUUID();
        if (readUUID != null && readUUID.length() >= 1) {
            return readUUID;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String str = " " + telephonyManager.getDeviceId();
        String str2 = " " + telephonyManager.getSimSerialNumber();
        String str3 = " " + Secure.getString(context.getContentResolver(), "android_id");
        String str4 = " " + BluetoothAdapter.getDefaultAdapter().getAddress();
        readUUID = new UUID((long) (str4.hashCode() | str3.hashCode()), (long) (str.hashCode() | str2.hashCode())).toString();
        C0596r.b(l, "\ndeviceId:" + str + "\nserialNum:" + str2 + "\nandroidId:" + str3 + "\nmacAddress:" + str4 + "\nuuid:" + readUUID);
        Keeper.keepUUID(readUUID);
        return readUUID;
    }

    private static List<WeightGoal> k(String str) {
        List<WeightGoal> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONObject(com.xiaomi.channel.gamesdk.b.b).getJSONArray(com.huami.android.widget.a.c);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new WeightGoal(jSONArray.getJSONObject(i)));
            }
        } catch (Exception e) {
            C0596r.e(l, "parse error");
        }
        return arrayList;
    }

    public static boolean k() {
        return b.h().w.booleanValue();
    }

    public static float l() {
        ah a = ah.a();
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        C0596r.e(l, "today before:" + new SimpleDateFormat("dd HH:mm:ss").format(Long.valueOf(instance.getTimeInMillis())));
        WeightInfo a2 = a.a(-1, instance.getTimeInMillis());
        float weight = a2 != null ? a2.weight : Keeper.readPersonInfo().getWeight();
        C0596r.e(l, " calorie weight :" + weight);
        return weight;
    }

    public static boolean l(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().isConnected() : false;
    }

    public static boolean m() {
        Locale locale = Locale.getDefault();
        return (locale.equals(Locale.CHINA) || locale.equals(Locale.CHINESE) || locale.equals(Locale.SIMPLIFIED_CHINESE) || locale.equals(Locale.TRADITIONAL_CHINESE)) ? false : k;
    }

    public static boolean m(Context context) {
        String a = a(context, "sys.keyguard.bleunlock");
        C0596r.e(l, "unlock:" + a);
        return (a == null || !a.equals("true")) ? false : k;
    }

    public static String n() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(BraceletApp.a().getString(r.date_month_day));
        Calendar instance = Calendar.getInstance();
        instance.add(2, -1);
        instance.set(5, 1);
        String format = simpleDateFormat.format(instance.getTime());
        instance.set(5, 1);
        instance.add(2, 1);
        instance.add(5, -1);
        return format + " - " + simpleDateFormat.format(instance.getTime());
    }

    public static boolean n(Context context) {
        if (B.a(context, B.d)) {
            return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(18) == null ? false : !cn.com.smartdevices.bracelet.f.g.a(context, cn.com.smartdevices.bracelet.h.h.i) ? false : !cn.com.smartdevices.bracelet.h.f.a(context.getContentResolver()) ? false : k;
        } else {
            C0596r.d(l, "not support miui sensorhub!!!");
            return false;
        }
    }

    public static String o() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(BraceletApp.a().getString(r.date_month_day));
        Calendar instance = Calendar.getInstance();
        int i = instance.get(7);
        instance.add(5, (i == 1 ? -6 : 2 - i) - 7);
        String format = simpleDateFormat.format(instance.getTime());
        instance.add(5, 6);
        return format + " - " + simpleDateFormat.format(instance.getTime());
    }

    public static boolean o(Context context) {
        boolean z = k;
        try {
            int i = Secure.getInt(context.getContentResolver(), "bluetooth_unlock_status");
            String string = Secure.getString(context.getContentResolver(), "bluetooth_address_to_unlock");
            String str = Keeper.readBraceletBtInfo().b;
            C0596r.d(l, "isUseUnlock:" + i + ",unlockAddress:" + string + " , mDeviceAddress = " + str);
            if (string == null || com.xiaomi.e.a.f.equals(string) || !string.equals(str)) {
                return false;
            }
            if (i != 1) {
                z = false;
            }
            return z;
        } catch (SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static UserInfo p() {
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        return readPersonInfo.isValid() ? a(readPersonInfo) : null;
    }

    public static boolean p(Context context) {
        if (!WXAPIFactory.createWXAPI(context, m.j).isWXAppInstalled()) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(WXApp.WXAPP_PACKAGE_NAME, 0).versionCode >= kankan.wheel.widget.a.ax ? k : false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static i q() {
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        return readPersonInfo.isValid() ? readPersonInfo.getMiLiHwConfig() : null;
    }

    public static void q(Context context) {
        String b = b(context);
        if (!TextUtils.isEmpty(b) && !b.equals(Keeper.readApkVersion())) {
            Keeper.keepApkVersion(b);
        }
    }

    public static void r(Context context) {
        if (l(context)) {
            b h = b.h();
            if (h.w.booleanValue()) {
                h.getClass();
                a("https://hm.mi-ae.com/huami.health.agreement.do", (int) r.user_agreement, context, 3);
                return;
            }
            h.getClass();
            a("https://hm.xiaomi.com/huami.health.agreement.do", (int) r.user_agreement, context, 3);
            return;
        }
        com.huami.android.view.b.a(context, (int) r.network_error, 1).show();
    }

    public static boolean s(Context context) {
        return b(context, Constant.d).equals(Constant.f);
    }

    public static void t(Context context) {
        l.a(context, new Y(), URLEncoder.encode(Keeper.readLazyDays()));
    }

    public static void u(Context context) {
        C0591m a = C0591m.a();
        SportDay m = C0591m.a().m();
        DaySportData g = a.g(m);
        if (g != null) {
            StepsInfo stepsInfo = g.getStepsInfo();
            if (stepsInfo != null && stepsInfo.getStepsCount() >= Keeper.readPersonInfo().getDaySportGoalSteps()) {
                b(m);
                t(context);
            }
        }
    }

    public static boolean v(Context context) {
        return (!C(context) || D(context)) ? false : k;
    }

    public static boolean w(Context context) {
        Partner a = C0425b.a(context).a("2833961550");
        C0596r.e(l, "bohee partner info : " + a.title + " " + a.authorizeStatus);
        return 1 == a.authorizeStatus ? k : false;
    }

    public static boolean x(Context context) {
        return C0891z.a(context).a("2833961550");
    }

    public static boolean y(Context context) {
        return DateFormat.is24HourFormat(context);
    }

    public static void z(Context context) {
        LoginData f = a.f(context);
        if (f.isValid()) {
            Keeper.setUploadImeiStatus(-1);
            l.a(context, f, 1, new S());
            return;
        }
        C0596r.d(l, "uploadIMEI loginData not valid.");
    }
}
