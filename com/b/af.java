package com.b;

public class af {
    public static Object a(Object obj, String str, Object... objArr) {
        Class cls = obj.getClass();
        Class[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return cls.getMethod(str, clsArr).invoke(obj, objArr);
    }
}
