package com.example.popwidget;

import androidx.core.content.ContextCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.calendarwidget.R;

import java.util.List;

/**
 * 创建日期 2018/8/27 11:10. 文件描述:
 *
 * @author FangGang
 */
public class PopMoreSingleAdapter extends BaseQuickAdapter<ResPopItem, BaseViewHolder> {
  /**
   * 构造
   *
   * @param data 数据集
   */
  public PopMoreSingleAdapter(@androidx.annotation.NonNull List<ResPopItem> data) {
    super(R.layout.item_home_bottom_pop, data);
  }

  /**
   * Implement this method and use the helper to adapt the view to the given item.
   *
   * @param helper A fully initialized helper.
   * @param item The item that needs to be displayed.
   */
  @Override
  protected void convert(BaseViewHolder helper, ResPopItem item) {
    helper
            .setText(R.id.tv_content, item.getTitle())
            .setTextColor(
                    R.id.tv_content,
                    ContextCompat.getColor(
                            mContext, item.isEnable() ? R.color.color_999 : (item.isSelect() ?  R.color.c_E02020 : R.color.color_222222)));
  }
}
