package algonquin.cst2335.ayushaandroidlabs.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import algonquin.cst2335.ayushaandroidlabs.R;
import algonquin.cst2335.ayushaandroidlabs.data.MainViewModel;
import algonquin.cst2335.ayushaandroidlabs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //this is the only function call, loads stuff onto screen
        setContentView(binding.getRoot());

        TextView tv = binding.myTextView;
        Button b = binding.myButton;
        EditText et = binding.myEditText;

        viewModel.userString.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv.setText(s);
            }
        });
        et.setText(viewModel.userString.getValue());

        b.setOnClickListener(v ->
        {
            tv.setText(R.string.button_message);
            String string = et.getText().toString();
            viewModel.userString.postValue (string);
            b.setText("you clicked the button");

        });
    }
}