package android.support.v4.k;

class n implements o {
    public static final n a = new n();

    private n() {
    }

    public int a(CharSequence charSequence, int i, int i2) {
        int i3 = i + i2;
        int i4 = 2;
        while (i < i3 && i4 == 2) {
            i4 = k.d(Character.getDirectionality(charSequence.charAt(i)));
            i++;
        }
        return i4;
    }
}
