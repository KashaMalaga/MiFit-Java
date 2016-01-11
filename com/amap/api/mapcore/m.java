package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.MapProjection;

class m extends LinearLayout {
    Bitmap a;
    Bitmap b;
    Bitmap c;
    ImageView d;
    t e;

    public m(Context context) {
        super(context);
    }

    public m(Context context, ak akVar, t tVar) {
        super(context);
        this.e = tVar;
        try {
            this.c = u.a(context, "maps_dav_compass_needle_large.png");
            this.b = u.a(this.c, n.a * 0.8f);
            this.c = u.a(this.c, n.a * 0.7f);
            this.a = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(this.a);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawBitmap(this.c, ((float) (this.b.getWidth() - this.c.getWidth())) / 2.0f, ((float) (this.b.getHeight() - this.c.getHeight())) / 2.0f, paint);
            this.d = new ImageView(context);
            this.d.setScaleType(ScaleType.MATRIX);
            this.d.setImageBitmap(this.a);
            this.d.setClickable(true);
            b();
            this.d.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ m a;

                {
                    this.a = r1;
                }

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (this.a.e.M()) {
                            if (motionEvent.getAction() == 0) {
                                this.a.d.setImageBitmap(this.a.b);
                            } else if (motionEvent.getAction() == 1) {
                                this.a.d.setImageBitmap(this.a.a);
                                CameraPosition l = this.a.e.l();
                                this.a.e.b(k.a(new CameraPosition(l.target, l.zoom, 0.0f, 0.0f)));
                            }
                        }
                    } catch (Throwable th) {
                        az.a(th, "CompassView", "onTouch");
                        th.printStackTrace();
                    }
                    return false;
                }
            });
            addView(this.d);
        } catch (Throwable th) {
            az.a(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    public void a() {
        try {
            if (this.a != null) {
                this.a.recycle();
            }
            if (this.b != null) {
                this.b.recycle();
            }
            if (this.c != null) {
                this.c.recycle();
            }
            this.c = null;
            this.a = null;
            this.b = null;
        } catch (Throwable th) {
            az.a(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }

    public void b() {
        try {
            MapProjection c = this.e.c();
            float mapAngle = c.getMapAngle();
            float cameraHeaderAngle = c.getCameraHeaderAngle();
            Matrix matrix = new Matrix();
            matrix.postRotate(-mapAngle, ((float) this.d.getDrawable().getBounds().width()) / 2.0f, ((float) this.d.getDrawable().getBounds().height()) / 2.0f);
            matrix.postScale(1.0f, (float) Math.cos((((double) cameraHeaderAngle) * 3.141592653589793d) / 180.0d), ((float) this.d.getDrawable().getBounds().width()) / 2.0f, ((float) this.d.getDrawable().getBounds().height()) / 2.0f);
            this.d.setImageMatrix(matrix);
        } catch (Throwable th) {
            az.a(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }
}
