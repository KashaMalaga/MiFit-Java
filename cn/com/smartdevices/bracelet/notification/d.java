package cn.com.smartdevices.bracelet.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.hm.health.R;
import java.util.List;

public class d extends ArrayAdapter<c> {
    private final LayoutInflater a;

    public d(Context context) {
        super(context, 17367044);
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void a(List<c> list) {
        clear();
        if (list != null) {
            addAll(list);
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.a.inflate(R.layout.view_notifi_apps_list_item, viewGroup, false);
        }
        c cVar = (c) getItem(i);
        ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(cVar.d());
        ((TextView) view.findViewById(R.id.text)).setText(cVar.b());
        ((CheckBox) view.findViewById(R.id.check)).setChecked(cVar.c());
        return view;
    }
}
