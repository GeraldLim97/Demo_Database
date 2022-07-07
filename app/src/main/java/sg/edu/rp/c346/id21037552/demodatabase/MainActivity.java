package sg.edu.rp.c346.id21037552.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTasks;
    TextView tvData;
    ListView lv;
    ArrayAdapter<Task> aa;
    ArrayList<Task> alTask;
    EditText etTask, etDate;

    boolean asc = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData = findViewById(R.id.tvData);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        lv = findViewById(R.id.lv);
        etTask = findViewById(R.id.editTextTask);
        etDate = findViewById(R.id.editTextDate);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(MainActivity.this);

                //Insert a task
                db.insertTask(etTask.getText().toString(), etDate.getText().toString());
                db.close();

            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db2 = new DBHelper(MainActivity.this);
                ArrayList<Task> al = db2.getTasks(asc);
                db2.close();;
                asc = !asc;
                aa = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, al);
                lv.setAdapter(aa);

            }
        });

    }
}

