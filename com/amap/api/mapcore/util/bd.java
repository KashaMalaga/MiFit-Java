package com.amap.api.mapcore.util;

import java.util.Date;
import java.util.List;

class bd extends bj {
    private a a;

    class a implements bo {
        final /* synthetic */ bd a;
        private al b;

        a(bd bdVar, al alVar) {
            this.a = bdVar;
            this.b = alVar;
        }

        public void a(String str) {
            try {
                this.b.b(str, this.a.a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    bd() {
    }

    protected int a() {
        return 0;
    }

    protected bo a(al alVar) {
        try {
            if (this.a == null) {
                this.a = new a(this, alVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.a;
    }

    protected String a(String str) {
        return ab.b(str + bk.a(new Date().getTime()));
    }

    protected String a(List<ad> list) {
        return null;
    }

    protected String b() {
        return bg.c;
    }
}
