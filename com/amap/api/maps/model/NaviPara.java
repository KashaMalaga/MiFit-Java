package com.amap.api.maps.model;

public class NaviPara {
    public static final int DRIVING_AVOID_CONGESTION = 4;
    public static final int DRIVING_DEFAULT = 0;
    public static final int DRIVING_NO_HIGHWAY = 3;
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SAVE_MONEY = 1;
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    public static final int DRIVING_SHORT_DISTANCE = 2;
    private int a = DRIVING_DEFAULT;
    private LatLng b;

    public int getNaviStyle() {
        return this.a;
    }

    public LatLng getTargetPoint() {
        return this.b;
    }

    public void setNaviStyle(int i) {
        if (i >= 0 && i < 9) {
            this.a = i;
        }
    }

    public void setTargetPoint(LatLng latLng) {
        this.b = latLng;
    }
}
