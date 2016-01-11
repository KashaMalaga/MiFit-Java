package cn.com.smartdevices.bracelet.b;

import cn.com.smartdevices.bracelet.Keeper;
import com.amap.api.maps.model.BitmapDescriptorFactory;

abstract class a implements c {
    a() {
    }

    public float a(int i, long j) {
        return a(i, j, Keeper.readPersonInfoBase().weight);
    }

    public float a(int i, long j, float f) {
        float b = b(i, j);
        return (b <= 0.0f || j <= 0 || f <= 0.0f) ? 0.0f : ((((1.34f * (b - 1.0f)) * f) * ((float) j)) / BitmapDescriptorFactory.HUE_YELLOW) / BitmapDescriptorFactory.HUE_YELLOW;
    }

    protected abstract float b(int i, long j);
}
