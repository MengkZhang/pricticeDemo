package com.zhang.titlealpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    RelativeLayout mTitle;
    ObservableScrollView mScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.iv);
        mTitle = findViewById(R.id.title);
        mScrollView = findViewById(R.id.sv);
        mScrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(ScrollView scrollView, int x, int y, int oldx, int oldy) {
                Log.e("===z","偏移量 = " + y);
                //计算偏移量
                int height = mImageView.getHeight();
                if (y <= height) {
                    float alpha = (float) y / height;
                    mTitle.setAlpha(alpha);
                } else {
                    //将标题栏的颜色设置为完全不透明状态
                    mTitle.setAlpha(1.0f);
                }
            }
        });
    }
}
