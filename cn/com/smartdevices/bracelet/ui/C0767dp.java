package cn.com.smartdevices.bracelet.ui;

import android.support.v4.app.aj;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.smartdevices.bracelet.model.BtDevice;

class C0767dp implements OnItemClickListener {
    final /* synthetic */ SearchSingleBraceletActivity a;

    C0767dp(SearchSingleBraceletActivity searchSingleBraceletActivity) {
        this.a = searchSingleBraceletActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.a.ad) {
            this.a.ad = true;
            SearchSingleBraceletActivity.v.removeMessages(4098);
            SearchSingleBraceletActivity.v.removeMessages(aj.K);
            this.a.p();
            this.a.a(((BtDevice) this.a.x.get(i)).device);
            this.a.a(false);
        }
    }
}
