package com.autonavi.amap.mapcore;

import java.util.ArrayList;
import java.util.Hashtable;

public class VTMCDataCache {
    public static final int MAXSIZE = 500;
    public static final int MAX_EXPIREDTIME = 10;
    private static volatile VTMCDataCache instance;
    static Hashtable<String, e> vtmcHs = new Hashtable();
    static ArrayList<String> vtmcList = new ArrayList();

    public static VTMCDataCache getInstance() {
        if (instance == null) {
            instance = new VTMCDataCache();
        }
        return instance;
    }

    public e GetData(String str) {
        e eVar = (e) vtmcHs.get(str);
        return eVar != null ? ((int) (System.currentTimeMillis() / 1000)) - eVar.c > MAX_EXPIREDTIME ? null : eVar : null;
    }

    public void putData(String str, byte[] bArr) {
        e eVar = new e(str, bArr);
        if (vtmcList.size() > MAXSIZE) {
            vtmcHs.remove(vtmcList.get(0));
            vtmcList.remove(0);
        }
        vtmcHs.put(str, eVar);
        vtmcList.add(str);
    }

    public void reset() {
        vtmcHs.clear();
    }
}
