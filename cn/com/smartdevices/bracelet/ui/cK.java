package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.smartdevices.bracelet.C0596r;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class cK implements OnItemClickListener {
    final /* synthetic */ cJ a;

    cK(cJ cJVar) {
        this.a = cJVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0596r.e("NewAlarmActivity", "onItemClick: " + i);
        switch (i) {
            case a.i /*0*/:
            case l.a /*1*/:
            case a.k /*2*/:
                this.a.a = NewAlarmActivity.a[i];
                ((NewAlarmActivity) this.a.getActivity()).c(this.a.a);
                break;
            case a.l /*3*/:
                Intent intent = new Intent(this.a.getActivity(), AlarmRepeatActivity.class);
                intent.putExtra(a.bv, this.a.a);
                this.a.getActivity().startActivityForResult(intent, 1);
                break;
        }
        this.a.dismiss();
    }
}
