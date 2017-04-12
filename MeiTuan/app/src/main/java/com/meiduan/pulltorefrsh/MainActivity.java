package com.meiduan.pulltorefrsh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class MainActivity extends AppCompatActivity {

    private ContentAdapter mContentAdapter;
    private List<String> mDataList;

    private PtrFrameLayout mPtrFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mContentAdapter = new ContentAdapter(this);
        recyclerView.setAdapter(mContentAdapter);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.refresh_layout);
        mPtrFrameLayout.setPtrHandler(mPtrHandler);
        requestDataList();

    }

    private PtrHandler mPtrHandler = new PtrDefaultHandler() {
        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            // 这里延时2000ms，模拟网络请求。
            mPtrFrameLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    requestDataList();
                }
            }, 2000);
        }
    };

    private void requestDataList() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mDataList.add("是第" + i + "个");
        }
        mContentAdapter.notifyDataSetChanged(mDataList);

        mPtrFrameLayout.refreshComplete();
    }
}
