package cn.com.smartdevices.bracelet.shoes.model;

public enum k {
    SYNC_STATE_DEFAULT(-1),
    STATE_UNSYNCED(0),
    STATE_SYNCED_FROM_SERVER(1),
    STATE_SYNCED_TO_SERVER(2);
    
    private int e;

    private k(int i) {
        this.e = i;
    }

    static boolean a(k kVar) {
        return STATE_SYNCED_FROM_SERVER.equals(kVar) || STATE_SYNCED_TO_SERVER.equals(kVar) || STATE_UNSYNCED.equals(kVar);
    }

    public int a() {
        return this.e;
    }
}
