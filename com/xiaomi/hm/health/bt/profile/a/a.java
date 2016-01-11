package com.xiaomi.hm.health.bt.profile.a;

import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.d.e;
import com.xiaomi.hm.health.bt.model.UserInfo;
import com.xiaomi.hm.health.bt.model.h;
import java.util.Calendar;
import java.util.UUID;

public interface a {
    public static final UUID A = y.a("2A50");
    public static final UUID B = y.a("1802");
    public static final UUID C = y.a("2A06");
    public static final int D = -1;
    public static final int E = 0;
    public static final int F = 1;
    public static final int G = 2;
    public static final int H = 3;
    public static final int I = 4;
    public static final int J = 5;
    public static final int K = 6;
    public static final int L = 7;
    public static final int M = 8;
    public static final int N = 9;
    public static final int O = 10;
    public static final int P = 11;
    public static final int Q = 12;
    public static final int R = 13;
    public static final int S = 14;
    public static final int T = 15;
    public static final int U = 16;
    public static final int V = 17;
    public static final int W = 18;
    public static final int X = 19;
    public static final int Y = 20;
    public static final int Z = 21;
    public static final int aa = 22;
    public static final int ab = 27;
    public static final int ac = 239;
    public static final int ad = 255;
    public static final int ae = 10;
    public static final long e_ = 13586;
    public static final UUID f = y.a("FF02");
    public static final long f_ = 2384656044284446464L;
    public static final UUID g_ = new UUID(e_, f_);
    public static final UUID h_ = y.a("FEE0");
    public static final UUID i_ = y.a("FF01");
    public static final UUID j_ = y.a("FF03");
    public static final UUID k = y.a("FF07");
    public static final UUID k_ = y.a("FF04");
    public static final UUID l = y.a("FF08");
    public static final UUID l_ = y.a("FF05");
    public static final UUID m = y.a("FF09");
    public static final UUID m_ = y.a("FF06");
    public static final UUID n = y.a("FF0A");
    public static final UUID o = y.a("FF0B");
    public static final UUID p = y.a("FF0C");
    public static final UUID q = y.a("FF0D");
    public static final UUID r = y.a("FF0E");
    public static final UUID s = y.a("FF0F");
    public static final UUID t = y.a("180D");
    public static final UUID u = y.a("2A39");
    public static final UUID v = y.a("2A37");
    public static final UUID w = y.a("180A");
    public static final UUID x = y.a("2A25");
    public static final UUID y = y.a("2A28");
    public static final UUID z = y.a("2A23");

    boolean a(byte b, byte b2, Calendar calendar, byte b3, byte b4);

    boolean a(byte b, int i);

    boolean a(UserInfo userInfo);

    boolean a(boolean z, e eVar);

    boolean b(UserInfo userInfo);

    h j_();

    int k_();
}
