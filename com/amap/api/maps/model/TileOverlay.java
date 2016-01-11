package com.amap.api.maps.model;

import com.amap.api.mapcore.af;

public final class TileOverlay {
    private af a;

    public TileOverlay(af afVar) {
        this.a = afVar;
    }

    public void clearTileCache() {
        this.a.b();
    }

    public boolean equals(Object obj) {
        return !(obj instanceof TileOverlay) ? false : this.a.a(((TileOverlay) obj).a);
    }

    public String getId() {
        return this.a.c();
    }

    public float getZIndex() {
        return this.a.d();
    }

    public int hashCode() {
        return this.a.f();
    }

    public boolean isVisible() {
        return this.a.e();
    }

    public void remove() {
        this.a.a();
    }

    public void setVisible(boolean z) {
        this.a.a(z);
    }

    public void setZIndex(float f) {
        this.a.a(f);
    }
}
