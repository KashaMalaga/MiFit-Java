package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.d.a.a.h;
import org.apache.http.Header;

class C0699ba extends h {
    final /* synthetic */ PersonInfo a;
    final /* synthetic */ HealthGoalsActivity b;

    C0699ba(HealthGoalsActivity healthGoalsActivity, PersonInfo personInfo) {
        this.b = healthGoalsActivity;
        this.a = personInfo;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        this.a.setNeedSyncServer(2);
        Keeper.keepPersonInfo(this.a);
        C0596r.e("HealthGoalsActivity", "fail, statusCode=" + i + ", content=" + Utils.b(bArr));
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String b = Utils.b(bArr);
        n a = n.a(this.b.getApplicationContext(), b);
        C0596r.e("HealthGoalsActivity", "statusCode=" + i + ", content=" + b);
        if (a.c()) {
            this.b.c.clearNeedSyncServer();
        } else {
            this.a.setNeedSyncServer(2);
        }
        Keeper.keepPersonInfo(this.a);
    }
}
