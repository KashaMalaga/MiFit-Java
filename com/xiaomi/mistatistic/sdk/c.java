package com.xiaomi.mistatistic.sdk;

import com.xiaomi.mistatistic.sdk.c.a;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

public class c {
    public static void a(Socket socket, SocketAddress socketAddress) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            socket.connect(socketAddress);
            e.a(new a(socketAddress.toString(), System.currentTimeMillis() - currentTimeMillis));
        } catch (IOException e) {
            e.a(new a(socketAddress.toString(), e.getClass().getSimpleName()));
            throw e;
        }
    }

    public static void a(Socket socket, SocketAddress socketAddress, int i) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            socket.connect(socketAddress, i);
            e.a(new a(socketAddress.toString(), System.currentTimeMillis() - currentTimeMillis));
        } catch (IOException e) {
            e.a(new a(socketAddress.toString(), e.getClass().getSimpleName()));
            throw e;
        }
    }
}
