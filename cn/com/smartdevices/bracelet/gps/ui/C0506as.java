package cn.com.smartdevices.bracelet.gps.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class C0506as implements OnItemClickListener {
    final /* synthetic */ LabelInputActivity a;

    C0506as(LabelInputActivity labelInputActivity) {
        this.a = labelInputActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CharSequence a = this.a.b.a(i);
        if (a != null && !TextUtils.isEmpty(a)) {
            this.a.d.setText(a);
        }
    }
}
