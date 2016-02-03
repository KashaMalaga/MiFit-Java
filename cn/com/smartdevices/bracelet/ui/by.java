package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.hm.health.R;

public class by extends Fragment {
    protected static TextView b;
    public View a;

    protected void a(View view, bG bGVar) {
        this.a = view.findViewById(R.id.instruction_weight_info);
        b = (TextView) view.findViewById(R.id.instruction_weight_title);
        b.setText(bGVar.a);
        ((TextView) view.findViewById(R.id.instruction_weight_tips1)).setText(bGVar.b);
        ((TextView) view.findViewById(R.id.instruction_weight_tips2)).setText(bGVar.c);
    }
}
