package cn.com.smartdevices.bracelet.heartrate;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import java.util.ArrayList;
import org.apache.http.Header;

class d extends h {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ e b;
    final /* synthetic */ b c;

    d(b bVar, ArrayList arrayList, e eVar) {
        this.c = bVar;
        this.a = arrayList;
        this.b = eVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("HeartRateDataManager", "syncToServer onFailure:" + Utils.b(bArr));
        this.b.a = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (n.a(this.c.c.getApplicationContext(), Utils.b(bArr)).c()) {
            C0596r.d("HeartRateDataManager", "syncToServer onSuccess");
            this.c.d.a(this.a, 1);
            this.b.a = true;
            return;
        }
        C0596r.d("HeartRateDataManager", "syncToServer onFailure");
        this.b.a = false;
    }
}
