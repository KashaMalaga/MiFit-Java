package cn.com.smartdevices.bracelet.chart.util;

import android.view.View;

final class e implements Runnable {
    final /* synthetic */ View a;

    e(View view) {
        this.a = view;
    }

    public void run() {
        this.a.setVisibility(0);
    }
}
