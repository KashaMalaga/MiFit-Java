package cn.com.smartdevices.bracelet.relation;

import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.relation.b.e;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import com.d.a.a.h;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.xiaomi.channel.gamesdk.b;
import java.util.ArrayList;
import java.util.Collection;
import kankan.wheel.widget.a;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class B extends h {
    final /* synthetic */ boolean a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ int c;
    final /* synthetic */ boolean d;
    final /* synthetic */ boolean e;
    final /* synthetic */ int f;
    final /* synthetic */ boolean g;
    final /* synthetic */ A h;

    B(A a, boolean z, ArrayList arrayList, int i, boolean z2, boolean z3, int i2, boolean z4) {
        this.h = a;
        this.a = z;
        this.b = arrayList;
        this.c = i;
        this.d = z2;
        this.e = z3;
        this.f = i2;
        this.g = z4;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        if (!this.d) {
            Collection a = this.h.e.a(this.f, this.c);
            if (!(a == null || a.isEmpty())) {
                this.b.addAll(a);
            }
            int i2 = !Utils.l(this.h.c) ? -2 : -1;
            boolean z = this.g;
            if (!z) {
                z = this.b.size() >= this.c;
            }
            this.h.h.post(new e(i2, this.a, z, this.e, this.b));
        }
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        int i2;
        try {
            JSONArray jSONArray = new JSONObject(new String(bArr)).getJSONArray(b.b);
            if (jSONArray != null) {
                if (this.a) {
                    this.h.e.c();
                }
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null) {
                        Friend friend = new Friend();
                        friend.n = jSONObject.optLong(a.n);
                        friend.o = jSONObject.optString(Friend.c);
                        friend.r = jSONObject.optInt(cn.com.smartdevices.bracelet.relation.db.a.c);
                        friend.s = jSONObject.optInt(Friend.f);
                        friend.q = jSONObject.optInt("w");
                        friend.p = jSONObject.optString(cn.com.smartdevices.bracelet.push.e.p);
                        friend.u = jSONObject.optInt("slove");
                        friend.t = jSONObject.optInt("rlove");
                        friend.v = ((long) jSONObject.optInt("update_ts")) * 1000;
                        friend.x = jSONObject.optString(ParamKey.NICK);
                        friend.y = ((long) jSONObject.optInt("addts")) * 1000;
                        this.h.e.b(friend);
                        this.h.d.a(friend.n, friend.c());
                        this.b.add(friend);
                    }
                }
            }
            i2 = 0;
        } catch (JSONException e) {
            i2 = -1;
        }
        boolean z = this.b.size() >= this.c;
        this.h.h.post(this.d ? new e(i2, true, z, false, this.b) : new e(i2, this.a, z, this.e, this.b));
    }
}
