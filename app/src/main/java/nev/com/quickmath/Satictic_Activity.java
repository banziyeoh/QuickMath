package nev.com.quickmath;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Satictic_Activity extends AppCompatActivity {
    EditText numofvar,numberofvar;
    Button done,clear,calculate,calcgd;
    List<EditText> allet;
    TextView means,variance,standardvariance,gdmean;
    EditText L,N,Fcm,fm,c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satictic);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        //define numofvar edittext
        numofvar= (EditText)findViewById(R.id.numofvar);

        //define textView
        means = (TextView)findViewById(R.id.mean);
        variance = (TextView) findViewById(R.id.variance);
        standardvariance = (TextView)findViewById(R.id.standard_variance);

        //define new batch of edittext
        L = (EditText)findViewById(R.id.lboundary);
        N = (EditText)findViewById(R.id.totalfreq);
        Fcm = (EditText)findViewById(R.id.cfb4mc);
        fm = (EditText)findViewById(R.id.freqofmclass);
        c = (EditText)findViewById(R.id.classintsize);

        //define gdmean textview
        gdmean = (TextView)findViewById(R.id.means);


        //define calculate gdata button
        calcgd= (Button)findViewById(R.id.calcgd);
        calcgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double xL = Double.parseDouble(L.getText().toString());
                double xN = Double.parseDouble(N.getText().toString());
                double xFcm = Double.parseDouble(Fcm.getText().toString());
                double xfm = Double.parseDouble(fm.getText().toString());
                double xc = Double.parseDouble(c.getText().toString());
                double mean = (xL+((((xN/2)-xFcm)/xfm)*xc));
                gdmean.setText("Mean = " + mean);
            }
        });



        //define done button
        done = (Button)findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numofvariable = Integer.parseInt(numofvar.getText().toString());
                 allet = new ArrayList<EditText>();

                if(numofvariable <= 10){

                    for(int i = 1;i<=numofvariable;i++){

                        LinearLayout mLinearLayout = new LinearLayout(getApplicationContext());
                        mLinearLayout = (LinearLayout)findViewById(R.id.ll);
                        EditText lEditText = new EditText(getApplicationContext());
                        mLinearLayout.addView(lEditText);
                        allet.add(lEditText);
                        lEditText.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    }


                }else{
                    Toast.makeText(Satictic_Activity.this, "Max number of variable is 10", Toast.LENGTH_SHORT).show();
                }

            }
        });
        clear = (Button)findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout mLinearLayout = new LinearLayout(getApplicationContext());
                mLinearLayout = (LinearLayout)findViewById(R.id.ll);
                 numberofvar = new EditText(getApplicationContext());
                mLinearLayout.removeAllViews();
                allet.clear();

            }
        });
        //define calculate button
        calculate = (Button)findViewById(R.id.calculatev);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double[] intarray=new Double[allet.size()];
                for (int i=0 ;i<allet.size();i++){
                    intarray[i] = Double.parseDouble(allet.get(i).getText().toString().trim());

                }
                double total =0;
                for(double element: intarray){
                    total += element;
                }
                double totalint= allet.size();
                double mean = (total/totalint);

                //variance
                double temp = 0;
                for(double a :intarray)
                    temp += (a-mean)*(a-mean);
                double variances = temp/intarray.length;
                variance.setText("Variance = " + variances);

                //stamdard deviation
                double std = Math.sqrt(variances);
                standardvariance.setText("Standard Deviation = "+ std);







                means.setText("Mean = " + mean);












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
