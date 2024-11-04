package com.example.work3;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {
    private String[] animalNames = {"狮子", "老虎", "猴子", "狗", "猫", "大象"};
    private int[] animalImages = {
            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.monkey,
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        // 获取返回按钮
        Button backButton = findViewById(R.id.button_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 返回上一个界面
            }
        });

        // 获取ListView
        ListView listView = findViewById(R.id.listView);

        // 准备列表项数据
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < animalNames.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("name", animalNames[i]);
            listItem.put("image", animalImages[i]);
            listItems.add(listItem);
        }

        // 创建SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                listItems,
                R.layout.list_item,
                new String[]{"name", "image"},
                new int[]{R.id.item_text, R.id.item_image}
        );

        // 设置适配器
        listView.setAdapter(adapter);

        // 设置列表项点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                String animalName = animalNames[position];
                Toast.makeText(ListViewActivity.this, "你选择了: " + animalName, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
