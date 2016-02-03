package cn.com.smartdevices.bracelet.relation;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.relation.b.c;
import cn.com.smartdevices.bracelet.relation.db.f;
import com.d.a.a.h;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.hm.health.R;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

class F extends h {
    final /* synthetic */ Context a;
    final /* synthetic */ long b;
    final /* synthetic */ boolean c;
    final /* synthetic */ A d;

    F(A a, Context context, long j, boolean z) {
        this.d = a;
        this.a = context;
        this.b = j;
        this.c = z;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0401a.a(this.a, C0409b.aY, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
        c cVar = new c();
        cVar.a = false;
        cVar.b = this.b;
        this.d.h.post(cVar);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        boolean z = true;
        C0401a.a(this.a, C0409b.aY, C0410c.t, Constants.VIA_RESULT_SUCCESS);
        String str = new String(bArr);
        c cVar = new c();
        cVar.b = this.b;
        try {
            int optInt = new JSONObject(str).optInt(b.a, -1);
            if (optInt == 1) {
                f a = this.d.d.a(this.b);
                if (a != null) {
                    a.v = 1;
                    this.d.d.a(a);
                }
                if (this.c) {
                    com.huami.android.view.b.a(this.d.c, (int) R.string.friend_new_user_guide_ok_toast, 1).show();
                }
            }
            if (optInt != 1) {
                z = false;
            }
            cVar.a = z;
        } catch (JSONException e) {
            cVar.a = false;
        }
        this.d.h.post(cVar);
    }
}
