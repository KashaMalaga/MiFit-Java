package org.keplerproject.luajava;

public abstract class JavaFunction {
    protected LuaState L;

    public JavaFunction(LuaState luaState) {
        this.L = luaState;
    }

    public abstract int execute();

    public LuaObject getParam(int i) {
        return this.L.getLuaObject(i);
    }

    public void register(String str) {
        synchronized (this.L) {
            this.L.pushJavaFunction(this);
            this.L.setGlobal(str);
        }
    }
}
