package com.scnu.zhou.listviewdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.scnu.zhou.widget.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PullToRefreshListView.OnPullToRefreshListener{

    private List<String> array;

    private PullToRefreshListView pullToRefreshListView;
    private ArraysAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.pullToRefreshListView);

        array = new ArrayList<>();
        for (int i=0; i<15; i++){
            array.add(i + "");
        }
        adapter = new ArraysAdapter(array);
        pullToRefreshListView.setAdapter(adapter);
        pullToRefreshListView.setOnPullToRefreshListener(this);
    }

    @Override
    public void onRefresh() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                array = new ArrayList<>();
                for (int i=0; i<15; i++){
                    array.add(i + "");
                }
                adapter = new ArraysAdapter(array);
                pullToRefreshListView.setAdapter(adapter);
                pullToRefreshListView.onRefreshCompleted();
            }
        }, 3000);
    }

    @Override
    public void onLoadMore() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                array.add("15");
                array.add("16");
                pullToRefreshListView.onLoadMoreCompleted();
            }
        }, 2000);
    }

    @Override
    public void onOutOfTime() {

    }

    public class ArraysAdapter extends BaseAdapter{

        private List<String> array;

        public ArraysAdapter(List<String> array){

            this.array = array;
        }

        @Override
        public int getCount() {
            return array.size();
        }

        @Override
        public String getItem(int i) {
            return array.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.lisitem_array, null);
            TextView textView = (TextView) view1.findViewById(R.id.textView);
            textView.setText(array.get(i));
            return view1;
        }
    }
}
