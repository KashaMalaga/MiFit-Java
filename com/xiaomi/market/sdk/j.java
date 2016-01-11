package com.xiaomi.market.sdk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class j extends n {
    final /* synthetic */ h a;
    private File d;

    public j(h hVar, File file) {
        this.a = hVar;
        super(hVar, new FileOutputStream(file));
        this.d = file;
    }

    public void a() {
        try {
            this.b.close();
        } catch (IOException e) {
        }
        this.d.delete();
        try {
            this.b = new FileOutputStream(this.d);
        } catch (FileNotFoundException e2) {
        }
    }
}
