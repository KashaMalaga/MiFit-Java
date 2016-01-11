package cn.com.smartdevices.bracelet.heartrate;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.gps.services.O;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import com.amap.api.location.LocationManagerProxy;
import com.xiaomi.e.a;

class i implements OnClickListener {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void onClick(View view) {
        HeartRateItem heartRateItem = (HeartRateItem) ((j) view.getTag()).a.getTag();
        Intent intent = new Intent();
        intent.putExtra(O.j, heartRateItem.hr + a.f);
        intent.putExtra(g.f, heartRateItem.time + a.f);
        intent.putExtra(LocationManagerProxy.KEY_STATUS_CHANGED, this.a.c(heartRateItem.hr) + a.f);
        intent.setClass(this.a.c, HeartRateDetailsActivity.class);
        this.a.c.startActivity(intent);
    }
}
