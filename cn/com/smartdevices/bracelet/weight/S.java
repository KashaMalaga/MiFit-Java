package cn.com.smartdevices.bracelet.weight;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0891z;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.weight.EventUserSelected;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightChanged;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightSyncedDevice;
import cn.com.smartdevices.bracelet.tencent.health.QQHealth;
import cn.com.smartdevices.bracelet.weight.family.MemberInfoBaseActivity;
import cn.com.smartdevices.bracelet.weight.family.MemberInfoSetNameActivity;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import de.greenrobot.event.EventBus;

class S implements OnItemClickListener {
    final /* synthetic */ Q a;

    S(Q q) {
        this.a = q;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0596r.e("UserListActivity", "onItemClick " + i + " count " + adapterView.getAdapter().getCount());
        if (this.a.c == null) {
            EventBus.getDefault().post(new EventUserSelected(((UserInfo) adapterView.getAdapter().getItem(i)).uid));
        } else if (i < adapterView.getAdapter().getCount() - 1) {
            UserInfo a = J.a().a(((UserInfo) adapterView.getAdapter().getItem(i)).uid);
            ah a2 = ah.a();
            WeightInfo b = a2.b(this.a.c.e());
            if (b != null) {
                a2.a(b, a.uid);
                if (a.uid == -1) {
                    QQHealth.getInstance(this.a.g).addNeedSyncWeight(Long.valueOf(b.timestamp));
                }
                EventBus.getDefault().post(new EventWeightSyncedDevice(a.uid));
            } else {
                C0596r.e("UserListActivity", "can not go here,something wrong!!!");
            }
            C0891z.a(this.a.g).a(this.a.c, a, aA.a(this.a.c.e(), 0));
            EventBus.getDefault().post(new EventWeightChanged(true, a.uid));
            Intent intent = new Intent(this.a.g, WeightReportActivity.class);
            intent.putExtra(e.d, this.a.c.n());
            intent.putExtra(UserInfo.USERINFO_KEY, a.toJsonString());
            C0596r.e("UserListActivity", "here userInfo toJsonString " + a.toJsonString());
            this.a.startActivity(intent);
        } else if (!Utils.l(this.a.g)) {
            b.a(this.a.g, this.a.getString(R.string.please_connect_internet), 0).show();
            return;
        } else if (J.a().c() >= 16) {
            b.a(this.a.g, this.a.getString(R.string.over_the_max_user_count), 0).show();
            return;
        } else {
            Intent intent2 = new Intent(this.a.g, MemberInfoSetNameActivity.class);
            intent2.putExtra("FROM_BABY_WEIGHT", this.a.k);
            intent2.putExtra(MemberInfoBaseActivity.d, true);
            intent2.putExtra(e.d, this.a.c.n());
            this.a.startActivity(intent2);
            C0401a.a(this.a.g, C0401a.fl, C0401a.fn);
            this.a.b();
            return;
        }
        this.a.b();
    }
}
