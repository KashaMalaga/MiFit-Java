package b.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class C0376dm extends C0375do {
    protected InputStream a = null;
    protected OutputStream b = null;

    protected C0376dm() {
    }

    public C0376dm(InputStream inputStream) {
        this.a = inputStream;
    }

    public C0376dm(InputStream inputStream, OutputStream outputStream) {
        this.a = inputStream;
        this.b = outputStream;
    }

    public C0376dm(OutputStream outputStream) {
        this.b = outputStream;
    }

    public int a(byte[] bArr, int i, int i2) {
        if (this.a == null) {
            throw new C0378dp(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new C0378dp(4);
        } catch (Throwable e) {
            throw new C0378dp(0, e);
        }
    }

    public boolean a() {
        return true;
    }

    public void b() {
    }

    public void b(byte[] bArr, int i, int i2) {
        if (this.b == null) {
            throw new C0378dp(1, "Cannot write to null outputStream");
        }
        try {
            this.b.write(bArr, i, i2);
        } catch (Throwable e) {
            throw new C0378dp(0, e);
        }
    }

    public void c() {
        if (this.a != null) {
            try {
                this.a.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.a = null;
        }
        if (this.b != null) {
            try {
                this.b.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.b = null;
        }
    }

    public void d() {
        if (this.b == null) {
            throw new C0378dp(1, "Cannot flush null outputStream");
        }
        try {
            this.b.flush();
        } catch (Throwable e) {
            throw new C0378dp(0, e);
        }
    }
}
