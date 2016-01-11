package cn.com.smartdevices.bracelet.gps.services;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Message;

final class E implements SensorEventListener {
    final /* synthetic */ A a;

    private E(A a) {
        this.a = a;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Message obtainMessage = this.a.k.obtainMessage();
        obtainMessage.obj = sensorEvent;
        obtainMessage.what = 1;
        this.a.k.sendMessage(obtainMessage);
    }
}
