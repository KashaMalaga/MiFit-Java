package cn.com.smartdevices.bracelet.chart.typeface;

public abstract class e {
    public d a(String str) {
        for (d dVar : b()) {
            if (dVar.b().equals(str)) {
                return dVar;
            }
        }
        return null;
    }

    public abstract d[] b();
}
