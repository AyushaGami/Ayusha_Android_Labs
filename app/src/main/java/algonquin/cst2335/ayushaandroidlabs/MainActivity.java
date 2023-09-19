package algonquin.cst2335.ayushaandroidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //this is the only function call, loads stuff onto screen
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.myTextView);
        Button b = findViewById(R.id.myButton);
        EditText et = findViewById(R.id.myEditText);

        b.setOnClickListener(v ->
        {
                tv.setText("you clicked the button");
                et.setText("you clicked the button");
                b.setText("you clicked the button");

        });
    }
}