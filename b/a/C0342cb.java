package b.a;

import android.os.AsyncTask;

class C0342cb extends AsyncTask<Integer, Integer, C0347ce> {
    final /* synthetic */ bZ a;
    private C0344cc b;
    private C0341ca c;

    public C0342cb(bZ bZVar, C0344cc c0344cc, C0341ca c0341ca) {
        this.a = bZVar;
        this.b = c0344cc;
        this.c = c0341ca;
    }

    protected C0347ce a(Integer... numArr) {
        return this.a.a(this.b);
    }

    protected void a(C0347ce c0347ce) {
        if (this.c != null) {
            this.c.a(c0347ce);
        }
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return a((Integer[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((C0347ce) obj);
    }

    protected void onPreExecute() {
        if (this.c != null) {
            this.c.a();
        }
    }
}
