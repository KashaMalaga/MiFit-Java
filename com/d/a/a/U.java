package com.d.a.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class U implements Serializable {
    private static final long serialVersionUID = 6374381828722046732L;
    private final transient Cookie a;
    private transient BasicClientCookie b;

    public U(Cookie cookie) {
        this.a = cookie;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.b = new BasicClientCookie((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        this.b.setComment((String) objectInputStream.readObject());
        this.b.setDomain((String) objectInputStream.readObject());
        this.b.setExpiryDate((Date) objectInputStream.readObject());
        this.b.setPath((String) objectInputStream.readObject());
        this.b.setVersion(objectInputStream.readInt());
        this.b.setSecure(objectInputStream.readBoolean());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.a.getName());
        objectOutputStream.writeObject(this.a.getValue());
        objectOutputStream.writeObject(this.a.getComment());
        objectOutputStream.writeObject(this.a.getDomain());
        objectOutputStream.writeObject(this.a.getExpiryDate());
        objectOutputStream.writeObject(this.a.getPath());
        objectOutputStream.writeInt(this.a.getVersion());
        objectOutputStream.writeBoolean(this.a.isSecure());
    }

    public Cookie a() {
        return this.b != null ? this.b : this.a;
    }
}
