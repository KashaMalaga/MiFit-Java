package cn.com.smartdevices.bracelet.tag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.tag.a.b;
import com.xiaomi.hm.health.R;
import java.util.ArrayList;
import java.util.List;

class o extends BaseAdapter {
    final /* synthetic */ n a;
    private final List<b> b = new ArrayList();
    private final Context c;

    public o(n nVar, Context context, b[] bVarArr) {
        this.a = nVar;
        this.c = context;
        if (this.b != null) {
            for (Object add : bVarArr) {
                this.b.add(add);
            }
        }
    }

    public b a(int i) {
        return (b) this.b.get(i);
    }

    public int getCount() {
        return this.b.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        p pVar;
        if (view == null) {
            view = LayoutInflater.from(this.c).inflate(R.layout.view_action_tag_menu_item, null);
            p pVar2 = new p();
            pVar2.b = (ImageView) view.findViewById(R.id.icon);
            pVar2.a = (TextView) view.findViewById(R.id.name);
            view.setTag(pVar2);
            pVar = pVar2;
        } else {
            pVar = (p) view.getTag();
        }
        b a = a(i);
        int a2 = this.a.b.a(a.c);
        CharSequence string = this.c.getString(a.a);
        if (a2 > 0) {
            string = string + " x " + a2;
        }
        pVar.a.setText(string);
        pVar.b.setImageResource(a.b);
        return view;
    }
}
