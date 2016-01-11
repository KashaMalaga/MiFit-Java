package cn.com.smartdevices.bracelet.tag;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class b extends Fragment implements Runnable {
    public static final int a = 3;
    private static final String b = "start_number";
    private static final String c = "CounterFragment";
    private TextView d;
    private int e = a;
    private c f;

    public static b a(int i) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putInt(b, i);
        bVar.setArguments(bundle);
        return bVar;
    }

    private void a() {
        C0596r.e(c, "startCounter");
        this.d.postDelayed(this, 1000);
    }

    public void onAttach(Activity activity) {
        C0596r.e(c, "onAttach");
        super.onAttach(activity);
        try {
            this.f = (c) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    public void onCreate(Bundle bundle) {
        C0596r.e(c, "onCreate");
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.e = arguments.getInt(b, a);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C0596r.e(c, "onCreateView");
        View inflate = layoutInflater.inflate(n.fragment_counter, viewGroup, false);
        this.d = (TextView) inflate.findViewById(l.counter);
        return inflate;
    }

    public void onResume() {
        C0596r.e(c, "onResume");
        super.onResume();
        a();
    }

    public void run() {
        int i = this.e - 1;
        this.e = i;
        if (this.e > 0) {
            this.d.setText(i + a.f);
            a();
        } else if (this.f != null) {
            this.f.a(2);
        }
    }
}
