/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.SurfaceTexture
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.Display
 *  android.view.OrientationEventListener
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.WindowManager
 *  com.google.zxing.client.android.R
 *  com.google.zxing.client.android.R$id
 *  com.google.zxing.client.android.R$styleable
 *  com.journeyapps.barcodescanner.CameraPreview$4
 *  com.journeyapps.barcodescanner.CameraPreview$5
 *  com.journeyapps.barcodescanner.a.g
 *  com.journeyapps.barcodescanner.a.i
 *  com.journeyapps.barcodescanner.a.j
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.a.b;
import com.journeyapps.barcodescanner.a.c;
import com.journeyapps.barcodescanner.a.d;
import com.journeyapps.barcodescanner.a.e;
import com.journeyapps.barcodescanner.a.g;
import com.journeyapps.barcodescanner.a.h;
import com.journeyapps.barcodescanner.a.i;
import com.journeyapps.barcodescanner.a.j;
import com.journeyapps.barcodescanner.a.l;
import com.journeyapps.barcodescanner.m;
import com.journeyapps.barcodescanner.n;
import com.journeyapps.barcodescanner.p;
import java.util.ArrayList;
import java.util.List;

public class CameraPreview
extends ViewGroup {
    private static final String c = "CameraPreview";
    private final a A;
    b a;
    boolean b = false;
    private WindowManager d;
    private Handler e;
    private boolean f = false;
    private SurfaceView g;
    private TextureView h;
    private m i;
    private int j = -1;
    private List<a> k = new ArrayList();
    private h l;
    private d m = new d();
    private n n;
    private n o;
    private Rect p;
    private n q;
    private Rect r = null;
    private Rect s = null;
    private n t = null;
    private double u = 0.1;
    private l v = null;
    private boolean w = false;
    private final SurfaceHolder.Callback x;
    private final Handler.Callback y;
    private com.journeyapps.barcodescanner.l z;

    public CameraPreview(Context context) {
        super(context);
        this.x = new SurfaceHolder.Callback(){

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int n2, int n3, int n4) {
                if (surfaceHolder == null) {
                    Log.e((String)c, (String)"*** WARNING *** surfaceChanged() gave us a null surface!");
                    return;
                }
                CameraPreview.this.q = new n(n3, n4);
                CameraPreview.this.g();
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                CameraPreview.this.q = null;
            }
        };
        this.y = new Handler.Callback(){

            public final boolean handleMessage(Message message) {
                if (message.what == R.id.zxing_prewiew_size_ready) {
                    CameraPreview.b(CameraPreview.this, (n)message.obj);
                    return true;
                }
                if (message.what == R.id.zxing_camera_error) {
                    Exception exception = (Exception)((Object)message.obj);
                    if (CameraPreview.this.e()) {
                        CameraPreview.this.c();
                        CameraPreview.this.A.a(exception);
                    }
                } else if (message.what == R.id.zxing_camera_closed) {
                    CameraPreview.this.A.d();
                }
                return false;
            }
        };
        this.z = new 4((CameraPreview)this);
        this.A = new 5((CameraPreview)this);
        CameraPreview.super.a(context, null);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = new /* invalid duplicate definition of identical inner class */;
        this.y = new /* invalid duplicate definition of identical inner class */;
        this.z = new 4((CameraPreview)this);
        this.A = new 5((CameraPreview)this);
        CameraPreview.super.a(context, attributeSet);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.x = new /* invalid duplicate definition of identical inner class */;
        this.y = new /* invalid duplicate definition of identical inner class */;
        this.z = new 4((CameraPreview)this);
        this.A = new 5((CameraPreview)this);
        CameraPreview.super.a(context, attributeSet);
    }

    @TargetApi(value=14)
    private TextureView.SurfaceTextureListener a() {
        return new TextureView.SurfaceTextureListener(){

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n2, int n3) {
                this.onSurfaceTextureSizeChanged(surfaceTexture, n2, n3);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n2, int n3) {
                CameraPreview.this.q = new n(n2, n3);
                CameraPreview.this.g();
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (this.getBackground() == null) {
            this.setBackgroundColor(-16777216);
        }
        this.a(attributeSet);
        this.d = (WindowManager)context.getSystemService("window");
        this.e = new Handler(this.y);
        this.i = new m();
    }

    private void a(e e2) {
        if (!this.b && this.a != null) {
            Log.i((String)c, (String)"Starting preview");
            this.a.a = e2;
            this.a.c();
            this.b = true;
            this.b();
            this.A.b();
        }
    }

    static /* synthetic */ void b(CameraPreview cameraPreview, n n2) {
        cameraPreview.o = n2;
        if (cameraPreview.n != null) {
            if (cameraPreview.n != null && cameraPreview.o != null && cameraPreview.l != null) {
                int n3 = cameraPreview.o.a;
                int n4 = cameraPreview.o.b;
                int n5 = cameraPreview.n.a;
                int n6 = cameraPreview.n.b;
                h h2 = cameraPreview.l;
                n n7 = cameraPreview.o;
                cameraPreview.p = h2.c.b(n7, h2.a);
                cameraPreview.r = cameraPreview.a(new Rect(0, 0, n5, n6), cameraPreview.p);
                Rect rect = new Rect(cameraPreview.r);
                rect.offset(-cameraPreview.p.left, -cameraPreview.p.top);
                cameraPreview.s = new Rect(n3 * rect.left / cameraPreview.p.width(), n4 * rect.top / cameraPreview.p.height(), n3 * rect.right / cameraPreview.p.width(), n4 * rect.bottom / cameraPreview.p.height());
                if (cameraPreview.s.width() > 0 && cameraPreview.s.height() > 0) {
                    cameraPreview.A.a();
                } else {
                    cameraPreview.s = null;
                    cameraPreview.r = null;
                    Log.w((String)c, (String)"Preview frame is too small");
                }
                cameraPreview.requestLayout();
                cameraPreview.g();
                return;
            }
            cameraPreview.s = null;
            cameraPreview.r = null;
            cameraPreview.p = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
    }

    static /* synthetic */ void c(CameraPreview cameraPreview) {
        if (cameraPreview.e() && cameraPreview.getDisplayRotation() != cameraPreview.j) {
            cameraPreview.c();
            cameraPreview.d();
        }
    }

    static /* synthetic */ Handler d(CameraPreview cameraPreview) {
        return cameraPreview.e;
    }

    static /* synthetic */ List e(CameraPreview cameraPreview) {
        return cameraPreview.k;
    }

    private void g() {
        if (this.q != null && this.o != null && this.p != null) {
            if (this.g != null && this.q.equals(new n(this.p.width(), this.p.height()))) {
                this.a(new e(this.g.getHolder()));
                return;
            }
            if (this.h != null && this.h.getSurfaceTexture() != null) {
                if (this.o != null) {
                    float f2;
                    n n2 = new n(this.h.getWidth(), this.h.getHeight());
                    n n3 = this.o;
                    float f3 = (float)n2.a / (float)n2.b;
                    float f4 = (float)n3.a / (float)n3.b;
                    float f5 = f3 FCMPG f4;
                    float f6 = 1.0f;
                    if (f5 < 0) {
                        f2 = f4 / f3;
                    } else {
                        f6 = f3 / f4;
                        f2 = 1.0f;
                    }
                    Matrix matrix = new Matrix();
                    matrix.setScale(f2, f6);
                    float f7 = f2 * (float)n2.a;
                    float f8 = f6 * (float)n2.b;
                    matrix.postTranslate(((float)n2.a - f7) / 2.0f, ((float)n2.b - f8) / 2.0f);
                    this.h.setTransform(matrix);
                }
                this.a(new e(this.h.getSurfaceTexture()));
            }
        }
    }

    private int getDisplayRotation() {
        return this.d.getDefaultDisplay().getRotation();
    }

    public Rect a(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.t != null) {
            rect3.inset(Math.max((int)0, (int)((rect3.width() - this.t.a) / 2)), Math.max((int)0, (int)((rect3.height() - this.t.b) / 2)));
            return rect3;
        }
        int n2 = (int)Math.min((double)((double)rect3.width() * this.u), (double)((double)rect3.height() * this.u));
        rect3.inset(n2, n2);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final void a(AttributeSet attributeSet) {
        TypedArray typedArray;
        block7 : {
            g g2;
            block5 : {
                int n2;
                block6 : {
                    block4 : {
                        typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_camera_preview);
                        int n3 = (int)typedArray.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
                        int n4 = (int)typedArray.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
                        if (n3 > 0 && n4 > 0) {
                            this.t = new n(n3, n4);
                        }
                        this.f = typedArray.getBoolean(R.styleable.zxing_camera_preview_zxing_use_texture_view, true);
                        n2 = typedArray.getInteger(R.styleable.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
                        if (n2 != 1) break block4;
                        g2 = new g();
                        break block5;
                    }
                    if (n2 != 2) break block6;
                    g2 = new i();
                    break block5;
                }
                if (n2 != 3) break block7;
                g2 = new j();
            }
            this.v = g2;
        }
        typedArray.recycle();
    }

    public final void a(a a2) {
        this.k.add((Object)a2);
    }

    protected void b() {
    }

    public void c() {
        p.a();
        Log.d((String)c, (String)"pause()");
        this.j = -1;
        if (this.a != null) {
            this.a.d();
            this.a = null;
            this.b = false;
        } else {
            this.e.sendEmptyMessage(R.id.zxing_camera_closed);
        }
        if (this.q == null && this.g != null) {
            this.g.getHolder().removeCallback(this.x);
        }
        if (this.q == null && this.h != null) {
            this.h.setSurfaceTextureListener(null);
        }
        this.n = null;
        this.o = null;
        this.s = null;
        this.i.a();
        this.A.c();
    }

    public final void d() {
        p.a();
        Log.d((String)c, (String)"resume()");
        if (this.a != null) {
            Log.w((String)c, (String)"initCamera called twice");
        } else {
            b b2 = new b(this.getContext());
            d d2 = this.m;
            if (!b2.e) {
                b2.h = d2;
                b2.b.g = d2;
            }
            this.a = b2;
            this.a.c = this.e;
            this.a.a();
            this.j = this.getDisplayRotation();
        }
        if (this.q != null) {
            this.g();
        } else if (this.g != null) {
            this.g.getHolder().addCallback(this.x);
        } else if (this.h != null) {
            if (this.h.isAvailable()) {
                this.a().onSurfaceTextureAvailable(this.h.getSurfaceTexture(), this.h.getWidth(), this.h.getHeight());
            } else {
                this.h.setSurfaceTextureListener(this.a());
            }
        }
        this.requestLayout();
        m m2 = this.i;
        Context context = this.getContext();
        com.journeyapps.barcodescanner.l l2 = this.z;
        m2.a();
        Context context2 = context.getApplicationContext();
        m2.d = l2;
        m2.b = (WindowManager)context2.getSystemService("window");
        m2.c = new OrientationEventListener(m2, context2){
            final /* synthetic */ m a;
            {
                this.a = m2;
                super(context, 3);
            }

            public final void onOrientationChanged(int n2) {
                int n3;
                WindowManager windowManager = this.a.b;
                com.journeyapps.barcodescanner.l l2 = this.a.d;
                if (this.a.b != null && l2 != null && (n3 = windowManager.getDefaultDisplay().getRotation()) != this.a.a) {
                    this.a.a = n3;
                    l2.a();
                }
            }
        };
        m2.c.enable();
        m2.a = m2.b.getDefaultDisplay().getRotation();
    }

    protected final boolean e() {
        return this.a != null;
    }

    public b getCameraInstance() {
        return this.a;
    }

    public d getCameraSettings() {
        return this.m;
    }

    public Rect getFramingRect() {
        return this.r;
    }

    public n getFramingRectSize() {
        return this.t;
    }

    public double getMarginFraction() {
        return this.u;
    }

    public Rect getPreviewFramingRect() {
        return this.s;
    }

    public l getPreviewScalingStrategy() {
        if (this.v != null) {
            return this.v;
        }
        if (this.h != null) {
            return new g();
        }
        return new i();
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onAttachedToWindow() {
        TextureView textureView;
        super.onAttachedToWindow();
        if (this.f) {
            this.h = new TextureView(this.getContext());
            this.h.setSurfaceTextureListener(this.a());
            textureView = this.h;
        } else {
            this.g = new SurfaceView(this.getContext());
            this.g.getHolder().addCallback(this.x);
            textureView = this.g;
        }
        this.addView((View)textureView);
    }

    @SuppressLint(value={"DrawAllocation"})
    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        n n6;
        this.n = n6 = new n(n4 - n2, n5 - n3);
        if (this.a != null && this.a.d == null) {
            h h2;
            this.l = new h(this.getDisplayRotation(), n6);
            this.l.c = this.getPreviewScalingStrategy();
            b b2 = this.a;
            b2.d = h2 = this.l;
            b2.b.h = h2;
            this.a.b();
            if (this.w) {
                this.a.a(this.w);
            }
        }
        if (this.g != null) {
            if (this.p == null) {
                this.g.layout(0, 0, this.getWidth(), this.getHeight());
                return;
            }
            this.g.layout(this.p.left, this.p.top, this.p.right, this.p.bottom);
            return;
        }
        if (this.h != null) {
            this.h.layout(0, 0, this.getWidth(), this.getHeight());
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle)parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        this.setTorch(bundle.getBoolean("torch"));
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", parcelable);
        bundle.putBoolean("torch", this.w);
        return bundle;
    }

    public void setCameraSettings(d d2) {
        this.m = d2;
    }

    public void setFramingRectSize(n n2) {
        this.t = n2;
    }

    public void setMarginFraction(double d2) {
        if (d2 >= 0.5) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.u = d2;
    }

    public void setPreviewScalingStrategy(l l2) {
        this.v = l2;
    }

    public void setTorch(boolean bl) {
        this.w = bl;
        if (this.a != null) {
            this.a.a(bl);
        }
    }

    public void setUseTextureView(boolean bl) {
        this.f = bl;
    }

    public static interface a {
        public void a();

        public void a(Exception var1);

        public void b();

        public void c();

        public void d();
    }

}

