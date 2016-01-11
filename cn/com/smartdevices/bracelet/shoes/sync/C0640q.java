package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.ContentProviderResult;
import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.b.c;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.h;
import cn.com.smartdevices.bracelet.shoes.model.k;
import com.xiaomi.hm.health.dataprocess.UserInfo;
import java.util.ArrayList;
import java.util.List;

final class C0640q {
    private static final String a = "SDP";

    private C0640q() {
    }

    public static boolean a(Context context, List<h> list) {
        if (context == null || list == null) {
            throw new IllegalArgumentException();
        } else if (list.size() == 0) {
            return true;
        } else {
            UserInfo a = c.a();
            List arrayList = new ArrayList(list.size());
            for (h hVar : list) {
                if (hVar == null || TextUtils.isEmpty(hVar.l())) {
                    C0596r.d(a, "Invalid server src date data");
                } else {
                    boolean z;
                    h a2 = t.a(context, hVar.e(), hVar.k(), true);
                    if (a2 == null || a2.c() == null || hVar.c() == null) {
                        a2 = hVar;
                        z = false;
                    } else {
                        a2.a(hVar);
                        z = true;
                    }
                    a2.l(z ? k.STATE_UNSYNCED.a() : k.STATE_SYNCED_FROM_SERVER.a());
                    if (a2.c() != null && a2.c().isNeedParseData() && C0628e.a(a2.c(), a)) {
                        a2.B();
                    }
                    arrayList.add(a2);
                }
            }
            try {
                ContentProviderResult[] a3 = t.a(context, arrayList);
                if (a3 != null && a3.length > 0) {
                    return true;
                }
                C0596r.d("ShoesDateDataMerger", "merger result none");
                return false;
            } catch (Exception e) {
                C0596r.d(a, e.getMessage());
                return false;
            }
        }
    }
}
