package me.tung666.quickdialog.demo;

import android.view.View;

import me.tung666.quickdialog.AbsQuickDialog;

/**
 * Created by yedong on 16/10/11.
 */

public class CustomDialog extends AbsQuickDialog {

    @Override
    public int getContentViewId() {
        return R.layout.dialog_layout;
    }

    @Override
    public void bindView(AbsQuickDialog dialog, View v) {
        // do any thing you want
    }
}
