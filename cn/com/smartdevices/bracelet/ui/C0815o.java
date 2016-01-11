package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.view.View.OnClickListener;

class C0815o implements OnClickListener {
    final /* synthetic */ BaseActivity a;

    C0815o(BaseActivity baseActivity) {
        this.a = baseActivity;
    }

    public void onClick(View view) {
        this.a.onHomeBackPressed();
    }
}
