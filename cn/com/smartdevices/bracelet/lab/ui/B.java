package cn.com.smartdevices.bracelet.lab.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;

class B implements OnLongClickListener {
    final /* synthetic */ SportAnalyserActivity a;

    B(SportAnalyserActivity sportAnalyserActivity) {
        this.a = sportAnalyserActivity;
    }

    public boolean onLongClick(View view) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        try {
            this.a.startActivityForResult(Intent.createChooser(intent, "Select one music"), 0);
        } catch (ActivityNotFoundException e) {
        }
        return true;
    }
}
