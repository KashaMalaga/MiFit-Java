package com.huami.android.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.hm.health.a.g;

public class b extends Toast {
    public b(Context context) {
        super(context);
    }

    public static Toast a(Context context, int i, int i2) {
        return context == null ? null : a(context, i, i2, 3);
    }

    public static Toast a(Context context, int i, int i2, int i3) {
        return context == null ? null : a(context, context.getResources().getString(i), i2, i3);
    }

    public static Toast a(Context context, String str, int i) {
        return a(context, str, i, 3);
    }

    public static Toast a(Context context, String str, int i, int i2) {
        if (context == null) {
            return null;
        }
        Toast bVar = new b(context);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(g.custom_toast, null);
        TextView textView = (TextView) viewGroup.getChildAt(0);
        textView.setText(str);
        textView.setGravity(i2);
        bVar.setView(viewGroup);
        bVar.setDuration(i);
        return bVar;
    }
}
