package cn.com.smartdevices.bracelet.gps.c.a;

public enum t {
    SYNC_STATE_DEFAULT(-1),
    STATE_UNSYNCED(0),
    STATE_SYNCED_FROM_SERVER(1),
    STATE_SYNCED_TO_SERVER(2),
    STATE_SYNCED_FROM_SERVER_SUMMERY_DONE(3),
    STATE_TO_BE_DELETED(4);
    
    private int g;

    private t(int i) {
        this.g = i;
    }

    static boolean a(t tVar) {
        return STATE_SYNCED_FROM_SERVER.equals(tVar) || STATE_SYNCED_TO_SERVER.equals(tVar) || STATE_UNSYNCED.equals(tVar) || STATE_SYNCED_FROM_SERVER_SUMMERY_DONE.equals(tVar) || STATE_TO_BE_DELETED.equals(tVar);
    }

    public int a() {
        return this.g;
    }
}
