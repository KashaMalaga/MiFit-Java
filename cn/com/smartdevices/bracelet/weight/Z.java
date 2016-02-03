package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.view.WeightUserAvatar;
import com.xiaomi.hm.health.R;

class Z extends LinearLayout {
    final /* synthetic */ Q a;
    private TextView b;
    private WeightUserAvatar c;

    public Z(Q q, Context context) {
        this(q, context, null);
    }

    public Z(Q q, Context context, AttributeSet attributeSet) {
        this.a = q;
        super(context, attributeSet);
        LayoutInflater.from(q.g).inflate(R.layout.userlist_item, this, true);
        this.b = (TextView) findViewById(R.id.user_list_item_name);
        this.b.setText(q.getString(R.string.new_user));
        this.c = (WeightUserAvatar) findViewById(R.id.user_icon);
        this.c.setBackground(getResources().getDrawable(R.drawable.btn_statistic_mode_zoom_out));
    }
}
