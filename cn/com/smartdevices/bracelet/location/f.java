package cn.com.smartdevices.bracelet.location;

import android.content.Intent;
import android.support.v4.content.v;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;

class f implements d {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public void a(Location location) {
        C0596r.e("LocationManager", "Location Received : " + location);
        C0401a.a(this.a.i, C0401a.eE);
        Utils.a(this.a.i, location);
        Intent intent = new Intent(e.d);
        intent.putExtra(e.e, location);
        v.a(this.a.i).a(intent);
    }
}
