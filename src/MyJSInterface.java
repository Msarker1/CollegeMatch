package sarker.collegematchv2;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

public class MyJSInterface {
    Context context;

    /* Instantiate the interface and set the context */
    MyJSInterface(Context c) {
        context = c;
    }

    /* Show a toast from the web page */
    @JavascriptInterface
    public void getCollegeData(String collegeName,String sat_math,String sat_reading,String sat_writing,String User_sat_math,String User_sat_reading,String User_sat_writing) {
//        college.setCollegeName(collegeName);
//        college.setSat_Math(Integer.parseInt(sat_math));
//        college.setSat_reading(Integer.parseInt(sat_reading));
//        college.setSat_writing(Integer.parseInt(sat_writing));
//
//        user.setSat_math(Integer.parseInt(User_sat_math));
//        user.setSat_reading(Integer.parseInt(User_sat_reading));
//        user.setSat_writing(Integer.parseInt(User_sat_writing));
        Intent intent = new Intent(context,Main3Activity.class);
        // intent.putExtra("userData",user.getSat_math());
        //intent.putExtra("collegeData",college);

        intent.putExtra("user_sat_math",User_sat_math);
        intent.putExtra("user_sat_reading",User_sat_reading);
        intent.putExtra("user_sat_writing",User_sat_writing);
        intent.putExtra("collegeName",collegeName);
        intent.putExtra("sat_math",sat_math);
        intent.putExtra("sat_reading",sat_reading);
        intent.putExtra("sat_writing",sat_writing);
        context.startActivity(intent);

    }

}