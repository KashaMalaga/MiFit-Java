package cn.com.smartdevices.bracelet.shoes.sync;

enum T {
    NONE(-1),
    ERROR(0),
    OK(1);
    
    private int d;

    private T(int i) {
        this.d = -1;
        this.d = i;
    }

    public int a() {
        return this.d;
    }
}
