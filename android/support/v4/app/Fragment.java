package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.a.r;
import android.support.v4.l.f;
import android.support.v4.l.u;
import android.support.v4.view.a.C0113o;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kankan.wheel.widget.a;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    private static final u<String, Class<?>> sClassMap = new u();
    FragmentActivity mActivity;
    boolean mAdded;
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    U mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    Object mEnterTransition = null;
    cn mEnterTransitionCallback = null;
    Object mExitTransition = null;
    cn mExitTransitionCallback = null;
    int mFragmentId;
    U mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mInLayout;
    int mIndex = -1;
    View mInnerView;
    aA mLoaderManager;
    boolean mLoadersStarted;
    boolean mMenuVisible = true;
    int mNextAnim;
    Fragment mParentFragment;
    Object mReenterTransition = USE_DEFAULT_TRANSITION;
    boolean mRemoving;
    boolean mRestored;
    boolean mResumed;
    boolean mRetainInstance;
    boolean mRetaining;
    Object mReturnTransition = USE_DEFAULT_TRANSITION;
    Bundle mSavedFragmentState;
    SparseArray<Parcelable> mSavedViewState;
    Object mSharedElementEnterTransition = null;
    Object mSharedElementReturnTransition = USE_DEFAULT_TRANSITION;
    int mState = INITIALIZING;
    int mStateAfterAnimating;
    String mTag;
    Fragment mTarget;
    int mTargetIndex = -1;
    int mTargetRequestCode;
    boolean mUserVisibleHint = true;
    View mView;
    String mWho;

    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new M();
        final Bundle a;

        SavedState(Bundle bundle) {
            this.a = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readBundle();
            if (classLoader != null && this.a != null) {
                this.a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return Fragment.INITIALIZING;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.a);
        }
    }

    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) sClassMap.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                sClassMap.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.mArguments = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new L("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new L("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new L("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean isSupportFragmentClass(Context context, String str) {
        try {
            Class cls = (Class) sClassMap.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                sClassMap.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mIndex=");
        printWriter.print(this.mIndex);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mRetaining=");
        printWriter.print(this.mRetaining);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mActivity != null) {
            printWriter.print(str);
            printWriter.print("mActivity=");
            printWriter.println(this.mActivity);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mTarget != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.mTarget);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (this.mNextAnim != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.mNextAnim);
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (this.mAnimatingAway != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.mAnimatingAway);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.mStateAfterAnimating);
        }
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.mLoaderManager.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.mChildFragmentManager != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.mChildFragmentManager + a.ci);
            this.mChildFragmentManager.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager != null ? this.mChildFragmentManager.b(str) : null;
    }

    public final FragmentActivity getActivity() {
        return this.mActivity;
    }

    public boolean getAllowEnterTransitionOverlap() {
        return this.mAllowEnterTransitionOverlap == null ? true : this.mAllowEnterTransitionOverlap.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        return this.mAllowReturnTransitionOverlap == null ? true : this.mAllowReturnTransitionOverlap.booleanValue();
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final R getChildFragmentManager() {
        if (this.mChildFragmentManager == null) {
            instantiateChildFragmentManager();
            if (this.mState >= RESUMED) {
                this.mChildFragmentManager.r();
            } else if (this.mState >= STARTED) {
                this.mChildFragmentManager.q();
            } else if (this.mState >= ACTIVITY_CREATED) {
                this.mChildFragmentManager.p();
            } else if (this.mState >= CREATED) {
                this.mChildFragmentManager.o();
            }
        }
        return this.mChildFragmentManager;
    }

    public Object getEnterTransition() {
        return this.mEnterTransition;
    }

    public Object getExitTransition() {
        return this.mExitTransition;
    }

    public final R getFragmentManager() {
        return this.mFragmentManager;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        LayoutInflater cloneInContext = this.mActivity.getLayoutInflater().cloneInContext(this.mActivity);
        getChildFragmentManager();
        cloneInContext.setFactory(this.mChildFragmentManager.y());
        return cloneInContext;
    }

    public ay getLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        if (this.mActivity == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = this.mActivity.a(this.mWho, this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public Object getReenterTransition() {
        return this.mReenterTransition == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mReenterTransition;
    }

    public final Resources getResources() {
        if (this.mActivity != null) {
            return this.mActivity.getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        return this.mReturnTransition == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mReturnTransition;
    }

    public Object getSharedElementEnterTransition() {
        return this.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        return this.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : this.mSharedElementReturnTransition;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final Fragment getTargetFragment() {
        return this.mTarget;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @r
    public View getView() {
        return this.mView;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        this.mIndex = -1;
        this.mWho = null;
        this.mAdded = false;
        this.mRemoving = false;
        this.mResumed = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = INITIALIZING;
        this.mFragmentManager = null;
        this.mChildFragmentManager = null;
        this.mActivity = null;
        this.mFragmentId = INITIALIZING;
        this.mContainerId = INITIALIZING;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
        this.mRetaining = false;
        this.mLoaderManager = null;
        this.mLoadersStarted = false;
        this.mCheckedForLoaderManager = false;
    }

    void instantiateChildFragmentManager() {
        this.mChildFragmentManager = new U();
        this.mChildFragmentManager.a(this.mActivity, new K(this), this);
    }

    public final boolean isAdded() {
        return this.mActivity != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mResumed;
    }

    public final boolean isVisible() {
        return (!isAdded() || isHidden() || this.mView == null || this.mView.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void onActivityCreated(@r Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        getActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, @r ViewGroup viewGroup, @r Bundle bundle) {
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
        if (!this.mCheckedForLoaderManager) {
            this.mCheckedForLoaderManager = true;
            this.mLoaderManager = this.mActivity.a(this.mWho, this.mLoadersStarted, false);
        }
        if (this.mLoaderManager != null) {
            this.mLoaderManager.h();
        }
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mActivity.a(this.mWho, this.mLoadersStarted, false);
            }
            if (this.mLoaderManager != null) {
                this.mLoaderManager.b();
            }
        }
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, @r Bundle bundle) {
    }

    public void onViewStateRestored(@r Bundle bundle) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.n();
        }
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new co("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.p();
        }
    }

    void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.a(configuration);
        }
    }

    boolean performContextItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (onContextItemSelected(menuItem)) {
                return true;
            }
            if (this.mChildFragmentManager != null && this.mChildFragmentManager.b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void performCreate(Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.n();
        }
        this.mCalled = false;
        onCreate(bundle);
        if (!this.mCalled) {
            throw new co("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.mChildFragmentManager == null) {
                    instantiateChildFragmentManager();
                }
                this.mChildFragmentManager.a(parcelable, null);
                this.mChildFragmentManager.o();
            }
        }
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return this.mChildFragmentManager != null ? z | this.mChildFragmentManager.a(menu, menuInflater) : z;
    }

    View performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.n();
        }
        return onCreateView(layoutInflater, viewGroup, bundle);
    }

    void performDestroy() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.w();
        }
        this.mCalled = false;
        onDestroy();
        if (!this.mCalled) {
            throw new co("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    void performDestroyView() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.v();
        }
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new co("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.mLoaderManager != null) {
            this.mLoaderManager.f();
        }
    }

    void performLowMemory() {
        onLowMemory();
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.x();
        }
    }

    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
                return true;
            }
            if (this.mChildFragmentManager != null && this.mChildFragmentManager.a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.b(menu);
            }
        }
    }

    void performPause() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.s();
        }
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new co("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return this.mChildFragmentManager != null ? z | this.mChildFragmentManager.a(menu) : z;
    }

    void performReallyStop() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.u();
        }
        if (this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mActivity.a(this.mWho, this.mLoadersStarted, false);
            }
            if (this.mLoaderManager == null) {
                return;
            }
            if (this.mActivity.k) {
                this.mLoaderManager.d();
            } else {
                this.mLoaderManager.c();
            }
        }
    }

    void performResume() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.n();
            this.mChildFragmentManager.j();
        }
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new co("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.r();
            this.mChildFragmentManager.j();
        }
    }

    void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        if (this.mChildFragmentManager != null) {
            Parcelable m = this.mChildFragmentManager.m();
            if (m != null) {
                bundle.putParcelable("android:support:fragments", m);
            }
        }
    }

    void performStart() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.n();
            this.mChildFragmentManager.j();
        }
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.q();
            }
            if (this.mLoaderManager != null) {
                this.mLoaderManager.g();
                return;
            }
            return;
        }
        throw new co("Fragment " + this + " did not call through to super.onStart()");
    }

    void performStop() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.t();
        }
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new co("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    final void restoreViewState(Bundle bundle) {
        if (this.mSavedViewState != null) {
            this.mInnerView.restoreHierarchyState(this.mSavedViewState);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new co("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        this.mAllowEnterTransitionOverlap = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        this.mAllowReturnTransitionOverlap = Boolean.valueOf(z);
    }

    public void setArguments(Bundle bundle) {
        if (this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(cn cnVar) {
        this.mEnterTransitionCallback = cnVar;
    }

    public void setEnterTransition(Object obj) {
        this.mEnterTransition = obj;
    }

    public void setExitSharedElementCallback(cn cnVar) {
        this.mExitTransitionCallback = cnVar;
    }

    public void setExitTransition(Object obj) {
        this.mExitTransition = obj;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                this.mActivity.g();
            }
        }
    }

    final void setIndex(int i, Fragment fragment) {
        this.mIndex = i;
        if (fragment != null) {
            this.mWho = fragment.mWho + a.ci + this.mIndex;
        } else {
            this.mWho = "android:fragment:" + this.mIndex;
        }
    }

    public void setInitialSavedState(SavedState savedState) {
        if (this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle = (savedState == null || savedState.a == null) ? null : savedState.a;
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mActivity.g();
            }
        }
    }

    public void setReenterTransition(Object obj) {
        this.mReenterTransition = obj;
    }

    public void setRetainInstance(boolean z) {
        if (!z || this.mParentFragment == null) {
            this.mRetainInstance = z;
            return;
        }
        throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
    }

    public void setReturnTransition(Object obj) {
        this.mReturnTransition = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        this.mSharedElementEnterTransition = obj;
    }

    public void setSharedElementReturnTransition(Object obj) {
        this.mSharedElementReturnTransition = obj;
    }

    public void setTargetFragment(Fragment fragment, int i) {
        this.mTarget = fragment;
        this.mTargetRequestCode = i;
    }

    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < STARTED) {
            this.mFragmentManager.b(this);
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = !z;
    }

    public void startActivity(Intent intent) {
        if (this.mActivity == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mActivity.a(this, intent, -1);
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.mActivity == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mActivity.a(this, intent, i);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(C0113o.h);
        f.a(this, stringBuilder);
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mTag);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }
}
