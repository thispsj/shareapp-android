/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.preference.CheckBoxPreference
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.CheckedTextView
 */
package com.xiaomi.miftp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckedTextView;
import com.xiaomi.miftp.R;

public class RadioButtonPreference
extends CheckBoxPreference {
    public RadioButtonPreference(Context context) {
        super(context, null);
    }

    public RadioButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.radioButtonPreferenceStyle);
    }

    public RadioButtonPreference(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.RadioButtonPreference, n2, 0);
        int n3 = typedArray.getResourceId(R.styleable.RadioButtonPreference_android_layout, R.layout.preference_radiobutton);
        int n4 = typedArray.getResourceId(R.styleable.RadioButtonPreference_android_widgetLayout, 0);
        typedArray.recycle();
        if (this.getLayoutResource() != n3) {
            this.setLayoutResource(R.layout.preference_radiobutton);
        }
        if (this.getWidgetLayoutResource() != n4) {
            this.setWidgetLayoutResource(0);
        }
    }

    protected void onBindView(View view) {
        View view2;
        super.onBindView(view);
        View view3 = view.findViewById(16908310);
        if (view3 != null && view3 instanceof CheckedTextView) {
            CheckedTextView checkedTextView = (CheckedTextView)view3;
            checkedTextView.setCheckMarkDrawable(0);
            checkedTextView.setChecked(this.isChecked());
        }
        if ((view2 = view.findViewById(16908289)) != null) {
            view2.setImportantForAccessibility(2);
        }
    }
}

