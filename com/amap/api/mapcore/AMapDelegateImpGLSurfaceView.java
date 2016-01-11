package com.amap.api.mapcore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.view.C0151az;
import android.support.v4.view.a.C0113o;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.o;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.AMap.InfoWindowAdapter;
import com.amap.api.maps.AMap.OnCacheRemoveListener;
import com.amap.api.maps.AMap.OnCameraChangeListener;
import com.amap.api.maps.AMap.OnInfoWindowClickListener;
import com.amap.api.maps.AMap.OnMapClickListener;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.AMap.OnMapLongClickListener;
import com.amap.api.maps.AMap.OnMapScreenShotListener;
import com.amap.api.maps.AMap.OnMapTouchListener;
import com.amap.api.maps.AMap.OnMarkerClickListener;
import com.amap.api.maps.AMap.OnMarkerDragListener;
import com.amap.api.maps.AMap.OnMyLocationChangeListener;
import com.amap.api.maps.AMap.OnPOIClickListener;
import com.amap.api.maps.AMap.onMapPrintScreenListener;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.amap.mapcore.Convert;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapCore;
import com.autonavi.amap.mapcore.MapProjection;
import com.d.a.a.C1012a;
import com.sina.weibo.sdk.utils.AidTask;
import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.File;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class AMapDelegateImpGLSurfaceView extends GLSurfaceView implements Renderer, t {
    private static Handler aG = new Handler();
    private static final double ax = Math.log(2.0d);
    private bc A;
    private ah B;
    private m C;
    private aw D;
    private OnMyLocationChangeListener E;
    private OnMarkerClickListener F;
    private OnMarkerDragListener G;
    private OnMapLoadedListener H;
    private OnCameraChangeListener I;
    private OnMapClickListener J;
    private OnMapTouchListener K;
    private OnPOIClickListener L;
    private OnMapLongClickListener M;
    private OnInfoWindowClickListener N;
    private InfoWindowAdapter O;
    private InfoWindowAdapter P;
    private View Q;
    private y R;
    private au S;
    private boolean T;
    private ad U;
    private ag V;
    private LocationSource W;
    private Rect X;
    private boolean Y;
    private boolean Z;
    ak a;
    private Handler aA;
    private Runnable aB;
    private Runnable aC;
    private o aD;
    private volatile boolean aE;
    private volatile boolean aF;
    private Runnable aH;
    private volatile boolean aI;
    private boolean aJ;
    private boolean aK;
    private boolean aL;
    private boolean aM;
    private Marker aN;
    private y aO;
    private boolean aP;
    private boolean aQ;
    private boolean aR;
    private int aS;
    private boolean aT;
    private Thread aU;
    private LatLngBounds aV;
    private boolean aW;
    private boolean aX;
    private boolean aY;
    private int aZ;
    private boolean aa;
    private h ab;
    private com.amap.api.mapcore.util.b ac;
    private ao ad;
    private j ae;
    private int af;
    private int ag;
    private CancelableCallback ah;
    private boolean ai;
    private int aj;
    private boolean ak;
    private boolean al;
    private Drawable am;
    private Location an;
    private Boolean ao;
    private final int[] ap;
    private boolean aq;
    private onMapPrintScreenListener ar;
    private OnMapScreenShotListener as;
    private Handler at;
    private k au;
    private Timer av;
    private TimeChangedReceiver aw;
    private volatile boolean ay;
    private Handler az;
    public al b;
    private int ba;
    bd c;
    az d;
    boolean e;
    CustomRenderer f;
    r g;
    Runnable h;
    final Handler i;
    private int j;
    private int k;
    private Bitmap l;
    private Bitmap m;
    private boolean n;
    private CopyOnWriteArrayList<Integer> o;
    private CopyOnWriteArrayList<Integer> p;
    private int q;
    private MapCore r;
    private Context s;
    private a t;
    private MapProjection u;
    private GestureDetector v;
    private ScaleGestureDetector w;
    private com.amap.api.mapcore.util.c x;
    private SurfaceHolder y;
    private am z;

    public class TimeChangedReceiver extends BroadcastReceiver {
        final /* synthetic */ AMapDelegateImpGLSurfaceView a;

        public TimeChangedReceiver(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.a = aMapDelegateImpGLSurfaceView;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.DATE_CHANGED".equals(action)) {
            }
            if ("android.intent.action.TIME_SET".equals(action)) {
                this.a.i.sendEmptyMessage(22);
            }
        }
    }

    class a implements com.amap.api.mapcore.util.b.a {
        Float a;
        Float b;
        IPoint c;
        float d;
        k e;
        final /* synthetic */ AMapDelegateImpGLSurfaceView f;
        private float g;
        private float h;
        private float i;
        private float j;
        private float k;

        private a(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.f = aMapDelegateImpGLSurfaceView;
            this.a = null;
            this.b = null;
            this.c = new IPoint();
            this.d = 0.0f;
            this.e = k.a();
        }

        public void a() {
            if (!this.f.aL) {
                try {
                    if (!this.f.V.f()) {
                        return;
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                try {
                    this.f.b(k.c());
                } catch (Throwable e2) {
                    az.a(e2, "AMapDelegateImpGLSurfaceView", "onMultiTouchSingleTap");
                    e2.printStackTrace();
                }
            }
        }

        public void a(float f, float f2, float f3, float f4, float f5) {
            this.g = f2;
            this.i = f3;
            this.h = f4;
            this.j = f5;
            this.k = (this.j - this.i) / (this.h - this.g);
            this.a = null;
            this.b = null;
            if (this.f.aY) {
                this.e.a = a.changeGeoCenterZoomTiltBearing;
                this.f.a(this.f.aZ, this.f.ba, this.c);
                this.e.o = this.c;
                this.e.n = this.f.aY;
            } else {
                this.e.a = a.changeTilt;
            }
            this.e.d = this.f.u.getMapZoomer();
            this.e.g = this.f.u.getMapAngle();
        }

        public boolean a(MotionEvent motionEvent, float f, float f2, float f3, float f4) {
            try {
                if (!this.f.V.g()) {
                    return true;
                }
                if (this.f.aL || this.f.aQ) {
                    return true;
                }
                if (this.b == null) {
                    this.b = Float.valueOf(f4);
                }
                if (this.a == null) {
                    this.a = Float.valueOf(f2);
                }
                float f5 = this.i - f2;
                float f6 = this.j - f4;
                float f7 = this.g - f;
                float f8 = this.h - f3;
                if (((double) Math.abs(this.k - ((f4 - f2) / (f3 - f)))) >= 0.2d || (((f5 <= 0.0f || f6 <= 0.0f) && (f5 >= 0.0f || f6 >= 0.0f)) || ((f7 < 0.0f || f8 < 0.0f) && (f7 > 0.0f || f8 > 0.0f)))) {
                    return false;
                }
                f5 = (this.a.floatValue() - f2) / 4.0f;
                this.f.aK = true;
                this.d = this.f.u.getCameraHeaderAngle() - f5;
                this.e.f = this.d;
                this.f.a.a(this.e);
                this.f.k();
                this.a = Float.valueOf(f2);
                this.b = Float.valueOf(f4);
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    class b implements OnDoubleTapListener {
        final /* synthetic */ AMapDelegateImpGLSurfaceView a;

        private b(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.a = aMapDelegateImpGLSurfaceView;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onDoubleTap(android.view.MotionEvent r6) {
            /*
            r5 = this;
            r4 = 1;
            r0 = r5.a;	 Catch:{ RemoteException -> 0x000e }
            r0 = r0.V;	 Catch:{ RemoteException -> 0x000e }
            r0 = r0.f();	 Catch:{ RemoteException -> 0x000e }
            if (r0 != 0) goto L_0x0012;
        L_0x000d:
            return r4;
        L_0x000e:
            r0 = move-exception;
            r0.printStackTrace();
        L_0x0012:
            r0 = r5.a;
            r0 = r0.aS;
            if (r0 > r4) goto L_0x000d;
        L_0x001a:
            r0 = r5.a;
            r0.aR = r4;
            r0 = r5.a;
            r0 = r0.u;
            r0 = r0.getMapZoomer();
            r1 = r5.a;
            r1 = r1.m();
            r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
            if (r0 == 0) goto L_0x000d;
        L_0x0033:
            r0 = r6.getX();
            r1 = r6.getY();
            r0 = (int) r0;
            r1 = (int) r1;
            r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r3 = new android.graphics.Point;
            r3.<init>(r0, r1);
            r0 = com.amap.api.mapcore.k.a(r2, r3);
            r1 = r5.a;	 Catch:{ RemoteException -> 0x004e }
            r1.b(r0);	 Catch:{ RemoteException -> 0x004e }
            goto L_0x000d;
        L_0x004e:
            r0 = move-exception;
            r1 = "AMapDelegateImpGLSurfaceView";
            r2 = "onDoubleTap";
            com.amap.api.mapcore.util.az.a(r0, r1, r2);
            r0.printStackTrace();
            goto L_0x000d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView.b.onDoubleTap(android.view.MotionEvent):boolean");
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            this.a.aP = false;
            if (this.a.aT) {
                this.a.aT = false;
            } else {
                if (this.a.Q != null) {
                    if (this.a.b.a(new Rect(this.a.Q.getLeft(), this.a.Q.getTop(), this.a.Q.getRight(), this.a.Q.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        if (this.a.N != null) {
                            y e = this.a.b.e();
                            if (e.o()) {
                                this.a.N.onInfoWindowClick(new Marker(e));
                            }
                        }
                    }
                }
                try {
                    if (this.a.b.b(motionEvent)) {
                        final y e2 = this.a.b.e();
                        if (e2 != null && e2.o()) {
                            Marker marker = new Marker(e2);
                            if (this.a.F != null) {
                                if (this.a.F.onMarkerClick(marker) || this.a.b.a() <= 0) {
                                    this.a.b.c(e2);
                                } else {
                                    this.a.at.postDelayed(new Runnable(this) {
                                        final /* synthetic */ b b;

                                        public void run() {
                                            try {
                                                this.b.a.a(e2);
                                            } catch (Throwable th) {
                                                az.a(th, "AMapDelegateImpGLSurfaceView", "onSingleTapUp showInfoWindow");
                                                th.printStackTrace();
                                            }
                                        }
                                    }, 20);
                                    if (!(this.a.b.e() == null || e2.F())) {
                                        LatLng g = e2.g();
                                        if (g != null) {
                                            IPoint iPoint = new IPoint();
                                            this.a.a(g.latitude, g.longitude, iPoint);
                                            this.a.a(k.a(iPoint));
                                        }
                                    }
                                }
                            }
                            this.a.b.c(e2);
                        }
                    } else {
                        if (this.a.J != null) {
                            DPoint dPoint = new DPoint();
                            this.a.a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint);
                            this.a.J.onMapClick(new LatLng(dPoint.y, dPoint.x));
                        }
                        if (this.a.L != null) {
                            List a = this.a.a((int) motionEvent.getX(), (int) motionEvent.getY(), 25);
                            if (a != null && a.size() > 0) {
                                this.a.L.onPOIClick((Poi) a.get(0));
                            }
                        }
                    }
                } catch (Throwable e3) {
                    az.a(e3, "AMapDelegateImpGLSurfaceView", "onSingleTapUp moveCamera");
                    e3.printStackTrace();
                } catch (Throwable e32) {
                    az.a(e32, "AMapDelegateImpGLSurfaceView", "onSingleTapUp");
                    e32.printStackTrace();
                }
            }
            return true;
        }
    }

    class c implements OnGestureListener {
        FPoint a;
        IPoint b;
        IPoint c;
        k d;
        final /* synthetic */ AMapDelegateImpGLSurfaceView e;

        private c(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.e = aMapDelegateImpGLSurfaceView;
            this.a = new FPoint();
            this.b = new IPoint();
            this.c = new IPoint();
            this.d = k.a(this.c);
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.e.aP = false;
            if (!this.e.aR) {
                try {
                    this.e.o();
                } catch (Throwable e) {
                    az.a(e, "AMapDelegateImpGLSurfaceView", "onDown");
                    e.printStackTrace();
                }
            }
            this.e.aR = false;
            this.e.aS = 0;
            this.a.x = motionEvent.getX();
            this.a.y = motionEvent.getY();
            this.e.a((int) this.a.x, (int) this.a.y, this.b);
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onFling(android.view.MotionEvent r11, android.view.MotionEvent r12, float r13, float r14) {
            /*
            r10 = this;
            r4 = 0;
            r9 = 1;
            r0 = r10.e;
            r0.aP = r4;
            r0 = r10.e;	 Catch:{ RemoteException -> 0x0014 }
            r0 = r0.V;	 Catch:{ RemoteException -> 0x0014 }
            r0 = r0.e();	 Catch:{ RemoteException -> 0x0014 }
            if (r0 != 0) goto L_0x001f;
        L_0x0013:
            return r9;
        L_0x0014:
            r0 = move-exception;
            r1 = "AMapDelegateImpGLSurfaceView";
            r2 = "onFling";
            com.amap.api.mapcore.util.az.a(r0, r1, r2);
            r0.printStackTrace();
        L_0x001f:
            r0 = r10.e;
            r0 = r0.ac;
            r0 = r0.a();
            if (r0 != 0) goto L_0x0013;
        L_0x002b:
            r0 = r11.getEventTime();
            r2 = r10.e;
            r2 = r2.ac;
            r2 = r2.b();
            r0 = r0 - r2;
            r2 = 30;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 < 0) goto L_0x0013;
        L_0x0040:
            r0 = r10.e;
            r0 = r0.h();
            r1 = r10.e;
            r1 = r1.i();
            r6 = r0 * 2;
            r8 = r1 * 2;
            r2 = r10.e;
            r0 = r0 / 2;
            r2.af = r0;
            r0 = r10.e;
            r1 = r1 / 2;
            r0.ag = r1;
            r0 = r10.e;
            r1 = 0;
            r0.ah = r1;
            r0 = r10.e;
            r0 = r0.Q;
            if (r0 == 0) goto L_0x0096;
        L_0x006c:
            r0 = r10.e;
            r0 = r0.R;
            if (r0 == 0) goto L_0x0096;
        L_0x0074:
            r0 = r10.e;
            r0 = r0.R;
            r0 = r0.F();
            if (r0 != 0) goto L_0x0096;
        L_0x0080:
            r0 = r10.e;
            r0.T = r4;
            r0 = r10.e;
            r0 = r0.S;
            if (r0 == 0) goto L_0x0096;
        L_0x008d:
            r0 = r10.e;
            r0 = r0.S;
            r0.b(r9);
        L_0x0096:
            r0 = r10.e;
            r0 = r0.ae;
            r1 = r10.e;
            r1 = r1.af;
            r2 = r10.e;
            r2 = r2.ag;
            r3 = -r13;
            r3 = (int) r3;
            r3 = r3 * 3;
            r3 = r3 / 5;
            r4 = -r14;
            r4 = (int) r4;
            r4 = r4 * 3;
            r4 = r4 / 5;
            r5 = -r6;
            r7 = -r8;
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
            r0 = r10.e;
            r0 = r0.d;
            if (r0 == 0) goto L_0x0013;
        L_0x00bf:
            r0 = r10.e;
            r0 = r0.d;
            r0.b(r9);
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView.c.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
        }

        public void onLongPress(MotionEvent motionEvent) {
            this.e.aP = false;
            this.e.aO = this.e.b.a(motionEvent);
            if (this.e.G != null && this.e.aO != null && this.e.aO.k()) {
                this.e.aN = new Marker(this.e.aO);
                LatLng position = this.e.aN.getPosition();
                LatLng g = this.e.aO.g();
                IPoint iPoint = new IPoint();
                this.e.b(g.latitude, g.longitude, iPoint);
                iPoint.y -= 60;
                DPoint dPoint = new DPoint();
                this.e.a(iPoint.x, iPoint.y, dPoint);
                this.e.aN.setPosition(new LatLng((position.latitude + dPoint.y) - g.latitude, (dPoint.x + position.longitude) - g.longitude));
                this.e.b.c(this.e.aO);
                this.e.G.onMarkerDragStart(this.e.aN);
                this.e.aM = true;
            } else if (this.e.M != null) {
                DPoint dPoint2 = new DPoint();
                this.e.a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint2);
                this.e.M.onMapLongClick(new LatLng(dPoint2.y, dPoint2.x));
                this.e.aT = true;
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.e.aP = true;
            if ((!this.e.ae.a() && this.e.ae.j() == 1) || this.e.ac.a() || motionEvent2.getEventTime() - this.e.ac.b() < 30) {
                this.e.aP = false;
            } else if (motionEvent2.getPointerCount() >= 2) {
                this.e.aP = false;
            } else {
                try {
                    if (!this.e.V.e()) {
                        this.e.aP = false;
                    }
                } catch (Throwable e) {
                    az.a(e, "AMapDelegateImpGLSurfaceView", "onScroll");
                    e.printStackTrace();
                }
                if (this.e.aS > 1) {
                    this.e.aP = false;
                } else {
                    if (!(this.e.Q == null || this.e.R == null || this.e.R.F() || this.e.S == null)) {
                        this.e.S.b(true);
                    }
                    IPoint iPoint = new IPoint();
                    this.e.a((int) motionEvent2.getX(), (int) motionEvent2.getY(), iPoint);
                    int i = this.b.x - iPoint.x;
                    int i2 = this.b.y - iPoint.y;
                    IPoint iPoint2 = new IPoint();
                    this.e.u.getGeoCenter(iPoint2);
                    this.c.x = i + iPoint2.x;
                    this.c.y = i2 + iPoint2.y;
                    this.d.o = this.c;
                    this.e.a.a(this.d);
                }
            }
            return true;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    class d implements com.amap.api.mapcore.util.c.a {
        float a;
        float b;
        IPoint c;
        k d;
        final /* synthetic */ AMapDelegateImpGLSurfaceView e;

        private d(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.e = aMapDelegateImpGLSurfaceView;
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = new IPoint();
            this.d = k.a();
        }

        public boolean a(com.amap.api.mapcore.util.c cVar) {
            if (this.e.aK) {
                return false;
            }
            float b = cVar.b();
            this.a += b;
            if (!this.e.aQ && Math.abs(this.a) <= BitmapDescriptorFactory.HUE_ORANGE && Math.abs(this.a) <= 350.0f) {
                return true;
            }
            this.e.aQ = true;
            this.b = b + this.e.u.getMapAngle();
            this.d.g = this.b;
            this.e.a.a(this.d);
            this.a = 0.0f;
            return true;
        }

        public boolean b(com.amap.api.mapcore.util.c cVar) {
            try {
                if (!this.e.V.h()) {
                    return false;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if (this.e.aY) {
                this.d.n = this.e.aY;
                this.d.a = a.changeBearingGeoCenter;
                this.e.a(this.e.aZ, this.e.ba, this.c);
                this.d.o = this.c;
            } else {
                this.d.a = a.changeBearing;
            }
            this.e.aQ = false;
            this.a = 0.0f;
            this.e.aS = 2;
            return !this.e.aK && ((float) this.e.getWidth()) / 4.0f < cVar.c();
        }

        public void c(com.amap.api.mapcore.util.c cVar) {
            this.a = 0.0f;
            if (this.e.aQ) {
                this.e.aQ = false;
                k a = k.a();
                a.p = true;
                this.e.a.a(a);
            }
            this.e.W();
        }
    }

    class e implements OnScaleGestureListener {
        k a;
        final /* synthetic */ AMapDelegateImpGLSurfaceView b;
        private float c;
        private IPoint d;

        private e(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.b = aMapDelegateImpGLSurfaceView;
            this.c = 0.0f;
            this.d = new IPoint();
            this.a = k.a();
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (!this.b.aK) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (this.b.aL || ((double) scaleFactor) > 1.08d || ((double) scaleFactor) < 0.92d) {
                    this.b.aL = true;
                    scaleFactor = (float) (Math.log((double) scaleFactor) / AMapDelegateImpGLSurfaceView.ax);
                    this.a.d = u.b(scaleFactor + this.c);
                    this.b.a.a(this.a);
                }
            }
            return false;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            try {
                if (!this.b.V.f() || this.b.aS < 2) {
                    return false;
                }
            } catch (Throwable e) {
                az.a(e, "AMapDelegateImpGLSurfaceView", "onScaleBegin");
                e.printStackTrace();
            }
            this.b.aS = 2;
            if (this.b.aK) {
                return false;
            }
            if (this.b.aY) {
                this.a.n = this.b.aY;
                this.a.a = a.changeGeoCenterZoom;
                this.b.a(this.b.aZ, this.b.ba, this.d);
                this.a.o = this.d;
            } else {
                this.a.a = a.zoomTo;
            }
            this.b.aL = false;
            this.c = this.b.u.getMapZoomer();
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.c = 0.0f;
            if (this.b.aL) {
                this.b.aL = false;
                k a = k.a();
                a.p = true;
                this.b.a.a(a);
            }
            this.b.W();
        }
    }

    class f extends TimerTask {
        AMapDelegateImpGLSurfaceView a;
        final /* synthetic */ AMapDelegateImpGLSurfaceView b;

        public f(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView, AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView2) {
            this.b = aMapDelegateImpGLSurfaceView;
            this.a = aMapDelegateImpGLSurfaceView2;
        }

        public void run() {
            if (!this.b.aE || this.b.aF || !this.b.g.e()) {
                this.a.requestRender();
            } else if (!this.b.b.d()) {
                this.a.requestRender();
            }
        }
    }

    class g implements Runnable {
        final /* synthetic */ AMapDelegateImpGLSurfaceView a;
        private Context b;
        private OnCacheRemoveListener c;

        public g(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView, Context context, OnCacheRemoveListener onCacheRemoveListener) {
            this.a = aMapDelegateImpGLSurfaceView;
            this.b = context;
            this.c = onCacheRemoveListener;
        }

        public boolean equals(Object obj) {
            return obj instanceof g;
        }

        public void run() {
            Throwable th;
            boolean z;
            Throwable th2;
            boolean z2;
            try {
                boolean z3;
                Context applicationContext = this.b.getApplicationContext();
                String b = u.b(applicationContext);
                String a = u.a(applicationContext);
                boolean z4 = this.a.a(new File(b));
                if (z4) {
                    try {
                        if (this.a.a(new File(a))) {
                            z3 = true;
                            this.a.r.setParameter(2601, 1, 0, 0, 0);
                            if (this.c != null) {
                                this.c.onRemoveCacheFinish(z3);
                            }
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        z2 = z4;
                        this.a.r.setParameter(2601, 1, 0, 0, 0);
                        if (this.c != null) {
                            this.c.onRemoveCacheFinish(z2);
                        }
                        throw th2;
                    }
                }
                z3 = false;
                try {
                    this.a.r.setParameter(2601, 1, 0, 0, 0);
                    if (this.c != null) {
                        this.c.onRemoveCacheFinish(z3);
                    }
                } catch (Throwable th32) {
                    th32.printStackTrace();
                }
            } catch (Throwable th4) {
                th2 = th4;
                z2 = true;
                this.a.r.setParameter(2601, 1, 0, 0, 0);
                if (this.c != null) {
                    this.c.onRemoveCacheFinish(z2);
                }
                throw th2;
            }
        }
    }

    public AMapDelegateImpGLSurfaceView(Context context) {
        this(context, null);
        this.s = context;
        this.y = getHolder();
        this.y.addCallback(this);
    }

    public AMapDelegateImpGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = -1;
        this.k = -1;
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = new CopyOnWriteArrayList();
        this.p = new CopyOnWriteArrayList();
        this.q = 1;
        this.t = null;
        this.a = new ak(this);
        this.y = null;
        this.T = true;
        this.X = new Rect();
        this.Y = true;
        this.Z = false;
        this.aa = true;
        this.e = false;
        this.af = 0;
        this.ag = 0;
        this.ah = null;
        this.ai = false;
        this.aj = 0;
        this.ak = false;
        this.al = false;
        this.am = null;
        this.ao = Boolean.valueOf(false);
        this.ap = new int[]{10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, kankan.wheel.widget.a.as, com.f.a.b.d.a.b, C1012a.b, com.f.a.b.d.a.a, kankan.wheel.widget.a.bZ, h.E, kankan.wheel.widget.a.aB, v.C, 100, 50, 25, 10, 5};
        this.aq = false;
        this.ar = null;
        this.as = null;
        this.at = new Handler();
        this.au = null;
        this.aw = null;
        this.ay = false;
        this.az = new Handler();
        this.aA = new b(this);
        this.aB = new e(this);
        this.aC = new f(this);
        this.g = new r();
        this.aD = new o();
        this.aE = false;
        this.aF = false;
        this.aH = new g(this);
        this.aI = false;
        this.aJ = false;
        this.aK = false;
        this.aL = false;
        this.aM = false;
        this.aN = null;
        this.aO = null;
        this.aP = false;
        this.aQ = false;
        this.aR = false;
        this.aS = 0;
        this.aT = false;
        this.aU = new c(this);
        this.aV = null;
        this.i = new d(this);
        this.aW = false;
        this.aX = false;
        this.aY = false;
        setBackgroundColor(Color.argb(HeartRateInfo.HR_EMPTY_VALUE, 235, 235, 235));
        this.s = context;
        this.r = new MapCore(context);
        this.t = new a(this);
        this.r.setMapCallback(this.t);
        this.u = this.r.getMapstate();
        this.a.a(k.a(new LatLng(39.924216d, 116.3978653d), 10.0f, 0.0f, 0.0f));
        this.U = new av(this);
        this.ab = new h(this);
        this.V = new ba(this);
        this.v = new GestureDetector(context, new c());
        this.v.setOnDoubleTapListener(new b());
        this.v.setIsLongpressEnabled(true);
        this.w = new ScaleGestureDetector(context, new e());
        this.x = new com.amap.api.mapcore.util.c(context, new d());
        this.ac = new com.amap.api.mapcore.util.b(context, new a());
        this.z = new am(this, context, this) {
            final /* synthetic */ AMapDelegateImpGLSurfaceView a;

            protected void a() {
                super.a();
                this.a.at.removeCallbacks(this.a.aC);
                this.a.at.post(this.a.aB);
            }
        };
        this.A = new bc(this.s, this);
        this.D = new aw(this.s, this);
        this.d = new az(this.s, this);
        this.c = new bd(this.s, this);
        this.B = new ah(this.s, this.a, this);
        this.C = new m(this.s, this.a, this);
        this.b = new al(this.s, attributeSet, this);
        this.A.setBackgroundColor(Color.argb(HeartRateInfo.HR_EMPTY_VALUE, 235, 235, 235));
        this.D.setBackgroundColor(Color.argb(HeartRateInfo.HR_EMPTY_VALUE, 235, 235, 235));
        this.z.setBackgroundColor(Color.argb(HeartRateInfo.HR_EMPTY_VALUE, 235, 235, 235));
        this.d.setBackgroundColor(Color.argb(HeartRateInfo.HR_EMPTY_VALUE, 235, 235, 235));
        this.c.setBackgroundColor(Color.argb(HeartRateInfo.HR_EMPTY_VALUE, 235, 235, 235));
        this.b.setBackgroundColor(Color.argb(HeartRateInfo.HR_EMPTY_VALUE, 235, 235, 235));
        this.B.setBackgroundColor(Color.argb(HeartRateInfo.HR_EMPTY_VALUE, 235, 235, 235));
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.z.addView(this, 0, layoutParams);
        this.z.addView(this.b, new com.amap.api.mapcore.am.a(layoutParams));
        this.z.addView(this.A, layoutParams);
        this.z.addView(this.D, layoutParams);
        this.z.addView(this.d, layoutParams);
        this.z.addView(this.c, new com.amap.api.mapcore.am.a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        this.z.addView(this.B, new com.amap.api.mapcore.am.a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        try {
            if (!this.V.d()) {
                this.B.setVisibility(8);
            }
        } catch (Throwable e) {
            az.a(e, "AMapDelegateImpGLSurfaceView", "locationView gone");
            e.printStackTrace();
        }
        this.z.addView(this.C, new com.amap.api.mapcore.am.a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 51));
        this.C.setVisibility(8);
        this.ae = new j(context);
        this.ad = new ao(this, context);
        this.P = new InfoWindowAdapter(this) {
            final /* synthetic */ AMapDelegateImpGLSurfaceView a;

            {
                this.a = r1;
            }

            public View getInfoContents(Marker marker) {
                return null;
            }

            public View getInfoWindow(Marker marker) {
                return null;
            }
        };
        this.O = this.P;
        setRenderer(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        this.aw = new TimeChangedReceiver(this);
        this.s.registerReceiver(this.aw, intentFilter);
        this.c.setId(AutoTestConfig.ZoomControllerViewId);
        this.D.setId(AutoTestConfig.ScaleControlsViewId);
        this.B.setId(AutoTestConfig.MyLocationViewId);
        this.C.setId(AutoTestConfig.CompassViewId);
    }

    private void R() {
        if (this.r != null) {
            this.r.destroy();
        }
    }

    private synchronized void S() {
        if (this.av != null) {
            T();
        }
        if (this.av == null) {
            this.av = new Timer();
        }
        this.av.schedule(new f(this, this), 0, 20);
    }

    private synchronized void T() {
        if (this.av != null) {
            this.av.cancel();
            this.av = null;
        }
    }

    private synchronized void U() {
        int i = 1;
        synchronized (this) {
            try {
                if (!this.aI) {
                    this.aI = true;
                    this.r.setStyleData(u.b(this.s, this.ay ? "style_v3_night.data" : "style_v3.data"), 0);
                    this.r.setStyleData(u.b(this.s, "style_sv3.data"), 1);
                    o.a("amapv241", "mapInit - loadStyle", 115);
                    this.r.setInternaltexture(u.b(this.s, this.ay ? "bk_night.pvr" : "bk.pvr"), 1);
                    o.a("amapv241", "mapInit - loadBackground", 115);
                    if (this.s.getResources().getDisplayMetrics().densityDpi >= RunningReminderInfo.b) {
                        this.r.setInternaltexture(u.a(u.b(this.s, this.ay ? "icn_h_night.data" : "icn_h.data")), 0);
                    } else {
                        this.r.setInternaltexture(u.a(u.b(this.s, this.ay ? "icn_night.data" : "icn.data")), 0);
                    }
                    o.a("amapv241", "mapInit - loadIcon", 115);
                    this.r.setInternaltexture(u.b(this.s, "roadarrow.pvr"), 2);
                    this.r.setInternaltexture(u.b(this.s, "LineRound.pvr"), 3);
                    this.r.setInternaltexture(u.b(this.s, "dash.pvr"), 8);
                    this.r.setInternaltexture(u.b(this.s, "tgl.data"), 6);
                    this.r.setInternaltexture(u.b(this.s, "trl.data"), 4);
                    this.r.setInternaltexture(u.b(this.s, "tyl.data"), 5);
                    this.r.setInternaltexture(u.b(this.s, "tbl.data"), 7);
                    o.a("amapv241", "mapInit - loadResSuccessed", 115);
                    MapCore mapCore = this.r;
                    if (!this.ay) {
                        i = 0;
                    }
                    mapCore.setParameter(2401, i, 0, 0, 0);
                }
            } catch (Throwable th) {
                az.a(th, "AMapDelegateImpGLSurfaceView", "setInternaltexture");
                o.a("amapv241", "mapInitError", 112);
                th.printStackTrace();
            }
        }
    }

    private LatLng V() {
        DPoint dPoint = new DPoint();
        IPoint iPoint = new IPoint();
        this.u.getGeoCenter(iPoint);
        MapProjection.geo2LonLat(iPoint.x, iPoint.y, dPoint);
        return new LatLng(dPoint.y, dPoint.x, false);
    }

    private void W() {
        if (this.aT) {
            this.aT = false;
        }
        if (this.aP) {
            this.aP = false;
            k a = k.a();
            a.p = true;
            this.a.a(a);
        }
        if (this.aK) {
            this.aK = false;
            a = k.a();
            a.p = true;
            this.a.a(a);
        }
        this.aL = false;
        this.aM = false;
        if (this.G != null && this.aN != null) {
            this.G.onMarkerDragEnd(this.aN);
            this.aN = null;
        }
    }

    public static Bitmap a(int i, int i2, int i3, int i4, GL10 gl10) {
        try {
            int[] iArr = new int[(i3 * i4)];
            int[] iArr2 = new int[(i3 * i4)];
            Buffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            gl10.glReadPixels(i, i2, i3, i4, 6408, 5121, wrap);
            for (int i5 = 0; i5 < i4; i5++) {
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = iArr[(i5 * i3) + i6];
                    iArr2[(((i4 - i5) - 1) * i3) + i6] = ((i7 & -16711936) | ((i7 << 16) & 16711680)) | ((i7 >> 16) & HeartRateInfo.HR_EMPTY_VALUE);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i3, 0, 0, i3, i4);
            return createBitmap;
        } catch (Throwable th) {
            az.a(th, "AMapDelegateImpGLSurfaceView", "SavePixels");
            th.printStackTrace();
            return null;
        }
    }

    private ArrayList<Poi> a(int i, int i2, int i3) {
        if (!this.Z) {
            return null;
        }
        try {
            ArrayList<Poi> arrayList = new ArrayList();
            byte[] bArr = new byte[C0113o.l];
            int labelBuffer = this.r.getLabelBuffer(i, i2, i3, bArr);
            if (labelBuffer <= 0 || bArr == null) {
                return null;
            }
            int i4 = 0;
            DPoint dPoint = new DPoint();
            for (int i5 = 0; i5 < labelBuffer; i5++) {
                int i6 = i4 + 8;
                int i7 = Convert.getInt(bArr, i6);
                i6 += 4;
                MapProjection.geo2LonLat(i7, Convert.getInt(bArr, i6), dPoint);
                i6 += 20;
                i7 = i6 + 1;
                byte b = bArr[i6];
                StringBuffer stringBuffer = new StringBuffer();
                byte b2 = (byte) 0;
                i4 = i7;
                while (b2 < b) {
                    stringBuffer.append((char) Convert.getShort(bArr, i4));
                    b2++;
                    i4 += 2;
                }
                arrayList.add(new Poi(stringBuffer.toString(), new LatLng(dPoint.y, dPoint.x, false)));
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    private void a(MotionEvent motionEvent) {
        if (this.aM && this.aN != null) {
            int x = (int) motionEvent.getX();
            int y = (int) (motionEvent.getY() - BitmapDescriptorFactory.HUE_YELLOW);
            LatLng g = this.aO.g();
            LatLng e = this.aO.e();
            DPoint dPoint = new DPoint();
            a(x, y, dPoint);
            this.aN.setPosition(new LatLng((e.latitude + dPoint.y) - g.latitude, (dPoint.x + e.longitude) - g.longitude));
            this.G.onMarkerDrag(this.aN);
        }
    }

    private void a(MapProjection mapProjection, int i, int i2, DPoint dPoint) {
        FPoint fPoint = new FPoint();
        mapProjection.win2Map(i, i2, fPoint);
        IPoint iPoint = new IPoint();
        mapProjection.map2Geo(fPoint.x, fPoint.y, iPoint);
        MapProjection.geo2LonLat(iPoint.x, iPoint.y, dPoint);
    }

    private boolean a(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!a(listFiles[i])) {
                    return false;
                } else {
                    listFiles[i].delete();
                }
            }
        }
        return true;
    }

    void A() {
        this.i.obtainMessage(18).sendToTarget();
    }

    public LatLngBounds B() {
        return this.aV;
    }

    void C() {
        if (!this.aW) {
            setBackgroundColor(0);
            this.A.setBackgroundColor(0);
            this.D.setBackgroundColor(0);
            this.z.setBackgroundColor(0);
            this.d.setBackgroundColor(0);
            if (this.c != null) {
                this.c.setBackgroundColor(0);
            }
            this.b.setBackgroundColor(0);
            this.B.setBackgroundColor(0);
            this.aW = true;
            postInvalidate();
        }
    }

    Point D() {
        return this.A == null ? null : this.A.c();
    }

    public float E() {
        try {
            LatLng latLng = l().target;
            return (float) ((((Math.cos((latLng.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, (double) this.u.getMapZoomer()) * 256.0d));
        } catch (Throwable th) {
            az.a(th, "AMapDelegateImpGLSurfaceView", "getScalePerPixel");
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int F() {
        Integer valueOf = Integer.valueOf(0);
        if (this.o.size() > 0) {
            valueOf = (Integer) this.o.get(0);
            this.o.remove(0);
            this.p.add(valueOf);
        }
        return valueOf.intValue();
    }

    public List<Marker> G() {
        boolean z = getWidth() > 0 && getHeight() > 0;
        com.amap.api.mapcore.util.e.a(z, (Object) "\u5730\u56fe\u672a\u521d\u59cb\u5316\u5b8c\u6210\uff01");
        return this.b.g();
    }

    public void H() {
        this.g.c();
    }

    public void I() {
        this.aX = true;
    }

    public boolean J() {
        return this.aX;
    }

    public void K() {
        if (this.b != null) {
            this.b.h();
        }
        this.aX = false;
    }

    public int L() {
        return this.aj;
    }

    public boolean M() {
        return this.Z;
    }

    public j N() {
        return this.ae;
    }

    public void O() {
        a(null);
    }

    public void P() {
        if (this.g != null) {
            this.g.d();
        }
        if (this.b != null) {
            this.b.c();
        }
        if (this.f != null) {
            this.f.OnMapReferencechanged();
        }
    }

    public ab a(PolygonOptions polygonOptions) {
        if (polygonOptions == null) {
            return null;
        }
        aa asVar = new as(this);
        asVar.a(polygonOptions.getFillColor());
        asVar.a(polygonOptions.getPoints());
        asVar.a(polygonOptions.isVisible());
        asVar.b(polygonOptions.getStrokeWidth());
        asVar.a(polygonOptions.getZIndex());
        asVar.b(polygonOptions.getStrokeColor());
        this.g.a(asVar);
        e(false);
        return asVar;
    }

    public ac a(PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            return null;
        }
        aa atVar = new at(this);
        atVar.a(polylineOptions.getColor());
        atVar.b(polylineOptions.isGeodesic());
        atVar.c(polylineOptions.isDottedLine());
        atVar.a(polylineOptions.getPoints());
        atVar.a(polylineOptions.isVisible());
        atVar.b(polylineOptions.getWidth());
        atVar.a(polylineOptions.getZIndex());
        atVar.d(polylineOptions.isUseTexture());
        if (polylineOptions.getCustomTexture() != null) {
            Bitmap bitmap = polylineOptions.getCustomTexture().clone().getBitmap();
            if (bitmap != null) {
                atVar.a(bitmap);
            }
        }
        this.g.a(atVar);
        e(false);
        return atVar;
    }

    public u a(ArcOptions arcOptions) {
        if (arcOptions == null) {
            return null;
        }
        aa iVar = new i(this);
        iVar.a(arcOptions.getStrokeColor());
        iVar.a(arcOptions.getStart());
        iVar.b(arcOptions.getPassed());
        iVar.c(arcOptions.getEnd());
        iVar.a(arcOptions.isVisible());
        iVar.b(arcOptions.getStrokeWidth());
        iVar.a(arcOptions.getZIndex());
        this.g.a(iVar);
        e(false);
        return iVar;
    }

    public v a(CircleOptions circleOptions) {
        if (circleOptions == null) {
            return null;
        }
        aa lVar = new l(this);
        lVar.b(circleOptions.getFillColor());
        lVar.a(circleOptions.getCenter());
        lVar.a(circleOptions.isVisible());
        lVar.b(circleOptions.getStrokeWidth());
        lVar.a(circleOptions.getZIndex());
        lVar.a(circleOptions.getStrokeColor());
        lVar.a(circleOptions.getRadius());
        this.g.a(lVar);
        e(false);
        return lVar;
    }

    public w a(GroundOverlayOptions groundOverlayOptions) {
        if (groundOverlayOptions == null) {
            return null;
        }
        aa sVar = new s(this);
        sVar.b(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
        sVar.a(groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
        sVar.a(groundOverlayOptions.getImage());
        sVar.a(groundOverlayOptions.getLocation());
        sVar.a(groundOverlayOptions.getBounds());
        sVar.c(groundOverlayOptions.getBearing());
        sVar.d(groundOverlayOptions.getTransparency());
        sVar.a(groundOverlayOptions.isVisible());
        sVar.a(groundOverlayOptions.getZIndex());
        this.g.a(sVar);
        e(false);
        return sVar;
    }

    public z a(NavigateArrowOptions navigateArrowOptions) {
        if (navigateArrowOptions == null) {
            return null;
        }
        aa apVar = new ap(this);
        apVar.a(navigateArrowOptions.getTopColor());
        apVar.b(navigateArrowOptions.getSideColor());
        apVar.a(navigateArrowOptions.getPoints());
        apVar.a(navigateArrowOptions.isVisible());
        apVar.b(navigateArrowOptions.getWidth());
        apVar.a(navigateArrowOptions.getZIndex());
        this.g.a(apVar);
        e(false);
        return apVar;
    }

    public LatLngBounds a(LatLng latLng, float f) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        IPoint iPoint = new IPoint();
        MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
        MapProjection mapProjection = new MapProjection(this.r);
        mapProjection.setCameraHeaderAngle(0.0f);
        mapProjection.setMapAngle(0.0f);
        mapProjection.setGeoCenter(iPoint.x, iPoint.y);
        mapProjection.setMapZoomer(f);
        mapProjection.recalculate();
        DPoint dPoint = new DPoint();
        a(mapProjection, 0, 0, dPoint);
        LatLng latLng2 = new LatLng(dPoint.y, dPoint.x, false);
        a(mapProjection, width, height, dPoint);
        LatLng latLng3 = new LatLng(dPoint.y, dPoint.x, false);
        mapProjection.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    public Marker a(MarkerOptions markerOptions) {
        if (markerOptions == null) {
            return null;
        }
        y anVar = new an(markerOptions, this.b);
        this.b.a(anVar);
        e(false);
        return new Marker(anVar);
    }

    public TileOverlay a(TileOverlayOptions tileOverlayOptions) {
        if (tileOverlayOptions == null || tileOverlayOptions.getTileProvider() == null) {
            return null;
        }
        af ayVar = new ay(tileOverlayOptions, this.d);
        this.d.a(ayVar);
        e(false);
        return new TileOverlay(ayVar);
    }

    public MapCore a() {
        return this.r;
    }

    public ArrayList<Marker> a(ArrayList<MarkerOptions> arrayList, boolean z) {
        int i = 0;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Marker> arrayList2 = new ArrayList();
        try {
            MarkerOptions markerOptions;
            if (arrayList.size() == 1) {
                markerOptions = (MarkerOptions) arrayList.get(0);
                if (markerOptions != null) {
                    arrayList2.add(a(markerOptions));
                    if (z && markerOptions.getPosition() != null) {
                        a(k.a(markerOptions.getPosition(), 18.0f));
                    }
                    return arrayList2;
                }
            }
            Builder builder = LatLngBounds.builder();
            int i2 = 0;
            while (i2 < arrayList.size()) {
                int i3;
                markerOptions = (MarkerOptions) arrayList.get(i2);
                if (arrayList.get(i2) != null) {
                    arrayList2.add(a(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                        i3 = i + 1;
                        i2++;
                        i = i3;
                    }
                }
                i3 = i;
                i2++;
                i = i3;
            }
            if (z && i > 0) {
                if (this.Z) {
                    a(k.a(builder.build(), 50));
                } else {
                    this.au = k.a(builder.build(), 50);
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            az.a(th, "AMapDelegateImpGLSurfaceView", "addMarkers");
            th.printStackTrace();
            return arrayList2;
        }
    }

    public void a(double d, double d2, FPoint fPoint) {
        IPoint iPoint = new IPoint();
        MapProjection.lonlat2Geo(d2, d, iPoint);
        this.u.geo2Map(iPoint.x, iPoint.y, fPoint);
    }

    public void a(double d, double d2, IPoint iPoint) {
        MapProjection.lonlat2Geo(d2, d, iPoint);
    }

    public void a(float f) {
        if (this.ad != null) {
            this.ad.a(f);
        }
    }

    public void a(int i) {
        if (this.ad != null) {
            this.ad.a(i);
        }
    }

    public void a(int i, int i2) {
        if (this.t != null) {
            this.aY = true;
            this.t.a(i, i2);
            this.aZ = i;
            this.ba = i2;
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        this.r.setParameter(2201, 1, 1, 1, 1);
        this.r.setParameter(2202, i, i2, i3, i4);
    }

    public void a(int i, int i2, DPoint dPoint) {
        a(this.u, i, i2, dPoint);
    }

    public void a(int i, int i2, FPoint fPoint) {
        this.u.win2Map(i, i2, fPoint);
    }

    public void a(int i, int i2, IPoint iPoint) {
        FPoint fPoint = new FPoint();
        this.u.win2Map(i, i2, fPoint);
        this.u.map2Geo(fPoint.x, fPoint.y, iPoint);
    }

    public void a(Location location) {
        if (location != null) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            try {
                if (!this.Y || this.W == null) {
                    this.ad.c();
                    this.ad = null;
                    return;
                }
                if (this.ad == null || this.an == null) {
                    if (this.ad == null) {
                        this.ad = new ao(this, this.s);
                    }
                    a(k.a(latLng, this.u.getMapZoomer()));
                }
                this.ad.a(location);
                if (!(this.E == null || (this.an != null && this.an.getBearing() == location.getBearing() && this.an.getAccuracy() == location.getAccuracy() && this.an.getLatitude() == location.getLatitude() && this.an.getLongitude() == location.getLongitude()))) {
                    this.E.onMyLocationChange(location);
                }
                this.an = new Location(location);
                e(false);
            } catch (Throwable e) {
                az.a(e, "AMapDelegateImpGLSurfaceView", "showMyLocationOverlay");
                e.printStackTrace();
            }
        }
    }

    public void a(k kVar) {
        if (kVar.a == a.newLatLngBounds) {
            boolean z = getWidth() > 0 && getHeight() > 0;
            com.amap.api.mapcore.util.e.a(z, (Object) "the map must have a size");
        }
        o();
        kVar.p = true;
        kVar.n = this.aY;
        this.a.a(kVar);
    }

    public void a(k kVar, long j, CancelableCallback cancelableCallback) {
        if (kVar.a == a.newLatLngBounds) {
            boolean z = getWidth() > 0 && getHeight() > 0;
            com.amap.api.mapcore.util.e.a(z, (Object) "the map must have a size");
        }
        if (!this.ae.a()) {
            this.ae.a(true);
            if (this.ah != null) {
                this.ah.onCancel();
            }
        }
        this.ae.b(this.aY);
        this.ah = cancelableCallback;
        if (this.ak) {
            this.al = true;
        }
        this.ai = false;
        IPoint iPoint;
        if (kVar.a == a.scrollBy) {
            if (kVar.b == 0.0f && kVar.c == 0.0f) {
                this.i.obtainMessage(17).sendToTarget();
                return;
            }
            this.ae.b(false);
            iPoint = new IPoint();
            this.u.getGeoCenter(iPoint);
            IPoint iPoint2 = new IPoint();
            a((getWidth() / 2) + ((int) kVar.b), (getHeight() / 2) + ((int) kVar.c), iPoint2);
            this.ae.a(new AccelerateDecelerateInterpolator());
            this.ae.a(iPoint.x, iPoint.y, this.u.getMapZoomer(), this.u.getMapAngle(), this.u.getCameraHeaderAngle(), iPoint2.x - iPoint.x, iPoint2.y - iPoint.y, 0.0f, 0.0f, 0.0f, j);
        } else if (kVar.a == a.zoomIn) {
            r6 = this.u.getMapZoomer();
            r11 = u.b(1.0f + r6) - r6;
            if (r11 == 0.0f) {
                this.i.obtainMessage(17).sendToTarget();
                return;
            }
            iPoint = new IPoint();
            if (this.aY) {
                a(this.aZ, this.ba, iPoint);
            } else {
                this.u.getGeoCenter(iPoint);
            }
            this.ae.a(new AccelerateInterpolator());
            this.ae.a(iPoint.x, iPoint.y, r6, this.u.getMapAngle(), this.u.getCameraHeaderAngle(), 0, 0, r11, 0.0f, 0.0f, j);
        } else if (kVar.a == a.zoomOut) {
            r6 = this.u.getMapZoomer();
            r11 = u.b(r6 - 1.0f) - r6;
            if (r11 == 0.0f) {
                this.i.obtainMessage(17).sendToTarget();
                return;
            }
            iPoint = new IPoint();
            if (this.aY) {
                a(this.aZ, this.ba, iPoint);
            } else {
                this.u.getGeoCenter(iPoint);
            }
            this.ae.a(new AccelerateInterpolator());
            this.ae.a(iPoint.x, iPoint.y, r6, this.u.getMapAngle(), this.u.getCameraHeaderAngle(), 0, 0, r11, 0.0f, 0.0f, j);
        } else if (kVar.a == a.zoomTo) {
            r6 = this.u.getMapZoomer();
            r11 = u.b(kVar.d) - r6;
            if (r11 == 0.0f) {
                this.i.obtainMessage(17).sendToTarget();
                return;
            }
            iPoint = new IPoint();
            if (this.aY) {
                a(this.aZ, this.ba, iPoint);
            } else {
                this.u.getGeoCenter(iPoint);
            }
            this.ae.a(new AccelerateInterpolator());
            this.ae.a(iPoint.x, iPoint.y, r6, this.u.getMapAngle(), this.u.getCameraHeaderAngle(), 0, 0, r11, 0.0f, 0.0f, j);
        } else if (kVar.a == a.zoomBy) {
            this.ae.b(false);
            float f = kVar.e;
            r6 = this.u.getMapZoomer();
            r11 = u.b(r6 + f) - r6;
            if (r11 == 0.0f) {
                this.i.obtainMessage(17).sendToTarget();
                return;
            }
            Point point = kVar.m;
            IPoint iPoint3 = new IPoint();
            this.u.getGeoCenter(iPoint3);
            r9 = 0;
            r10 = 0;
            IPoint iPoint4 = new IPoint();
            int i;
            if (point != null) {
                a(point.x, point.y, iPoint4);
                r3 = iPoint3.x - iPoint4.x;
                i = iPoint3.y - iPoint4.y;
                r9 = (int) ((((double) r3) / Math.pow(2.0d, (double) f)) - ((double) r3));
                r10 = (int) ((((double) i) / Math.pow(2.0d, (double) f)) - ((double) i));
            } else if (this.aY) {
                a(this.aZ, this.ba, iPoint4);
                r3 = iPoint3.x - iPoint4.x;
                i = iPoint3.y - iPoint4.y;
                r9 = (int) ((((double) r3) / Math.pow(2.0d, (double) f)) - ((double) r3));
                r10 = (int) ((((double) i) / Math.pow(2.0d, (double) f)) - ((double) i));
            }
            this.ae.a(new AccelerateInterpolator());
            this.ae.a(iPoint3.x, iPoint3.y, r6, this.u.getMapAngle(), this.u.getCameraHeaderAngle(), r9, r10, r11, 0.0f, 0.0f, j);
        } else if (kVar.a == a.newCameraPosition) {
            iPoint = new IPoint();
            if (this.aY) {
                a(this.aZ, this.ba, iPoint);
            } else {
                this.u.getGeoCenter(iPoint);
            }
            r3 = new IPoint();
            CameraPosition cameraPosition = kVar.h;
            MapProjection.lonlat2Geo(cameraPosition.target.longitude, cameraPosition.target.latitude, r3);
            r6 = this.u.getMapZoomer();
            r9 = r3.x - iPoint.x;
            r10 = r3.y - iPoint.y;
            r11 = u.b(cameraPosition.zoom) - r6;
            r7 = this.u.getMapAngle();
            r12 = (cameraPosition.bearing % 360.0f) - (r7 % 360.0f);
            if (Math.abs(r12) >= BitmapDescriptorFactory.HUE_CYAN) {
                r12 -= Math.signum(r12) * 360.0f;
            }
            r8 = this.u.getCameraHeaderAngle();
            r13 = u.a(cameraPosition.tilt) - r8;
            if (r9 == 0 && r10 == 0 && r11 == 0.0f && r12 == 0.0f && r13 == 0.0f) {
                this.i.obtainMessage(17).sendToTarget();
                return;
            } else {
                this.ae.a(new AccelerateInterpolator());
                this.ae.a(iPoint.x, iPoint.y, r6, r7, r8, r9, r10, r11, r12, r13, j);
            }
        } else if (kVar.a == a.changeBearing) {
            r7 = this.u.getMapAngle();
            r12 = (kVar.g % 360.0f) - (r7 % 360.0f);
            if (Math.abs(r12) >= BitmapDescriptorFactory.HUE_CYAN) {
                r12 -= Math.signum(r12) * 360.0f;
            }
            if (r12 == 0.0f) {
                this.i.obtainMessage(17).sendToTarget();
                return;
            }
            iPoint = new IPoint();
            if (this.aY) {
                a(this.aZ, this.ba, iPoint);
            } else {
                this.u.getGeoCenter(iPoint);
            }
            this.ae.a(new AccelerateInterpolator());
            this.ae.a(iPoint.x, iPoint.y, this.u.getMapZoomer(), r7, this.u.getCameraHeaderAngle(), 0, 0, 0.0f, r12, 0.0f, j);
        } else if (kVar.a == a.changeTilt) {
            r8 = this.u.getCameraHeaderAngle();
            r13 = kVar.f - r8;
            if (r13 == 0.0f) {
                this.i.obtainMessage(17).sendToTarget();
                return;
            }
            iPoint = new IPoint();
            if (this.aY) {
                a(this.aZ, this.ba, iPoint);
            } else {
                this.u.getGeoCenter(iPoint);
            }
            this.ae.a(new AccelerateInterpolator());
            this.ae.a(iPoint.x, iPoint.y, this.u.getMapZoomer(), this.u.getMapAngle(), r8, 0, 0, 0.0f, 0.0f, r13, j);
        } else if (kVar.a == a.changeCenter) {
            iPoint = new IPoint();
            if (this.aY) {
                a(this.aZ, this.ba, iPoint);
            } else {
                this.u.getGeoCenter(iPoint);
            }
            r9 = kVar.o.x - iPoint.x;
            r10 = kVar.o.y - iPoint.y;
            if (r9 == 0 && r10 == 0) {
                this.i.obtainMessage(17).sendToTarget();
                return;
            } else {
                this.ae.a(new AccelerateDecelerateInterpolator());
                this.ae.a(iPoint.x, iPoint.y, this.u.getMapZoomer(), this.u.getMapAngle(), this.u.getCameraHeaderAngle(), r9, r10, 0.0f, 0.0f, 0.0f, j);
            }
        } else if (kVar.a == a.newLatLngBounds || kVar.a == a.newLatLngBoundsWithSize) {
            int i2;
            this.ae.b(false);
            if (kVar.a == a.newLatLngBounds) {
                r3 = getWidth();
                r9 = getHeight();
                i2 = r3;
            } else {
                r3 = kVar.k;
                r9 = kVar.l;
                i2 = r3;
            }
            float mapAngle = this.u.getMapAngle() % 360.0f;
            float cameraHeaderAngle = this.u.getCameraHeaderAngle();
            r12 = -mapAngle;
            if (Math.abs(r12) >= BitmapDescriptorFactory.HUE_CYAN) {
                r12 -= Math.signum(r12) * 360.0f;
            }
            r13 = -cameraHeaderAngle;
            LatLngBounds latLngBounds = kVar.i;
            int i3 = kVar.j;
            IPoint iPoint5 = new IPoint();
            this.u.getGeoCenter(iPoint5);
            float mapZoomer = this.u.getMapZoomer();
            this.ae.a(new AccelerateInterpolator());
            iPoint = new IPoint();
            r3 = new IPoint();
            MapProjection.lonlat2Geo(latLngBounds.northeast.longitude, latLngBounds.northeast.latitude, iPoint);
            MapProjection.lonlat2Geo(latLngBounds.southwest.longitude, latLngBounds.southwest.latitude, r3);
            r10 = iPoint.x - r3.x;
            int i4 = r3.y - iPoint.y;
            if (r10 > 0 || i4 > 0) {
                int i5 = (iPoint.x + r3.x) / 2;
                int i6 = (iPoint.y + r3.y) / 2;
                IPoint iPoint6 = new IPoint();
                b((latLngBounds.northeast.latitude + latLngBounds.southwest.latitude) / 2.0d, (latLngBounds.northeast.longitude + latLngBounds.southwest.longitude) / 2.0d, iPoint6);
                int i7;
                if ((!this.X.contains(iPoint6.x, iPoint6.y) ? 1 : null) == null) {
                    r3 = i2 - (i3 * 2);
                    i7 = r9 - (i3 * 2);
                    if (r3 <= 0) {
                        r3 = 1;
                    }
                    if (i7 <= 0) {
                        i7 = 1;
                    }
                    r11 = u.b((float) ((int) (Math.min(Math.log(((double) this.u.getMapLenWithWin(r3)) / ((double) this.u.getMapLenWithGeo(r10))) / Math.log(2.0d), Math.log(((double) this.u.getMapLenWithWin(i7)) / ((double) this.u.getMapLenWithGeo(i4))) / Math.log(2.0d)) + ((double) mapZoomer)))) - mapZoomer;
                    r9 = i5 - iPoint5.x;
                    r10 = i6 - iPoint5.y;
                    if (r9 == 0 && r10 == 0 && r11 == 0.0f) {
                        this.i.obtainMessage(17).sendToTarget();
                        return;
                    } else {
                        this.ae.a(new DecelerateInterpolator());
                        this.ae.a(iPoint5.x, iPoint5.y, mapZoomer, mapAngle, cameraHeaderAngle, r9, r10, r11, r12, r13, j);
                    }
                } else {
                    final CancelableCallback cancelableCallback2 = this.ah;
                    final LatLngBounds latLngBounds2 = latLngBounds;
                    final int i8 = i2;
                    final int i9 = r9;
                    final int i10 = i3;
                    final long j2 = j;
                    this.ah = new CancelableCallback(this) {
                        final /* synthetic */ AMapDelegateImpGLSurfaceView g;

                        public void onCancel() {
                            if (cancelableCallback2 != null) {
                                cancelableCallback2.onCancel();
                            }
                        }

                        public void onFinish() {
                            try {
                                this.g.a(k.a(latLngBounds2, i8, i9, i10), j2, cancelableCallback2);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    };
                    i4 = ((iPoint5.x + i5) / 2) - iPoint5.x;
                    r10 = ((iPoint5.y + i6) / 2) - iPoint5.y;
                    i7 = (int) u.a((double) (((float) h()) / 2.0f), (double) (((float) i()) / 2.0f), (double) Math.abs(i5 - iPoint5.x), (double) Math.abs(i6 - iPoint5.y));
                    r11 = i7 == 0 ? 0.0f : ((float) i7) - mapZoomer;
                    if (r11 >= 0.0f) {
                        r11 = 0.0f;
                    }
                    this.ai = true;
                    this.ae.a(iPoint5.x, iPoint5.y, mapZoomer, mapAngle, cameraHeaderAngle, i4, r10, r11, r12 / 2.0f, r13 / 2.0f, j / 2);
                }
            } else {
                this.i.obtainMessage(17).sendToTarget();
                return;
            }
        } else {
            kVar.p = true;
            this.a.a(kVar);
        }
        e(false);
    }

    public void a(k kVar, CancelableCallback cancelableCallback) {
        a(kVar, 250, cancelableCallback);
    }

    public void a(q qVar) {
        this.aD.a(qVar);
    }

    public void a(y yVar) {
        int i = -2;
        if (yVar != null) {
            if ((yVar.i() != null || yVar.j() != null) && this.O != null) {
                y();
                this.R = yVar;
                if (this.Z) {
                    int i2;
                    Marker marker = new Marker(yVar);
                    this.Q = this.O.getInfoWindow(marker);
                    try {
                        if (this.am == null) {
                            this.am = aq.a(this.s, "infowindow_bg.9.png");
                        }
                    } catch (Throwable th) {
                        az.a(th, "AMapDelegateImpGLSurfaceView", "showInfoWindow decodeDrawableFromAsset");
                        th.printStackTrace();
                    }
                    if (this.Q == null) {
                        this.Q = this.O.getInfoContents(marker);
                    }
                    View linearLayout = new LinearLayout(this.s);
                    if (this.Q != null) {
                        if (this.Q.getBackground() == null) {
                            this.Q.setBackgroundDrawable(this.am);
                        }
                        linearLayout.addView(this.Q);
                    } else {
                        linearLayout.setBackgroundDrawable(this.am);
                        View textView = new TextView(this.s);
                        textView.setText(yVar.i());
                        textView.setTextColor(C0151az.s);
                        View textView2 = new TextView(this.s);
                        textView2.setTextColor(C0151az.s);
                        textView2.setText(yVar.j());
                        linearLayout.setOrientation(1);
                        linearLayout.addView(textView);
                        linearLayout.addView(textView2);
                    }
                    this.Q = linearLayout;
                    LayoutParams layoutParams = this.Q.getLayoutParams();
                    this.Q.setDrawingCacheEnabled(true);
                    this.Q.setDrawingCacheQuality(0);
                    yVar.d();
                    int D = yVar.D() + yVar.B();
                    int E = (yVar.E() + yVar.C()) + 2;
                    if (layoutParams != null) {
                        i2 = layoutParams.width;
                        i = layoutParams.height;
                    } else {
                        i2 = -2;
                    }
                    layoutParams = new com.amap.api.mapcore.am.a(i2, i, yVar.f(), D, E, 81);
                    if (this.S == null) {
                        this.S = new au(this, new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(u.a(this.Q))), this) {
                            final /* synthetic */ AMapDelegateImpGLSurfaceView a;

                            public void a() {
                                this.a.at.removeCallbacks(this.a.aB);
                                this.a.at.post(this.a.aC);
                            }
                        };
                        this.S.a(yVar.f());
                        this.S.b(D, E);
                    } else {
                        this.S.a(yVar.f());
                        this.S.b(D, E);
                        this.S.a(BitmapDescriptorFactory.fromBitmap(u.a(this.Q)));
                    }
                    this.z.addView(this.Q, layoutParams);
                    return;
                }
                this.at.postDelayed(new Runnable(this) {
                    final /* synthetic */ AMapDelegateImpGLSurfaceView a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        try {
                            this.a.a(this.a.R);
                        } catch (Throwable e) {
                            az.a(e, "AMapDelegateImpGLSurfaceView", "showInfoWindow postDelayed");
                            e.printStackTrace();
                        }
                    }
                }, 100);
            }
        }
    }

    public void a(InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            this.O = this.P;
        } else {
            this.O = infoWindowAdapter;
        }
    }

    public void a(OnCacheRemoveListener onCacheRemoveListener) {
        if (this.az != null) {
            try {
                this.r.setParameter(2601, 0, 0, 0, 0);
                Runnable gVar = new g(this, this.s, onCacheRemoveListener);
                this.az.removeCallbacks(gVar);
                this.az.post(gVar);
            } catch (Throwable th) {
                az.a(th, "AMapDelegateImpGLSurfaceView", "removecache");
                th.printStackTrace();
            }
        }
    }

    public void a(OnCameraChangeListener onCameraChangeListener) {
        this.I = onCameraChangeListener;
    }

    public void a(OnInfoWindowClickListener onInfoWindowClickListener) {
        this.N = onInfoWindowClickListener;
    }

    public void a(OnMapClickListener onMapClickListener) {
        this.J = onMapClickListener;
    }

    public void a(OnMapLoadedListener onMapLoadedListener) {
        this.H = onMapLoadedListener;
    }

    public void a(OnMapLongClickListener onMapLongClickListener) {
        this.M = onMapLongClickListener;
    }

    public void a(OnMapScreenShotListener onMapScreenShotListener) {
        this.as = onMapScreenShotListener;
        this.aq = true;
        e(false);
    }

    public void a(OnMapTouchListener onMapTouchListener) {
        this.K = onMapTouchListener;
    }

    public void a(OnMarkerClickListener onMarkerClickListener) {
        this.F = onMarkerClickListener;
    }

    public void a(OnMarkerDragListener onMarkerDragListener) {
        this.G = onMarkerDragListener;
    }

    public void a(OnMyLocationChangeListener onMyLocationChangeListener) {
        this.E = onMyLocationChangeListener;
    }

    public void a(OnPOIClickListener onPOIClickListener) {
        this.L = onPOIClickListener;
    }

    public void a(onMapPrintScreenListener com_amap_api_maps_AMap_onMapPrintScreenListener) {
        this.ar = com_amap_api_maps_AMap_onMapPrintScreenListener;
        this.aq = true;
        e(false);
    }

    public void a(CustomRenderer customRenderer) {
        this.f = customRenderer;
    }

    public void a(LocationSource locationSource) {
        try {
            this.W = locationSource;
            if (locationSource != null) {
                this.B.a(true);
            } else {
                this.B.a(false);
            }
        } catch (Throwable th) {
            az.a(th, "AMapDelegateImpGLSurfaceView", "setLocationSource");
            th.printStackTrace();
        }
    }

    void a(CameraPosition cameraPosition) {
        Message message = new Message();
        message.what = 10;
        message.obj = cameraPosition;
        this.i.sendMessage(message);
    }

    public void a(MyLocationStyle myLocationStyle) {
        if (this.ad != null) {
            this.ad.a(myLocationStyle);
        }
    }

    public void a(GL10 gl10) {
        int i = 0;
        if (!this.n) {
            int[] iArr = new int[kankan.wheel.widget.a.aB];
            gl10.glGenTextures(kankan.wheel.widget.a.aB, iArr, 0);
            while (i < iArr.length) {
                this.o.add(Integer.valueOf(iArr[i]));
                i++;
            }
            this.n = true;
        }
    }

    public void a(boolean z) {
        if (this.c != null) {
            if (z) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    protected void a(boolean z, CameraPosition cameraPosition) {
        if (this.I != null && this.ae.a() && isEnabled()) {
            if (cameraPosition == null) {
                try {
                    cameraPosition = l();
                } catch (Throwable e) {
                    az.a(e, "AMapDelegateImpGLSurfaceView", "cameraChangeFinish");
                    e.printStackTrace();
                }
            }
            this.I.onCameraChangeFinish(cameraPosition);
        }
    }

    public boolean a(String str) {
        e(false);
        return this.g.b(str);
    }

    public float b(float f) {
        return u.b(f);
    }

    public int b() {
        return this.j;
    }

    public void b(double d, double d2, IPoint iPoint) {
        IPoint iPoint2 = new IPoint();
        FPoint fPoint = new FPoint();
        MapProjection.lonlat2Geo(d2, d, iPoint2);
        this.u.geo2Map(iPoint2.x, iPoint2.y, fPoint);
        this.u.map2Win(fPoint.x, fPoint.y, iPoint);
    }

    public void b(int i) {
        if (i == 2) {
            try {
                if (this.q == 3) {
                    this.a.a(new aj(2012).a(false));
                }
                this.q = 2;
                this.a.a(new aj(2011).a(true));
                this.A.a(true);
            } catch (Throwable th) {
                az.a(th, "AMapDelegateImpGLSurfaceView", "setMaptype");
                th.printStackTrace();
            }
        } else if (i == 1) {
            if (this.q == 3) {
                this.a.a(new aj(2012).a(false));
            }
            this.q = 1;
            this.a.a(new aj(2011).a(false));
            this.A.a(false);
        } else {
            if (this.q == 2) {
                this.a.a(new aj(2011).a(false));
            }
            this.q = 3;
            this.a.a(new aj(2012).a(true));
            this.A.a(true);
        }
    }

    public void b(int i, int i2, DPoint dPoint) {
        MapProjection.geo2LonLat(i, i2, dPoint);
    }

    public void b(int i, int i2, FPoint fPoint) {
        this.u.geo2Map(i2, i, fPoint);
    }

    public void b(k kVar) {
        a(kVar, null);
    }

    public void b(boolean z) {
        if (this.B != null) {
            if (z) {
                this.B.setVisibility(0);
            } else {
                this.B.setVisibility(8);
            }
        }
    }

    public boolean b(y yVar) {
        try {
            if (!(this.R == null || this.Q == null)) {
                return this.R.h().equals(yVar.h());
            }
        } catch (Throwable e) {
            az.a(e, "AMapDelegateImpGLSurfaceView", "isInfoWindowShown");
            e.printStackTrace();
        }
        return false;
    }

    public float c(int i) {
        return this.u.getMapLenWithWin(i);
    }

    public MapProjection c() {
        if (this.u == null) {
            this.u = this.r.getMapstate();
        }
        return this.u;
    }

    public void c(boolean z) {
        if (this.C != null) {
            if (z) {
                this.C.setVisibility(0);
                this.C.b();
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public void d() {
        this.ao = Boolean.valueOf(true);
        try {
            T();
            if (this.m != null) {
                this.m.recycle();
                this.m = null;
            }
            if (this.l != null) {
                this.l.recycle();
                this.l = null;
            }
            if (!(this.i == null || this.h == null)) {
                this.i.removeCallbacks(this.h);
                this.h = null;
            }
            if (aG != null) {
                aG.removeCallbacks(this.aH);
            }
            if (this.aw != null) {
                this.s.unregisterReceiver(this.aw);
            }
            if (this.c != null) {
                this.c.a();
            }
            if (this.D != null) {
                this.D.a();
            }
            if (this.A != null) {
                this.A.a();
            }
            if (this.B != null) {
                this.B.a();
            }
            if (this.C != null) {
                this.C.a();
            }
            if (this.d != null) {
                this.d.b();
            }
            if (this.g != null) {
                this.g.b();
            }
            if (this.b != null) {
                this.b.f();
            }
            if (this.aU != null) {
                this.aU.interrupt();
            }
            if (this.t != null) {
                this.t.OnMapDestory(this.r);
            }
            y();
            u.a(this.am);
            if (this.o != null) {
                this.o.clear();
            }
            if (this.p != null) {
                this.p.clear();
            }
            az.c();
            R();
            o.a("amap", "\u5b8c\u5168\u91ca\u653e", 113);
        } catch (Throwable th) {
            az.a(th, "AMapDelegateImpGLSurfaceView", "destroy");
            o.a("amap", "\u6ca1\u6709\u5b8c\u5168\u91ca\u653e" + th.getMessage(), 111);
            th.printStackTrace();
        }
    }

    public void d(int i) {
        if (this.A != null) {
            this.A.a(i);
            this.A.invalidate();
            if (this.D.getVisibility() == 0) {
                this.D.invalidate();
            }
        }
    }

    public void d(boolean z) {
        if (this.D != null) {
            if (z) {
                this.D.setVisibility(0);
                f();
                return;
            }
            this.D.a(com.xiaomi.e.a.f);
            this.D.a(0);
            this.D.setVisibility(8);
        }
    }

    void e() {
        this.i.obtainMessage(14).sendToTarget();
    }

    public void e(int i) {
        if (this.c != null) {
            com.amap.api.mapcore.am.a aVar = (com.amap.api.mapcore.am.a) this.c.getLayoutParams();
            if (i == 0) {
                aVar.d = 16;
            } else if (i == 1) {
                aVar.d = 80;
            }
            this.z.updateViewLayout(this.c, aVar);
        }
    }

    public synchronized void e(boolean z) {
        if (!z) {
            this.aF = false;
            aG.removeCallbacks(this.aH);
            this.aE = false;
        } else if (!(this.aE || this.aF)) {
            this.aF = true;
            aG.postDelayed(this.aH, 6000);
        }
    }

    void f() {
        this.i.sendEmptyMessage(15);
    }

    public void f(int i) {
        if (this.p.contains(Integer.valueOf(i))) {
            this.o.add(Integer.valueOf(i));
            this.p.remove(this.p.indexOf(Integer.valueOf(i)));
        }
    }

    public void f(boolean z) {
        this.aJ = z;
        this.a.a(new aj(2).a(z));
    }

    void g() {
        if (this.D != null && this.Z) {
            try {
                LatLng latLng = l().target;
                float mapZoomer = this.u.getMapZoomer();
                double d = (double) 1.0f;
                int cos = (int) (d * (((double) this.ap[(int) mapZoomer]) / ((double) ((float) ((((Math.cos((latLng.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (256.0d * Math.pow(2.0d, (double) mapZoomer)))))));
                String b = u.b(this.ap[(int) mapZoomer]);
                this.D.a(cos);
                this.D.a(b);
                this.D.invalidate();
            } catch (Throwable th) {
                az.a(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
                th.printStackTrace();
            }
        }
    }

    public void g(int i) {
        this.aj = i;
    }

    public void g(final boolean z) {
        queueEvent(new Runnable(this) {
            final /* synthetic */ AMapDelegateImpGLSurfaceView b;

            public void run() {
                if (this.b.r != null) {
                    this.b.r.setParameter(com.activeandroid.b.a, z ? 1 : 0, 0, 0, 0);
                }
            }
        });
    }

    public int h() {
        return this.X.width();
    }

    public void h(int i) {
        setVisibility(i);
    }

    public void h(boolean z) {
        try {
            if (this.W == null) {
                this.B.a(false);
            } else if (z) {
                this.W.activate(this.ab);
                this.B.a(true);
                if (this.ad == null) {
                    this.ad = new ao(this, this.s);
                }
            } else {
                if (this.ad != null) {
                    this.ad.c();
                    this.ad = null;
                }
                this.an = null;
                this.W.deactivate();
            }
            if (!z) {
                this.V.d(z);
            }
            this.Y = z;
            e(false);
        } catch (Throwable th) {
            az.a(th, "AMapDelegateImpGLSurfaceView", "setMyLocationEnabled");
            th.printStackTrace();
        }
    }

    public int i() {
        return this.X.height();
    }

    public CameraPosition i(boolean z) {
        LatLng latLng;
        if (z) {
            DPoint dPoint = new DPoint();
            a(this.aZ, this.ba, dPoint);
            latLng = new LatLng(dPoint.y, dPoint.x, false);
        } else {
            latLng = V();
        }
        return CameraPosition.builder().target(latLng).bearing(this.u.getMapAngle()).tilt(this.u.getCameraHeaderAngle()).zoom(this.u.getMapZoomer()).build();
    }

    public int j() {
        return this.k;
    }

    void j(boolean z) {
        this.i.obtainMessage(20, z ? 1 : 0, 0).sendToTarget();
    }

    public void k() {
        try {
            if (this.T && this.Q != null && this.R != null) {
                com.amap.api.mapcore.am.a aVar = (com.amap.api.mapcore.am.a) this.Q.getLayoutParams();
                if (aVar != null) {
                    this.R.d();
                    int D = this.R.D() + this.R.B();
                    int E = (this.R.E() + this.R.C()) + 2;
                    aVar.a = this.R.f();
                    aVar.b = D;
                    aVar.c = E;
                    if (this.S != null) {
                        this.S.a(this.R.f());
                        this.S.b(D, E);
                    }
                }
                this.z.onLayout(false, 0, 0, 0, 0);
                e(false);
            }
        } catch (Throwable th) {
            az.a(th, "AMapDelegateImpGLSurfaceView", "redrawInfoWindow");
            th.printStackTrace();
        }
    }

    public void k(boolean z) {
        if (this.ay != z) {
            this.ay = z;
            if (this.aI) {
                this.aI = false;
                queueEvent(new Runnable(this) {
                    final /* synthetic */ AMapDelegateImpGLSurfaceView a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        try {
                            this.a.e(true);
                            this.a.r.setParameter(2501, 0, 0, 0, 0);
                            this.a.U();
                            this.a.r.setParameter(2501, 1, 0, 0, 0);
                            this.a.e(false);
                        } catch (Throwable th) {
                            az.a(th, "AMapDelegateImpGLSurfaceView", "setNightMode");
                            th.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public CameraPosition l() {
        return i(this.aY);
    }

    public void l(final boolean z) {
        queueEvent(new Runnable(this) {
            final /* synthetic */ AMapDelegateImpGLSurfaceView b;

            public void run() {
                this.b.r.setParameter(2601, z ? 0 : 1, 0, 0, 0);
            }
        });
    }

    public float m() {
        return 20.0f;
    }

    public float n() {
        return 3.0f;
    }

    public void o() {
        if (!this.ae.a()) {
            this.ae.a(true);
            a(true, null);
            if (this.ah != null) {
                this.ah.onCancel();
            }
            if (!(this.Q == null || this.S == null)) {
                this.Q.setVisibility(0);
            }
            this.ah = null;
        }
        e(false);
    }

    public void onDrawFrame(GL10 gl10) {
        if (!this.ao.booleanValue()) {
            if (this.aq) {
                this.i.obtainMessage(16, a(0, 0, getWidth(), getHeight(), gl10)).sendToTarget();
                this.aq = false;
            }
            gl10.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            this.r.setGL(gl10);
            this.r.drawFrame(gl10);
            a(gl10);
            this.g.a(gl10, false, this.aj);
            this.d.a(gl10);
            this.b.a(gl10);
            this.aD.a(gl10);
            if (this.S != null) {
                this.S.a(gl10);
            }
            if (!this.ae.a()) {
                this.i.sendEmptyMessage(13);
            }
            if (!this.Z) {
                this.i.sendEmptyMessage(11);
                this.Z = true;
            }
        }
    }

    public void onPause() {
        T();
        if (this.t != null) {
            this.t.onPause();
        }
        if (this.d != null) {
            this.d.d();
        }
        if (this.ad != null) {
            this.ad.a();
        }
    }

    public void onResume() {
        S();
        if (this.t != null) {
            this.t.onResume();
            e(false);
        }
        if (this.d != null) {
            this.d.e();
        }
        if (this.ad != null) {
            this.ad.b();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.X = new Rect(0, 0, i, i2);
        this.r.setGL(gl10);
        this.r.surfaceChange(gl10, i, i2);
        int i3 = this.s.getResources().getDisplayMetrics().densityDpi;
        U();
        if (i3 <= 120) {
            this.r.setParameter(2051, 100, 50, 1, 0);
        } else if (i3 <= 160) {
            if (Math.min(i, i2) >= h.E) {
                this.r.setParameter(2051, 80, 100, 1, 0);
            } else if (Math.max(i, i2) <= kankan.wheel.widget.a.ax) {
                this.r.setParameter(2051, 120, 60, 1, 0);
            } else {
                this.r.setParameter(2051, 100, 80, 1, 0);
            }
        } else if (i3 <= 215) {
            this.r.setParameter(2051, 100, 80, 1, 0);
        } else if (i3 <= RunningReminderInfo.b) {
            if (Math.min(i, i2) >= h.E) {
                this.r.setParameter(2051, 60, 100, 2, 0);
            } else {
                this.r.setParameter(2051, 100, 90, 2, 0);
            }
        } else if (i3 <= kankan.wheel.widget.a.by) {
            if (Math.max(i, i2) <= 1280) {
                this.r.setParameter(2051, 90, 100, 2, 0);
            } else if (Math.max(i, i2) >= 2160) {
                this.r.setParameter(2051, 50, kankan.wheel.widget.a.aC, 2, 0);
            } else {
                this.r.setParameter(2051, 70, kankan.wheel.widget.a.ap, 2, 0);
            }
        } else if (i3 <= kankan.wheel.widget.a.ax) {
            this.r.setParameter(2051, 70, kankan.wheel.widget.a.ap, 3, 0);
        } else if (i3 == 640) {
            this.r.setParameter(2051, 50, cn.com.smartdevices.bracelet.gps.c.a.i, 3, 0);
        } else {
            this.r.setParameter(2051, 60, cn.com.smartdevices.bracelet.gps.c.a.i, 3, 0);
        }
        this.r.setParameter(1021, 1, 0, 0, 0);
        this.r.setParameter(1022, 0, 0, 0, 0);
        this.r.setParameter(1023, 1, 0, 0, 0);
        e(false);
        if (this.h == null) {
            this.h = new Runnable(this) {
                final /* synthetic */ AMapDelegateImpGLSurfaceView a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.i.obtainMessage(19).sendToTarget();
                }
            };
        }
        this.i.postDelayed(this.h, 300);
        if (this.f != null) {
            this.f.onSurfaceChanged(gl10, i, i2);
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        setRenderMode(0);
        S();
        this.r.setGL(gl10);
        U();
        this.r.surfaceCreate(gl10);
        String glGetString = gl10.glGetString(7937);
        if (glGetString != null) {
            if (glGetString.toLowerCase(Locale.US).indexOf("adreno") > -1) {
                this.aa = true;
                this.r.setParameter(AidTask.WHAT_LOAD_AID_SUC, 0, 0, 0, 0);
            } else {
                this.aa = false;
                this.r.setParameter(AidTask.WHAT_LOAD_AID_SUC, 1, 0, 0, 0);
            }
        }
        if (this.l == null || this.l.isRecycled()) {
            this.l = u.a(this.s, "lineTexture.png");
        }
        if (this.m == null || this.m.isRecycled()) {
            this.m = u.a(this.s, "lineDashTexture.png");
        }
        this.j = u.a(gl10, this.l);
        this.k = u.a(gl10, this.m, true);
        this.l = null;
        e(false);
        if (!this.e) {
            try {
                this.aU.setName("AuthThread");
                this.aU.start();
                this.e = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (this.f != null) {
            this.f.onSurfaceCreated(gl10, eGLConfig);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.aW) {
            return false;
        }
        e(false);
        if (motionEvent.getAction() == 261) {
            this.aS = motionEvent.getPointerCount();
        }
        this.v.onTouchEvent(motionEvent);
        this.ac.a(motionEvent);
        this.w.onTouchEvent(motionEvent);
        this.x.a(motionEvent);
        if (motionEvent.getAction() == 2) {
            try {
                a(motionEvent);
            } catch (Throwable e) {
                az.a(e, "AMapDelegateImpGLSurfaceView", "onDragMarker");
                e.printStackTrace();
            }
        }
        if (motionEvent.getAction() == 1) {
            W();
        }
        e(false);
        if (this.K != null) {
            this.aA.removeMessages(1);
            Message obtainMessage = this.aA.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = MotionEvent.obtain(motionEvent);
            obtainMessage.sendToTarget();
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void p() {
        try {
            y();
            this.g.a();
            this.d.b();
            this.b.b();
            e(false);
        } catch (Throwable th) {
            az.a(th, "AMapDelegateImpGLSurfaceView", "clear");
            Log.d("amapApi", "AMapDelegateImpGLSurfaceView clear erro" + th.getMessage());
            th.printStackTrace();
        }
    }

    public int q() {
        return this.q;
    }

    public boolean r() {
        return this.aJ;
    }

    public boolean s() {
        return this.Y;
    }

    public void setZOrderOnTop(boolean z) {
        super.setZOrderOnTop(z);
    }

    public Location t() {
        return this.W != null ? this.ab.a : null;
    }

    public ag u() {
        return this.V;
    }

    public ad v() {
        return this.U;
    }

    public OnCameraChangeListener w() {
        return this.I;
    }

    public View x() {
        return this.z;
    }

    public void y() {
        if (this.Q != null) {
            this.Q.clearFocus();
            this.z.removeView(this.Q);
            u.a(this.Q.getBackground());
            u.a(this.am);
            if (this.S != null) {
                this.S.b(false);
            }
            this.Q = null;
        }
        this.R = null;
    }

    public float z() {
        return this.u.getMapZoomer();
    }
}
