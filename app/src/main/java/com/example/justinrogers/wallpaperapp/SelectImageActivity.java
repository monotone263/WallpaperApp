package com.example.justinrogers.wallpaperapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
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

import java.lang.reflect.Field;


public class SelectImageActivity extends ActionBarActivity {

    ListView listView;
    String[] text = {"img0001", "img0002", "img0003", "img0004", "img0005", "img0006",
            "img0001", "img0002", "img0003", "img0004", "img0005", "img0006"};
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

                String tempValue = (String) parent.getItemAtPosition(position);
                String temp2 = view.toString();
                Log.d("LSTV", "the value from the list is " + tempValue + ", " + temp2);
                showPopup(view, tempValue);
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

    public void showPopup(View view, String selectedValue)
    {
        ImageView image = new ImageView(this);
        image.setBackgroundColor(Color.BLACK);
        image.setPadding(5,5,5,5);
        int picId = getResources().getIdentifier(selectedValue, "drawable", getApplicationContext().getPackageName());
        image.setImageResource(picId);


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Set Wallpaper");
        alertDialog.setMessage("Are you sure you want set this as the Wallpaper?");
        alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // continue with delete
            }
        });
        alertDialog.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // do nothing
            }
        });
        alertDialog.setView(image);
        alertDialog.show();
    }


}
