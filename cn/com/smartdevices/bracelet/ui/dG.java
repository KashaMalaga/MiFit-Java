package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.view.View.OnLongClickListener;

class dG implements OnLongClickListener {
    final /* synthetic */ dE a;

    dG(dE dEVar) {
        this.a = dEVar;
    }

    public boolean onLongClick(View view) {
        this.a.e();
        return true;
    }
}
