package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.model.LatLng;

class ah extends LinearLayout {
    Bitmap a;
    Bitmap b;
    Bitmap c;
    Bitmap d;
    Bitmap e;
    Bitmap f;
    ImageView g;
    t h;
    boolean i = false;

    public ah(Context context) {
        super(context);
    }

    public ah(Context context, ak akVar, t tVar) {
        super(context);
        this.h = tVar;
        try {
            this.d = u.a(context, "location_selected.png");
            this.a = u.a(this.d, n.a);
            this.e = u.a(context, "location_pressed.png");
            this.b = u.a(this.e, n.a);
            this.f = u.a(context, "location_unselected.png");
            this.c = u.a(this.f, n.a);
        } catch (Throwable th) {
            az.a(th, "LocationView", "create");
            th.printStackTrace();
        }
        this.g = new ImageView(context);
        this.g.setImageBitmap(this.a);
        this.g.setClickable(true);
        this.g.setPadding(0, 20, 20, 0);
        this.g.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ah a;

            {
                this.a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.a.i) {
                    if (motionEvent.getAction() == 0) {
                        this.a.g.setImageBitmap(this.a.b);
                    } else if (motionEvent.getAction() == 1) {
                        try {
                            this.a.g.setImageBitmap(this.a.a);
                            this.a.h.h(true);
                            Location t = this.a.h.t();
                            if (t != null) {
                                LatLng latLng = new LatLng(t.getLatitude(), t.getLongitude());
                                this.a.h.a(t);
                                this.a.h.a(k.a(latLng, this.a.h.z()));
                            }
                        } catch (Throwable th) {
                            az.a(th, "LocationView", "onTouch");
                            th.printStackTrace();
                        }
                    }
                }
                return false;
            }
        });
        addView(this.g);
    }

    public void a() {
        try {
            if (this.a != null) {
                this.a.recycle();
            }
            if (this.b != null) {
                this.b.recycle();
            }
            if (this.b != null) {
                this.c.recycle();
            }
            this.a = null;
            this.b = null;
            this.c = null;
            if (this.d != null) {
                this.d.recycle();
                this.d = null;
            }
            if (this.e != null) {
                this.e.recycle();
                this.e = null;
            }
            if (this.f != null) {
                this.f.recycle();
                this.f = null;
            }
        } catch (Throwable th) {
            az.a(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    public void a(boolean z) {
        this.i = z;
        if (z) {
            this.g.setImageBitmap(this.a);
        } else {
            this.g.setImageBitmap(this.c);
        }
        this.g.invalidate();
    }
}
