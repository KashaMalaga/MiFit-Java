package cn.com.smartdevices.bracelet.view;

import android.support.v7.widget.aj;
import android.view.View;
import com.xiaomi.hm.health.R;

public class ae extends aj {
    protected WeightUserAvatar r;

    public ae(View view) {
        super(view);
        this.r = (WeightUserAvatar) view.findViewById(R.id.user_avatar);
    }
}
