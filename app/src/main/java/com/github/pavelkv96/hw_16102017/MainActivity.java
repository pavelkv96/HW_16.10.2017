package com.github.pavelkv96.hw_16102017;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final VersionChecker checker = new VersionChecker();
                if (!checker.isCorrectVersion()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                            VersionDialog(alertDialogBuilder, checker);
                        }
                    });
                }

            }
        }).start();
    }

    void VersionDialog(AlertDialog.Builder alertDialogBuilder, VersionChecker checker) {
        if (checker.isForceUpdate()) {
            alertDialogBuilder
                    .setTitle("Necessary to update")
                    .setMessage("You should update your application here: " + BuildConfig.UPDATE_URL);
        } else {
            alertDialogBuilder
                    .setTitle("You want to update?")
                    .setMessage("Do you want to update application? ")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, final int id) {
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, final int id) {
                            dialog.cancel();
                        }
                    });
        }
        alertDialogBuilder
                .setCancelable(false)
                .create()
                .show();
    }
}
