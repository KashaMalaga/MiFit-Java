package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.model.BtDevice;
import java.util.ArrayList;

class R extends BaseAdapter {
    private ArrayList<BtDevice> a;
    private Context b;

    public R(Context context, ArrayList<BtDevice> arrayList) {
        this.b = context;
        this.a = arrayList;
    }

    public int getCount() {
        return this.a == null ? 0 : this.a.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.b).inflate(com.xiaomi.hm.health.R.layout.search_device_item, null);
        BtDevice btDevice = (BtDevice) this.a.get(i);
        TextView textView = (TextView) inflate.findViewById(com.xiaomi.hm.health.R.id.searched_device_item_mac_tv);
        TextView textView2 = (TextView) inflate.findViewById(com.xiaomi.hm.health.R.id.searched_device_item_signal_tv);
        ((LayoutParams) inflate.findViewById(com.xiaomi.hm.health.R.id.searched_device_item_signal_bar).getLayoutParams()).rightMargin = (-btDevice.signal) * 5;
        inflate.invalidate();
        String address = btDevice.device.getAddress();
        textView.setText(address.substring(address.length() - "MM:AA:CC".length(), address.length()));
        textView2.setText(this.b.getString(com.xiaomi.hm.health.R.string.signal_strength) + btDevice.signal);
        return inflate;
    }
}
