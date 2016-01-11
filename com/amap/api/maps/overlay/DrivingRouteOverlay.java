package com.amap.api.maps.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amap.api.mapcore.n;
import com.amap.api.mapcore.util.s;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveStep;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DrivingRouteOverlay extends RouteOverlay {
    private DrivePath a;
    private List<LatLonPoint> b;
    private List<Marker> c;
    private boolean d;
    private Context e;

    public DrivingRouteOverlay(Context context, AMap aMap, DrivePath drivePath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        this(context, aMap, drivePath, latLonPoint, latLonPoint2, null);
        this.e = context;
    }

    public DrivingRouteOverlay(Context context, AMap aMap, DrivePath drivePath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2, List<LatLonPoint> list) {
        super(context);
        this.c = new ArrayList();
        this.d = true;
        this.mAMap = aMap;
        this.a = drivePath;
        this.startPoint = a.a(latLonPoint);
        this.endPoint = a.a(latLonPoint2);
        this.b = list;
        this.e = context;
    }

    private void a() {
        if (this.b != null && this.b.size() > 0) {
            for (int i = 0; i < this.b.size(); i++) {
                LatLonPoint latLonPoint = (LatLonPoint) this.b.get(i);
                if (latLonPoint != null) {
                    this.c.add(this.mAMap.addMarker(new MarkerOptions().position(new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude())).visible(this.d).icon(b()).title("\u9014\u7ecf\u70b9")));
                }
            }
        }
    }

    private BitmapDescriptor b() {
        Throwable th;
        Throwable th2;
        Throwable th3;
        Bitmap a;
        InputStream inputStream = null;
        InputStream open;
        try {
            Bitmap decodeStream;
            open = s.a(this.e).open("amap_throughpoint.png");
            try {
                decodeStream = BitmapFactory.decodeStream(open);
            } catch (Throwable th22) {
                th = th22;
                Object obj = inputStream;
                th3 = th;
                try {
                    th3.printStackTrace();
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable th32) {
                            th32.printStackTrace();
                        }
                    }
                    return BitmapDescriptorFactory.fromBitmap(a);
                } catch (Throwable th4) {
                    th22 = th4;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable th322) {
                            th322.printStackTrace();
                        }
                    }
                    throw th22;
                }
            }
            try {
                a = u.a(decodeStream, n.a);
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable th3222) {
                        th3222.printStackTrace();
                    }
                }
            } catch (Throwable th222) {
                th = th222;
                a = decodeStream;
                th3222 = th;
                th3222.printStackTrace();
                if (open != null) {
                    open.close();
                }
                return BitmapDescriptorFactory.fromBitmap(a);
            }
        } catch (Throwable th5) {
            th222 = th5;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw th222;
        }
        return BitmapDescriptorFactory.fromBitmap(a);
    }

    public void addToMap() {
        try {
            List steps = this.a.getSteps();
            for (int i = 0; i < steps.size(); i++) {
                DriveStep driveStep = (DriveStep) steps.get(i);
                LatLng a = a.a((LatLonPoint) driveStep.getPolyline().get(0));
                LatLng a2;
                if (i < steps.size() - 1) {
                    if (i == 0) {
                        this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(this.startPoint, a).color(getDriveColor()).width(getBuslineWidth())));
                    }
                    if (!a.a((LatLonPoint) driveStep.getPolyline().get(driveStep.getPolyline().size() - 1)).equals(a.a((LatLonPoint) ((DriveStep) steps.get(i + 1)).getPolyline().get(0)))) {
                        this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(r5, a2).color(getDriveColor()).width(getBuslineWidth())));
                    }
                } else {
                    a2 = a.a((LatLonPoint) driveStep.getPolyline().get(driveStep.getPolyline().size() - 1));
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a2, this.endPoint).color(getDriveColor()).width(getBuslineWidth())));
                }
                this.stationMarkers.add(this.mAMap.addMarker(new MarkerOptions().position(a).title("\u65b9\u5411:" + driveStep.getAction() + "\n\u9053\u8def:" + driveStep.getRoad()).snippet(driveStep.getInstruction()).visible(this.nodeIconVisible).anchor(0.5f, 0.5f).icon(getDriveBitmapDescriptor())));
                this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().addAll(a.a(driveStep.getPolyline())).color(getDriveColor()).width(getBuslineWidth())));
            }
            addStartAndEndMarker();
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected float getBuslineWidth() {
        return 18.0f;
    }

    protected LatLngBounds getLatLngBounds() {
        Builder builder = LatLngBounds.builder();
        builder.include(new LatLng(this.startPoint.latitude, this.startPoint.longitude));
        builder.include(new LatLng(this.endPoint.latitude, this.endPoint.longitude));
        if (this.b != null && this.b.size() > 0) {
            for (int i = 0; i < this.b.size(); i++) {
                builder.include(new LatLng(((LatLonPoint) this.b.get(i)).getLatitude(), ((LatLonPoint) this.b.get(i)).getLongitude()));
            }
        }
        return builder.build();
    }

    public void removeFromMap() {
        try {
            super.removeFromMap();
            if (this.c != null && this.c.size() > 0) {
                for (int i = 0; i < this.c.size(); i++) {
                    ((Marker) this.c.get(i)).remove();
                }
                this.c.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setThroughPointIconVisibility(boolean z) {
        try {
            this.d = z;
            if (this.c != null && this.c.size() > 0) {
                for (int i = 0; i < this.c.size(); i++) {
                    ((Marker) this.c.get(i)).setVisible(z);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
