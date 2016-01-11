package cn.com.smartdevices.bracelet.gps.ui.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.gps.h.k;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.o;

public class a extends DialogFragment {
    private static final String e = "start_count_number";
    private static final int f = 1000;
    private static final String h = "AnimateCountDownFragment";
    private TextView a = null;
    private int b = 0;
    private int c = 0;
    private boolean d = false;
    private f g = null;
    private AnimatorSet i = null;

    private int a() {
        return j.fragment_running_count_down;
    }

    public static a a(int i) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt(e, i);
        aVar.setArguments(bundle);
        return aVar;
    }

    private void b() {
        if (this.b > 0) {
            this.c = this.b;
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{100});
            ofInt.setDuration(200);
            ofInt.setInterpolator(new AnticipateOvershootInterpolator());
            ofInt.addUpdateListener(new c(this));
            ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{100});
            ofInt2.setDuration(50);
            ofInt2.setInterpolator(new DecelerateInterpolator());
            ofInt2.setStartDelay(750);
            ofInt2.addUpdateListener(new d(this));
            this.i = new AnimatorSet();
            this.i.playSequentially(new Animator[]{ofInt, ofInt2});
            this.i.addListener(new e(this));
            this.i.start();
        }
    }

    static /* synthetic */ int d(a aVar) {
        int i = aVar.b - 1;
        aVar.b = i;
        return i;
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.g = fVar;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        this.d = true;
        if (this.g != null) {
            this.g.a();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = o.CountDownDimTint;
        if (k.b(getActivity())) {
            i = o.CountDownDimDialogTint;
        }
        setStyle(0, i);
        this.b = getArguments().getInt(e);
        this.c = this.b;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), getTheme())).inflate(a(), viewGroup, false);
        this.a = (TextView) inflate.findViewById(i.counter);
        this.a.postDelayed(new b(this), 500);
        return inflate;
    }

    public void onResume() {
        super.onResume();
    }
}
