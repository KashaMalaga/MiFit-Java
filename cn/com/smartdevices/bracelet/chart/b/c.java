package cn.com.smartdevices.bracelet.chart.b;

import android.os.AsyncTask;

class c extends AsyncTask<Integer, Void, e> {
    final /* synthetic */ a a;

    private c(a aVar) {
        this.a = aVar;
    }

    protected e a(Integer... numArr) {
        e b = this.a.a.b(numArr[0].intValue());
        b.g = numArr[0].intValue();
        this.a.b.put(numArr[0].intValue(), b);
        return b;
    }

    protected void a(e eVar) {
        this.a.a.a(eVar);
        this.a.e.remove(this);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Integer[]) objArr);
    }

    protected void onCancelled() {
        this.a.e.remove(this);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((e) obj);
    }
}
