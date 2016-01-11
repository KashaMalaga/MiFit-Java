package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.SyncResult;
import com.d.a.a.h;
import java.util.List;
import org.apache.http.Header;

class ai extends h {
    final /* synthetic */ SyncResult a;
    final /* synthetic */ Context b;
    final /* synthetic */ aE c;
    final /* synthetic */ ah d;

    ai(ah ahVar, SyncResult syncResult, Context context, aE aEVar) {
        this.d = ahVar;
        this.a = syncResult;
        this.b = context;
        this.c = aEVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("WeightInfoManager", "Sync WeightInfos To Local Failure!!");
        if (bArr != null) {
            C0596r.e("WeightInfoManager", "Response : " + new String(bArr));
        }
        this.a.result = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        C0596r.d("WeightInfoManager", "Sync WeightInfos To Local Success!!");
        if (bArr != null) {
            String str = new String(bArr);
            C0596r.e("WeightInfoManager", "Response : " + str);
            n a = n.a(this.b, str);
            if (a.c()) {
                C0596r.d("WeightInfoManager", "Result OK!!");
                this.a.result = true;
                List<WeightInfo> a2 = this.d.a(str);
                if (a2 != null && !a2.isEmpty()) {
                    for (WeightInfo weightInfo : a2) {
                        weightInfo.synced = 1;
                    }
                    if (this.d.a((List) a2)) {
                        Keeper.keepScaleSyncedWeightInfosFromServer(true);
                        if (this.c != null) {
                            this.c.a();
                        }
                    }
                }
            } else if (a.a()) {
                C0596r.d("WeightInfoManager", "Result Empty OK!!");
                Keeper.keepScaleSyncedWeightInfosFromServer(true);
                if (this.c != null) {
                    this.c.a();
                }
            }
        }
    }
}
