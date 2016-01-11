package cn.com.smartdevices.bracelet.tag;

import com.tencent.connect.common.Constants;
import kankan.wheel.widget.a;

class g implements Runnable {
    StringBuilder a = new StringBuilder();
    final /* synthetic */ TagDataActivity b;

    g(TagDataActivity tagDataActivity) {
        this.b = tagDataActivity;
    }

    public void run() {
        if (this.b.f) {
            this.b.o.setText("00:00:00");
            this.b.x = 0;
            return;
        }
        this.b.x = this.b.x + 1;
        this.a.delete(0, this.a.length());
        int d = this.b.x / 3600;
        if (d < 10) {
            this.a.append(Constants.VIA_RESULT_SUCCESS);
        }
        this.a.append(d).append(a.ci);
        d = this.b.x % 3600;
        int i = d / 60;
        if (i < 10) {
            this.a.append(Constants.VIA_RESULT_SUCCESS);
        }
        this.a.append(i).append(a.ci);
        d %= 60;
        if (d < 10) {
            this.a.append(Constants.VIA_RESULT_SUCCESS);
        }
        this.a.append(d);
        this.b.o.setText(this.a.toString());
        this.b.e();
    }
}
