package cn.com.smartdevices.bracelet.relation;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0544h;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import com.c.b.b.a.C1009k;
import com.f.a.b.a.b;
import com.f.a.b.f.a;
import com.xiaomi.hm.health.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class C0621y extends BaseAdapter implements a {
    final /* synthetic */ FriendActivity a;
    private List<Friend> b = new ArrayList();

    public C0621y(FriendActivity friendActivity) {
        this.a = friendActivity;
    }

    public Friend a(int i) {
        return (Friend) this.b.get(i);
    }

    public void a() {
        this.b.clear();
    }

    public void a(int i, Friend friend) {
        if (this.b.contains(friend)) {
            this.b.remove(friend);
        }
        this.b.add(i, friend);
    }

    public void a(long j) {
        Friend friend = new Friend(j);
        if (this.b.contains(friend)) {
            this.b.remove(friend);
        }
        notifyDataSetChanged();
    }

    public void a(Friend friend) {
        if (friend != null) {
            int size = this.b.size();
            int i = 0;
            while (i < size) {
                if (a(i).n == friend.n) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i < 0) {
                this.b.add(0, friend);
                return;
            }
            this.b.remove(i);
            this.b.add(i, friend);
        }
    }

    public void a(String str, View view) {
        ((ImageView) view).setBackgroundResource(R.drawable.default_friend_avatar);
    }

    public void a(String str, View view, Bitmap bitmap) {
        if (bitmap == null) {
            ((ImageView) view).setBackgroundResource(R.drawable.default_friend_avatar);
        }
    }

    public void a(String str, View view, b bVar) {
        ((ImageView) view).setBackgroundResource(R.drawable.default_friend_avatar);
    }

    public void a(List<Friend> list) {
        if (list != null) {
            for (Friend friend : list) {
                if (this.b.contains(friend)) {
                    this.b.remove(friend);
                }
            }
            this.b.addAll(list);
        }
    }

    public Friend b(long j) {
        int size = this.b.size();
        Friend friend = null;
        for (int i = 0; i < size; i++) {
            friend = (Friend) this.b.get(i);
            if (friend.n == j) {
                break;
            }
        }
        return friend;
    }

    public void b(String str, View view) {
        ((ImageView) view).setBackgroundResource(R.drawable.default_friend_avatar);
    }

    public int getCount() {
        return this.b.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public long getItemId(int i) {
        Friend friend = (Friend) this.b.get(i);
        return friend == null ? -1 : friend.n;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0622z c0622z;
        if (view == null) {
            view = View.inflate(this.a, R.layout.friend_list_item, null);
            C0622z c0622z2 = new C0622z();
            c0622z2.a = (ImageView) view.findViewById(R.id.icon);
            c0622z2.b = (TextView) view.findViewById(R.id.username);
            c0622z2.c = (TextView) view.findViewById(R.id.last_update_time);
            c0622z2.d = (TextView) view.findViewById(R.id.careByMe);
            c0622z2.e = (TextView) view.findViewById(R.id.step);
            c0622z2.g = (TextView) view.findViewById(R.id.sleep);
            c0622z2.f = (TextView) view.findViewById(R.id.weight);
            c0622z2.h = (ImageView) view.findViewById(R.id.care_icon);
            view.setTag(c0622z2);
            c0622z = c0622z2;
        } else {
            c0622z = (C0622z) view.getTag();
        }
        Friend a = a(i);
        C0544h.a().b(a.p, c0622z.a, this);
        c0622z.b.setText(a.c());
        if (a.u <= 0) {
            c0622z.d.setText(R.string.label_no_care_time_by_me);
            c0622z.h.setImageResource(R.drawable.ic_grey_heart);
        } else {
            c0622z.d.setText(this.a.getString(R.string.label_care_time_by_me, new Object[]{Integer.valueOf(a.u)}));
            c0622z.h.setImageResource(R.drawable.ic_red_heart);
        }
        String string = a.v == 0 ? this.a.getString(R.string.label_no_update) : FriendActivity.b.format(new Date(a.v));
        c0622z.c.setText(this.a.getString(R.string.label_update_time, new Object[]{string}));
        c0622z.e.setText(this.a.getString(R.string.label_step_with_unit, new Object[]{Integer.valueOf(a.r)}));
        c0622z.g.setText(DetailActivity.a(a.s));
        c0622z.f.setText(a.q + C1009k.a);
        return view;
    }
}
