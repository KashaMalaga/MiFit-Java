package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.activity.WebActivity;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import kankan.wheel.widget.a;

class aI extends BaseAdapter {
    final /* synthetic */ aG a;

    private aI(aG aGVar) {
        this.a = aGVar;
    }

    private void a(aK aKVar) {
        Intent intent = new Intent();
        intent.setClass(this.a.getActivity(), WebActivity.class);
        intent.putExtra(a.d, 2);
        intent.putExtra(a.e, aKVar.d.toString());
        intent.putExtra("Label", aKVar.a);
        this.a.getActivity().startActivity(intent);
    }

    public int getCount() {
        C0596r.e("Dynamic.List", "GetCount : " + this.a.b.size());
        return this.a.b.size();
    }

    public Object getItem(int i) {
        return this.a.b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0596r.e("Dynamic.List", "GetView : " + i);
        if (view == null) {
            view = LayoutInflater.from(this.a.getActivity()).inflate(n.fragment_dynamic_list_item, viewGroup, false);
        }
        aK aKVar = (aK) getItem(i);
        TextView textView = (TextView) view.findViewById(l.summary);
        ((TextView) view.findViewById(l.title)).setText(aKVar.a);
        textView.setText(aKVar.b);
        view.setOnClickListener(new aJ(this, aKVar));
        return view;
    }
}
