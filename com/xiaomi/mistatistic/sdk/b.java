package com.xiaomi.mistatistic.sdk;

import com.xiaomi.mistatistic.sdk.b.u;
import com.xiaomi.mistatistic.sdk.c.a;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public class b {
    private static int a(Object obj) {
        if (!(obj instanceof HttpResponse)) {
            return 0;
        }
        StatusLine statusLine = ((HttpResponse) obj).getStatusLine();
        return statusLine == null ? 0 : statusLine.getStatusCode();
    }

    public static Object a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) {
        String str = httpHost.toURI().toString();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Object execute = httpClient.execute(httpHost, httpRequest, responseHandler);
            u.a().a(new a(str, System.currentTimeMillis() - currentTimeMillis, a(execute), null));
            return execute;
        } catch (IOException e) {
            u.a().a(new a(str, e.getClass().getSimpleName()));
            throw e;
        }
    }

    public static Object a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) {
        String str = httpHost.toURI().toString();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Object execute = httpClient.execute(httpHost, httpRequest, responseHandler, httpContext);
            u.a().a(new a(str, System.currentTimeMillis() - currentTimeMillis, a(execute), null));
            return execute;
        } catch (ClientProtocolException e) {
            u.a().a(new a(str, e.getClass().getSimpleName()));
            throw e;
        } catch (IOException e2) {
            u.a().a(new a(str, e2.getClass().getSimpleName()));
            throw e2;
        }
    }

    public static Object a(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler) {
        String uri = httpUriRequest.getURI().toString();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Object execute = httpClient.execute(httpUriRequest, responseHandler);
            u.a().a(new a(uri, System.currentTimeMillis() - currentTimeMillis, a(execute), null));
            return execute;
        } catch (IOException e) {
            u.a().a(new a(uri, e.getClass().getSimpleName()));
            throw e;
        }
    }

    public static Object a(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext) {
        String url = httpUriRequest.getURI().toURL().toString();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Object execute = httpClient.execute(httpUriRequest, responseHandler, httpContext);
            u.a().a(new a(url, System.currentTimeMillis() - currentTimeMillis, a(execute), null));
            return execute;
        } catch (ClientProtocolException e) {
            u.a().a(new a(url, e.getClass().getSimpleName()));
            throw e;
        } catch (IOException e2) {
            u.a().a(new a(url, e2.getClass().getSimpleName()));
            throw e2;
        }
    }

    public static HttpResponse a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) {
        String str = httpHost.toURI().toString();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HttpResponse execute = httpClient.execute(httpHost, httpRequest);
            u.a().a(new a(str, System.currentTimeMillis() - currentTimeMillis, a(execute), null));
            return execute;
        } catch (IOException e) {
            u.a().a(new a(str, e.getClass().getSimpleName()));
            throw e;
        }
    }

    public static HttpResponse a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        String str = httpHost.toURI().toString();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HttpResponse execute = httpClient.execute(httpHost, httpRequest, httpContext);
            u.a().a(new a(str, System.currentTimeMillis() - currentTimeMillis, a(execute), null));
            return execute;
        } catch (IOException e) {
            u.a().a(new a(str, e.getClass().getSimpleName()));
            throw e;
        }
    }

    public static HttpResponse a(HttpClient httpClient, HttpUriRequest httpUriRequest) {
        String url = httpUriRequest.getURI().toURL().toString();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HttpResponse execute = httpClient.execute(httpUriRequest);
            u.a().a(new a(url, System.currentTimeMillis() - currentTimeMillis, a(execute), null));
            return execute;
        } catch (ClientProtocolException e) {
            u.a().a(new a(url, e.getClass().getSimpleName()));
            throw e;
        } catch (IOException e2) {
            u.a().a(new a(url, e2.getClass().getSimpleName()));
            throw e2;
        }
    }

    public static HttpResponse a(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) {
        String uri = httpUriRequest.getURI().toString();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HttpResponse execute = httpClient.execute(httpUriRequest, httpContext);
            u.a().a(new a(uri, System.currentTimeMillis() - currentTimeMillis, a(execute), null));
            return execute;
        } catch (IOException e) {
            u.a().a(new a(uri, e.getClass().getSimpleName()));
            throw e;
        }
    }
}
