package cn.com.smartdevices.bracelet.lab.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class C0579o implements OnItemSelectedListener {
    final /* synthetic */ LabFactoryTestActivity a;

    C0579o(LabFactoryTestActivity labFactoryTestActivity) {
        this.a = labFactoryTestActivity;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.a.p = LabFactoryTestActivity.o[i];
        adapterView.setVisibility(0);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
