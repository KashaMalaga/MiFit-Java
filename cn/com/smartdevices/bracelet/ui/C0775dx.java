package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.model.BtDevice;

class C0775dx implements OnItemClickListener {
    final /* synthetic */ SearchWeightScaleActivity a;

    C0775dx(SearchWeightScaleActivity searchWeightScaleActivity) {
        this.a = searchWeightScaleActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.a.e();
        if (this.a.u != -1) {
            this.a.h();
            DeviceSource.unbindWeight();
        }
        this.a.u = i;
        this.a.x = ((BtDevice) this.a.s.get(i)).device;
        this.a.a(this.a.x);
        this.a.w = false;
        this.a.a(this.a.w);
        this.a.applyStatusBarTintAuto();
    }
}
