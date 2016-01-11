package cn.com.smartdevices.bracelet.relation;

import cn.com.smartdevices.bracelet.relation.b.b;
import com.d.a.a.h;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

class I extends h {
    final /* synthetic */ long a;
    final /* synthetic */ A b;

    I(A a, long j) {
        this.b = a;
        this.a = j;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        b bVar = new b();
        bVar.a = -1;
        bVar.b = this.a;
        this.b.h.post(bVar);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        int optInt;
        try {
            optInt = new JSONObject(new String(bArr)).optInt(com.xiaomi.channel.gamesdk.b.a);
        } catch (JSONException e) {
            optInt = -1;
        }
        b bVar = new b();
        bVar.a = optInt;
        bVar.b = this.a;
        this.b.h.post(bVar);
    }
}
