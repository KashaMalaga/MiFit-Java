package cn.com.smartdevices.bracelet.partner;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import java.util.ArrayList;
import java.util.List;

final class PartnerListAdapter extends BaseExpandableListAdapter {
    private LayoutInflater mInflater = null;
    private SparseArray<ArrayList<Partner>> mPartners;

    class Holder {
        View divider;
        TextView labelText;

        Holder() {
        }
    }

    public PartnerListAdapter(Context context, SparseArray<ArrayList<Partner>> sparseArray) {
        if (sparseArray != null) {
            this.mPartners = sparseArray;
        } else {
            this.mPartners = new SparseArray();
        }
        this.mInflater = LayoutInflater.from(context);
    }

    public void addPartners(int i, List<Partner> list) {
        if (list != null && list.size() >= 0) {
            ArrayList arrayList;
            ArrayList arrayList2 = (ArrayList) this.mPartners.get(i);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                this.mPartners.put(i, arrayList2);
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
            }
            for (Partner partner : list) {
                if (!arrayList.contains(partner)) {
                    arrayList.add(partner);
                }
            }
        }
    }

    public Partner getChild(int i, int i2) {
        List list = (List) this.mPartners.get(this.mPartners.keyAt(i));
        return list == null ? null : (Partner) list.get(i2);
    }

    public long getChildId(int i, int i2) {
        return 0;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            view = this.mInflater.inflate(n.activity_service_list_item, null);
            Holder holder2 = new Holder();
            holder2.labelText = (TextView) view.findViewById(l.service_name);
            holder2.divider = view.findViewById(l.divider);
            view.setTag(holder2);
            holder = holder2;
        } else {
            holder = (Holder) view.getTag();
        }
        Partner child = getChild(i, i2);
        if (child != null) {
            holder.labelText.setText(child.title);
        }
        if (z) {
            holder.divider.setVisibility(8);
        } else {
            holder.divider.setVisibility(0);
        }
        return view;
    }

    public int getChildrenCount(int i) {
        List list = (List) this.mPartners.get(this.mPartners.keyAt(i));
        return list == null ? 0 : list.size();
    }

    public Integer getGroup(int i) {
        return Integer.valueOf(this.mPartners.keyAt(i));
    }

    public int getGroupCount() {
        return this.mPartners == null ? 0 : this.mPartners.size();
    }

    public long getGroupId(int i) {
        return 0;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        return view == null ? this.mInflater.inflate(n.activity_service_list_item_category, null) : view;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public void updatePartnerItem(int i, String str, int i2, String str2) {
        List<Partner> list = (List) this.mPartners.get(i);
        if (list != null) {
            for (Partner partner : list) {
                if (partner.id.equals(str)) {
                    partner.authorizeStatus = i2;
                    partner.url = str2;
                }
            }
        }
    }
}
