/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 */
package com.yalantis.ucrop.model;

public class ExifInfo {
    private int mExifDegrees;
    private int mExifOrientation;
    private int mExifTranslation;

    public ExifInfo(int n2, int n3, int n4) {
        this.mExifOrientation = n2;
        this.mExifDegrees = n3;
        this.mExifTranslation = n4;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            ExifInfo exifInfo = (ExifInfo)object;
            if (this.mExifOrientation != exifInfo.mExifOrientation) {
                return false;
            }
            if (this.mExifDegrees != exifInfo.mExifDegrees) {
                return false;
            }
            if (this.mExifTranslation == exifInfo.mExifTranslation) {
                return true;
            }
        }
        return false;
    }

    public int getExifDegrees() {
        return this.mExifDegrees;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public int getExifTranslation() {
        return this.mExifTranslation;
    }

    public int hashCode() {
        return 31 * (31 * this.mExifOrientation + this.mExifDegrees) + this.mExifTranslation;
    }

    public void setExifDegrees(int n2) {
        this.mExifDegrees = n2;
    }

    public void setExifOrientation(int n2) {
        this.mExifOrientation = n2;
    }

    public void setExifTranslation(int n2) {
        this.mExifTranslation = n2;
    }
}

