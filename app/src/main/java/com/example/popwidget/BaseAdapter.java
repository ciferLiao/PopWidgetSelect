package com.example.popwidget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calendarwidget.R;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T extends BaseSelect> extends RecyclerView.Adapter<ViewHolder> {

    protected OnItemClickListener mOnItemClickListener;
    private List<T> mDatas;

    private LayoutInflater layoutInflater;
    protected Context mContext;
    private boolean isMutiple = false;

    public BaseAdapter(Context context, boolean isMutiple){
        this.mContext = context;
        mDatas = new ArrayList<>();
        layoutInflater = LayoutInflater.from(this.mContext);
        this.isMutiple = isMutiple;
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull ViewHolder holder, int position) {
        onBindViewHolder(holder, getData(position), position);
    }

    public void setMutiple(boolean isMutiple){
        this.isMutiple = isMutiple;
    }

    /**
     * view与数据绑定
     *
     * @param holder
     * @param t
     * @param position
     */
    public void onBindViewHolder(@androidx.annotation.NonNull ViewHolder holder, T t, int position) {

    }

    @androidx.annotation.NonNull
    @Override
    public ViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View inflate = layoutInflater.inflate(getLayout(getLayoutId()), parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        onBindViewHolderClick(holder, holder.itemView);
        return holder;
    }


    public @LayoutRes int getLayout(@androidx.annotation.NonNull @LayoutRes int layout){
        return (layout == 0  ? (isMutiple ? R.layout.item_home_bottom_pop_mutiple : R.layout.item_home_bottom_pop) : layout);
    }

    /**
     * 实现item的点击事件
     */
    public void onBindViewHolderClick(@androidx.annotation.NonNull final ViewHolder viewHolder, View view) {
        //判断当前holder是否已经设置了点击事件
        if (!view.hasOnClickListeners()) {
            view.setOnClickListener(v -> {
                //获得holder的position
                int layoutPosition = viewHolder.getLayoutPosition();
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(layoutPosition);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return getDatas().size();
    }

    public List<T> getDatas() {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }
        return mDatas;
    }

    public void setDatas(List<T> datas) {
        if (datas != null && !datas.isEmpty()) {
            getDatas().clear();
            getDatas().addAll(datas);
        }
    }

    public void addDatas(List<T> datas){
        if (datas != null && !datas.isEmpty()) {
            getDatas().addAll(datas);
        }
    }

    @androidx.annotation.Nullable
    public T getData(int position) {
        if (position >= 0) {
            return getDatas().get(position);
        }
        return null;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void clear() {
        getDatas().clear();
    }

    /**
     * 获取该position的item的layout
     * 用原本控件不需要填写
     * @return item的layout id
     */
    public abstract @LayoutRes int getLayoutId();

}
