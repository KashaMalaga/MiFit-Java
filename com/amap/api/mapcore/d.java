package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.x;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.xiaomi.hm.health.t;
import kankan.wheel.widget.a;

class d extends Handler {
    final /* synthetic */ AMapDelegateImpGLSurfaceView a;

    d(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.a = aMapDelegateImpGLSurfaceView;
    }

    public void handleMessage(Message message) {
        if (message != null && !this.a.ao.booleanValue()) {
            this.a.e(false);
            k kVar;
            int b;
            switch (message.what) {
                case a.k /*2*/:
                    Toast.makeText(this.a.s, x.b, 0).show();
                    break;
                case a.bd /*10*/:
                    CameraPosition cameraPosition = (CameraPosition) message.obj;
                    if (!(cameraPosition == null || this.a.I == null)) {
                        this.a.I.onCameraChange(cameraPosition);
                        break;
                    }
                case a.aW /*11*/:
                    if (this.a.au != null) {
                        try {
                            this.a.a(this.a.au);
                        } catch (Throwable th) {
                            az.a(th, "AMapDelegateImpGLSurfaceView", "onMapLoaded");
                            th.printStackTrace();
                        }
                    }
                    if (this.a.H != null) {
                        this.a.H.onMapLoaded();
                        break;
                    }
                    break;
                case a.be /*12*/:
                    kVar = (k) message.obj;
                    if (kVar != null) {
                        this.a.a.a(kVar);
                        break;
                    }
                    break;
                case t.WeightView_wv_bmi_size /*13*/:
                    if (this.a.ae != null && this.a.ae.h()) {
                        switch (this.a.ae.j()) {
                            case a.k /*2*/:
                                kVar = k.a(new IPoint(this.a.ae.b(), this.a.ae.c()), this.a.ae.d(), this.a.ae.e(), this.a.ae.f());
                                if (this.a.ae.a()) {
                                    kVar.p = true;
                                }
                                kVar.n = this.a.ae.k();
                                this.a.a.a(kVar);
                                break;
                            default:
                                b = this.a.ae.b() - this.a.af;
                                int c = this.a.ae.c() - this.a.ag;
                                this.a.af = this.a.ae.b();
                                this.a.ag = this.a.ae.c();
                                FPoint fPoint = new FPoint((float) (b + (this.a.getWidth() / 2)), (float) (c + (this.a.getHeight() / 2)));
                                FPoint fPoint2 = new FPoint();
                                this.a.u.win2Map((int) fPoint.x, (int) fPoint.y, fPoint2);
                                IPoint iPoint = new IPoint();
                                this.a.u.map2Geo(fPoint2.x, fPoint2.y, iPoint);
                                kVar = k.a(iPoint);
                                if (this.a.ae.a()) {
                                    kVar.p = true;
                                }
                                this.a.a.a(kVar);
                                break;
                        }
                    }
                case t.WeightView_wv_tips /*14*/:
                    if (this.a.C != null) {
                        this.a.C.b();
                        break;
                    }
                    return;
                case a.aV /*15*/:
                    this.a.g();
                    break;
                case a.bp /*16*/:
                    Bitmap bitmap = (Bitmap) message.obj;
                    if (bitmap != null) {
                        Canvas canvas = new Canvas(bitmap);
                        if (this.a.A != null) {
                            this.a.A.onDraw(canvas);
                        }
                        if (!(this.a.Q == null || this.a.R == null)) {
                            Bitmap drawingCache = this.a.Q.getDrawingCache(true);
                            if (drawingCache != null) {
                                canvas.drawBitmap(drawingCache, (float) this.a.Q.getLeft(), (float) this.a.Q.getTop(), new Paint());
                            }
                        }
                        if (this.a.ar != null) {
                            this.a.ar.onMapPrint(new BitmapDrawable(this.a.getResources(), bitmap));
                        }
                        if (this.a.as != null) {
                            this.a.as.onMapScreenShot(bitmap);
                        }
                    } else {
                        if (this.a.ar != null) {
                            this.a.ar.onMapPrint(null);
                        }
                        if (this.a.as != null) {
                            this.a.as.onMapScreenShot(null);
                        }
                    }
                    this.a.ar = null;
                    this.a.as = null;
                    break;
                case a.bu /*17*/:
                    if (!(this.a.Q == null || this.a.S == null)) {
                        this.a.Q.setVisibility(0);
                    }
                    if (this.a.ah == null || !this.a.ai) {
                        this.a.a(true, null);
                    }
                    if (this.a.ah != null) {
                        this.a.ak = true;
                        this.a.ah.onFinish();
                        this.a.ak = false;
                    }
                    if (!this.a.al) {
                        this.a.ah = null;
                        break;
                    } else {
                        this.a.al = false;
                        break;
                    }
                case a.br /*18*/:
                    b = this.a.getWidth();
                    int height = this.a.getHeight();
                    if (b > 0 && height > 0) {
                        try {
                            CameraPosition l = this.a.l();
                            MapProjection.lonlat2Geo(l.target.longitude, l.target.latitude, new IPoint());
                            MapProjection mapProjection = new MapProjection(this.a.r);
                            mapProjection.setCameraHeaderAngle(l.tilt);
                            mapProjection.setMapAngle(l.bearing);
                            mapProjection.setMapZoomer(l.zoom);
                            mapProjection.recalculate();
                            DPoint dPoint = new DPoint();
                            this.a.a(mapProjection, 0, 0, dPoint);
                            LatLng latLng = new LatLng(dPoint.y, dPoint.x, false);
                            this.a.a(mapProjection, b, 0, dPoint);
                            LatLng latLng2 = new LatLng(dPoint.y, dPoint.x, false);
                            this.a.a(mapProjection, 0, height, dPoint);
                            LatLng latLng3 = new LatLng(dPoint.y, dPoint.x, false);
                            this.a.a(mapProjection, b, height, dPoint);
                            this.a.aV = LatLngBounds.builder().include(latLng3).include(new LatLng(dPoint.y, dPoint.x, false)).include(latLng).include(latLng2).build();
                            mapProjection.recycle();
                            break;
                        } catch (Throwable th2) {
                            break;
                        }
                    }
                    this.a.aV = null;
                    break;
                case a.bs /*19*/:
                    try {
                        this.a.C();
                        this.a.j(true);
                        break;
                    } catch (Throwable th3) {
                        az.a(th3, "AMapDelegateImpGLSurfaceView", "CREATEMAP");
                        th3.printStackTrace();
                        break;
                    }
                case a.aF /*20*/:
                    if (this.a.ae.a() || !(this.a.ae.j() == 1 || this.a.d == null)) {
                        this.a.d.b(false);
                    }
                    if (this.a.d != null) {
                        this.a.d.a(message.arg1 != 0);
                        break;
                    }
                    break;
                case com.xiaomi.hm.health.bt.profile.a.a.Z /*21*/:
                    if (this.a.c != null) {
                        this.a.c.a(this.a.z());
                        break;
                    }
                    break;
                case com.xiaomi.hm.health.bt.profile.a.a.aa /*22*/:
                    this.a.S();
                    break;
            }
            this.a.e(false);
        }
    }
}
