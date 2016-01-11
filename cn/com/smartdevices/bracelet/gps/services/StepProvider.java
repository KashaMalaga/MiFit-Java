package cn.com.smartdevices.bracelet.gps.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Timer;

abstract class StepProvider {
    protected static final String b = "Step";
    protected ak a = null;
    protected volatile an c = null;
    protected Context d = null;
    protected boolean e = false;
    private HashMap<Timer, al> f = null;
    private boolean g = false;
    private BroadcastReceiver h = null;

    public class HwStatusReceiver extends BroadcastReceiver {
        final /* synthetic */ StepProvider a;

        protected HwStatusReceiver(StepProvider stepProvider) {
            this.a = stepProvider;
        }

        public void onReceive(Context context, Intent intent) {
            if (BLEService.b.equals(intent.getAction())) {
                HwConnStatus hwConnStatus = (HwConnStatus) intent.getParcelableExtra(BLEService.j);
                this.a.a(hwConnStatus);
                C0596r.d(StepProvider.b, "HwStatusReceiver status = " + hwConnStatus + ",type = " + hwConnStatus.b());
            }
        }
    }

    public StepProvider(Context context) {
        a(context, 4);
    }

    public StepProvider(Context context, int i) {
        a(context, i);
    }

    private void a(Context context, int i) {
        this.d = context.getApplicationContext();
        this.c = new an(i);
        this.f = new HashMap();
        this.a = new ak(this);
        this.h = new HwStatusReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BLEService.b);
        context.registerReceiver(this.h, intentFilter);
    }

    private void b(boolean z) {
        this.e = z;
        a(z);
    }

    private void h() {
        if (this.f != null) {
            for (Entry entry : this.f.entrySet()) {
                Timer timer = (Timer) entry.getKey();
                if (timer != null) {
                    timer.cancel();
                }
                if (!(entry.getValue() == null || ((al) entry.getValue()).a == null)) {
                    ((al) entry.getValue()).a.cancel();
                }
            }
            this.f.clear();
        }
    }

    private void i() {
        if (this.c != null) {
            this.c.start();
        } else {
            C0596r.d(b, "start mStatisticStepInfo is null");
        }
        h();
        j();
    }

    private void j() {
        if (this.f != null) {
            for (al put : e()) {
                this.f.put(new Timer(), put);
            }
            for (Entry entry : this.f.entrySet()) {
                al alVar = (al) entry.getValue();
                Timer timer = (Timer) entry.getKey();
                if (!(alVar == null || alVar.a == null)) {
                    try {
                        timer.schedule(alVar.a, alVar.b, alVar.c);
                    } catch (IllegalStateException e) {
                        C0596r.d(b, "startTimerTask e:" + e.getMessage());
                    }
                }
            }
        }
    }

    protected abstract void a(int i, int i2);

    protected abstract void a(int i, long j);

    protected abstract void a(aj ajVar);

    protected abstract void a(HwConnStatus hwConnStatus);

    protected abstract void a(String str);

    protected abstract void a(boolean z);

    public boolean a() {
        if (c()) {
            h();
            this.g = false;
            if (this.a != null) {
                this.a.a();
            }
            if (this.h != null) {
                this.d.unregisterReceiver(this.h);
                this.h = null;
            }
            return true;
        }
        C0596r.d(b, "RtStep.NO_BINDED_DEVICES");
        return false;
    }

    protected abstract String b();

    protected abstract boolean b(int i, int i2);

    protected boolean b(int i, long j) {
        C0596r.d(b, "setBaseRt steps = " + i + ",time = " + j);
        if (i > 0 && j > 0 && this.c != null) {
            this.c.a(i, j);
        }
        return true;
    }

    protected abstract boolean c();

    protected boolean c(int i, int i2) {
        C0596r.d(b, "setBaseMinutes ffsteps = " + i + ",steps = " + i2);
        if (i2 > 0 && this.c != null) {
            this.c.a(i, i2);
        }
        return true;
    }

    protected abstract boolean d();

    protected boolean d(int i, int i2) {
        if (this.c != null && this.g && i2 > 0) {
            return this.c.c(i, i2);
        }
        C0596r.d(b, "ffSteps:" + i + "totalSteps:" + i2 + ",mIsStarted:" + this.g);
        return false;
    }

    protected abstract List<al> e();

    public boolean f() {
        if (c()) {
            b(false);
            if (!this.g) {
                i();
            }
            this.g = true;
            return true;
        }
        C0596r.d(b, "RtStep.NO_BINDED_DEVICES");
        return false;
    }

    protected int g() {
        return this.c != null ? this.c.h() : -1;
    }

    public boolean start() {
        if (c()) {
            b(true);
            if (!this.g) {
                i();
            }
            this.g = true;
            return true;
        }
        C0596r.d(b, "RtStep.NO_BINDED_DEVICES");
        return false;
    }

    protected ap stop() {
        if (!c()) {
            C0596r.d(b, "RtStep.NO_BINDED_DEVICES");
            return null;
        } else if (!this.g) {
            return null;
        } else {
            this.g = false;
            b(false);
            h();
            return this.c != null ? this.c.stop() : null;
        }
    }
}
