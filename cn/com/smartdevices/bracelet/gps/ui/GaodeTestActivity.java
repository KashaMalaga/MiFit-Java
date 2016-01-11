package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.algorithm.TrackStatistics;
import cn.com.smartdevices.bracelet.gps.f.C;
import cn.com.smartdevices.bracelet.gps.f.e;
import cn.com.smartdevices.bracelet.gps.f.f;
import cn.com.smartdevices.bracelet.gps.services.Z;
import com.activeandroid.b;
import com.amap.api.maps.MapView;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.xiaomi.account.openauth.h;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import java.io.IOException;

public class GaodeTestActivity extends Activity implements e {
    Button a;
    Button b;
    Button c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    Z h;
    MapView i;

    private void d() {
        try {
            this.i.onDestroy();
        } catch (Exception e) {
            C0596r.a("Run", e.getMessage());
        }
    }

    private String e() {
        try {
            int n = this.h.n();
            if ((n > 0 ? 1 : null) == null) {
                throw new Exception("gps_lab_all.txt is empty");
            }
            String str = "B";
            if (n > b.a) {
                n /= b.a;
                str = "KB";
                if (n > b.a) {
                    n /= b.a;
                    str = "MB";
                    if (n > b.a) {
                        n /= b.a;
                        str = "GB";
                    }
                }
            }
            return n + " " + str;
        } catch (Exception e) {
            C0596r.e(GeocodeSearch.GPS, e.getMessage());
            return h.P;
        }
    }

    public void a() {
        new Builder(this).setTitle("Are you sure to delete data?").setPositiveButton("Delete", new M(this)).setNegativeButton("No", null).show();
    }

    public void a(f fVar) {
        boolean z = true;
        if (f.SERVICE_READY.equals(fVar)) {
            this.a.setEnabled(true);
            String e = e();
            this.b.setText("Clean " + e);
            this.b.setEnabled(!e.contains(C0410c.j));
            Button button = this.c;
            if (e.contains(C0410c.j)) {
                z = false;
            }
            button.setEnabled(z);
        }
    }

    public void b() {
        try {
            TrackStatistics p = this.h.p();
            if (p != null) {
                CharSequence charSequence = ((a.f + "Distance = " + p.mTotalDistance + "m\n") + "Time = " + p.mTotalTime + "s\n") + "KiloNum = " + p.mLastKilometerNum + "\n";
                for (int i = 0; i < p.mLastKilometerNum; i++) {
                    charSequence = charSequence + (i + 1) + "km: \ntime = " + p.mKilometerTimestamps[i] + "s\nspeed = " + p.mKilometerSpeeds[i] + "m/s\npace = " + p.mKilometerPaces[i] + "s/m" + "\n";
                }
                new Builder(this).setTitle(C0410c.b).setMessage(charSequence).show();
                return;
            }
            throw new Exception("Track is null");
        } catch (Exception e) {
            new Builder(this).setTitle("ERROR").setMessage(e.getMessage()).show();
        }
    }

    public void c() {
        try {
            TrackStatistics o = this.h.o();
            if (o != null) {
                CharSequence charSequence = ((a.f + "Distance = " + o.mTotalDistance + "m\n") + "Time = " + o.mTotalTime + "s\n") + "KiloNum = " + o.mLastKilometerNum + "\n";
                for (int i = 0; i < o.mLastKilometerNum; i++) {
                    charSequence = charSequence + (i + 1) + "km: \ntime = " + o.mKilometerTimestamps[i] + "s\nspeed = " + o.mKilometerSpeeds[i] + "m/s\npace = " + o.mKilometerPaces[i] + "s/m" + "\n";
                }
                new Builder(this).setTitle(C0410c.b).setMessage(charSequence).show();
                return;
            }
            throw new Exception("Track is null");
        } catch (Exception e) {
            new Builder(this).setTitle("ERROR").setMessage(e.getMessage()).show();
        }
    }

    public void onCreate(Bundle bundle) {
        try {
            C0596r.e(GeocodeSearch.GPS, "onCreate-in");
            super.onCreate(bundle);
            setContentView(n.gps_map_route_activity_test_hao);
            this.i = (MapView) findViewById(l.gaode_test_map);
            this.i.onCreate(bundle);
            this.h = new Z(this, new C(this.i.getMap()), cn.com.smartdevices.bracelet.a.a.d(".MISportLab").getAbsolutePath());
            this.h.a(this.i.getMap());
            this.h.d(1);
            this.h.a((e) this);
            this.a = (Button) findViewById(l.gps_start_button);
            this.c = (Button) findViewById(l.gps_test_button);
            this.b = (Button) findViewById(l.gps_clean_button);
            this.a.setEnabled(false);
            this.c.setEnabled(false);
            this.b.setEnabled(false);
            this.d = (TextView) findViewById(l.gps_raw_distance_text);
            this.e = (TextView) findViewById(l.gps_raw_speed_text);
            this.f = (TextView) findViewById(l.gps_new_distance_text);
            this.g = (TextView) findViewById(l.gps_new_speed_text);
            this.a.setOnClickListener(new N(this));
            this.b.setOnClickListener(new O(this));
            this.c.setOnClickListener(new P(this));
            C0596r.e(GeocodeSearch.GPS, "onCreate-out");
        } catch (IOException e) {
            e.printStackTrace();
            C0596r.e(GeocodeSearch.GPS, e.getMessage());
        }
    }

    public void onDestroy() {
        this.h.a((Context) this);
        this.i.onDestroy();
        d();
        super.onDestroy();
        C0596r.e("Run", "onDestroy");
    }

    public void onPause() {
        this.i.setVisibility(8);
        this.i.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.i.setVisibility(0);
        this.i.onResume();
        this.h.a(true);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.i.onSaveInstanceState(bundle);
    }
}
