package cn.com.smartdevices.bracelet.ui;

import android.app.ListFragment;
import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.shoes.ui.ShoesBindActivity;
import cn.com.smartdevices.bracelet.shoes.ui.ShoesDetailActivity;
import cn.com.smartdevices.bracelet.shoes.ui.ShoesIntroActivity;
import com.huami.android.zxing.CaptureActivity;
import java.io.Serializable;
import kankan.wheel.widget.a.b;

public class DeviceListFragment extends ListFragment {
    public static final String a = "DeviceListFragment";
    public static final int b = 1;
    public static final int c = 2;
    private static final int d = 0;
    private static final int e = 1;
    private int f = e;
    private X g;
    private e h;
    private Context i;

    private void a() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            if (defaultAdapter.isEnabled()) {
                b();
            } else {
                startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), d);
            }
        }
    }

    private void b() {
        startActivity(ShoesBindActivity.a(this.i, this.h));
    }

    public void a(int i) {
        this.f = i;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getListView().setDivider(null);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 0) {
            if (i == e) {
                switch (i2) {
                    case b.a /*-1*/:
                        b();
                        break;
                    case d /*0*/:
                        getActivity().finish();
                        break;
                    default:
                        break;
                }
            }
        }
        switch (i2) {
            case b.a /*-1*/:
                b();
                break;
            case d /*0*/:
                try {
                    startActivityForResult(new Intent("cn.com.smartdevices.bracelet.intent.action.ENABLE_BLUETOOTH"), e);
                    break;
                } catch (ActivityNotFoundException e) {
                    C0596r.e(a, "EnableBluetoothActivity not found, may be the module is running alone");
                    break;
                }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = getActivity().getApplicationContext();
        this.g = new X(this.i);
        setListAdapter(this.g);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        Z z = (Z) getListView().getItemAtPosition(i);
        if (z.a == C0671aa.BRACELET || z.a == C0671aa.WEIGHT) {
            Intent intent = new Intent(this.i, SettingContainerActivity.class);
            intent.putExtra(SettingContainerActivity.a, z.a.ordinal());
            startActivity(intent);
        } else if (z.a == C0671aa.SHOES) {
            Serializable serializable = z.e;
            Intent intent2 = z.d ? new Intent(this.i, ShoesDetailActivity.class) : new Intent(this.i, ShoesIntroActivity.class);
            intent2.putExtra(CaptureActivity.l, serializable);
            startActivity(intent2);
        }
    }

    public void onResume() {
        super.onResume();
        this.g.a();
        this.g.notifyDataSetChanged();
    }
}
