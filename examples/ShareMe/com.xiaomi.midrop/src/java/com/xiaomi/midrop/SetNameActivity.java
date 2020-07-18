/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.InputFilter
 *  android.text.Spanned
 *  android.text.TextWatcher
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.SetNameActivity;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.e;

public class SetNameActivity
extends com.xiaomi.midrop.util.Locale.a {
    private EditText a;
    private TextView b;
    private String c;
    private ImageView d;
    private View.OnClickListener e = new View.OnClickListener(this){
        final /* synthetic */ SetNameActivity a;
        {
            this.a = setNameActivity;
        }

        public void onClick(View view) {
            this.a.onBackPressed();
        }
    };

    static /* synthetic */ EditText a(SetNameActivity setNameActivity) {
        return setNameActivity.a;
    }

    static /* synthetic */ String a(SetNameActivity setNameActivity, String string2) {
        setNameActivity.c = string2;
        return string2;
    }

    static /* synthetic */ String b(SetNameActivity setNameActivity) {
        return setNameActivity.c;
    }

    static /* synthetic */ TextView c(SetNameActivity setNameActivity) {
        return setNameActivity.b;
    }

    static /* synthetic */ ImageView d(SetNameActivity setNameActivity) {
        return setNameActivity.d;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131427376);
        this.b = (TextView)this.findViewById(2131296695);
        this.b.setOnClickListener(new View.OnClickListener((SetNameActivity)this){
            final /* synthetic */ SetNameActivity a;
            {
                this.a = setNameActivity;
            }

            public void onClick(View view) {
                String string2 = SetNameActivity.a(this.a).getText().toString().trim();
                if (!android.text.TextUtils.equals((CharSequence)SetNameActivity.b(this.a), (CharSequence)string2)) {
                    e.a(string2);
                    SetNameActivity.a(this.a, string2);
                    android.util.Log.i((String)"SetNameActivity", (String)"name saved");
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.n).a();
                }
                this.a.finish();
            }
        });
        this.a = (EditText)this.findViewById(2131296744);
        this.c = e.a();
        this.a.setText((CharSequence)this.c);
        this.a.setSelection(this.a.length());
        EditText editText = this.a;
        InputFilter[] arrinputFilter = new InputFilter[]{new InputFilter(){
            private int a = 15;

            public final CharSequence filter(CharSequence charSequence, int n2, int n3, Spanned spanned, int n4, int n5) {
                int n6 = 0;
                int n7 = n2;
                int n8 = 0;
                do {
                    int n9 = 1;
                    if (n7 >= n3) break;
                    char c2 = charSequence.charAt(n7);
                    if (c2 >= '') {
                        n9 = c2 < '\u0800' ? 2 : 3;
                    }
                    n8 += n9;
                    ++n7;
                } while (true);
                int n10 = spanned.length();
                int n11 = 0;
                while (n6 < n10) {
                    if (n6 < n4 || n6 >= n5) {
                        char c3 = spanned.charAt(n6);
                        int n12 = c3 < '' ? 1 : (c3 < '\u0800' ? 2 : 3);
                        n11 += n12;
                    }
                    ++n6;
                }
                int n13 = this.a - n11;
                if (n13 <= 0) {
                    return "";
                }
                if (n13 >= n8) {
                    return null;
                }
                int n14 = n13;
                for (int i2 = n2; i2 < n3; ++i2) {
                    char c4 = charSequence.charAt(i2);
                    int n15 = c4 < '' ? 1 : (c4 < '\u0800' ? 2 : 3);
                    if ((n14 -= n15) >= 0) continue;
                    return charSequence.subSequence(n2, i2);
                }
                return null;
            }
        }};
        editText.setFilters(arrinputFilter);
        this.a.addTextChangedListener(new TextWatcher((SetNameActivity)this){
            final /* synthetic */ SetNameActivity a;
            {
                this.a = setNameActivity;
            }

            /*
             * Enabled aggressive block sorting
             */
            public final void afterTextChanged(android.text.Editable editable) {
                boolean bl;
                TextView textView;
                String string2 = editable.toString().trim();
                if (android.text.TextUtils.isEmpty((CharSequence)string2)) {
                    textView = SetNameActivity.c(this.a);
                    bl = false;
                } else {
                    textView = SetNameActivity.c(this.a);
                    bl = true;
                }
                textView.setEnabled(bl);
                SetNameActivity.d(this.a).setImageDrawable((Drawable)new com.xiaomi.midrop.a.a(string2));
            }

            public final void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public final void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }
        });
        this.d = (ImageView)this.findViewById(2131296484);
        this.d.setImageDrawable((Drawable)new com.xiaomi.midrop.a.a(this.c));
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.c(2131427429);
        View view = this.t();
        View view2 = view.findViewById(2131296485);
        if (ac.c((Context)this)) {
            view2.setRotation(180.0f);
        }
        view2.setOnClickListener(this.e);
        TextView textView = (TextView)view.findViewById(2131296810);
        textView.setText(b.a().a(2131689906));
        textView.setOnClickListener(this.e);
    }

}

