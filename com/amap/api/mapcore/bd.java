package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.u;

class bd extends LinearLayout {
    private Bitmap a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private Bitmap l;
    private ImageView m;
    private ImageView n;
    private t o;

    public bd(Context context) {
        super(context);
    }

    public bd(Context context, t tVar) {
        super(context);
        this.o = tVar;
        try {
            this.g = u.a(context, "zoomin_selected.png");
            this.a = u.a(this.g, n.a);
            this.h = u.a(context, "zoomin_unselected.png");
            this.b = u.a(this.h, n.a);
            this.i = u.a(context, "zoomout_selected.png");
            this.c = u.a(this.i, n.a);
            this.j = u.a(context, "zoomout_unselected.png");
            this.d = u.a(this.j, n.a);
            this.k = u.a(context, "zoomin_pressed.png");
            this.e = u.a(this.k, n.a);
            this.l = u.a(context, "zoomout_pressed.png");
            this.f = u.a(this.l, n.a);
            this.m = new ImageView(context);
            this.m.setImageBitmap(this.a);
            this.m.setClickable(true);
            this.n = new ImageView(context);
            this.n.setImageBitmap(this.c);
            this.n.setClickable(true);
        } catch (Throwable th) {
            az.a(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
        this.m.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ bd a;

            {
                this.a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.a.o.z() < this.a.o.m() && this.a.o.M()) {
                    if (motionEvent.getAction() == 0) {
                        this.a.m.setImageBitmap(this.a.e);
                    } else if (motionEvent.getAction() == 1) {
                        this.a.m.setImageBitmap(this.a.a);
                        try {
                            this.a.o.b(k.b());
                        } catch (Throwable e) {
                            az.a(e, "ZoomControllerView", "zoomin ontouch");
                            e.printStackTrace();
                        }
                    }
                }
                return false;
            }
        });
        this.n.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ bd a;

            {
                this.a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.a.o.z() > this.a.o.n() && this.a.o.M()) {
                    if (motionEvent.getAction() == 0) {
                        this.a.n.setImageBitmap(this.a.f);
                    } else if (motionEvent.getAction() == 1) {
                        this.a.n.setImageBitmap(this.a.c);
                        try {
                            this.a.o.b(k.c());
                        } catch (Throwable e) {
                            az.a(e, "ZoomControllerView", "zoomout ontouch");
                            e.printStackTrace();
                        }
                    }
                }
                return false;
            }
        });
        this.m.setPadding(0, 0, 20, -2);
        this.n.setPadding(0, 0, 20, 20);
        setOrientation(1);
        addView(this.m);
        addView(this.n);
    }

    public void a() {
        try {
            this.a.recycle();
            this.b.recycle();
            this.c.recycle();
            this.d.recycle();
            this.e.recycle();
            this.f.recycle();
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            if (this.g != null) {
                this.g.recycle();
                this.g = null;
            }
            if (this.h != null) {
                this.h.recycle();
                this.h = null;
            }
            if (this.i != null) {
                this.i.recycle();
                this.i = null;
            }
            if (this.j != null) {
                this.j.recycle();
                this.g = null;
            }
            if (this.k != null) {
                this.k.recycle();
                this.k = null;
            }
            if (this.l != null) {
                this.l.recycle();
                this.l = null;
            }
            removeAllViews();
            this.m = null;
            this.n = null;
        } catch (Throwable th) {
            az.a(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public void a(float f) {
        if (f < this.o.m() && f > this.o.n()) {
            this.m.setImageBitmap(this.a);
            this.n.setImageBitmap(this.c);
        } else if (f == this.o.n()) {
            this.n.setImageBitmap(this.d);
            this.m.setImageBitmap(this.a);
        } else if (f == this.o.m()) {
            this.m.setImageBitmap(this.b);
            this.n.setImageBitmap(this.c);
        }
    }
}
