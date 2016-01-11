package a.a.a;

import java.nio.ByteBuffer;

class z implements C0000H {
    final /* synthetic */ A a;
    final /* synthetic */ y b;

    z(y yVar, A a) {
        this.b = yVar;
        this.a = a;
    }

    public void a(int i, byte[] bArr) {
        if (i == 4 && bArr != null && bArr.length == 4) {
            this.a.a(ByteBuffer.wrap(bArr).getInt());
        }
    }
}
