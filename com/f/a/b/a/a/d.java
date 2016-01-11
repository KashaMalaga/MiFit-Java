package com.f.a.b.a.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class d<E> extends AbstractQueue<E> implements a<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    transient i<E> a;
    transient i<E> b;
    final ReentrantLock c;
    private transient int d;
    private final int e;
    private final Condition f;
    private final Condition g;

    public d() {
        this(Integer.MAX_VALUE);
    }

    public d(int i) {
        this.c = new ReentrantLock();
        this.f = this.c.newCondition();
        this.g = this.c.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.e = i;
    }

    public d(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            for (Object next : collection) {
                if (next == null) {
                    throw new NullPointerException();
                } else if (!c(new i(next))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean b(i<E> iVar) {
        if (this.d >= this.e) {
            return false;
        }
        i iVar2 = this.a;
        iVar.c = iVar2;
        this.a = iVar;
        if (this.b == null) {
            this.b = iVar;
        } else {
            iVar2.b = iVar;
        }
        this.d++;
        this.f.signal();
        return true;
    }

    private boolean c(i<E> iVar) {
        if (this.d >= this.e) {
            return false;
        }
        i iVar2 = this.b;
        iVar.b = iVar2;
        this.b = iVar;
        if (this.a == null) {
            this.a = iVar;
        } else {
            iVar2.c = iVar;
        }
        this.d++;
        this.f.signal();
        return true;
    }

    private E m() {
        i iVar = this.a;
        if (iVar == null) {
            return null;
        }
        i iVar2 = iVar.c;
        E e = iVar.a;
        iVar.a = null;
        iVar.c = iVar;
        this.a = iVar2;
        if (iVar2 == null) {
            this.b = null;
        } else {
            iVar2.b = null;
        }
        this.d--;
        this.g.signal();
        return e;
    }

    private E n() {
        i iVar = this.b;
        if (iVar == null) {
            return null;
        }
        i iVar2 = iVar.b;
        E e = iVar.a;
        iVar.a = null;
        iVar.b = iVar;
        this.b = iVar2;
        if (iVar2 == null) {
            this.a = null;
        } else {
            iVar2.c = null;
        }
        this.d--;
        this.g.signal();
        return e;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.d = 0;
        this.a = null;
        this.b = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (i iVar = this.a; iVar != null; iVar = iVar.c) {
                objectOutputStream.writeObject(iVar.a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public E a() {
        E m;
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        while (true) {
            try {
                m = m();
                if (m != null) {
                    break;
                }
                this.f.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        return m;
    }

    public E a(long j, TimeUnit timeUnit) {
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lockInterruptibly();
        long j2 = toNanos;
        while (true) {
            try {
                E m = m();
                if (m != null) {
                    reentrantLock.unlock();
                    return m;
                } else if (j2 <= 0) {
                    break;
                } else {
                    j2 = this.f.awaitNanos(j2);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return null;
    }

    void a(i<E> iVar) {
        i iVar2 = iVar.b;
        i iVar3 = iVar.c;
        if (iVar2 == null) {
            m();
        } else if (iVar3 == null) {
            n();
        } else {
            iVar2.c = iVar3;
            iVar3.b = iVar2;
            iVar.a = null;
            this.d--;
            this.g.signal();
        }
    }

    public void a(E e) {
        if (!c((Object) e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public boolean a(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        i iVar = new i(e);
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lockInterruptibly();
        while (!b(iVar)) {
            try {
                if (toNanos <= 0) {
                    return false;
                }
                toNanos = this.g.awaitNanos(toNanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public boolean add(E e) {
        b((Object) e);
        return true;
    }

    public E b() {
        E n;
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        while (true) {
            try {
                n = n();
                if (n != null) {
                    break;
                }
                this.f.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        return n;
    }

    public E b(long j, TimeUnit timeUnit) {
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lockInterruptibly();
        long j2 = toNanos;
        while (true) {
            try {
                E n = n();
                if (n != null) {
                    reentrantLock.unlock();
                    return n;
                } else if (j2 <= 0) {
                    break;
                } else {
                    j2 = this.f.awaitNanos(j2);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return null;
    }

    public void b(E e) {
        if (!d(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public boolean b(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        i iVar = new i(e);
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lockInterruptibly();
        while (!c(iVar)) {
            try {
                if (toNanos <= 0) {
                    return false;
                }
                toNanos = this.g.awaitNanos(toNanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public E c() {
        E e = e();
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public boolean c(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        i iVar = new i(e);
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            boolean b = b(iVar);
            return b;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void clear() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            i iVar = this.a;
            while (iVar != null) {
                iVar.a = null;
                i iVar2 = iVar.c;
                iVar.b = null;
                iVar.c = null;
                iVar = iVar2;
            }
            this.b = null;
            this.a = null;
            this.d = 0;
            this.g.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            for (i iVar = this.a; iVar != null; iVar = iVar.c) {
                if (obj.equals(iVar.a)) {
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E d() {
        E f = f();
        if (f != null) {
            return f;
        }
        throw new NoSuchElementException();
    }

    public boolean d(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        i iVar = new i(e);
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            boolean c = c(iVar);
            return c;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        } else if (collection == this) {
            throw new IllegalArgumentException();
        } else {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                int min = Math.min(i, this.d);
                for (int i2 = 0; i2 < min; i2++) {
                    collection.add(this.a.a);
                    m();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E e() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            E m = m();
            return m;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void e(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        i iVar = new i(e);
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        while (!b(iVar)) {
            try {
                this.g.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E element() {
        return g();
    }

    public E f() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            E n = n();
            return n;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void f(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        i iVar = new i(e);
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        while (!c(iVar)) {
            try {
                this.g.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E g() {
        E i = i();
        if (i != null) {
            return i;
        }
        throw new NoSuchElementException();
    }

    public boolean g(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            for (i iVar = this.a; iVar != null; iVar = iVar.c) {
                if (obj.equals(iVar.a)) {
                    a(iVar);
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E h() {
        E j = j();
        if (j != null) {
            return j;
        }
        throw new NoSuchElementException();
    }

    public boolean h(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            for (i iVar = this.b; iVar != null; iVar = iVar.b) {
                if (obj.equals(iVar.a)) {
                    a(iVar);
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E i() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            E e = this.a == null ? null : this.a.a;
            reentrantLock.unlock();
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    public void i(E e) {
        a((Object) e);
    }

    public Iterator<E> iterator() {
        return new h();
    }

    public E j() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            E e = this.b == null ? null : this.b.a;
            reentrantLock.unlock();
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    public E k() {
        return c();
    }

    public Iterator<E> l() {
        return new g();
    }

    public boolean offer(E e) {
        return d(e);
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return b(e, j, timeUnit);
    }

    public E peek() {
        return i();
    }

    public E poll() {
        return e();
    }

    public E poll(long j, TimeUnit timeUnit) {
        return a(j, timeUnit);
    }

    public void put(E e) {
        f(e);
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            int i = this.e - this.d;
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E remove() {
        return c();
    }

    public boolean remove(Object obj) {
        return g(obj);
    }

    public int size() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            int i = this.d;
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() {
        return a();
    }

    public Object[] toArray() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.d];
            int i = 0;
            i iVar = this.a;
            while (iVar != null) {
                int i2 = i + 1;
                objArr[i] = iVar.a;
                iVar = iVar.c;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            if (tArr.length < this.d) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.d);
            }
            int i = 0;
            i iVar = this.a;
            while (iVar != null) {
                int i2 = i + 1;
                tArr[i] = iVar.a;
                iVar = iVar.c;
                i = i2;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            reentrantLock.unlock();
            return tArr;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    public String toString() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            String str;
            i iVar = this.a;
            if (iVar == null) {
                str = "[]";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('[');
                i iVar2 = iVar;
                while (true) {
                    Object obj = iVar2.a;
                    if (obj == this) {
                        obj = "(this Collection)";
                    }
                    stringBuilder.append(obj);
                    iVar = iVar2.c;
                    if (iVar == null) {
                        break;
                    }
                    stringBuilder.append(',').append(' ');
                    iVar2 = iVar;
                }
                str = stringBuilder.append(']').toString();
                reentrantLock.unlock();
            }
            return str;
        } finally {
            reentrantLock.unlock();
        }
    }
}
