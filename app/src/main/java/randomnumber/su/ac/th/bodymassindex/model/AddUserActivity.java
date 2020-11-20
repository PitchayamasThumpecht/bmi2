package randomnumber.su.ac.th.bodymassindex.model;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import randomnumber.su.ac.th.bodymassindex.MainActivity;
import randomnumber.su.ac.th.bodymassindex.R;

public class AddUserActivity extends AppCompatActivity {

    int score =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Button bmichartButton = findViewById(R.id.bmi_chart_button);
        bmichartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (AddUserActivity.this, bmichart.class);
                startActivity(intent);
            }
        });


        Button calButton = findViewById(R.id.cal_button);
        ///guessButton.setText("Hello"); //เซตข้อความบนปุ่ม
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText numberEditText1 = findViewById(R.id.weight_edit_text);
                String weightText = numberEditText1.getText().toString(); //
                int num1 = Integer.parseInt(weightText); //แปลงค่าเป็นจำนวนเต็ม
                EditText numberEditText2 = findViewById(R.id.height_edit_text);
                String heightText = numberEditText2.getText().toString(); //
                int num2 = Integer.parseInt(heightText);

                double result =num1/(num2*num2);
                AlertDialog.Builder dialog = new AlertDialog.Builder(AddUserActivity.this);
                dialog.setTitle("Body Mass Index");
                Log.i("AddUserActivity", "ค่าBMIเท่ากับ: " + result);
                if(result<18.5){


                    dialog.setMessage("อยู่ในเกณฑ์ : น้ำหนักน้อย/ผอม ");
                }else if (result>=18.5&&result<=22.90){


                    dialog.setMessage("อยู่ในเกณฑ์ : ปกติ(สุขภาพดี)");

                }else if(result>=23&&result<=24.90){


                    dialog.setMessage("อยู่ในเกณฑ์ : ท้วม/โรคอ้วนระดับ1");
                }else if (result>=25&&result<=29.90){


                    dialog.setMessage("อยู่ในเกณฑ์ : อ้วน/โรคอ้วนระดับ2");
                }else if (result>=30){


                    dialog.setMessage("อยู่ในเกณฑ์ : อ้วนมาก/โรคอ้วนระดับ3");
                }




                dialog.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                dialog.setNegativeButton("Yes", null);
                dialog.show();
            }

        });





        Button exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {


                // finish();
                AlertDialog.Builder dialog = new AlertDialog.Builder(AddUserActivity.this);
                dialog.setTitle("Exit Body Mass Index");
                dialog.setMessage("Are you sure you want to exit?");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // จะไม่ปิดจนกว่จะกดปุ่ม yes
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                dialog.setNegativeButton("No", null);
                dialog.show();
            }

        });
    }
}