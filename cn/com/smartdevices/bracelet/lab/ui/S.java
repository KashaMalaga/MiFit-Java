package cn.com.smartdevices.bracelet.lab.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.hm.health.R;
import java.util.ArrayList;
import java.util.List;

final class S extends BaseAdapter {
    final /* synthetic */ SportFavoriteVoteGridActivity a;
    private List<Bundle> b;
    private LayoutInflater c;

    public S(SportFavoriteVoteGridActivity sportFavoriteVoteGridActivity, Context context, List<Bundle> list) {
        this.a = sportFavoriteVoteGridActivity;
        this.b = null;
        this.c = null;
        this.b = new ArrayList();
        this.b.addAll(list);
        this.c = LayoutInflater.from(context);
    }

    public Bundle a(int i) {
        return (Bundle) this.b.get(i);
    }

    public void a() {
        if (this.b != null) {
            this.b.clear();
        }
    }

    public void a(int i, boolean z) {
        ((Bundle) this.b.get(i)).putBoolean(C0568d.a, z);
    }

    public boolean b(int i) {
        return ((Bundle) this.b.get(i)).getBoolean(C0568d.e);
    }

    public int getCount() {
        return this.b.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        R r;
        int i2;
        if (view == null) {
            r = new R(this.a);
            view = this.c.inflate(R.layout.activity_lab_factory_more_sport_favorite_item, null);
            r.b = (ImageView) view.findViewById(R.id.sport_item_img);
            r.a = (TextView) view.findViewById(R.id.sport_name);
            r.c = (ImageView) view.findViewById(R.id.sport_done_flag);
            view.setTag(r);
        } else {
            r = (R) view.getTag();
        }
        Bundle bundle = (Bundle) this.b.get(i);
        r.a.setText(bundle.getInt(C0568d.b));
        int i3 = bundle.getInt(C0568d.h);
        if (bundle.getBoolean(C0568d.a)) {
            i2 = bundle.getInt(C0568d.d);
            r.c.setVisibility(0);
        } else {
            i2 = bundle.getInt(C0568d.c);
            r.c.setVisibility(8);
        }
        if (i2 <= 0) {
            r.b.setVisibility(8);
        } else {
            r.b.setVisibility(0);
            r.b.setImageResource(i2);
            r.a.setTextColor(this.a.getResources().getColor(i3));
        }
        return view;
    }
}
