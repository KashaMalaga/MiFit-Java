package cn.com.smartdevices.bracelet.weight.family;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.view.WeightUserAvatar;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.xiaomi.hm.health.R;

class n extends BaseAdapter {
    final /* synthetic */ WeightFamilyMemberActivity a;

    public n(WeightFamilyMemberActivity weightFamilyMemberActivity) {
        this.a = weightFamilyMemberActivity;
    }

    public int getCount() {
        return this.a.e.size();
    }

    public Object getItem(int i) {
        return this.a.e.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        o oVar;
        C0596r.e("WeightFamilyMemberActivity", "adapter getView()");
        if (view == null) {
            view = LayoutInflater.from(this.a.a).inflate(R.layout.family_member_item, null);
            o oVar2 = new o(this);
            oVar2.a = (WeightUserAvatar) view.findViewById(R.id.member_icon);
            oVar2.b = (TextView) view.findViewById(R.id.member_name);
            oVar2.c = (TextView) view.findViewById(R.id.member_content);
            view.setTag(oVar2);
            oVar = oVar2;
        } else {
            oVar = (o) view.getTag();
        }
        UserInfo userInfo = (UserInfo) this.a.e.get(i);
        oVar.a.a(userInfo.name);
        oVar.a.a(Utils.c(((UserInfo) this.a.e.get(i)).uid));
        Utils.a(userInfo, oVar.a);
        if (!(userInfo.name == null || userInfo.name.isEmpty())) {
            oVar.b.setText(userInfo.name);
        }
        return view;
    }
}
