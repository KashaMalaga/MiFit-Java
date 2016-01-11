package cn.com.smartdevices.bracelet.gps.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ListView;
import com.huami.android.view.c;
import com.huami.android.view.e;
import com.xiaomi.hm.health.b.a.b;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import java.util.ArrayList;
import java.util.List;

public class C0510aw extends c implements OnClickListener {
    private ListView a = null;
    private aA b = null;
    private Resources c = null;
    private EditText d = null;
    private Animation e = null;

    @SuppressLint({"NewApi"})
    public static void a(Activity activity, Class<? extends DialogFragment> cls, Bundle bundle, e eVar) {
        FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
        C0510aw c0510aw = (C0510aw) Fragment.instantiate(activity, cls.getName(), bundle);
        c0510aw.setOpClickListener(eVar);
        c0510aw.show(beginTransaction, cls.getName());
    }

    private List<String> b() {
        return new ArrayList(0);
    }

    public String a() {
        return this.d.getText().toString();
    }

    protected int inflateLayout() {
        return j.fragment_running_label_input;
    }

    @SuppressLint({"NewApi"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.c = getResources();
        this.e = AnimationUtils.loadAnimation(getActivity(), b.edit_shake);
        this.d = (EditText) onCreateView.findViewById(i.label_input);
        this.d.addTextChangedListener(new C0513az(this, 20, this.d));
        this.a = (ListView) onCreateView.findViewById(i.hot_list);
        if (this.a != null && this.a.getVisibility() == 0) {
            this.b = new aA(this, getActivity(), b());
            this.a.setAdapter(this.b);
            this.a.setOnItemClickListener(new C0511ax(this));
        }
        return onCreateView;
    }

    @SuppressLint({"NewApi"})
    protected void onRightButtonClicked() {
        Editable text = this.d.getText();
        if (TextUtils.isEmpty(text.toString().trim())) {
            this.d.startAnimation(this.e);
            this.d.setSelection(0, text.length());
            return;
        }
        super.onRightButtonClicked();
        dismiss();
    }
}
