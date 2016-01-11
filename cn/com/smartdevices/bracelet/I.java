package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import com.d.a.a.h;
import java.util.ArrayList;
import org.apache.http.Header;

class I extends h {
    final /* synthetic */ F a;
    private C0595q b = null;
    private ArrayList<BasicDateData> c = null;

    public I(F f) {
        this.a = f;
    }

    public I(F f, ArrayList<BasicDateData> arrayList, C0595q c0595q) {
        this.a = f;
        this.c = arrayList;
        this.b = c0595q;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("SyncMiLiDataCB", "syncToServer onFailure:" + Utils.b(bArr));
        C0401a.a(this.a.i, C0401a.ev);
        this.a.a(this.c);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String b = Utils.b(bArr);
        if (n.a(this.a.i.getApplicationContext(), b).c()) {
            C0596r.d("SyncMiLiDataCB", "syncToServer onSuccess:" + b + "  type = " + this.b.b());
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                C0596r.d("SyncMiLiDataCB", "onSuccess date = " + ((BasicDateData) this.c.get(i2)).date);
            }
            C0591m.a().b(this.c, 1, this.b);
            Keeper.keepSyncToServerTime(System.currentTimeMillis());
            C0401a.a(this.a.i, C0401a.ew);
            return;
        }
        C0596r.d("SyncMiLiDataCB", "syncToServer onFailure:" + b);
        C0401a.a(this.a.i, C0401a.ev);
        this.a.a(this.c);
    }
}
