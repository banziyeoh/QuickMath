package nev.com.quickmath;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CoordinateActitity extends AppCompatActivity {
    EditText p1x,p1y,p2x,p2y,p1xg,p1yg,p2xg,p2yg;
    TextView answer,answerr;
    Button calculate,calculategradient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //define edittext
        p1x = (EditText)findViewById(R.id.point1x);
        p1y = (EditText)findViewById(R.id.point1y);
        p2x = (EditText)findViewById(R.id.point2x);
        p2y = (EditText)findViewById(R.id.point2y);
        //define new batch edittext
        p1xg = (EditText)findViewById(R.id.point1xr);
        p1yg = (EditText)findViewById(R.id.point1yr);
        p2xg = (EditText)findViewById(R.id.point2xr);
        p2yg = (EditText)findViewById(R.id.point2yr);

        //define TextView
        answer = (TextView) findViewById(R.id.answer);
        answerr =(TextView)findViewById(R.id.answerr);

        //define calculate button
        calculate = (Button)findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int getp1x= Integer.parseInt(p1x.getText().toString());
                int getp1y= Integer.parseInt(p1y.getText().toString());
                int getp2x= Integer.parseInt(p2x.getText().toString());
                int getp2y= Integer.parseInt(p2y.getText().toString());
                double answers=(Math.sqrt(((Math.pow((getp1x-getp2x),2))+(Math.pow((getp1y-getp2y),2)))));
                answer.setText("Distance = " + answers);

                System.out.println(Math.sqrt((Math.pow((getp1x+getp2x),2)+Math.pow((getp1y+getp2y),2))));
            }
        });
        //define calculate ratio button
        calculategradient = (Button)findViewById(R.id.calculater);
        calculategradient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int getp1x= Integer.parseInt(p1xg.getText().toString());
                int getp1y= Integer.parseInt(p1yg.getText().toString());
                int getp2x= Integer.parseInt(p2xg.getText().toString());
                int getp2y= Integer.parseInt(p2yg.getText().toString());
                double answers = ((getp1y-getp2y)/(getp1x-getp2x));
                answerr.setText("Gradient = " + answers);


            }
        });



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
