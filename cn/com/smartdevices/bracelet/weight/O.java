package cn.com.smartdevices.bracelet.weight;

import java.util.Comparator;

public class O implements Comparator<UserInfo> {
    final /* synthetic */ J a;

    public O(J j) {
        this.a = j;
    }

    public int a(UserInfo userInfo, UserInfo userInfo2) {
        return userInfo.uid - userInfo2.uid;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((UserInfo) obj, (UserInfo) obj2);
    }
}
