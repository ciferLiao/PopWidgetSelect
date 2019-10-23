package com.example.popwidget;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ActionSheetUtils {


    public static CustomPopuWindow initTitleBottomPop(Activity context,
                                                      String title, List<ResPopItem> data, BottomPopCallBack callBack){
        View popContentView = View.inflate(context, R.layout.layout_bottom_pop, null);
        RecyclerView recyclerView = popContentView.findViewById(R.id.pop_recyclerview);
        View cancel = popContentView.findViewById(R.id.cancel);
        ImageView backGround = popContentView.findViewById(R.id.iv_dark);
        BaseAdapter baseAdapter = new BaseAdapter(context,false) {
            @Override
            public int getLayoutId() {
                return 0;
            }

            @Override
            public void onBindViewHolder(@androidx.annotation.NonNull ViewHolder holder, int position) {
                holder.setNormalSingleContent(holder,getData(position));
            }
        };
        baseAdapter.setDatas(data);
        recyclerView.setAdapter(baseAdapter);

        TextView titleView = popContentView.findViewById(R.id.tv_pop_title);
        titleView.setText(title);

        CustomPopuWindow mPopuWindow =
                new CustomPopuWindow(
                        popContentView,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        mPopuWindow.setAnimationStyle(android.R.style.Animation_InputMethod);

        baseAdapter.setOnItemClickListener(
                (position) ->{
                    mPopuWindow.dismiss();
                    ResPopItem o = (ResPopItem) baseAdapter.getData(position);
                    if(o.isEnable()){
                        return;
                    }
                    for (ResPopItem item : data){
                        item.setSelect(item == o);
                    }
                    baseAdapter.notifyDataSetChanged();
                    callBack.onBottomItemClick();
                });
        mPopuWindow.setOutsideTouchable(true);
        mPopuWindow.setTouchable(true);
        mPopuWindow.setFocusable(true);
        mPopuWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context,android.R.color.transparent)));
        mPopuWindow.setOnDismissListener(
                () -> {
                });
        cancel.setOnClickListener(v -> mPopuWindow.dismiss());
        backGround.setOnClickListener(v -> mPopuWindow.dismiss());

        return mPopuWindow;
    }

    public static CustomPopuWindow initTitleBottomPop(Activity context, List<ResPopItem> data, BottomPopCallBack callBack){
        View popContentView = View.inflate(context, R.layout.layout_bottom_pop, null);
        RecyclerView recyclerView = popContentView.findViewById(R.id.pop_recyclerview);
        View cancel = popContentView.findViewById(R.id.cancel);
        popContentView.findViewById(R.id.line_ll).setVisibility(View.GONE);
        ImageView backGround = popContentView.findViewById(R.id.iv_dark);
        BaseAdapter baseAdapter = new BaseAdapter(context,false) {
            @Override
            public int getLayoutId() {
                return 0;
            }

            @Override
            public void onBindViewHolder(@androidx.annotation.NonNull ViewHolder holder, int position) {
                holder.setNormalSingleContent(holder,getData(position));
            }
        };
        baseAdapter.setDatas(data);
        recyclerView.setAdapter(baseAdapter);

        CustomPopuWindow mPopuWindow =
                new CustomPopuWindow(
                        popContentView,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        mPopuWindow.setAnimationStyle(android.R.style.Animation_InputMethod);

        baseAdapter.setOnItemClickListener(
                (position) ->{
                    mPopuWindow.dismiss();
                    ResPopItem o = (ResPopItem) baseAdapter.getData(position);
                    if(o.isEnable()){
                        return;
                    }
                    for (ResPopItem item : data){
                        item.setSelect(item == o);
                    }
                    baseAdapter.notifyDataSetChanged();
                    callBack.onBottomItemClick();
                });
        mPopuWindow.setOutsideTouchable(true);
        mPopuWindow.setTouchable(true);
        mPopuWindow.setFocusable(true);
        mPopuWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context,android.R.color.transparent)));
        mPopuWindow.setOnDismissListener(
                () -> {
                });
        cancel.setOnClickListener(v -> mPopuWindow.dismiss());
        backGround.setOnClickListener(v -> mPopuWindow.dismiss());

        return mPopuWindow;
    }

    public static CustomPopuWindow initTitleBottomPopByAdapter(Activity context, @androidx.annotation.NonNull BaseAdapter adapter, BottomPopCallBack callBack){
        View popContentView = View.inflate(context, R.layout.layout_bottom_pop_mutiple, null);
        RecyclerView recyclerView = popContentView.findViewById(R.id.pop_recyclerview);
        View cancel = popContentView.findViewById(R.id.cancel);
        View submit = popContentView.findViewById(R.id.submit);
        popContentView.findViewById(R.id.line_ll).setVisibility(View.GONE);
        ImageView backGround = popContentView.findViewById(R.id.iv_dark);

        recyclerView.setAdapter(adapter);

        CustomPopuWindow mPopuWindow =
                new CustomPopuWindow(
                        popContentView,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        mPopuWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        mPopuWindow.setOutsideTouchable(true);
        mPopuWindow.setTouchable(true);
        mPopuWindow.setFocusable(true);
        mPopuWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context,android.R.color.transparent)));
        mPopuWindow.setOnDismissListener(
                () -> {
                });
        cancel.setOnClickListener(v -> mPopuWindow.dismiss());
        backGround.setOnClickListener(v -> mPopuWindow.dismiss());
        submit.setOnClickListener(v -> callBack.onBottomItemClick());
        return mPopuWindow;
    }

    public static CustomPopuWindow initTitleBottomPop(Activity context, @androidx.annotation.NonNull BaseAdapter adapter, BottomPopCallBack callBack){
        View popContentView = View.inflate(context, R.layout.layout_bottom_pop_mutiple, null);
        RecyclerView recyclerView = popContentView.findViewById(R.id.pop_recyclerview);
        View cancel = popContentView.findViewById(R.id.cancel);
        View submit = popContentView.findViewById(R.id.submit);
        popContentView.findViewById(R.id.line_ll).setVisibility(View.GONE);
        ImageView backGround = popContentView.findViewById(R.id.iv_dark);

        adapter.setMutiple(false);

        recyclerView.setAdapter(adapter);

        CustomPopuWindow mPopuWindow =
                new CustomPopuWindow(
                        popContentView,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        mPopuWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        mPopuWindow.setOutsideTouchable(true);
        mPopuWindow.setTouchable(true);
        mPopuWindow.setFocusable(true);
        mPopuWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context,android.R.color.transparent)));
        mPopuWindow.setOnDismissListener(
                () -> {
                });
        cancel.setOnClickListener(v -> mPopuWindow.dismiss());
        backGround.setOnClickListener(v -> mPopuWindow.dismiss());
        submit.setOnClickListener(v -> callBack.onBottomItemClick());
        return mPopuWindow;
    }

    public static CustomPopuWindow initTitleBottomPopByAdapter(Activity context,
                                                               String title, @androidx.annotation.NonNull BaseAdapter adapter, BottomPopCallBack callBack){
        View popContentView = View.inflate(context, R.layout.layout_bottom_pop_mutiple, null);
        RecyclerView recyclerView = popContentView.findViewById(R.id.pop_recyclerview);
        View cancel = popContentView.findViewById(R.id.cancel);
        View submit = popContentView.findViewById(R.id.submit);
        ImageView backGround = popContentView.findViewById(R.id.iv_dark);

        recyclerView.setAdapter(adapter);

        TextView titleView = popContentView.findViewById(R.id.tv_pop_title);
        titleView.setText(title);

        CustomPopuWindow mPopuWindow =
                new CustomPopuWindow(
                        popContentView,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        mPopuWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        mPopuWindow.setOutsideTouchable(true);
        mPopuWindow.setTouchable(true);
        mPopuWindow.setFocusable(true);
        mPopuWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context,android.R.color.transparent)));
        mPopuWindow.setOnDismissListener(
                () -> {
                });
        cancel.setOnClickListener(v -> mPopuWindow.dismiss());
        backGround.setOnClickListener(v -> mPopuWindow.dismiss());
        submit.setOnClickListener(v -> callBack.onBottomItemClick());
        return mPopuWindow;
    }

    public static CustomPopuWindow initTitleBottomPop(Activity context,
                                                      String title, @androidx.annotation.NonNull BaseAdapter adapter, BottomPopCallBack callBack){
        View popContentView = View.inflate(context, R.layout.layout_bottom_pop_mutiple, null);
        RecyclerView recyclerView = popContentView.findViewById(R.id.pop_recyclerview);
        View cancel = popContentView.findViewById(R.id.cancel);
        View submit = popContentView.findViewById(R.id.submit);
        ImageView backGround = popContentView.findViewById(R.id.iv_dark);

        adapter.setMutiple(false);

        recyclerView.setAdapter(adapter);

        TextView titleView = popContentView.findViewById(R.id.tv_pop_title);
        titleView.setText(title);

        CustomPopuWindow mPopuWindow =
                new CustomPopuWindow(
                        popContentView,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        mPopuWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        mPopuWindow.setOutsideTouchable(true);
        mPopuWindow.setTouchable(true);
        mPopuWindow.setFocusable(true);
        mPopuWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context,android.R.color.transparent)));
        mPopuWindow.setOnDismissListener(
                () -> {
                });
        cancel.setOnClickListener(v -> mPopuWindow.dismiss());
        backGround.setOnClickListener(v -> mPopuWindow.dismiss());
        submit.setOnClickListener(v -> callBack.onBottomItemClick());
        return mPopuWindow;
    }


    public static CustomPopuWindow initTitleBottomPopMutiple(Activity context,
                                                             String title, List<ResPopItem> data, BottomPopCallBack callBack){
        View popContentView = View.inflate(context, R.layout.layout_bottom_pop_mutiple, null);
        RecyclerView recyclerView = popContentView.findViewById(R.id.pop_recyclerview);
        View cancel = popContentView.findViewById(R.id.cancel);
        View submit = popContentView.findViewById(R.id.submit);
        ImageView backGround = popContentView.findViewById(R.id.iv_dark);

        BaseAdapter baseAdapter = new BaseAdapter(context,true) {
            @Override
            public int getLayoutId() {
                return 0;
            }

            @Override
            public void onBindViewHolder(@androidx.annotation.NonNull ViewHolder holder, int position) {
                holder.setNormalMutipleContent(holder,getData(position));
            }
        };
        baseAdapter.setDatas(data);
        recyclerView.setAdapter(baseAdapter);

        TextView titleView = popContentView.findViewById(R.id.tv_pop_title);
        titleView.setText(title);

        CustomPopuWindow mPopuWindow =
                new CustomPopuWindow(
                        popContentView,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        mPopuWindow.setAnimationStyle(android.R.style.Animation_InputMethod);

        baseAdapter.setOnItemClickListener(
                (position) ->{
                    ResPopItem o = (ResPopItem) baseAdapter.getData(position);
                    if(o.isEnable()){
                        return;
                    }
                    for (ResPopItem item : data){
                        if(item == o) {
                            item.setSelect(!item.isSelect());
                        }
                    }
                    baseAdapter.notifyDataSetChanged();
                });
        mPopuWindow.setOutsideTouchable(true);
        mPopuWindow.setTouchable(true);
        mPopuWindow.setFocusable(true);
        mPopuWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context,android.R.color.transparent)));
        mPopuWindow.setOnDismissListener(
                () -> {
                });
        cancel.setOnClickListener(v -> mPopuWindow.dismiss());
        backGround.setOnClickListener(v -> mPopuWindow.dismiss());
        submit.setOnClickListener(v -> callBack.onBottomItemClick());
        return mPopuWindow;
    }

    public static CustomPopuWindow initTitleBottomPopMutiple(Activity context,
                                                             String title, @androidx.annotation.NonNull BaseAdapter adapter, BottomPopCallBack callBack){
        View popContentView = View.inflate(context, R.layout.layout_bottom_pop_mutiple, null);
        RecyclerView recyclerView = popContentView.findViewById(R.id.pop_recyclerview);
        View cancel = popContentView.findViewById(R.id.cancel);
        View submit = popContentView.findViewById(R.id.submit);
        ImageView backGround = popContentView.findViewById(R.id.iv_dark);

        adapter.setMutiple(true);

        recyclerView.setAdapter(adapter);

        TextView titleView = popContentView.findViewById(R.id.tv_pop_title);
        titleView.setText(title);

        CustomPopuWindow mPopuWindow =
                new CustomPopuWindow(
                        popContentView,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        mPopuWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        mPopuWindow.setOutsideTouchable(true);
        mPopuWindow.setTouchable(true);
        mPopuWindow.setFocusable(true);
        mPopuWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context,android.R.color.transparent)));
        mPopuWindow.setOnDismissListener(
                () -> {
                });
        cancel.setOnClickListener(v -> mPopuWindow.dismiss());
        backGround.setOnClickListener(v -> mPopuWindow.dismiss());
        submit.setOnClickListener(v -> callBack.onBottomItemClick());
        return mPopuWindow;
    }


    public static int getScreenHeight(Activity context){
        DisplayMetrics metrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }

    public interface BottomPopCallBack{
        void onBottomItemClick();
    }
}
