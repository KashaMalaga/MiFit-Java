package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.view.f;
import java.io.IOException;

public class C0713bo extends C0709bk {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0596r.e("DDDD", "Load Gif!!");
        try {
            this.a_ = InstructionActivity.b(getResources().openRawResource(R.drawable.intruction_3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_instruction_page_2, viewGroup, false);
        a(inflate);
        this.c_.setCurrentText(getString(R.string.instruction_tip_3));
        this.b_.a(f.COVER);
        this.b_.c();
        return inflate;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.b_ != null) {
            if (z) {
                this.b_.a(this.a_);
            } else {
                this.b_.f();
            }
        }
    }
}
