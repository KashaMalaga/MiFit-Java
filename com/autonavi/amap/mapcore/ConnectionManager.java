package com.autonavi.amap.mapcore;

import com.amap.api.mapcore.util.az;

public class ConnectionManager extends Thread {
    c connectionPool = new c();
    int sleepTime = 30;
    boolean threadFlag = true;

    public ConnectionManager() {
        super("ConnectionManager");
    }

    public synchronized void addConntionTask(MapLoader mapLoader) {
        this.connectionPool.a(mapLoader);
    }

    protected void finalize() {
        this.threadFlag = false;
        if (this.connectionPool != null) {
            this.connectionPool.clear();
        }
        interrupt();
    }

    public synchronized int getTaskCount() {
        return this.connectionPool.size();
    }

    public synchronized void insertConntionTask(MapLoader mapLoader) {
        this.connectionPool.insertElementAt(mapLoader, 0);
    }

    public synchronized boolean isEmptyTask() {
        return this.connectionPool.size() == 0;
    }

    public void run() {
        while (this.threadFlag) {
            while (true) {
                if (!this.threadFlag || isInterrupted() || this.connectionPool == null) {
                    try {
                        interrupt();
                        break;
                    } catch (Throwable th) {
                        az.a(th, "ConnectionManager", "interrupt");
                        th.printStackTrace();
                    }
                }
                MapLoader mapLoader = (MapLoader) this.connectionPool.a();
                if (mapLoader != null) {
                    do {
                        if (System.currentTimeMillis() - mapLoader.createtime > 50) {
                            try {
                                mapLoader.doRequest();
                                break;
                            } catch (Throwable th2) {
                                az.a(th2, "ConnectionManager", "doRequest");
                                th2.printStackTrace();
                            }
                        } else {
                            try {
                                sleep(10);
                            } catch (Throwable th22) {
                                th22.printStackTrace();
                            }
                        }
                    } while (this.threadFlag);
                }
            }
            sleep((long) this.sleepTime);
        }
    }
}
