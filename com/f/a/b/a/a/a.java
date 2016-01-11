package com.f.a.b.a.a;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public interface a<E> extends b<E>, BlockingQueue<E> {
    E a();

    E a(long j, TimeUnit timeUnit);

    void a(E e);

    boolean a(E e, long j, TimeUnit timeUnit);

    boolean add(E e);

    E b();

    E b(long j, TimeUnit timeUnit);

    void b(E e);

    boolean b(E e, long j, TimeUnit timeUnit);

    boolean c(E e);

    boolean contains(Object obj);

    boolean d(E e);

    void e(E e);

    E element();

    void f(E e);

    boolean g(Object obj);

    boolean h(Object obj);

    void i(E e);

    Iterator<E> iterator();

    boolean offer(E e);

    boolean offer(E e, long j, TimeUnit timeUnit);

    E peek();

    E poll();

    E poll(long j, TimeUnit timeUnit);

    void put(E e);

    E remove();

    boolean remove(Object obj);

    int size();

    E take();
}
