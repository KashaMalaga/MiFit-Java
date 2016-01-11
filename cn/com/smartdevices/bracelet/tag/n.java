package cn.com.smartdevices.bracelet.tag;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.tag.a.c;
import com.huami.android.view.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.profile.a.j;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.r;
import java.util.List;

public class n extends Fragment implements OnItemClickListener {
    private o a;
    private c b;
    private j c;
    private boolean d = false;

    public static n a() {
        n nVar = new n();
        nVar.setArguments(new Bundle());
        return nVar;
    }

    private void b() {
        List<e> d = t.d(getActivity());
        if (d != null) {
            for (e k : d) {
                if (k.k()) {
                    this.d = true;
                }
            }
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = new c(activity, a.f);
        this.a = new o(this, activity, c.b);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0401a.a(getActivity(), C0401a.bR);
        this.c = com.xiaomi.hm.health.bt.bleservice.a.a();
        b();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.xiaomi.hm.health.n.fragment_mark_menu, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(l.action_list);
        gridView.setAdapter(this.a);
        gridView.setOnItemClickListener(this);
        return inflate;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.c != null || this.d) {
            startActivity(TagDataActivity.a(getActivity(), this.a.a(i)));
            return;
        }
        b.a(getActivity(), (int) r.unbind_mili, 0).show();
    }

    public void onPause() {
        super.onPause();
        C0401a.b(getActivity());
        C0401a.b(C0401a.ah);
    }

    public void onResume() {
        super.onResume();
        this.a.notifyDataSetChanged();
        C0401a.a(getActivity());
        C0401a.a(C0401a.ah);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        this.c = com.xiaomi.hm.health.bt.bleservice.a.a();
    }
}
