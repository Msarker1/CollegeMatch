
function validInfo(){


    if((document.getElementById("college_name").value=="") ||(document.getElementById("user_sat_math").value=="") || (document.getElementById("user_sat_reading").value=="") ||(document.getElementById("user_sat_writing").value==""))
         $("#myModal").modal('show');

   else if(isNaN(document.getElementById("user_sat_math").value) || isNaN(document.getElementById("user_sat_reading").value) || isNaN(document.getElementById("user_sat_writing").value))
       $("#myModal2").modal('show');
   else if ((document.getElementById("user_sat_math").value.indexOf(' ') >= 0) || (document.getElementById("user_sat_reading").value.indexOf(' ') >= 0) ||(document.getElementById("user_sat_writing").value.indexOf(' ') >= 0))
        $("#myModal5").modal('show');
   else if((document.getElementById("user_sat_math").value>800 || document.getElementById("user_sat_math").value<200) || (document.getElementById("user_sat_reading").value>800 || document.getElementById("user_sat_reading").value<200) || (document.getElementById("user_sat_writing").value>800 || document.getElementById("user_sat_writing").value<200)){
        $("#myModal3").modal('show');
    }

    else{

        var collegeName = document.getElementById("college_name").value;
        var User_sat_math = document.getElementById("user_sat_math").value;
        var User_sat_reading = document.getElementById("user_sat_reading").value;
        var User_sat_writing = document.getElementById("user_sat_writing").value;

        CollegeData(collegeName,User_sat_math,User_sat_reading,User_sat_reading);

    }

}


function CollegeData(collegeName,User_sat_math,User_sat_reading,User_sat_reading){
    var sat_reading;
    var sat_writing;
    var sat_math;
 $("#myprogress").modal('show');
    $.ajax({
        type: "GET",
        url: "https://api.data.gov/ed/collegescorecard/v1/schools?school.name="+collegeName+"&api_key=lMw0Hg7asKUrzWG6Tiw1U1WBhlPRSSTS4syb1yZm",
        data: {

        },
        dataType: 'json',

        success: function(response) {
            if(response.results.length==0){
                 $("#myprogress").modal('hide');

                $("#myModal4").modal('show');
                }
            else{

            for(var i = 0; i<response.results.length; i++){
                   for(var j =1996; j<2015; j++){
                        if(response.results[i][j]===undefined)
                            continue;
                        if((response.results[i][j].admissions.sat_scores["25th_percentile"].critical_reading)!=null)
                             sat_reading=response.results[i][j].admissions.sat_scores["25th_percentile"].critical_reading;
                        if((response.results[i][j].admissions.sat_scores["25th_percentile"].writing)!=null)
                            sat_writing=response.results[i][j].admissions.sat_scores["25th_percentile"].writing;
                        if((response.results[i][j].admissions.sat_scores["25th_percentile"].math)!=null)
                             sat_math=response.results[i][j].admissions.sat_scores["25th_percentile"].math;
                   }
             }
             $("#myprogress").modal('hide');
            js.getCollegeData(collegeName,sat_math,sat_reading,sat_writing,User_sat_math,User_sat_reading,User_sat_reading);

            }
        },
        error: function(err) {
            console.error( err );
        }
        });
}

