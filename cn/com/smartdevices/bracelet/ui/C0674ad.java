package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.i;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class C0674ad extends i {
    public C0674ad(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public int a(Object obj) {
        return -2;
    }

    public Fragment a(int i) {
        switch (i) {
            case a.i /*0*/:
                return DeviceSource.hasBindBracelet() ? new C0784ee() : new A();
            case l.a /*1*/:
                return DeviceSource.hasBindWeight() ? new eD() : new B();
            default:
                return null;
        }
    }

    public int b() {
        return DeviceSource.getDeviceCount();
    }
}
