package teerayut.dev.vlife.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import cn.pedant.SweetAlert.SweetAlertDialog;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.main.MainActivity;

/**
 * Created by OzoeSK on 7/5/2017.
 */

public class Alert {

    public static void dialogError(Context context, int msgID) {
        sweetAlertDialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setTitleText(context.getResources().getString(R.string.dialog_title_error));
        sweetAlertDialog.setContentText(context.getResources().getString(msgID));
        //sweetAlertDialog.setCancelText(context.getResources().getString(R.string.dialog_btn_ok));
        sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog dialog) {
                        dialog.dismiss();
                    }
                });
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.show();
    }

    public static void dialogChooser(final Activity context, int title, int msg, int cancelButton, int confirmButton,
                                     final Intent intent1, final int result1, final Intent intent2, final int result2) {
        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(context.getResources().getString(title))
                .setContentText(context.getResources().getString(msg))
                .setCancelText(context.getResources().getString(cancelButton))
                .setConfirmText(context.getResources().getString(confirmButton))
                .showCancelButton(false)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismiss();
                        context.startActivityForResult(intent1, result1);
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        context.startActivityForResult(intent2, result2);
                    }
                })
                .show();
    }

    public static void dialogSuccess(final Context context, int msgID, final Intent intent) {
        sweetAlertDialog = new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog.setTitleText(context.getResources().getString(R.string.dialog_title_success));
        sweetAlertDialog.setContentText(context.getResources().getString(R.string.dialog_msg_apply_success));
        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();
                context.startActivity(intent);
            }
        });
        sweetAlertDialog.setConfirmText(context.getResources().getString(R.string.dialog_btn_ok));
        sweetAlertDialog.show();
    }

    public static void dialogNetworkWarning(final Context context) {
        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(context.getResources().getString(R.string.dialog_title_error))
                .setContentText(context.getResources().getString(R.string.dialog_msg_network_error))
                .setCancelText(context.getResources().getString(R.string.dialog_btn_cancel))
                .setConfirmText(context.getResources().getString(R.string.dialog_btn_settings))
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog dialog) {
                        dialog.dismiss();
                        ((MainActivity)context).finish();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog dialog) {
                        dialog.dismiss();
                        Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                        ((MainActivity)context).startActivityForResult(intent, Config.REQUEST_SETTINGS);
                    }
                })
                .show();
    }

    private static SweetAlertDialog sweetAlertDialog;
    public static void dialogLoading(final Context context) {
        sweetAlertDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        sweetAlertDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.colorPrimaryDark));
        sweetAlertDialog.setTitleText("Loading...");
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.show();
    }

    public static void dialogDimiss() {
        sweetAlertDialog.dismiss();
    }
}
