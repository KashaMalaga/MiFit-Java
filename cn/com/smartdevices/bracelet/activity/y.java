package cn.com.smartdevices.bracelet.activity;

import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0596r;

class y implements OnClickListener {
    final /* synthetic */ StartUpActivity a;
    private String b;
    private String c;

    public y(StartUpActivity startUpActivity, String str, String str2) {
        this.a = startUpActivity;
        this.b = str;
        this.c = str2;
    }

    public void onClick(View view) {
        this.a.a(this.b, this.c);
        C0596r.d("StartUpActivity", "clickUrl = " + this.b);
        C0596r.d("StartUpActivity", "title = " + this.c);
    }
}
