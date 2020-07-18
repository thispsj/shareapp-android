/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.yalantis.ucrop.UCropFragment
 *  java.lang.Object
 */
package com.yalantis.ucrop;

import com.yalantis.ucrop.UCropFragment;

public interface UCropFragmentCallback {
    public void loadingProgress(boolean var1);

    public void onCropFinish(UCropFragment.UCropResult var1);
}

