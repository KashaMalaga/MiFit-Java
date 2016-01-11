package cn.com.smartdevices.bracelet.tag;

import android.support.v4.app.aj;
import cn.com.smartdevices.bracelet.tag.a.g;
import java.io.File;
import java.util.List;

class e implements g {
    final /* synthetic */ TagActivity a;

    e(TagActivity tagActivity) {
        this.a = tagActivity;
    }

    public void a(String str) {
        this.a.g.obtainMessage(aj.I, str).sendToTarget();
    }

    public void a(List<File> list) {
        Object obj = (list == null || list.size() == 0) ? "\u6ca1\u6709\u53ef\u4e0a\u4f20\u7684\u6570\u636e" : "\u5f00\u59cb\u4e0a\u4f20\u6570\u636e\uff0c\u8bf7\u4fdd\u6301\u7f51\u7edc\u7545\u901a";
        this.a.g.obtainMessage(aj.I, obj).sendToTarget();
    }

    public void a(boolean z, String str) {
        if (z) {
            this.a.g.obtainMessage(aj.I, "\u4e0a\u4f20\u6210\u529f").sendToTarget();
        } else {
            this.a.g.obtainMessage(aj.I, str).sendToTarget();
        }
    }
}
