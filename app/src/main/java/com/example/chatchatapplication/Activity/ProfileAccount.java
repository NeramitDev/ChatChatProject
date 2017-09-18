package com.example.chatchatapplication.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chatchatapplication.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileAccount extends AppCompatActivity {

    TextView displayName, userName,Email;
    LinearLayout topLinear;
    LinearLayout.LayoutParams p;
    String displayname, username, email;
    CircleImageView userImage;

    // Shared preferrence
    SharedPreferences sp;
    SharedPreferences.Editor mEdit1;

    @Override
    protected void onStart() {
        super.onStart();
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        mEdit1 = sp.edit();

        displayname = sp.getString("displayName", null);
        username = sp.getString("username",null);
        email = sp.getString("email",null);

        if (displayName != null) {
            displayName.setText(displayname);
        }else{
            displayName.setText(username);
        }
        userName.setText(username);
        Email.setText(email);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setIcon(R.drawable.profile_icon);
        getSupportActionBar().setTitle(R.string.title_profile);
        setContentView(R.layout.activity_profile_account);

        userImage = (CircleImageView) findViewById(R.id.user_image);
        topLinear = (LinearLayout) findViewById(R.id.topLinear);
        displayName = (TextView) findViewById(R.id.displayname);
        userName = (TextView) findViewById(R.id.user_name);
        Email = (TextView) findViewById(R.id.Email);
    }

    public void changeDisplayname(View v) {
        startActivity(new Intent(this, ChangeDisplayname.class));
    }

    public void changeUserPicture(View v) {
        startActivity(new Intent(this, ChangeDisplayname.class));
    }
}
