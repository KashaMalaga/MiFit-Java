package com.xiaomi.push.service;

import com.xiaomi.hm.health.t;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public abstract class ad {
    public static String a = "com.xiaomi.push.OPEN_CHANNEL";
    public static String b = "com.xiaomi.push.SEND_MESSAGE";
    public static String c = "com.xiaomi.push.SEND_IQ";
    public static String d = "com.xiaomi.push.BATCH_SEND_MESSAGE";
    public static String e = "com.xiaomi.push.SEND_PRES";
    public static String f = "com.xiaomi.push.CLOSE_CHANNEL";
    public static String g = "com.xiaomi.push.FORCE_RECONN";
    public static String h = "com.xiaomi.push.RESET_CONN";
    public static String i = "com.xiaomi.push.UPDATE_CHANNEL_INFO";
    public static String j = "com.xiaomi.push.SEND_STATS";
    public static String k = "com.xiaomi.push.CHANGE_HOST";
    public static String l = "com.xiaomi.push.PING_TIMER";
    public static String m = "ext_user_id";
    public static String n = "ext_chid";
    public static String o = "ext_sid";
    public static String p = "ext_token";
    public static String q = "ext_auth_method";
    public static String r = "ext_security";
    public static String s = "ext_kick";
    public static String t = "ext_client_attr";
    public static String u = "ext_cloud_attr";
    public static String v = "ext_pkg_name";
    public static String w = "ext_notify_id";
    public static String x = "ext_notify_type";
    public static String y = "ext_session";
    public static String z = "sig";

    public static String a(int i) {
        switch (i) {
            case a.i /*0*/:
                return "ERROR_OK";
            case l.a /*1*/:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case a.k /*2*/:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case a.l /*3*/:
                return "ERROR_NETWORK_FAILED";
            case a.aQ /*4*/:
                return "ERROR_ACCESS_DENIED";
            case a.X /*5*/:
                return "ERROR_AUTH_FAILED";
            case a.bt /*6*/:
                return "ERROR_MULTI_LOGIN";
            case a.bc /*7*/:
                return "ERROR_SERVER_ERROR";
            case a.ba /*8*/:
                return "ERROR_RECEIVE_TIMEOUT";
            case a.bo /*9*/:
                return "ERROR_READ_ERROR";
            case a.bd /*10*/:
                return "ERROR_SEND_ERROR";
            case a.aW /*11*/:
                return "ERROR_RESET";
            case a.be /*12*/:
                return "ERROR_NO_CLIENT";
            case t.WeightView_wv_bmi_size /*13*/:
                return "ERROR_SERVER_STREAM";
            case t.WeightView_wv_tips /*14*/:
                return "ERROR_THREAD_BLOCK";
            case a.aV /*15*/:
                return "ERROR_SERVICE_DESTROY";
            case a.bp /*16*/:
                return "ERROR_SESSION_CHANGED";
            case a.bu /*17*/:
                return "ERROR_READ_TIMEOUT";
            case a.br /*18*/:
                return "ERROR_CONNECTIING_TIMEOUT";
            case a.bs /*19*/:
                return "ERROR_USER_BLOCKED";
            case a.aF /*20*/:
                return "ERROR_REDIRECT";
            case com.xiaomi.hm.health.bt.profile.a.a.Z /*21*/:
                return "ERROR_BIND_TIMEOUT";
            case com.xiaomi.hm.health.bt.profile.a.a.aa /*22*/:
                return "ERROR_PING_TIMEOUT";
            default:
                return String.valueOf(i);
        }
    }
}
