package cn.com.smartdevices.bracelet.gps.ui;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;

class C0517bc implements OnSeekBarChangeListener {
    final /* synthetic */ RunningSettingActivity a;
    private int b = 0;

    C0517bc(RunningSettingActivity runningSettingActivity) {
        this.a = runningSettingActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.b = (i * 15) + RunningReminderInfo.b;
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.a.f.e(this.b);
        this.a.d(this.b);
        this.a.d();
    }
}
