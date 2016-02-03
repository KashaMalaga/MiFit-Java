package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.C0421k;
import cn.com.smartdevices.bracelet.chart.b.e;
import cn.com.smartdevices.bracelet.chart.base.c;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.dataprocess.ActiveItem;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StageSteps;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import java.util.Calendar;
import java.util.Iterator;

class C0687aq implements C0421k {
    final /* synthetic */ C0681ak a;

    C0687aq(C0681ak c0681ak) {
        this.a = c0681ak;
    }

    public void a(float f, float f2) {
        View view = null;
        if (this.a.N == 16) {
            view = this.a.z;
        } else if (this.a.N == 1) {
            view = this.a.A;
        }
        if (this.a.V == null && this.a.W) {
            this.a.V = this.a.c(view);
            this.a.V.start();
        }
    }

    public void a(int i, c cVar, int i2, float f, float f2) {
        View v;
        if (this.a.N == 16) {
            v = this.a.z;
            this.a.a(cVar, i2, this.a.z);
        } else {
            if (this.a.N == 1) {
                DaySportData g = this.a.I.g(this.a.K);
                StepsInfo stepsInfo = g != null ? g.getStepsInfo() : null;
                if (stepsInfo == null) {
                    stepsInfo = new StepsInfo();
                }
                Iterator it = stepsInfo.getStageSteps().iterator();
                while (it.hasNext()) {
                    StageSteps stageSteps = (StageSteps) it.next();
                    if (stageSteps.time == i) {
                        View w = this.a.A;
                        this.a.a(stageSteps, i * 10, this.a.A);
                        v = w;
                        break;
                    }
                }
            }
            v = null;
        }
        if (v != null) {
            if (this.a.V != null) {
                if (this.a.V.isRunning()) {
                    this.a.V.end();
                } else {
                    this.a.V.cancel();
                }
            }
            if (!this.a.W) {
                v.setVisibility(0);
                this.a.W = true;
                this.a.U = this.a.a(f, f2, v);
                this.a.U.start();
                this.a.h();
            }
        }
    }

    public void a(e eVar) {
        if (this.a.B == null || !this.a.B.j()) {
            C0596r.g("Dynamic.Detail", "Chart Already Detached From UI : onDataLoaded , " + this.a.B);
            return;
        }
        if ((this.a.ag & 2) > 0) {
            int m = this.a.Z / 10;
            int n = ((this.a.aa / 10) - m) + 1;
            for (int i = 0; i < n; i++) {
                this.a.B.d(m + i);
            }
        }
        if (this.a.T != null) {
            this.a.B.c(false);
            this.a.T.start();
        }
    }

    public boolean a(int i) {
        SportDay addDay = this.a.K.addDay(i);
        C0596r.e("Dynamic.Detail", "Has Day : " + addDay);
        if (!addDay.before(this.a.L) && !addDay.after(this.a.M)) {
            return true;
        }
        C0596r.g("Dynamic.Detail", "False!!");
        return false;
    }

    public e b(int i) {
        SportDay addDay = this.a.K.addDay(i);
        C0596r.e("Dynamic.Detail", "Load Data : " + addDay);
        e a = C0681ak.a(this.a.I, addDay, this.a.N);
        String f = addDay.equals(this.a.J) ? "\u4eca\u5929" : addDay.addDay(1).equals(this.a.J) ? "\u6628\u5929" : this.a.b(this.a.K.addDay(i));
        a.a = f;
        a.b = this.a.b(this.a.K.addDay(i - 1));
        return a;
    }

    public void c(int i) {
        if (this.a.B == null || !this.a.B.j()) {
            C0596r.g("Dynamic.Detail", "Chart Already Detached From UI : onToItem , " + this.a.B);
            return;
        }
        SportDay addDay = this.a.K.addDay(i);
        C0596r.e("Dynamic.Detail", "On To : " + addDay);
        DaySportData g = this.a.I.g(addDay);
        if (g != null) {
            SleepInfo sleepInfo;
            StepsInfo stepsInfo;
            if (g != null) {
                sleepInfo = g.getSleepInfo();
                stepsInfo = g.getStepsInfo();
            } else {
                stepsInfo = null;
                sleepInfo = null;
            }
            if (this.a.N == 1) {
                this.a.C.setText(R.string.no_steps);
                this.a.C.setVisibility(8);
                if (stepsInfo == null) {
                    stepsInfo = new StepsInfo();
                    this.a.C.setVisibility(0);
                } else if (stepsInfo.getStepsCount() == 0) {
                    this.a.C.setVisibility(0);
                }
                if ((this.a.ag & 2) > 0) {
                    ActiveItem a = this.a.a(stepsInfo, this.a.Y);
                    if (a != null) {
                        this.a.Z = a.getStart();
                        this.a.aa = a.getStop();
                        this.a.ab = a.getMode();
                        this.a.ac = a.getSteps();
                        this.a.ad = a.getDistance();
                        this.a.a(a, this.a.y);
                    }
                } else {
                    this.a.a(stepsInfo, null, this.a.x);
                }
            } else if (this.a.N == 16) {
                this.a.C.setText(R.string.no_wear_bracelet);
                this.a.C.setVisibility(8);
                if (sleepInfo == null) {
                    sleepInfo = new SleepInfo();
                } else if (!sleepInfo.getHasSleep()) {
                    if (sleepInfo.getSleepCount() == 0) {
                        this.a.C.setText(R.string.no_wear_bracelet);
                    } else {
                        this.a.C.setText(a.f);
                    }
                    this.a.C.setVisibility(0);
                } else if (DeviceSource.hasBindSensorHub()) {
                }
                this.a.B.a(C0681ak.ae, C0681ak.af);
                this.a.a(sleepInfo, sleepInfo.getStartDateMin(), sleepInfo.getStopDateMin(), this.a.w);
            }
            if (this.a.O != com.xiaomi.hm.health.bt.b.c.SENSORHUB.b()) {
                int i2;
                if (g != null) {
                    SleepInfo sleepInfo2 = g.getSleepInfo();
                    i2 = sleepInfo2 != null ? sleepInfo2.getSleepCount() == 0 ? 1 : 0 : 1;
                } else {
                    i2 = 1;
                }
                Calendar instance = Calendar.getInstance();
                if (this.a.N == 16 && r0 != 0 && this.a.K.equals(this.a.M) && instance.get(11) < 5) {
                    this.a.K = this.a.K.addDay(-1);
                    this.a.B.b();
                    this.a.B.b(0);
                }
            }
        }
    }
}
