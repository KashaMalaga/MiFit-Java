package org.keplerproject.luajava;

public class LuaException extends Exception {
    private static final long serialVersionUID = 1;

    public LuaException(Exception exception) {
        Throwable cause;
        if (exception.getCause() != null) {
            cause = exception.getCause();
        }
        super(cause);
    }

    public LuaException(String str) {
        super(str);
    }
}
