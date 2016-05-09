package com.icaboalo.consoles.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.icaboalo.consoles.R;
import com.icaboalo.consoles.ui.fragment.ConsolesFragment;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new ConsolesFragment());
    }

    void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
