package test.dmdfchina.com.glesdemo.mytest;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Window;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import test.dmdfchina.com.glesdemo.R;

public class CoordinatorActivity extends AppCompatActivity {
    private DrawerLayout drawer_layout;
    private NavigationView navigation;
    private CollapsingToolbarLayout collapsing_toolbar;
    private ImageView backdrop;
    private Toolbar toolbar;
    private TabLayout tab_layout;
    private ViewPager view_pager;
    private FloatingActionButton floatingActionButton;
    private String[] titles;
    private List<Fragment> allFragments=new ArrayList<Fragment>();
    private MyViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_coordinator);
        initView();
        initData();
        configViewPager();
    }

    private void configViewPager() {
        viewPagerAdapter=new MyViewPagerAdapter(getSupportFragmentManager(),titles,allFragments);
        view_pager.setAdapter(viewPagerAdapter);
        tab_layout.setupWithViewPager(view_pager);
        tab_layout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab_layout.setTabsFromPagerAdapter(viewPagerAdapter);

        //抽屉布局
        navigation.inflateHeaderView(R.layout.header_navigation);
        navigation.inflateMenu(R.menu.nav_menu);
        //设置悬停的标题
        collapsing_toolbar.setTitle("这是多样式");
        collapsing_toolbar.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));
        collapsing_toolbar.setCollapsedTitleGravity(Gravity.CENTER);
        backdrop=findViewById(R.id.backdrop);
        Picasso.with(this).load("http://pic22.nipic.com/20120715/3247605_105802332102_2.jpg").into(backdrop);
    }

    //初始化数据
    private void initData() {
        titles=getResources().getStringArray(R.array.tab_titles);
        for (int i=0;i<titles.length;i++){
            Bundle bundle=new Bundle();
            bundle.putInt("flags",i);
            Fragment fragment=new MyFragmentDemo();
            fragment.setArguments(bundle);
            allFragments.add(i,fragment);
        }
    }

    private void initView() {
        drawer_layout = findViewById(R.id.drawer_layout);
        navigation = findViewById(R.id.navigation);
        collapsing_toolbar = findViewById(R.id.collapsing_toolbar);
        backdrop = findViewById(R.id.backdrop);
        toolbar = findViewById(R.id.toolbar);
        tab_layout = findViewById(R.id.tab_layout);
        view_pager = findViewById(R.id.view_pager);
        floatingActionButton = findViewById(R.id.floating_button);
    }
    
    
}
