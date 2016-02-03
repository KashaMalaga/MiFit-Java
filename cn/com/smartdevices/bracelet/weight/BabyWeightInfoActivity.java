package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.ui.WeightTableView;
import com.xiaomi.hm.health.R;

public class BabyWeightInfoActivity extends SystemBarTintActivity {
    int a = 1;
    int b = 0;
    private ImageButton c;
    private Context d = this;
    private WeightTableView e;
    private TextView f;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_baby_weight_info);
        this.c = (ImageButton) findViewById(R.id.go2_txt_detail_btn);
        this.c.setOnClickListener(new C0872j(this));
        this.e = (WeightTableView) findViewById(R.id.weight_table_view);
        this.f = (TextView) findViewById(R.id.baby_weight_info_titl);
        if (getIntent() != null) {
            this.a = getIntent().getIntExtra("GENDER", 1);
            this.b = getIntent().getIntExtra("UNIT", 0);
        }
        if (this.a == 1) {
            this.f.setText(getString(R.string.baby_boy_weight_model_new, new Object[]{aA.a(this.d, this.b)}));
            this.e.a(C0873k.a().a(this.b, this.a));
            return;
        }
        this.f.setText(getString(R.string.baby_girl_weight_model_new, new Object[]{aA.a(this.d, this.b)}));
        this.e.a(C0873k.a().a(this.b, this.a));
    }
}
