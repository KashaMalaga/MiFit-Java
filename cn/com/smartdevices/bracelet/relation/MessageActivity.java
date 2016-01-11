package cn.com.smartdevices.bracelet.relation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.push.h;
import cn.com.smartdevices.bracelet.push.j;
import cn.com.smartdevices.bracelet.relation.b.a;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.relation.view.b;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.huami.android.ui.ActionBarActivity;
import com.huami.android.view.c;
import com.huami.android.widget.f;
import com.xiaomi.hm.health.e;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class MessageActivity extends ActionBarActivity implements OnClickListener, OnScrollListener, b {
    private static final String b = "MessageActivity";
    private static final DateFormat j = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    private static final int n = 1;
    boolean a = false;
    private ListView c;
    private View d;
    private View e;
    private U f;
    private A g = A.a();
    private h h = null;
    private V i;
    private long k = -1;
    private View l;
    private f m;

    public MessageActivity() {
        super(C0401a.gL, C0401a.gB);
    }

    public static Intent a(Context context) {
        return new Intent(context, MessageActivity.class);
    }

    public void a(View view, int i) {
        if (i == 2) {
            this.l.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this, e.header_notify_in);
            if (loadAnimation != null) {
                this.l.startAnimation(loadAnimation);
            }
            this.l.postDelayed(new Q(this), 1500);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.c.setVisibility(8);
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            return;
        }
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.c.setVisibility(0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (n == i && i2 == -1) {
            Object stringExtra = intent.getStringExtra(Friend.c);
            if (!TextUtils.isEmpty(stringExtra)) {
                long longExtra = intent.getLongExtra(g.f, -1);
                for (cn.com.smartdevices.bracelet.relation.db.f fVar : this.f.a()) {
                    if (fVar.q == longExtra) {
                        fVar.r = stringExtra;
                    }
                }
                this.f.notifyDataSetChanged();
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        this.k = ((cn.com.smartdevices.bracelet.relation.db.f) view.getTag()).q;
        switch (id) {
            case l.care_button /*2131296371*/:
                if (this.g.a((Context) this)) {
                    C0401a.a((Context) this, C0409b.ba);
                    this.g.b(this, this.k, false);
                    this.f.notifyDataSetChanged();
                    this.m = f.a(getFragmentManager());
                    return;
                }
                c.showPanel((Activity) this, this.i);
                return;
            case l.ok_button /*2131296548*/:
                Utils.a((Activity) this, (int) r.data_loading, true);
                this.g.a((Context) this, this.k, true);
                return;
            case l.refuse_button /*2131297625*/:
                this.g.a((Context) this, this.k, false);
                Utils.a((Activity) this, (int) r.data_loading, true);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.activity_message);
        this.c = (ListView) findViewById(l.message_list);
        this.d = findViewById(l.logo_bracelet);
        this.e = findViewById(l.no_data_refresh);
        this.l = findViewById(l.toast_view);
        this.f = new U(this);
        this.f.a(this.g.b(0, 10));
        this.c.setAdapter(this.f);
        this.c.setOnScrollListener(this);
        this.h = h.a(getApplicationContext());
        this.h.a((Object) this);
        a(this.f.getCount() == 0);
        this.h.a(false);
        this.i = new V(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.h.b((Object) this);
    }

    public void onEvent(cn.com.smartdevices.bracelet.push.b bVar) {
        cn.com.smartdevices.bracelet.relation.db.f a = this.g.a(bVar.n, 0);
        if (a != null) {
            this.f.a(a);
            this.c.post(new O(this));
            EventBus.getDefault().cancelEventDelivery(bVar);
        }
    }

    public void onEvent(cn.com.smartdevices.bracelet.push.e eVar) {
        int i = n;
        cn.com.smartdevices.bracelet.relation.db.f a;
        if (eVar.v == n) {
            a = this.g.a(eVar.r, (int) n);
            this.f.a(a);
            if (a == null) {
                i = 0;
            }
        } else if (eVar.v == 2) {
            a = this.g.a(eVar.r, 2);
            this.f.a(a);
            if (a == null) {
                i = 0;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            this.c.post(new P(this));
            EventBus.getDefault().cancelEventDelivery(eVar);
        }
    }

    public void onEvent(j jVar) {
        C0596r.e(b, "Unfollow message");
        this.f.a(jVar.l);
    }

    public void onEvent(a aVar) {
        cn.com.smartdevices.bracelet.relation.db.f a = this.f.a(aVar.b, (int) n);
        if (a != null && this.k > 0 && this.k == a.q) {
            Utils.a((Activity) this);
            if (aVar.a == n) {
                a.v = aVar.d ? 3 : 2;
                this.f.notifyDataSetChanged();
            }
            if (aVar.a != n) {
                com.huami.android.view.b.a((Context) this, (int) r.toast_operation_failed, 0);
            } else if (aVar.d) {
                startActivityForResult(RemarkActivity.a(this, aVar.c), n);
            }
            this.k = -1;
        }
    }

    public void onEvent(cn.com.smartdevices.bracelet.relation.b.c cVar) {
        if (cVar.b == this.k) {
            if (this.m != null) {
                this.m.dismiss();
            }
            this.f.a(cVar.b, 0).v = 0;
            if (cVar.a) {
                com.huami.android.view.b.a((Context) this, (int) r.toast_care_send_success, 0);
            } else {
                com.huami.android.view.b.a((Context) this, (int) r.toast_care_send_failed, 0);
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.a = i + i2 == i3;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 || this.a) {
            List b = this.g.b(this.f.getCount(), 10);
            this.f.a(b);
            this.f.notifyDataSetChanged();
            if (this.f.getCount() < 10) {
                this.c.setOnScrollListener(null);
            } else if (b == null || b.size() < 10) {
                com.huami.android.view.b.a((Context) this, (int) r.toast_no_more_data, 0);
                this.c.setOnScrollListener(null);
            }
        }
    }
}
