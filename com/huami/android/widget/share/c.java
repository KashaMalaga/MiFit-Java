package com.huami.android.widget.share;

import cn.com.smartdevices.bracelet.C0596r;
import com.d.a.a.h;
import com.huami.android.widget.share.ShareDataManager.SharedData;
import java.util.List;
import org.apache.http.Header;

class c extends h {
    final /* synthetic */ List a;
    final /* synthetic */ ShareDataManager b;

    c(ShareDataManager shareDataManager, List list) {
        this.b = shareDataManager;
        this.a = list;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("ShareDataManager", "updateSharedTimes error");
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.b.f.a(((SharedData) this.a.get(i2)).m.longValue());
        }
    }
}
