package nev.com.quickmath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText a,b,c;
    Button calculate;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //define edit text a,b,c
        a = (EditText) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.b);
        c = (EditText) findViewById(R.id.c);

        //define button calculate
        calculate = (Button)findViewById(R.id.calculate);

        //define the answer textview
        answer = (TextView)findViewById(R.id.answer);

        //set onclick calculate
        calculate.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                int geta = Integer.parseInt( a.getText().toString() );
                int getb = Integer.parseInt(b.getText().toString());
                int getc = Integer.parseInt(c.getText().toString());

                    double answers = (-getb+((Math.sqrt((Math.pow(getb,2))-(4*geta*getc)))))/(2*geta) ;
                double answers2= (-getb-((Math.sqrt((Math.pow(getb,2))-(4*geta*getc)))))/(2*geta);
                    answer.setText("" + answers + " \n "+
                            answers2);}

        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.android_action_bar_spinner_menu, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.math_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 1){
                    Intent intent = new Intent(MainActivity.this,CoordinateActitity.class);
                    startActivity(intent);
                }
                if(i ==2){
                    Intent intent = new Intent(MainActivity.this,Satictic_Activity.class);
                    startActivity(intent);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return true;
    }
}
