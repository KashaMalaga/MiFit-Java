package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.xiaomi.hm.health.n;

public class PersonPageUserInfoView extends FrameLayout {
    private static final String a = "PersonPageUserInfoView";
    private LayoutInflater b;
    private String c;

    public PersonPageUserInfoView(Context context) {
        super(context);
        this.b = LayoutInflater.from(context);
        this.b.inflate(n.person_page_user_info, this);
    }

    public PersonPageUserInfoView(Context context, AttributeSet attributeSet) {
        super(context);
    }

    public PersonPageUserInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
