package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.gps.e.c;
import cn.com.smartdevices.bracelet.gps.e.h;
import cn.com.smartdevices.bracelet.gps.e.n;
import cn.com.smartdevices.bracelet.gps.services.a.a;
import cn.com.smartdevices.bracelet.gps.services.az;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition.Builder;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;

public class C0541x extends Fragment implements a {
    public static final String a = "init_cost_time";
    public static final String b = "init_distance";
    private AMap c = null;
    private Builder d = null;
    private boolean e = false;
    private MapView f = null;
    private TextView g = null;
    private TextView h = null;
    private final String i = "GPSMainMapFragment";
    private final h j = c.a();
    private TextView k = null;

    private View a(LayoutInflater layoutInflater) {
        Bundle arguments = getArguments();
        float f = arguments == null ? 0.0f : arguments.getFloat(b);
        long j = arguments == null ? 0 : arguments.getLong(a);
        View inflate = layoutInflater.inflate(j.fragment_running_gps_main_map, null);
        this.h = (TextView) inflate.findViewById(i.total_distance);
        this.k = (TextView) inflate.findViewById(i.distance_unit);
        this.g = (TextView) inflate.findViewById(i.total_cost_time);
        this.f = (MapView) inflate.findViewById(i.map);
        cn.com.smartdevices.bracelet.gps.e.j a = this.j.a((double) (f / 1000.0f));
        if (n.Mile == a.b) {
            this.k.setText(getResources().getString(com.xiaomi.hm.health.b.a.n.running_mile));
        }
        this.h.setText(a((float) a.a));
        this.g.setText(b(j));
        return inflate;
    }

    private String a(float f) {
        return cn.com.smartdevices.bracelet.gps.ui.b.a.b(f);
    }

    private void a(View view, Bundle bundle) {
        this.f = (MapView) view.findViewById(i.map);
        this.f.onCreate(bundle);
        this.c = this.f.getMap();
        UiSettings uiSettings = this.c.getUiSettings();
        uiSettings.setRotateGesturesEnabled(false);
        uiSettings.setScaleControlsEnabled(false);
        uiSettings.setTiltGesturesEnabled(false);
        uiSettings.setZoomControlsEnabled(false);
        uiSettings.setMyLocationButtonEnabled(false);
        this.c.setOnMapLoadedListener((OnMapLoadedListener) getActivity());
        this.c.setMyLocationEnabled(false);
        this.c.setMyLocationType(1);
        this.c.setOnMyLocationChangeListener(new C0542y(this));
    }

    private String b(long j) {
        return cn.com.smartdevices.bracelet.gps.ui.b.a.a(j, true);
    }

    private void e() {
        float maxZoomLevel = this.c.getMaxZoomLevel();
        if (maxZoomLevel >= 10.0f) {
            maxZoomLevel -= 3.0f;
        }
        this.d = new Builder().zoom(maxZoomLevel).bearing(0.0f).tilt(0.0f);
    }

    public AMap a() {
        return this.c;
    }

    public void a(int i, boolean z) {
    }

    public void a(long j) {
        if (this.g != null) {
            this.g.setText(b(j));
        }
    }

    public void a(az azVar) {
        if (this.h != null) {
            this.h.setText(a((float) this.j.a((double) (azVar.l() / 1000.0f)).a));
        }
    }

    public MapView b() {
        return this.f;
    }

    public void b(int i, int i2) {
    }

    public void c() {
        if (this.f != null) {
            this.f.onPause();
        }
    }

    public void d() {
        if (this.f != null) {
            this.f.onResume();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = a(layoutInflater);
        a(a, bundle);
        e();
        return a;
    }

    public void onDestroy() {
        this.f.removeAllViews();
        this.f.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }
}
