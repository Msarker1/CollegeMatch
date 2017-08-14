package sarker.collegematchv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.content.Context;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    Context context;
    TextView t, user_math,user_reading,user_writing,math,reading,writing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Bundle b = getIntent().getExtras();
        String user_sat_math=null,user_sat_reading=null,user_sat_writing=null,sat_math=null,sat_reading=null,sat_writing=null,collegeName=null;
        user_sat_math = b.getString("user_sat_math");
        user_sat_reading=b.getString("user_sat_reading");
        user_sat_writing=b.getString("user_sat_writing");

        collegeName = b.getString("collegeName");
        sat_math = b.getString("sat_math");
        sat_reading=b.getString("sat_reading");
        sat_writing=b.getString("sat_writing");


        t = (TextView)findViewById(R.id.results);

        t.setText(collegeName);
        user_math = (TextView)findViewById(R.id.user_math);
        user_math.setText(user_sat_math);

        user_reading = (TextView)findViewById(R.id.user_reading);
        user_reading.setText(user_sat_reading);

        user_writing= (TextView)findViewById(R.id.user_writing);
        user_writing.setText(user_sat_writing);

        math = (TextView)findViewById(R.id.math);
        math.setText(sat_math);

        reading = (TextView)findViewById(R.id.reading);
        reading.setText(sat_reading);

        writing = (TextView)findViewById(R.id.writing);
        writing.setText(sat_writing);
//

        check( user_sat_math,user_sat_reading,user_sat_writing,sat_math,sat_reading,sat_writing,collegeName);

    }

    private void check(String user_sat_math, String user_sat_reading, String user_sat_writing, String sat_math, String sat_reading, String sat_writing, String collegeName) {
        int checks=0;
        int USER_MATH= Integer.parseInt(user_sat_math);
        int USER_READ= Integer.parseInt(user_sat_reading);
        int USER_WRITE= Integer.parseInt(user_sat_writing);

        int MATH= Integer.parseInt(sat_math);
        int READ= Integer.parseInt(sat_reading);
        int WRITE= Integer.parseInt(sat_writing);

        if(USER_MATH>=MATH) {
            checks++;
        }

        if(USER_READ>=READ) {

            checks++;
        }
        if(USER_WRITE>=WRITE) {

            checks++;
        }
        insertInfo(checks,collegeName);


    }


    private void insertInfo(int checks,String collegeName) {
        if (checks == 0)
            t.setText(collegeName + ": VERY LOW CHANCE OF ADMISSION");
        if (checks == 1)
            t.setText(collegeName + ": UNLIKEY CHANCE OF ADMISSION");
        if (checks == 2)
            t.setText(collegeName + ": LIKELY CHANCE OF ADMISSION");
        if (checks == 3)
            t.setText(collegeName + ": GOOD CHANCE OF ADMISSION");
    }



}
