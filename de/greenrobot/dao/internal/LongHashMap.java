package de.greenrobot.dao.internal;

import de.greenrobot.dao.DaoLog;
import java.util.Arrays;

public final class LongHashMap<T> {
    private int capacity;
    private int size;
    private Entry<T>[] table;
    private int threshold;

    final class Entry<T> {
        final long key;
        Entry<T> next;
        T value;

        Entry(long j, T t, Entry<T> entry) {
            this.key = j;
            this.value = t;
            this.next = entry;
        }
    }

    public LongHashMap() {
        this(16);
    }

    public LongHashMap(int i) {
        this.capacity = i;
        this.threshold = (i * 4) / 3;
        this.table = new Entry[i];
    }

    public void clear() {
        this.size = 0;
        Arrays.fill(this.table, null);
    }

    public boolean containsKey(long j) {
        for (Entry entry = this.table[((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j) {
                return true;
            }
        }
        return false;
    }

    public T get(long j) {
        for (Entry entry = this.table[((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j) {
                return entry.value;
            }
        }
        return null;
    }

    public void logStats() {
        int i = 0;
        for (Entry entry : this.table) {
            Entry entry2;
            while (entry2 != null && entry2.next != null) {
                i++;
                entry2 = entry2.next;
            }
        }
        DaoLog.d("load: " + (((float) this.size) / ((float) this.capacity)) + ", size: " + this.size + ", capa: " + this.capacity + ", collisions: " + i + ", collision ratio: " + (((float) i) / ((float) this.size)));
    }

    public T put(long j, T t) {
        int i = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % this.capacity;
        Entry entry = this.table[i];
        for (Entry entry2 = entry; entry2 != null; entry2 = entry2.next) {
            if (entry2.key == j) {
                T t2 = entry2.value;
                entry2.value = t;
                return t2;
            }
        }
        this.table[i] = new Entry(j, t, entry);
        this.size++;
        if (this.size > this.threshold) {
            setCapacity(this.capacity * 2);
        }
        return null;
    }

    public T remove(long j) {
        int i = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % this.capacity;
        Entry entry = this.table[i];
        Entry entry2 = null;
        while (entry != null) {
            Entry entry3 = entry.next;
            if (entry.key == j) {
                if (entry2 == null) {
                    this.table[i] = entry3;
                } else {
                    entry2.next = entry3;
                }
                this.size--;
                return entry.value;
            }
            entry2 = entry;
            entry = entry3;
        }
        return null;
    }

    public void reserveRoom(int i) {
        setCapacity((i * 5) / 3);
    }

    public void setCapacity(int i) {
        Entry[] entryArr = new Entry[i];
        for (Entry entry : this.table) {
            Entry entry2;
            while (entry2 != null) {
                long j = entry2.key;
                int i2 = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % i;
                Entry entry3 = entry2.next;
                entry2.next = entryArr[i2];
                entryArr[i2] = entry2;
                entry2 = entry3;
            }
        }
        this.table = entryArr;
        this.capacity = i;
        this.threshold = (i * 4) / 3;
    }

    public int size() {
        return this.size;
    }
}
