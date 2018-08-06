package com.example.rishabgarg.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText password_text;
    private static RadioGroup animals;
    private static RadioButton rad;
    private static Button selec;
    private static RatingBar rate;
    private static Button rateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        addOnClickListener();
        onCheckboxClicked();
        onRadioSelector();
        OnRatingBarListener();

    }
    public void OnRatingBarListener(){
        rate = findViewById(R.id.ratingBar);
        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                Toast.makeText(MainActivity.this, String.valueOf(rating),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void onRadioSelector() {
        animals = (RadioGroup)findViewById(R.id.animalGroup);
        selec = findViewById(R.id.button2);
        selec.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int rad_id =  animals.getCheckedRadioButtonId();
                rad = findViewById(rad_id);
                Toast.makeText(MainActivity.this, rad.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void addOnClickListener() {
        password_text = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password_text.setText("dfljerngvjlrengv");


                Toast.makeText(MainActivity.this, password_text.getText(),Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }

        });

    }

    public void onCheckboxClicked() {
        CheckBox chk = (CheckBox) findViewById(R.id.checkBox);
        CheckBox chk2 = (CheckBox) findViewById(R.id.checkBox2);

        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    Toast.makeText(MainActivity.this, "first got selected",Toast.LENGTH_SHORT).show();

                }

            }
        });
        chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    Toast.makeText(MainActivity.this, "second  selected",Toast.LENGTH_SHORT).show();

                }

            }
        });


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
}
