package com.c.b;

import java.util.List;

public enum e {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(v.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);
    
    private final Class<?> l;

    private e(Class<?> cls) {
        this.l = cls;
    }

    public Class<?> a() {
        return this.l;
    }
}
