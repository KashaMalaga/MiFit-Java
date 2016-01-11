package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.model.BtDevice;
import java.util.Comparator;

public class C0673ac implements Comparator {
    public int compare(Object obj, Object obj2) {
        return ((BtDevice) obj2).signal - ((BtDevice) obj).signal;
    }
}
