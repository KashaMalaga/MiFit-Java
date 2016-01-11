package cn.com.smartdevices.bracelet.ui.person;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.d.a.a.h;
import org.apache.http.Header;

class f extends h {
    final /* synthetic */ PersonInfo a;
    final /* synthetic */ PersonInfoSetSportGoalActivity b;

    f(PersonInfoSetSportGoalActivity personInfoSetSportGoalActivity, PersonInfo personInfo) {
        this.b = personInfoSetSportGoalActivity;
        this.a = personInfo;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("PersonInfoSetSportGoalActivity", "statusCode=" + i + ", content=" + Utils.b(bArr));
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String b = Utils.b(bArr);
        if (n.a(this.b.getApplicationContext(), b).c()) {
            this.a.clearNeedSyncServer();
            Keeper.keepPersonInfo(this.a);
            return;
        }
        C0596r.e("PersonInfoSetSportGoalActivity", "statusCode=" + i + ", content=" + b);
    }
}
