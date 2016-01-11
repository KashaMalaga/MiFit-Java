package cn.com.smartdevices.bracelet.relation;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.push.e;
import cn.com.smartdevices.bracelet.relation.b.g;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import kankan.wheel.widget.a;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

class C extends h {
    final /* synthetic */ A a;

    C(A a) {
        this.a = a;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        g gVar = new g();
        gVar.a = -1;
        this.a.h.post(gVar);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        int optInt;
        JSONException e;
        boolean z = false;
        String str = new String(bArr);
        g gVar = new g();
        try {
            JSONObject jSONObject = new JSONObject(str);
            optInt = jSONObject.optInt(b.a);
            if (optInt == 1) {
                try {
                    jSONObject = jSONObject.optJSONObject(b.b);
                    if (jSONObject != null) {
                        gVar.b = jSONObject.optLong(a.n);
                        gVar.c = jSONObject.optString(Friend.c);
                        gVar.d = jSONObject.optString(e.p);
                        if (jSONObject.optInt(RemarkActivity.a) == 1) {
                            z = true;
                        }
                        gVar.e = z;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    C0596r.a(A.a, e.getMessage());
                    gVar.a = optInt;
                    this.a.h.post(gVar);
                }
            }
        } catch (JSONException e3) {
            JSONException jSONException = e3;
            optInt = 0;
            e = jSONException;
            C0596r.a(A.a, e.getMessage());
            gVar.a = optInt;
            this.a.h.post(gVar);
        }
        gVar.a = optInt;
        this.a.h.post(gVar);
    }
}
