package com.example.basic_banking_app.UI;

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

import com.example.basic_banking_app.R;

import org.w3c.dom.Text;

public class UserData extends AppCompatActivity {
    TextView name;
    TextView accountNo;
    TextView email;
    TextView ifsc;
    TextView mobileNo;
    TextView balance;
    Button Tranfer;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        name=findViewById(R.id.name);
        accountNo=findViewById(R.id.account_no);
        email=findViewById(R.id.email_id);
        ifsc=findViewById(R.id.ifsc_id);
        mobileNo=findViewById(R.id.phone_no);
        balance=findViewById(R.id.avail_balance);
        Tranfer=findViewById(R.id.transfer_money);
        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
           name.setText(extras.getString("NAME"));
           accountNo.setText(String.valueOf(extras.getInt("ACCOUNT_NO")));
           email.setText(extras.getString("EMAIL"));
           ifsc.setText(extras.getString("IFSC"));
           mobileNo.setText(extras.getString("MOBILE_NO"));
           balance.setText(extras.getString("BALANCE"));
        }
        else
        {
            Log.d("Tag","Empty Intent");
        }
        Tranfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               enterAmount();
            }
        });

        


    }
    private void enterAmount() {
        final AlertDialog.Builder mBuilder=new AlertDialog.Builder(UserData.this);
        View mView=getLayoutInflater().inflate(R.layout.dialogbox,null);
        mBuilder.setTitle("Enter Amount").setView(mView).setCancelable(false);
        final EditText mAmount=(EditText) mView.findViewById(R.id.enterMoney);
        mBuilder.setPositiveButton("SEND", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {}
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                transactionCancel();
               dialog.dismiss();
            }
        });
        dialog = mBuilder.create();
        dialog.show();
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentBalance=Integer.parseInt(String.valueOf(balance.getText()));
                if(mAmount.getText().toString().isEmpty()){
                 //   mAmount.setText("Amount can't be empty");
                    Toast.makeText(UserData.this,"Amount can't be empty",Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(mAmount.getText().toString())>currentBalance){
                    Toast.makeText(UserData.this,"Please enter Correct Amount",Toast.LENGTH_SHORT).show();

                }
                else{
                  Intent intent=new Intent(UserData.this,SendToUser.class);
                  intent.putExtra("FROM ACCOUNT NO",Integer.parseInt(accountNo.getText().toString()));
                  intent.putExtra("FROM USER NAME",name.getText().toString());
                  intent.putExtra("FROM_USER_ACCOUNT_BALANCE",balance.getText().toString());
                  intent.putExtra("TRANSFER_AMOUNT",mAmount.getText().toString());
                  startActivity(intent);
                  finish();
                }


            }
        });
    }

    private void transactionCancel() {
      //  Toast.makeText(UserData.this,"Cancel",Toast.LENGTH_SHORT).show();
        final AlertDialog.Builder builder = new AlertDialog.Builder(UserData.this);
        builder.setTitle("Exit");
        builder.setMessage("Do you want to exit ??");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(UserData.this,"Transaction Cancelled",Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                enterAmount();

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}