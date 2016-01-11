package android.support.v4.f;

import android.net.TrafficStats;
import java.net.Socket;

class q {
    q() {
    }

    public static void a() {
        TrafficStats.clearThreadStatsTag();
    }

    public static void a(int i) {
        TrafficStats.incrementOperationCount(i);
    }

    public static void a(int i, int i2) {
        TrafficStats.incrementOperationCount(i, i2);
    }

    public static void a(Socket socket) {
        TrafficStats.tagSocket(socket);
    }

    public static int b() {
        return TrafficStats.getThreadStatsTag();
    }

    public static void b(int i) {
        TrafficStats.setThreadStatsTag(i);
    }

    public static void b(Socket socket) {
        TrafficStats.untagSocket(socket);
    }
}
