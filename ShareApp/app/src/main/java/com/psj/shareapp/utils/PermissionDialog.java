package com.psj.shareapp.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import com.google.android.material.snackbar.Snackbar;
import com.psj.shareapp.R;

class PermissionDialog {
    private PermissionDialog() {}
    public static boolean checkPerms(Context c)
    {
        int i=ContextCompat.checkSelfPermission(c,"android.permission.WRITE_EXTERNAL_STORAGE");
        if(
        return false;
    }

}
