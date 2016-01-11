package com.huami.android.view;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huami.android.ui.a;
import com.xiaomi.hm.health.a.f;
import com.xiaomi.hm.health.a.i;

public class c extends DialogFragment implements OnClickListener {
    protected boolean mCanceled = true;
    protected boolean mCanceledOnTouchOutside = true;
    protected TextView mLeftButton;
    private e mListener = null;
    protected TextView mRightButton;

    public static void showPanel(Activity activity, DialogFragment dialogFragment) {
        dialogFragment.show(activity.getFragmentManager().beginTransaction(), null);
    }

    public static void showPanel(Activity activity, DialogFragment dialogFragment, Bundle bundle) {
        FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
        dialogFragment.setArguments(bundle);
        dialogFragment.show(beginTransaction, null);
    }

    public static void showPanel(Activity activity, Class<? extends Fragment> cls) {
        try {
            ((DialogFragment) Fragment.instantiate(activity, cls.getName())).show(activity.getFragmentManager().beginTransaction(), cls.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showPanel(Activity activity, Class<? extends DialogFragment> cls, Bundle bundle) {
        ((DialogFragment) Fragment.instantiate(activity, cls.getName(), bundle)).show(activity.getFragmentManager().beginTransaction(), cls.getName());
    }

    public TextView getRightButton() {
        return this.mRightButton;
    }

    protected int inflateLayout() {
        return 0;
    }

    public void onClick(View view) {
        if (view.getId() == f.left_button) {
            onLeftButtonClicked();
        } else if (view.getId() == f.right_button) {
            onRightButtonClicked();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = i.DimPanel;
        if (a.b(getActivity())) {
            i = i.DimPanelTint;
        }
        setStyle(0, i);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(inflateLayout(), viewGroup, false);
        this.mLeftButton = (TextView) inflate.findViewById(f.left_button);
        this.mRightButton = (TextView) inflate.findViewById(f.right_button);
        if (this.mLeftButton != null) {
            this.mLeftButton.setOnClickListener(this);
        }
        if (this.mRightButton != null) {
            this.mRightButton.setOnClickListener(this);
        }
        getDialog().setCanceledOnTouchOutside(this.mCanceledOnTouchOutside);
        getDialog().setCancelable(this.mCanceled);
        View findViewById = inflate.findViewById(f.dlg_empty_area_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new d(this));
        }
        inflate.setFitsSystemWindows(true);
        return inflate;
    }

    protected void onEmptyAreaClicked() {
        if (this.mListener != null) {
            this.mListener.a(this);
        }
        dismissAllowingStateLoss();
    }

    protected void onLeftButtonClicked() {
        if (this.mListener != null) {
            this.mListener.b(this);
        } else {
            dismissAllowingStateLoss();
        }
    }

    protected void onRightButtonClicked() {
        if (this.mListener != null) {
            this.mListener.c(this);
        }
    }

    public void setCanceled(boolean z) {
        this.mCanceled = z;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mCanceledOnTouchOutside = z;
    }

    public void setOpClickListener(e eVar) {
        this.mListener = eVar;
    }

    public void showPanel(FragmentManager fragmentManager) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, null);
        beginTransaction.commitAllowingStateLoss();
    }
}
