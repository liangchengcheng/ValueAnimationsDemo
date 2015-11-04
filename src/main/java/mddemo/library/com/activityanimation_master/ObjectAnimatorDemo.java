package mddemo.library.com.activityanimation_master;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月4日13:22:19
 * Description: 我根据博客练习的值动画相关的知识：http://blog.csdn.net/lmj623565791/article/details/38067475
 */

public class ObjectAnimatorDemo  extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_animation_layout);

        //下面是点击图片之后产生的动画
        findViewById(R.id.id_ball).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                demo1(view);
            }
        });
    }

    //最基本的演示1
    private void demo1(View view){
        ObjectAnimator
                .ofFloat(view, "rotationX", 0.0F, 360.0F)
                .setDuration(500)
                .start();
    }

    //实现2个动画一起
    private  void roatteAnimRun(final View view){
        ObjectAnimator animator=ObjectAnimator
                .ofFloat(view, "rotationX", 0.0F, 360.0F)
                .setDuration(500);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (float) animation.getAnimatedValue();

                view.setAlpha(cVal);
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }

    private  void propertyValuesHolderdemo(View view){

        PropertyValuesHolder xpropertyValuesHolder=PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f);
        PropertyValuesHolder ypropertyValuesHolder=PropertyValuesHolder.ofFloat("scaleX",1f,0,1f);
        PropertyValuesHolder zpropertyValuesHolder=PropertyValuesHolder.ofFloat("scaleY",1f,0,1f);

    }

    private void verticalRun(View view){
        ValueAnimator animator=ValueAnimator.ofFloat(0,100f);
        animator.setTarget(view);
        animator.setDuration(2000).start();
    }
}
