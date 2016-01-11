package cn.com.smartdevices.bracelet.gps.ui;

import android.content.Context;
import android.view.View;
import cn.com.smartdevices.bracelet.gps.algorithm.GaoceptUtils;

class C0498ai {
    private long a = 0;
    private long b = 0;

    C0498ai() {
    }

    public void a(Context context, View view) {
        if (GaoceptUtils.IS_DEBUG) {
            view.setOnClickListener(new C0499aj(this, context));
        }
    }
}
