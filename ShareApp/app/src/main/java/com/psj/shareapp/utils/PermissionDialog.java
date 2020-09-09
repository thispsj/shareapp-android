package com.psj.shareapp.utils;

import android.content.Context;

import androidx.core.content.ContextCompat;

class PermissionDialog {
    private PermissionDialog() {}
    public static boolean checkPerms(Context c)
    {
        int i=ContextCompat.checkSelfPermission(c,"android.permission.WRITE_EXTERNAL_STORAGE");
        return i == 0;
    }

}
