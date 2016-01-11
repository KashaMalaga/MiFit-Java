package cn.com.smartdevices.bracelet.gps.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class C0511ax implements OnItemClickListener {
    final /* synthetic */ C0510aw a;

    C0511ax(C0510aw c0510aw) {
        this.a = c0510aw;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CharSequence a = this.a.b.a(i);
        if (a != null && !TextUtils.isEmpty(a)) {
            this.a.d.setText(a);
        }
    }
}
