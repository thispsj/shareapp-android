/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.ClipboardManager
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  android.support.design.widget.BottomSheetBehavior
 *  android.support.design.widget.BottomSheetBehavior$a
 *  android.support.design.widget.BottomSheetDialogFragment
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.g
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$i
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.Toast
 *  com.facebook.share.a.t
 *  com.facebook.share.a.t$a
 *  com.facebook.share.a.u
 *  com.facebook.share.a.u$a
 *  com.facebook.share.b.a
 *  java.io.FileOutputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 */
package com.xiaomi.midrop.result;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import com.facebook.share.a.t;
import com.facebook.share.a.u;
import com.xiaomi.globalmiuiapp.common.f.f;
import com.xiaomi.midrop.cloudsettings.TransResultCardSettingModel;
import com.xiaomi.midrop.result.ResultAdapter;
import com.xiaomi.midrop.result.ResultBottomSheetFragment;
import com.xiaomi.midrop.result.b;
import com.xiaomi.midrop.util.ae;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.am;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import midrop.service.c.d;

public class ResultBottomSheetFragment
extends BottomSheetDialogFragment {
    private RecyclerView a;
    private List<b> b = new ArrayList();
    private Uri c;
    private BottomSheetBehavior d;
    private float e;
    private BottomSheetBehavior.a f = new BottomSheetBehavior.a(this){
        final /* synthetic */ ResultBottomSheetFragment a;
        {
            this.a = resultBottomSheetFragment;
        }

        public final void a(float f2) {
            ResultBottomSheetFragment.a(this.a, f2);
        }

        public final void a(int n2) {
            if (n2 == 2) {
                if (ResultBottomSheetFragment.a(this.a) != 0.0f && ResultBottomSheetFragment.a(this.a) < -0.19f) {
                    ResultBottomSheetFragment.b(this.a);
                    af.a(af.a.de).a(af.b.V, "move").a();
                    return;
                }
            } else if (n2 == 5) {
                this.a.dismiss();
            }
        }
    };

    static /* synthetic */ float a(ResultBottomSheetFragment resultBottomSheetFragment) {
        return resultBottomSheetFragment.e;
    }

    static /* synthetic */ float a(ResultBottomSheetFragment resultBottomSheetFragment, float f2) {
        resultBottomSheetFragment.e = f2;
        return f2;
    }

    static /* synthetic */ BottomSheetBehavior a(ResultBottomSheetFragment resultBottomSheetFragment, BottomSheetBehavior bottomSheetBehavior) {
        resultBottomSheetFragment.d = bottomSheetBehavior;
        return bottomSheetBehavior;
    }

    private void a(int n2, Uri uri) {
        if (this.getActivity() != null && this.getView() != null && uri != null) {
            String string2 = com.xiaomi.midrop.result.a.a().k;
            if (n2 == 0) {
                ClipboardManager clipboardManager = (ClipboardManager)this.getContext().getSystemService("clipboard");
                if (clipboardManager != null) {
                    clipboardManager.setText((CharSequence)string2.trim());
                    Toast.makeText((Context)this.getContext(), (CharSequence)this.getContext().getString(2131689989), (int)1).show();
                }
                u.a a2 = new u.a();
                t.a a3 = new t.a();
                a3.c = uri;
                u u2 = a2.a(a3.a()).a();
                new com.facebook.share.b.a((Activity)this.getActivity()).a((Object)u2);
            } else {
                Intent intent = new Intent("android.intent.action.SEND");
                if (n2 == 1) {
                    intent.setPackage("com.whatsapp");
                }
                intent.putExtra("android.intent.extra.TEXT", string2);
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.STREAM", (Parcelable)uri);
                this.getContext().startActivity(intent);
            }
            this.c = uri;
        }
    }

    static /* synthetic */ void a(ResultBottomSheetFragment resultBottomSheetFragment, int n2) {
        if (resultBottomSheetFragment.getView() != null) {
            View view = resultBottomSheetFragment.getView().findViewById(2131296753);
            if (resultBottomSheetFragment.c != null) {
                resultBottomSheetFragment.a(n2, resultBottomSheetFragment.c);
                return;
            }
            new Handler().post(new Runnable(resultBottomSheetFragment, view, n2){
                final /* synthetic */ View a;
                final /* synthetic */ int b;
                final /* synthetic */ ResultBottomSheetFragment c;
                {
                    this.c = resultBottomSheetFragment;
                    this.a = view;
                    this.b = n2;
                }

                public final void run() {
                    new AsyncTask<Void, Void, Uri>(this.c, this.a, this.b){
                        private WeakReference<ResultBottomSheetFragment> a;
                        private WeakReference<View> b;
                        private int c;
                        private Bitmap d;
                        {
                            this.a = new WeakReference((Object)resultBottomSheetFragment);
                            this.b = new WeakReference((Object)view);
                            this.c = n2;
                        }

                        /*
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         */
                        private /* varargs */ Uri a() {
                            if (this.a == null) return null;
                            if (this.a.get() == null) return null;
                            Context context = ((ResultBottomSheetFragment)((Object)this.a.get())).getContext();
                            try {
                                String string2;
                                FileOutputStream fileOutputStream = context.openFileOutput("view_shot", 0);
                                if (fileOutputStream != null && this.d != null) {
                                    this.d.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)fileOutputStream);
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                }
                                if (TextUtils.isEmpty((CharSequence)(string2 = MediaStore.Images.Media.insertImage((ContentResolver)context.getContentResolver(), (Bitmap)this.d, null, null)))) return null;
                                return Uri.parse((String)string2);
                            }
                            catch (Exception exception) {
                                d.a("ShareTask", "savePic e = ", exception, new Object[0]);
                            }
                            return null;
                        }

                        /*
                         * Exception decompiling
                         */
                        protected final /* synthetic */ Object doInBackground(Object[] var1) {
                            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                            // java.lang.ArrayIndexOutOfBoundsException: length=0; index=-1
                            // java.util.ArrayList.get(ArrayList.java:315)
                            // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:87)
                            // org.benf.cfr.reader.b.a.b.a.e.a(AbstractMemberFunctionInvokation.java:146)
                            // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:56)
                            // org.benf.cfr.reader.b.a.d.b.u.a(StructuredReturn.java:90)
                            // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:42)
                            // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:1185)
                            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:760)
                            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                            // org.benf.cfr.reader.entities.g.p(Method.java:396)
                            // org.benf.cfr.reader.entities.d.e(ClassFile.java:885)
                            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
                            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
                            // org.benf.cfr.reader.b.a(Driver.java:128)
                            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
                            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
                            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
                            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
                            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
                            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
                            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
                            // java.lang.Thread.run(Thread.java:818)
                            throw new IllegalStateException("Decompilation failed");
                        }

                        protected final /* synthetic */ void onPostExecute(Object object) {
                            Uri uri = (Uri)object;
                            super.onPostExecute((Object)uri);
                            if (uri != null && this.a != null && this.a.get() != null) {
                                ((ResultBottomSheetFragment)((Object)this.a.get())).a(this.c, uri);
                            }
                        }

                        protected final void onPreExecute() {
                            super.onPreExecute();
                            if (this.b != null && this.b.get() != null) {
                                View view = (View)this.b.get();
                                this.d = Bitmap.createBitmap((int)view.getMeasuredWidth(), (int)view.getMeasuredHeight(), (Bitmap.Config)Bitmap.Config.RGB_565);
                                view.draw(new Canvas(this.d));
                            }
                        }
                    }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
                }
            });
        }
    }

    static /* synthetic */ void b(ResultBottomSheetFragment resultBottomSheetFragment) {
        if (resultBottomSheetFragment.d != null) {
            resultBottomSheetFragment.d.c(5);
        }
        new Handler().postDelayed(new Runnable(resultBottomSheetFragment){
            final /* synthetic */ ResultBottomSheetFragment a;
            {
                this.a = resultBottomSheetFragment;
            }

            public final void run() {
                this.a.dismissAllowingStateLoss();
            }
        }, 75L);
    }

    static /* synthetic */ BottomSheetBehavior c(ResultBottomSheetFragment resultBottomSheetFragment) {
        return resultBottomSheetFragment.d;
    }

    static /* synthetic */ BottomSheetBehavior.a d(ResultBottomSheetFragment resultBottomSheetFragment) {
        return resultBottomSheetFragment.f;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setStyle(0, 2131755186);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.getDialog() != null) {
            this.getDialog().getWindow().addFlags(134217728);
            if (Build.VERSION.SDK_INT > 28) {
                am.a(this.getDialog().getWindow());
            }
            this.getDialog().setOnShowListener(new DialogInterface.OnShowListener((ResultBottomSheetFragment)this){
                final /* synthetic */ ResultBottomSheetFragment a;
                {
                    this.a = resultBottomSheetFragment;
                }

                /*
                 * Exception decompiling
                 */
                public final void onShow(}
        }
        java.lang.IllegalStateException: Parameters not created
        
        