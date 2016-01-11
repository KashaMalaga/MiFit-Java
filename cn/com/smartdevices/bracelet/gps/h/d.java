package cn.com.smartdevices.bracelet.gps.h;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class d {
    private d() {
    }

    public static String a(Context context, double d, double d2) {
        List b = b(context, d, d2);
        if (b != null && b.size() > 0) {
            return a(b);
        }
        C0596r.e("Address", "addressList is 0");
        return a.f;
    }

    private static String a(List<Address> list) {
        if (list == null || list.size() <= 0) {
            return a.f;
        }
        Address address = (Address) list.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(address.getLocality()).append("|").append(address.getSubLocality());
        return stringBuilder.toString();
    }

    private static List<Address> b(Context context, double d, double d2) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            return new Geocoder(context, Locale.getDefault()).getFromLocation(d, d2, 1);
        } catch (IOException e) {
            C0596r.e("Address", e.getMessage());
            return null;
        }
    }
}
