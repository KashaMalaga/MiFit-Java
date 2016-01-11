package com.huami.android.widget;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.hm.health.a.f;
import com.xiaomi.hm.health.a.g;
import com.xiaomi.hm.health.a.h;

public class a extends e implements OnClickListener, OnItemClickListener {
    public static final String a = "title";
    public static final String b = "message";
    public static final String c = "list";
    public static final String d = "left_label";
    public static final String e = "right_label";
    private c i;
    private b j;
    private TextView k;
    private ListView l;
    private TextView m;
    private TextView n;
    private d o;

    public a() {
        super(g.view_bottom_dialog);
    }

    protected void a(View view) {
        this.k = (TextView) view.findViewById(f.dialog_title);
        this.l = (ListView) view.findViewById(f.menu_list);
        this.m = (TextView) view.findViewById(f.left_button);
        this.n = (TextView) view.findViewById(f.right_button);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(f.message);
        View findViewById = view.findViewById(f.title_divider);
        View findViewById2 = view.findViewById(f.bottom_bar_frame);
        Bundle arguments = getArguments();
        if (arguments != null) {
            CharSequence string = arguments.getString(a);
            if (TextUtils.isEmpty(string)) {
                this.k.setVisibility(8);
                findViewById.setVisibility(8);
            } else {
                this.k.setText(string);
                findViewById.setVisibility(0);
            }
            CharSequence string2 = arguments.getString(b);
            if (TextUtils.isEmpty(string2)) {
                textView.setVisibility(8);
            } else {
                textView.setText(string2);
                textView.setVisibility(0);
            }
            String[] stringArray = arguments.getStringArray(c);
            if (stringArray == null || stringArray.length <= 0) {
                findViewById2.setVisibility(0);
                this.l.setVisibility(8);
                CharSequence string3 = arguments.getString(d);
                if (TextUtils.isEmpty(string3)) {
                    this.m.setText(h.ok);
                } else {
                    this.m.setText(string3);
                }
                string3 = arguments.getString(e);
                if (TextUtils.isEmpty(string3)) {
                    this.n.setText(h.cancel);
                    return;
                } else {
                    this.n.setText(string3);
                    return;
                }
            }
            findViewById2.setVisibility(8);
            this.l.setVisibility(0);
            this.j = new b(getActivity());
            this.j.a(stringArray);
            this.l.setAdapter(this.j);
            this.l.setOnItemClickListener(this);
        }
    }

    public void a(c cVar) {
        this.i = cVar;
    }

    public void a(d dVar) {
        this.o = dVar;
    }

    public void onClick(View view) {
        int i = -1;
        int id = view.getId();
        if (id != f.left_button && id == f.right_button) {
            i = -2;
        }
        if (this.i != null) {
            this.i.a(this, i);
        }
        dismiss();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.o != null) {
            this.o.onItemClick(adapterView, view, i, j);
        }
        dismiss();
    }
}
