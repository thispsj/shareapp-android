/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Message
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationSet
 *  android.view.animation.ScaleAnimation
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.xiaomi.midrop.sender.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public final class a {
    ImageView a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    View e;
    ImageView f;
    ImageView g;
    ImageView h;
    FrameLayout i;
    TextView j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    int o;
    public Handler p;
    private Context q;

    public a(Context context, View view) {
        this.p = new Handler(){

            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                a a2 = a.this;
                Log.d((String)"AnimationController", (String)"start anim");
                a2.k = true;
                a2.i.setVisibility(0);
                a2.j.setVisibility(0);
                a2.e.setVisibility(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(120L);
                alphaAnimation.setFillAfter(true);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 1.0f);
                scaleAnimation.setDuration(300L);
                scaleAnimation.setFillAfter(true);
                int n2 = ((BitmapDrawable)a2.g.getDrawable()).getIntrinsicWidth() / 2;
                ImageView imageView = a2.g;
                float f2 = n2;
                imageView.setPivotX(f2);
                a2.g.setPivotY(f2);
                a2.h.setPivotX(f2);
                a2.h.setPivotY(f2);
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)a2.g, (String)"rotation", (float[])new float[]{45.0f}).setDuration(300L);
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((Object)a2.h, (String)"rotation", (float[])new float[]{-45.0f}).setDuration(300L);
                final AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{objectAnimator, objectAnimator2});
                animatorSet.addListener(new Animator.AnimatorListener(){

                    public final void onAnimationCancel(Animator animator2) {
                    }

                    public final void onAnimationEnd(Animator animator2) {
                        a.this.a();
                        a.this.m = true;
                    }

                    public final void onAnimationRepeat(Animator animator2) {
                    }

                    public final void onAnimationStart(Animator animator2) {
                    }
                });
                scaleAnimation.setAnimationListener(new Animation.AnimationListener(){

                    public final void onAnimationEnd(Animation animation) {
                        a.this.g.setVisibility(0);
                        a.this.h.setVisibility(0);
                        animatorSet.start();
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                a2.a.startAnimation((Animation)alphaAnimation);
                a2.a.setVisibility(0);
                a2.f.startAnimation((Animation)scaleAnimation);
                a2.f.setVisibility(0);
            }
        };
        this.q = context;
        this.i = (FrameLayout)view.findViewById(2131296725);
        this.j = (TextView)view.findViewById(2131296726);
        LayoutInflater.from((Context)context).inflate(2131427421, (ViewGroup)this.i);
        this.b = (ImageView)this.i.findViewById(2131296361);
        this.a = (ImageView)this.i.findViewById(2131296360);
        this.c = (ImageView)this.i.findViewById(2131296362);
        this.d = (ImageView)this.i.findViewById(2131296363);
        this.o = this.q.getResources().getInteger(2131361800);
        this.e = this.i.findViewById(2131296603);
        this.f = (ImageView)this.i.findViewById(2131296586);
        this.g = (ImageView)this.i.findViewById(2131296584);
        this.h = (ImageView)this.i.findViewById(2131296682);
    }

    private AnimationSet e() {
        int n2 = this.q.getResources().getDimensionPixelOffset(2131165326);
        float f2 = (float)(this.q.getResources().getDimensionPixelOffset(2131165331) / 2) / (float)n2;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f2, 1.0f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(Integer.MAX_VALUE);
        scaleAnimation.setRepeatMode(-1);
        scaleAnimation.setDuration((long)this.o);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setRepeatMode(-1);
        alphaAnimation.setRepeatCount(Integer.MAX_VALUE);
        alphaAnimation.setDuration((long)this.o);
        final AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation((Animation)alphaAnimation);
        animationSet.addAnimation((Animation)scaleAnimation);
        animationSet.setRepeatMode(-1);
        animationSet.setRepeatCount(Integer.MAX_VALUE);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener(){

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
                if (a.this.l) {
                    if (a.this.b.getAnimation() == animationSet) {
                        a.this.b.setVisibility(4);
                        a.this.b.clearAnimation();
                    }
                    if (a.this.c.getAnimation() == animationSet) {
                        a.this.c.setVisibility(4);
                        a.this.c.clearAnimation();
                    }
                    if (a.this.d.getAnimation() == animationSet) {
                        a.this.d.setVisibility(4);
                        a.this.d.clearAnimation();
                    }
                    if (!a.this.n) {
                        a.this.b();
                    }
                }
            }

            public final void onAnimationStart(Animation animation) {
            }
        });
        return animationSet;
    }

    final void a() {
        if (this.l) {
            this.b();
            return;
        }
        AnimationSet animationSet = this.e();
        final AnimationSet animationSet2 = this.e();
        final AnimationSet animationSet3 = this.e();
        this.b.startAnimation((Animation)animationSet);
        this.b.setVisibility(0);
        animationSet.setAnimationListener(new Animation.AnimationListener(){

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                a.this.b.postDelayed(new Runnable(){

                    public final void run() {
                        if (a.this.l) {
                            a.this.b();
                            return;
                        }
                        a.this.c.startAnimation((Animation)animationSet2);
                        a.this.c.setVisibility(0);
                    }
                }, (long)(a.this.o / 3));
            }

        });
        animationSet2.setAnimationListener(new Animation.AnimationListener(){

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                a.this.c.postDelayed(new Runnable(){

                    public final void run() {
                        if (a.this.l) {
                            a.this.b();
                            return;
                        }
                        a.this.d.startAnimation((Animation)animationSet3);
                        a.this.d.setVisibility(0);
                    }
                }, (long)(a.this.o / 3));
            }

        });
    }

    final void b() {
        this.n = true;
        int n2 = this.q.getResources().getDimensionPixelOffset(2131165326);
        float f2 = (float)(this.q.getResources().getDimensionPixelOffset(2131165331) / 2) / (float)n2;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f2, 1.0f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(false);
        scaleAnimation.setDuration((long)(2 * this.o / 3));
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setDuration((long)(2 * this.o / 3));
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation((Animation)alphaAnimation);
        animationSet.addAnimation((Animation)scaleAnimation);
        animationSet.setFillAfter(true);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)this.g, (String)"rotation", (float[])new float[]{0.0f}).setDuration(300L);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((Object)this.h, (String)"rotation", (float[])new float[]{0.0f}).setDuration(300L);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{objectAnimator, objectAnimator2});
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 0.0f, 1, 1.0f);
        scaleAnimation2.setDuration(300L);
        scaleAnimation2.setFillAfter(true);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setFillAfter(true);
        alphaAnimation2.setDuration(300L);
        final AnimationSet animationSet2 = new AnimationSet(true);
        animationSet2.addAnimation((Animation)scaleAnimation2);
        animationSet2.addAnimation((Animation)alphaAnimation2);
        animationSet2.setFillAfter(true);
        new AlphaAnimation(1.0f, 0.0f).setDuration(120L);
        animatorSet.addListener(new Animator.AnimatorListener(){

            public final void onAnimationCancel(Animator animator2) {
            }

            public final void onAnimationEnd(Animator animator2) {
                a.this.g.setVisibility(8);
                a.this.h.setVisibility(8);
                a.this.f.startAnimation((Animation)animationSet2);
                a.this.f.setVisibility(0);
            }

            public final void onAnimationRepeat(Animator animator2) {
            }

            public final void onAnimationStart(Animator animator2) {
            }
        });
        animationSet2.setAnimationListener(new Animation.AnimationListener(){

            public final void onAnimationEnd(Animation animation) {
                a.this.c();
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }
        });
        animationSet.setAnimationListener(new Animation.AnimationListener(){

            public final void onAnimationEnd(Animation animation) {
                a.this.a.setVisibility(4);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                a.this.a.postDelayed(new Runnable(){

                    public final void run() {
                        animatorSet.start();
                    }
                }, 800L);
            }

        });
        this.a.startAnimation((Animation)animationSet);
    }

    public final void c() {
        this.i.setVisibility(8);
        this.j.setVisibility(8);
    }

    public final void d() {
        if (this.k && this.m && !this.l) {
            Log.d((String)"AnimationController", (String)"resume");
            this.a();
        }
    }

}

