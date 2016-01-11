package cn.com.smartdevices.bracelet.tag;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.aj;
import com.huami.android.view.b;
import com.xiaomi.e.a;

class d extends Handler {
    final /* synthetic */ TagActivity a;

    d(TagActivity tagActivity) {
        this.a = tagActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case aj.I /*4097*/:
                String str = (String) message.obj;
                Context context = this.a;
                if (str == null) {
                    str = a.f;
                }
                b.a(context, str, 0).show();
                return;
            default:
                return;
        }
    }
}
