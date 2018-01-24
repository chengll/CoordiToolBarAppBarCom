package test.dmdfchina.com.glesdemo.mytest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Timer;
import java.util.TimerTask;

import test.dmdfchina.com.glesdemo.R;

/**
 * Created by mkt on 2018/1/24.
 */

public class MyFragmentDemo extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private int[] colors={R.color.colorAccent,R.color.colorPrimary,R.color.colorPrimaryDark};
    private Timer timer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_frament,container,false);
        mRecyclerView=view.findViewById(R.id.recycler_view);
        refreshLayout=view.findViewById(R.id.swipe_refresh);
        refreshLayout.setColorSchemeColors(colors);
        refreshLayout.setOnRefreshListener(this);
        myAdapter=new MyAdapter(getActivity());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(myAdapter);
        return  view;
    }

    @Override
    public void onRefresh() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                    }
                });
            }
        },3000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (timer!=null){
            timer.cancel();
        }
    }
}
