package randomnumber.su.ac.th.bodymassindex.model;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import randomnumber.su.ac.th.bodymassindex.MainActivity;
import randomnumber.su.ac.th.bodymassindex.R;

public class bmichart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmichart);


        Button exitButton2 = findViewById(R.id.exit_button2);
        exitButton2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent (bmichart.this, AddUserActivity.class);
                startActivity(intent);
                // finish();
                AlertDialog.Builder dialog = new AlertDialog.Builder(bmichart.this);
                dialog.setTitle("Exit Body Mass Index Chart");
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