package com.g.a;

public abstract class A implements Runnable {
    public abstract void a();

    public void run() {
        try {
            a();
        } catch (Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
        }
    }
}
