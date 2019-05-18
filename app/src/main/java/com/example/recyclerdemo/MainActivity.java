package com.example.recyclerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerdemo.ItemTochHelp.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MainRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainRecyclerAdapter(this);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this));
        mRecyclerView.setAdapter(mAdapter);
        ItemTouchHelpCallback itemTouchHelpCallback=new ItemTouchHelpCallback();

        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(itemTouchHelpCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
        mAdapter.updateData(createTestDatas());
    }

    private List<TestModel> createTestDatas() {
        List<TestModel> result = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TestModel testModel= new TestModel(i,":Item Swipe Action Button Container Width");

            result.add(testModel);
        }
        return result;
    }
}
