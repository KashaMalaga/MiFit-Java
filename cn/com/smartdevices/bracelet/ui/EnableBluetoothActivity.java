package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaomi.hm.health.R;

public class EnableBluetoothActivity extends Activity implements OnClickListener {
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_enable_bluetooth) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null || !defaultAdapter.enable()) {
                setResult(0);
            } else {
                setResult(-1);
            }
            finish();
        } else if (id == R.id.skip) {
            setResult(0);
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_enable_bluetooth);
        findViewById(R.id.btn_enable_bluetooth).setOnClickListener(this);
        findViewById(R.id.skip).setOnClickListener(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        setResult(0);
        finish();
        return true;
    }
}
