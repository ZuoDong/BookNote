package com.administrator.opengles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.administrator.opengles.SolarSystem.SolarSystemActivity;
import com.administrator.opengles.activity.DrawIcosahedronActivity;
import com.administrator.opengles.activity.DrawLineActivity;
import com.administrator.opengles.activity.DrawTriangleActivity;
import com.administrator.opengles.activity.OpenGlSquareActivity;
import com.administrator.opengles.activity.RendererActivity;
import com.administrator.opengles.activity.PointActivity;

import java.util.ArrayList;
import java.util.List;

public class LaunchActivity extends AppCompatActivity {

    private ListView list_view;
    private List<Modedd> modedds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        list_view = (ListView) findViewById(R.id.list_view);
        initData();
    }

    private void initData() {
        modedds = new ArrayList<>();
        modedds.add(new Modedd("旋转方块",OpenGlSquareActivity.class));
        modedds.add(new Modedd("材质渲染",RendererActivity.class));
        modedds.add(new Modedd("画点",PointActivity.class));
        modedds.add(new Modedd("画线",DrawLineActivity.class));
        modedds.add(new Modedd("画三角形",DrawTriangleActivity.class));
        modedds.add(new Modedd("画多边形", DrawIcosahedronActivity.class));
        modedds.add(new Modedd("画星系图", SolarSystemActivity.class));

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < modedds.size(); i++) {
            strings.add(modedds.get(i).text);
        }
        list_view.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strings));
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(LaunchActivity.this,modedds.get(position).clz));
            }
        });
    }


    public class Modedd{

        public Modedd(String text, Class clz) {
            this.text = text;
            this.clz = clz;
        }

        public String text;
        public Class clz;
    }
}
