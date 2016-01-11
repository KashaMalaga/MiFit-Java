package com.xiaomi.account.openauth;

import java.util.Comparator;
import org.apache.http.NameValuePair;

final class d implements Comparator<NameValuePair> {
    d() {
    }

    public int a(NameValuePair nameValuePair, NameValuePair nameValuePair2) {
        return nameValuePair.getName().compareTo(nameValuePair2.getName());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((NameValuePair) obj, (NameValuePair) obj2);
    }
}
