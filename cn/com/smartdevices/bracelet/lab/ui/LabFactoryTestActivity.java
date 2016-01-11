package cn.com.smartdevices.bracelet.lab.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gaocept.a;
import cn.com.smartdevices.bracelet.lab.k;
import com.activeandroid.b;
import com.xiaomi.hm.health.bt.d.f;
import com.xiaomi.hm.health.bt.profile.a.o;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LabFactoryTestActivity extends Activity implements f {
    private static final String[] n = new String[]{k.b, "Situp", "Footwalk", "Pushup", "DoubleClick", k.e};
    private static final String[] o = new String[]{"Left,Front", "Left,Reverse", "Right,Front", "Right,Reverse"};
    private final String A = "Lab";
    private o B = null;
    private boolean a = false;
    private String b;
    private Button c;
    private Button d;
    private Button e;
    private Button f;
    private EditText g;
    private TextView h;
    private TextView i;
    private TextView j;
    private Button k;
    private Spinner l;
    private Spinner m;
    private String p;
    private File q;
    private PowerManager r = null;
    private WakeLock s = null;
    private a t = null;
    private cn.com.smartdevices.bracelet.c.a u = null;
    private boolean v = false;
    private int w = 0;
    private boolean x = false;
    private final SimpleDateFormat y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SimpleDateFormat z = new SimpleDateFormat("HH:mm:ss");

    private void a(boolean z) {
        this.c.setEnabled(false);
        this.k.setEnabled(false);
        this.l.setEnabled(false);
        this.m.setEnabled(false);
        this.d.setEnabled(false);
        this.e.setEnabled(false);
        this.f.setEnabled(false);
        try {
            new Builder(this).setTitle("Congratulations!").setMessage("last action count: " + this.t.a(z)).show();
        } catch (Exception e) {
            new Builder(this).setTitle("Test Error").setMessage(e.getMessage()).show();
        }
        this.c.setEnabled(true);
        this.k.setEnabled(true);
        this.l.setEnabled(true);
        this.m.setEnabled(true);
        this.d.setEnabled(true);
        this.e.setEnabled(true);
        this.f.setEnabled(true);
    }

    private void a(boolean z, f fVar) {
        C0596r.e("Lab", " enable = " + z);
        if (z && this.B == null) {
            this.B = new o(com.xiaomi.hm.health.bt.bleservice.a.a());
        }
        if (this.B != null) {
            this.B.a(z, fVar);
        }
    }

    private void d() {
        try {
            ArrayList a = this.u.a();
            new Builder(this).setTitle("Zip success!").setMessage("Zip file length: " + ((long) a.size()) + " B").setPositiveButton("Delete", new C0578n(this, a)).setNegativeButton("Keep", null).show();
        } catch (Exception e) {
            new Builder(this).setTitle("Zip file error").setMessage(e.getMessage()).show();
        }
    }

    private void e() {
        SpinnerAdapter arrayAdapter = new ArrayAdapter(this, 17367050, o);
        arrayAdapter.setDropDownViewResource(17367049);
        this.m.setAdapter(arrayAdapter);
        this.m.setOnItemSelectedListener(new C0579o(this));
    }

    private void f() {
        SpinnerAdapter arrayAdapter = new ArrayAdapter(this, 17367048, n);
        arrayAdapter.setDropDownViewResource(17367049);
        this.l.setAdapter(arrayAdapter);
        this.l.setOnItemSelectedListener(new C0580p(this));
    }

    private void g() {
        C0596r.e("Lab", "startRecord");
        try {
            this.r = (PowerManager) getSystemService("power");
            this.s = this.r.newWakeLock(1, getClass().getCanonicalName());
            this.s.acquire();
            a(true, (f) this);
            this.t.start(this.b, this.p.split(com.xiaomi.mipush.sdk.f.i)[0], this.p.split(com.xiaomi.mipush.sdk.f.i)[1], this.g.getText().toString());
            this.w = 0;
            this.c.setEnabled(true);
            this.v = true;
        } catch (Exception e) {
            C0596r.a("Lab", e.getMessage());
        }
    }

    private void h() {
        C0596r.e("Lab", "stopRecord");
        this.s.release();
        a(false, (f) this);
        try {
            this.t.b();
            a();
        } catch (Exception e) {
            C0596r.a("Lab", e.getMessage());
        } finally {
            this.v = false;
        }
    }

    private void on_empty_button_click() {
        new Builder(this).setTitle("Are you sure to delete data?").setPositiveButton("Delete", new C0586v(this)).setNegativeButton("No", null).show();
    }

    private void on_start_button_click() {
        if (this.a) {
            this.a = false;
            h();
            boolean j = this.t.j();
            this.c.setText("Start");
            this.c.setEnabled(j);
            this.l.setEnabled(j);
            this.m.setEnabled(j);
            this.g.setEnabled(j);
            this.d.setEnabled(j);
            this.e.setEnabled(j);
            this.f.setEnabled(j);
            this.k.setEnabled(true);
            return;
        }
        new Builder(this).setTitle("Are you ready?").setPositiveButton(17039379, new C0588x(this)).setNegativeButton(17039360, new C0587w(this)).show();
    }

    public void a() {
        try {
            if (this.q.exists()) {
                int d = this.t.d();
                boolean z = d > 0;
                String str = "B";
                if (d > b.a) {
                    d /= b.a;
                    str = "KB";
                    if (d > b.a) {
                        d /= b.a;
                        str = "MB";
                        if (d > b.a) {
                            d /= b.a;
                            str = "GB";
                        }
                    }
                }
                this.h.setText(Integer.toString(d) + " " + str);
                this.i.setText(this.t.e());
                this.k.setEnabled(z);
                this.c.setText("Start");
                this.c.setEnabled(true);
                this.l.setEnabled(true);
                this.m.setEnabled(true);
                this.g.setEnabled(true);
                this.d.setEnabled(z);
                this.e.setEnabled(z);
                this.f.setEnabled(z);
                return;
            }
            this.h.setText("No data found");
            this.i.setText(com.xiaomi.e.a.f);
            this.k.setEnabled(false);
        } catch (Exception e) {
            this.h.setText("Read data error");
            this.i.setText(com.xiaomi.e.a.f);
            this.k.setEnabled(false);
            this.c.setText("Start");
            this.c.setEnabled(true);
            this.l.setEnabled(true);
            this.m.setEnabled(true);
            this.g.setEnabled(true);
            this.d.setEnabled(false);
            this.e.setEnabled(false);
            this.f.setEnabled(false);
        }
    }

    public void a(int i) {
    }

    public void a(short s, short s2, short s3) {
        try {
            if (this.t.a(s, s2, s3)) {
                this.w = this.t.c();
                this.x = this.t.g();
                C0596r.e("Lab", "mTotalCount = " + this.w);
                C0596r.e("Lab", "mIsCheat = " + this.x);
                runOnUiThread(new C0585u(this));
                return;
            }
            C0596r.e("Lab", "Failed to analyse this time, current mTotalCount = " + this.w);
        } catch (Exception e) {
            C0596r.a("Lab", e.getMessage());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.activity_lab_factory_test);
        this.c = (Button) findViewById(l.start_button);
        this.c.setEnabled(true);
        this.d = (Button) findViewById(l.test_button);
        this.d.setOnClickListener(new C0577m(this));
        this.e = (Button) findViewById(l.test_button2);
        this.e.setOnClickListener(new C0581q(this));
        this.f = (Button) findViewById(l.upload_button);
        this.f.setOnClickListener(new C0582r(this));
        this.g = (EditText) findViewById(l.custom_text);
        this.h = (TextView) findViewById(l.storage_text);
        this.i = (TextView) findViewById(l.file_text);
        this.j = (TextView) findViewById(l.number_text);
        this.k = (Button) findViewById(l.empty_button);
        this.l = (Spinner) findViewById(l.sport_spinner);
        this.m = (Spinner) findViewById(l.handside_spinner);
        this.c.setText("Start");
        this.c.setOnClickListener(new C0583s(this));
        this.k.setEnabled(true);
        this.k.setOnClickListener(new C0584t(this));
        this.d.setEnabled(true);
        this.e.setEnabled(true);
        this.f.setEnabled(true);
        f();
        e();
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.q = cn.com.smartdevices.bracelet.a.a.d(".MISportLab");
            if (!this.q.exists()) {
                this.q.mkdir();
            }
        } else {
            Toast.makeText(this, "No external storage to save large files, please remount and retry!", 1).show();
            finish();
        }
        this.t = new a(this.q.getAbsolutePath());
        this.u = new cn.com.smartdevices.bracelet.c.a(this.q.getAbsolutePath());
        a();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.xiaomi.hm.health.o.lab_factory_test_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return menuItem.getItemId() == l.action_settings ? true : super.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        if (this.v) {
            h();
        }
        super.onPause();
    }
}
