package cn.com.smartdevices.bracelet.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.xiaomi.channel.b.v;

class dO implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ View b;
    final /* synthetic */ SettingActivity c;

    dO(SettingActivity settingActivity, View view, View view2) {
        this.c = settingActivity;
        this.a = view;
        this.b = view2;
    }

    public void run() {
        Rect rect = new Rect();
        this.a.getHitRect(rect);
        rect.left -= 200;
        rect.top -= 200;
        rect.right += v.C;
        rect.bottom += v.C;
        this.b.setTouchDelegate(new TouchDelegate(rect, this.a));
    }
}
