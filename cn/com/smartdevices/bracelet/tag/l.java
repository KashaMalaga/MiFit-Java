package cn.com.smartdevices.bracelet.tag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.gaocept.b;
import cn.com.smartdevices.bracelet.tag.a.a;
import cn.com.smartdevices.bracelet.tag.a.c;
import com.xiaomi.hm.health.n;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class l extends BaseAdapter {
    final /* synthetic */ TagHistoryActivity a;
    private List<a> b = new ArrayList();

    l(TagHistoryActivity tagHistoryActivity) {
        this.a = tagHistoryActivity;
    }

    public a a(int i) {
        return (a) this.b.get(i);
    }

    public void a(List<a> list) {
        if (list != null && !list.isEmpty()) {
            this.b.addAll(list);
        }
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
        m mVar;
        if (view == null) {
            view = LayoutInflater.from(this.a.getApplication()).inflate(n.view_tag_history_item, null);
            m mVar2 = new m();
            mVar2.a = (TextView) view.findViewById(com.xiaomi.hm.health.l.name);
            mVar2.b = (TextView) view.findViewById(com.xiaomi.hm.health.l.date);
            view.setTag(mVar2);
            mVar = mVar2;
        } else {
            mVar = (m) view.getTag();
        }
        a a = a(i);
        CharSequence format = b.c.format(new Date(a.a));
        for (cn.com.smartdevices.bracelet.tag.a.b bVar : c.b) {
            if (bVar.c.equals(a.b)) {
                mVar.a.setText(bVar.a);
                break;
            }
        }
        mVar.b.setText(format);
        return view;
    }
}
