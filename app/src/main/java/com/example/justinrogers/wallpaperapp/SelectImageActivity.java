package com.example.justinrogers.wallpaperapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class SelectImageActivity extends ActionBarActivity {

    ListView listView;
    String[] text = {"img1", "img2", "img3", "img4", "img5", "img6",
            "img1", "img2", "img3", "img4", "img5", "img6"};
    Integer[] imgValues = {
            R.drawable.img0001,
            R.drawable.img0002,
            R.drawable.img0003,
            R.drawable.img0004,
            R.drawable.img0005,
            R.drawable.img0006,
            R.drawable.img0001,
            R.drawable.img0002,
            R.drawable.img0003,
            R.drawable.img0004,
            R.drawable.img0005,
            R.drawable.img0006
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        final CustomList adapter = new
                CustomList(SelectImageActivity.this, text, imgValues);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(SelectImageActivity.this, "You Clicked at " + text[+position], Toast.LENGTH_SHORT).show();
               // ImageView imageView = (ImageView)findViewById(R.id.imageView2);
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));

                ImageView image = (ImageView) layout.findViewById(R.id.image);
                image.setImageResource(R.drawable.img0001);
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("Hello! This is a custom toast!");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
