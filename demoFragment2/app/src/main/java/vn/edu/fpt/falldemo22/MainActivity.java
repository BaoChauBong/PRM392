package vn.edu.fpt.falldemo22;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    FragmentA fragA;
    FragmentB fragB;
    FragmentManager fragmentManager;
    FragmentTransaction trans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragA = FragmentA.newInstance(null, null);
        trans = fragmentManager.beginTransaction();
        trans.add(R.id.fr_container, fragA);
        trans.commit();
        ((Button) findViewById(R.id.btn_goto)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragA.setData();
                fragB = FragmentB.newInstance(fragA.getValue(), fragA.getProgress());

                trans = fragmentManager.beginTransaction();
                trans.replace(R.id.fr_container, fragB);
                trans.commit();
            }
        });
    }

}


