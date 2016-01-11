package cn.com.smartdevices.bracelet.lab.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.smartdevices.bracelet.C0401a;

class O implements OnItemClickListener {
    final /* synthetic */ SportFavoriteVoteGridActivity a;

    O(SportFavoriteVoteGridActivity sportFavoriteVoteGridActivity) {
        this.a = sportFavoriteVoteGridActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.a.b != null && this.a.a != null) {
            Intent intent;
            if (this.a.a.b(i)) {
                intent = new Intent();
                intent.setClass(this.a.getApplicationContext(), SportVoteOthersActivity.class);
                this.a.startActivityForResult(intent, 100);
                return;
            }
            Bundle a = this.a.a.a(i);
            boolean z = a.getBoolean(C0568d.a);
            if (z) {
                Object string = a.getString(C0568d.g);
                if (!TextUtils.isEmpty(string)) {
                    intent = new Intent();
                    intent.setClassName(this.a.getApplicationContext(), string);
                    this.a.startActivity(intent);
                    return;
                }
            }
            z = !z;
            this.a.a.a(i, z);
            if (z) {
                C0401a.a(this.a, C0401a.bb, a.getString(C0568d.f));
                this.a.a(a.getInt(C0568d.c), this.a.getResources().getString(a.getInt(C0568d.b)));
            }
        }
    }
}
