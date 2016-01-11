package cn.com.smartdevices.bracelet.gps.ui.a;

import android.app.DialogFragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class g extends DialogFragment implements Runnable {
    private static final String a = "start_number";
    private static final int b = 3;
    private int c = b;
    private final Handler d = new Handler();

    protected static Bundle a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(a, i);
        return bundle;
    }

    private void c() {
        this.d.postDelayed(this, 1000);
    }

    public abstract int a();

    public abstract void b();

    public abstract void b(int i);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.c = arguments.getInt(a, b);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), getTheme())).inflate(a(), viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        this.d.removeCallbacksAndMessages(null);
    }

    public void onResume() {
        super.onResume();
        c();
    }

    public void run() {
        int i = this.c - 1;
        this.c = i;
        if (this.c <= 0) {
            b();
            return;
        }
        b(i);
        c();
    }
}
