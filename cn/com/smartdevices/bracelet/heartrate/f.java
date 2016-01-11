package cn.com.smartdevices.bracelet.heartrate;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.gps.services.O;
import com.amap.api.location.LocationManagerProxy;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.l;

class f implements OnClickListener {
    final /* synthetic */ HeartRateDetailsActivity a;

    f(HeartRateDetailsActivity heartRateDetailsActivity) {
        this.a = heartRateDetailsActivity;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.btn_sports /*2131296409*/:
                Intent intent = new Intent();
                intent.putExtra(O.j, this.a.h + a.f);
                intent.putExtra(g.f, this.a.i + a.f);
                intent.putExtra(LocationManagerProxy.KEY_STATUS_CHANGED, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP);
                intent.setClass(this.a.getApplicationContext(), HeartRateDetailsActivity.class);
                this.a.startActivity(intent);
                this.a.l.a(this.a.i);
                this.a.finish();
                return;
            default:
                return;
        }
    }
}
