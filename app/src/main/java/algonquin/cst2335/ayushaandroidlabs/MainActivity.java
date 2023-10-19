package algonquin.cst2335.ayushaandroidlabs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is the main activity class for the Android application.
 * @author Ayusha Gami
 * @version 1.8
 */

public class MainActivity extends AppCompatActivity {

    /** The TextView to display a message. */
    private TextView theMessage;
    /** The Button used for login. */
    private Button loginButton;
    /** The EditText for entering a password. */
    private EditText passwordText;

    /**
     * Called when the activity is first created.
     * @param savedInstanceState The saved state of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Set the content view to the activity_main layout. */
        setContentView(R.layout.activity_main);

        /** Initialize UI elements. */
        theMessage = findViewById(R.id.textView);
        loginButton = findViewById(R.id.loginButton);
        passwordText = findViewById(R.id.loginText);

        /** Set a click listener for the loginButton. */
        loginButton.setOnClickListener( click -> {
            String password = passwordText.getText().toString();
            if (isComplexEnough(password) == true){
                theMessage.setText("Your password meets the requirements");
            } else {
                theMessage.setText("You shall not pass!");
            }
        });
    }

    /**
     * Check if a given text is complex enough by having both upper and lower case characters.
     * @param text The input text to check.
     * @return True if the text is complex enough, false otherwise.
     */
    boolean isComplexEnough(String text){
        boolean result = false;
        boolean foundUpperCase= false, foundLowerCase =false, foundNumber =false, foundSpecial = false;
        for(int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if(Character.isUpperCase(c))
                foundUpperCase = true;
            else if(Character.isLowerCase(c))
                foundLowerCase = true;
            else if (Character.isDigit(c))
                foundNumber = true;
             else
                foundSpecial = true;
        }
        if (!foundUpperCase) {
            Toast.makeText(this, "No uppercase character found", Toast.LENGTH_SHORT).show();// Say that they are missing an upper case letter;
            return false;
        } else if (!foundLowerCase){
            Toast.makeText(this, "No lowercase character found", Toast.LENGTH_SHORT).show();// Say that they are missing a lower case letter;
            return false;
        }else if (!foundNumber) {
            Toast.makeText(this, "No number found", Toast.LENGTH_SHORT).show(); // Say that they are missing a lower case letter;
            return false;
        }else if (!foundSpecial) {
            Toast.makeText(this, "No special character found", Toast.LENGTH_SHORT).show(); // Say that they are missing a lower case letter;
            return false;
        }else{
            return true;
        }
    }
    /** This function checks for if the provided character
     * is the Special Character or not
     * @param c parameter object to be checked
     * @return Returns true if the provided character is a special character
     */
    boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }
}