package cn.com.smartdevices.bracelet.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;

public class C0675ae extends c {
    private static final String a = C0675ae.class.getSimpleName();
    private TextView b;
    private TextView c;
    private TextView d;
    private View e;
    private View f;
    private String g;
    private String h;
    private String i;
    private String j;
    private C0680aj k;

    private void a() {
        DialogFragment c0679ai = new C0679ai();
        c0679ai.setOpClickListener(new C0678ah(this, c0679ai));
        Bundle bundle = new Bundle();
        bundle.putString("Msg", this.g);
        c.showPanel(getActivity(), c0679ai, bundle);
        dismiss();
    }

    private void a(View view) {
        this.b = (TextView) view.findViewById(R.id.text_first);
        if (!(this.h == null || this.h.isEmpty())) {
            this.b.setText(this.h);
        }
        this.c = (TextView) view.findViewById(R.id.text_second);
        if (!(this.i == null || this.i.isEmpty())) {
            this.c.setText(this.i);
        }
        this.e = view.findViewById(R.id.weight_edit_delete);
        this.f = view.findViewById(R.id.weight_edit_move);
        this.e.setOnClickListener(new C0676af(this));
        this.f.setOnClickListener(new C0677ag(this));
    }

    public void a(C0680aj c0680aj) {
        this.k = c0680aj;
    }

    public void a(String str) {
        this.h = str;
    }

    public void b(String str) {
        this.i = str;
    }

    public void c(String str) {
        this.j = str;
    }

    public void d(String str) {
        this.g = str;
    }

    protected int inflateLayout() {
        return R.layout.dialog_weight_info_modify;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(getView());
    }
}
