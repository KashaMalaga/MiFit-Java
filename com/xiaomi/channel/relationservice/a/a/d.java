package com.xiaomi.channel.relationservice.a.a;

import android.os.Bundle;
import android.os.IInterface;
import com.xiaomi.channel.relationservice.data.BuddyData;
import java.util.List;

public interface d extends IInterface {
    int a(String str, String[] strArr, List<Bundle> list);

    String a(String str);

    List<BuddyData> a(String str, String[] strArr, String str2, String str3, String str4, String str5);

    void a(a aVar);

    boolean a();

    boolean a(Bundle bundle);

    boolean a(BuddyData buddyData);

    boolean a(String str, String str2);

    boolean a(List<BuddyData> list);

    int b();

    int b(List<String> list);

    BuddyData b(String str);

    void b(a aVar);

    boolean c();

    boolean c(List<String> list);

    String d();
}
