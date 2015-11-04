package mddemo.library.com.activityanimation_master;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class AnimationSetDemo extends AppCompatActivity {
    private ImageView mBlueBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_set_demo);
        mBlueBall = (ImageView) findViewById(R.id.id_ball);
    }

    //主要讲解2使用animationset设置2个动画一起执行
    private void togetherRun(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mBlueBall, "scaleX", 1.0f, 2f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mBlueBall, "scaleY", 1.0f, 2f);

        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.setDuration(3000);
        animatorSet.setInterpolator(new LinearInterpolator());
        //设置2个动画一起执行
        animatorSet.playTogether(objectAnimator,objectAnimator1);
        animatorSet.start();
    }

}
