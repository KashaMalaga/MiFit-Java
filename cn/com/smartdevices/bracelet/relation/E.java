package cn.com.smartdevices.bracelet.relation;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.push.e;
import cn.com.smartdevices.bracelet.relation.b.a;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.relation.db.f;
import com.d.a.a.h;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.gamesdk.b;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class E extends h {
    final /* synthetic */ boolean a;
    final /* synthetic */ Context b;
    final /* synthetic */ long c;
    final /* synthetic */ A d;

    E(A a, boolean z, Context context, long j) {
        this.d = a;
        this.a = z;
        this.b = context;
        this.c = j;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        if (this.a) {
            C0401a.a(this.b, C0409b.aV, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
        } else {
            C0401a.a(this.b, C0409b.aW, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
        }
        a aVar = new a();
        aVar.a = -1;
        aVar.c = null;
        aVar.b = this.c;
        aVar.d = this.a;
        this.d.h.post(aVar);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        int optInt;
        JSONException jSONException;
        JSONException jSONException2;
        a aVar;
        if (this.a) {
            C0401a.a(this.b, C0409b.aV, C0410c.t, Constants.VIA_RESULT_SUCCESS);
        } else {
            C0401a.a(this.b, C0409b.aW, C0410c.t, Constants.VIA_RESULT_SUCCESS);
        }
        Friend friend = null;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            optInt = jSONObject.optInt(b.a);
            if (optInt == 1) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray(b.b);
                    if (!(optJSONArray == null || optJSONArray.length() == 0)) {
                        jSONObject = optJSONArray.optJSONObject(0);
                        Friend friend2 = new Friend();
                        try {
                            friend2.n = jSONObject.optLong(kankan.wheel.widget.a.n);
                            friend2.o = jSONObject.optString(Friend.c);
                            friend2.r = jSONObject.optInt(cn.com.smartdevices.bracelet.relation.db.a.c);
                            friend2.s = jSONObject.optInt(Friend.f);
                            friend2.p = jSONObject.optString(e.p);
                            friend2.q = jSONObject.optInt("w");
                            friend2.t = jSONObject.optInt("rlove");
                            friend2.u = jSONObject.optInt("slove");
                            friend2.v = ((long) jSONObject.optInt("update_ts")) * 1000;
                            friend2.x = jSONObject.optString(ParamKey.NICK);
                            friend2.y = System.currentTimeMillis();
                            this.d.e.b(friend2);
                            friend = friend2;
                        } catch (JSONException e) {
                            jSONException = e;
                            friend = friend2;
                            jSONException2 = jSONException;
                            C0596r.a(A.a, jSONException2.toString());
                            aVar = new a();
                            aVar.a = optInt;
                            aVar.b = this.c;
                            aVar.c = friend;
                            aVar.d = this.a;
                            this.d.h.post(aVar);
                        }
                    }
                    f b = this.d.d.b(this.c);
                    if (b != null) {
                        b.v = this.a ? 3 : 2;
                        this.d.d.b(b);
                    }
                } catch (JSONException e2) {
                    jSONException2 = e2;
                    C0596r.a(A.a, jSONException2.toString());
                    aVar = new a();
                    aVar.a = optInt;
                    aVar.b = this.c;
                    aVar.c = friend;
                    aVar.d = this.a;
                    this.d.h.post(aVar);
                }
            }
        } catch (JSONException e3) {
            jSONException = e3;
            optInt = -1;
            jSONException2 = jSONException;
            C0596r.a(A.a, jSONException2.toString());
            aVar = new a();
            aVar.a = optInt;
            aVar.b = this.c;
            aVar.c = friend;
            aVar.d = this.a;
            this.d.h.post(aVar);
        }
        aVar = new a();
        aVar.a = optInt;
        aVar.b = this.c;
        aVar.c = friend;
        aVar.d = this.a;
        this.d.h.post(aVar);
    }
}
