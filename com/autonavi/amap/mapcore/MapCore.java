package com.autonavi.amap.mapcore;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.u;
import javax.microedition.khronos.opengles.GL10;

public class MapCore {
    public static final int AM_DATA_BASEMAP = 0;
    public static final int AM_DATA_BMP_BASEMAP = 2;
    public static final int AM_DATA_GEO_BUILDING = 1;
    public static final int AM_DATA_MODEL = 6;
    public static final int AM_DATA_SATELLITE = 3;
    public static final int AM_DATA_SCREEN = 5;
    public static final int AM_DATA_VEC_TMC = 4;
    public static final int MAPRENDER_BASEMAPBEGIN = 1;
    public static final int MAPRENDER_BUILDINGBEGIN = 2;
    public static final int MAPRENDER_ENTER = 0;
    public static final int MAPRENDER_LABELSBEGIN = 3;
    public static final int MAPRENDER_NOMORENEEDRENDER = 5;
    public static final int MAPRENDER_RENDEROVER = 4;
    public static final int TEXTURE_BACKGROUND = 1;
    public static final int TEXTURE_ICON = 0;
    public static final int TEXTURE_RAILWAY = 8;
    public static final int TEXTURE_ROADARROW = 2;
    public static final int TEXTURE_ROADROUND = 3;
    public static final int TEXTURE_TMC_BLACK = 7;
    public static final int TEXTURE_TMC_GREEN = 6;
    public static final int TEXTURE_TMC_RED = 4;
    public static final int TEXTURE_TMC_YELLOW = 5;
    GL10 mGL = null;
    private IMapCallback mMapcallback = null;
    private Object mut_lock = new Object();
    long native_instance = 0;
    public View view;

    static {
        try {
            System.loadLibrary("amapv304");
            System.loadLibrary("amapv304ex");
        } catch (UnsatisfiedLinkError e) {
        }
    }

    public MapCore(Context context) {
        this.native_instance = nativeNewInstance(u.a(context));
    }

    private byte[] OnMapCharsWidthsRequired(int[] iArr, int i, int i2) {
        return this.mMapcallback != null ? this.mMapcallback.OnMapCharsWidthsRequired(this, iArr, i, i2) : new byte[TEXTURE_ICON];
    }

    private void OnMapDataRequired(int i, String[] strArr) {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapDataRequired(this, i, strArr);
        }
    }

    private void OnMapDestory() {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapDestory(this.mGL, this);
        }
    }

    private void OnMapLabelsRequired(int[] iArr, int i) {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapLabelsRequired(this, iArr, i);
        }
    }

    private void OnMapProcessEvent() {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapProcessEvent(this);
        }
    }

    private void OnMapReferencechanged(String str, String str2) {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapReferencechanged(this, str, str2);
        }
    }

    private void OnMapSufaceChanged(int i, int i2) {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapSufaceChanged(this.mGL, this, i, i2);
        }
    }

    private void OnMapSurfaceCreate() {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapSurfaceCreate(this.mGL, this);
        }
    }

    private void OnMapSurfaceRenderer(int i) {
        if (this.mMapcallback != null) {
            this.mMapcallback.OnMapSurfaceRenderer(this.mGL, this, i);
        }
    }

    private static native void nativeDestroy(long j, MapCore mapCore);

    private static native long nativeGetMapstate(long j);

    private static native int nativeGetSelectedMapPois(long j, int i, int i2, int i3, byte[] bArr);

    private static native long nativeNewInstance(String str);

    private static native void nativePutCharbitmap(long j, int i, byte[] bArr);

    private static native void nativePutMapdata(long j, int i, byte[] bArr);

    private static native void nativeSetInternaltexture(long j, byte[] bArr, int i);

    private static native void nativeSetMapstate(long j, long j2);

    private static native void nativeSetStyleData(long j, byte[] bArr, int i);

    private static native void nativeSetparameter(long j, int i, int i2, int i3, int i4, int i5);

    private static native void nativeSurfaceChange(long j, MapCore mapCore, int i, int i2);

    private static native void nativeSurfaceCreate(long j, MapCore mapCore);

    private static native void nativeSurfaceRenderMap(long j, MapCore mapCore);

    public void destroy() {
        try {
            synchronized (this.mut_lock) {
                if (this.native_instance != 0) {
                    nativeDestroy(this.native_instance, this);
                    this.native_instance = 0;
                }
            }
        } catch (Throwable th) {
            az.a(th, "MapCore", "destroy");
            Log.d("minimap", "finalize erro:" + th.getMessage());
        }
    }

    public void drawFrame(GL10 gl10) {
        nativeSurfaceRenderMap(this.native_instance, this);
    }

    public long getInstanceHandle() {
        return this.native_instance;
    }

    public int getLabelBuffer(int i, int i2, int i3, byte[] bArr) {
        return nativeGetSelectedMapPois(this.native_instance, i, i2, i3, bArr);
    }

    public MapProjection getMapstate() {
        return new MapProjection(nativeGetMapstate(this.native_instance));
    }

    public boolean isMapEngineValid() {
        boolean z;
        synchronized (this.mut_lock) {
            z = this.native_instance != 0;
        }
        return z;
    }

    public void putCharbitmap(int i, byte[] bArr) {
        nativePutCharbitmap(this.native_instance, i, bArr);
        if (this.mMapcallback != null) {
            this.mMapcallback.onSetParameter(this);
        }
    }

    public void putMapData(byte[] bArr, int i, int i2, int i3) {
        if (bArr.length == i2 && i == 0) {
            nativePutMapdata(this.native_instance, i3, bArr);
        } else {
            Object obj = new byte[i2];
            System.arraycopy(bArr, i, obj, TEXTURE_ICON, i2);
            nativePutMapdata(this.native_instance, i3, obj);
        }
        if (this.mMapcallback != null) {
            this.mMapcallback.onSetParameter(this);
        }
    }

    public void setGL(GL10 gl10) {
        this.mGL = gl10;
    }

    public void setInternaltexture(byte[] bArr, int i) {
        nativeSetInternaltexture(this.native_instance, bArr, i);
    }

    public void setMapCallback(IMapCallback iMapCallback) {
        this.mMapcallback = iMapCallback;
    }

    public void setMapstate(MapProjection mapProjection) {
        nativeSetMapstate(this.native_instance, mapProjection.getInstanceHandle());
    }

    public void setParameter(int i, int i2, int i3, int i4, int i5) {
        nativeSetparameter(this.native_instance, i, i2, i3, i4, i5);
        if (this.mMapcallback != null) {
            this.mMapcallback.onSetParameter(this);
        }
    }

    public void setStyleData(byte[] bArr, int i) {
        nativeSetStyleData(this.native_instance, bArr, i);
    }

    public void surfaceChange(GL10 gl10, int i, int i2) {
        nativeSurfaceChange(this.native_instance, this, i, i2);
    }

    public void surfaceCreate(GL10 gl10) {
        nativeSurfaceCreate(this.native_instance, this);
    }
}
