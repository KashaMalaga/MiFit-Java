package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher.ViewFactory;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.view.GifView;

public class C0709bk extends Fragment implements ViewFactory {
    protected byte[] a_;
    protected GifView b_;
    protected TextSwitcher c_;

    public void a() {
        if (this.b_ != null) {
            this.b_.f();
        }
    }

    protected void a(View view) {
        View findViewById = view.findViewById(l.gif_view);
        if (findViewById != null) {
            this.b_ = (GifView) findViewById;
        }
        this.c_ = (TextSwitcher) view.findViewById(l.tip);
        this.c_.setFactory(this);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300);
        Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(300);
        this.c_.setInAnimation(alphaAnimation);
        this.c_.setOutAnimation(alphaAnimation2);
    }

    public void b() {
        if (this.b_ != null) {
            this.b_.e();
        }
    }

    public View makeView() {
        return LayoutInflater.from(getActivity()).inflate(n.activity_instruction_page_tip_textview, this.c_, false);
    }

    public void onDestroy() {
        if (this.b_ != null) {
            try {
                this.b_.d();
                this.b_ = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        super.onDestroy();
    }
}
