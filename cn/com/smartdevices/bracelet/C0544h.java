package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.f.a.a.a.b.c;
import com.f.a.a.b.a.f;
import com.f.a.b.a.h;
import com.f.a.b.d;
import com.f.a.b.f.a;
import com.f.a.b.g;
import com.f.a.b.j;
import com.f.a.b.l;
import java.io.File;
import java.util.List;

public class C0544h {
    private static C0544h a;
    private d b;
    private g c;

    private C0544h(Context context) {
        b(context);
    }

    public static C0544h a() {
        return a;
    }

    public static void a(Context context) {
        a = new C0544h(context);
    }

    private void b(Context context) {
        j c = new l(context).b(5).a().b(new c()).a(h.LIFO).a(new f(4194304)).c(4194304).b(new com.f.a.a.a.a.c(new File(Utils.j(context)))).f(52428800).h((int) com.xiaomi.account.openauth.h.E).b().c();
        this.c = g.a();
        this.c.a(c);
        this.b = new com.f.a.b.f().b(true).d(true).d();
    }

    public Bitmap a(String str) {
        return this.c.a(str);
    }

    public Bitmap a(String str, com.f.a.b.a.f fVar) {
        return this.c.a(str, fVar);
    }

    public void a(String str, ImageView imageView) {
        this.c.a(str, imageView, this.b);
    }

    public void a(String str, ImageView imageView, a aVar) {
        this.c.a(str, imageView, this.b, aVar);
    }

    public void a(String str, com.f.a.b.a.f fVar, a aVar) {
        this.c.a(str, fVar, aVar);
    }

    public void a(String str, a aVar) {
        this.c.a(str, new com.f.a.b.f().b(false).d(true).d(), aVar);
    }

    public Bitmap b(String str, com.f.a.b.a.f fVar) {
        return this.c.a(str, fVar, new com.f.a.b.f().b(true).d(true).d());
    }

    public List<Bitmap> b(String str) {
        return com.f.a.c.g.a(str, this.c.c());
    }

    public void b(String str, ImageView imageView) {
        this.c.a(str, imageView, new com.f.a.b.f().b(true).d(true).a(new C0561i(this)).d());
    }

    public void b(String str, ImageView imageView, a aVar) {
        this.c.a(str, imageView, new com.f.a.b.f().b(true).d(true).a(new C0561i(this)).d(), aVar);
    }

    public void b(String str, a aVar) {
        this.c.a(str, aVar);
    }

    public File c(String str) {
        return com.f.a.c.a.a(str, this.c.f());
    }

    public void d(String str) {
        com.f.a.c.g.c(str, this.c.c());
        com.f.a.c.a.b(str, this.c.f());
    }
}
