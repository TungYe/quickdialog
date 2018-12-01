package me.tung666.quickdialog.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.tung666.quickdialog.AbsQuickDialog;
import me.tung666.quickdialog.QuickDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();

            }
        });
    }

    private void showDialog() {
        QuickDialog.create(getSupportFragmentManager())
                .setViewListener(new QuickDialog.ViewListener() {
                    @Override
                    public void bindView(AbsQuickDialog dialog, View v) {
                        initView(v);
                    }
                })
                .setContentViewId(R.layout.dialog_layout)
                .setDimAmount(0.5f)
                .setTag("dialog")
                .show();
    }

    private void initView(final View view) {

    }
}
