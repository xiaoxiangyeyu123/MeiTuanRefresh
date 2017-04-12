package com.meiduan.pulltorefrsh.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.meiduan.pulltorefrsh.R;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by Administrator on 2017/4/12.
 */

public class PullToRefreshHeader extends FrameLayout implements PtrUIHandler {

    private ImageView mIvIcon;
    private AnimationDrawable mIconAnim1_three;
    private AnimationDrawable mIconAnim1_two;
    private boolean isRunAnimation;

    public PullToRefreshHeader(Context context) {
        this(context, null, 0);
    }

    public PullToRefreshHeader(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PullToRefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.refresh_pulltorefresh, this);
        mIvIcon = (ImageView) findViewById(R.id.iv_refresh_icon);
        mIconAnim1_three = (AnimationDrawable) mIvIcon.getBackground();
        mIconAnim1_two = (AnimationDrawable) getResources().getDrawable(R.drawable.pull_to_refresh_second_anim);

    }

    private void startAnimation() {
        if (!isRunAnimation) {
            isRunAnimation = true;
            mIvIcon.setBackgroundDrawable(mIconAnim1_three);
            mIconAnim1_three.start();
        }
    }

    private void stopAnimation() {
            isRunAnimation = false;
            mIconAnim1_three.stop();
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {
        stopAnimation();

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        stopAnimation();
        startAnimation();

    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        stopAnimation();
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        // 获取总的头部可下拉的距离：
        final int offsetToRefresh = frame.getOffsetToRefresh();
        // 获取当前手指已经下拉的距离：
        final int currentPos = ptrIndicator.getCurrentPosY();
        if (currentPos <= offsetToRefresh && !isRunAnimation) {
            double percent = (double) currentPos / offsetToRefresh;
            if (percent < 0.4) {
                mIvIcon.setBackgroundResource(R.mipmap.pull_image);
            } else if (percent >= 0.4 && percent < 0.6) {
                mIvIcon.setBackgroundDrawable(mIconAnim1_two.getFrame(0));

            } else if (percent >= 0.6 && percent < 0.7) {
                mIvIcon.setBackgroundDrawable(mIconAnim1_two.getFrame(1));
            }else if (percent >= 0.7 && percent < 0.8) {
                mIvIcon.setBackgroundDrawable(mIconAnim1_two.getFrame(2));
            }else if (percent >= 0.8 && percent < 0.9) {
                mIvIcon.setBackgroundDrawable(mIconAnim1_two.getFrame(3));
            }else if (percent >= 0.9) {
                mIvIcon.setBackgroundDrawable(mIconAnim1_two.getFrame(4));
            }
        }

    }
}
