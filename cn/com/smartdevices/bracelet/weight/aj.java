package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.SyncResult;
import com.d.a.a.h;
import java.util.List;
import org.apache.http.Header;

class aj extends h {
    final /* synthetic */ Context a;
    final /* synthetic */ SyncResult b;
    final /* synthetic */ List c;
    final /* synthetic */ ah d;

    aj(ah ahVar, Context context, SyncResult syncResult, List list) {
        this.d = ahVar;
        this.a = context;
        this.b = syncResult;
        this.c = list;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("WeightInfoManager", "Sync WeightInfos To Server Failure!!");
        if (bArr != null) {
            C0596r.e("WeightInfoManager", "Response : " + new String(bArr));
        }
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        C0596r.d("WeightInfoManager", "Sync WeightInfos To Server Success!!");
        if (bArr != null) {
            String str = new String(bArr);
            C0596r.e("WeightInfoManager", "Response : " + str);
            if (n.a(this.a, str).c()) {
                C0596r.d("WeightInfoManager", "Result OK!!");
                this.b.result = true;
                for (WeightInfo weightInfo : this.c) {
                    weightInfo.synced = 1;
                }
                this.d.d(this.c);
            }
        }
    }
}
