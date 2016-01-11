package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.SyncResult;
import com.d.a.a.h;
import java.util.List;
import org.apache.http.Header;

class M extends h {
    final /* synthetic */ Context a;
    final /* synthetic */ SyncResult b;
    final /* synthetic */ List c;
    final /* synthetic */ J d;

    M(J j, Context context, SyncResult syncResult, List list) {
        this.d = j;
        this.a = context;
        this.b = syncResult;
        this.c = list;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("UserInfoManager", "Sync Deleted UserInfos To Server Failure!!");
        if (bArr != null) {
            C0596r.e("UserInfoManager", "Response : " + new String(bArr));
        }
        this.b.result = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        C0596r.d("UserInfoManager", "Sync Deleted UserInfos To Server Success!!");
        if (bArr != null) {
            String str = new String(bArr);
            C0596r.e("UserInfoManager", "Response : " + str);
            if (n.a(this.a, str).c()) {
                C0596r.d("UserInfoManager", "Result OK!!");
                this.b.result = true;
                this.d.c(this.c);
            }
        }
    }
}
