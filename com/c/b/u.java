package com.c.b;

import com.c.b.c.a.a;

public class u {
    private final float a;
    private final float b;

    public u(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public static float a(u uVar, u uVar2) {
        return a.a(uVar.a, uVar.b, uVar2.a, uVar2.b);
    }

    private static float a(u uVar, u uVar2, u uVar3) {
        float f = uVar2.a;
        float f2 = uVar2.b;
        return ((uVar3.a - f) * (uVar.b - f2)) - ((uVar.a - f) * (uVar3.b - f2));
    }

    public static void a(u[] uVarArr) {
        u uVar;
        u uVar2;
        u uVar3;
        float a = a(uVarArr[0], uVarArr[1]);
        float a2 = a(uVarArr[1], uVarArr[2]);
        float a3 = a(uVarArr[0], uVarArr[2]);
        if (a2 >= a && a2 >= a3) {
            uVar = uVarArr[0];
            uVar2 = uVarArr[1];
            uVar3 = uVarArr[2];
        } else if (a3 < a2 || a3 < a) {
            uVar = uVarArr[2];
            uVar2 = uVarArr[0];
            uVar3 = uVarArr[1];
        } else {
            uVar = uVarArr[1];
            uVar2 = uVarArr[0];
            uVar3 = uVarArr[2];
        }
        if (a(uVar2, uVar, uVar3) >= 0.0f) {
            u uVar4 = uVar3;
            uVar3 = uVar2;
            uVar2 = uVar4;
        }
        uVarArr[0] = uVar3;
        uVarArr[1] = uVar;
        uVarArr[2] = uVar2;
    }

    public final float a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.a == uVar.a && this.b == uVar.b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(25);
        stringBuilder.append('(');
        stringBuilder.append(this.a);
        stringBuilder.append(',');
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
