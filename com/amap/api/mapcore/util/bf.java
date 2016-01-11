package com.amap.api.mapcore.util;

import java.util.List;

class bf extends bj {
    private a a;

    class a implements bo {
        final /* synthetic */ bf a;
        private al b;

        a(bf bfVar, al alVar) {
            this.a = bfVar;
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

    bf() {
    }

    protected int a() {
        return 1;
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
        return ab.b(str);
    }

    protected String a(List<ad> list) {
        return null;
    }

    protected String b() {
        return bg.b;
    }
}
