package me.tung666.quickdialog;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.view.View;

/**
 * Created by yedong on 18/11/30.
 */

public class QuickDialog extends AbsQuickDialog {

    private static final String KEY_LAYOUT_RES = "bottom_layout_res";
    private static final String KEY_HEIGHT = "bottom_height";
    private static final String KEY_DIM = "bottom_dim";
    private static final String KEY_CANCEL_OUTSIDE = "bottom_cancel_outside";

    private FragmentManager mFragmentManager;

    private boolean mIsCancelOutside = super.getCancelOutside();

    private String mTag = super.getFragmentTag();

    private float mDimAmount = super.getDimAmount();

    private int mHeight = super.getHeight();

    @LayoutRes
    private int mViewId;

    private View mContent;

    private int mGravity;

    private ViewListener mViewListener;

    public static QuickDialog create(FragmentManager manager) {
        QuickDialog dialog = new QuickDialog();
        dialog.setFragmentManager(manager);
        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mViewId = savedInstanceState.getInt(KEY_LAYOUT_RES);
            mHeight = savedInstanceState.getInt(KEY_HEIGHT);
            mDimAmount = savedInstanceState.getFloat(KEY_DIM);
            mIsCancelOutside = savedInstanceState.getBoolean(KEY_CANCEL_OUTSIDE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_LAYOUT_RES, mViewId);
        outState.putInt(KEY_HEIGHT, mHeight);
        outState.putFloat(KEY_DIM, mDimAmount);
        outState.putBoolean(KEY_CANCEL_OUTSIDE, mIsCancelOutside);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void bindView(AbsQuickDialog dialog, View v) {
        if (mViewListener != null) {
            mViewListener.bindView(this, v);
        }
    }

    @Override
    public int getContentViewId() {
        return mViewId;
    }

    public QuickDialog setContentViewId(@LayoutRes int viewId) {
        mViewId = viewId;
        return this;
    }

    @Override
    public View getContentView() {
        return mContent;
    }

    public QuickDialog setContentView(View content) {
        mContent = content;
        return this;
    }

    public QuickDialog setFragmentManager(FragmentManager manager) {
        mFragmentManager = manager;
        return this;
    }

    public QuickDialog setViewListener(ViewListener listener) {
        mViewListener = listener;
        return this;
    }

    public QuickDialog setTag(String tag) {
        mTag = tag;
        return this;
    }

    public QuickDialog setGravity(int gravity) {
        mGravity = gravity;
        return this;
    }

    @Override
    public float getDimAmount() {
        return mDimAmount;
    }

    public QuickDialog setDimAmount(float dim) {
        mDimAmount = dim;
        return this;
    }

    @Override
    public int getHeight() {
        return mHeight;
    }

    public QuickDialog setHeight(int heightPx) {
        mHeight = heightPx;
        return this;
    }

    @Override
    public boolean getCancelOutside() {
        return mIsCancelOutside;
    }

    public QuickDialog setCancelOutside(boolean cancel) {
        mIsCancelOutside = cancel;
        return this;
    }

    @Override
    public String getFragmentTag() {
        return mTag;
    }

    public AbsQuickDialog show() {
        show(mFragmentManager);
        return this;
    }

    public interface ViewListener {
        void bindView(AbsQuickDialog dialog, View v);
    }
}
