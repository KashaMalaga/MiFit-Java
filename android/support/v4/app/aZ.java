package android.support.v4.app;

import java.util.ArrayList;

public class aZ extends bj {
    ArrayList<CharSequence> a = new ArrayList();

    public aZ(aT aTVar) {
        a(aTVar);
    }

    public aZ a(CharSequence charSequence) {
        this.e = aT.f(charSequence);
        return this;
    }

    public aZ b(CharSequence charSequence) {
        this.f = aT.f(charSequence);
        this.g = true;
        return this;
    }

    public aZ c(CharSequence charSequence) {
        this.a.add(aT.f(charSequence));
        return this;
    }
}
