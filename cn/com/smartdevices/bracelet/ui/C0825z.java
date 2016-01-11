package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import org.apache.http.Header;

class C0825z extends h {
    final /* synthetic */ BaseSCActivity a;

    C0825z(BaseSCActivity baseSCActivity) {
        this.a = baseSCActivity;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        Keeper.setSyncBraceletInfoToServer(1);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            if (n.a(this.a.x, new String(bArr)).c()) {
                Keeper.setSyncBraceletInfoToServer(2);
            }
        }
    }
}
