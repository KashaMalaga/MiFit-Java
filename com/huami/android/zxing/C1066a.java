package com.huami.android.zxing;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.huami.android.zxing.a.g;

final class C1066a implements SensorEventListener {
    private static final float a = 45.0f;
    private static final float b = 450.0f;
    private final Context c;
    private g d;
    private Sensor e;

    C1066a(Context context) {
        this.c = context;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (this.d == null) {
            return;
        }
        if (f <= a) {
            this.d.a(true);
        } else if (f >= b) {
            this.d.a(false);
        }
    }

    void start(g gVar) {
        this.d = gVar;
    }

    void stop() {
        if (this.e != null) {
            ((SensorManager) this.c.getSystemService("sensor")).unregisterListener(this);
            this.d = null;
            this.e = null;
        }
    }
}
