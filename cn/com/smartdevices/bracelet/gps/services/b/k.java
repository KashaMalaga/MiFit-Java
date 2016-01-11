package cn.com.smartdevices.bracelet.gps.services.b;

import java.util.LinkedList;

public class k {
    private LinkedList<Float> a;
    private int b;

    public k(int i) {
        this.a = null;
        this.b = 0;
        this.a = new LinkedList();
        this.b = i;
    }

    private Float b() {
        float floatValue;
        Float f = (Float) this.a.get(0);
        Float f2 = (Float) this.a.get(1);
        Float f3 = (Float) this.a.get(2);
        if (f.floatValue() <= f2.floatValue()) {
            float floatValue2 = f2.floatValue();
            if (floatValue2 > f3.floatValue()) {
                if (f3.floatValue() >= f.floatValue()) {
                    f = f3;
                }
                floatValue = f.floatValue();
            } else {
                floatValue = floatValue2;
            }
        } else {
            floatValue = f.floatValue();
            if (floatValue > f3.floatValue()) {
                if (f3.floatValue() >= f2.floatValue()) {
                    f2 = f3;
                }
                floatValue = f2.floatValue();
            }
        }
        return Float.valueOf(floatValue);
    }

    public float a(Float f) {
        if (this.a.size() >= this.b) {
            this.a.removeFirst();
        }
        this.a.add(f);
        int size = this.a.size();
        return size == 0 ? 0.0f : (size == 1 || size == 2) ? f.floatValue() : b().floatValue();
    }

    public void a() {
        if (this.a != null) {
            this.a.clear();
        }
    }
}
