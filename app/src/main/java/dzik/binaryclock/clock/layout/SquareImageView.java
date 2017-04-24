package dzik.binaryclock.clock.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

import dzik.binaryclock.R;

public class SquareImageView extends ImageView {
    private GradientDrawable mDrawable;
    public SquareImageView(Context context) {
        super(context);
        createView();
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        createView();
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        createView();
    }

    public void createView() {
        mDrawable = new GradientDrawable();
        mDrawable.setShape(GradientDrawable.OVAL);
        setImageDrawable(mDrawable);
    }

    public void toggle(boolean toggle) {
        int color;
        if(toggle) {
            color = Color.parseColor("#EEEEEE");
        } else {
            color = Color.parseColor("#000000");
        }
        mDrawable.setStroke((int) getContext().getResources().getDimension(R.dimen.circle_stroke_size), color);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        int margin = getMeasuredHeight() / 30;
        layoutParams.setMargins(margin, margin, margin, margin);
        requestLayout();
        setMeasuredDimension(getMeasuredHeight(), getMeasuredHeight());
    }
}