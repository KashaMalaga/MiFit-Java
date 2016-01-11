package de.greenrobot.dao.query;

import android.os.Process;
import android.util.SparseArray;
import de.greenrobot.dao.AbstractDao;
import java.lang.ref.WeakReference;

abstract class AbstractQueryData<T, Q extends AbstractQuery<T>> {
    final AbstractDao<T, ?> dao;
    final String[] initialValues;
    final SparseArray<WeakReference<Q>> queriesForThreads = new SparseArray();
    final String sql;

    AbstractQueryData(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.dao = abstractDao;
        this.sql = str;
        this.initialValues = strArr;
    }

    protected abstract Q createQuery();

    Q forCurrentThread() {
        Q q;
        int myTid = Process.myTid();
        synchronized (this.queriesForThreads) {
            WeakReference weakReference = (WeakReference) this.queriesForThreads.get(myTid);
            q = weakReference != null ? (AbstractQuery) weakReference.get() : null;
            if (q == null) {
                gc();
                q = createQuery();
                this.queriesForThreads.put(myTid, new WeakReference(q));
            } else {
                System.arraycopy(this.initialValues, 0, q.parameters, 0, this.initialValues.length);
            }
        }
        return q;
    }

    Q forCurrentThread(Q q) {
        if (Thread.currentThread() != q.ownerThread) {
            return forCurrentThread();
        }
        System.arraycopy(this.initialValues, 0, q.parameters, 0, this.initialValues.length);
        return q;
    }

    void gc() {
        synchronized (this.queriesForThreads) {
            for (int size = this.queriesForThreads.size() - 1; size >= 0; size--) {
                if (((WeakReference) this.queriesForThreads.valueAt(size)).get() == null) {
                    this.queriesForThreads.remove(this.queriesForThreads.keyAt(size));
                }
            }
        }
    }
}
