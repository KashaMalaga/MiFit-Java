package cn.com.smartdevices.bracelet.gps.ui;

import android.os.AsyncTask;
import android.support.v4.e.a.a;
import cn.com.smartdevices.bracelet.gps.model.c;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.xiaomi.hm.health.b.a.h;
import java.util.LinkedList;
import java.util.List;

class F extends AsyncTask<Long, Void, List<c>> {
    final /* synthetic */ GPSResultActivity a;

    F(GPSResultActivity gPSResultActivity) {
        this.a = gPSResultActivity;
    }

    protected List<c> a(Long... lArr) {
        return cn.com.smartdevices.bracelet.gps.d.c.a(this.a, this.a.G);
    }

    protected void a(List<c> list) {
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(h.running_detail_pause);
        PolylineOptions width = new PolylineOptions().color(a.c).width(10.0f);
        Iterable linkedList = new LinkedList();
        Builder builder = new Builder();
        for (c cVar : list) {
            LatLng latLng = new LatLng(cVar.p, cVar.q);
            linkedList.add(latLng);
            builder.include(latLng);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.icon(fromResource);
            markerOptions.setFlat(false);
            this.a.n.addMarker(markerOptions);
        }
        width.addAll(linkedList);
        this.a.n.addPolyline(width);
        this.a.n.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 10));
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Long[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((List) obj);
    }
}
