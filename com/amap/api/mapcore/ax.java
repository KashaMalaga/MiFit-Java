package com.amap.api.mapcore;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.RemoteException;
import android.view.WindowManager;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Marker;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class ax implements SensorEventListener {
    private SensorManager a;
    private Sensor b;
    private long c = 0;
    private final int d = 100;
    private float e;
    private Context f;
    private t g;
    private Marker h;

    public ax(Context context, t tVar) {
        this.f = context;
        this.g = tVar;
        this.a = (SensorManager) context.getSystemService("sensor");
        this.b = this.a.getDefaultSensor(3);
    }

    public static int a(Context context) {
        switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
            case a.i /*0*/:
                return 0;
            case l.a /*1*/:
                return 90;
            case a.k /*2*/:
                return cn.com.smartdevices.bracelet.gps.c.a.i;
            case a.l /*3*/:
                return -90;
            default:
                return 0;
        }
    }

    public void a() {
        this.a.registerListener(this, this.b, 3);
    }

    public void a(Marker marker) {
        this.h = marker;
    }

    public void b() {
        this.a.unregisterListener(this, this.b);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (System.currentTimeMillis() - this.c >= 100 && this.g.N().a()) {
            switch (sensorEvent.sensor.getType()) {
                case a.l /*3*/:
                    float a = (sensorEvent.values[0] + ((float) a(this.f))) % 360.0f;
                    if (a > BitmapDescriptorFactory.HUE_CYAN) {
                        a -= 360.0f;
                    } else if (a < -180.0f) {
                        a += 360.0f;
                    }
                    if (Math.abs(this.e - a) >= 3.0f) {
                        if (Float.isNaN(a)) {
                            a = 0.0f;
                        }
                        this.e = a;
                        if (this.h != null) {
                            try {
                                this.g.a(k.d(this.e));
                                this.h.setRotateAngle(-this.e);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                        this.c = System.currentTimeMillis();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
