package org.keplerproject.luajava;

import java.util.ArrayList;
import java.util.List;

public final class LuaStateFactory {
    private static final List states = new ArrayList();

    private LuaStateFactory() {
    }

    public static synchronized LuaState getExistingState(int i) {
        LuaState luaState;
        synchronized (LuaStateFactory.class) {
            luaState = (LuaState) states.get(i);
        }
        return luaState;
    }

    private static synchronized int getNextStateIndex() {
        int i;
        synchronized (LuaStateFactory.class) {
            i = 0;
            while (i < states.size() && states.get(i) != null) {
                i++;
            }
        }
        return i;
    }

    public static synchronized int insertLuaState(LuaState luaState) {
        int i;
        synchronized (LuaStateFactory.class) {
            for (int i2 = 0; i2 < states.size(); i2++) {
                LuaState luaState2 = (LuaState) states.get(i2);
                if (luaState2 != null && luaState2.getCPtrPeer() == luaState.getCPtrPeer()) {
                    i = i2;
                    break;
                }
            }
            i = getNextStateIndex();
            states.set(i, luaState);
        }
        return i;
    }

    public static synchronized LuaState newLuaState() {
        LuaState luaState;
        synchronized (LuaStateFactory.class) {
            int nextStateIndex = getNextStateIndex();
            luaState = new LuaState(nextStateIndex);
            states.add(nextStateIndex, luaState);
        }
        return luaState;
    }

    public static synchronized void removeLuaState(int i) {
        synchronized (LuaStateFactory.class) {
            states.add(i, null);
        }
    }
}
