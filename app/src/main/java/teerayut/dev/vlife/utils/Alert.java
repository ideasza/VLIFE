package teerayut.dev.vlife.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import cn.pedant.SweetAlert.SweetAlertDialog;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.authentication.AuthenticationActivity;

/**
 * Created by OzoeSK on 7/5/2017.
 */

public class Alert {

    public static void dialogError(Context context, int msgID) {
        new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(context.getResources().getString(R.string.dialog_title_error))
                .setContentText(context.getResources().getString(msgID))
                .setCancelText(context.getResources().getString(R.string.dialog_btn_ok))
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false);
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
                        ((AuthenticationActivity)context).finish();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog dialog) {
                        dialog.dismiss();
                        Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                        ((AuthenticationActivity)context).startActivityForResult(intent, Config.REQUEST_SETTINGS);
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
