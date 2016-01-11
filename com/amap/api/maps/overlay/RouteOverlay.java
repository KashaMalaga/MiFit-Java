package com.amap.api.maps.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import java.util.ArrayList;
import java.util.List;

public class RouteOverlay {
    private Context a;
    protected List<Polyline> allPolyLines = new ArrayList();
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    protected Marker endMarker;
    protected LatLng endPoint;
    private Bitmap f;
    protected AMap mAMap;
    protected boolean nodeIconVisible = true;
    protected Marker startMarker;
    protected LatLng startPoint;
    protected List<Marker> stationMarkers = new ArrayList();

    public RouteOverlay(Context context) {
        this.a = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.maps.model.BitmapDescriptor a(android.graphics.Bitmap r4, java.lang.String r5) {
        /*
        r3 = this;
        r1 = 0;
        r0 = r3.a;	 Catch:{ IOException -> 0x0024, all -> 0x0036 }
        r0 = com.amap.api.mapcore.util.s.a(r0);	 Catch:{ IOException -> 0x0024, all -> 0x0036 }
        r1 = r0.open(r5);	 Catch:{ IOException -> 0x0024, all -> 0x0036 }
        r4 = android.graphics.BitmapFactory.decodeStream(r1);	 Catch:{ IOException -> 0x0045, all -> 0x0036 }
        r0 = com.amap.api.mapcore.n.a;	 Catch:{ IOException -> 0x0045, all -> 0x0036 }
        r0 = com.amap.api.mapcore.util.u.a(r4, r0);	 Catch:{ IOException -> 0x0045, all -> 0x0036 }
        if (r1 == 0) goto L_0x001a;
    L_0x0017:
        r1.close();	 Catch:{ IOException -> 0x001f }
    L_0x001a:
        r0 = com.amap.api.maps.model.BitmapDescriptorFactory.fromBitmap(r0);
        return r0;
    L_0x001f:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x001a;
    L_0x0024:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0028:
        r1.printStackTrace();	 Catch:{ all -> 0x0042 }
        if (r2 == 0) goto L_0x001a;
    L_0x002d:
        r2.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x001a;
    L_0x0031:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x001a;
    L_0x0036:
        r0 = move-exception;
    L_0x0037:
        if (r1 == 0) goto L_0x003c;
    L_0x0039:
        r1.close();	 Catch:{ IOException -> 0x003d }
    L_0x003c:
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x003c;
    L_0x0042:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0037;
    L_0x0045:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.overlay.RouteOverlay.a(android.graphics.Bitmap, java.lang.String):com.amap.api.maps.model.BitmapDescriptor");
    }

    private void a() {
        if (this.b != null) {
            this.b.recycle();
            this.b = null;
        }
        if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
        if (this.d != null) {
            this.d.recycle();
            this.d = null;
        }
        if (this.e != null) {
            this.e.recycle();
            this.e = null;
        }
        if (this.f != null) {
            this.f.recycle();
            this.f = null;
        }
    }

    protected void addStartAndEndMarker() {
        this.startMarker = this.mAMap.addMarker(new MarkerOptions().position(this.startPoint).icon(getStartBitmapDescriptor()).title("\u8d77\u70b9"));
        this.endMarker = this.mAMap.addMarker(new MarkerOptions().position(this.endPoint).icon(getEndBitmapDescriptor()).title("\u7ec8\u70b9"));
    }

    protected BitmapDescriptor getBusBitmapDescriptor() {
        return a(this.d, "amap_bus.png");
    }

    protected int getBusColor() {
        return Color.parseColor("#537edc");
    }

    protected BitmapDescriptor getDriveBitmapDescriptor() {
        return a(this.f, "amap_car.png");
    }

    protected int getDriveColor() {
        return Color.parseColor("#537edc");
    }

    protected BitmapDescriptor getEndBitmapDescriptor() {
        return a(this.c, "amap_end.png");
    }

    protected LatLngBounds getLatLngBounds() {
        Builder builder = LatLngBounds.builder();
        builder.include(new LatLng(this.startPoint.latitude, this.startPoint.longitude));
        builder.include(new LatLng(this.endPoint.latitude, this.endPoint.longitude));
        return builder.build();
    }

    protected BitmapDescriptor getStartBitmapDescriptor() {
        return a(this.b, "amap_start.png");
    }

    protected BitmapDescriptor getWalkBitmapDescriptor() {
        return a(this.e, "amap_man.png");
    }

    protected int getWalkColor() {
        return Color.parseColor("#6db74d");
    }

    public void removeFromMap() {
        if (this.startMarker != null) {
            this.startMarker.remove();
        }
        if (this.endMarker != null) {
            this.endMarker.remove();
        }
        for (Marker remove : this.stationMarkers) {
            remove.remove();
        }
        for (Polyline remove2 : this.allPolyLines) {
            remove2.remove();
        }
        a();
    }

    public void setNodeIconVisibility(boolean z) {
        try {
            this.nodeIconVisible = z;
            if (this.stationMarkers != null && this.stationMarkers.size() > 0) {
                for (int i = 0; i < this.stationMarkers.size(); i++) {
                    ((Marker) this.stationMarkers.get(i)).setVisible(z);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void zoomToSpan() {
        if (this.startPoint != null && this.mAMap != null) {
            try {
                this.mAMap.animateCamera(CameraUpdateFactory.newLatLngBounds(getLatLngBounds(), 50));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
