package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.chart.util.t;
import com.xiaomi.hm.health.R;

public abstract class p extends Fragment {
    protected TextView a;

    private void a(View view) {
        this.a = (TextView) view.findViewById(R.id.home_back);
        if (this.a != null) {
            this.a.setOnClickListener(new C0816q(this));
            if (t.a() && !b()) {
                this.a.setTextSize(14.0f);
            }
        }
    }

    protected void a() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    protected void a(String str) {
        this.a.setText(str);
    }

    protected void b(int i) {
        this.a.setText(i);
    }

    protected boolean b() {
        return false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }
}
