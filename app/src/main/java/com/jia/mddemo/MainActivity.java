package com.jia.mddemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    private FloatingActionButton fab;

    private RecyclerView rv_main;

    private NavigationView nav_view;

    private DrawerLayout drawer;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mContext=MainActivity.this;

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        nav_view = (NavigationView) findViewById(R.id.nav_view);
        drawer = (DrawerLayout) findViewById(R.id.drawer);


        //设置App图标
//        toolbar.setLogo(R.mipmap.ic_launcher);
        //设置导航的图标
        toolbar.setNavigationIcon(R.mipmap.ic_menu);
        // 设置主标题
        toolbar.setTitle("J++");
        // 设置子标题
//        toolbar.setSubtitle("MaterialDesign");

        setSupportActionBar(toolbar);


        fab.setOnClickListener(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawer.openDrawer(Gravity.LEFT);
            }
        });

    }
    //                Snackbar snackbar=Snackbar.make(view,"提示",Snackbar.LENGTH_LONG);
//                snackbar.setAction("关闭", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                });
//                // 设置右侧Action按钮颜色
//                snackbar.setActionTextColor(Color.RED);
//                // 设置提示框背景色
//                snackbar.getView().setBackgroundColor(Color.BLUE);
//                snackbar.show();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
//                Snackbar.make(toolbar, "搜索", Snackbar.LENGTH_LONG).show();
                startActivity(new Intent(mContext,ScrollingActivity.class));
                break;
            case R.id.action_add:
                Snackbar.make(toolbar, "更多", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.action_setting:
                Snackbar.make(toolbar, "设置", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.action_help:
                Snackbar.make(toolbar, "帮助", Snackbar.LENGTH_LONG).show();
                break;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:

                Snackbar.make(view, "悬浮框", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                break;
        }
    }
}
