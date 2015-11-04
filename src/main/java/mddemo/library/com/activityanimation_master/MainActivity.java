package mddemo.library.com.activityanimation_master;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com 
 * Date:    2015年11月4日14:33:30
 * Description:http://blog.csdn.net/lmj623565791/article/details/38092093
 */
// TODO: 2015/11/4  这个只是我研究动画的demo 具体代码请查看上面的博客里面地址
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ObjectAnimatorDemo.class));
            }
        });
    }


}
