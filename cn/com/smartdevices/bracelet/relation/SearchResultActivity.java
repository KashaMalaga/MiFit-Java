package cn.com.smartdevices.bracelet.relation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.push.h;
import cn.com.smartdevices.bracelet.relation.b.a;
import cn.com.smartdevices.bracelet.relation.b.g;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import com.huami.android.ui.ActionBarActivity;
import com.huami.android.view.b;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import java.util.ArrayList;

public class SearchResultActivity extends ActionBarActivity implements OnClickListener {
    private static final String a = "isFriend";
    private static final String b = "uid";
    private static final String c = "username";
    private static final String d = "icon";
    private long e = -1;
    private String f;
    private String g;
    private Button h;
    private boolean i;
    private A j = A.a();
    private h k = null;
    private X l;

    public SearchResultActivity() {
        super(C0401a.gN, C0401a.gD);
    }

    public static Intent a(Context context, long j, String str, String str2, boolean z) {
        Intent intent = new Intent(context, SearchResultActivity.class);
        intent.putExtra(b, j);
        intent.putExtra(c, str);
        intent.putExtra(d, str2);
        intent.putExtra(a, z);
        return intent;
    }

    private void a(boolean z) {
        Utils.a((Activity) this);
        if (z) {
            C0401a.a((Context) this, C0409b.aI);
            b.a((Context) this, (int) r.toast_add_friend_success, 0).show();
            finish();
            return;
        }
        C0401a.a((Context) this, C0409b.aJ);
        this.h.setEnabled(true);
        b.a((Context) this, (int) r.toast_add_friend_failed, 0).show();
    }

    public void onClick(View view) {
        if (view.getId() == l.add_button && this.e > 0) {
            this.h.setEnabled(false);
            Utils.a((Activity) this, (int) r.data_loading, false);
            this.j.a((Context) this, this.e);
            C0401a.a((Context) this, C0409b.aK);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.activity_search_result);
        ListView listView = (ListView) findViewById(l.list);
        this.h = (Button) findViewById(l.add_button);
        this.h.setOnClickListener(this);
        View findViewById = findViewById(l.result_view);
        View findViewById2 = findViewById(l.empty_view);
        Intent intent = getIntent();
        if (intent != null) {
            this.e = intent.getLongExtra(b, -1);
            this.f = intent.getStringExtra(c);
            this.g = intent.getStringExtra(d);
            this.i = intent.getBooleanExtra(a, false);
        }
        if (this.e < 0) {
            this.h.setEnabled(false);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
        } else {
            this.h.setEnabled(!this.i);
            findViewById2.setVisibility(8);
            findViewById.setVisibility(0);
            this.l = new X(this, this, new ArrayList());
            Friend friend = new Friend();
            friend.p = this.g;
            friend.o = this.f;
            friend.n = this.e;
            this.l.add(friend);
            listView.setAdapter(this.l);
        }
        if (TextUtils.isEmpty(this.g)) {
            this.j.a(this.e);
        }
        this.k = h.a(getApplicationContext());
        this.k.a((Object) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.k.b((Object) this);
    }

    public void onEvent(a aVar) {
        boolean z = true;
        Friend friend = aVar.c;
        if (friend != null && this.e == friend.n) {
            if (aVar.a != 1) {
                z = false;
            }
            a(z);
        }
    }

    public void onEvent(cn.com.smartdevices.bracelet.relation.b.b bVar) {
        boolean z = true;
        if (this.e == bVar.b) {
            if (bVar.a != 1) {
                z = false;
            }
            a(z);
        }
    }

    public void onEvent(g gVar) {
        boolean z = true;
        if (gVar.a == 1 && this.l != null) {
            Friend a = this.l.a(gVar.b);
            if (a != null) {
                a.n = gVar.b;
                a.o = gVar.c;
                a.p = gVar.d;
                this.i = gVar.e;
                Button button = this.h;
                if (this.i) {
                    z = false;
                }
                button.setEnabled(z);
                if (this.i) {
                    this.h.setText(r.label_friend_added);
                    this.h.setBackgroundResource(k.btn_unable_bg);
                } else {
                    this.h.setText(r.title_add_friend);
                    this.h.setBackgroundResource(k.btn_blue_bg);
                }
                this.l.notifyDataSetChanged();
            }
        }
    }
}
