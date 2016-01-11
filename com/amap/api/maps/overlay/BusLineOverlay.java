package com.amap.api.maps.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.amap.api.mapcore.n;
import com.amap.api.mapcore.util.s;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import com.xiaomi.e.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BusLineOverlay {
    private BusLineItem a;
    private AMap b;
    private ArrayList<Marker> c = new ArrayList();
    private Polyline d;
    private List<BusStationItem> e;
    private BitmapDescriptor f;
    private BitmapDescriptor g;
    private BitmapDescriptor h;
    private Context i;

    public BusLineOverlay(Context context, AMap aMap, BusLineItem busLineItem) {
        this.i = context;
        this.a = busLineItem;
        this.b = aMap;
        this.e = this.a.getBusStations();
    }

    private BitmapDescriptor a(String str) {
        InputStream open;
        Bitmap a;
        IOException e;
        IOException iOException;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Object obj;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            open = s.a(this.i).open(str);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                try {
                    a = u.a(decodeStream, n.a);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    iOException = e3;
                    a = decodeStream;
                    e2 = iOException;
                    try {
                        e2.printStackTrace();
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return BitmapDescriptorFactory.fromBitmap(a);
                    } catch (Throwable th4) {
                        th = th4;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    a = decodeStream;
                    th3 = th2;
                    th3.printStackTrace();
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    return BitmapDescriptorFactory.fromBitmap(a);
                }
            } catch (IOException e32) {
                iOException = e32;
                obj = inputStream2;
                e2222 = iOException;
                e2222.printStackTrace();
                if (open != null) {
                    open.close();
                }
                return BitmapDescriptorFactory.fromBitmap(a);
            } catch (Throwable th52) {
                th2 = th52;
                obj = inputStream2;
                th3 = th2;
                th3.printStackTrace();
                if (open != null) {
                    open.close();
                }
                return BitmapDescriptorFactory.fromBitmap(a);
            }
        } catch (IOException e322) {
            open = inputStream2;
            inputStream = inputStream2;
            e2222 = e322;
            a = inputStream;
            e2222.printStackTrace();
            if (open != null) {
                open.close();
            }
            return BitmapDescriptorFactory.fromBitmap(a);
        } catch (Throwable th6) {
            th52 = th6;
            open = inputStream2;
            if (open != null) {
                open.close();
            }
            throw th52;
        }
        return BitmapDescriptorFactory.fromBitmap(a);
    }

    private LatLngBounds a(List<LatLonPoint> list) {
        Builder builder = LatLngBounds.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.include(new LatLng(((LatLonPoint) list.get(i)).getLatitude(), ((LatLonPoint) list.get(i)).getLongitude()));
        }
        return builder.build();
    }

    private MarkerOptions a(int i) {
        MarkerOptions snippet = new MarkerOptions().position(new LatLng(((BusStationItem) this.e.get(i)).getLatLonPoint().getLatitude(), ((BusStationItem) this.e.get(i)).getLatLonPoint().getLongitude())).title(getTitle(i)).snippet(getSnippet(i));
        if (i == 0) {
            snippet.icon(getStartBitmapDescriptor());
        } else if (i == this.e.size() - 1) {
            snippet.icon(getEndBitmapDescriptor());
        } else {
            snippet.anchor(0.5f, 0.5f);
            snippet.icon(getBusBitmapDescriptor());
        }
        return snippet;
    }

    private void a() {
        if (this.f != null) {
            this.f.recycle();
            this.f = null;
        }
        if (this.g != null) {
            this.g.recycle();
            this.g = null;
        }
        if (this.h != null) {
            this.h.recycle();
            this.h = null;
        }
    }

    public void addToMap() {
        int i = 1;
        try {
            this.d = this.b.addPolyline(new PolylineOptions().addAll(a.a(this.a.getDirectionsCoordinates())).color(getBusColor()).width(getBuslineWidth()));
            if (this.e.size() >= 1) {
                while (i < this.e.size() - 1) {
                    this.c.add(this.b.addMarker(a(i)));
                    i++;
                }
                this.c.add(this.b.addMarker(a(0)));
                this.c.add(this.b.addMarker(a(this.e.size() - 1)));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected BitmapDescriptor getBusBitmapDescriptor() {
        this.h = a("amap_bus.png");
        return this.h;
    }

    protected int getBusColor() {
        return Color.parseColor("#537edc");
    }

    public int getBusStationIndex(Marker marker) {
        for (int i = 0; i < this.c.size(); i++) {
            if (((Marker) this.c.get(i)).equals(marker)) {
                return i;
            }
        }
        return -1;
    }

    public BusStationItem getBusStationItem(int i) {
        return (i < 0 || i >= this.e.size()) ? null : (BusStationItem) this.e.get(i);
    }

    protected float getBuslineWidth() {
        return 18.0f;
    }

    protected BitmapDescriptor getEndBitmapDescriptor() {
        this.g = a("amap_end.png");
        return this.g;
    }

    protected String getSnippet(int i) {
        return a.f;
    }

    protected BitmapDescriptor getStartBitmapDescriptor() {
        this.f = a("amap_start.png");
        return this.f;
    }

    protected String getTitle(int i) {
        return ((BusStationItem) this.e.get(i)).getBusStationName();
    }

    public void removeFromMap() {
        if (this.d != null) {
            this.d.remove();
        }
        try {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((Marker) it.next()).remove();
            }
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void zoomToSpan() {
        if (this.b != null) {
            try {
                List directionsCoordinates = this.a.getDirectionsCoordinates();
                if (directionsCoordinates != null && directionsCoordinates.size() > 0) {
                    this.b.moveCamera(CameraUpdateFactory.newLatLngBounds(a(directionsCoordinates), 5));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
