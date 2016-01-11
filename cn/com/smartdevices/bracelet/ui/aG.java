package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.chart.util.t;
import com.xiaomi.hm.health.n;
import java.util.ArrayList;

public class aG extends Fragment {
    private static final String a = "Dynamic.List";
    private ArrayList<aK> b;
    private ListView c;
    private aI d;

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.b = new ArrayList();
        aK aKVar = new aK();
        aKVar.a = "\u6b22\u8fce\u4f7f\u7528\u5c0f\u7c73\u624b\u73af";
        aKVar.b = "\u70b9\u51fb\u67e5\u770b\u5982\u4f55\u73a9\u8f6c\u5c0f\u7c73\u624b\u73af";
        aKVar.d = Uri.parse("file:///android_asset/help.html");
        this.b.add(aKVar);
        aKVar = new aK();
        aKVar.a = "\u6234\u4e0a\u5c0f\u7c73\u624b\u73af\u51fa\u53bb\u8d70\u4e00\u8d70\u5427\uff01";
        aKVar.b = "\u8ba9\u5c0f\u7c73\u624b\u73af\u5b9e\u65f6\u8bb0\u5f55\u4f60\u7684\u8fd0\u52a8\u4fe1\u606f\uff0c\u505a\u4f60\u7684\u5065\u5eb7\u52a9\u624b";
        this.b.add(aKVar);
        this.d = new aI();
        this.c.setAdapter(this.d);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.fragment_dynamic_list, viewGroup, false);
        this.c = (ListView) inflate;
        View view = new View(getActivity());
        view.setLayoutParams(new LayoutParams(-1, (int) (390.0f * t.a(getActivity()))));
        view.setTag("MarginView");
        this.c.addHeaderView(view, null, false);
        return inflate;
    }
}
