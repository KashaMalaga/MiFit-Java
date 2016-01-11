package com.f.a.b.a.a;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

abstract class f implements Iterator<E> {
    i<E> a;
    E b;
    final /* synthetic */ d c;
    private i<E> d;

    f(d dVar) {
        this.c = dVar;
        ReentrantLock reentrantLock = dVar.c;
        reentrantLock.lock();
        try {
            this.a = a();
            this.b = this.a == null ? null : this.a.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    private i<E> b(i<E> iVar) {
        while (true) {
            i<E> a = a(iVar);
            if (a == null) {
                return null;
            }
            if (a.a != null) {
                return a;
            }
            if (a == iVar) {
                return a();
            }
            iVar = a;
        }
    }

    abstract i<E> a();

    abstract i<E> a(i<E> iVar);

    void b() {
        ReentrantLock reentrantLock = this.c.c;
        reentrantLock.lock();
        try {
            this.a = b(this.a);
            this.b = this.a == null ? null : this.a.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean hasNext() {
        return this.a != null;
    }

    public E next() {
        if (this.a == null) {
            throw new NoSuchElementException();
        }
        this.d = this.a;
        E e = this.b;
        b();
        return e;
    }

    public void remove() {
        i iVar = this.d;
        if (iVar == null) {
            throw new IllegalStateException();
        }
        this.d = null;
        ReentrantLock reentrantLock = this.c.c;
        reentrantLock.lock();
        try {
            if (iVar.a != null) {
                this.c.a(iVar);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }
}
