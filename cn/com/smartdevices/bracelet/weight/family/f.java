package cn.com.smartdevices.bracelet.weight.family;

import android.app.Activity;
import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventUserInfoUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventWeightWithUser;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import com.huami.android.view.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;

class f extends AsyncTask<Void, Void, Boolean> {
    final /* synthetic */ UserInfo a;
    final /* synthetic */ e b;
    final /* synthetic */ MemberInfoSetWeightActivity c;

    f(MemberInfoSetWeightActivity memberInfoSetWeightActivity, UserInfo userInfo, e eVar) {
        this.c = memberInfoSetWeightActivity;
        this.a = userInfo;
        this.b = eVar;
    }

    protected Boolean a(Void... voidArr) {
        C0596r.e("MemberInfoSetWeightActivity", "doInBackground");
        C0596r.e("MemberInfoSetWeightActivity", "start sync with server " + aA.k);
        this.c.u = false;
        aA.k = true;
        J.a().b(this.c.p, new g(this));
        aA.k = false;
        C0596r.e("MemberInfoSetWeightActivity", "end sync with server, result ok? " + this.c.u);
        if (!this.c.u) {
            return Boolean.valueOf(false);
        }
        C0596r.e("MemberInfoSetWeightActivity", "before uid " + this.a.uid);
        J.a().a(this.a, true);
        C0596r.e("MemberInfoSetWeightActivity", "after uid " + this.a.uid);
        return Boolean.valueOf(J.a().a(this.c.p, this.a));
    }

    protected void a(Boolean bool) {
        Utils.a((Activity) this.c.p);
        if (bool.booleanValue()) {
            Keeper.saveCurrentUser(Keeper.CURRENT_USER_NAME, a.f);
            Keeper.saveCurrentUser(Keeper.CURRENT_USER_GENDER, a.f);
            Keeper.saveCurrentUser(Keeper.CURRENT_USER_BIRTH, a.f);
            Keeper.saveCurrentUser(Keeper.CURRENT_USER_HEIGHT, a.f);
            if (this.a != null) {
                WeightInfo weightInfo = new WeightInfo();
                weightInfo.uid = this.a.uid;
                if (0 == this.c.v) {
                    weightInfo.timestamp = this.b.e();
                } else {
                    weightInfo.timestamp = this.c.v;
                }
                weightInfo.weight = this.a.weight;
                ah.a().a(weightInfo);
                EventBus.getDefault().post(new EventWeightWithUser(this.b, this.a.uid));
                EventBus.getDefault().post(new EventUserInfoUpdate(this.a));
                this.c.setResult(-1);
                this.c.finish();
                return;
            }
            return;
        }
        C0596r.e("MemberInfoSetWeightActivity", "onSyncFail");
        J.a().c(this.a);
        b.a(this.c.p, this.c.getString(r.please_connect_internet), 0).show();
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Boolean) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        Utils.a((Activity) this.c.p, (int) r.add_family_member);
    }
}
