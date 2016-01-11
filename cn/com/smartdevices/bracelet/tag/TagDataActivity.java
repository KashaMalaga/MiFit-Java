package cn.com.smartdevices.bracelet.tag;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.gps.ui.C0487a;
import cn.com.smartdevices.bracelet.tag.a.b;
import cn.com.smartdevices.bracelet.tag.a.c;
import cn.com.smartdevices.bracelet.tag.a.i;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.huami.android.view.e;
import com.huami.android.widget.f;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class TagDataActivity extends SystemBarTintActivity implements OnClickListener, i, c {
    public static final String c = "TagDataActivity";
    private static final String h = "action_id";
    private static final String i = "title_key";
    private static final String j = "icon_key";
    private final e A = new i(this);
    private final e B = new j(this);
    boolean d = false;
    WakeLock e;
    public boolean f = false;
    final IntentFilter g = new IntentFilter();
    private int k = 0;
    private c l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private Button q;
    private ImageView r;
    private LinearLayout s;
    private RelativeLayout t;
    private RelativeLayout u;
    private final boolean v = false;
    private Fragment w;
    private int x = 0;
    private final Runnable y = new g(this);
    private final BroadcastReceiver z = new h(this);

    public static Intent a(Context context, b bVar) {
        Intent intent = new Intent(context, TagDataActivity.class);
        intent.putExtra(h, bVar.c);
        intent.putExtra(i, bVar.a);
        intent.putExtra(j, bVar.d);
        return intent;
    }

    private void a() {
        this.k = this.l.a();
        C0596r.b(c, "refreshView|mCurrentStatus:" + this.k);
        Utils.a((Activity) this);
        switch (this.k) {
            case a.i /*0*/:
                f();
                this.n.setVisibility(0);
                this.s.setVisibility(8);
                this.t.setVisibility(8);
                this.p.setVisibility(8);
                this.u.setVisibility(0);
                this.q.setEnabled(true);
                this.q.setText(r.tag_connect);
                return;
            case l.a /*1*/:
                this.n.setVisibility(0);
                this.s.setVisibility(8);
                this.t.setVisibility(0);
                this.p.setVisibility(8);
                this.u.setVisibility(8);
                this.q.setEnabled(false);
                this.q.setText(r.tag_wait);
                return;
            case a.k /*2*/:
                this.n.setVisibility(0);
                this.s.setVisibility(8);
                this.t.setVisibility(8);
                this.p.setVisibility(8);
                this.u.setVisibility(8);
                this.q.setEnabled(true);
                this.q.setText(r.tag_start);
                return;
            case a.l /*3*/:
                this.n.setVisibility(8);
                this.s.setVisibility(0);
                this.t.setVisibility(8);
                this.p.setVisibility(8);
                this.u.setVisibility(8);
                this.q.setText(r.tag_finish);
                return;
            case a.aQ /*4*/:
                f();
                this.n.setVisibility(0);
                this.s.setVisibility(8);
                this.t.setVisibility(8);
                this.p.setVisibility(0);
                this.p.setText(r.tag_error_notice);
                this.u.setVisibility(8);
                this.q.setEnabled(true);
                this.q.setText(r.tag_click_to_retry);
                return;
            case a.bt /*6*/:
                f();
                this.n.setVisibility(0);
                this.s.setVisibility(8);
                this.t.setVisibility(8);
                this.p.setText(r.tag_reconnect_notice);
                this.p.setVisibility(0);
                this.u.setVisibility(8);
                this.q.setEnabled(true);
                this.q.setText(r.tag_start);
                return;
            default:
                return;
        }
    }

    private void b() {
        C0596r.b(c, "onBottomButtonClick|mCurrentStatus" + this.k + ",enable:" + this.q.isEnabled());
        this.q.setEnabled(false);
        switch (this.k) {
            case a.i /*0*/:
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (!defaultAdapter.isEnabled()) {
                    defaultAdapter.enable();
                }
                this.l.h();
                return;
            case a.k /*2*/:
                d();
                return;
            case a.l /*3*/:
                c();
                return;
            default:
                return;
        }
    }

    private void c() {
        C0596r.b(c, "showConfirmDialog");
        Bundle bundle = new Bundle();
        bundle.putString(f.a, getString(r.confirm_complete_tag));
        bundle.putString(a.b, getString(r.label_continue_record));
        C0487a.a(this, bundle).setOpClickListener(this.A);
    }

    private void d() {
        C0596r.b(c, "startCounter|mActionEnabled:" + this.q.isEnabled());
        this.w = b.a(3);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(com.xiaomi.hm.health.e.fade_in, com.xiaomi.hm.health.e.fade_out);
        beginTransaction.replace(com.xiaomi.hm.health.l.fragment_container, this.w);
        beginTransaction.commit();
        findViewById(com.xiaomi.hm.health.l.fragment_container).setVisibility(0);
        this.l.f();
    }

    private void e() {
        C0596r.b(c, "startTimer");
        this.f = false;
        this.o.removeCallbacks(this.y);
        this.o.postDelayed(this.y, 1000);
    }

    private void f() {
        C0596r.b(c, "stopTimer");
        this.f = true;
        this.x = 0;
        this.o.setText("00:00:00");
    }

    private void g() {
        Bundle bundle = new Bundle();
        bundle.putString(f.a, getString(r.confirm_abort_tag));
        bundle.putString(a.b, getString(r.label_continue_record));
        C0487a.a(this, bundle).setOpClickListener(this.B);
    }

    private boolean h() {
        C0596r.b(c, "checkTagStatus|mCurrentStatus:" + this.k);
        if (this.k != 3) {
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString(f.a, getString(r.confirm_abort_tag));
        bundle.putString(a.b, getString(r.label_continue_record));
        C0487a.a(this, bundle).setOpClickListener(this.B);
        return false;
    }

    public void a(int i) {
        C0596r.b(c, "onEvent|event:" + i);
        if (i == 2 && this.w != null && this.w.isAdded() && !this.w.isDetached()) {
            if (!this.d) {
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.setCustomAnimations(com.xiaomi.hm.health.e.fade_in, com.xiaomi.hm.health.e.fade_out);
                beginTransaction.remove(this.w);
                beginTransaction.commit();
            }
            findViewById(com.xiaomi.hm.health.l.fragment_container).setVisibility(8);
            this.q.setEnabled(true);
            e();
        }
    }

    public void b(int i) {
        C0596r.b(c, "onStatusChanged|status:" + i);
        this.q.post(new f(this));
    }

    public void onBackPressed() {
        if (h()) {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        C0596r.b(c, "onClick|id:" + id);
        switch (id) {
            case com.xiaomi.hm.health.l.home_back /*2131296313*/:
                if (h()) {
                    finish();
                    return;
                }
                return;
            case com.xiaomi.hm.health.l.action_button /*2131296395*/:
                b();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0596r.b(c, "onCreate");
        this.e = ((PowerManager) getSystemService("power")).newWakeLock(1, "TagData");
        this.e.acquire();
        setContentView((int) n.activity_tag_data);
        this.m = (TextView) findViewById(com.xiaomi.hm.health.l.name);
        this.r = (ImageView) findViewById(com.xiaomi.hm.health.l.icon);
        this.n = (TextView) findViewById(com.xiaomi.hm.health.l.tag_action_tips);
        this.s = (LinearLayout) findViewById(com.xiaomi.hm.health.l.rl_time);
        TextView textView = (TextView) findViewById(com.xiaomi.hm.health.l.doing_label);
        this.o = (TextView) findViewById(com.xiaomi.hm.health.l.timer);
        this.t = (RelativeLayout) findViewById(com.xiaomi.hm.health.l.rl_connection);
        this.u = (RelativeLayout) findViewById(com.xiaomi.hm.health.l.rl_connection_f);
        this.p = (TextView) findViewById(com.xiaomi.hm.health.l.notice);
        this.q = (Button) findViewById(com.xiaomi.hm.health.l.action_button);
        Intent intent = getIntent();
        Object obj = com.xiaomi.e.a.f;
        String str = com.xiaomi.e.a.f;
        if (intent != null) {
            obj = intent.getStringExtra(h);
            str = getString(intent.getIntExtra(i, 0));
            this.m.setText(str);
            this.r.setBackgroundResource(intent.getIntExtra(j, 0));
        }
        if (TextUtils.isEmpty(obj)) {
            com.huami.android.view.b.a((Context) this, (int) r.action_type_error, 0).show();
            finish();
            return;
        }
        this.d = false;
        this.q.setOnClickListener(this);
        findViewById(com.xiaomi.hm.health.l.home_back).setOnClickListener(this);
        this.g.addAction(BLEService.b);
        registerReceiver(this.z, this.g);
        this.n.setText(getString(r.tag_action_tips, new Object[]{str}));
        textView.setText(getString(r.tag_doing_label, new Object[]{str}));
        this.l = new c(this, obj);
        this.l.a((i) this);
        this.l.b();
        a();
        C0401a.a((Context) this, C0401a.bS, str);
    }

    protected void onDestroy() {
        super.onDestroy();
        C0596r.b(c, "onDestroy");
        this.l.c();
        unregisterReceiver(this.z);
        f();
        this.e.release();
    }

    public void onPause() {
        super.onPause();
        C0401a.b((Activity) this);
        C0401a.b(C0401a.ai);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        this.d = false;
        super.onRestoreInstanceState(bundle);
        C0596r.b(c, "onRestoreInstanceState");
    }

    public void onResume() {
        super.onResume();
        C0401a.a((Activity) this);
        C0401a.a(C0401a.ai);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.d = true;
        super.onSaveInstanceState(bundle);
        C0596r.b(c, "onSaveInstanceState");
    }
}
