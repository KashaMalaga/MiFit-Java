package com.e.a;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class X extends Handler {
    private X() {
    }

    public void handleMessage(Message message) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int size;
        int i;
        R r;
        ArrayList arrayList3 = (ArrayList) R.r.get();
        ArrayList arrayList4 = (ArrayList) R.t.get();
        int i2;
        switch (message.what) {
            case a.i /*0*/:
                arrayList = (ArrayList) R.s.get();
                if (arrayList3.size() > 0 || arrayList4.size() > 0) {
                    Object obj = null;
                } else {
                    i2 = 1;
                }
                while (arrayList.size() > 0) {
                    arrayList2 = (ArrayList) arrayList.clone();
                    arrayList.clear();
                    size = arrayList2.size();
                    for (i = 0; i < size; i++) {
                        r = (R) arrayList2.get(i);
                        if (r.H == 0) {
                            r.n();
                        } else {
                            arrayList4.add(r);
                        }
                    }
                }
                break;
            case l.a /*1*/:
                i2 = 1;
                break;
            default:
                return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        arrayList = (ArrayList) R.v.get();
        arrayList2 = (ArrayList) R.u.get();
        size = arrayList4.size();
        for (i = 0; i < size; i++) {
            r = (R) arrayList4.get(i);
            if (r.g(currentAnimationTimeMillis)) {
                arrayList.add(r);
            }
        }
        size = arrayList.size();
        if (size > 0) {
            for (i = 0; i < size; i++) {
                r = (R) arrayList.get(i);
                r.n();
                r.E = true;
                arrayList4.remove(r);
            }
            arrayList.clear();
        }
        i = arrayList3.size();
        int i3 = 0;
        while (i3 < i) {
            R r2 = (R) arrayList3.get(i3);
            if (r2.c(currentAnimationTimeMillis)) {
                arrayList2.add(r2);
            }
            if (arrayList3.size() == i) {
                i3++;
            } else {
                i--;
                arrayList2.remove(r2);
            }
        }
        if (arrayList2.size() > 0) {
            for (i3 = 0; i3 < arrayList2.size(); i3++) {
                ((R) arrayList2.get(i3)).l();
            }
            arrayList2.clear();
        }
        if (obj == null) {
            return;
        }
        if (!arrayList3.isEmpty() || !arrayList4.isEmpty()) {
            sendEmptyMessageDelayed(1, Math.max(0, R.I - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
        }
    }
}
