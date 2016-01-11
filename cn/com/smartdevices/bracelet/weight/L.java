package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.SyncResult;
import cn.com.smartdevices.bracelet.weight.goal.a;
import com.d.a.a.h;
import java.util.List;
import org.apache.http.Header;

class L extends h {
    final /* synthetic */ Context a;
    final /* synthetic */ SyncResult b;
    final /* synthetic */ aE c;
    final /* synthetic */ J d;

    L(J j, Context context, SyncResult syncResult, aE aEVar) {
        this.d = j;
        this.a = context;
        this.b = syncResult;
        this.c = aEVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("UserInfoManager", "Sync UserInfos To Local Failure!!");
        if (bArr != null) {
            C0596r.e("UserInfoManager", "Response : " + new String(bArr));
        }
        this.b.result = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        C0596r.d("UserInfoManager", "Sync UserInfos To Local Success!!");
        if (bArr != null) {
            String str = new String(bArr);
            C0596r.e("UserInfoManager", "Response : " + str);
            n a = n.a(this.a, str);
            if (a.c()) {
                C0596r.d("UserInfoManager", "Result OK!!");
                List<UserInfo> a2 = this.d.b(str);
                if (a2 != null) {
                    a.a().a(this.a, (List) a2);
                    for (UserInfo userInfo : a2) {
                        userInfo.synced = 1;
                    }
                    this.d.d((List) a2);
                    if (this.d.a((List) a2, false)) {
                        this.b.result = true;
                        Keeper.keepScaleSyncedUserInfosFromServer(true);
                        if (this.c != null) {
                            this.c.a();
                        }
                    }
                }
            } else if (a.a()) {
                C0596r.d("UserInfoManager", "Result Empty OK!!");
                this.b.result = true;
                Keeper.keepScaleSyncedUserInfosFromServer(true);
                if (this.c != null) {
                    this.c.a();
                }
            }
        }
    }
}
