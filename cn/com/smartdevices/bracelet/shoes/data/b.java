package cn.com.smartdevices.bracelet.shoes.data;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.g;
import cn.com.smartdevices.bracelet.shoes.sync.C0635l;

public final class b {
    private b() {
    }

    public static g a(Context context) {
        return C0635l.a(context).g();
    }

    public static String a(Context context, boolean z) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        String a = C0635l.a(context).a();
        return TextUtils.isEmpty(a) ? null : (!z || BluetoothAdapter.checkBluetoothAddress(a)) ? a : null;
    }

    public static c b(Context context, boolean z) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        c b = C0635l.a(context).b();
        return (b == null || b.e()) ? null : (!z || BluetoothAdapter.checkBluetoothAddress(b.b())) ? b : null;
    }

    public static boolean b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        Object a = C0635l.a(context).a();
        return TextUtils.isEmpty(a) ? false : BluetoothAdapter.checkBluetoothAddress(a);
    }
}
