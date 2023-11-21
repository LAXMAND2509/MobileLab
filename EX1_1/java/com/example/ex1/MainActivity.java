package com.example.ex1;

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.AdapterView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import java.util.Calendar;
import android.os.Bundle;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    String [] marital = {"Single", "Married", "Live-In Relationship"};
    EditText dateEdt;
    Button next;
    RadioGroup radioGroup, radioGroup2;
    RadioButton radioButton, radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin = findViewById(R.id.maritalspinner);
        ArrayAdapter Ad = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, marital);
        Ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(Ad);
        dateEdt = findViewById(R.id.DateofBirth);
        dateEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int
                                    monthOfYear, int dayOfMonth) {
                                dateEdt.setText(dayOfMonth + "/" + (monthOfYear +
                                        1) + "/" + year);
                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });
        next = (Button) findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editPersonName);
                String Name = editText.getText().toString().trim();
                EditText editText2 = (EditText) findViewById(R.id.editTextPhone2);
                String PhoneNumber = editText2.getText().toString();
                EditText editText3 = (EditText)
                        findViewById(R.id.editPostalAddress);
                String Address = editText3.getText().toString();
                EditText editText4 = (EditText) findViewById(R.id.editTextNumber);
                String Age = editText4.getText().toString();
                EditText editText5 = (EditText) findViewById(R.id.DateofBirth);
                String DateOfBirth = editText5.getText().toString();
                radioGroup = (RadioGroup)findViewById(R.id.RadioGroup1);
                radioGroup2 = (RadioGroup)findViewById(R.id.RadioGroup2);
                int selectedButtonID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedButtonID);
                String button1 = radioButton.getText().toString();
                int selectedButtonID2 = radioGroup2.getCheckedRadioButtonId();
                radioButton2 = findViewById(selectedButtonID2);
                String button2 = radioButton2.getText().toString();
                Bundle bundle2 = new Bundle();
                bundle2.putString("name", Name);
                bundle2.putString("phone", PhoneNumber);
                bundle2.putString("address", Address);
                bundle2.putString("age", Age);
                bundle2.putString("dob", DateOfBirth);
                bundle2.putString("gender", button1);
                bundle2.putString("option", button2);
                bundle2.putString("marital",
                        String.valueOf(spin.getSelectedItem()));
                Intent intent = new Intent(MainActivity.this,
                        MainActivity2.class);
                intent.putExtras(bundle2);
                startActivity(intent);
            }
        });
    }
}
