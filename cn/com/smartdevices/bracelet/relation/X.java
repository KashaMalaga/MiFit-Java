package cn.com.smartdevices.bracelet.relation;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0544h;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import com.f.a.b.a.b;
import com.f.a.b.f.a;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import java.util.List;

class X extends ArrayAdapter<Friend> implements a {
    final /* synthetic */ SearchResultActivity a;
    private LayoutInflater b;

    public X(SearchResultActivity searchResultActivity, Context context, List<Friend> list) {
        this.a = searchResultActivity;
        super(context, 0, list);
        this.b = LayoutInflater.from(context);
    }

    public Friend a(long j) {
        int count = getCount();
        Friend friend = null;
        for (int i = 0; i < count; i++) {
            friend = (Friend) getItem(i);
            if (friend.n == j) {
                break;
            }
        }
        return friend;
    }

    public void a(String str, View view) {
        ((ImageView) view).setBackgroundResource(k.default_friend_avatar);
    }

    public void a(String str, View view, Bitmap bitmap) {
        if (bitmap == null) {
            ((ImageView) view).setBackgroundResource(k.default_friend_avatar);
        }
    }

    public void a(String str, View view, b bVar) {
        ((ImageView) view).setBackgroundResource(k.default_friend_avatar);
    }

    public void b(String str, View view) {
        if (view != null) {
            ((ImageView) view).setBackgroundResource(k.default_friend_avatar);
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Y y;
        if (view == null) {
            view = this.b.inflate(n.search_result_list_item, null);
            y = new Y();
            y.a = (ImageView) view.findViewById(l.icon);
            y.b = (TextView) view.findViewById(l.username);
            y.c = (TextView) view.findViewById(l.uid);
            view.setTag(y);
        } else {
            y = (Y) view.getTag();
        }
        Friend friend = (Friend) getItem(i);
        C0544h.a().b(friend.p, y.a, this);
        y.b.setText(friend.o);
        y.c.setText(this.a.getString(r.label_uid, new Object[]{Long.valueOf(friend.n)}));
        return view;
    }
}
