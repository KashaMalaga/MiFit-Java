package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import java.util.List;
import org.apache.http.Header;

final class D extends h {
    final /* synthetic */ Context a;

    D(Context context) {
        this.a = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("SyncGPSSportData", "get from server fail");
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            String str = new String(bArr);
            if (n.a(this.a, str).c()) {
                List a = C0472e.a(str);
                if (a != null && a.isEmpty()) {
                }
            }
        }
    }
}
