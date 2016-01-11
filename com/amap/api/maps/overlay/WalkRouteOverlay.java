package com.amap.api.maps.overlay;

import android.content.Context;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkStep;
import java.util.List;

public class WalkRouteOverlay extends RouteOverlay {
    private WalkPath a;

    public WalkRouteOverlay(Context context, AMap aMap, WalkPath walkPath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        super(context);
        this.mAMap = aMap;
        this.a = walkPath;
        this.startPoint = a.a(latLonPoint);
        this.endPoint = a.a(latLonPoint2);
    }

    public void addToMap() {
        try {
            List steps = this.a.getSteps();
            for (int i = 0; i < steps.size(); i++) {
                WalkStep walkStep = (WalkStep) steps.get(i);
                LatLng a = a.a((LatLonPoint) walkStep.getPolyline().get(0));
                LatLng a2;
                if (i < steps.size() - 1) {
                    if (i == 0) {
                        this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(this.startPoint, a).color(getWalkColor()).width(getBuslineWidth())));
                    }
                    if (!a.a((LatLonPoint) walkStep.getPolyline().get(walkStep.getPolyline().size() - 1)).equals(a.a((LatLonPoint) ((WalkStep) steps.get(i + 1)).getPolyline().get(0)))) {
                        this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(r5, a2).color(getWalkColor()).width(getBuslineWidth())));
                    }
                } else {
                    a2 = a.a((LatLonPoint) walkStep.getPolyline().get(walkStep.getPolyline().size() - 1));
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a2, this.endPoint).color(getWalkColor()).width(getBuslineWidth())));
                }
                this.stationMarkers.add(this.mAMap.addMarker(new MarkerOptions().position(a).title("\u65b9\u5411:" + walkStep.getAction() + "\n\u9053\u8def:" + walkStep.getRoad()).snippet(walkStep.getInstruction()).visible(this.nodeIconVisible).anchor(0.5f, 0.5f).icon(getWalkBitmapDescriptor())));
                this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().addAll(a.a(walkStep.getPolyline())).color(getWalkColor()).width(getBuslineWidth())));
            }
            addStartAndEndMarker();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected float getBuslineWidth() {
        return 18.0f;
    }
}
