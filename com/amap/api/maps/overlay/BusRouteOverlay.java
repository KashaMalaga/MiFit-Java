package com.amap.api.maps.overlay;

import android.content.Context;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.WalkStep;
import java.util.List;

public class BusRouteOverlay extends RouteOverlay {
    private BusPath a;
    private LatLng b;

    public BusRouteOverlay(Context context, AMap aMap, BusPath busPath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        super(context);
        this.a = busPath;
        this.startPoint = a.a(latLonPoint);
        this.endPoint = a.a(latLonPoint2);
        this.mAMap = aMap;
    }

    private LatLonPoint a(BusStep busStep) {
        Doorway exit = busStep.getExit();
        return exit == null ? null : exit.getLatLonPoint();
    }

    private String a(RouteBusLineItem routeBusLineItem) {
        return "(" + routeBusLineItem.getDepartureBusStation().getBusStationName() + "-->" + routeBusLineItem.getArrivalBusStation().getBusStationName() + ") \u7ecf\u8fc7" + (routeBusLineItem.getPassStationNum() + 1) + "\u7ad9";
    }

    private String a(List<WalkStep> list) {
        float f = 0.0f;
        for (WalkStep distance : list) {
            f = distance.getDistance() + f;
        }
        return "\u6b65\u884c" + f + "\u7c73";
    }

    private LatLonPoint b(BusStep busStep) {
        Doorway entrance = busStep.getEntrance();
        return entrance == null ? null : entrance.getLatLonPoint();
    }

    public void addToMap() {
        List steps = this.a.getSteps();
        for (int i = 0; i < steps.size(); i++) {
            LatLng a;
            LatLng a2;
            BusStep busStep = (BusStep) steps.get(i);
            if (i < steps.size() - 1) {
                LatLng a3;
                LatLonPoint b;
                BusStep busStep2 = (BusStep) steps.get(i + 1);
                if (!(busStep.getWalk() == null || busStep.getBusLine() == null)) {
                    a3 = a.a((LatLonPoint) ((WalkStep) busStep.getWalk().getSteps().get(busStep.getWalk().getSteps().size() - 1)).getPolyline().get(((WalkStep) busStep.getWalk().getSteps().get(busStep.getWalk().getSteps().size() - 1)).getPolyline().size() - 1));
                    b = b(busStep);
                    if (b == null) {
                        b = (LatLonPoint) busStep.getBusLine().getPolyline().get(0);
                    }
                    a = a.a(b);
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a3, a).width(getBuslineWidth()).color(getWalkColor())));
                }
                if (!(busStep.getBusLine() == null || busStep2.getWalk() == null)) {
                    LatLonPoint a4 = a(busStep);
                    b = (LatLonPoint) busStep.getBusLine().getPolyline().get(busStep.getBusLine().getPolyline().size() - 1);
                    if (a4 != null) {
                        a = a.a(b);
                        LatLng a5 = a.a(a4);
                        this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a, a5).width(getBuslineWidth()).color(getWalkColor())));
                        b = a4;
                    }
                    try {
                        a3 = a.a(b);
                        a = a.a((LatLonPoint) ((WalkStep) busStep2.getWalk().getSteps().get(0)).getPolyline().get(0));
                        this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a3, a).width(getBuslineWidth()).color(getWalkColor())));
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                if (!(busStep.getBusLine() == null || busStep2.getWalk() != null || busStep2.getBusLine() == null)) {
                    b = a(busStep);
                    if (b == null) {
                        b = (LatLonPoint) busStep.getBusLine().getPolyline().get(busStep.getBusLine().getPolyline().size() - 1);
                    }
                    a3 = a.a(b);
                    b = b(busStep2);
                    if (b == null) {
                        b = (LatLonPoint) busStep2.getBusLine().getPolyline().get(0);
                    }
                    drawLineArrow(a3, a.a(b));
                }
                if (!(busStep.getBusLine() == null || busStep2.getWalk() != null || busStep2.getBusLine() == null)) {
                    a = a.a((LatLonPoint) busStep.getBusLine().getPolyline().get(busStep.getBusLine().getPolyline().size() - 1));
                    a2 = a.a((LatLonPoint) busStep2.getBusLine().getPolyline().get(0));
                    if (a2.latitude - a.latitude > 1.0E-4d || a2.longitude - a.longitude > 1.0E-4d) {
                        drawLineArrow(a, a2);
                    }
                }
                if (!(busStep.getWalk() == null || busStep.getBusLine() == null)) {
                    LatLonPoint b2 = b(busStep);
                    if (b2 == null) {
                        b2 = (LatLonPoint) ((WalkStep) busStep.getWalk().getSteps().get(busStep.getWalk().getSteps().size() - 1)).getPolyline().get(((WalkStep) busStep.getWalk().getSteps().get(busStep.getWalk().getSteps().size() - 1)).getPolyline().size() - 1);
                    }
                    a = a.a(b2);
                    a2 = a.a((LatLonPoint) busStep.getBusLine().getPolyline().get(0));
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a, a2).width(3.0f).color(getWalkColor()).width(getBuslineWidth())));
                }
            }
            if (busStep.getWalk() != null && busStep.getWalk().getSteps().size() > 0) {
                List steps2 = busStep.getWalk().getSteps();
                for (int i2 = 0; i2 < steps2.size(); i2++) {
                    WalkStep walkStep = (WalkStep) steps2.get(i2);
                    a = a.a((LatLonPoint) walkStep.getPolyline().get(0));
                    String road = walkStep.getRoad();
                    String a6 = a(steps2);
                    List a7 = a.a(walkStep.getPolyline());
                    this.b = (LatLng) a7.get(a7.size() - 1);
                    if (i2 == 0) {
                        this.stationMarkers.add(this.mAMap.addMarker(new MarkerOptions().position(a).title(road).snippet(a6).anchor(0.5f, 0.5f).icon(getWalkBitmapDescriptor())));
                    }
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().addAll(a7).color(getWalkColor()).width(getBuslineWidth())));
                    if (i2 < steps2.size() - 1) {
                        if (!((LatLng) a7.get(a7.size() - 1)).equals(a.a((LatLonPoint) ((WalkStep) steps2.get(i2 + 1)).getPolyline().get(0)))) {
                            this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a2, a).width(getBuslineWidth()).color(getWalkColor())));
                        }
                    }
                }
            } else if (busStep.getBusLine() == null) {
                this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(this.b, this.endPoint).color(getWalkColor()).width(getBuslineWidth())));
            }
            if (busStep.getBusLine() != null) {
                RouteBusLineItem busLine = busStep.getBusLine();
                Iterable a8 = a.a(busLine.getPolyline());
                BusStationItem departureBusStation = busLine.getDepartureBusStation();
                this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().addAll(a8).color(getBusColor()).width(getBuslineWidth())));
                this.stationMarkers.add(this.mAMap.addMarker(new MarkerOptions().position(a.a(departureBusStation.getLatLonPoint())).title(busLine.getBusLineName()).snippet(a(busLine)).anchor(0.5f, 0.5f).visible(this.nodeIconVisible).icon(getBusBitmapDescriptor())));
            }
        }
        addStartAndEndMarker();
    }

    public void drawLineArrow(LatLng latLng, LatLng latLng2) {
        this.mAMap.addPolyline(new PolylineOptions().add(latLng, latLng2).width(3.0f).color(getBusColor()).width(getBuslineWidth()));
    }

    protected float getBuslineWidth() {
        return 18.0f;
    }
}
