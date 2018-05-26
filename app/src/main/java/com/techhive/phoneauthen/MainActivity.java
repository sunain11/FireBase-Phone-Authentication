package com.techhive.phoneauthen;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    private static final String TAG = "PhoneAuthActivity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mSignOutButton = (Button) findViewById(R.id.sign_out_button);
        TextView fireBaseId = (TextView) findViewById(R.id.detail);
        mAuth = FirebaseAuth.getInstance();
        //DF:03:B4:DC:6C:E2:32:A2:60:7D:FC:BD:0F:43:69:7D:A5:ED:D7:06
        if (mAuth.getCurrentUser() != null) {
            fireBaseId.setText(mAuth.getCurrentUser().getPhoneNumber());
        } else
        {
            startActivity(new Intent(MainActivity.this, PhoneAuthActivity.class));
            finish();
        }
        mSignOutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_out_button:
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this, PhoneAuthActivity.class));
                finish();
                break;
        }
    }
}
