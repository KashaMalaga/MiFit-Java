package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.a.b;
import com.huami.android.ui.ActionBarActivity;
import com.huami.android.widget.share.p;
import com.huami.android.widget.share.q;
import com.huami.android.widget.share.s;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;

public class WatermarkShareActivity extends ActionBarActivity implements OnClickListener, p, s {
    private static final String b = "WatermarkShareActivity";
    boolean a;
    private ImageView c;
    private String d;
    private q e;

    public WatermarkShareActivity() {
        super(C0401a.aA, C0401a.aC);
    }

    public WatermarkShareActivity(String str, String str2) {
        super(C0401a.aA, C0401a.aC);
    }

    private void c() {
        getActionBar().setTitle(n.running_share);
    }

    private void d() {
        if (findViewById(i.share_pane_container) != null) {
            this.e = new q();
            Bundle bundle = new Bundle();
            bundle.putBoolean(v.e, true);
            this.e.setArguments(bundle);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.add(i.share_pane_container, this.e);
            this.e.a((s) this);
            this.e.a((p) this);
            this.e.a((OnClickListener) this);
            beginTransaction.commit();
        }
    }

    public static boolean start(Context context, String str) {
        Intent intent = new Intent(context, WatermarkShareActivity.class);
        intent.putExtra("photo_path", str);
        context.startActivity(intent);
        return true;
    }

    public void a() {
        b.c(this, this.a);
        super.a();
    }

    public void a(int i) {
    }

    public void a(int i, int i2, String str) {
    }

    public void b() {
        runOnUiThread(new bE(this));
    }

    public void b(int i) {
        C0596r.e(b, "Share success" + i);
        C0401a.a((Context) this, C0409b.C);
    }

    public void onBackPressed() {
        a();
    }

    public void onClick(View view) {
        this.a = true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(j.activity_running_watermark_share);
        c();
        Intent intent = getIntent();
        if (intent != null) {
            this.d = intent.getStringExtra("photo_path");
        }
        d();
        this.c = (ImageView) findViewById(i.tv_photo);
        this.c.setImageURI(Uri.parse(this.d));
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.aC);
        C0401a.b((Activity) this);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.aC);
        C0401a.a((Activity) this);
    }
}
