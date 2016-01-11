package com.commonsware.cwac.camera;

public enum c {
    NO_CAMERAS_REPORTED(1),
    UNKNOWN(2);
    
    int c;

    private c(int i) {
        this.c = i;
    }
}
