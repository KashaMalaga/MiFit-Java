package android.support.v4.f;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class h {
    h() {
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        switch (activeNetworkInfo.getType()) {
            case a.i /*0*/:
            case a.k /*2*/:
            case a.l /*3*/:
            case a.aQ /*4*/:
            case a.X /*5*/:
            case a.bt /*6*/:
                return true;
            case l.a /*1*/:
            case a.bc /*7*/:
            case a.bo /*9*/:
                return false;
            default:
                return true;
        }
    }
}
