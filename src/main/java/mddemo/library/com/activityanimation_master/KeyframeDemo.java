package mddemo.library.com.activityanimation_master;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class KeyframeDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyframe_demo);
    }

    private void keyfram(View view) {
        float ballx = view.getX();
        Keyframe keyframe = Keyframe.ofFloat(0f, ballx);
        Keyframe keyframe1 = Keyframe.ofFloat(0.5f, ballx + 100f);
        Keyframe keyframe2 = Keyframe.ofFloat(1f, ballx + 50f);
        //用3个关键帧来进行构造properValuesHoldr的对象
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("x", keyframe, keyframe1, keyframe2);
        //再用三个关键帧构造objectanimation
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolder, propertyValuesHolder).setDuration(2000);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.RESTART);

    }
}
