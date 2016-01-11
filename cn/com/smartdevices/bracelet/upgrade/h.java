package cn.com.smartdevices.bracelet.upgrade;

import java.util.concurrent.ConcurrentLinkedQueue;

interface h {
    void onFinish(ConcurrentLinkedQueue<Integer> concurrentLinkedQueue);

    void onUpgrade(int i);
}
