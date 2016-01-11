package cn.com.smartdevices.bracelet.relation;

import cn.com.smartdevices.bracelet.relation.b.d;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.relation.db.a;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class G extends h {
    final /* synthetic */ long a;
    final /* synthetic */ A b;

    G(A a, long j) {
        this.b = a;
        this.a = j;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        d dVar = new d();
        dVar.c = this.a;
        dVar.a = false;
        this.b.h.post(dVar);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        boolean z = true;
        String str = new String(bArr);
        d dVar = new d();
        dVar.c = this.a;
        dVar.a = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(b.a, -1) != 1) {
                z = false;
            }
            dVar.a = z;
            if (dVar.a) {
                List arrayList = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray(b.b);
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (jSONObject2 != null) {
                            a aVar = new a();
                            aVar.n = jSONObject2.optInt("shallowsleep");
                            aVar.m = jSONObject2.optInt("deepsleep");
                            aVar.l = jSONObject2.optInt(a.c);
                            aVar.o = ((long) jSONObject2.optInt(g.a)) * 1000;
                            aVar.k = this.a;
                            aVar.p = jSONObject2.optInt(a.g);
                            aVar.q = jSONObject2.optInt(a.h);
                            aVar.r = (long) jSONObject2.optInt("startSleep");
                            aVar.s = (long) jSONObject2.optInt("sleepEndTime");
                            this.b.f.a(aVar);
                            arrayList.add(aVar);
                        }
                    }
                }
                Friend a = this.b.e.a(this.a);
                a.w = a.v;
                this.b.e.a(a);
                dVar.b = arrayList;
            } else {
                dVar.a = false;
            }
        } catch (JSONException e) {
            dVar.a = false;
        }
        this.b.h.post(dVar);
    }
}
