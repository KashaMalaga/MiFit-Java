package org.keplerproject.luajava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class LuaJavaAPI {
    private LuaJavaAPI() {
    }

    public static int checkField(int i, Object obj, String str) {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                Field field = (obj instanceof Class ? (Class) obj : obj.getClass()).getField(str);
                if (field == null) {
                    return 0;
                }
                try {
                    Object obj2 = field.get(obj);
                    if (obj == null) {
                        return 0;
                    }
                    existingState.pushObjectValue(obj2);
                    return 1;
                } catch (Exception e) {
                    return 0;
                }
            } catch (Exception e2) {
                return 0;
            }
        }
    }

    public static int checkMethod(int i, Object obj, String str) {
        int i2 = 0;
        synchronized (LuaStateFactory.getExistingState(i)) {
            Method[] methods = (obj instanceof Class ? (Class) obj : obj.getClass()).getMethods();
            for (Method name : methods) {
                if (name.getName().equals(str)) {
                    i2 = 1;
                    break;
                }
            }
        }
        return i2;
    }

    public static int classIndex(int i, Class cls, String str) {
        int i2;
        synchronized (LuaStateFactory.getExistingState(i)) {
            if (checkField(i, cls, str) != 0) {
                i2 = 1;
            } else if (checkMethod(i, cls, str) != 0) {
                i2 = 2;
            } else {
                i2 = 0;
            }
        }
        return i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object compareTypes(org.keplerproject.luajava.LuaState r6, java.lang.Class r7, int r8) {
        /*
        r2 = 0;
        r0 = 0;
        r1 = 1;
        r3 = r6.isBoolean(r8);
        if (r3 == 0) goto L_0x0030;
    L_0x0009:
        r2 = r7.isPrimitive();
        if (r2 == 0) goto L_0x0026;
    L_0x000f:
        r2 = java.lang.Boolean.TYPE;
        if (r7 == r2) goto L_0x002e;
    L_0x0013:
        r2 = new java.lang.Boolean;
        r1 = r6.toBoolean(r8);
        r2.<init>(r1);
    L_0x001c:
        if (r0 != 0) goto L_0x00d1;
    L_0x001e:
        r0 = new org.keplerproject.luajava.LuaException;
        r1 = "Invalid Parameter.";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r2 = java.lang.Boolean.class;
        r2 = r7.isAssignableFrom(r2);
        if (r2 == 0) goto L_0x0013;
    L_0x002e:
        r0 = r1;
        goto L_0x0013;
    L_0x0030:
        r3 = r6.type(r8);
        r4 = org.keplerproject.luajava.LuaState.LUA_TSTRING;
        r4 = r4.intValue();
        if (r3 != r4) goto L_0x004a;
    L_0x003c:
        r3 = java.lang.String.class;
        r3 = r7.isAssignableFrom(r3);
        if (r3 == 0) goto L_0x001c;
    L_0x0044:
        r2 = r6.toString(r8);
        r0 = r1;
        goto L_0x001c;
    L_0x004a:
        r3 = r6.isFunction(r8);
        if (r3 == 0) goto L_0x005e;
    L_0x0050:
        r3 = org.keplerproject.luajava.LuaObject.class;
        r3 = r7.isAssignableFrom(r3);
        if (r3 == 0) goto L_0x001c;
    L_0x0058:
        r2 = r6.getLuaObject(r8);
        r0 = r1;
        goto L_0x001c;
    L_0x005e:
        r3 = r6.isTable(r8);
        if (r3 == 0) goto L_0x0072;
    L_0x0064:
        r3 = org.keplerproject.luajava.LuaObject.class;
        r3 = r7.isAssignableFrom(r3);
        if (r3 == 0) goto L_0x001c;
    L_0x006c:
        r2 = r6.getLuaObject(r8);
        r0 = r1;
        goto L_0x001c;
    L_0x0072:
        r3 = r6.type(r8);
        r4 = org.keplerproject.luajava.LuaState.LUA_TNUMBER;
        r4 = r4.intValue();
        if (r3 != r4) goto L_0x008f;
    L_0x007e:
        r2 = new java.lang.Double;
        r4 = r6.toNumber(r8);
        r2.<init>(r4);
        r2 = org.keplerproject.luajava.LuaState.convertLuaNumber(r2, r7);
        if (r2 == 0) goto L_0x001c;
    L_0x008d:
        r0 = r1;
        goto L_0x001c;
    L_0x008f:
        r3 = r6.isUserdata(r8);
        if (r3 == 0) goto L_0x00c0;
    L_0x0095:
        r3 = r6.isObject(r8);
        if (r3 == 0) goto L_0x00b1;
    L_0x009b:
        r3 = r6.getObjectFromUserdata(r8);
        r4 = r3.getClass();
        r4 = r7.isAssignableFrom(r4);
        if (r4 != 0) goto L_0x00af;
    L_0x00a9:
        r1 = r0;
        r0 = r2;
    L_0x00ab:
        r2 = r0;
        r0 = r1;
        goto L_0x001c;
    L_0x00af:
        r0 = r3;
        goto L_0x00ab;
    L_0x00b1:
        r3 = org.keplerproject.luajava.LuaObject.class;
        r3 = r7.isAssignableFrom(r3);
        if (r3 == 0) goto L_0x001c;
    L_0x00b9:
        r2 = r6.getLuaObject(r8);
        r0 = r1;
        goto L_0x001c;
    L_0x00c0:
        r0 = r6.isNil(r8);
        if (r0 == 0) goto L_0x00c9;
    L_0x00c6:
        r0 = r1;
        goto L_0x001c;
    L_0x00c9:
        r0 = new org.keplerproject.luajava.LuaException;
        r1 = "Invalid Parameters.";
        r0.<init>(r1);
        throw r0;
    L_0x00d1:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.keplerproject.luajava.LuaJavaAPI.compareTypes(org.keplerproject.luajava.LuaState, java.lang.Class, int):java.lang.Object");
    }

    public static int createProxyObject(int i, String str) {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                if (existingState.isTable(2)) {
                    existingState.pushJavaObject(existingState.getLuaObject(2).createProxy(str));
                } else {
                    throw new LuaException("Parameter is not a table. Can't create proxy.");
                }
            } catch (Exception e) {
                throw new LuaException(e);
            }
        }
        return 1;
    }

    private static Object getObjInstance(LuaState luaState, Class cls) {
        Object newInstance;
        synchronized (luaState) {
            int top = luaState.getTop();
            Object[] objArr = new Object[(top - 1)];
            Constructor[] constructors = cls.getConstructors();
            Constructor constructor = null;
            for (int i = 0; i < constructors.length; i++) {
                Class[] parameterTypes = constructors[i].getParameterTypes();
                if (parameterTypes.length == top - 1) {
                    Object obj = 1;
                    int i2 = 0;
                    while (i2 < parameterTypes.length) {
                        try {
                            objArr[i2] = compareTypes(luaState, parameterTypes[i2], i2 + 2);
                            i2++;
                        } catch (Exception e) {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        constructor = constructors[i];
                        break;
                    }
                }
            }
            if (constructor == null) {
                throw new LuaException("Invalid method call. No such method.");
            }
            try {
                newInstance = constructor.newInstance(objArr);
                if (newInstance == null) {
                    throw new LuaException("Couldn't instantiate java Object");
                }
            } catch (Exception e2) {
                throw new LuaException(e2);
            }
        }
        return newInstance;
    }

    public static int javaLoadLib(int i, String str, String str2) {
        synchronized (LuaStateFactory.getExistingState(i)) {
            try {
                Object invoke = Class.forName(str).getMethod(str2, new Class[]{LuaState.class}).invoke(null, new Object[]{r2});
                if (invoke == null || !(invoke instanceof Integer)) {
                    return 0;
                }
                int intValue = ((Integer) invoke).intValue();
                return intValue;
            } catch (Exception e) {
                throw new LuaException("Error on calling method. Library could not be loaded. " + e.getMessage());
            } catch (Exception e2) {
                throw new LuaException(e2);
            }
        }
    }

    public static int javaNew(int i, Class cls) {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            existingState.pushJavaObject(getObjInstance(existingState, cls));
        }
        return 1;
    }

    public static int javaNewInstance(int i, String str) {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                existingState.pushJavaObject(getObjInstance(existingState, Class.forName(str)));
            } catch (Exception e) {
                throw new LuaException(e);
            }
        }
        return 1;
    }

    public static int objectIndex(int i, Object obj, String str) {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            Method method;
            int top = existingState.getTop();
            Object[] objArr = new Object[(top - 1)];
            Method[] methods = (obj instanceof Class ? (Class) obj : obj.getClass()).getMethods();
            for (int i2 = 0; i2 < methods.length; i2++) {
                Object obj2;
                if (methods[i2].getName().equals(str)) {
                    Class[] parameterTypes = methods[i2].getParameterTypes();
                    if (parameterTypes.length == top - 1) {
                        int i3 = 0;
                        while (i3 < parameterTypes.length) {
                            try {
                                objArr[i3] = compareTypes(existingState, parameterTypes[i3], i3 + 2);
                                i3++;
                            } catch (Exception e) {
                                obj2 = null;
                            }
                        }
                        i3 = 1;
                        if (obj2 != null) {
                            method = methods[i2];
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            method = null;
            if (method == null) {
                throw new LuaException("Invalid method call. No such method.");
            }
            try {
                if (Modifier.isPublic(method.getModifiers())) {
                    method.setAccessible(true);
                }
                obj2 = obj instanceof Class ? method.invoke(null, objArr) : method.invoke(obj, objArr);
                if (obj2 == null) {
                    return 0;
                }
                existingState.pushObjectValue(obj2);
                return 1;
            } catch (Exception e2) {
                throw new LuaException(e2);
            }
        }
    }
}
