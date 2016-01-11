package com.e.a;

public class C1046m implements Q<Number> {
    public Float a(float f, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + ((number2.floatValue() - floatValue) * f));
    }
}
