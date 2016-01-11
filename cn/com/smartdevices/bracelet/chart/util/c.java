package cn.com.smartdevices.bracelet.chart.util;

import android.view.View;

final class c implements Runnable {
    final /* synthetic */ View a;

    c(View view) {
        this.a = view;
    }

    public void run() {
        this.a.setVisibility(4);
    }
}
