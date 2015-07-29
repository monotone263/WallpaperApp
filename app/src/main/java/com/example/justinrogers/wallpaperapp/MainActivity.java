package com.example.justinrogers.wallpaperapp;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            WallpaperManager wallMan = WallpaperManager.getInstance(this);
            imageView.setImageDrawable(wallMan.getDrawable());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // If the request went well (OK) and the request was PICK_CONTACT_REQUEST
        Log.d("OOTT", "Got here!!!");
        if (resultCode == Activity.RESULT_OK && requestCode == 1)
        {
            // Perform a query to the contact's content provider for the contact's name
            Cursor cursor = getContentResolver().query(data.getData(),
                    new String[]
                            {
                                    ContactsContract.Contacts.DISPLAY_NAME}, null, null, null);
                                    if (cursor.moveToFirst())
                                    { // True if the cursor is not empty
                                        int columnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                                        String name = cursor.getString(columnIndex);
                // Do something with the selected contact's name...
                                    }
        }
    }

    public void selectImage(View view)
    {
        Intent intent = new Intent(this, SelectImageActivity.class);
        startActivityForResult(intent, 1);
    }

    public void clearWallpaper(View view)
    {
        WallpaperManager wallMan = WallpaperManager.getInstance(this);
        try
        {
            wallMan.clear();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
