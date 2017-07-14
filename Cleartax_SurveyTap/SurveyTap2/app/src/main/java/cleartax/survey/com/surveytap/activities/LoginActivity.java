package cleartax.survey.com.surveytap.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cleartax.survey.com.surveytap.R;

/**
 * Created by ankit.ag on 07/07/16.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button signInBtn;
    EditText userName;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInBtn = (Button) findViewById(R.id.sign_in_button);
        signInBtn.setOnClickListener(this);
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    private void validateCredentials(){
        //No check for validation

        //Simply start the vendor activity if username and password are not empty
        if(userName.getText().length()==0 && password.getText().length()==0) {
            Toast.makeText(this, "Username and password cannot be left blank!", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(userName.getText().length()==0){
            Toast.makeText(this, "Username cannot be left blank!", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(password.getText().length()==0){
            Toast.makeText(this, "Password cannot be left blank!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent vendorIntent = new Intent(this, VendorActivity.class);
        startActivity(vendorIntent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sign_in_button:
                validateCredentials();
                break;
            default:
                break;
        }
    }
}
