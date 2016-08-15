package com.example.sapeu.learnrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        setContentView(R.layout.activity_main);
        recyclerView = new RecyclerView(this);
        setContentView(recyclerView);
        // 使用线性布局
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL,true));
        // 使用表格布局,3是列的数量
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(
                new MyAdapter()
                /*new RecyclerView.Adapter() {
                    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
                        private TextView textView;

                        public RecyclerViewViewHolder(TextView itemView) {
                            super(itemView);
                            textView = itemView;
                        }

                        public void setTextView(TextView textView) {
                            this.textView = textView;
                        }

                        public TextView getTextView() {
                            return textView;
                        }
                    }

                    *//**
                     * @param parent   ViewGroup
                     * @param viewType 类型
                     * @return 创建View Holder的方法
                     *//*
                    @Override
                    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        return new RecyclerViewViewHolder(new TextView(parent.getContext()));
                    }

                    *//**
                     * 绑定View Holder的方法
                     *
                     * @param holder   通过onCreateViewHolder方法创建的RecyclerView.ViewHolder
                     * @param position 索引
                     *//*
                    @Override
                    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;
                        TextView textView = viewHolder.getTextView();
                        textView.setText(strings[position]);
                    }

                    *//**
                     * @return 创建recyclerView的子对象有10个
                     *//*
                    @Override
                    public int getItemCount() {
                        return strings.length;
                    }

                    private String[] strings = "月溅星河 长路漫漫\n风烟残尽 独影阑珊\n谁叫我身手不凡\n谁让我爱恨两难\n到后来 肝肠寸断\n幻世当空 恩怨休怀\n舍悟离迷 六尘不改\n且怒且悲且狂哉\n是人是鬼是妖怪\n不过是 心有魔债\n叫一声佛祖 回头无岸\n跪一人为师 生死无关\n善恶浮世真假界\n尘缘散聚不分明 难断\n我要 这铁棒有何用\n我有 这变化又如何\n还是不安 还是氐惆\n金箍当头 欲说还休\n世间变化千百般 终是空空浮云烟\n我虽有七十二变 不改初衷心中念\n路 万水千山 魔 有多妖艳\n道种在彼此心间 不改吾生发弘愿\n叫一声佛祖 回头无岸\n跪一人为师 生死无关\n善恶浮世真假界\n尘缘散聚不分明\n难断\n我要 这铁棒有何用\n我有 这变化又如何\n还是不安 还是氐惆\n金箍当头 欲说还休\n我要 这铁棒醉舞魔\n我有 这变化乱迷浊\n踏碎灵霄 放肆桀骜\n世恶道险 终究难逃\n这一棒\n叫你灰飞烟灭".split("\n");

                }*/
        );
    }

}
