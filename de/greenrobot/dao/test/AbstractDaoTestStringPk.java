package de.greenrobot.dao.test;

import de.greenrobot.dao.AbstractDao;

public abstract class AbstractDaoTestStringPk<D extends AbstractDao<T, String>, T> extends AbstractDaoTestSinglePk<D, T, String> {
    public AbstractDaoTestStringPk(Class<D> cls) {
        super(cls);
    }

    protected String createRandomPk() {
        int nextInt = this.random.nextInt(30) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nextInt; i++) {
            stringBuilder.append((char) (this.random.nextInt(25) + 97));
        }
        return stringBuilder.toString();
    }
}
