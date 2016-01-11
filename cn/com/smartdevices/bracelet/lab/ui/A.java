package cn.com.smartdevices.bracelet.lab.ui;

import java.util.Collections;
import java.util.LinkedList;

public class A {
    private LinkedList<Integer> a;

    public float a(int i) {
        if (this.a.size() < 5) {
            this.a.addFirst(Integer.valueOf(i));
        } else {
            this.a.removeLast();
            this.a.addFirst(Integer.valueOf(i));
        }
        LinkedList linkedList = this.a;
        Collections.sort(linkedList);
        int intValue = ((Integer) linkedList.get(linkedList.size() / 2)).intValue();
        linkedList.clear();
        return (float) intValue;
    }

    public void a() {
        this.a = new LinkedList();
        this.a.clear();
    }
}
