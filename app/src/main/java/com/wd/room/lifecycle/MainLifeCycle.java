package com.wd.room.lifecycle;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.room.Room;

import com.wd.room.AppDatabase;
import com.wd.room.LoginModel;
import com.wd.room.R;
import com.wd.room.User;
import com.wd.room.UserDao;
import com.wd.room.databinding.ActivityMainBinding;

import java.util.List;
import java.util.Random;

/**
 * 实现业务和页面的完全解耦，而且做到了内存和性能提升
 * 观察者模式，AppCompatActivity作为被观察者，如果被android系统回收之后，
 * 那么所有的LifecycleObserver观察者由于观察不到对象，则被系统自动回收，
 * 优化内存释放，提升了程序性能
 */
public class MainLifeCycle implements LifecycleObserver, View.OnClickListener {
    ActivityMainBinding binding;
    Context context;
    UserDao userDao;
    Random random = new Random(10000);
    public MainLifeCycle(ActivityMainBinding binding, Context context) {
        this.binding = binding;
        this.context = context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void create(){
        Log.i("dt","create()");
        AppDatabase appDatabase = Room.databaseBuilder(context, AppDatabase.class, "Sample.db")
                .build();

        userDao = appDatabase.getUserDao();
        binding.insert.setOnClickListener(this);
        binding.query.setOnClickListener(this);
        binding.request.setOnClickListener(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resume(){
        Log.i("dt","resume()");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.insert){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    userDao.insertUsers(new User("小明"+random.nextInt(),random.nextInt(),"男","我也不知道啊"));
                }
            }).start();
        }else if(v.getId() == R.id.query){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<User> userList = userDao.loadAllUsers();
                    Log.i("dt","查询出来："+userList.size());
                }
            }).start();
        }else if(v.getId()==R.id.request){//模拟请求数据
            LoginModel loginModel = new LoginModel(binding);
            loginModel.login("13126965104","123456");
        }
    }
}
