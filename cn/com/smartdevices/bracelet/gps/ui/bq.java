package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.h;

public class bq extends h {
    final /* synthetic */ WatermarkActivity c;

    public bq(WatermarkActivity watermarkActivity, FragmentManager fragmentManager) {
        this.c = watermarkActivity;
        super(fragmentManager);
    }

    public Fragment a(int i) {
        return (Fragment) this.c.G.get(i);
    }

    public int b() {
        return 1;
    }

    public void e(int i) {
    }
}
