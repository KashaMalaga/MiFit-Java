package cn.com.smartdevices.bracelet.gps.services;

public final class ap {
    public int a = -1;
    public long b = -1;
    public int c = -1;
    public int d = -1;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mTotalRtStep:").append(this.a).append(",mTotalRtStepSpan:").append(this.b).append(",mTotalMinutesStep:").append(this.c).append(",mTotalMinutesforefootStep:").append(this.d);
        return stringBuilder.toString();
    }
}
