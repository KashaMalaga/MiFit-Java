package cn.com.smartdevices.bracelet.lab.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.i;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import cn.com.smartdevices.bracelet.model.SyncedServerDataInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

class e {
    private e() {
    }

    static void a(Context context) {
        a(context, 2);
        a(context, new C0595q(2));
        a(context, 1);
        a(context, new C0595q(1));
    }

    static boolean a(Context context, int i) {
        if (SyncedServerDataInfo.readInfoFromPref(i).isSucceededToSaved()) {
            C0596r.e("Sync", "SyncFromServer Initial data saved true, type = " + i);
            return true;
        }
        h hVar = new h();
        i iVar = new i(context, i);
        iVar.j = 3;
        c.a(iVar, cn.com.smartdevices.bracelet.j.e.a(c.a), new g(i, hVar, context));
        return hVar.a;
    }

    static boolean a(Context context, C0595q c0595q) {
        C0591m a = C0591m.a();
        ArrayList a2 = a.a(c0595q);
        if (a2 == null || a2.size() <= 0) {
            C0596r.e("Sync", "syncDataNeededToSyncToSever no data type = " + c0595q.b());
            return true;
        }
        h hVar = new h();
        JSONArray jSONArray = new JSONArray();
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            jSONArray.put(((BasicDateData) it.next()).toJSONObject());
        }
        i iVar = new i(context, c0595q.b());
        if (!iVar.o.isValid()) {
            return false;
        }
        c.a(iVar, cn.com.smartdevices.bracelet.j.e.a(c.b), jSONArray.toString(), null, new f(hVar, context, c0595q, a, a2));
        return hVar.a;
    }
}
