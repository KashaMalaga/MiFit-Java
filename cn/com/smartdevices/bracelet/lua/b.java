package cn.com.smartdevices.bracelet.lua;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.C0596r;
import com.f.a.b.f.a;
import com.xiaomi.hm.health.R;

class b implements a {
    final /* synthetic */ LuaListAdapter a;

    b(LuaListAdapter luaListAdapter) {
        this.a = luaListAdapter;
    }

    public void a(String str, View view) {
        C0596r.e("LuaListAdapter", "onLoadingStarted");
    }

    public void a(String str, View view, Bitmap bitmap) {
    }

    public void a(String str, View view, com.f.a.b.a.b bVar) {
        C0596r.e("LuaListAdapter", "onLoadingFailed");
        ((ImageView) view).setImageResource(R.drawable.game_banner_icon);
    }

    public void b(String str, View view) {
    }
}
