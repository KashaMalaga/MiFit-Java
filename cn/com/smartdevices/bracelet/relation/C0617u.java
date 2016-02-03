package cn.com.smartdevices.bracelet.relation;

import cn.com.smartdevices.bracelet.relation.b.e;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;

class C0617u implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ FriendActivity b;

    C0617u(FriendActivity friendActivity, e eVar) {
        this.b = friendActivity;
        this.a = eVar;
    }

    public void run() {
        if (this.b.g != null) {
            this.b.g.onRefreshComplete();
            if (this.a.f) {
                this.b.g.setMode(Mode.BOTH);
            } else {
                this.b.g.setMode(Mode.PULL_FROM_START);
            }
        }
        if (this.a.d != 0 && this.a.g) {
            int i = this.a.f ? this.a.h.size() <= 0 ? 1 : 0 : 0;
            if (this.a.e) {
                i = 1;
            }
            if (i != 0) {
                if (this.a.d == -2) {
                    b.a(this.b, (int) R.string.no_network_connection, 1).show();
                } else {
                    b.a(this.b, (int) R.string.friend_list_get_error, 1).show();
                }
            }
        }
        this.b.h.a(this.a.h);
        this.b.h.notifyDataSetChanged();
        this.b.l = this.b.h.getCount();
        if (this.b.l == 0) {
            this.b.i.setVisibility(0);
            this.b.g.setVisibility(8);
            return;
        }
        this.b.i.setVisibility(8);
        this.b.g.setVisibility(0);
    }
}
