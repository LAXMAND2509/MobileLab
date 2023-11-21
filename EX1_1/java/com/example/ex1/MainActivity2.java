package com.example.ex1;

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class MainActivity2 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//    }
//}
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class MainActivity2 extends AppCompatActivity {
    Button Next, Previous;
    RadioGroup radioGroup;
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle2 = getIntent().getExtras();
        String Name=bundle2.getString("name");
        String PhoneNumber=bundle2.getString("phone");
        String Address=bundle2.getString("address");
        String Age=bundle2.getString("age");
        String DateOfBirth=bundle2.getString("dob");
        String Gender=bundle2.getString("gender");
        String Option=bundle2.getString("option");
        String Marital=bundle2.getString("marital");
        Next = (Button) findViewById(R.id.button12);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editPersonName5);
                String Company = editText.getText().toString();
                EditText editText2 = (EditText)
                        findViewById(R.id.editPersonName4);
                String Designation = editText2.getText().toString();
                radioGroup = (RadioGroup)findViewById(R.id.RadioGroup3);
                int selectedButtonID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedButtonID);
                String button1 = radioButton.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("name", Name);
                bundle.putString("phone", PhoneNumber);
                bundle.putString("address", Address);
                bundle.putString("age", Age);
                bundle.putString("dob", DateOfBirth);
                bundle.putString("gender", Gender);
                bundle.putString("option", Option);
                bundle.putString("marital", Marital);
                bundle.putString("status", button1);
                bundle.putString("company", Company);
                bundle.putString("designation", Designation);
                Intent intent = new Intent(MainActivity2.this,
                        MainActivity3.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        Previous = (Button) findViewById(R.id.button11);
        Previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
