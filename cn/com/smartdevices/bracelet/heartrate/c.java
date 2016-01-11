package cn.com.smartdevices.bracelet.heartrate;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import de.greenrobot.event.EventBus;
import java.util.List;
import org.apache.http.Header;

class c extends h {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("HeartRateDataManager", "get from server fail");
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            String str = new String(bArr);
            if (n.a(this.a.c, str).c()) {
                List a = this.a.a(str);
                if (a == null) {
                    return;
                }
                if (a.isEmpty()) {
                    C0596r.d("HeartRateDataManager", "Result Empty OK!!");
                    Keeper.setHeartRateDataFromServer(true);
                    return;
                } else if (this.a.d.b(a)) {
                    C0596r.d("HeartRateDataManager", "sync from server success");
                    Keeper.setHeartRateDataFromServer(true);
                    EventBus.getDefault().post(new a());
                    return;
                } else {
                    return;
                }
            }
            C0596r.d("HeartRateDataManager", "sync from server error");
        }
    }
}
