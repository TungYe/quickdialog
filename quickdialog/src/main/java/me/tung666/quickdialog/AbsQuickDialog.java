package me.tung666.quickdialog;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by yedong on 18/11/30.
 */

public abstract class AbsQuickDialog extends DialogFragment {

    private static final String TAG = "BaseQuickDialog";

    private static final float DEFAULT_DIM = 0.3f;
    private static final int DEFAULT_GRAVITY = Gravity.BOTTOM;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.YdQuickDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(getCancelOutside());
        View v;
        if (getContentViewId() != 0) {
            v = inflater.inflate(getContentViewId(), container, false);
        } else if (getContentView() != null) {
            v = getContentView();
        } else {
            throw new RuntimeException("you must set the dialog content by getContentViewId or getContentView");
        }
        bindView(this, v);
        return v;
    }

    @LayoutRes
    public abstract int getContentViewId();

    public View getContentView() {
        return null;
    }

    public abstract void bindView(AbsQuickDialog dialog, View v);

    @Override
    public void onStart() {
        super.onStart();

        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();

        params.dimAmount = getDimAmount();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        if (getHeight() > 0) {
            params.height = getHeight();
        } else {
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        }
        params.gravity = getGravity();

        window.setAttributes(params);
    }

    public int getHeight() {
        return -1;
    }

    public float getDimAmount() {
        return DEFAULT_DIM;
    }

    public int getGravity() {
        return DEFAULT_GRAVITY;
    }

    public boolean getCancelOutside() {
        return true;
    }

    public String getFragmentTag() {
        return TAG;
    }

    public void show(FragmentManager fragmentManager) {
        show(fragmentManager, getFragmentTag());
    }
}
