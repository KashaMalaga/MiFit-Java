package cn.com.smartdevices.bracelet.weight.family;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.weight.EventUserDeleted;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.goal.a;
import com.huami.android.view.b;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;

class j extends AsyncTask<Void, Void, Boolean> {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    protected Boolean a(Void... voidArr) {
        if (this.a.a.g != null) {
            C0596r.e("UserInfoFragment", "before del userinfo " + this.a.a.g);
        }
        boolean b = this.a.a.g();
        if (b) {
            a.a().b(this.a.a.g.uid);
            aA.b(this.a.a.getActivity(), this.a.a.g.uid);
        }
        return Boolean.valueOf(b);
    }

    protected void a(Boolean bool) {
        Utils.a(this.a.a.getActivity());
        if (bool.booleanValue()) {
            C0596r.e("UserInfoFragment", "after del userinfo " + this.a.a.g);
            EventBus.getDefault().post(new EventUserDeleted(this.a.a.g.uid));
            this.a.a.getActivity().finish();
            C0401a.a(this.a.a.getActivity(), C0401a.fr);
            return;
        }
        C0596r.e("UserInfoFragment", "onSyncFail");
        b.a(this.a.a.getActivity().getApplicationContext(), this.a.a.getString(r.please_connect_internet), 0).show();
        C0401a.a(this.a.a.getActivity(), C0401a.fs);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Boolean) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        Utils.a(this.a.a.getActivity(), (int) r.delete_family_member);
    }
}
