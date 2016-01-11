package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import com.d.a.a.h;
import java.util.ArrayList;
import org.apache.http.Header;

final class y extends h {
    final /* synthetic */ int a;
    final /* synthetic */ C0480n b;
    final /* synthetic */ Context c;

    y(int i, C0480n c0480n, Context context) {
        this.a = i;
        this.b = c0480n;
        this.c = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Sync", "syncContourTrackFromServer onFailure statusCode = " + i + "  content = " + R.a(bArr) + ", type = " + this.a);
        this.b.a = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (C0476i.a(this.c, new String(bArr), arrayList).c()) {
            z = C0469a.a(this.c, arrayList);
        }
        this.b.a = z;
        if (!this.b.a) {
            C0596r.e("Sync", "syncContourTrackFromServer isSucceededToSaveToDB = " + z + ", type = " + this.a);
        }
    }
}
