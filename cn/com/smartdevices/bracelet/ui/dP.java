package cn.com.smartdevices.bracelet.ui;

import android.support.v4.view.bz;
import cn.com.smartdevices.bracelet.chart.util.a;

class dP implements bz {
    final /* synthetic */ SettingActivity_old a;

    dP(SettingActivity_old settingActivity_old) {
        this.a = settingActivity_old;
    }

    public void a(int i) {
    }

    public void a(int i, float f, int i2) {
        if (this.a.d != null) {
            if (i == 0) {
                a.a(this.a.d, f);
            } else if (i == 1 && f == 0.0f) {
                a.a(this.a.d, 1.0f);
            }
        }
        if (f != 0.0f) {
            this.a.e.setAlpha((1.0f - f) + 0.5f);
            this.a.f.setAlpha(0.5f + f);
        }
    }

    public void b(int i) {
    }
}
