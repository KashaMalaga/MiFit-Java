package cn.com.smartdevices.bracelet.weight.family;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.ui.PersonInfoActivity;
import cn.com.smartdevices.bracelet.weight.UserInfo;

class m implements OnItemClickListener {
    final /* synthetic */ WeightFamilyMemberActivity a;

    m(WeightFamilyMemberActivity weightFamilyMemberActivity) {
        this.a = weightFamilyMemberActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        UserInfo userInfo = (UserInfo) this.a.e.get(i);
        if (userInfo == null || userInfo.uid != -1) {
            Intent intent = new Intent(this.a.a, UserInfoActivity.class);
            intent.putExtra(MemberInfoBaseActivity.b, ((UserInfo) this.a.e.get(i)).uid);
            this.a.a.startActivity(intent);
            C0401a.a(this.a.a, C0401a.gf);
            return;
        }
        Intent intent2 = new Intent();
        intent2.setClass(this.a.a, PersonInfoActivity.class);
        this.a.startActivity(intent2);
    }
}
