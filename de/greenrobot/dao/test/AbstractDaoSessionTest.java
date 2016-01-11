package de.greenrobot.dao.test;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;

public abstract class AbstractDaoSessionTest<T extends AbstractDaoMaster, S extends AbstractDaoSession> extends DbTest {
    protected T daoMaster;
    private final Class<T> daoMasterClass;
    protected S daoSession;

    public AbstractDaoSessionTest(Class<T> cls) {
        this(cls, true);
    }

    public AbstractDaoSessionTest(Class<T> cls, boolean z) {
        super(z);
        this.daoMasterClass = cls;
    }

    protected void setUp() {
        super.setUp();
        try {
            this.daoMaster = (AbstractDaoMaster) this.daoMasterClass.getConstructor(new Class[]{SQLiteDatabase.class}).newInstance(new Object[]{this.db});
            this.daoMasterClass.getMethod("createAllTables", new Class[]{SQLiteDatabase.class, Boolean.TYPE}).invoke(null, new Object[]{this.db, Boolean.valueOf(false)});
            this.daoSession = this.daoMaster.newSession();
        } catch (Throwable e) {
            throw new RuntimeException("Could not prepare DAO session test", e);
        }
    }
}
