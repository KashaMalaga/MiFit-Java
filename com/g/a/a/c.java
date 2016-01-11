package com.g.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import b.a.C0364dI;
import b.a.C0366dK;

public class c {
    public String a;
    public String b;
    private Context c;
    private final String d = "um_g_cache";
    private final String e = "single_level";
    private final String f = "stat_player_level";
    private final String g = "stat_game_level";
    private d h = null;

    public c(Context context) {
        this.c = context;
    }

    public d a(String str) {
        this.h = new d(str);
        this.h.a();
        return this.h;
    }

    public void a() {
        if (this.h != null) {
            this.h.b();
            Editor edit = this.c.getSharedPreferences("um_g_cache", 0).edit();
            edit.putString("single_level", C0364dI.a(this.h));
            edit.putString("stat_player_level", this.b);
            edit.putString("stat_game_level", this.a);
            edit.commit();
        }
    }

    public d b(String str) {
        if (this.h != null) {
            this.h.d();
            if (this.h.a(str)) {
                d dVar = this.h;
                this.h = null;
                return dVar;
            }
        }
        return null;
    }

    public void b() {
        SharedPreferences a = C0366dK.a(this.c, "um_g_cache");
        String string = a.getString("single_level", null);
        if (string != null) {
            this.h = (d) C0364dI.a(string);
            if (this.h != null) {
                this.h.c();
            }
        }
        if (this.b == null) {
            this.b = a.getString("stat_player_level", null);
        }
        if (this.a == null) {
            this.a = a.getString("stat_game_level", null);
        }
    }
}
