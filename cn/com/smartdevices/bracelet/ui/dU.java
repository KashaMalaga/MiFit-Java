package cn.com.smartdevices.bracelet.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class dU implements OnEditorActionListener {
    final /* synthetic */ dT a;

    dU(dT dTVar) {
        this.a = dTVar;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (6 != i) {
            return false;
        }
        this.a.onClick(this.a.d);
        return true;
    }
}
