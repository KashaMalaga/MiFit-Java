package cn.com.smartdevices.bracelet;

import android.content.Context;
import cn.com.smartdevices.bracelet.j.m;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.d.a.a.h;
import org.apache.http.Header;

final class Z extends h {
    final /* synthetic */ PersonInfo a;
    final /* synthetic */ Context b;

    Z(PersonInfo personInfo, Context context) {
        this.a = personInfo;
        this.b = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("Utils", "Sync person info to server fail : " + bArr + ", statusCode " + i + ", error");
        th.printStackTrace();
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String b = Utils.b(bArr);
        C0596r.d("Utils", "update person info onSuccess:" + i + ",content:" + b);
        String str = this.a.avatarUrl;
        if (m.a(this.b, b, this.a).c()) {
            C0596r.e("Utils", "update avatar onSuccess:" + i + ", avatarUrl=" + this.a.avatarUrl);
            C0544h.a().d(str);
        }
        this.a.clearNeedSyncServer();
        Keeper.keepPersonInfo(this.a);
    }
}
