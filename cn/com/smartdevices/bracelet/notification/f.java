package cn.com.smartdevices.bracelet.notification;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.notification.NotificationAppsActivity.PackageIntentReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class f extends AsyncTaskLoader<List<c>> {
    final g a = new g();
    final PackageManager b = getContext().getPackageManager();
    List<c> c;
    PackageIntentReceiver d;

    public f(Context context) {
        super(context);
    }

    public List<c> a() {
        List a = NotificationAppsActivity.a(getContext(), C0113o.h);
        C0596r.e(h.b, "Installed Apps : " + a.size());
        if (a == null) {
            a = new ArrayList();
        }
        Context context = getContext();
        h a2 = h.a(getContext());
        List<c> arrayList = new ArrayList(r0.size());
        for (ApplicationInfo applicationInfo : r0) {
            if (NotificationAppsActivity.b || (applicationInfo.flags & 1) <= 0) {
                c cVar = new c(this, applicationInfo);
                if (a2.c(applicationInfo.packageName)) {
                    cVar.g = true;
                }
                cVar.a(context);
                arrayList.add(cVar);
            }
        }
        Collections.sort(arrayList, NotificationAppsActivity.a);
        return arrayList;
    }

    public void a(List<c> list) {
        if (isReset() && list != null) {
            c(list);
        }
        this.c = list;
        if (isStarted()) {
            super.deliverResult(list);
        }
        if (list != null) {
            c(list);
        }
    }

    public void b(List<c> list) {
        super.onCanceled(list);
        c(list);
    }

    protected void c(List<c> list) {
    }

    public /* synthetic */ void deliverResult(Object obj) {
        a((List) obj);
    }

    public /* synthetic */ Object loadInBackground() {
        return a();
    }

    public /* synthetic */ void onCanceled(Object obj) {
        b((List) obj);
    }

    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (this.c != null) {
            c(this.c);
            this.c = null;
        }
        if (this.d != null) {
            getContext().unregisterReceiver(this.d);
            this.d = null;
        }
    }

    protected void onStartLoading() {
        if (this.c != null) {
            a(this.c);
        }
        if (this.d == null) {
            this.d = new PackageIntentReceiver(this);
        }
        boolean a = this.a.a(getContext().getResources());
        if (takeContentChanged() || this.c == null || a) {
            forceLoad();
        }
    }

    protected void onStopLoading() {
        cancelLoad();
    }
}
