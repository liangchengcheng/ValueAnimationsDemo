package mddemo.library.com.activityanimation_master;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class ValueAnimatorDemo extends AppCompatActivity {

    private ImageView id_ball;
    private float mScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator_demo);
        id_ball = (ImageView) findViewById(R.id.id_ball);

        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        mScreenHeight = outMetrics.heightPixels;
    }

    //左上角一个小球，底部两个按钮~我们先看一个自由落体的代码：
    private void verticalRun(View view) {
        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mScreenHeight - id_ball.getHeight());
        valueAnimator.setTarget(id_ball);
        valueAnimator.setDuration(2000).start();

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                id_ball.setTranslationY((Float) valueAnimator.getAnimatedValue());
            }
        });
    }

    //抛物线
    private void paowuxian(View view) {
        ValueAnimator animator = new ValueAnimator();
        animator.setDuration(3000);
        animator.setObjectValues(new PointF(0, 0));
        //设置一个差值器
        animator.setInterpolator(new LinearInterpolator());
        animator.setEvaluator(new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                //x方向是200px/s y是。05*10*t
                PointF point = new PointF();
                point.x
                        = 200 * fraction * 3;
                point.y
                        = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointf = (PointF) animation.getAnimatedValue();
                id_ball.setX(pointf.x);
                id_ball.setY(pointf.y);
            }
        });
    }
}
