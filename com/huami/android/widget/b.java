package com.huami.android.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.xiaomi.hm.health.a.f;
import com.xiaomi.hm.health.a.g;
import java.util.ArrayList;
import java.util.List;

class b extends BaseAdapter {
    private List<String> a = new ArrayList();
    private Context b;

    public b(Context context) {
        this.b = context;
    }

    public String a(int i) {
        return (String) this.a.get(i);
    }

    public void a(String[] strArr) {
        if (strArr != null) {
            for (Object add : strArr) {
                this.a.add(add);
            }
        }
    }

    public int getCount() {
        return this.a.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(g.view_dialog_menu_item, null);
            textView = (TextView) view.findViewById(f.label);
            view.setTag(textView);
        } else {
            textView = (TextView) view.getTag();
        }
        textView.setText(a(i));
        return view;
    }
}
