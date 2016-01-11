package cn.com.smartdevices.bracelet;

import android.content.Context;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.view.O;
import com.d.a.a.h;
import org.apache.http.Header;

final class aa extends h {
    final /* synthetic */ ag a;
    final /* synthetic */ Context b;
    final /* synthetic */ PersonInfo c;

    aa(ag agVar, Context context, PersonInfo personInfo) {
        this.a = agVar;
        this.b = context;
        this.c = personInfo;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("WPJ", "onFailure:" + i + ",content:" + Utils.b(bArr));
        O.a();
        if (this.a != null) {
            this.a.a();
        }
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String b = Utils.b(bArr);
        C0596r.e("Utils", "update Profile onSuccess:" + i + ",content:" + b);
        n a = n.a(this.b, b);
        O.a();
        if (a.c()) {
            Keeper.keepPersonInfo(this.c);
            if (this.a != null) {
                this.a.b();
            }
        } else if (this.a != null) {
            this.a.a();
        }
    }
}
