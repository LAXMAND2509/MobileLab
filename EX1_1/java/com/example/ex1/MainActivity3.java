package com.example.ex1;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class MainActivity3 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);
//    }
//}

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ex1.MainActivity2;

public class MainActivity3 extends AppCompatActivity {
    Button Submit, Previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle bundle = getIntent().getExtras();
        String Name=bundle.getString("name");
        String PhoneNumber=bundle.getString("phone");
        String Address=bundle.getString("address");
        String Age=bundle.getString("age");
        String DateOfBirth=bundle.getString("dob");
        String Gender=bundle.getString("gender");
        String Option=bundle.getString("option");
        String Marital=bundle.getString("marital");
        String Company=bundle.getString("company");
        String Designation=bundle.getString("designation");
        String Status=bundle.getString("status");
        Submit = (Button) findViewById(R.id.button2);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editPersonName3);
                String EName = editText.getText().toString();
                EditText editText2 = (EditText)
                        findViewById(R.id.editPersonName2);
                String Relationship = editText2.getText().toString();
                EditText editText3 = (EditText)
                        findViewById(R.id.editPostalAddress2);
                String EAddress = editText3.getText().toString();
                EditText editText4 = (EditText) findViewById(R.id.editTextPhone);
                String EPhoneNumber = editText4.getText().toString();
                Bundle bundle2 = new Bundle();
                bundle2.putString("name", Name);
                bundle2.putString("phone", PhoneNumber);
                bundle2.putString("address", Address);
                bundle2.putString("age", Age);
                bundle2.putString("dob", DateOfBirth);
                bundle2.putString("gender", Gender);
                bundle2.putString("option", Option);
                bundle2.putString("marital", Marital);
                bundle2.putString("status", Status);
                bundle2.putString("company", Company);
                bundle2.putString("designation", Designation);
                bundle2.putString("ename", EName);
                bundle2.putString("relationship", Relationship);
                bundle2.putString("eaddress", EAddress);
                bundle2.putString("ephone", EPhoneNumber);
                Intent intent = new Intent(MainActivity3.this,
                        MainActivity4.class);
                intent.putExtras(bundle2);
                startActivity(intent);
            }
        });
        Previous = (Button) findViewById(R.id.button3);
        Previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this,
                        MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}
