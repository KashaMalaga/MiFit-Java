package com.huami.android.widget;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.hm.health.a.g;

public class f extends e {
    public static final String a = "message";
    public static final String b = "cancel";
    private static final String c = "progress";
    private String d = null;
    private boolean e = true;

    public f() {
        super(g.view_progress_dialog);
    }

    public static f a(FragmentManager fragmentManager) {
        return a(fragmentManager, null, true);
    }

    public static f a(FragmentManager fragmentManager, String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(b, z);
        bundle.putString(a, str);
        f fVar = new f();
        fVar.setArguments(bundle);
        fVar.show(fragmentManager, c);
        return fVar;
    }

    public static f a(FragmentManager fragmentManager, boolean z) {
        return a(fragmentManager, null, z);
    }

    protected void a(View view) {
        view.setPadding(20, 20, 20, 20);
        TextView textView = (TextView) view.findViewById(com.xiaomi.hm.health.a.f.progress_txt);
        if (!TextUtils.isEmpty(this.d)) {
            textView.setText(this.d);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.d = arguments.getString(a);
            this.e = arguments.getBoolean(b);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            onCreateDialog.setCancelable(this.e);
        }
        return onCreateDialog;
    }
}
