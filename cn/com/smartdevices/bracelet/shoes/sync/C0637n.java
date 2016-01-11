package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.data.db.b;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.xiaomi.account.openauth.h;

final class C0637n extends ContentObserver {
    final /* synthetic */ C0635l a;

    public C0637n(C0635l c0635l, Context context) {
        this.a = c0635l;
        super(null);
    }

    public void onChange(boolean z, Uri uri) {
        if (uri == null) {
            C0596r.d("SDCM", "onChange uri is null");
            return;
        }
        Object queryParameter = uri.getQueryParameter(g.q);
        String queryParameter2 = uri.getQueryParameter(g.p);
        String queryParameter3 = uri.getQueryParameter(b.e);
        String queryParameter4 = uri.getQueryParameter(g.t);
        String queryParameter5 = uri.getQueryParameter(h.N);
        if (TextUtils.isEmpty(queryParameter)) {
            C0596r.d("SDCM", "onChange mac is null");
        } else {
            this.a.b(this.a.l, new c(queryParameter, queryParameter2, queryParameter4, queryParameter3), queryParameter5);
        }
    }
}
