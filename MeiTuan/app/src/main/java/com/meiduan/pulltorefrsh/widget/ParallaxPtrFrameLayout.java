/*
 * AUTHOR：Yan Zhenjie
 *
 * DESCRIPTION：create the File, and add the content.
 *
 * Copyright © ZhiMore. All Rights Reserved
 *
 */
package com.meiduan.pulltorefrsh.widget;

import android.content.Context;
import android.util.AttributeSet;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Yan Zhenjie on 2016/11/21.
 */
public class ParallaxPtrFrameLayout extends PtrFrameLayout {

    private PullToRefreshHeader mParallaxHeader;

    public ParallaxPtrFrameLayout(Context context) {
        super(context);
        initViews();
    }

    public ParallaxPtrFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public ParallaxPtrFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }

    private void initViews() {
        mParallaxHeader = new PullToRefreshHeader(getContext());
        setHeaderView(mParallaxHeader);
        addPtrUIHandler(mParallaxHeader);
    }

    public PullToRefreshHeader getHeader() {
        return mParallaxHeader;
    }
}
