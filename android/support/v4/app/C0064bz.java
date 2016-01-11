package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.a.C0113o;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

public class C0064bz implements aI, C0012aJ {
    private Builder a;
    private final Bundle b;
    private List<Bundle> c = new ArrayList();

    public C0064bz(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
        this.a = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & C0113o.h) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
        this.b = new Bundle();
        if (bundle != null) {
            this.b.putAll(bundle);
        }
        if (z3) {
            this.b.putBoolean(C0059bu.a, true);
        }
        if (str != null) {
            this.b.putString(C0059bu.b, str);
            if (z4) {
                this.b.putBoolean(C0059bu.c, true);
            } else {
                this.b.putBoolean(bE.a, true);
            }
        }
        if (str2 != null) {
            this.b.putString(C0059bu.d, str2);
        }
    }

    public Builder a() {
        return this.a;
    }

    public void a(bq bqVar) {
        this.c.add(C0063by.a(this.a, bqVar));
    }

    public Notification b() {
        Notification build = this.a.build();
        Bundle a = C0063by.a(build);
        Bundle bundle = new Bundle(this.b);
        for (String str : this.b.keySet()) {
            if (a.containsKey(str)) {
                bundle.remove(str);
            }
        }
        a.putAll(bundle);
        SparseArray a2 = C0063by.a(this.c);
        if (a2 != null) {
            C0063by.a(build).putSparseParcelableArray(C0059bu.e, a2);
        }
        return build;
    }
}
