package cn.com.smartdevices.bracelet.relation;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import com.d.a.a.h;
import com.huami.android.view.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import org.apache.http.Header;

class D extends h {
    final /* synthetic */ long a;
    final /* synthetic */ String b;
    final /* synthetic */ Context c;
    final /* synthetic */ A d;

    D(A a, long j, String str, Context context) {
        this.d = a;
        this.a = j;
        this.b = str;
        this.c = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
        b.a(this.c, (int) R.string.friend_set_nick_name_failed, 1).show();
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        C0596r.e(A.a, "Update user nick name");
        Friend a = this.d.e.a(this.a);
        a.x = this.b;
        this.d.e.c(a);
        this.d.a(0, 10, false, false, false);
        String str = this.b;
        if (a.f.equals(this.b)) {
            str = a.c();
        }
        this.d.d.a(this.a, str);
    }
}
