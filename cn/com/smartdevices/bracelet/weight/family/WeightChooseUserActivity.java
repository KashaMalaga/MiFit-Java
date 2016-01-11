package cn.com.smartdevices.bracelet.weight.family;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import cn.com.smartdevices.bracelet.weight.Q;
import kankan.wheel.widget.a;

public class WeightChooseUserActivity extends Activity {
    private Q a;
    private boolean b = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Intent intent = getIntent();
        Bundle bundle2 = null;
        if (intent != null) {
            bundle2 = intent.getExtras();
        }
        this.a = (Q) Fragment.instantiate(this, Q.class.getName(), bundle2);
        this.b = true;
        this.a.a(new l(this));
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(16908290, this.a);
        beginTransaction.commit();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.b && keyEvent.getAction() == 0) {
            switch (i) {
                case a.aQ /*4*/:
                    this.a.onCancel(null);
                    return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
