package cn.com.smartdevices.bracelet.h;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import cn.com.smartdevices.bracelet.C0596r;

class d implements SensorEventListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        C0596r.e("SensorHubController", "Step:" + String.valueOf(sensorEvent.values[0]));
        C0596r.e("SensorHubController", "Step:" + String.valueOf(a.a(this.a, sensorEvent.values[0])));
        if (this.a.j != null) {
            this.a.j.a(this.a.h);
        }
    }
}
