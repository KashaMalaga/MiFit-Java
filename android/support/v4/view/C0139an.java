package android.support.v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

class C0139an extends SingleLineTransformationMethod {
    private static final String a = "SingleLineAllCapsTransform";
    private Locale b;

    public C0139an(Context context) {
        this.b = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        CharSequence transformation = super.getTransformation(charSequence, view);
        return transformation != null ? transformation.toString().toUpperCase(this.b) : null;
    }
}
