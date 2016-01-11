package cn.com.smartdevices.bracelet.ui;

import android.text.Html;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.g.d;

class eF implements d {
    final /* synthetic */ ShareActivity a;

    eF(ShareActivity shareActivity) {
        this.a = shareActivity;
    }

    public void a(double d) {
        C0596r.e("TAG", "show ranking = " + d);
        if (d >= 0.0d) {
            this.a.i.setText(Html.fromHtml(Utils.a(this.a, d)));
        }
    }
}
