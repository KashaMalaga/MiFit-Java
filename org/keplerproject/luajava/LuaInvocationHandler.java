package org.keplerproject.luajava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LuaInvocationHandler implements InvocationHandler {
    private LuaObject obj;

    public LuaInvocationHandler(LuaObject luaObject) {
        this.obj = luaObject;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2 = null;
        synchronized (this.obj.L) {
            LuaObject field = this.obj.getField(method.getName());
            if (field.isNil()) {
            } else {
                Class returnType = method.getReturnType();
                if (returnType.equals(Void.class) || returnType.equals(Void.TYPE)) {
                    field.call(objArr, 0);
                } else {
                    obj2 = field.call(objArr, 1)[0];
                    if (obj2 != null && (obj2 instanceof Double)) {
                        obj2 = LuaState.convertLuaNumber((Double) obj2, returnType);
                    }
                }
            }
        }
        return obj2;
    }
}
