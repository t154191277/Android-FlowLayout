package wmlove.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/6/4.
 */
public class FlowLayout extends ViewGroup{

    public FlowLayout(Context context) {
        super(context,null);
    }
/
    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeigh = MeasureSpec.getSize(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(widthMeasureSpec);


        int width = 0;
        int height = 0;

        int lineWidth = 0;
        int lineHeight = 0;

        int cCount = getChildCount();

        for(int i=0;i<cCount;i++){
            View child = getChildAt(i);
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            int childWidth = child.getWidth()+lp.leftMargin+lp.rightMargin;
            int childHeight = child.getHeight()+lp.topMargin+lp.bottomMargin;

            if(lineWidth + childWidth > sizeWidth){
                width = Math.max(width,lineWidth);
                lineWidth = childWidth;
                height += lineHeight;
                lineHeight = childHeight;
            }else{
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight,childHeight);
            }

            if(i == cCount - 1){
                width = Math.max(width,lineWidth);
                height += lineHeight;
            }
        }

        Log.i("TAG","sizeWidth="+sizeWidth);
        Log.i("TAG","sizeHeight="+sizeHeigh);

        setMeasuredDimension((modeWidth == MeasureSpec.AT_MOST) ? width : sizeWidth
                , (modeHeight == MeasureSpec.AT_MOST) ? height : sizeHeigh);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }
}
