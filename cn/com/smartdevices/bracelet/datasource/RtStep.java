package cn.com.smartdevices.bracelet.datasource;

import android.content.Context;
import com.xiaomi.hm.health.bt.d.e;

public abstract class RtStep {
    public static final int ENABLE_REALTIME_STEP_FAILED = -3;
    public static final int GET_STEPS_FAILED = -1;
    public static final int NO_BINDED_DEVICES = -2;
    private static RtStep gRtStep = null;
    protected String TAG = getClass().getSimpleName();
    private int source = 0;

    public RtStep(int i) {
        this.source = i;
    }

    public static void enableRtSteps(Context context, int i, boolean z, e eVar) {
        if (i == 3) {
            b.a(context, z, eVar);
            return;
        }
        enableRtSteps(z, eVar);
        b.a(context, false, eVar);
    }

    public static void enableRtSteps(boolean z, e eVar) {
        if (gRtStep != null) {
            if (DeviceSource.hasBindSensorHub() && (gRtStep instanceof c)) {
                gRtStep.enable(false, eVar);
                gRtStep = null;
            } else if ((DeviceSource.hasBindBracelet() || DeviceSource.hasBindShoesDevice()) && (gRtStep instanceof e)) {
                gRtStep.enable(false, eVar);
                gRtStep = null;
            }
        }
        if (DeviceSource.hasBindSensorHub()) {
            if (gRtStep == null) {
                gRtStep = new e();
            }
            gRtStep.enable(true, eVar);
        } else if (DeviceSource.hasBindBracelet()) {
            if (gRtStep == null) {
                gRtStep = new c();
            }
            gRtStep.enable(z, eVar);
        } else {
            eVar.a(NO_BINDED_DEVICES);
        }
    }

    public static int getRealtimeSteps() {
        if (gRtStep != null) {
            if (DeviceSource.hasBindSensorHub() && (gRtStep instanceof c)) {
                gRtStep = null;
            } else if (DeviceSource.hasBindBracelet() && (gRtStep instanceof e)) {
                gRtStep = null;
            }
        }
        if (DeviceSource.hasBindSensorHub()) {
            if (gRtStep == null) {
                gRtStep = new e();
            }
            return gRtStep.getSteps();
        } else if (!DeviceSource.hasBindBracelet()) {
            return NO_BINDED_DEVICES;
        } else {
            if (gRtStep == null) {
                gRtStep = new c();
            }
            return gRtStep.getSteps();
        }
    }

    public abstract boolean enable(boolean z, e eVar);

    public int getSource() {
        return this.source;
    }

    public abstract int getSteps();
}
