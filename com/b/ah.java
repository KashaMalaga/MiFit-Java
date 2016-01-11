package com.b;

import com.d.a.a.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ah {
    private static List<File> a = new ArrayList();
    private R b;
    private int c;

    private ah(File file, int i, long j) {
        this.c = i;
        this.b = R.a(file, i, 1, j);
    }

    public static synchronized ah a(File file, int i, long j) {
        ah ahVar;
        synchronized (ah.class) {
            if (a.contains(file)) {
                throw new IllegalStateException("Cache dir " + file.getAbsolutePath() + " was used before.");
            }
            a.add(file);
            ahVar = new ah(file, i, j);
        }
        return ahVar;
    }

    private Map<String, Serializable> a(V v) {
        ObjectInputStream objectInputStream;
        Throwable e;
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(v.a(0)));
            try {
                Map<String, Serializable> map = (Map) objectInputStream.readObject();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return map;
            } catch (ClassNotFoundException e2) {
                e = e2;
                try {
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    e = th;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw e;
                }
            }
        } catch (ClassNotFoundException e3) {
            e = e3;
            objectInputStream = null;
            throw new RuntimeException(e);
        } catch (Throwable th2) {
            e = th2;
            objectInputStream = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw e;
        }
    }

    private String b(String str) {
        return c(str);
    }

    private String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(h.DEFAULT_CHARSET));
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError();
        }
    }

    public OutputStream a(String str, Map<String, ? extends Serializable> map) {
        OutputStream outputStream = null;
        S b = this.b.b(b(str));
        if (b != null) {
            try {
                OutputStream objectOutputStream = new ObjectOutputStream(b.a(0));
                objectOutputStream.writeObject(map);
                outputStream = new aj(objectOutputStream, b, null);
            } catch (IOException e) {
                b.b();
                throw e;
            }
        }
        return outputStream;
    }

    public Map<String, Serializable> a(String str) {
        V a = this.b.a(b(str));
        if (a == null) {
            return null;
        }
        try {
            Map<String, Serializable> a2 = a(a);
            return a2;
        } finally {
            a.close();
        }
    }

    public void a() {
        try {
            if (a != null) {
                a.clear();
            }
            if (this.b != null) {
                this.b.close();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b(String str, Map<String, ? extends Serializable> map) {
        OutputStream outputStream = null;
        try {
            outputStream = a(str, map);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
