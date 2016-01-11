package cn.com.smartdevices.bracelet.shoes.b;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.d.e;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class a {
    public static final int a = -100;

    public static boolean a() {
        try {
            return ((Boolean) Class.forName("cn.com.smartdevices.bracelet.datasource.DeviceSource").getMethod("hasBindBracelet", (Class[]) null).invoke(null, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            C0596r.e("BleDevice", e.toString());
            return false;
        }
    }

    public static boolean a(boolean z, e eVar) {
        try {
            Method method = Class.forName("cn.com.smartdevices.bracelet.datasource.RtStep").getMethod("enableRtSteps", new Class[]{Boolean.TYPE, e.class});
            if (method == null) {
                return false;
            }
            method.invoke(null, new Object[]{Boolean.valueOf(z), eVar});
            return true;
        } catch (Exception e) {
            C0596r.a("BleDevice", "Error = " + e.getMessage());
            return false;
        }
    }

    public static int b() {
        try {
            Method method = Class.forName("cn.com.smartdevices.bracelet.datasource.RtStep").getMethod("getRealtimeSteps", new Class[0]);
            return method == null ? -1 : ((Integer) method.invoke(null, new Object[0])).intValue();
        } catch (Exception e) {
            C0596r.a("BleDevice", e.getMessage());
            return -1;
        }
    }

    public static int c() {
        int i = a;
        try {
            Field declaredField = Class.forName("cn.com.smartdevices.bracelet.datasource.RtStep").getDeclaredField("ENABLE_REALTIME_STEP_FAILED");
            if (declaredField != null) {
                i = declaredField.getInt(null);
            }
        } catch (Exception e) {
            C0596r.a("BleDevice", e.getMessage());
        }
        return i;
    }

    public static int d() {
        int i = a;
        try {
            Field declaredField = Class.forName("cn.com.smartdevices.bracelet.datasource.RtStep").getDeclaredField("GET_STEPS_FAILED");
            if (declaredField != null) {
                i = declaredField.getInt(null);
            }
        } catch (Exception e) {
            C0596r.a("BleDevice", e.getMessage());
        }
        return i;
    }

    public static int e() {
        int i = a;
        try {
            Field declaredField = Class.forName("cn.com.smartdevices.bracelet.datasource.RtStep").getDeclaredField("NO_BINDED_DEVICES");
            if (declaredField != null) {
                i = declaredField.getInt(null);
            }
        } catch (Exception e) {
            C0596r.a("BleDevice", e.getMessage());
        }
        return i;
    }

    public static boolean f() {
        try {
            Method method = Class.forName("cn.com.smartdevices.bracelet.datasource.DeviceSource").getMethod("hasBindBracelet", new Class[0]);
            return method == null ? false : ((Boolean) method.invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            C0596r.a("BleDevice", e.getMessage());
            return false;
        }
    }

    public static boolean g() {
        try {
            Method method = Class.forName("cn.com.smartdevices.bracelet.datasource.DeviceSource").getMethod("hasBindSensorHub", new Class[0]);
            return method == null ? false : ((Boolean) method.invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            C0596r.a("BleDevice", e.getMessage());
            return false;
        }
    }

    public static boolean h() {
        try {
            Method method = Class.forName("cn.com.smartdevices.bracelet.datasource.DeviceSource").getMethod("hasBindShoesDevice", new Class[0]);
            return method == null ? false : ((Boolean) method.invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            C0596r.a("BleDevice", e.getMessage());
            return false;
        }
    }
}
