package cn.com.smartdevices.bracelet.lab.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class P implements OnClickListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ SportFavoriteVoteGridActivity b;

    P(SportFavoriteVoteGridActivity sportFavoriteVoteGridActivity, Dialog dialog) {
        this.b = sportFavoriteVoteGridActivity;
        this.a = dialog;
    }

    public void onClick(View view) {
        this.a.dismiss();
    }
}
