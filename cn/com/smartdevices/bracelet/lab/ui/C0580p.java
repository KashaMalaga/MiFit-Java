package cn.com.smartdevices.bracelet.lab.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.xiaomi.e.a;

class C0580p implements OnItemSelectedListener {
    final /* synthetic */ LabFactoryTestActivity a;

    C0580p(LabFactoryTestActivity labFactoryTestActivity) {
        this.a = labFactoryTestActivity;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.a.b = LabFactoryTestActivity.n[i];
        this.a.g.setText(a.f);
        adapterView.setVisibility(0);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
