package cn.com.smartdevices.bracelet.relation;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.push.e;
import cn.com.smartdevices.bracelet.push.h;
import cn.com.smartdevices.bracelet.push.j;
import cn.com.smartdevices.bracelet.relation.b.c;
import cn.com.smartdevices.bracelet.relation.b.d;
import cn.com.smartdevices.bracelet.relation.b.f;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import com.c.a.G;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.huami.android.ui.ActionBarActivity;
import com.huami.android.ui.a;
import com.huami.android.view.b;
import com.huami.android.zxing.CaptureActivity;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FriendActivity extends ActionBarActivity implements OnClickListener, OnItemClickListener, N, OnRefreshListener2<ListView>, Runnable {
    private static final int a = 65537;
    private static final DateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    private static final String c = "FriendActivity";
    private A d;
    private h e;
    private J f;
    private PullToRefreshListView g;
    private C0621y h = new C0621y(this);
    private View i;
    private Thread j;
    private boolean k;
    private int l = 0;
    private View m;

    public FriendActivity() {
        super(C0401a.gK, C0401a.gA);
    }

    private void f() {
        Bitmap bitmap = null;
        if (!this.k) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            if (this.f == null) {
                this.f = J.a((Context) this);
                beginTransaction.add(this.f, null);
                beginTransaction.commitAllowingStateLoss();
                this.f.a((OnClickListener) this);
            } else {
                this.f.show(beginTransaction, null);
            }
            this.k = true;
            if (a.b(this)) {
                View decorView = getWindow().getDecorView();
                decorView.buildDrawingCache();
                bitmap = decorView.getDrawingCache();
            } else {
                View findViewById = findViewById(16908290);
                if (findViewById != null) {
                    findViewById.buildDrawingCache();
                    bitmap = findViewById.getDrawingCache();
                }
            }
            this.f.a(bitmap);
            this.f.a((N) this);
        }
    }

    public void b() {
        boolean a = this.e.a();
        if (this.m != null) {
            if (a) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
        }
        if (this.f != null) {
            this.f.a(a);
        }
    }

    public void c() {
        if (a.b(this)) {
            getWindow().getDecorView().destroyDrawingCache();
        } else {
            View findViewById = findViewById(16908290);
            if (findViewById != null) {
                findViewById.destroyDrawingCache();
            }
        }
        this.k = false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == a && i2 == -1) {
            cn.com.smartdevices.bracelet.relation.a.a aVar;
            intent.getByteArrayExtra(CaptureActivity.a);
            try {
                aVar = (cn.com.smartdevices.bracelet.relation.a.a) Utils.c().a(intent.getStringExtra(CaptureActivity.b), cn.com.smartdevices.bracelet.relation.a.a.class);
            } catch (G e) {
                C0596r.b(c, e.getMessage());
                aVar = null;
            }
            if (aVar != null) {
                if (aVar.a != cn.com.smartdevices.bracelet.e.a.f(this).uid) {
                    startActivity(SearchResultActivity.a(this, aVar.a, aVar.b, null, false));
                    C0401a.a((Context) this, C0409b.aF);
                } else {
                    b.a((Context) this, (int) R.string.lable_qrcode_is_myself, 0);
                    C0401a.a((Context) this, C0409b.aG);
                }
            } else {
                b.a((Context) this, (int) R.string.label_qrcode_error, 0);
                C0401a.a((Context) this, C0409b.aG);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_button:
            case R.id.action_button:
            case R.id.action_add_friend:
                C0401a.a((Context) this, C0409b.aB, C0410c.t, this.l == 0 ? Constants.VIA_RESULT_SUCCESS : Constants.VIA_TO_TYPE_QQ_GROUP);
                startActivityForResult(CaptureActivity.b(this), a);
                return;
            case R.id.my_qrcode_button:
            case R.id.action_my_qrcode:
                C0401a.a((Context) this, C0409b.aC, C0410c.t, this.l == 0 ? Constants.VIA_RESULT_SUCCESS : Constants.VIA_TO_TYPE_QQ_GROUP);
                PersonInfo readPersonInfo = Keeper.readPersonInfo();
                startActivity(UserQRCardActivity.a(this, readPersonInfo.uid, readPersonInfo.avatarUrl, readPersonInfo.getNickname()));
                return;
            case R.id.message_button:
                C0401a.a((Context) this, C0409b.aE);
                startActivity(MessageActivity.a((Context) this));
                return;
            case R.id.more_button:
                C0401a.a((Context) this, C0409b.aD, C0410c.t, this.l == 0 ? Constants.VIA_RESULT_SUCCESS : Constants.VIA_TO_TYPE_QQ_GROUP);
                f();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_friend_list);
        this.d = A.a();
        this.e = h.a(getApplicationContext());
        this.e.a((Object) this);
        this.g = (PullToRefreshListView) findViewById(R.id.friend_list);
        this.i = findViewById(R.id.empty_list);
        findViewById(R.id.my_qrcode_button).setOnClickListener(this);
        findViewById(R.id.action_button).setOnClickListener(this);
        this.g.setOnRefreshListener((OnRefreshListener2) this);
        this.g.setMode(Mode.BOTH);
        ILoadingLayout loadingLayoutProxy = this.g.getLoadingLayoutProxy(true, false);
        loadingLayoutProxy.setPullLabel(getString(R.string.label_pull_to_refresh));
        loadingLayoutProxy.setRefreshingLabel(getString(R.string.label_refreshing));
        loadingLayoutProxy.setReleaseLabel(getString(R.string.label_release_to_refresh));
        loadingLayoutProxy = this.g.getLoadingLayoutProxy(false, true);
        loadingLayoutProxy.setPullLabel(getString(R.string.label_pull_to_load));
        loadingLayoutProxy.setRefreshingLabel(getString(R.string.label_loading));
        loadingLayoutProxy.setReleaseLabel(getString(R.string.label_release_to_load));
        this.g.setMode(Mode.DISABLED);
        ListView listView = (ListView) this.g.getRefreshableView();
        listView.setFadingEdgeLength(0);
        listView.setAdapter(this.h);
        listView.setOnItemClickListener(this);
        List a = this.d.a(0, 10);
        this.h.a(a);
        if (a == null || a.isEmpty()) {
            this.i.setVisibility(0);
            this.g.setVisibility(8);
            this.d.a(0, 10, true, false, false);
        } else {
            this.i.setVisibility(8);
            this.g.setVisibility(0);
            if (a.size() < 10) {
                this.g.setMode(Mode.PULL_FROM_START);
            } else {
                this.g.setMode(Mode.BOTH);
            }
            this.d.a(0, 10, true, false, false, true);
        }
        this.j = new Thread(this);
        this.j.start();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_friend, menu);
        MenuItem findItem = menu.findItem(R.id.action_more);
        View inflate = LayoutInflater.from(this).inflate(R.layout.view_friend_menu_view, null);
        this.m = inflate.findViewById(R.id.menu_new_flag);
        inflate.setOnClickListener(this);
        findItem.setActionView(inflate);
        b();
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.e.b((Object) this);
    }

    public void onEvent(cn.com.smartdevices.bracelet.push.b.a aVar) {
        this.m.post(new C0620x(this));
    }

    public void onEvent(cn.com.smartdevices.bracelet.push.b bVar) {
        if (this.h.b(bVar.n) != null) {
            this.g.post(new C0618v(this));
        }
    }

    public void onEvent(e eVar) {
        if (eVar.v == 0) {
            Friend d = this.d.d(eVar.r);
            if (d != null) {
                this.h.a(d);
                this.g.post(new C0615s(this));
            }
        }
    }

    public void onEvent(j jVar) {
        Log.e("FRR", "Unfollow Message by from uid " + jVar.l);
        runOnUiThread(new C0616t(this, jVar));
    }

    public void onEvent(cn.com.smartdevices.bracelet.relation.b.a aVar) {
        if (aVar.a == 1 && aVar.d) {
            this.i.setVisibility(8);
            this.g.setVisibility(0);
            this.h.a(0, aVar.c);
            this.h.notifyDataSetChanged();
        }
    }

    public void onEvent(c cVar) {
        if (cVar.a) {
            Friend b = this.h.b(cVar.b);
            if (b != null) {
                b.u++;
                this.g.post(new C0619w(this));
            }
        }
    }

    public void onEvent(d dVar) {
        if (dVar.a) {
            Friend b = this.h.b(dVar.c);
            if (b != null) {
                b.w = System.currentTimeMillis();
                this.h.notifyDataSetChanged();
            }
        }
    }

    public void onEvent(cn.com.smartdevices.bracelet.relation.b.e eVar) {
        if (eVar.e) {
            this.h.a();
        }
        this.g.post(new C0617u(this, eVar));
    }

    public void onEvent(f fVar) {
        if (fVar.a == 1) {
            this.h.a(fVar.b);
            if (this.h.getCount() == 0) {
                this.i.setVisibility(0);
                this.g.setVisibility(8);
                return;
            }
            this.i.setVisibility(8);
            this.g.setVisibility(0);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        startActivity(DetailActivity.a((Context) this, (Friend) adapterView.getAdapter().getItem(i)));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_more) {
            return super.onOptionsItemSelected(menuItem);
        }
        f();
        return true;
    }

    public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
        this.d.a(0, 10, true, false, true);
    }

    public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
        this.d.a(this.h.getCount(), 10, false, true, true);
    }

    protected void onResume() {
        super.onResume();
        b();
        C0401a.a((Context) this, C0409b.aA, C0410c.t, this.l == 0 ? Constants.VIA_RESULT_SUCCESS : Constants.VIA_TO_TYPE_QQ_GROUP);
    }

    public void run() {
        List c = this.d.c();
        int size = c.size();
        List arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(Long.valueOf(((Friend) c.get(i)).n));
        }
        List<cn.com.smartdevices.bracelet.relation.db.f> d = this.d.d();
        if (d != null && c != null) {
            for (cn.com.smartdevices.bracelet.relation.db.f fVar : d) {
                if (fVar.t == 0 && !arrayList.contains(Long.valueOf(fVar.q))) {
                    this.d.b(fVar.q);
                    C0596r.e(c, "Delete message from uid " + fVar.q);
                }
            }
        }
    }
}
