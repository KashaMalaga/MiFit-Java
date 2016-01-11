package com.e.c;

import java.util.ArrayList;

class o {
    int a;
    ArrayList<n> b;

    o(int i, ArrayList<n> arrayList) {
        this.a = i;
        this.b = arrayList;
    }

    boolean a(int i) {
        if (!((this.a & i) == 0 || this.b == null)) {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((n) this.b.get(i2)).a == i) {
                    this.b.remove(i2);
                    this.a &= i ^ -1;
                    return true;
                }
            }
        }
        return false;
    }
}
