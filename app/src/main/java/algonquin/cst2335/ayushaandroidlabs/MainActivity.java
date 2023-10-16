package algonquin.cst2335.ayushaandroidlabs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
            boolean isComplex  = isComplexEnough(password);

            if(isComplex)
                theMessage.setText("It has upper and lower case");
            else theMessage.setText("You are missing something in your password");
        });
    }

    /**
     * Check if a given text is complex enough by having both upper and lower case characters.
     * @param text The input text to check.
     * @return True if the text is complex enough, false otherwise.
     */
    boolean isComplexEnough(String text){
        boolean result = false;
        boolean foundUpperCase= false, foundLowerCase =false;
        for(int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if(Character.isUpperCase(c))
                foundUpperCase = true;
            else if(Character.isLowerCase(c))
                foundLowerCase = true;
        }
        return (foundLowerCase && foundUpperCase);
    }
}