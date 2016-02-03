package cn.com.smartdevices.bracelet.gps.ui.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.services.b.o;
import com.d.a.a.O;
import com.xiaomi.channel.relationservice.data.a;
import java.io.File;

public class b {
    private b() {
    }

    public static boolean a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        File b = o.b();
        if (b == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"baochundong@smartdevices.com.cn", "wuhaocheng@smartdevices.com.cn"});
        intent.putExtra("android.intent.extra.SUBJECT", "Send run log");
        intent.putExtra("android.intent.extra.TEXT", "Send run log");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(b));
        intent.setType(O.a);
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            C0596r.a(a.f, e.getMessage());
        }
        return true;
    }
}
