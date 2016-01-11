package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.data.db.r;
import java.util.List;

final class C0638o extends ContentObserver {
    final /* synthetic */ C0635l a;

    public C0638o(C0635l c0635l, Context context) {
        this.a = c0635l;
        super(null);
    }

    public void onChange(boolean z, Uri uri) {
        if (uri == null) {
            C0596r.d("SDCM", "onChange uri is null");
            return;
        }
        List pathSegments = uri.getPathSegments();
        C0596r.d("SDCM", "onChange uri = " + uri);
        if (pathSegments != null && pathSegments.size() == 3 && r.k.equals(pathSegments.get(1)) && Integer.valueOf((String) pathSegments.get(2)).intValue() > 0) {
            this.a.d(this.a.l);
            if (this.a.h != null) {
                this.a.h.clear();
            }
        }
    }
}
