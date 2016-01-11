package cn.com.smartdevices.bracelet.weibo;

import android.content.DialogInterface;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.activity.LoginActivity;

class e extends n {
    final /* synthetic */ BindHealthActivity a;

    e(BindHealthActivity bindHealthActivity) {
        this.a = bindHealthActivity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.finish();
        C0401a.a(this.a, C0401a.aK);
    }

    protected void onRightButtonClicked() {
        LoginActivity.a(this.a, new f(this));
    }
}
