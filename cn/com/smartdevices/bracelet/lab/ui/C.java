package cn.com.smartdevices.bracelet.lab.ui;

import android.view.View;
import android.view.View.OnClickListener;

class C implements OnClickListener {
    final /* synthetic */ SportAnalyserActivity a;

    C(SportAnalyserActivity sportAnalyserActivity) {
        this.a = sportAnalyserActivity;
    }

    public void onClick(View view) {
        this.a.n.setEnabled(false);
        this.a.g.a();
        this.a.c(2);
        this.a.G = true;
        this.a.d(false);
        this.a.finish();
    }
}
