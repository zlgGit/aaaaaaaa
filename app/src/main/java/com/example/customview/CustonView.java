package com.example.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 16-3-29.
 */
public class CustonView extends View {
    public CustonView(Context context) {
        this(context, null);
        //当textview的长度不会大于父控件!!!
    }

    public CustonView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //一个模式一个大小
        //三种模式
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);//最高的两位数
        //
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);//前面两位不要
        switch (widthmode)
        {
            //未知空间，真正的包裹内容。可以滑动的时候，滚动条
            //滚动的另一方，不滚动的方向，不影响
            //listview中的item最外层的控件，匹配不到父窗口
            //即使写的是固定大小也是，匹配不到父窗口是，都是UNSPECIFIED模式模式
            //
            case MeasureSpec.UNSPECIFIED:
                //在此模式下widthsize没有意义、
                widthsize=200;
                break;
            //尽可能大，xml内容包裹对应的模式AT_MOST
            case MeasureSpec.AT_MOST:
                //在此模式下不能超过widthsize
                widthsize=Math.min(200,widthsize);

                break;
            //确定的，在xml文件中，指定的高度和match parent对应EXACTLY模式
            case MeasureSpec.EXACTLY:
                //在此模式下就是widthsize
                break;
            //match_parent根据父控件的模式使用，
            //

        }
        // 默认不会计算大小
//        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int Hmode = MeasureSpec.getMode(heightMeasureSpec);
        int Hsize = MeasureSpec.getSize(heightMeasureSpec);
        switch (Hmode)
        {
            //未知空间，真正的包裹内容。可以滑动的时候，滚动条
            //滚动的另一方，不滚动的方向，不影响
            //listview中的item最外层的控件，匹配不到父窗口
            //即使写的是固定大小也是，匹配不到父窗口是，都是UNSPECIFIED模式模式
            //
            case MeasureSpec.UNSPECIFIED:
                //在此模式下widthsize没有意义、
                Hsize=200;
                break;
            //尽可能大，xml内容包裹对应的模式AT_MOST
            case MeasureSpec.AT_MOST:
                //在此模式下不能超过widthsize
                Hsize=Math.min(200,widthsize);

                break;
            //确定的，在xml文件中，指定的高度和match parent对应EXACTLY模式
            case MeasureSpec.EXACTLY:
                //在此模式下就是widthsize
                break;
            //match_parent根据父控件的模式使用，
            //

        }

        setMeasuredDimension(widthsize, Hsize);//自己测量
    }
}
