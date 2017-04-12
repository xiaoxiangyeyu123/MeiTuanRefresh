/*
 * Copyright © Yan Zhenjie. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.meiduan.pulltorefrsh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<String> mDataList;

    public ContentAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void notifyDataSetChanged(List<String> dataList) {
        this.mDataList = dataList;
        super.notifyDataSetChanged();
    }

    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.item_main_content, parent, false));
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        holder.setData(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTvTitle;

        public ContentViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }

        public void setData(String data) {
            mTvTitle.setText(data);
        }

        @Override
        public void onClick(View v) {
        }
    }

}
