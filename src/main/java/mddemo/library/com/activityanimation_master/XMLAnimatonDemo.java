package mddemo.library.com.activityanimation_master;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com 
 * Date:2015年11月4日14:31:03    
 * Description:
 */

// TODO: 2015/11/4 需要注意的是这个只是介绍加载xml定义的动画
public class XMLAnimatonDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlanimaton_demo);
    }


    private void scale(View view){
        //记载动画
        Animator animator= AnimatorInflater.loadAnimator(this,R.animator.scale);
        animator.setTarget(view);
        animator.start();
    }
}
