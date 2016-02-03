package cn.com.smartdevices.bracelet.heartrate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import com.xiaomi.hm.health.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class h extends BaseAdapter {
    private static final String a = "HeartRateListAdapter";
    private SimpleDateFormat b;
    private Context c = null;
    private List<HeartRateItem> d = null;

    public h(Context context, List<HeartRateItem> list) {
        this.c = context;
        this.d = list;
        this.b = new SimpleDateFormat(this.c.getString(R.string.hr_item_date));
    }

    private String a(int i) {
        return i == 0 ? this.c.getString(R.string.hr_slow) : i == 1 ? this.c.getString(R.string.hr_normal) : i == 2 ? this.c.getString(R.string.hr_sports) : this.c.getString(R.string.hr_fast);
    }

    private String a(long j) {
        return this.b.format(new Date(1000 * j));
    }

    private String b(int i) {
        return i < 60 ? this.c.getString(R.string.hr_slow) : (i < 60 || i > 100) ? this.c.getString(R.string.hr_fast) : this.c.getString(R.string.hr_normal);
    }

    private int c(int i) {
        return i < 60 ? 0 : (i < 60 || i > 100) ? 3 : 1;
    }

    public void a(List<HeartRateItem> list) {
        if (list != null) {
            this.d = list;
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.d == null ? 0 : this.d.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        j jVar;
        if (view == null) {
            jVar = new j(this);
            view = LayoutInflater.from(this.c).inflate(R.layout.hr_list_item, null);
            jVar.a = (TextView) view.findViewById(R.id.date);
            jVar.b = (TextView) view.findViewById(R.id.hr);
            jVar.c = (TextView) view.findViewById(R.id.hr_level);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        view.setOnClickListener(new i(this));
        HeartRateItem heartRateItem = (HeartRateItem) this.d.get(i);
        jVar.a.setText(a(heartRateItem.time));
        jVar.b.setText(String.valueOf(heartRateItem.hr));
        jVar.c.setText(b(heartRateItem.hr));
        jVar.a.setTag(heartRateItem);
        return view;
    }
}
