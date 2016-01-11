package cn.com.smartdevices.bracelet.gps.ui;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.a.b;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import com.huami.android.ui.CustomActionBarActivity;
import com.huami.android.widget.share.h;
import com.huami.android.widget.share.l;
import com.huami.android.widget.share.q;
import com.xiaomi.channel.b.v;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.k;
import com.xiaomi.hm.health.b.a.n;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PaceDetailActivity extends CustomActionBarActivity implements ar {
    private static final String c = "PaceDetailActivity";
    private long a = -1;
    private aH b = null;
    private h d = null;
    private final ExecutorService f = Executors.newSingleThreadExecutor();

    public PaceDetailActivity() {
        super(C0401a.al, C0401a.am);
    }

    private void onShare() {
        b.g(this);
        if (this.d != null) {
            this.d.dismiss();
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(q.b, false);
        bundle.putBoolean(v.e, true);
        bundle.putBoolean(h.d, true);
        this.d = new h();
        this.d.setArguments(bundle);
        this.d.a(new aE(this));
        this.d.show(getFragmentManager(), C0401a.aY);
        this.d.a(new aF(this));
        this.f.execute(new aG(this));
    }

    public void a(Bundle bundle) {
    }

    public void a(l lVar) {
        C0596r.g(c, "onShareContentReady");
        if (lVar == null) {
            throw new IllegalArgumentException();
        } else if (this.d != null) {
            l lVar2 = new l();
            lVar2.a = getString(n.running_share_to_mypace);
            cn.com.smartdevices.bracelet.config.b.h().g.getClass();
            lVar2.d = "http://paopaotuan.org/";
            lVar2.c = a.f;
            lVar2.e = lVar.d;
            lVar2.b = getString(n.running_share_to_topic);
            this.d.a(lVar2);
        }
    }

    public boolean a(int i, l lVar) {
        return false;
    }

    protected String b() {
        return getResources().getString(n.running_detail_title);
    }

    public void b(Bundle bundle) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(j.activity_pace_detail);
        this.a = getIntent().getLongExtra(C0483q.a, -1);
        this.b = new aH();
        Bundle bundle2 = new Bundle();
        bundle2.putLong(C0483q.a, this.a);
        this.b.setArguments(bundle2);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(i.main_fragment, this.b);
        beginTransaction.commit();
        b.p(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(k.pace_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == i.action_share) {
            onShare();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.a = bundle.getLong(C0483q.a);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(C0483q.a, this.a);
    }
}
