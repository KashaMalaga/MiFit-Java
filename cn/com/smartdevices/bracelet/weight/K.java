package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.SyncResult;
import com.d.a.a.h;
import org.apache.http.Header;

class K extends h {
    final /* synthetic */ Context a;
    final /* synthetic */ SyncResult b;
    final /* synthetic */ boolean c;
    final /* synthetic */ UserInfo d;
    final /* synthetic */ J e;

    K(J j, Context context, SyncResult syncResult, boolean z, UserInfo userInfo) {
        this.e = j;
        this.a = context;
        this.b = syncResult;
        this.c = z;
        this.d = userInfo;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("UserInfoManager", "Sync UserInfo To Server Failure!!");
        if (bArr != null) {
            C0596r.e("UserInfoManager", "Response : " + new String(bArr));
        }
        this.b.result = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        C0596r.d("UserInfoManager", "Sync UserInfo To Server Success!!");
        if (bArr != null) {
            String str = new String(bArr);
            C0596r.e("UserInfoManager", "Response : " + str);
            if (n.a(this.a, str).c()) {
                this.b.result = true;
                C0596r.d("UserInfoManager", "Result OK!!");
                if (this.c) {
                    Object a = this.e.a(str, this.d);
                    if (!TextUtils.isEmpty(a)) {
                        this.d.avatarUrl = a;
                    }
                }
                this.d.synced = 1;
                this.e.h(this.d);
            }
        }
    }
}
