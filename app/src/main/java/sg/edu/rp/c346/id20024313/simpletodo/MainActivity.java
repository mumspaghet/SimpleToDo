package sg.edu.rp.c346.id20024313.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText editText;
Button btnAdd;
Button btnClear;
Button btnDelete;
ArrayList<String> alToDo;
ArrayAdapter<String> aaToDo;
ListView lv1;
Spinner SpinnerNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btnAdd=findViewById(R.id.btnAdd);
    btnClear= findViewById(R.id.btnClear);
    btnDelete=findViewById(R.id.btnDelete);
    editText=findViewById(R.id.editText1);
    lv1= findViewById(R.id.ListView1);
    SpinnerNewTask= findViewById(R.id.spinnerNewTask);

    alToDo=new ArrayList<String>();
    aaToDo=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alToDo);
    lv1.setAdapter(aaToDo);
    btnDelete.setEnabled(false);

    btnAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strText = editText.getText().toString();
            alToDo.add(strText);
            aaToDo.notifyDataSetChanged();
        }
    });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alToDo.size()>0) {
                    int index = Integer.parseInt(editText.getText().toString());
                    alToDo.remove(index);
                    aaToDo.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "You don't have any task to remove", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alToDo.clear();
                aaToDo.notifyDataSetChanged();
            }
        });
        SpinnerNewTask.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        editText.setHint("Add a task");
                        btnAdd.setEnabled(true);
                        btnDelete.setEnabled(false);
                        break;
                    case 1:
                        editText.setHint("Remove a task");
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        }
    }

