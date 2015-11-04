package mddemo.library.com.activityanimation_master;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ViewAnimationDemo extends AppCompatActivity {


    private ImageView muleBall;
    private float mScreenHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation_demo);

        DisplayMetrics metric=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        mScreenHeight=metric.heightPixels;
        muleBall= (ImageView) findViewById(R.id.id_ball);
    }

    //api需要16+
    private void viewAnimation(View view){
        muleBall.animate().alpha(0).y(mScreenHeight/2).setDuration(1000)
                .withStartAction(new Runnable() {
                    @Override
                    public void run() {

                    }
                }).withEndAction(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        muleBall.setY(0);
                        muleBall.setAlpha(1.0f);
                    }
                });
            }
        }).start();
    }

    private void PropertyValueHolder(){
        PropertyValuesHolder x=PropertyValuesHolder.ofFloat("alpha",1f,0f,1f);
        PropertyValuesHolder y=PropertyValuesHolder.ofFloat("y",0,mScreenHeight/2);
        ObjectAnimator.ofPropertyValuesHolder(muleBall,x,y).setDuration(1000).start();
    }


}
