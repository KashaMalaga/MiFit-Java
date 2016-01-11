package android.support.v4.f;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class b implements c {
    b() {
    }

    public boolean a(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        switch (activeNetworkInfo.getType()) {
            case a.i /*0*/:
                return true;
            case l.a /*1*/:
                return false;
            default:
                return true;
        }
    }
}
