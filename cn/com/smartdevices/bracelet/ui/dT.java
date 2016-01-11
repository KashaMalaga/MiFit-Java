package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.j.l;
import com.huami.android.view.b;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import java.util.regex.Pattern;

public class dT extends p implements OnClickListener {
    private static final String e = "^[\\w\\-\\.]+@[\\w\\-]+(\\.\\w+)+$";
    private static final String f = "^\\d+$";
    private EditText b;
    private EditText c;
    private View d;

    private void a(String str, String str2) {
        this.d.setEnabled(false);
        l.a(a.f(getActivity()), str, str2, new dV(this));
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && (Pattern.compile(e).matcher(str).matches() || Pattern.compile(f).matcher(str).matches());
    }

    protected boolean b() {
        return true;
    }

    public void onClick(View view) {
        String obj = this.b.getText().toString();
        String obj2 = this.c.getText().toString();
        if (!b(obj)) {
            b.a(getActivity(), (int) r.feedback_empty, 0).show();
        } else if (c(obj2)) {
            a(obj, obj2);
            C0401a.a(getActivity(), C0401a.ee);
        } else {
            b.a(getActivity(), (int) r.feedback_invalid, 0).show();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.fragment_setting_feedback, viewGroup, false);
        this.b = (EditText) inflate.findViewById(com.xiaomi.hm.health.l.feedback_content);
        this.c = (EditText) inflate.findViewById(com.xiaomi.hm.health.l.feedback_email);
        this.d = inflate.findViewById(com.xiaomi.hm.health.l.feedback);
        this.d.setOnClickListener(this);
        this.c.setOnEditorActionListener(new dU(this));
        return inflate;
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.K);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.K);
    }
}
