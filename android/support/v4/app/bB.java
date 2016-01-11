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

public class bB implements aI, C0012aJ {
    private Builder a;
    private Bundle b;
    private List<Bundle> c = new ArrayList();

    public bB(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
        this.a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & C0113o.h) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
        this.b = new Bundle();
        if (bundle != null) {
            this.b.putAll(bundle);
        }
        if (!(arrayList == null || arrayList.isEmpty())) {
            this.b.putStringArray(aK.M, (String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        if (z4) {
            this.b.putBoolean(C0059bu.a, true);
        }
        if (str != null) {
            this.b.putString(C0059bu.b, str);
            if (z5) {
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
        SparseArray a = C0063by.a(this.c);
        if (a != null) {
            this.b.putSparseParcelableArray(C0059bu.e, a);
        }
        this.a.setExtras(this.b);
        return this.a.build();
    }
}
