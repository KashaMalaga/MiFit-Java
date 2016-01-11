package cn.com.smartdevices.bracelet.weight;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.view.WeightUserAvatar;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

class C0861ac extends BaseAdapter {
    final /* synthetic */ Q a;

    C0861ac(Q q) {
        this.a = q;
    }

    public int getCount() {
        return this.a.d.size();
    }

    public Object getItem(int i) {
        return this.a.d.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0862ad c0862ad;
        C0596r.e("UserListActivity", "adapter getView()");
        if (view == null) {
            view = LayoutInflater.from(this.a.g).inflate(n.userlist_item, null);
            C0862ad c0862ad2 = new C0862ad(this);
            c0862ad2.a = (TextView) view.findViewById(l.user_list_item_name);
            c0862ad2.b = (WeightUserAvatar) view.findViewById(l.user_icon);
            view.setTag(c0862ad2);
            c0862ad = c0862ad2;
        } else {
            c0862ad = (C0862ad) view.getTag();
        }
        UserInfo userInfo = (UserInfo) this.a.d.get(i);
        if (!(userInfo.name == null || userInfo.name.isEmpty())) {
            c0862ad.a.setText(userInfo.name);
        }
        c0862ad.b.a(userInfo.name);
        c0862ad.b.a(Utils.c(((UserInfo) this.a.d.get(i)).uid));
        Utils.a(userInfo, c0862ad.b);
        return view;
    }
}
