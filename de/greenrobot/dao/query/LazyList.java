package de.greenrobot.dao.query;

import android.database.Cursor;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.InternalQueryDaoAccess;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

public class LazyList<E> implements Closeable, List<E> {
    private final Cursor cursor;
    private final InternalQueryDaoAccess<E> daoAccess;
    private final List<E> entities;
    private volatile int loadedCount;
    private final ReentrantLock lock;
    private final int size;

    public class LazyIterator implements CloseableListIterator<E> {
        private final boolean closeWhenDone;
        private int index;

        public LazyIterator(int i, boolean z) {
            this.index = i;
            this.closeWhenDone = z;
        }

        public void add(E e) {
            throw new UnsupportedOperationException();
        }

        public void close() {
            LazyList.this.close();
        }

        public boolean hasNext() {
            return this.index < LazyList.this.size;
        }

        public boolean hasPrevious() {
            return this.index > 0;
        }

        public E next() {
            if (this.index >= LazyList.this.size) {
                throw new NoSuchElementException();
            }
            E e = LazyList.this.get(this.index);
            this.index++;
            if (this.index == LazyList.this.size && this.closeWhenDone) {
                close();
            }
            return e;
        }

        public int nextIndex() {
            return this.index;
        }

        public E previous() {
            if (this.index <= 0) {
                throw new NoSuchElementException();
            }
            this.index--;
            return LazyList.this.get(this.index);
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void set(E e) {
            throw new UnsupportedOperationException();
        }
    }

    LazyList(InternalQueryDaoAccess<E> internalQueryDaoAccess, Cursor cursor, boolean z) {
        this.cursor = cursor;
        this.daoAccess = internalQueryDaoAccess;
        this.size = cursor.getCount();
        if (z) {
            this.entities = new ArrayList(this.size);
            for (int i = 0; i < this.size; i++) {
                this.entities.add(null);
            }
        } else {
            this.entities = null;
        }
        if (this.size == 0) {
            cursor.close();
        }
        this.lock = new ReentrantLock();
    }

    public void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    protected void checkCached() {
        if (this.entities == null) {
            throw new DaoException("This operation only works with cached lazy lists");
        }
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void close() {
        this.cursor.close();
    }

    public boolean contains(Object obj) {
        loadRemaining();
        return this.entities.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        loadRemaining();
        return this.entities.containsAll(collection);
    }

    public E get(int i) {
        if (this.entities == null) {
            return loadEntity(i);
        }
        E e = this.entities.get(i);
        if (e != null) {
            return e;
        }
        this.lock.lock();
        try {
            e = this.entities.get(i);
            if (e == null) {
                e = loadEntity(i);
                this.entities.set(i, e);
                this.loadedCount++;
                if (this.loadedCount == this.size) {
                    this.cursor.close();
                }
            }
            this.lock.unlock();
            return e;
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }

    public int getLoadedCount() {
        return this.loadedCount;
    }

    public int indexOf(Object obj) {
        loadRemaining();
        return this.entities.indexOf(obj);
    }

    public boolean isClosed() {
        return this.cursor.isClosed();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isLoadedCompletely() {
        return this.loadedCount == this.size;
    }

    public Iterator<E> iterator() {
        return new LazyIterator(0, false);
    }

    public int lastIndexOf(Object obj) {
        loadRemaining();
        return this.entities.lastIndexOf(obj);
    }

    public CloseableListIterator<E> listIterator() {
        return new LazyIterator(0, false);
    }

    public ListIterator<E> listIterator(int i) {
        return new LazyIterator(i, false);
    }

    public CloseableListIterator<E> listIteratorAutoClose() {
        return new LazyIterator(0, true);
    }

    protected E loadEntity(int i) {
        this.cursor.moveToPosition(i);
        E loadCurrent = this.daoAccess.loadCurrent(this.cursor, 0, true);
        if (loadCurrent != null) {
            return loadCurrent;
        }
        throw new DaoException("Loading of entity failed (null) at position " + i);
    }

    public void loadRemaining() {
        checkCached();
        int size = this.entities.size();
        for (int i = 0; i < size; i++) {
            get(i);
        }
    }

    public E peak(int i) {
        return this.entities != null ? this.entities.get(i) : null;
    }

    public E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.size;
    }

    public List<E> subList(int i, int i2) {
        checkCached();
        for (int i3 = i; i3 < i2; i3++) {
            this.entities.get(i3);
        }
        return this.entities.subList(i, i2);
    }

    public Object[] toArray() {
        loadRemaining();
        return this.entities.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        loadRemaining();
        return this.entities.toArray(tArr);
    }
}
