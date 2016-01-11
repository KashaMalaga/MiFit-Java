package cn.com.smartdevices.bracelet;

import android.content.Context;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import java.util.ArrayList;

class J extends H {
    final Context b;
    final /* synthetic */ F c;

    public J(F f, Context context) {
        this.c = f;
        super(f);
        this.b = context;
    }

    public void b(ArrayList<String> arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            C0596r.d("SyncMiLiDataCB", "retry date = " + ((String) arrayList.get(i2)));
        }
        if (arrayList != null && arrayList.size() != 0) {
            if (Utils.l(this.b)) {
                C0591m a = C0591m.a();
                C0595q t = C0591m.a().t();
                ArrayList arrayList2 = new ArrayList();
                while (i < arrayList.size()) {
                    BasicDateData b = a.b((String) arrayList.get(i), t);
                    if (b != null) {
                        arrayList2.add(b);
                    }
                    i++;
                }
                if (arrayList2 != null && arrayList2.size() > 0 && F.h) {
                    a(this.b, arrayList2, t);
                    return;
                }
                return;
            }
            C0596r.d("SyncMiLiDataCB", "retry sync , No connected network !");
            C0401a.a(this.b, C0401a.et);
        }
    }
}
