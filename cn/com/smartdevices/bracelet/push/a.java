package cn.com.smartdevices.bracelet.push;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.aT;
import com.xiaomi.hm.health.k;
import java.util.List;
import kankan.wheel.widget.g;
import org.json.JSONObject;

public abstract class a {
    public static final int f = 0;
    public static final int g = 1;
    public final long a;
    public final long b;
    public final int c = a();
    protected Context d;
    public int e;

    public a(Context context, long j, long j2, JSONObject jSONObject) {
        this.a = j2;
        this.b = j;
        this.d = context;
    }

    public abstract int a();

    public void a(String str, String str2, PendingIntent pendingIntent) {
        NotificationManager notificationManager = (NotificationManager) this.d.getSystemService("notification");
        aT aTVar = new aT(this.d);
        aTVar.a((CharSequence) str);
        aTVar.b((CharSequence) str2);
        aTVar.e((CharSequence) str2);
        aTVar.a(pendingIntent);
        aTVar.a((int) k.app_icon_small);
        aTVar.a(this.d.getResources().getColor(g.bg_color_blue), 100, 100);
        aTVar.e(true);
        aTVar.c((int) g);
        notificationManager.notify(this.c, aTVar.c());
    }

    public boolean a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage(this.d.getPackageName());
        List queryIntentActivities = this.d.getPackageManager().queryIntentActivities(intent, f);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public abstract void b();

    public abstract void c();
}
