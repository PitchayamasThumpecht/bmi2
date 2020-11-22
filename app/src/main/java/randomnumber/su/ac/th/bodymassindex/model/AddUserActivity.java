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

import randomnumber.su.ac.th.bodymassindex.DatabaseClass;
import randomnumber.su.ac.th.bodymassindex.EntityClass.UserModel;
import randomnumber.su.ac.th.bodymassindex.R;

public class AddUserActivity extends AppCompatActivity {

    EditText name, id, weight, height;

    int score =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        name = findViewById(R.id.name_edit_text);
        id = findViewById(R.id.id_edit_text);
        weight = findViewById(R.id.weight_edit_text);
        height = findViewById(R.id.height_edit_text);

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

                String weightText = weight.getText().toString(); //
                int w = Integer.parseInt(weightText); //แปลงค่าน้ำหนักที่ใส่จากตัวอักษรเป็นจำนวนเต็ม

                String heightText = height.getText().toString(); //แปลงค่านส่วนสูงที่ใส่จากตัวอักษรเป็นจำนวนเต็ม
                int h = Integer.parseInt(heightText);

                double resultBMI = w/((h/100)*(h/100));

                AlertDialog.Builder dialog = new AlertDialog.Builder(AddUserActivity.this);
                dialog.setTitle("Body Mass Index");
                Log.i("AddUserActivity", "ค่าBMIเท่ากับ: " + resultBMI);
                if(resultBMI < 18.5){
                    dialog.setMessage("อยู่ในเกณฑ์ : น้ำหนักน้อย/ผอม ");
                }else if (resultBMI>=18.5 && resultBMI<=22.90){
                    dialog.setMessage("อยู่ในเกณฑ์ : ปกติ(สุขภาพดี)");
                }else if(resultBMI>=23 && resultBMI<=24.90){
                    dialog.setMessage("อยู่ในเกณฑ์ : ท้วม/โรคอ้วนระดับ1");
                }else if (resultBMI>=25 && resultBMI<=29.90){
                    dialog.setMessage("อยู่ในเกณฑ์ : อ้วน/โรคอ้วนระดับ2");
                }else if (resultBMI >= 30){
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

    private void saveData(){
        String name_txt = name.getText().toString().trim();
        String id_txt = id.getText().toString().trim();
        String weight_txt = weight.getText().toString().trim();
        String height_txt = height.getText().toString().trim();

        if(name_txt != null && id_txt != null && weight_txt != null && height_txt != null){

            UserModel model = new UserModel();

            model.setName(name_txt);
            model.setKey(id_txt);
            model.setWeight(weight_txt);
            model.setHeight(height_txt);

            DatabaseClass.getDatabase(getApplicationContext()).getDao().insertAllData(model);
            Toast.makeText(this,"บันทึกสำเร็จ", Toast.LENGTH_SHORT).show();
        }
    }
}