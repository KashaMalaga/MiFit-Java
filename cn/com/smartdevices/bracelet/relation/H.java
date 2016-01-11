package cn.com.smartdevices.bracelet.relation;

import cn.com.smartdevices.bracelet.relation.b.f;
import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

class H extends h {
    final /* synthetic */ long a;
    final /* synthetic */ A b;

    H(A a, long j) {
        this.b = a;
        this.a = j;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        f fVar = new f();
        fVar.a = -1;
        fVar.b = this.a;
        this.b.h.post(fVar);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String str = new String(bArr);
        f fVar = new f();
        fVar.b = this.a;
        try {
            fVar.a = new JSONObject(str).optInt(b.a);
            if (fVar.a == 1) {
                this.b.e.b(this.a);
                this.b.d.c(this.a);
            }
        } catch (JSONException e) {
            fVar.a = -1;
        }
        this.b.h.post(fVar);
    }
}
