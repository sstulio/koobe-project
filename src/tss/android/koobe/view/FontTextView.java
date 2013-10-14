package tss.android.koobe.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


public class FontTextView extends TextView {

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface font = Typeface.createFromAsset(context.getAssets(), "font/Neo_Sans.ttf");
        setTypeface(font);
    }

}
