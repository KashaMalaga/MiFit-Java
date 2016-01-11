package com.xiaomi.g;

import com.xiaomi.c.a.C1070b;
import com.xiaomi.f.D;
import com.xiaomi.h.a.C1095b;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

final class d {
    static e a(Exception exception) {
        Throwable a;
        d(exception);
        if ((exception instanceof D) && ((D) exception).a() != null) {
            a = ((D) exception).a();
        }
        e eVar = new e();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        if (a instanceof SocketTimeoutException) {
            eVar.a = C1095b.CONN_TCP_TIMEOUT;
        } else if (a instanceof SocketException) {
            if (message.endsWith("ENETUNREACH (Network is unreachable)")) {
                eVar.a = C1095b.CONN_TCP_NETUNREACH;
            } else if (message.endsWith("ECONNREFUSED (Connection refused)")) {
                eVar.a = C1095b.CONN_TCP_CONNREFUSED;
            } else if (message.endsWith("ETIMEDOUT (Connection timed out)")) {
                eVar.a = C1095b.CONN_TCP_TIMEOUT;
            } else if (message.endsWith("EACCES (Permission denied)")) {
                eVar.a = C1095b.CONN_TCP_NOACCESS;
            } else if (message.endsWith("EINVAL (Invalid argument)")) {
                eVar.a = C1095b.CONN_TCP_INVALARG;
            } else {
                eVar.a = C1095b.CONN_TCP_ERR_OTHER;
                eVar.b = message;
            }
        } else if (a instanceof C1070b) {
            eVar.a = C1095b.CONN_BOSH_ERR;
            Throwable cause = a.getCause();
            if (cause != null && (cause instanceof UnknownHostException)) {
                eVar.a = C1095b.CONN_BOSH_UNKNOWNHOST;
            }
            if (eVar.a == C1095b.CONN_BOSH_ERR) {
                eVar.b = message;
            }
        } else {
            eVar.a = C1095b.CONN_XMPP_ERR;
            eVar.b = message;
        }
        return eVar;
    }

    static e b(Exception exception) {
        Throwable a;
        d(exception);
        if ((exception instanceof D) && ((D) exception).a() != null) {
            a = ((D) exception).a();
        }
        e eVar = new e();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        if (a instanceof SocketTimeoutException) {
            eVar.a = C1095b.BIND_TCP_READ_TIMEOUT;
        } else if (a instanceof SocketException) {
            if (message.endsWith("ECONNRESET (Connection reset by peer)")) {
                eVar.a = C1095b.BIND_TCP_CONNRESET;
            } else if (message.endsWith("ETIMEDOUT (Connection timed out)")) {
                eVar.a = C1095b.BIND_TCP_READ_TIMEOUT;
            } else if (message.endsWith("EPIPE (Broken pipe)")) {
                eVar.a = C1095b.BIND_TCP_BROKEN_PIPE;
            } else {
                eVar.a = C1095b.BIND_TCP_ERR;
                eVar.b = message;
            }
        } else if (a instanceof C1070b) {
            eVar.a = C1095b.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                eVar.a = C1095b.BIND_BOSH_ITEM_NOT_FOUND;
            }
            if (eVar.a == C1095b.BIND_BOSH_ERR) {
                eVar.b = message;
            }
        } else {
            eVar.a = C1095b.BIND_XMPP_ERR;
            eVar.b = message;
        }
        return eVar;
    }

    static e c(Exception exception) {
        Throwable a;
        d(exception);
        if ((exception instanceof D) && ((D) exception).a() != null) {
            a = ((D) exception).a();
        }
        e eVar = new e();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        if (a instanceof SocketTimeoutException) {
            eVar.a = C1095b.CHANNEL_TCP_READTIMEOUT;
        } else if (a instanceof SocketException) {
            if (message.endsWith("ECONNRESET (Connection reset by peer)")) {
                eVar.a = C1095b.CHANNEL_TCP_CONNRESET;
            } else if (message.endsWith("ETIMEDOUT (Connection timed out)")) {
                eVar.a = C1095b.CHANNEL_TCP_READTIMEOUT;
            } else if (message.endsWith("EPIPE (Broken pipe)")) {
                eVar.a = C1095b.CHANNEL_TCP_BROKEN_PIPE;
            } else {
                eVar.a = C1095b.CHANNEL_TCP_ERR;
                eVar.b = message;
            }
        } else if (a instanceof C1070b) {
            eVar.a = C1095b.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                eVar.a = C1095b.CHANNEL_BOSH_ITEMNOTFIND;
            }
            if (eVar.a == C1095b.BIND_BOSH_ERR) {
                eVar.b = message;
            }
        } else {
            eVar.a = C1095b.BIND_XMPP_ERR;
            eVar.b = message;
        }
        return eVar;
    }

    private static void d(Exception exception) {
        if (exception == null) {
            throw new NullPointerException();
        }
    }
}
