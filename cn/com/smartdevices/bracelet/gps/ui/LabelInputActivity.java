package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ListView;
import com.xiaomi.hm.health.b.a.b;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import java.util.ArrayList;
import java.util.List;

public class LabelInputActivity extends Activity implements OnClickListener {
    private ListView a = null;
    private C0509av b = null;
    private Resources c = null;
    private EditText d = null;
    private Animation e = null;

    private List<String> a() {
        return new ArrayList(0);
    }

    public void onClick(View view) {
        if (view.getId() == i.confirm) {
            Editable text = this.d.getText();
            Object trim = text.toString().trim();
            if (TextUtils.isEmpty(trim)) {
                this.d.startAnimation(this.e);
                this.d.setSelection(0, text.length());
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("text_input", trim);
            setResult(-1, intent);
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(j.fragment_running_label_input);
        this.c = getResources();
        this.e = AnimationUtils.loadAnimation(this, b.edit_shake);
        this.d = (EditText) findViewById(i.label_input);
        this.d.addTextChangedListener(new C0508au(this, 20, this.d));
        findViewById(i.confirm).setOnClickListener(this);
        this.a = (ListView) findViewById(i.hot_list);
        if (this.a != null && this.a.getVisibility() == 0) {
            this.b = new C0509av(this, this, a());
            this.a.setAdapter(this.b);
            this.a.setOnItemClickListener(new C0506as(this));
        }
    }
}
