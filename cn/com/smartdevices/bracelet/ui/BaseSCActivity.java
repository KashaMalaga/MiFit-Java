package cn.com.smartdevices.bracelet.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.support.v4.app.aT;
import cn.com.smartdevices.bracelet.B;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0891z;
import cn.com.smartdevices.bracelet.F;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.L;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.activity.MainActivity;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.eventbus.EventBtOnOff;
import cn.com.smartdevices.bracelet.eventbus.EventWifiConnected;
import cn.com.smartdevices.bracelet.eventbus.shoes.EventDeviceBoundState;
import cn.com.smartdevices.bracelet.eventbus.weight.EventScaleStatus;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightSyncedDevice;
import cn.com.smartdevices.bracelet.gps.sync.z;
import cn.com.smartdevices.bracelet.j.j;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.lab.sync.i;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.shoes.sync.C0639p;
import cn.com.smartdevices.bracelet.shoes.sync.J;
import cn.com.smartdevices.bracelet.tencent.health.QQHealth;
import cn.com.smartdevices.bracelet.upgrade.FwUpgradeManager;
import cn.com.smartdevices.bracelet.weight.BabyWeightActivity;
import cn.com.smartdevices.bracelet.weight.P;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import cn.com.smartdevices.bracelet.weight.family.MemberInfoSetWeightActivity;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.xiaomi.hm.health.bt.a.A;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.e.a;
import com.xiaomi.hm.health.bt.e.f;
import com.xiaomi.hm.health.bt.e.g;
import com.xiaomi.hm.health.bt.e.h;
import com.xiaomi.hm.health.bt.model.HwBatteryStatus;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.r;
import com.xiaomi.hm.health.t;
import com.xiaomi.mistatistic.sdk.d;
import de.greenrobot.event.EventBus;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class BaseSCActivity extends SystemBarTintActivity implements h {
    private static final int c = 8193;
    private static final int d = 8194;
    private static final int e = 8195;
    private static final int f = 30000;
    private static final int g = 4098;
    private static final int h = 4099;
    private static final int i = 4100;
    private static final int j = 4101;
    private static final int k = 4102;
    private static final int l = 4103;
    private static final int m = 4104;
    private static final int n = 4105;
    private static final int o = 4112;
    private static final int p = 4113;
    private static final int q = 4114;
    private static final int r = 4115;
    private static final int s = 4116;
    private static final int t = 39;
    private static final String v = "BaseSCActivity";
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = true;
    private a E = a.a();
    private f F = null;
    private boolean G = false;
    private boolean H = false;
    private long I = 0;
    private long J = 0;
    private boolean K;
    private boolean L = false;
    private final int M = 1;
    private final int N = 3;
    protected C0639p a = null;
    private FwUpgradeManager b;
    private Handler u = null;
    private BroadcastReceiver w = null;
    private Context x = null;
    private boolean y = false;
    private boolean z = false;

    private void A() {
        j.a(getApplicationContext(), l.a(getApplicationContext(), 1), new C0824y(this), true);
    }

    private void B() {
        j.a(getApplicationContext(), l.a(getApplicationContext(), 0), new C0825z(this), true);
    }

    private void C() {
        if (Keeper.getSyncWeightInfoToServer() == 1) {
            A();
        }
        if (Keeper.getSyncBraceletInfoToServer() == 1) {
            B();
        }
        if (Keeper.getUploadImeiStatus() == 0) {
            C0596r.d(v, " last uploadImei failed, retry uploadIMEI()");
            Utils.z(getApplicationContext());
        }
    }

    private void a(int i, int i2) {
        new Thread(new C0823x(this, i, i2)).start();
    }

    private void a(WeightInfo weightInfo) {
        ah a = ah.a();
        boolean weightMergeResult = Keeper.readPersonInfo().getMiliConfig().getWeightMergeResult();
        WeightInfo e = a.e(weightInfo.uid);
        if (weightInfo.uid != 0 && weightMergeResult && e != null && weightInfo.timestamp - e.timestamp <= 30000) {
            C0596r.d(v, "<<merge>> realtime weighting:<" + e + "><" + weightInfo + ">");
            aA.a(e);
        }
        a.b(weightInfo);
        if (b.h().c.d.booleanValue() && weightInfo.uid == -1) {
            QQHealth.getInstance(this.x.getApplicationContext()).addNeedSyncWeight(Long.valueOf(weightInfo.timestamp));
        }
        EventBus.getDefault().post(new EventWeightSyncedDevice(weightInfo.uid));
    }

    private void a(c cVar) {
        PowerManager powerManager = (PowerManager) getSystemService("power");
        boolean a = a(this.x);
        C0596r.d(v, "isEnterInBackground:" + a + ",isScreenOn:" + powerManager.isScreenOn());
        if (!a && powerManager.isScreenOn()) {
            if (cVar.c()) {
                HashMap hashMap = new HashMap();
                hashMap.put(C0410c.y, com.xiaomi.hm.health.bt.bleservice.a.e().a + com.xiaomi.e.a.f);
                hashMap.put(C0410c.z, com.xiaomi.hm.health.bt.bleservice.a.e().b.toString() + com.xiaomi.e.a.f);
                C0401a.a(this.x, C0409b.af, hashMap);
                r();
            } else if (c.SHOES.equals(cVar)) {
                a(false);
            }
        }
    }

    private void a(HwConnStatus hwConnStatus) {
        C0596r.d(v, "HwConnStatus:" + hwConnStatus + ",type = " + hwConnStatus.b());
        if (DeviceSource.hasBindShoesDevice() || DeviceSource.hasBindBracelet()) {
            EventBus.getDefault().postSticky(hwConnStatus);
            if (hwConnStatus.k()) {
                a(hwConnStatus.b());
            }
        }
    }

    private void a(e eVar) {
        P p = new P();
        p.a = eVar;
        if (!eVar.f()) {
            p.b = getResources().getString(r.weight_weighting_now);
            p.c = 0;
            p.d = 0.0f;
        } else if (eVar.d()) {
            C0596r.e(v, "the data is finish not save!!!");
        } else {
            UserInfo userInfo = new UserInfo();
            userInfo.uid = 0;
            userInfo.name = getString(r.visitor);
            List a = aA.a(eVar);
            if (a != null && a.size() == 1) {
                userInfo = (UserInfo) a.get(0);
            }
            p.f = a;
            if (userInfo.uid != 0) {
                eVar.a(aA.a(userInfo.height, Birthday.fromStr(userInfo.birthday).getAge(), eVar.k()));
                p.b = userInfo.name;
                p.c = userInfo.uid;
                p.d = userInfo.targetWeight;
            } else {
                p.b = getResources().getString(r.weight_guest);
                p.c = 0;
                p.d = 0.0f;
            }
            Calendar instance = Calendar.getInstance();
            instance.clear(14);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(eVar.e());
            if (instance.get(1) != instance2.get(1)) {
                C0596r.d(v, "update weight data timestamp!!!");
                eVar.a(instance.getTimeInMillis());
            }
            if (ah.a().b(eVar.e()) == null) {
                WeightInfo weightInfo = new WeightInfo(eVar.k(), userInfo.uid, eVar.e());
                weightInfo.deviceid = eVar.a();
                a(weightInfo);
                C0891z.a(this.x).b(userInfo, eVar);
                this.u.sendEmptyMessage(l);
            } else {
                C0596r.d(v, "the data exist in database!!!");
            }
        }
        EventBus.getDefault().post(p);
    }

    private boolean a(boolean z, boolean z2) {
        boolean z3 = true;
        boolean z4 = (z2 || C0591m.a().r() == c.SHOES.b()) ? false : true;
        if (z4) {
            return false;
        }
        if (this.a == null) {
            this.a = new C0639p(this.x);
        }
        if (z) {
            z3 = false;
        } else if (System.currentTimeMillis() - Keeper.readSyncDeviceTime(c.SHOES.b()) > 120000) {
            z3 = false;
        }
        return !z3 ? this.a.h() : false;
    }

    private void b(Context context) {
        l.f(cn.com.smartdevices.bracelet.e.a.f(context), new C0822w(this, SystemClock.elapsedRealtime()));
    }

    private void c(int i) {
        C0596r.b(v, "onBatteryLowNotification:" + i);
        int readLowBatteryNofifyLevel = Keeper.readLowBatteryNofifyLevel();
        int a = HwBatteryStatus.a(i);
        if (readLowBatteryNofifyLevel != a) {
            Keeper.keepLowBatteryNofityLevel(a);
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            CharSequence string = getString(r.noti_bracelet_low_battery_title);
            CharSequence charSequence = com.xiaomi.e.a.f;
            if (a == 0) {
                charSequence = getString(r.noti_bracelet_low_battery_content_high);
            } else if (a == 1 || a == 2) {
                charSequence = getString(r.noti_bracelet_low_battery_content_mid);
            } else if (a == 3) {
                string = getString(r.noti_bracelet_low_battery_title_low);
                charSequence = getString(r.noti_bracelet_low_battery_content_low);
            }
            aT e = new aT(this).a((int) k.app_icon).a(string).b(charSequence).e(true);
            e.a(new long[]{100, 500, 500, 500});
            e.a(PendingIntent.getBroadcast(this, 0, new Intent(kankan.wheel.widget.a.bM), 268435456));
            notificationManager.notify(1, e.c());
        }
    }

    private boolean d(int i) {
        String string;
        PendingIntent pendingIntent;
        C0596r.e(v, "notifyBraceletVibrated:" + i);
        String str = com.xiaomi.e.a.f;
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 268435456);
        switch (i) {
            case t.WeightView_wv_tips /*14*/:
                string = getString(r.notify_status_motor_call);
                pendingIntent = activity;
                break;
            case kankan.wheel.widget.a.aV /*15*/:
                string = getString(r.notify_status_motor_disconnect);
                pendingIntent = activity;
                break;
            case kankan.wheel.widget.a.bp /*16*/:
                string = getString(r.notify_status_motor_smart_alarm);
                pendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(kankan.wheel.widget.a.bN), 268435456);
                break;
            case kankan.wheel.widget.a.bu /*17*/:
                string = getString(r.notify_status_motor_alarm);
                pendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(kankan.wheel.widget.a.bN), 268435456);
                break;
            case kankan.wheel.widget.a.br /*18*/:
                string = getString(r.notify_status_motor_goal);
                pendingIntent = activity;
                break;
            case kankan.wheel.widget.a.bs /*19*/:
                string = getString(r.notify_status_motor_auth);
                pendingIntent = activity;
                break;
            case kankan.wheel.widget.a.aF /*20*/:
                string = getString(r.notify_status_motor_shut_down);
                pendingIntent = activity;
                break;
            case com.xiaomi.hm.health.bt.profile.a.a.Z /*21*/:
                string = getString(r.notify_status_motor_auth_success);
                pendingIntent = activity;
                break;
            case com.xiaomi.hm.health.bt.profile.a.a.aa /*22*/:
                string = getString(r.notify_status_motor_test);
                pendingIntent = activity;
                break;
            case com.xiaomi.hm.health.bt.profile.a.a.ab /*27*/:
                return true;
            default:
                return false;
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        aT e = new aT(this).a((int) k.app_icon).a(getString(r.notify_status_motor) + string).e(true);
        e.a(pendingIntent);
        notificationManager.notify(t, e.c());
        return true;
    }

    private boolean d(boolean z) {
        boolean z2 = this.y || this.z;
        j();
        if (!DeviceSource.hasBindBracelet()) {
            return false;
        }
        DeviceSource.unbindSensorHub();
        if (z && com.xiaomi.hm.health.bt.bleservice.a.c()) {
            if (z2) {
                r();
            } else if (this.G) {
                this.G = false;
                g(true);
            }
        }
        i();
        return true;
    }

    private void e(int i) {
        C0596r.e(v, "showFwUpgradeUI:" + this.B);
        if (!this.B) {
            this.B = true;
            Intent intent = new Intent();
            intent.setClass(this, FwUpgradeActivity.class);
            intent.putExtra(SettingContainerActivity.a, i);
            startActivityForResult(intent, i == 0 ? d : e);
        }
    }

    private boolean e(boolean z) {
        if (DeviceSource.hasBindWeight()) {
            if (z) {
                if (l()) {
                    this.u.sendEmptyMessage(n);
                } else {
                    m();
                }
            }
            return true;
        }
        n();
        return false;
    }

    private void f(int i) {
        C0596r.d(v, "weight connect status:" + i);
        if (i == 1 || i == 0 || i == 4) {
            m();
        } else if (i != 2 && i == 3) {
            this.L = true;
            if (DeviceSource.hasBindWeight()) {
                this.u.sendEmptyMessage(n);
            }
            n();
            C0596r.d(v, "removeWeightConnectFailedDynamic");
            this.u.removeMessages(o);
            if (C0891z.a(this.x).b()) {
                this.u.sendEmptyMessage(l);
            }
        }
    }

    private boolean f(boolean z) {
        if (!DeviceSource.hasBindShoesDevice()) {
            return false;
        }
        DeviceSource.unbindSensorHub();
        if (z) {
            a(this.H);
            this.H = false;
        }
        return true;
    }

    private void g(boolean z) {
        com.xiaomi.hm.health.bt.bleservice.a.j();
        if (z || this.b.checkMiliFwUpgrade() || System.currentTimeMillis() - Keeper.readSyncTime(0) > 120000) {
            new A(new F(this.x)).f();
        }
    }

    private void h() {
        boolean c = c(false);
        if (b.h().l.a.booleanValue()) {
            e(c);
        }
        if (d(c)) {
            this.C = true;
        } else if (f(c)) {
            this.C = true;
        } else if (k()) {
            this.C = true;
        } else if (this.C) {
            c();
            this.C = false;
        }
    }

    private void i() {
        B a = B.a();
        if (a.f()) {
            PersonInfo readPersonInfo = Keeper.readPersonInfo();
            String str = Keeper.readBraceletBtInfo().b;
            if (BluetoothAdapter.checkBluetoothAddress(str) && readPersonInfo.isInComingCallEnabled() && !a.c(Keeper.readBraceletBtInfo().b)) {
                C0596r.d(v, "checkMiuiIncallDelay setAlertIncall:" + readPersonInfo.getInComingCallTime());
                a.d(str, true);
                a.a(str, readPersonInfo.getInComingCallTime());
                readPersonInfo.disableInComingCallTime();
                readPersonInfo.setInComingCallTime(2);
                readPersonInfo.setNeedSyncServer(2);
                Keeper.keepPersonInfo(readPersonInfo);
                Utils.a(this.x, Keeper.readPersonInfo());
            }
        }
    }

    private boolean j() {
        String str = Keeper.readBraceletBtInfo().b;
        List<String> c = B.a().c();
        if (c != null) {
            for (String str2 : c) {
                C0596r.d(v, "miui service bound device:" + str2);
                if (!str2.equalsIgnoreCase(str)) {
                    B.a().a(str2);
                }
            }
        }
        return true;
    }

    private boolean k() {
        boolean z = this.y || this.z;
        if (!Utils.n(this)) {
            return false;
        }
        if (!DeviceSource.hasBindSensorHub()) {
            o();
        }
        d();
        if (z) {
            cn.com.smartdevices.bracelet.h.a.a().a(this.x, new F(this.x, true));
        }
        return true;
    }

    private boolean l() {
        com.xiaomi.hm.health.bt.profile.Weight.f i = com.xiaomi.hm.health.bt.bleservice.a.i();
        return i != null && i.u();
    }

    private void m() {
        if (this.F == null) {
            this.F = new g().a(com.xiaomi.hm.health.bt.profile.Weight.a.y_).a((h) this).a(-1).a();
        }
        if (DeviceSource.hasBindWeight()) {
            if (((!a(this.x) ? 1 : 0) | this.D) != 0) {
                C0596r.d(v, "start scan for weight");
                this.D = false;
                this.E.a(this.x, this.F);
                this.u.sendEmptyMessageDelayed(p, 30000);
            }
        }
    }

    private void n() {
        C0596r.d(v, "stop scan for weight");
        if (this.F != null) {
            this.E.a(this.F);
            this.F = null;
        }
        this.u.sendEmptyMessage(q);
    }

    private void o() {
        cn.com.smartdevices.bracelet.h.e eVar = new cn.com.smartdevices.bracelet.h.e(System.currentTimeMillis(), 1, 0);
        DeviceSource.bindSensorHub(eVar);
        cn.com.smartdevices.bracelet.h.a.a().a(eVar);
        p();
        e();
    }

    private void p() {
        j.a(getApplicationContext(), l.a(getApplicationContext(), 2), new C0817r(this), true);
    }

    private void q() {
        this.u = new C0818s(this);
        this.w = new C0820u(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(BLEService.b);
        intentFilter.addAction(BLEService.e);
        intentFilter.addAction(BLEService.f);
        intentFilter.addAction(BLEService.h);
        intentFilter.addAction(BLEService.c);
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction(BLEService.g);
        intentFilter.addAction(BLEService.d);
        intentFilter.addAction(BLEService.d);
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.w, intentFilter);
    }

    private void r() {
        g(false);
    }

    private void s() {
        com.xiaomi.hm.health.bt.profile.a.j a = com.xiaomi.hm.health.bt.bleservice.a.a();
        if (a != null) {
            a.a(new C0821v(this));
        }
    }

    private void t() {
        aT e = new aT(this).a((int) k.app_icon).a(getString(r.bracelet_notify_title)).b(getString(r.bracelet_notify_text)).e(true);
        e.a(new long[]{100, 500, 500, 500});
        e.a(PendingIntent.getBroadcast(this, 0, new Intent(kankan.wheel.widget.a.bM), 268435456));
        ((NotificationManager) getSystemService("notification")).notify(3, e.c());
    }

    private void u() {
        ((NotificationManager) getSystemService("notification")).cancel(1);
    }

    private void v() {
        Intent intent = new Intent();
        intent.setClass(this, FwLowBatteryActivity.class);
        startActivity(intent);
    }

    private void w() {
        Object obj = null;
        Object obj2 = 1;
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) this.x.getSystemService("connectivity")).getAllNetworkInfo();
        int i = 0;
        while (i < allNetworkInfo.length) {
            if (allNetworkInfo[i].getType() != 1) {
                int i2;
                if (allNetworkInfo[i].getType() != 9) {
                    if (allNetworkInfo[i].getType() == 0 && allNetworkInfo[i].isConnected()) {
                        obj2 = null;
                        i2 = 1;
                        break;
                    }
                } else if (allNetworkInfo[i].isConnected()) {
                    obj2 = null;
                    i2 = 1;
                    break;
                }
            } else if (allNetworkInfo[i].isConnected()) {
                obj = 1;
                break;
            }
            i++;
        }
        obj2 = null;
        if (obj != null) {
            if (obj2 != null) {
                x();
            }
            C();
        }
    }

    private void x() {
        if (Keeper.readPersonInfoBaseNeedSync().getNeedSyncServer() != 0) {
            C0596r.e(v, "Sync person info when net connected");
            Utils.a(this.x, Keeper.readPersonInfo());
        }
        Utils.u(this.x);
        EventBus.getDefault().post(new EventWifiConnected());
    }

    private void y() {
        Calendar instance = Calendar.getInstance();
        if (Keeper.readSyncTime(C0591m.a().r()) > -1) {
            instance.setTimeInMillis(Keeper.readSyncTime(C0591m.a().r()));
        }
        Calendar instance2 = Calendar.getInstance();
        if (instance.get(6) != instance2.get(6)) {
            C0401a.a(this.x, C0401a.el, instance2.get(11));
        }
    }

    private void z() {
        C0401a.a(this.x, C0409b.aw);
        com.xiaomi.hm.health.bt.bleservice.a.a(new L(this.x), Keeper.readPersonInfo().uid);
    }

    protected void a() {
        C0596r.d(v, "=================onEnterInForeground=================");
        this.y = false;
        this.K = false;
        this.I = System.currentTimeMillis();
    }

    protected void a(int i) {
    }

    public void a(f fVar) {
    }

    public void a(com.xiaomi.hm.health.bt.model.e eVar, f fVar) {
        if (this.u != null && Keeper.readWeightHwInfo().address.equalsIgnoreCase(eVar.a.getAddress())) {
            this.u.sendEmptyMessage(q);
            if (!this.L) {
                C0596r.d(v, "connectWeightDevice:" + eVar);
                com.xiaomi.hm.health.bt.bleservice.a.a(eVar.a, false);
                this.J = System.currentTimeMillis();
                if (!this.u.hasMessages(o)) {
                    this.u.sendEmptyMessageDelayed(o, d.g);
                }
            }
            if (eVar.n != null) {
                EventBus.getDefault().post(eVar.n);
            }
        }
    }

    public boolean a(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            C0596r.d(v, "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    boolean a(boolean z) {
        return a(z, false);
    }

    protected void b() {
        C0596r.d(v, "=================onEnterInBackground=================");
        if (this.y) {
            C0596r.d(v, "has onEnterInBackground,now return!!!");
            return;
        }
        this.y = true;
        this.A = false;
        this.L = false;
        n();
        if (0 == this.I || this.J <= this.I) {
            C0596r.e(v, "connect device fail...");
            C0401a.a(this.x, C0401a.fO, WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
        } else {
            C0596r.e(v, "connect device time " + this.J + " mStartTime " + this.I);
            C0401a.a(this.x, C0401a.fO, com.xiaomi.e.a.f + (this.J - this.I));
        }
        this.I = 0;
        if (this.b != null) {
            this.b.enableFwUpgrade();
        }
    }

    protected void b(int i) {
    }

    public void b(f fVar) {
    }

    protected void b(boolean z) {
    }

    protected void c() {
    }

    public boolean c(boolean z) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.isEnabled()) {
            return true;
        }
        if (!z && this.A) {
            return false;
        }
        if (com.xiaomi.hm.health.bt.bleservice.a.l()) {
            return true;
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), c);
        this.D = true;
        return false;
    }

    protected void d() {
    }

    protected void e() {
    }

    protected void f() {
        C0596r.e(v, "onWeightScanTimeout");
        EventBus.getDefault().post(new EventScaleStatus(PersonInfo.INCOMING_CALL_DISABLE_BIT));
    }

    protected void g() {
        C0596r.e(v, "onWeightFound");
        EventBus.getDefault().post(new EventScaleStatus(EventScaleStatus.SCALE_FOUNDED));
        this.u.removeMessages(p);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0596r.e(v, "onActivityResult:" + i);
        if (i == c) {
            switch (i2) {
                case kankan.wheel.widget.a.b.a /*-1*/:
                    this.A = false;
                    return;
                case kankan.wheel.widget.a.i /*0*/:
                    com.huami.android.view.b.a((Context) this, getString(r.failed_enable_bt), 1).show();
                    this.A = true;
                    EventBus.getDefault().post(new EventBtOnOff(1));
                    return;
                default:
                    return;
            }
        } else if (i == d) {
            this.B = false;
        } else if (i == e) {
            this.B = false;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0596r.d(v, "onCreate...");
        this.x = getApplicationContext();
        this.b = FwUpgradeManager.getDefault(this.x);
        this.b.enableFwUpgrade();
        this.z = true;
        this.C = (DeviceSource.hasBindBracelet() | DeviceSource.hasBindShoesDevice()) | DeviceSource.hasBindSensorHub();
        b((Context) this);
        q();
        a(0, 0);
        EventBus.getDefault().register(this);
        J.c(this.x);
        J.d(this.x);
        z.c(this.x);
        i.b(this.x);
    }

    protected void onDestroy() {
        unregisterReceiver(this.w);
        C0596r.d(v, "onDestory..........................................");
        this.u.removeCallbacksAndMessages(null);
        this.u = null;
        this.A = false;
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEventBackgroundThread(e eVar) {
        C0596r.e(v, "onEvent WeightAdvData:" + eVar);
        C0596r.e("BOOL", "onBaseSCActivity MemberInfoSetWeightActivity.isUserWeighting " + MemberInfoSetWeightActivity.h + " BabyWeightActivity.isAdultWithBabyWeighting " + BabyWeightActivity.b + " BabyWeightActivity.isAdultWeighting " + BabyWeightActivity.a);
        if (MemberInfoSetWeightActivity.h || BabyWeightActivity.b || BabyWeightActivity.a) {
            C0596r.e(v, "MemberInfoSetWeightActivity is running and here do nothing");
        } else if (eVar != null) {
            a(eVar);
        }
    }

    public void onEventMainThread(EventDeviceBoundState eventDeviceBoundState) {
        int i;
        C0596r.d(v, "EventDeviceBoundState:" + eventDeviceBoundState);
        int i2 = eventDeviceBoundState.mType;
        boolean z = eventDeviceBoundState.mState == 1;
        switch (i2) {
            case kankan.wheel.widget.a.i /*0*/:
                LuaEvent.getInstance(this.x).deleteLuaOfStepAssociatedItem();
                if (z) {
                    EventBus.getDefault().postSticky(new HwConnStatus(com.xiaomi.hm.health.bt.bleservice.a.c() ? 6 : 4));
                }
                this.G = z;
                i = 0;
                break;
            case kankan.wheel.widget.l.a /*1*/:
                i = 1;
                break;
            case kankan.wheel.widget.a.l /*3*/:
                i = 2;
                if (!DeviceSource.hasBindBracelet()) {
                    LuaEvent.getInstance(this.x).deleteLuaOfStepAssociatedItem();
                }
                this.H = z;
                break;
            default:
                i = 0;
                break;
        }
        this.b.setUpgradeState(i, true);
        if (z) {
            a(i2);
        } else {
            b(i2);
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    protected void onPause() {
        this.z = false;
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        com.xiaomi.hm.health.bt.bleservice.a.b(this.x, Keeper.readBraceletBtInfo().b, Utils.p());
        h();
        if (this.y || this.z) {
            a();
        }
    }

    protected void onStop() {
        super.onStop();
        this.z = false;
        if (a((Context) this)) {
            this.u.sendEmptyMessage(r);
        }
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
    }
}
