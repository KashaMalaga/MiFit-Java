package org.keplerproject.luajava;

import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;
import java.lang.reflect.Proxy;
import java.util.StringTokenizer;

public class LuaObject {
    protected LuaState L;
    protected Integer ref;

    protected LuaObject(LuaObject luaObject, Number number) {
        synchronized (luaObject.getLuaState()) {
            this.L = luaObject.getLuaState();
            if (luaObject.isTable() || luaObject.isUserdata()) {
                luaObject.push();
                this.L.pushNumber(number.doubleValue());
                this.L.getTable(-2);
                this.L.remove(-2);
                registerValue(-1);
                this.L.pop(1);
            } else {
                throw new LuaException("Object parent should be a table or userdata .");
            }
        }
    }

    protected LuaObject(LuaObject luaObject, String str) {
        synchronized (luaObject.getLuaState()) {
            this.L = luaObject.getLuaState();
            if (luaObject.isTable() || luaObject.isUserdata()) {
                luaObject.push();
                this.L.pushString(str);
                this.L.getTable(-2);
                this.L.remove(-2);
                registerValue(-1);
                this.L.pop(1);
            } else {
                throw new LuaException("Object parent should be a table or userdata .");
            }
        }
    }

    protected LuaObject(LuaObject luaObject, LuaObject luaObject2) {
        if (luaObject.getLuaState() != luaObject2.getLuaState()) {
            throw new LuaException("LuaStates must be the same!");
        }
        synchronized (luaObject.getLuaState()) {
            if (luaObject.isTable() || luaObject.isUserdata()) {
                this.L = luaObject.getLuaState();
                luaObject.push();
                luaObject2.push();
                this.L.getTable(-2);
                this.L.remove(-2);
                registerValue(-1);
                this.L.pop(1);
            } else {
                throw new LuaException("Object parent should be a table or userdata .");
            }
        }
    }

    protected LuaObject(LuaState luaState, int i) {
        synchronized (luaState) {
            this.L = luaState;
            registerValue(i);
        }
    }

    protected LuaObject(LuaState luaState, String str) {
        synchronized (luaState) {
            this.L = luaState;
            luaState.getGlobal(str);
            registerValue(-1);
            luaState.pop(1);
        }
    }

    private void registerValue(int i) {
        synchronized (this.L) {
            this.L.pushValue(i);
            this.ref = new Integer(this.L.Lref(LuaState.LUA_REGISTRYINDEX.intValue()));
        }
    }

    public Object call(Object[] objArr) {
        return call(objArr, 1)[0];
    }

    public Object[] call(Object[] objArr, int i) {
        Object[] objArr2;
        int i2 = 0;
        synchronized (this.L) {
            if (isFunction() || isTable() || isUserdata()) {
                int length;
                int top = this.L.getTop();
                push();
                if (objArr != null) {
                    length = objArr.length;
                    while (i2 < length) {
                        this.L.pushObjectValue(objArr[i2]);
                        i2++;
                    }
                } else {
                    length = 0;
                }
                i2 = this.L.pcall(length, i, 0);
                if (i2 != 0) {
                    String luaState;
                    if (this.L.isString(-1)) {
                        luaState = this.L.toString(-1);
                        this.L.pop(1);
                    } else {
                        luaState = a.f;
                    }
                    luaState = i2 == LuaState.LUA_ERRRUN.intValue() ? "Runtime error. " + luaState : i2 == LuaState.LUA_ERRMEM.intValue() ? "Memory allocation error. " + luaState : i2 == LuaState.LUA_ERRERR.intValue() ? "Error while running the error handler function. " + luaState : "Lua Error code " + i2 + ". " + luaState;
                    throw new LuaException(luaState);
                }
                length = i == LuaState.LUA_MULTRET.intValue() ? this.L.getTop() - top : i;
                if (this.L.getTop() - top < length) {
                    throw new LuaException("Invalid Number of Results .");
                }
                objArr2 = new Object[length];
                while (length > 0) {
                    objArr2[length - 1] = this.L.toJavaObject(-1);
                    this.L.pop(1);
                    length--;
                }
            } else {
                throw new LuaException("Invalid object. Not a function, table or userdata .");
            }
        }
        return objArr2;
    }

    public Object createProxy(String str) {
        Object newProxyInstance;
        synchronized (this.L) {
            if (isTable()) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, f.i);
                Class[] clsArr = new Class[stringTokenizer.countTokens()];
                int i = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    clsArr[i] = Class.forName(stringTokenizer.nextToken());
                    i++;
                }
                newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new LuaInvocationHandler(this));
            } else {
                throw new LuaException("Invalid Object. Must be Table.");
            }
        }
        return newProxyInstance;
    }

    protected void finalize() {
        try {
            synchronized (this.L) {
                if (this.L.getCPtrPeer() != 0) {
                    this.L.LunRef(LuaState.LUA_REGISTRYINDEX.intValue(), this.ref.intValue());
                }
            }
        } catch (Exception e) {
            System.err.println("Unable to release object " + this.ref);
        }
    }

    public boolean getBoolean() {
        boolean toBoolean;
        synchronized (this.L) {
            push();
            toBoolean = this.L.toBoolean(-1);
            this.L.pop(1);
        }
        return toBoolean;
    }

    public LuaObject getField(String str) {
        return this.L.getLuaObject(this, str);
    }

    public LuaState getLuaState() {
        return this.L;
    }

    public double getNumber() {
        double toNumber;
        synchronized (this.L) {
            push();
            toNumber = this.L.toNumber(-1);
            this.L.pop(1);
        }
        return toNumber;
    }

    public Object getObject() {
        Object objectFromUserdata;
        synchronized (this.L) {
            push();
            objectFromUserdata = this.L.getObjectFromUserdata(-1);
            this.L.pop(1);
        }
        return objectFromUserdata;
    }

    public String getString() {
        String luaState;
        synchronized (this.L) {
            push();
            luaState = this.L.toString(-1);
            this.L.pop(1);
        }
        return luaState;
    }

    public boolean isBoolean() {
        boolean isBoolean;
        synchronized (this.L) {
            push();
            isBoolean = this.L.isBoolean(-1);
            this.L.pop(1);
        }
        return isBoolean;
    }

    public boolean isFunction() {
        boolean isFunction;
        synchronized (this.L) {
            push();
            isFunction = this.L.isFunction(-1);
            this.L.pop(1);
        }
        return isFunction;
    }

    public boolean isJavaFunction() {
        boolean isJavaFunction;
        synchronized (this.L) {
            push();
            isJavaFunction = this.L.isJavaFunction(-1);
            this.L.pop(1);
        }
        return isJavaFunction;
    }

    public boolean isJavaObject() {
        boolean isObject;
        synchronized (this.L) {
            push();
            isObject = this.L.isObject(-1);
            this.L.pop(1);
        }
        return isObject;
    }

    public boolean isNil() {
        boolean isNil;
        synchronized (this.L) {
            push();
            isNil = this.L.isNil(-1);
            this.L.pop(1);
        }
        return isNil;
    }

    public boolean isNumber() {
        boolean isNumber;
        synchronized (this.L) {
            push();
            isNumber = this.L.isNumber(-1);
            this.L.pop(1);
        }
        return isNumber;
    }

    public boolean isString() {
        boolean isString;
        synchronized (this.L) {
            push();
            isString = this.L.isString(-1);
            this.L.pop(1);
        }
        return isString;
    }

    public boolean isTable() {
        boolean isTable;
        synchronized (this.L) {
            push();
            isTable = this.L.isTable(-1);
            this.L.pop(1);
        }
        return isTable;
    }

    public boolean isUserdata() {
        boolean isUserdata;
        synchronized (this.L) {
            push();
            isUserdata = this.L.isUserdata(-1);
            this.L.pop(1);
        }
        return isUserdata;
    }

    public void push() {
        this.L.rawGetI(LuaState.LUA_REGISTRYINDEX.intValue(), this.ref.intValue());
    }

    public String toString() {
        String str = null;
        synchronized (this.L) {
            try {
                if (isNil()) {
                    str = "nil";
                } else if (isBoolean()) {
                    str = String.valueOf(getBoolean());
                } else if (isNumber()) {
                    str = String.valueOf(getNumber());
                } else if (isString()) {
                    str = getString();
                } else if (isFunction()) {
                    str = "Lua Function";
                } else if (isJavaObject()) {
                    str = getObject().toString();
                } else if (isUserdata()) {
                    str = "Userdata";
                } else if (isTable()) {
                    str = "Lua Table";
                } else if (isJavaFunction()) {
                    str = "Java Function";
                }
            } catch (LuaException e) {
            }
        }
        return str;
    }

    public int type() {
        int type;
        synchronized (this.L) {
            push();
            type = this.L.type(-1);
            this.L.pop(1);
        }
        return type;
    }
}
