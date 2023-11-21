package com.example.ex1;

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class MainActivity4 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main4);
//    }
//}

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity4 extends AppCompatActivity {
    Button Clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle bundle = getIntent().getExtras();
        String Name= bundle.getString("name");
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
        String EName=bundle.getString("ename");
        String Relationship=bundle.getString("relationship");
        String EAddress=bundle.getString("eaddress");
        String EPhoneNumber=bundle.getString("ephone");
        TextView textView = (TextView) findViewById(R.id.textView24);
        TextView textView2 = (TextView) findViewById(R.id.textView26);
        TextView textView3 = (TextView) findViewById(R.id.textView15);
        TextView textView4 = (TextView) findViewById(R.id.textView30);
        TextView textView5 = (TextView) findViewById(R.id.textView32);
        TextView textView6 = (TextView) findViewById(R.id.textView34);
        TextView textView7 = (TextView) findViewById(R.id.textView36);
        TextView textView8 = (TextView) findViewById(R.id.textView28);
        TextView textView9 = (TextView) findViewById(R.id.textView39);
        TextView textView10 = (TextView) findViewById(R.id.textView41);
        TextView textView11 = (TextView) findViewById(R.id.textView43);
        TextView textView12 = (TextView) findViewById(R.id.textView46);
        TextView textView13 = (TextView) findViewById(R.id.textView48);
        TextView textView14 = (TextView) findViewById(R.id.textView50);
        TextView textView15 = (TextView) findViewById(R.id.textView52);
        textView.setText(Name);
        textView2.setText(PhoneNumber);
        textView3.setText(Option);
        textView4.setText(Address);
        textView5.setText(Gender);
        textView6.setText(Age);
        textView7.setText(DateOfBirth);
        textView8.setText(Marital);
        textView9.setText(Status);
        textView10.setText(Company);
        textView11.setText(Designation);
        textView12.setText(EName);
        textView13.setText(Relationship);
        textView14.setText(EAddress);
        textView15.setText(EPhoneNumber);
        Clear = (Button) findViewById(R.id.button4);
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity4.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }
}