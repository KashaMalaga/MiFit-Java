package cn.com.smartdevices.bracelet.chart.util;

import android.view.View;

final class d implements Runnable {
    final /* synthetic */ View a;

    d(View view) {
        this.a = view;
    }

    public void run() {
        this.a.setVisibility(8);
    }
}
