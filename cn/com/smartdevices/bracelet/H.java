package cn.com.smartdevices.bracelet;

import android.content.Context;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

abstract class H {
    final /* synthetic */ F a;

    private H(F f) {
        this.a = f;
    }

    protected ArrayList<ArrayList<BasicDateData>> a(ArrayList<BasicDateData> arrayList) {
        ArrayList<ArrayList<BasicDateData>> arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size() - 1;
        int i = 0;
        while (size >= 0) {
            ArrayList arrayList4;
            int i2;
            BasicDateData basicDateData = (BasicDateData) arrayList.get(size);
            Object obj = ((basicDateData.data == null || basicDateData.data.length <= 0) && (basicDateData.dataHR == null || basicDateData.dataHR.length <= 0)) ? null : 1;
            arrayList3.add(basicDateData);
            int i3 = i + 1;
            if (i3 >= 3 || obj != null) {
                arrayList2.add(arrayList3);
                arrayList4 = new ArrayList();
                i2 = 0;
            } else {
                i2 = i3;
                arrayList4 = arrayList3;
            }
            size--;
            i = i2;
            arrayList3 = arrayList4;
        }
        return arrayList2;
    }

    protected void a(Context context, ArrayList<BasicDateData> arrayList, C0595q c0595q) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(((BasicDateData) it.next()).toJSONObject());
        }
        C0596r.d("SyncMiLiDataCB", "sync page to server: " + jSONArray.toString());
        l.a(a.f(context), a.d(context), c0595q, jSONArray.toString(), new I(this.a, arrayList, c0595q));
    }
}
