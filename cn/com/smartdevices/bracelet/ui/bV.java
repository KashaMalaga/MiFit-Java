package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.F;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener;
import cn.com.smartdevices.bracelet.weight.family.h;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.A;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.HwSyncDataStatus;
import com.xiaomi.mipush.sdk.f;

class bV implements PanelSlideListener {
    final /* synthetic */ MainUIActivity a;

    bV(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public int onGetPullDownDistance() {
        return this.a.aq;
    }

    public Boolean onGetPullDownDockEnable() {
        C0596r.e("MainUIActivity", "res:" + this.a.aj + f.i + this.a.o + f.i + DeviceSource.hasBindDevice());
        return this.a.aj ? Boolean.valueOf(true) : !this.a.o ? Boolean.valueOf(false) : Boolean.valueOf(DeviceSource.hasBindDevice());
    }

    public float onGetThreshhold() {
        return this.a.ak;
    }

    public float onGetThreshhold2() {
        return 1.27f;
    }

    public void onLastSlideOffset(View view, float f) {
        C0596r.e("MainUIActivity", "onLastSlideOffset:  lastOffset " + f);
        if (f > this.a.ak) {
            C0596r.d("MainUIActivity", "\nisBinded:" + Utils.e() + ",isBtOff:" + this.a.q + ",isTimeoutTips:" + this.a.au + ",isConnected:" + a.c() + ",isNeedSyncData:" + this.a.o);
            if (DeviceSource.hasBindBracelet()) {
                HwConnStatus k = a.k();
                if (this.a.q) {
                    this.a.c(true);
                } else if (this.a.au) {
                    this.a.M();
                    this.a.r.sendEmptyMessage(h.d);
                } else if (this.a.o) {
                    new A(new F(this.a.E)).f();
                    C0401a.a(this.a, C0401a.da, C0401a.dc);
                } else if (k.f()) {
                    a.a(null, true, Utils.p());
                    C0401a.a(this.a, C0401a.da, C0401a.dd);
                }
            } else if (DeviceSource.hasBindShoesDevice()) {
                if (this.a.q) {
                    this.a.c(true);
                } else if (this.a.av || this.a.au) {
                    this.a.av = false;
                    this.a.M();
                    this.a.r.sendEmptyMessage(h.d);
                } else if (c.SHOES.equals(this.a.z.b()) && this.a.z.k()) {
                    if (!this.a.a(true)) {
                        this.a.e(true);
                    }
                } else if (this.a.o) {
                    this.a.e(true);
                }
            } else if (DeviceSource.hasBindSensorHub()) {
                cn.com.smartdevices.bracelet.h.a.a().a(this.a.E, new F(this.a.E, true));
            }
            this.a.y.loadHomeMessageList();
        }
    }

    public void onPanelAnchored(View view) {
        C0596r.e("MainUIActivity", "onPanelAnchored");
    }

    public void onPanelCollapsed(View view) {
        C0596r.e("MainUIActivity", "onPanelCollapsed");
        this.a.ag = true;
        this.a.V.setSlidingEnabled(true);
        this.a.ad.setSelectionAfterHeaderView();
    }

    public void onPanelExpanded(View view) {
        C0596r.e("MainUIActivity", "onPanelExpanded");
        this.a.ag = false;
    }

    public void onPanelSlide(View view, Boolean bool, float f) {
        C0596r.e("MainUIActivity", "onPanelSlide, slideOffset=" + f + " Pressed: " + bool);
        if (f <= 1.0f) {
            if (this.a.k != null) {
                this.a.k.a(f);
            }
            if (f == 0.0f) {
                C0401a.a(this.a, C0401a.da, C0401a.db);
            }
        } else {
            this.a.k.a(1.0f);
            if (bool.booleanValue()) {
                this.a.ae.setVisibility(8);
                if (!(this.a.aj && this.a.ai == 1)) {
                    if (f < this.a.ak) {
                        this.a.a(this.a.getString(R.string.dynamic_pull_pull_to_sync), Utils.a(this.a, (int) R.string.dynamic_pull_last_sync_time), 0, f);
                        this.a.Z.setRotation(0.0f);
                    } else {
                        if (this.a.ah < this.a.ak) {
                            this.a.P();
                        }
                        HwSyncDataStatus hwSyncDataStatus = F.b;
                        C0596r.d("MainUIActivity", "hds:" + hwSyncDataStatus + ",status:" + a.c());
                        this.a.o = false;
                        if ((a.c() && !hwSyncDataStatus.e()) || DeviceSource.hasBindSensorHub()) {
                            this.a.o = true;
                        } else if (DeviceSource.hasBindShoesDevice() && c.SHOES.equals(this.a.s.h()) && !this.a.s.e()) {
                            this.a.o = true;
                        }
                        this.a.a(this.a.getString(R.string.dynamic_pull_release_to_sync), Utils.a(this.a, (int) R.string.dynamic_pull_last_sync_time), 0, f);
                    }
                }
            }
        }
        this.a.ah = f;
    }
}
