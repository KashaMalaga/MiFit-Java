package cn.com.smartdevices.bracelet.weight.family;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventUserInfoUpdate;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.WeightReportActivity;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import de.greenrobot.event.EventBus;

class b extends AsyncTask<Void, Void, Boolean> {
    final /* synthetic */ UserInfo a;
    final /* synthetic */ MemberInfoSetHeightActivity b;

    b(MemberInfoSetHeightActivity memberInfoSetHeightActivity, UserInfo userInfo) {
        this.b = memberInfoSetHeightActivity;
        this.a = userInfo;
    }

    protected Boolean a(Void... voidArr) {
        C0596r.e("MemberInfoBaseActivity", "doInBackground");
        C0596r.e("MemberInfoBaseActivity", "start sync with server " + aA.k);
        this.b.s = false;
        aA.k = true;
        J.a().b(this.b.h, new c(this));
        aA.k = false;
        C0596r.e("MemberInfoBaseActivity", "end sync with server, result ok? " + this.b.s);
        if (!this.b.s) {
            return Boolean.valueOf(false);
        }
        C0596r.e("MemberInfoBaseActivity", "before uid " + this.a.uid);
        J.a().a(this.a, true);
        C0596r.e("MemberInfoBaseActivity", "after uid " + this.a.uid);
        return Boolean.valueOf(J.a().a(this.b.h, this.a));
    }

    protected void a(Boolean bool) {
        Utils.a((Activity) this.b.h);
        if (bool.booleanValue()) {
            Keeper.saveCurrentUser(Keeper.CURRENT_USER_NAME, a.f);
            Keeper.saveCurrentUser(Keeper.CURRENT_USER_GENDER, a.f);
            Keeper.saveCurrentUser(Keeper.CURRENT_USER_BIRTH, a.f);
            Keeper.saveCurrentUser(Keeper.CURRENT_USER_HEIGHT, a.f);
            if (this.b.f && this.b.g != null) {
                this.b.g.a(aA.a(this.b.m, Birthday.fromStr(this.a.birthday).getAge(), this.b.n));
                Intent intent = new Intent(this.b, WeightReportActivity.class);
                intent.putExtra(e.d, this.b.g.n());
                if (this.a != null) {
                    C0596r.e("MemberInfoBaseActivity", "info is not null and info is  " + this.a.toString());
                } else {
                    C0596r.e("MemberInfoBaseActivity", "info is null");
                    this.a.uid = 0;
                }
                intent.putExtra(UserInfo.USERINFO_KEY, this.a.toJsonString());
                intent.putExtra("NEW_USER", true);
                this.b.startActivityForResult(intent, 6);
                return;
            } else if (this.a != null) {
                WeightInfo weightInfo = new WeightInfo();
                weightInfo.uid = this.a.uid;
                weightInfo.timestamp = System.currentTimeMillis();
                weightInfo.weight = this.b.n;
                ah.a().a(weightInfo);
                EventBus.getDefault().post(new EventUserInfoUpdate(this.a));
                this.b.setResult(-1);
                this.b.finish();
                return;
            } else {
                return;
            }
        }
        C0596r.e("MemberInfoBaseActivity", "onSyncFail");
        J.a().c(this.a);
        com.huami.android.view.b.a(this.b.h, this.b.getString(R.string.please_connect_internet), 0).show();
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Boolean) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        Utils.a((Activity) this.b.h, (int) R.string.add_family_member);
    }
}
