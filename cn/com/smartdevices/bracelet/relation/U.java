package cn.com.smartdevices.bracelet.relation;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0544h;
import cn.com.smartdevices.bracelet.relation.db.f;
import cn.com.smartdevices.bracelet.relation.view.CareButton;
import com.f.a.b.a.b;
import com.f.a.b.f.a;
import com.xiaomi.hm.health.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kankan.wheel.widget.l;

class U extends BaseAdapter implements a {
    final /* synthetic */ MessageActivity a;
    private List<f> b = new ArrayList();

    public U(MessageActivity messageActivity) {
        this.a = messageActivity;
    }

    public f a(int i) {
        return (f) this.b.get(i);
    }

    public f a(long j, int i) {
        for (f fVar : this.b) {
            if (fVar.q == j && fVar.t == i) {
                return fVar;
            }
        }
        return null;
    }

    public List<f> a() {
        return this.b;
    }

    public void a(long j) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((f) it.next()).q == j) {
                it.remove();
            }
        }
        notifyDataSetInvalidated();
    }

    public void a(f fVar) {
        if (fVar != null) {
            f a = a(fVar.q, fVar.t);
            if (a == null) {
                this.b.add(0, fVar);
                return;
            }
            a.v = fVar.v;
            a.s = fVar.s;
            a.u = fVar.u;
            a.t = fVar.t;
            a.q = fVar.q;
            a.r = fVar.r;
        }
    }

    public void a(String str, View view) {
        ((ImageView) view).setBackgroundResource(R.drawable.default_friend_avatar);
    }

    public void a(String str, View view, Bitmap bitmap) {
        if (bitmap == null) {
            ((ImageView) view).setBackgroundResource(R.drawable.default_friend_avatar);
        }
    }

    public void a(String str, View view, b bVar) {
        ((ImageView) view).setBackgroundResource(R.drawable.default_friend_avatar);
    }

    public void a(List<f> list) {
        if (list != null) {
            this.b.addAll(list);
        }
    }

    public void b() {
        this.b.clear();
    }

    public void b(String str, View view) {
        ((ImageView) view).setBackgroundResource(R.drawable.default_friend_avatar);
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

    public int getItemViewType(int i) {
        switch (a(i).t) {
            case l.a /*1*/:
                return 1;
            case kankan.wheel.widget.a.k /*2*/:
            case kankan.wheel.widget.a.l /*3*/:
                return 2;
            default:
                return 0;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        f a = a(i);
        switch (itemViewType) {
            case kankan.wheel.widget.a.i /*0*/:
                T t;
                if (view == null) {
                    view = View.inflate(this.a, R.layout.view_message_care_item, null);
                    T t2 = new T();
                    t2.e = (ImageView) view.findViewById(R.id.icon);
                    t2.a = (TextView) view.findViewById(R.id.username);
                    t2.b = (TextView) view.findViewById(R.id.notice);
                    t2.c = (TextView) view.findViewById(R.id.notice_time);
                    t2.d = (CareButton) view.findViewById(R.id.care_button);
                    t2.d.setOnClickListener(this.a);
                    t2.d.a(this.a);
                    t2.d.a(false);
                    view.setTag(t2);
                    t = t2;
                } else {
                    t = (T) view.getTag();
                }
                C0544h.a().b(a.w, t.e, this);
                t.a.setText(a.r);
                t.b.setText(this.a.getString(R.string.label_care_time_by_other, new Object[]{Integer.valueOf(a.u)}));
                t.c.setText(MessageActivity.j.format(new Date(a.s)));
                t.d.setTag(a);
                break;
            case l.a /*1*/:
                S s;
                if (view == null) {
                    view = View.inflate(this.a, R.layout.view_message_add_item, null);
                    S s2 = new S();
                    s2.h = (ImageView) view.findViewById(R.id.icon);
                    s2.a = (TextView) view.findViewById(R.id.username);
                    s2.b = (TextView) view.findViewById(R.id.notice);
                    s2.c = (TextView) view.findViewById(R.id.notice_time);
                    s2.d = (Button) view.findViewById(R.id.ok_button);
                    s2.e = (Button) view.findViewById(R.id.refuse_button);
                    s2.f = view.findViewById(R.id.action_panel);
                    s2.g = (TextView) view.findViewById(R.id.agree_flag);
                    view.setTag(s2);
                    s = s2;
                } else {
                    s = (S) view.getTag();
                }
                s.a.setText(a.r);
                s.c.setText(MessageActivity.j.format(new Date(a.s)));
                s.b.setText(R.string.label_request_add_friend);
                C0544h.a().b(a.w, s.h, this);
                if (a.v != 0) {
                    if (a.v != 3) {
                        if (a.v == 2) {
                            s.g.setText(R.string.label_refused);
                            s.g.setVisibility(0);
                            s.f.setVisibility(8);
                            break;
                        }
                    }
                    s.g.setText(R.string.label_accepted);
                    s.g.setVisibility(0);
                    s.f.setVisibility(8);
                    break;
                }
                s.f.setVisibility(0);
                s.g.setVisibility(8);
                s.d.setTag(a);
                s.e.setTag(a);
                s.d.setOnClickListener(this.a);
                s.e.setOnClickListener(this.a);
                break;
                break;
            case kankan.wheel.widget.a.k /*2*/:
                W w;
                if (view == null) {
                    view = View.inflate(this.a, R.layout.view_message_refuse_item, null);
                    W w2 = new W();
                    w2.a = (ImageView) view.findViewById(R.id.icon);
                    w2.c = (TextView) view.findViewById(R.id.username);
                    w2.b = (TextView) view.findViewById(R.id.notice_time);
                    w2.d = (TextView) view.findViewById(R.id.notice);
                    view.setTag(w2);
                    w = w2;
                } else {
                    w = (W) view.getTag();
                }
                C0544h.a().b(a.w, w.a, this);
                if (a.t == 3) {
                    w.d.setText(R.string.label_accept_add_friend_by_him);
                } else {
                    w.d.setText(R.string.label_refuse_add_friend_by_him);
                }
                w.c.setText(a.r);
                w.b.setText(MessageActivity.j.format(new Date(a.s)));
                break;
        }
        return view;
    }

    public int getViewTypeCount() {
        return 3;
    }
}
