package cn.com.smartdevices.bracelet.lab.ui;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import cn.com.smartdevices.bracelet.C0401a;
import com.xiaomi.hm.health.R;

class Q implements OnClickListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ Dialog b;
    final /* synthetic */ SportFavoriteVoteGridActivity c;

    Q(SportFavoriteVoteGridActivity sportFavoriteVoteGridActivity, EditText editText, Dialog dialog) {
        this.c = sportFavoriteVoteGridActivity;
        this.a = editText;
        this.b = dialog;
    }

    public void onClick(View view) {
        CharSequence text = this.a.getText();
        if (!TextUtils.isEmpty(text)) {
            C0401a.a(this.c, C0401a.bb, "Others", text.toString());
            this.b.dismiss();
            this.c.a(R.drawable.lab_favorite_vote_others_normal, text.toString());
        }
    }
}
