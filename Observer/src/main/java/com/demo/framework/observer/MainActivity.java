package com.demo.framework.observer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Observer<Member> {


    private ListView mMemeberLv;
    private List<Member> mMembers;

    private BaseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMemeberLv = findViewById(R.id.member_lv);

        mMembers = new ArrayList<>();

        setAdater();

        DatabaseManager.getInstanc().register(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mAdapter.notifyDataSetChanged();
    }

    private void setAdater() {
        if (mAdapter == null) {
            mAdapter = new BaseAdapter() {
                @Override
                public int getCount() {
                    return mMembers.size();
                }

                @Override
                public Object getItem(int position) {
                    return mMembers.get(position);
                }

                @Override
                public long getItemId(int position) {
                    return position;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    //忽略界面优化
                    TextView textTV = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
                    textTV.setText(mMembers.get(position).getName());
                    return null;
                }
            };
            mMemeberLv.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }


    public void addMember(View view) {
        Intent intent = new Intent(this, InsuranceActivity.class);
        startActivity(intent);
    }

    @Override
    public void update(Member member) {
        mMembers.add(member);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DatabaseManager.getInstanc().unRegister(this);
    }
}
