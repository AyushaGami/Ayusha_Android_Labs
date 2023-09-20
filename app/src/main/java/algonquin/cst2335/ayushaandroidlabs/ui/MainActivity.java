package algonquin.cst2335.ayushaandroidlabs.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import algonquin.cst2335.ayushaandroidlabs.R;
import algonquin.cst2335.ayushaandroidlabs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //this is the only function call, loads stuff onto screen
        setContentView(binding.getRoot());

        TextView tv = binding.myTextView;
        Button b = binding.myButton;
        EditText et = binding.myEditText;

        b.setOnClickListener(v ->
        {
            tv.setText(R.string.button_message);
            et.setText("you clicked the button");
            b.setText("you clicked the button");

        });
    }
}