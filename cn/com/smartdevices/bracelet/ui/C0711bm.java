package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.view.f;
import com.xiaomi.hm.view.g;
import java.io.IOException;

public class C0711bm extends C0709bk implements g {
    private static int d = 4;
    private int e;

    public void a(int i) {
        if (i >= d) {
            this.b_.post(new C0712bn());
        }
    }

    public void b(int i) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0596r.e("DDDD", "Load Gif!!");
        try {
            this.a_ = InstructionActivity.b(getResources().openRawResource(R.drawable.intruction_2_1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_instruction_page_2, viewGroup, false);
        a(inflate);
        this.c_.setCurrentText(getString(R.string.instruction_tip_2_1));
        this.b_.a(f.COVER);
        this.b_.b(d);
        this.b_.a((g) this, 1);
        return inflate;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.b_ != null) {
            if (z) {
                this.c_.setCurrentText(getString(R.string.instruction_tip_2_1));
                this.b_.a(this.a_);
                this.e = 1;
                return;
            }
            this.b_.f();
        }
    }
}
