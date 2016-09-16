package com.example.zar.ceasercipher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {


    TextView cipherTextView,decryptTextView;
    //user  entered text
    EditText plainText;
    //string which will contain plain text or cipher text
    String cText;
    //An array storing plain text from user input on edit text.
    char[] plainTextArray;
    //An array storing cipher integer values
    int[] cipherInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plainText=(EditText) findViewById(R.id.plainText);
        cipherTextView=(TextView) findViewById(R.id.cipherText);
        decryptTextView=(TextView) findViewById(R.id.decryptText);
        final Button encrypt=(Button) findViewById(R.id.magic);
        final Button decrypt=(Button) findViewById(R.id.decryptButton);
        final Button clear=(Button) findViewById(R.id.clear);
        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encryption();
            }
        });
        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decryption();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                plainText.setText("");
                cipherTextView.setText("");
                decryptTextView.setText("");
            }
        });

    }

public void encryption()
{
    cText=plainText.getText().toString();
    plainTextArray=new char[cText.length()];
    cipherInt=new int[plainTextArray.length];
    plainTextArray=cText.toCharArray();
     for (int i=0; i<plainTextArray.length;i++)
        {
            int a=(int)plainTextArray[i];
            if(a+3<=122)
            {
                cipherInt[i]=(a+3);
            }
            else
            {
                cipherInt[i]=((a+3)%122)+96;
            }
        }
    for(int i=0; i<cipherInt.length; i++)
    {
        plainTextArray[i]=(char)cipherInt[i];
    }
    cText=Arrays.toString(plainTextArray).replaceAll("\\[|\\]|\\,\\ ","");
    cipherTextView.setText(cText);
}
    public void decryption()
    {
        cText=cipherTextView.getText().toString();
        plainTextArray=new char[cText.length()];
        cipherInt=new int[plainTextArray.length];
        plainTextArray=cText.toCharArray();
        for (int i=0; i<plainTextArray.length;i++)
        {
            int a=(int)plainTextArray[i];
            if(a-3<97)
            {
                cipherInt[i]=(a-3)+26;
            }
            else
            {
                cipherInt[i]=(a-3);
            }
        }
        for (int i = 0; i<cipherInt.length; i++)
        {
            plainTextArray[i]=(char)cipherInt[i];
        }
        cText=Arrays.toString(plainTextArray).replaceAll("\\[|\\]|\\,","");
        decryptTextView.setText(cText);
    }
}
