/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  android.support.v4.app.a
 *  android.support.v4.content.FileProvider
 *  android.support.v7.app.c
 *  android.support.v7.widget.GridLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$i
 *  android.support.v7.widget.RecyclerView$w
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  android.widget.Toast
 *  com.xiaomi.midrop.profile.ProfileSettingActivity$ProfileIconAdapter
 *  com.xiaomi.midrop.profile.ProfileSettingActivity$ProfileIconAdapter$ViewHolder
 *  com.xiaomi.midrop.profile.ProfileSettingActivity$initView
 *  com.xiaomi.midrop.profile.ProfileSettingActivity$onBackPressed
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.profile;

import a.e.b.f;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.R;
import com.xiaomi.midrop.profile.ProfileSettingActivity;
import com.xiaomi.midrop.profile.a;
import com.xiaomi.midrop.send.FilePickNewActivity;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.y;
import com.xiaomi.midrop.view.AutoPressedStyleImageView;
import com.xiaomi.midrop.view.ProfileImageView;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ProfileSettingActivity
extends com.xiaomi.midrop.util.Locale.a {
    public static final a a = new Object(0){

        public static Intent a(Context context, boolean bl) {
            a.e.b.d.b((Object)context, "context");
            Intent intent = new Intent(context, ProfileSettingActivity.class);
            intent.putExtra("first_start", bl);
            return intent;
        }
    };
    private String b = "";
    private int c = -1;
    private HashMap d;

    public static final /* synthetic */ int a(ProfileSettingActivity profileSettingActivity) {
        return profileSettingActivity.c;
    }

    private final void a(Uri uri) {
        if (uri != null) {
            UCrop uCrop = UCrop.of(uri, com.xiaomi.midrop.profile.a.a());
            a.e.b.d.a((Object)uCrop, "UCrop.of(uri, ProfileModel.PROFILE_CROP_TEMP_URI)");
            UCrop.Options options = new UCrop.Options();
            options.setHideBottomControls(true);
            options.setCircleDimmedLayer(true);
            options.setShowCropGrid(false);
            options.setShowCropFrame(false);
            Context context = (Context)this;
            options.setStatusBarColor(android.support.v4.app.a.c((Context)context, (int)2131099712));
            options.setToolbarColor(android.support.v4.app.a.c((Context)context, (int)2131099712));
            uCrop.withOptions(options).withAspectRatio(1.0f, 1.0f).withMaxResultSize(240, 240);
            uCrop.start((Activity)this, 69);
        }
    }

    public static final /* synthetic */ void a(ProfileSettingActivity profileSettingActivity, int n2) {
        profileSettingActivity.c = n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void a(ProfileSettingActivity profileSettingActivity, boolean bl) {
        String[] arrstring;
        void var4_5;
        int n2;
        if (bl) {
            arrstring = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};
            n2 = 1;
            a.a a2 = new a.a(profileSettingActivity, bl){
                final /* synthetic */ ProfileSettingActivity a;
                final /* synthetic */ boolean b;
                {
                    this.a = profileSettingActivity;
                    this.b = bl;
                }

                public final void a() {
                    ProfileSettingActivity.b(this.a, this.b);
                }

                public final void a(int n2) {
                    ProfileSettingActivity.c(this.a);
                }
            };
        } else {
            arrstring = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
            n2 = 2;
            a.a a3 = new a.a(profileSettingActivity, bl){
                final /* synthetic */ ProfileSettingActivity a;
                final /* synthetic */ boolean b;
                {
                    this.a = profileSettingActivity;
                    this.b = bl;
                }

                public final void a() {
                    ProfileSettingActivity.b(this.a, this.b);
                }

                public final void a(int n2) {
                    ProfileSettingActivity.d(this.a);
                }
            };
        }
        profileSettingActivity.a(arrstring, n2, var4_5);
    }

    public static final /* synthetic */ String b(ProfileSettingActivity profileSettingActivity) {
        return profileSettingActivity.b;
    }

    public static final /* synthetic */ void b(ProfileSettingActivity profileSettingActivity, boolean bl) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (bl) {
                if (!profileSettingActivity.shouldShowRequestPermissionRationale("android.permission.CAMERA") && !profileSettingActivity.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    Toast.makeText((Context)((Context)profileSettingActivity), (int)2131689861, (int)1).show();
                    return;
                }
            } else if (!profileSettingActivity.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                Toast.makeText((Context)((Context)profileSettingActivity), (int)2131689861, (int)1).show();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void b(boolean bl) {
        float f2;
        TextView textView;
        TextView textView2 = (TextView)this.a(R.id.confirm);
        a.e.b.d.a((Object)textView2, "confirm");
        textView2.setEnabled(bl);
        if (bl) {
            textView = (TextView)this.a(R.id.confirm);
            a.e.b.d.a((Object)textView, "confirm");
            f2 = 1.0f;
        } else {
            textView = (TextView)this.a(R.id.confirm);
            a.e.b.d.a((Object)textView, "confirm");
            f2 = 0.5f;
        }
        textView.setAlpha(f2);
    }

    private final Uri c() {
        Context context = MiDropApplication.a();
        a.e.b.d.a((Object)context, "MiDropApplication.getApplication()");
        File file = new File(context.getExternalCacheDir(), "profile");
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Uri uri = FileProvider.a((Context)((Context)this), (String)"com.xiaomi.midrop.fileProvider", (File)file);
                return uri;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                midrop.service.c.d.a("ProfileSet", "IllegalArgumentException", illegalArgumentException, new Object[0]);
                return null;
            }
        }
        return Uri.fromFile((File)file);
    }

    public static final /* synthetic */ void c(ProfileSettingActivity profileSettingActivity) {
        Uri uri;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(profileSettingActivity.getPackageManager()) != null && (uri = profileSettingActivity.c()) != null) {
            List list = profileSettingActivity.getPackageManager().queryIntentActivities(intent, 65536);
            a.e.b.d.a((Object)list, "resInfoList");
            Iterator iterator = ((Iterable)list).iterator();
            while (iterator.hasNext()) {
                profileSettingActivity.grantUriPermission(((ResolveInfo)iterator.next()).activityInfo.packageName, uri, 2);
            }
            intent.putExtra("output", (Parcelable)uri);
            try {
                profileSettingActivity.startActivityForResult(intent, 102);
                return;
            }
            catch (SecurityException securityException) {
                midrop.service.c.d.a("ProfileSet", "openCamera", securityException, new Object[0]);
            }
        }
    }

    public static final /* synthetic */ void d(ProfileSettingActivity profileSettingActivity) {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (intent.resolveActivity(profileSettingActivity.getPackageManager()) != null) {
            try {
                profileSettingActivity.startActivityForResult(intent, 101);
                return;
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                midrop.service.c.d.a("ProfileSet", "openAlbum", activityNotFoundException, new Object[0]);
            }
        }
    }

    public final View a(int n2) {
        View view;
        if (this.d == null) {
            this.d = new HashMap();
        }
        if ((view = (View)this.d.get((Object)n2)) == null) {
            view = this.findViewById(n2);
            this.d.put((Object)n2, (Object)view);
        }
        return view;
    }

    public final void a() {
        if (!this.isDestroyed() && !this.isFinishing()) {
            EditText editText = (EditText)this.a(R.id.setName);
            a.e.b.d.a((Object)editText, "setName");
            Editable editable = editText.getText();
            a.e.b.d.a((Object)editable, "setName.text");
            this.b(true ^ a.i.g.a((CharSequence)editable));
        }
    }

    public final void b() {
        boolean bl;
        String string2 = this.b;
        EditText editText = (EditText)this.a(R.id.setName);
        a.e.b.d.a((Object)editText, "setName");
        if (true ^ a.e.b.d.a((Object)string2, (Object)editText.getText().toString())) {
            EditText editText2 = (EditText)this.a(R.id.setName);
            a.e.b.d.a((Object)editText2, "setName");
            com.xiaomi.midrop.util.e.a(editText2.getText().toString());
        }
        if (this.c >= 0) {
            y.f(this.c);
            if (this.c == 101) {
                File file = new File(com.xiaomi.midrop.profile.a.b().getPath());
                file.renameTo(new File(com.xiaomi.midrop.profile.a.c().getPath()));
            }
        }
        if (!(bl = this.getIntent().getBooleanExtra("first_start", false))) {
            af af2 = af.a(af.a.dF).a(af.b.an, String.valueOf((int)(1 + this.c)));
            af.b b2 = af.b.ao;
            String string3 = this.b;
            EditText editText3 = (EditText)this.a(R.id.setName);
            a.e.b.d.a((Object)editText3, "setName");
            String string4 = a.e.b.d.a((Object)string3, (Object)editText3.getText().toString()) ? "Default" : "Changed";
            af2.a(b2, string4).a();
        }
        Intent intent = this.getIntent();
        boolean bl2 = false;
        if (intent != null) {
            bl2 = intent.getBooleanExtra("from_third_party", false);
        }
        if (bl && !bl2) {
            this.startActivity(new Intent((Context)this, FilePickNewActivity.class));
            af.a(af.a.cf).a();
        }
        this.finish();
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (n3 == -1) {
            if (n2 != 69) {
                Uri uri;
                switch (n2) {
                    default: {
                        return;
                    }
                    case 102: {
                        uri = ProfileSettingActivity.super.c();
                        break;
                    }
                    case 101: {
                        if (intent == null) {
                            a.e.b.d.a();
                        }
                        uri = intent.getData();
                    }
                }
                ProfileSettingActivity.super.a(uri);
                return;
            }
            this.c = 101;
            ProfileImageView profileImageView = (ProfileImageView)this.a(R.id.icon);
            a.e.b.d.a((Object)profileImageView, "icon");
            ImageView imageView = profileImageView;
            if (intent == null) {
                a.e.b.d.a();
            }
            a.a.a(imageView, 0, UCrop.getOutput(intent), 2);
            File file = new File(com.xiaomi.midrop.profile.a.a().getPath());
            file.renameTo(new File(com.xiaomi.midrop.profile.a.b().getPath()));
            this.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void onBackPressed() {
        af af2;
        if (this.getIntent().getBooleanExtra("first_start", false)) {
            this.b();
            af af3 = af.a(af.a.dM).a(af.b.ar, "back").a(af.b.as, String.valueOf((int)(1 + this.c)));
            af.b b2 = af.b.ao;
            String string2 = this.b;
            EditText editText = (EditText)this.a(R.id.setName);
            a.e.b.d.a((Object)editText, "setName");
            String string3 = a.e.b.d.a((Object)string2, (Object)editText.getText().toString()) ? "Default" : "Changed";
            af2 = af3.a(b2, string3);
        } else {
            TextView textView = (TextView)this.a(R.id.confirm);
            a.e.b.d.a((Object)textView, "confirm");
            if (!textView.isEnabled()) {
                super.onBackPressed();
                return;
            }
            f.a a2 = new f.a();
            a2.a = -1;
            f.b b3 = new f.b();
            b3.a = null;
            b3.a = new com.xiaomi.midrop.view.c((Context)this).a(this.getString(2131689811)).b(this.getString(2131689543), new View.OnClickListener(this, a2){
                final /* synthetic */ ProfileSettingActivity a;
                final /* synthetic */ f.a b;
                {
                    this.a = profileSettingActivity;
                    this.b = a2;
                }

                public final void onClick(View view) {
                    this.a.b();
                    this.b.a = 0;
                }
            }).a(this.getString(2131689542), new View.OnClickListener(this, b3, a2){
                final /* synthetic */ ProfileSettingActivity a;
                final /* synthetic */ f.b b;
                final /* synthetic */ f.a c;
                {
                    this.a = profileSettingActivity;
                    this.b = b2;
                    this.c = a2;
                }

                public final void onClick(View view) {
                    android.support.v7.app.c c2 = (android.support.v7.app.c)this.b.a;
                    if (c2 != null) {
                        c2.dismiss();
                    }
                    this.a.finish();
                    this.c.a = 1;
                }
            }).d();
            ((android.support.v7.app.c)b3.a).setOnDismissListener(new DialogInterface.OnDismissListener(a2){
                final /* synthetic */ f.a a;
                {
                    this.a = a2;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    String string2;
                    switch (this.a.a) {
                        default: {
                            string2 = "close";
                            break;
                        }
                        case 1: {
                            string2 = "GiveUp";
                            break;
                        }
                        case 0: {
                            string2 = "Save";
                        }
                    }
                    af.a(af.a.dG).a(af.b.ap, string2).a();
                }
            });
            af2 = af.a(af.a.dN);
        }
        af2.a();
    }

    @Override
    protected final void onCreate(Bundle bundle) {
        AutoPressedStyleImageView autoPressedStyleImageView;
        super.onCreate(bundle);
        this.setContentView(2131427372);
        String string2 = com.xiaomi.midrop.util.e.a();
        a.e.b.d.a((Object)string2, "CustomNameUtils.getName(this)");
        this.b = string2;
        this.c(2131427533);
        ag.a((Activity)this, this.getResources().getColor(2131100072));
        View view = this.t();
        if (view == null) {
            a.e.b.d.a();
        }
        view.setBackgroundColor(this.getResources().getColor(2131100072));
        TextView textView = (TextView)view.findViewById(R.id.title);
        a.e.b.d.a((Object)textView, "customView.title");
        textView.setText((CharSequence)this.getResources().getString(2131689812));
        boolean bl = this.getIntent().getBooleanExtra("first_start", false);
        Context context = (Context)this;
        if (ac.c(context) && (autoPressedStyleImageView = (AutoPressedStyleImageView)this.a(R.id.icon_back)) != null) {
            autoPressedStyleImageView.setRotation(180.0f);
        }
        ((AutoPressedStyleImageView)this.a(R.id.icon_back)).setOnClickListener(new View.OnClickListener((ProfileSettingActivity)this){
            final /* synthetic */ ProfileSettingActivity a;
            {
                this.a = profileSettingActivity;
            }

            public final void onClick(View view) {
                this.a.onBackPressed();
            }
        });
        if (bl) {
            AutoPressedStyleImageView autoPressedStyleImageView2 = (AutoPressedStyleImageView)this.a(R.id.icon_back);
            a.e.b.d.a((Object)autoPressedStyleImageView2, "icon_back");
            autoPressedStyleImageView2.setVisibility(8);
            ProfileSettingActivity.super.b(true);
            af.a(af.a.dK).a();
        } else {
            AutoPressedStyleImageView autoPressedStyleImageView3 = (AutoPressedStyleImageView)this.a(R.id.icon_back);
            a.e.b.d.a((Object)autoPressedStyleImageView3, "icon_back");
            autoPressedStyleImageView3.setVisibility(0);
            ProfileSettingActivity.super.b(false);
            ((TextView)this.a(R.id.confirm)).setText(2131689543);
        }
        ((TextView)this.a(R.id.confirm)).setOnClickListener(new View.OnClickListener((ProfileSettingActivity)this, bl){
            final /* synthetic */ ProfileSettingActivity a;
            final /* synthetic */ boolean b;
            {
                this.a = profileSettingActivity;
                this.b = bl;
            }

            public final void onClick(View view) {
                EditText editText = (EditText)this.a.a(R.id.setName);
                a.e.b.d.a((Object)editText, "setName");
                Editable editable = editText.getText();
                a.e.b.d.a((Object)editable, "setName.text");
                if (true ^ a.i.g.a(a.i.g.b((CharSequence)editable).toString())) {
                    this.a.b();
                    if (this.b) {
                        af af2 = af.a(af.a.dM).a(af.b.ar, "button").a(af.b.as, String.valueOf((int)(1 + ProfileSettingActivity.a(this.a))));
                        af.b b2 = af.b.ao;
                        String string2 = ProfileSettingActivity.b(this.a);
                        EditText editText2 = (EditText)this.a.a(R.id.setName);
                        a.e.b.d.a((Object)editText2, "setName");
                        String string3 = a.e.b.d.a((Object)string2, (Object)editText2.getText().toString()) ? "Default" : "Changed";
                        af2.a(b2, string3).a();
                    }
                }
            }
        });
        ((EditText)this.a(R.id.setName)).setText((CharSequence)this.b);
        EditText editText = (EditText)this.a(R.id.setName);
        a.e.b.d.a((Object)editText, "setName");
        editText.addTextChangedListener(new TextWatcher(new a.e.a.b<String, a.l>((ProfileSettingActivity)this){
            final /* synthetic */ ProfileSettingActivity a;
            {
                this.a = profileSettingActivity;
                super(1);
            }

            @Override
            public final /* synthetic */ Object a(Object object) {
                a.e.b.d.b((String)object, "it");
                this.a.a();
                return a.l.a;
            }
        }){
            final /* synthetic */ a.e.a.b a;
            {
                this.a = b2;
            }

            public final void afterTextChanged(Editable editable) {
                this.a.a(String.valueOf((Object)editable));
            }

            public final void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public final void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }
        });
        if (true ^ a.i.g.a(this.b)) {
            ((EditText)this.a(R.id.setName)).setSelection(this.b.length());
        }
        ((EditText)this.a(R.id.setName)).setOnEditorActionListener((TextView.OnEditorActionListener)f.a);
        ((LinearLayout)this.a(R.id.parentView)).setOnTouchListener(new View.OnTouchListener((ProfileSettingActivity)this){
            final /* synthetic */ ProfileSettingActivity a;
            {
                this.a = profileSettingActivity;
            }

            public final boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                com.xiaomi.midrop.util.am.a((View)((EditText)this.a.a(R.id.setName)));
                return true;
            }
        });
        ((RelativeLayout)this.a(R.id.root)).setOnTouchListener(new View.OnTouchListener((ProfileSettingActivity)this){
            final /* synthetic */ ProfileSettingActivity a;
            {
                this.a = profileSettingActivity;
            }

            public final boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                a.e.b.d.a((Object)motionEvent, "event");
                if (motionEvent.getAction() == 1) {
                    com.xiaomi.midrop.util.am.a((View)((EditText)this.a.a(R.id.setName)));
                }
                return false;
            }
        });
        RecyclerView recyclerView = (RecyclerView)this.a(R.id.recyclerView);
        a.e.b.d.a((Object)recyclerView, "recyclerView");
        recyclerView.setLayoutManager((RecyclerView.i)new GridLayoutManager(context, 4));
        RecyclerView recyclerView2 = (RecyclerView)this.a(R.id.recyclerView);
        a.e.b.d.a((Object)recyclerView2, "recyclerView");
        recyclerView2.setAdapter((RecyclerView.a)new RecyclerView.a<a>(context, new b((ProfileSettingActivity)this){
            final /* synthetic */ ProfileSettingActivity a;
            {
                this.a = profileSettingActivity;
            }

            public final void a(int n2) {
                ProfileSettingActivity.a(this.a, n2);
                ProfileImageView profileImageView = (ProfileImageView)this.a.a(R.id.icon);
                a.e.b.d.a((Object)((Object)profileImageView), "icon");
                a.a.a((ImageView)profileImageView, n2, null, 4);
                this.a.a();
                com.xiaomi.midrop.util.am.a((View)((EditText)this.a.a(R.id.setName)));
            }

            public final void a(boolean bl) {
                ProfileSettingActivity.a(this.a, bl);
                com.xiaomi.midrop.util.am.a((View)((EditText)this.a.a(R.id.setName)));
            }
        }){
            TypedArray c;
            b d;
            private final Context f;
            {
                a.e.b.d.b((Object)context, "context");
                a.e.b.d.b(b2, "itemClick");
                this.f = context;
                this.d = b2;
                TypedArray typedArray = ProfileSettingActivity.this.getResources().obtainTypedArray(2130903044);
                a.e.b.d.a((Object)typedArray, "resources.obtainTypedArray(R.array.profile_icon)");
                this.c = typedArray;
            }

            public final int a() {
                return this.c.length();
            }

            public final /* synthetic */ RecyclerView.w a(ViewGroup viewGroup, int n2) {
                a.e.b.d.b((Object)viewGroup, "parent");
                View view = LayoutInflater.from((Context)this.f).inflate(2131427476, viewGroup, false);
                a.e.b.d.a((Object)view, "view");
                return new a(view);
            }

            /*
             * Enabled aggressive block sorting
             */
            public final /* synthetic */ void a(RecyclerView.w w2, int n2) {
                boolean bl;
                ProfileImageView profileImageView;
                a a2 = (a)w2;
                a.e.b.d.b((Object)a2, "holder");
                a2.n.setImageDrawable(this.f.getResources().getDrawable(this.c.getResourceId(n2, -1)));
                if (n2 >= -2 + this.c.length()) {
                    profileImageView = a2.n;
                    bl = false;
                } else {
                    profileImageView = a2.n;
                    bl = true;
                }
                profileImageView.setBolderEnable(bl);
            }

            public final class a
            extends RecyclerView.w {
                final ProfileImageView n;

                public a(View view) {
                    a.e.b.d.b((Object)view, "view");
                    super(view);
                    ProfileImageView profileImageView = (ProfileImageView)view.findViewById(R.id.img);
                    a.e.b.d.a((Object)profileImageView, "view.img");
                    this.n = profileImageView;
                    this.a.setOnClickListener(new View.OnClickListener((a)this){
                        final /* synthetic */ a a;
                        {
                            this.a = a2;
                        }

                        /*
                         * Enabled aggressive block sorting
                         */
                        public final void onClick(View view) {
                            af.a a2;
                            int n2;
                            block6 : {
                                af.b b2;
                                af af2;
                                String string2;
                                block5 : {
                                    block4 : {
                                        a2 = this.a.c.this.ProfileSettingActivity.this.getIntent().getBooleanExtra("first_start", false) ? af.a.dL : af.a.dE;
                                        n2 = this.a.c();
                                        int n3 = -3 + this.a.c.this.c.length();
                                        if (n2 < 0 || n3 < n2) break block4;
                                        this.a.c.this.d.a(this.a.c());
                                        af2 = af.a(a2);
                                        b2 = af.b.am;
                                        string2 = String.valueOf((int)(1 + this.a.c()));
                                        break block5;
                                    }
                                    if (n2 != -2 + this.a.c.this.c.length()) break block6;
                                    this.a.c.this.d.a(true);
                                    af2 = af.a(a2);
                                    b2 = af.b.am;
                                    string2 = "Camera";
                                }
                                af2.a(b2, string2).a();
                                return;
                            }
                            if (n2 == this.a.c.this.c.length() - 1) {
                                this.a.c.this.d.a(false);
                                af.a(a2).a(af.b.am, "Album").a();
                            }
                        }
                    });
                }
            }

        });
        ((ProfileImageView)this.a(R.id.icon)).a();
    }

}

