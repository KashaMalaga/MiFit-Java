package b.a;

import android.content.Context;
import android.telephony.TelephonyManager;

public class dr extends C0281a {
    private static final String a = "imei";
    private Context b;

    public dr(Context context) {
        super(a);
        this.b = context;
    }

    public String f() {
        TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
        if (telephonyManager == null) {
        }
        try {
            return bW.a(this.b, "android.permission.READ_PHONE_STATE") ? telephonyManager.getDeviceId() : null;
        } catch (Exception e) {
            return null;
        }
    }
}
