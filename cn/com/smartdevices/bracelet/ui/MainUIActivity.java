package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0563k;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0891z;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.DynamicManager;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.d.C0425b;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.eventbus.EventApkupgrade;
import cn.com.smartdevices.bracelet.eventbus.EventBtOnOff;
import cn.com.smartdevices.bracelet.eventbus.EventDynamicDetailSleepUserModified;
import cn.com.smartdevices.bracelet.eventbus.EventGameUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventGoalsUpdated;
import cn.com.smartdevices.bracelet.eventbus.EventHomeListLoad;
import cn.com.smartdevices.bracelet.eventbus.EventLuaUpdated;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdateUnit;
import cn.com.smartdevices.bracelet.eventbus.EventTimeChanged;
import cn.com.smartdevices.bracelet.eventbus.EventUseManualLazyDay;
import cn.com.smartdevices.bracelet.eventbus.EventWeightTargetUpdated;
import cn.com.smartdevices.bracelet.eventbus.EventWeightWithUser;
import cn.com.smartdevices.bracelet.eventbus.weight.EventUserChanged;
import cn.com.smartdevices.bracelet.eventbus.weight.EventUserDeleted;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightChanged;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightSyncedDevice;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightSyncedServer;
import cn.com.smartdevices.bracelet.honor.MedalManager;
import cn.com.smartdevices.bracelet.location.e;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.lua.LuaListAdapter;
import cn.com.smartdevices.bracelet.lua.MyListView;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.LayoutParams;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener;
import cn.com.smartdevices.bracelet.model.LuaItem;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ThirdTokenState;
import cn.com.smartdevices.bracelet.model.game.GameManager;
import cn.com.smartdevices.bracelet.partner.Partner;
import cn.com.smartdevices.bracelet.partner.PartnerDataManager;
import cn.com.smartdevices.bracelet.push.h;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import cn.com.smartdevices.bracelet.tencent.health.QQHealth;
import cn.com.smartdevices.bracelet.upgrade.FwUpgradeManager;
import cn.com.smartdevices.bracelet.weather.WeatherManager;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.huami.android.ui.a;
import com.huami.android.view.c;
import com.huami.android.widget.share.ShareDataManager;
import com.huami.android.widget.share.m;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.model.HwBatteryStatus;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.HwSyncDataStatus;
import com.xiaomi.mistatistic.sdk.d;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;

public class MainUIActivity extends BaseSCActivity implements OnClickListener {
    private static final int I = 0;
    private static final int J = 1;
    private static final int K = 60000;
    private static final int L = 272;
    private static final int M = 273;
    private static final int N = 274;
    private static final int O = 0;
    private static final int P = 2;
    private static final int Q = 3;
    private static final int R = 378;
    private static final int S = 33;
    private static final int T = 33;
    private static final int U = 100;
    public static final int b = 2000;
    public static final int c = 520;
    private static final String d = "MainUIActivity";
    private static final int e = 5;
    private static final boolean f = false;
    private MedalManager A;
    private ShareDataManager B;
    private FwUpgradeManager C;
    private long D = -1;
    private Context E;
    private final b F = b.h();
    private boolean G;
    private Resources H = null;
    private SlidingUpPanelLayout V;
    private View W;
    private View X;
    private View Y;
    private ImageView Z;
    private int aA = -1;
    private int aB = O;
    private ProgressBar aa;
    private TextView ab;
    private TextView ac;
    private MyListView ad;
    private TextView ae;
    private LuaListAdapter af;
    private boolean ag = true;
    private float ah = 1.0f;
    private int ai = -1;
    private boolean aj;
    private float ak = 1.3f;
    private final float al = 1.27f;
    private int am = m.n;
    private int an = 1150;
    private int ao = U;
    private int ap = v.C;
    private int aq = 400;
    private final float ar = 800.0f;
    private boolean as;
    private boolean at;
    private boolean au;
    private boolean av;
    private ValueAnimator aw;
    private ValueAnimator ax;
    private ValueAnimator ay;
    private final PanelSlideListener az = new bV(this);
    private View g;
    private View h;
    private TextView i;
    private TextView j;
    private C0694ax k;
    private bH l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private Handler r;
    private HwSyncDataStatus s = new HwSyncDataStatus();
    private BroadcastReceiver t;
    private h u;
    private e v;
    private WeatherManager w;
    private GameManager x;
    private PartnerDataManager y;
    private HwConnStatus z = new HwConnStatus();

    private void A() {
        if (!this.q) {
            if (DeviceSource.hasBindBracelet() || DeviceSource.hasBindShoesDevice()) {
                this.r.sendEmptyMessage(M);
            }
        }
    }

    private void B() {
        updateTitle(R.string.battery_low_info);
    }

    private void C() {
        Intent intent = new Intent(this, StatisticActivity.class);
        intent.putExtra(ChartData.KEY_MODE, ChartData.a().u());
        startActivity(intent);
        if (ChartData.a().u() == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            C0401a.a(this.E, C0401a.fR);
        }
        if (ChartData.a().u() == J && C0591m.a().r() == Q) {
            C0401a.a(this.E, C0409b.bE);
        }
    }

    private void D() {
        if (!this.m) {
            Bitmap drawingCache;
            this.m = true;
            if (this.l == null) {
                this.l = (bH) Fragment.instantiate(this.E, bH.class.getName());
                this.l.a(new C0749cy(this));
            }
            C0596r.e(d, "CurrentMode() " + ChartData.a().u());
            C0596r.e(d, "LastShownData().userId " + this.k.g().c);
            C0596r.e(d, "LastShownData().advData.toJsonString() " + this.k.g().a.n());
            Bundle bundle = new Bundle();
            if (this.k.f().c == 0) {
                bundle.putInt(ChartData.KEY_MODE, ChartData.a().u());
                bundle.putInt(ChartData.l, this.k.g().c);
                bundle.putString(ChartData.m, this.k.g().a.n());
            } else {
                bundle.putInt(ChartData.KEY_MODE, ChartData.a().u());
                bundle.putInt(ChartData.l, this.k.f().c);
                bundle.putString(ChartData.m, this.k.f().a.n());
            }
            this.l.setArguments(bundle);
            View decorView;
            if (a.b(this.E)) {
                decorView = getWindow().getDecorView();
                decorView.buildDrawingCache();
                drawingCache = decorView.getDrawingCache();
            } else {
                decorView = findViewById(16908290);
                if (decorView != null) {
                    decorView.buildDrawingCache();
                    drawingCache = decorView.getDrawingCache();
                } else {
                    drawingCache = null;
                }
            }
            this.l.a(drawingCache);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.addToBackStack(null);
            this.l.show(beginTransaction, null);
            C0401a.a((Context) this, C0401a.df);
        }
    }

    private void E() {
        f(true);
        this.am = O;
        this.an = (int) Utils.b(378.0f, (Context) this);
        this.ao = (int) Utils.b(33.0f, (Context) this);
        this.ap = (int) Utils.b(33.0f, (Context) this);
        this.aq = (int) Utils.b((float) CropOverlayView.a, (Context) this);
        this.W = findViewById(R.id.backView);
        this.X = findViewById(R.id.dragView);
        this.Y = findViewById(R.id.msgDV);
        this.Z = (ImageView) findViewById(R.id.rightArrow);
        this.aa = (ProgressBar) findViewById(R.id.progressBar1);
        this.ab = (TextView) findViewById(R.id.tMsg1);
        this.ac = (TextView) findViewById(R.id.tMsg2);
        this.ad = (MyListView) findViewById(R.id.lv2);
        this.ae = (TextView) findViewById(R.id.listMsg);
        G();
        F();
        this.W.setBackgroundColor(O);
        this.Y.setX((float) this.am);
        this.Y.setY((float) this.an);
        this.Y.setVisibility(O);
        if (this.k != null) {
            this.k.b();
        }
    }

    private void F() {
        fg a = new fe(this).a();
        if (a.d()) {
            int e = a.e();
            int dimensionPixelSize = this.H.getDimensionPixelSize(R.dimen.main_ui_panel_height);
            C0596r.e(d, "SlidingPanel SystemBarH : " + e + ", OriginalPanelH : " + dimensionPixelSize);
            this.V.setPanelHeight(dimensionPixelSize - e);
            dimensionPixelSize = this.H.getDimensionPixelSize(R.dimen.main_ui_dragview_height);
            C0596r.e(d, "SlidingPanel DragViewH : " + dimensionPixelSize);
            this.X.setLayoutParams(new LayoutParams(-1, dimensionPixelSize - e));
            this.ak = 1.3f;
            this.ao = (int) Utils.b(55.0f, (Context) this);
        }
        if (t.d(this)) {
            this.V.setPanelHeight((int) t.a((Context) this, 250.0f));
        }
    }

    private void G() {
        this.af = new LuaListAdapter(this, null);
        this.ad.setAdapter(this.af);
        this.ad.setParentPanelLayout(this.V);
        this.V.setListAdapter(this.af);
    }

    private void H() {
        d(false);
    }

    private void I() {
        e(false);
    }

    private void J() {
        if (this.ax != null && this.ax.isStarted()) {
            this.ax.end();
        }
        float b = Utils.b(36.0f, (Context) this);
        float[] fArr = new float[P];
        fArr[O] = 0.0f;
        fArr[J] = 2900.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        this.ax = ofFloat;
        ofFloat.setDuration((long) 1161117696);
        ofFloat.addListener(new bW(this, b));
        ofFloat.addUpdateListener(new bX(this, b));
        ofFloat.start();
    }

    private void K() {
        a(1.27f);
    }

    private boolean L() {
        if (!this.as) {
            return false;
        }
        if (this.at) {
            return true;
        }
        this.at = true;
        this.r.sendEmptyMessageDelayed(L, d.g);
        return true;
    }

    private boolean M() {
        if (!this.as) {
            return false;
        }
        this.at = false;
        this.au = false;
        this.r.removeMessages(L);
        return true;
    }

    private void N() {
        this.aw = ValueAnimator.ofFloat(new float[]{0.0f, 800.0f});
        this.aw.setDuration(500);
        this.aw.setInterpolator(new DecelerateInterpolator());
        this.aw.addListener(new C0698bY(this));
        this.aw.addUpdateListener(new bZ(this));
        this.aw.start();
    }

    private void O() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setDuration(300);
        ofFloat.addListener(new C0725ca(this));
        ofFloat.addUpdateListener(new C0726cb(this));
        ofFloat.start();
    }

    private void P() {
        if (this.ay != null) {
            if (!this.ay.isStarted()) {
                this.ay.start();
            } else {
                return;
            }
        }
        this.ay = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.ay.setDuration(100);
        this.ay.addListener(new C0727cc(this));
        this.ay.addUpdateListener(new C0728cd(this));
        this.ay.start();
    }

    private void Q() {
        if (S() || R()) {
            T();
            U();
            V();
            return;
        }
        LuaEvent.getInstance(this).setDefaultMsgs();
        H();
    }

    private boolean R() {
        return Keeper.read24HourFormat() != DateFormat.is24HourFormat(this);
    }

    private boolean S() {
        String readLocaleStr = Keeper.readLocaleStr();
        if (com.xiaomi.e.a.f.equals(readLocaleStr)) {
            readLocaleStr = Keeper.keepLocaleStr();
        }
        if (readLocaleStr.equals(Locale.getDefault().toString())) {
            return false;
        }
        C0596r.e(d, "set locale when changed");
        return true;
    }

    private void T() {
        Keeper.keepLocaleStr();
        LuaEvent.getInstance(this).setLocale(Locale.getDefault().toString());
    }

    private void U() {
        boolean is24HourFormat = DateFormat.is24HourFormat(this);
        LuaEvent.getInstance(this).set24HourFormat(is24HourFormat);
        Keeper.keep24HourFormat(is24HourFormat);
    }

    private void V() {
        C0596r.e(d, "refreshUI");
        Y();
        g(true);
        W();
        h();
    }

    private void W() {
        if (this.w != null && this.v != null) {
            this.j.setText(com.xiaomi.e.a.f);
            this.w.cleanSavedWeatherInfo();
            this.v.d();
            this.v.b(e.b);
        }
    }

    private void X() {
        LuaEvent.getInstance(this).setLocale(Locale.getDefault().toString());
        String luaVersion = LuaEvent.getInstance(this).getLuaVersion();
        String readLatestDBLuaVersion = Keeper.readLatestDBLuaVersion();
        C0596r.e(d, "newVersion = " + luaVersion + ", oldVersion = " + readLatestDBLuaVersion);
        if (kankan.wheel.widget.a.cf.equals(readLatestDBLuaVersion) && luaVersion != null) {
            Keeper.keepLatestDBLuaVersion(luaVersion);
        }
        if (luaVersion != null && luaVersion.compareTo(readLatestDBLuaVersion) > 0) {
            Keeper.keepLatestDBLuaVersion(luaVersion);
            LuaEvent.getInstance(this).resetLuaState();
            g(true);
            C0596r.e(d, "Update LUA to version: " + luaVersion);
        }
    }

    private void Y() {
        if (!this.F.i.a.booleanValue()) {
            return;
        }
        if (GameManager.NEW_GAME.equals(LuaEvent.getInstance(this).getGameInfo())) {
            this.x.processGameEvent(this.E, com.xiaomi.e.a.f);
        } else {
            this.x.processGameEvent(this.E, GameManager.STR_GAME_CLEAR_BANNER);
        }
    }

    private void Z() {
        C0596r.e(d, "updateDynamicListByWeather, aqi level = " + this.aA + ", last aqi = " + this.aB);
        LuaEvent.getInstance(this).setLocale(Locale.getDefault().toString());
        if (this.aA < e) {
            DynamicManager.getInstance().a(this.E, this.aA);
        } else if (this.aA != this.aB) {
            DynamicManager.getInstance().a(this.E, this.aA);
            this.aB = this.aA;
        }
        H();
    }

    private void a(float f) {
        if (this.V == null) {
            C0596r.a(d, "not init layout");
            return;
        }
        C0596r.e(d, "showPullDownMsgs, mIsPulledDown = " + this.aj);
        this.aj = true;
        this.Y.setScaleX(1.0f);
        this.Y.setScaleY(1.0f);
        this.Y.setAlpha(1.0f);
        this.Y.setTranslationY((float) this.an);
        this.ae.setVisibility(8);
        this.V.smoothSlideTo(f, O);
    }

    private void a(Context context, cn.com.smartdevices.bracelet.notification.h hVar) {
        if (hVar.f()) {
            C0401a.a((Context) this, C0401a.eN);
        }
        if (hVar.e()) {
            C0401a.a((Context) this, C0401a.eO);
        }
        for (cn.com.smartdevices.bracelet.notification.a aVar : hVar.c()) {
            C0401a.a(context, C0401a.eP, aVar.a + "_" + (aVar.b ? C0401a.fG : C0401a.fH));
        }
    }

    private void a(Intent intent) {
        if (intent != null) {
            if (!(!intent.getBooleanExtra(Constant.aL, false) || Utils.n(this) || DeviceSource.hasBindDevice())) {
                if (b.h().l.a.booleanValue()) {
                    intent.setClass(this, SelectDevicesActivity.class);
                } else {
                    intent.setClass(this, SearchSingleBraceletActivity.class);
                }
                startActivity(intent);
            }
            String stringExtra = intent.getStringExtra(Constant.aN);
            C0596r.e(d, "open page extra = " + stringExtra);
            if (Constant.cb.equals(stringExtra)) {
                intent.setClass(this, SettingAboutActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean(Constant.aP, true);
                intent.putExtra(Constant.aN, bundle);
                startActivity(intent);
            }
            if (intent.getIntExtra(kankan.wheel.widget.a.bJ, O) == J) {
                startActivity(new Intent(this, SettingActivity.class));
            }
        }
    }

    private void a(HwConnStatus hwConnStatus) {
        boolean z = hwConnStatus.f() || (!hwConnStatus.k() && this.av);
        this.av = z;
        if (this.av) {
            ab();
        } else if (hwConnStatus.k()) {
            ac();
        } else if (hwConnStatus.e()) {
            aa();
        } else {
            L();
            if (!this.au) {
                aa();
            }
        }
    }

    private void a(String str, int i) {
        if (i >= 0) {
            this.ae.setText(str);
            if (i > 0) {
                J();
                this.ae.setOnClickListener(null);
                this.ae.setBackgroundColor(-530995438);
                return;
            }
            this.ae.setVisibility(O);
            this.ae.setOnClickListener(null);
            this.ae.setBackgroundColor(-522095308);
        }
    }

    private void a(String str, String str2) {
        a(str, str2, J, 0.0f);
    }

    private void a(String str, String str2, int i, float f) {
        this.ai = i;
        C0596r.e(d, "enter:" + str + " " + str2 + " type:" + i + "offset: " + f);
        this.ab.setText(str);
        this.ac.setText(str2);
        if (i == 0) {
            float f2 = (float) (this.an - this.ao);
            this.Y.setTranslationY((((f - 1.0f) / (this.ak - 1.0f)) * ((float) this.ap)) + f2);
            if (f < this.ak) {
                this.Y.setScaleX(1.0f);
                this.Y.setScaleY(1.0f);
                this.Y.setAlpha(1.0f);
            }
            this.Z.setVisibility(O);
            this.Z.setImageResource(R.drawable.pulldown);
            this.aa.setVisibility(8);
            this.ab.setTextColor(-11184811);
            this.ac.setTextColor(-6316129);
        } else if (i == P || i == Q) {
            LuaEvent.getInstance(this.E).setConnectStatus(false);
            this.aj = false;
            this.ab.setTextColor(-2143214);
            this.ac.setTextColor(-1400947);
            this.Z.setVisibility(O);
            this.Z.setImageResource(R.drawable.pulldown2);
            this.aa.setVisibility(8);
            K();
        } else {
            this.ab.setTextColor(-11184811);
            this.ac.setTextColor(-6316129);
            K();
            this.Z.setVisibility(4);
            this.aa.setVisibility(O);
        }
    }

    private void aa() {
        e((int) J);
        if (this.k != null) {
            this.k.a(Boolean.valueOf(true));
        }
    }

    private void ab() {
        e((int) O);
        if (this.k != null) {
            this.k.a(Boolean.valueOf(true));
        }
    }

    private void ac() {
        LuaEvent.getInstance(this).setConnectStatus(true);
        d(true);
        M();
        this.ae.setVisibility(8);
        if (this.k != null) {
            this.k.a(Boolean.valueOf(false));
        }
        this.r.sendEmptyMessageDelayed(N, 1000);
    }

    private void ad() {
        ae();
        af();
    }

    private void ae() {
        Object readPushIntentUri = Keeper.readPushIntentUri();
        if (!TextUtils.isEmpty(readPushIntentUri)) {
            try {
                startActivity(Intent.parseUri(readPushIntentUri, O));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
            Keeper.keepPushIntentUri(com.xiaomi.e.a.f);
        }
    }

    private void af() {
        String readLuaItem = Keeper.readLuaItem();
        if (TextUtils.isEmpty(readLuaItem)) {
            C0596r.e(d, "luaItem is empty");
            return;
        }
        LuaItem luaItem;
        try {
            luaItem = (LuaItem) Utils.c().a(readLuaItem, LuaItem.class);
        } catch (Exception e) {
            luaItem = null;
        }
        if (luaItem != null) {
            LuaEvent.getInstance(this).showLuaItem(luaItem);
            H();
            Keeper.keepLuaItem(com.xiaomi.e.a.f);
        }
    }

    private void ag() {
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        WeightInfo a = ah.a().a(-1, (int) O);
        if (a == null) {
            C0596r.e("PERSON_WEIGHT", "info is null ");
        } else if (a.weight == readPersonInfo.weight) {
            C0596r.e("PERSON_WEIGHT", "person info not updated");
        } else {
            C0596r.e("PERSON_WEIGHT", "upload person info weight " + a.weight);
            readPersonInfo.weight = a.weight;
            readPersonInfo.setNeedSyncServer(P);
            Keeper.keepPersonInfo(readPersonInfo);
        }
    }

    private void b(HwConnStatus hwConnStatus) {
        if (hwConnStatus.e()) {
            C0596r.e(d, "Ble Status : Is searching!!");
            aa();
        } else if (hwConnStatus.f()) {
            ab();
        } else if (hwConnStatus.k()) {
            ac();
        } else {
            L();
            if (!this.au) {
                aa();
            }
        }
    }

    private void d(boolean z) {
        C0596r.e(d, "refreshListAndDetectBlank forceRefresh= " + z);
        if (this.af == null) {
            C0596r.e(d, "UI is not ready!");
            return;
        }
        this.af.refreshList();
        int newItemCount = this.af.getNewItemCount();
        C0596r.e(d, "newItemCount:" + newItemCount);
        if (!z && newItemCount > 0 && DeviceSource.hasBindDevice()) {
            Resources resources = this.H;
            Object[] objArr = new Object[J];
            objArr[O] = Integer.valueOf(newItemCount);
            a(resources.getQuantityString(R.plurals.numberOfPullUpdateReport, newItemCount, objArr), (int) P);
        }
    }

    private void e(int i) {
        String str = null;
        int r = C0591m.a().r();
        if (r == Q) {
            Object string = getString(R.string.devices_shoes_label);
        } else {
            String string2 = r == 0 ? getString(R.string.devices_miband_label) : null;
        }
        Object[] objArr;
        if (i == 0) {
            String format;
            Object[] objArr2;
            if (r == Q) {
                str = getString(R.string.shoes_home_tips_connect_failed);
                objArr = new Object[J];
                objArr[O] = string;
                format = String.format(str, objArr);
                str = getString(R.string.shoes_alert_body_connect_failed);
                objArr2 = new Object[J];
                objArr2[O] = string;
                str = String.format(str, objArr2);
            } else if (r == 0) {
                str = getString(R.string.dynamic_pull_connect_failed);
                objArr = new Object[J];
                objArr[O] = string;
                format = String.format(str, objArr);
                str = getString(R.string.dynamic_pull_connect_failed_hint);
                objArr2 = new Object[J];
                objArr2[O] = string;
                str = String.format(str, objArr2);
            } else {
                format = null;
            }
            a(format, str, P, 0.0f);
        } else if (i == J) {
            str = getString(R.string.dynamic_pull_connecting_bracelet);
            objArr = new Object[J];
            objArr[O] = string;
            a(String.format(str, objArr), String.format(getString(R.string.dynamic_pull_sync_after_connected), new Object[O]));
        }
    }

    private void e(boolean z) {
        if (!this.aj && !z) {
            C0596r.e(d, "not pulled down yet");
        } else if (this.V == null) {
            C0596r.a(d, "not init layout");
        } else {
            this.aj = false;
            O();
            H();
        }
    }

    private void f(boolean z) {
        this.as = z;
    }

    private void g(boolean z) {
        C0596r.e(d, "Clear lua db...............");
        C0563k.a().b().deleteAll();
        C0563k.a().c().deleteAll();
        new Thread(new C0729ce(this)).start();
        LuaEvent.getInstance(this).setCurLocale();
        LuaEvent.getInstance(this).setDefaultMsgs(Boolean.valueOf(z));
        d(z);
    }

    private void m() {
    }

    private void n() {
        if (this.F.q.a.booleanValue()) {
            this.A = MedalManager.a();
            this.A.a(getApplicationContext());
        }
    }

    private void o() {
    }

    private void p() {
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        if (readPersonInfo.nickname == null || !readPersonInfo.nickname.isEmpty()) {
            C0596r.e(d, "nick name is not null " + readPersonInfo.nickname);
            return;
        }
        C0596r.e(d, "nick name is empty and give it a new nickname " + cn.com.smartdevices.bracelet.e.a.f(this.E).uid);
        readPersonInfo.nickname = cn.com.smartdevices.bracelet.e.a.f(this.E).uid + com.xiaomi.e.a.f;
        Keeper.keepPersonInfo(readPersonInfo);
    }

    private void q() {
        this.V = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        this.V.setOverlayed(true);
        this.V.setEnableDragViewTouchEvents(true);
        this.V.setPanelSlideListener(this.az);
    }

    private void r() {
        this.t = new C0731cg(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        intentFilter.addAction(kankan.wheel.widget.a.bM);
        intentFilter.addAction(Constant.bZ);
        intentFilter.addAction(kankan.wheel.widget.a.bN);
        intentFilter.addAction(Constant.aY);
        intentFilter.addAction(Constant.bV);
        intentFilter.addAction(Constant.bW);
        intentFilter.addAction(Constant.bX);
        registerReceiver(this.t, intentFilter);
    }

    private void s() {
        int i;
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        List<RunningTaskInfo> runningTasks = activityManager.getRunningTasks(50);
        if (runningTasks != null) {
            i = -1;
            for (RunningTaskInfo runningTaskInfo : runningTasks) {
                ComponentName componentName = runningTaskInfo.baseActivity;
                C0596r.e(d, "recent activity:" + componentName.getClassName());
                i = componentName.getClassName().contains("cn.com.smartdevices.bracelet.ui.MainUIActivity") ? runningTaskInfo.id : i;
            }
        } else {
            i = -1;
        }
        if (i != -1) {
            C0596r.e(d, "move mainUI activity to front");
            activityManager.moveTaskToFront(i, O);
        }
    }

    private void t() {
        this.r = new C0742cr(this);
    }

    private void u() {
        this.g = findViewById(R.id.header_nav_left);
        this.g.setOnClickListener(this);
        this.h = findViewById(R.id.header_nav_right);
        this.h.setOnClickListener(this);
        this.i = (TextView) findViewById(R.id.dynamic_title);
        this.j = (TextView) findViewById(R.id.dynamic_subtitle);
        this.i.setOnClickListener(new C0743cs(this));
        if (t.a()) {
            this.i.setTextSize(14.0f);
        }
    }

    private void v() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        this.k = (C0694ax) Fragment.instantiate(this, C0694ax.class.getName());
        beginTransaction.add(R.id.container, this.k, "DynamicFragment");
        beginTransaction.commit();
        fragmentManager.executePendingTransactions();
        if (DeviceSource.hasBindWeight() && !DeviceSource.hasBindBracelet()) {
            this.k.b((int) PersonInfo.INCOMING_CALL_DISABLE_BIT);
        }
    }

    private void w() {
        X();
        A();
    }

    private void x() {
        if (this.F.d.a.booleanValue()) {
            this.u = h.a(getApplicationContext());
        }
        this.v = e.a(getApplicationContext());
        this.w = WeatherManager.getManager(getApplicationContext());
        this.w.registerLocationChanged();
        this.w.registerWeatherListener(new C0744ct(this));
        this.v.b(e.b);
        if (this.F.c.d.booleanValue()) {
            QQLogin.getInstance(getApplicationContext());
            QQHealth.getInstance(getApplicationContext());
        }
        this.x = new GameManager();
        if (TextUtils.isEmpty(Keeper.readLazyDays())) {
            Utils.c(this.E);
        }
        this.y = new PartnerDataManager(this);
        this.y.loadAvailableServiceList(true);
        this.y.loadHomeMessageList();
        a((Context) this, cn.com.smartdevices.bracelet.notification.h.a((Context) this));
    }

    private void y() {
        if (cn.com.smartdevices.bracelet.lab.h.a()) {
            findViewById(R.id.header_nav_right_new_sign).setVisibility(O);
        } else {
            findViewById(R.id.header_nav_right_new_sign).setVisibility(8);
        }
    }

    private void z() {
        ag();
        Q();
        ad();
        y();
        QQLogin instance = QQLogin.getInstance();
        if (instance != null && instance.isLoginValid()) {
            C0401a.a((Context) this, C0401a.eM);
        }
        if (b.h().l.a.booleanValue()) {
            aA.b(this.E);
        }
        if (b.h().s.a.booleanValue()) {
            new Thread(new C0748cx(this)).start();
        }
        cn.com.smartdevices.bracelet.weibo.v.a().e(getApplicationContext());
    }

    protected void a(int i) {
        super.a(i);
        C0596r.e(d, "onDeviceBonded deviceType " + i);
        if (i == 0 || i == J || i == Q) {
            I();
            if (this.k != null) {
                this.k.d();
            }
        }
        if (i == J && this.k != null) {
            this.k.b((int) PersonInfo.INCOMING_CALL_DISABLE_BIT);
        }
    }

    protected void b(int i) {
        super.b(i);
        if (i == 0 || i == J || i == Q) {
            I();
            if (this.k != null) {
                this.k.d();
            }
        }
        if (i == J && this.k != null) {
            this.k.b((int) J);
        }
    }

    protected void b(boolean z) {
        C0596r.e(d, "updateUI.............");
        d(z);
    }

    protected void c() {
        M();
        LuaEvent.getInstance(this).setDefaultMsgs();
        this.V.setPullDownEnabled(false);
        I();
        if (this.k != null) {
            this.k.e();
        }
        this.z = new HwConnStatus();
    }

    public void c(int i) {
        int i2 = R.string.dynamic_title_weight_unbind;
        int i3 = R.string.dynamic_title_bracelet_unbind;
        if (!this.p || i == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            switch (i) {
                case J /*1*/:
                    if (DeviceSource.hasBindBracelet() || DeviceSource.hasBindShoesDevice()) {
                        i3 = R.string.dynamic_title_step;
                    }
                    updateTitle(i3);
                    return;
                case kankan.wheel.widget.a.bp /*16*/:
                    if (DeviceSource.hasBindBracelet()) {
                        i3 = R.string.dynamic_title_sleep;
                    }
                    updateTitle(i3);
                    return;
                case PersonInfo.INCOMING_CALL_DISABLE_BIT /*256*/:
                    if (this.G) {
                        updateTitle(DeviceSource.hasBindWeight() ? R.string.dynamic_title_weight_not_nearby : R.string.dynamic_title_weight_unbind);
                        return;
                    }
                    if (DeviceSource.hasBindWeight()) {
                        i2 = R.string.dynamic_title_weight;
                    }
                    updateTitle(i2);
                    return;
                default:
                    return;
            }
        }
        B();
    }

    protected void d() {
        super.d();
        C0596r.d(d, "onSensorHub");
        M();
        this.z = new HwConnStatus();
    }

    public void d(int i) {
        ((ImageView) this.g.findViewById(R.id.btn)).setImageResource(i);
    }

    protected void e() {
        super.e();
        C0596r.d(d, "onSensorHubBinded");
        LuaEvent.getInstance(this).setDefaultMsgs();
        I();
        h();
        this.z = new HwConnStatus();
        if (this.k != null) {
            this.k.d();
        }
    }

    protected void f() {
        super.f();
        this.G = true;
        h();
    }

    protected void g() {
        super.g();
        if (this.G) {
            this.G = false;
            h();
        }
    }

    public void h() {
        c(ChartData.a().u());
    }

    protected void i() {
        Keeper.setEnterAppTrace(J);
        Keeper.setActiveHistory(J);
        moveTaskToBack(true);
    }

    public void j() {
        int i;
        if (this.ag) {
            i = O;
        } else {
            i = kankan.wheel.widget.a.aA;
            this.V.smoothSlideTo(1.0f, O);
        }
        this.g.setVisibility(4);
        this.h.setVisibility(4);
        this.Y.setVisibility(4);
        View c = this.k.c();
        int visibility = c.getVisibility();
        c.setVisibility(4);
        this.V.postDelayed(new C0750cz(this, c, visibility), (long) i);
    }

    public void k() {
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.list_fadein));
        layoutAnimationController.setOrder(O);
        layoutAnimationController.setInterpolator(new DecelerateInterpolator());
        layoutAnimationController.setDelay(0.5f);
        this.ad.setLayoutAnimation(layoutAnimationController);
    }

    public void l() {
        new Thread(new C0736cl(this)).start();
    }

    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.D == -1) {
            com.huami.android.view.b.a((Context) this, (int) R.string.app_exit_press_again, (int) O).show();
            this.D = currentTimeMillis;
            this.r.sendEmptyMessageDelayed(c, 2000);
        } else if (currentTimeMillis - this.D < 2000) {
            this.D = -1;
            i();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_nav_left:
                C();
                return;
            case R.id.header_nav_right:
                D();
                return;
            default:
                return;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0596r.e(d, "onConfigurationChanged");
        T();
        V();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.E = this;
        this.H = getResources();
        setContentView((int) R.layout.activity_main);
        disableAutoApplyStatusBarTint();
        if (DeviceSource.hasBindBracelet() || DeviceSource.hasBindShoesDevice()) {
            findViewById(R.id.backView).setBackgroundColor(this.H.getColor(R.color.bg_mode_step));
            applyStatusBarTintRes(R.color.bg_mode_step);
        } else {
            findViewById(R.id.backView).setBackgroundColor(this.H.getColor(R.color.bg_mode_unbind));
            applyStatusBarTintRes(R.color.bg_mode_unbind);
        }
        q();
        r();
        t();
        u();
        this.V.post(new bS(this));
        a(getIntent());
    }

    public void onDestroy() {
        super.onDestroy();
        this.r.removeCallbacksAndMessages(null);
        this.r = null;
        if (this.t != null) {
            unregisterReceiver(this.t);
            this.t = null;
        }
        if (this.F.q.a.booleanValue()) {
            this.A.b();
        }
        C0596r.e(d, "onDestroy");
    }

    public void onEvent(EventApkupgrade eventApkupgrade) {
        C0596r.d(d, "onEvent, force=" + eventApkupgrade.isForceCheck() + " HasWindowfocus=" + hasWindowFocus());
        if (this.n) {
            Utils.b((Activity) this, eventApkupgrade.isForceCheck());
        }
    }

    public void onEvent(EventBtOnOff eventBtOnOff) {
        C0596r.e(d, "onBtOnOff:" + eventBtOnOff.type);
        if (eventBtOnOff.type == J) {
            this.q = true;
            if (this.k != null) {
                this.k.a(Boolean.valueOf(true));
            }
            d(true);
            e((int) O);
        } else if (eventBtOnOff.type == 0 && this.q) {
            this.q = false;
            this.r.sendEmptyMessage(M);
        }
    }

    public void onEvent(EventDynamicDetailSleepUserModified eventDynamicDetailSleepUserModified) {
        new Thread(new C0734cj(this)).start();
    }

    public void onEvent(EventGameUpdate eventGameUpdate) {
        C0596r.e(d, "EventGameUpdate: " + eventGameUpdate);
        LuaEvent.getInstance(this).callLuaFunc("showGameBanner", eventGameUpdate);
        runOnUiThread(new C0732ch(this));
    }

    public void onEvent(EventGoalsUpdated eventGoalsUpdated) {
        C0596r.e(d, "onEvent, EventGoalsUpdated");
        C0591m.a().s();
        Utils.u(this.E);
        l();
    }

    public void onEvent(EventHomeListLoad eventHomeListLoad) {
        if (eventHomeListLoad != null && eventHomeListLoad.success) {
            d(true);
        }
    }

    public void onEvent(EventLuaUpdated eventLuaUpdated) {
        g(true);
    }

    public void onEvent(EventPersonInfoUpdateUnit eventPersonInfoUpdateUnit) {
        g(true);
    }

    public void onEvent(EventUseManualLazyDay eventUseManualLazyDay) {
        c.showPanel((Activity) this, fm.class);
    }

    public void onEvent(EventWeightTargetUpdated eventWeightTargetUpdated) {
        int i = eventWeightTargetUpdated.uid;
        C0596r.e(d, "target weight goal update " + i);
        C0891z.a(this.E).a(i);
        runOnUiThread(new C0740cp(this));
        if (!Utils.w(this.E) && !Utils.x(this.E)) {
            Partner a = C0425b.a(this.E).a("2833961550");
            a.title = getString(R.string.bohee_title);
            a.subTitle = getString(R.string.bohee_subtitle);
            LuaEvent.getInstance(this.E).showLuaItem(PartnerDataManager.buildLuaItem(a));
        }
    }

    public void onEvent(EventUserChanged eventUserChanged) {
        C0596r.e(d, "EventUserChanged : " + eventUserChanged.uid);
        this.k.a(eventUserChanged.uid, true);
    }

    public void onEvent(EventUserDeleted eventUserDeleted) {
        int i = eventUserDeleted.uid;
        C0596r.e(d, "EventUserDeleted " + i);
        this.k.a(i, false);
        runOnUiThread(new C0739co(this));
    }

    public void onEvent(EventWeightChanged eventWeightChanged) {
        C0596r.e(d, "EventWeightChanged : " + eventWeightChanged.uids + ", forceUpdate : " + eventWeightChanged.forceUpdate);
        if (eventWeightChanged.uids != null && eventWeightChanged.uids.length > 0) {
            int[] iArr = eventWeightChanged.uids;
            int length = iArr.length;
            for (int i = O; i < length; i += J) {
                this.k.a(iArr[i], eventWeightChanged.forceUpdate);
            }
        }
        runOnUiThread(new C0738cn(this));
    }

    public void onEvent(EventWeightSyncedDevice eventWeightSyncedDevice) {
        C0596r.e(d, "EventWeightSyncedDevice : " + eventWeightSyncedDevice.forceUpdate + ", " + eventWeightSyncedDevice.uid);
        aA.b((Context) this);
    }

    public void onEvent(EventWeightSyncedServer eventWeightSyncedServer) {
        C0596r.e(d, "EventWeightSyncedServer : " + eventWeightSyncedServer.state);
        if (eventWeightSyncedServer.state == J) {
            this.k.a(false);
        }
    }

    public void onEvent(ThirdTokenState thirdTokenState) {
        runOnUiThread(new C0733ci(this, thirdTokenState));
    }

    public void onEvent(HwBatteryStatus hwBatteryStatus) {
        if (hwBatteryStatus != null) {
            C0596r.e(d, "EventBatteryStatus onEvent: status = " + hwBatteryStatus.e + ", charges =" + hwBatteryStatus.f);
            if (hwBatteryStatus.e == J) {
                this.p = true;
            } else {
                this.p = false;
            }
            h();
        }
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        C0596r.e(d, "HwConnStatus:" + hwConnStatus + ",type = " + hwConnStatus.b());
        if (hwConnStatus.b().b() == C0591m.a().r()) {
            if (!hwConnStatus.b().equals(this.z.b())) {
                this.av = false;
                this.au = false;
            }
            if (this.ae == null || this.k == null) {
                C0596r.e(d, "HwConnStatus: mDynamicListUpdateTip is null" + hwConnStatus);
            } else if (hwConnStatus.b().c()) {
                b(hwConnStatus);
            } else if (com.xiaomi.hm.health.bt.b.c.SHOES.equals(hwConnStatus.b())) {
                a(hwConnStatus);
            }
            this.z = hwConnStatus;
            C0596r.e(d, "out HwConnStatus:" + hwConnStatus);
        }
    }

    public void onEvent(HwSyncDataStatus hwSyncDataStatus) {
        C0596r.e(d, "HwSyncDataStatus:" + hwSyncDataStatus + ",type = " + hwSyncDataStatus.h());
        if (hwSyncDataStatus.h().b() == C0591m.a().r()) {
            this.s = hwSyncDataStatus;
            String string = getString(R.string.dynamic_pull_syncing);
            String str = com.xiaomi.e.a.f;
            if (hwSyncDataStatus.b()) {
                this.r.removeMessages(N);
                Object[] objArr = new Object[J];
                objArr[O] = Integer.valueOf(O);
                a(string, getString(R.string.dynamic_pull_syncing_progress, objArr));
            } else if (hwSyncDataStatus.c()) {
                Object[] objArr2 = new Object[J];
                objArr2[O] = Integer.valueOf(Math.max(O, Math.min(U, hwSyncDataStatus.f())));
                a(string, getString(R.string.dynamic_pull_syncing_progress, objArr2));
            } else if (hwSyncDataStatus.d()) {
                if (hwSyncDataStatus.g()) {
                    I();
                    Y();
                    Z();
                    Utils.u(this.E);
                    C0596r.e(d, "Sync step data to Google Fit");
                } else {
                    a(getString(R.string.dynamic_pull_sync_error), Utils.a((Context) this, (int) R.string.dynamic_pull_last_sync_time), Q, 0.0f);
                }
            }
            C0596r.e(d, "out HwSyncDataStatus");
        }
    }

    public void onEventBackgroundThread(EventWeightWithUser eventWeightWithUser) {
        C0891z.a(this.E).b(J.a().a(eventWeightWithUser.uid), eventWeightWithUser.mWeightAdvData);
        this.k.a(eventWeightWithUser.uid, true);
        runOnUiThread(new C0741cq(this));
    }

    public void onEventMainThread(EventTimeChanged eventTimeChanged) {
        C0596r.e(d, "time changed");
        if (R()) {
            U();
            V();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C0596r.e(d, "onNewIntent:" + intent);
        a(intent);
    }

    protected void onPause() {
        super.onPause();
        C0596r.e(d, "onPause");
        this.n = false;
        if (this.v != null) {
            this.v.d();
        }
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0596r.e(d, "onResume");
        this.n = true;
        this.V.post(new C0745cu(this));
        if (DeviceSource.hasBindBracelet() || DeviceSource.hasBindShoesDevice()) {
            this.V.setPullDownEnabled(true);
        } else {
            this.V.setPullDownEnabled(false);
        }
        C0401a.a((Activity) this);
        if (Utils.g()) {
            C0401a.a((Context) this, C0401a.eK);
        }
        if (Utils.f()) {
            C0401a.a((Context) this, C0401a.eL);
        }
        if (!Keeper.readPersonInfo().getMiliVibrate()) {
            C0401a.a((Context) this, C0401a.eQ);
        }
        if (this.v != null) {
            this.v.b(e.b);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }

    public void onStop() {
        super.onStop();
        getWindow().setWindowAnimations(16973825);
    }

    protected void updateTitle(int i) {
        this.i.setText(i);
    }
}
