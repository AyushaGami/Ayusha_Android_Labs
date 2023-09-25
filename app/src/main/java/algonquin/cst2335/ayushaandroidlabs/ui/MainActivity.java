package algonquin.cst2335.ayushaandroidlabs.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.widget.Toast;
import algonquin.cst2335.ayushaandroidlabs.data.MainViewModel;
import algonquin.cst2335.ayushaandroidlabs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding variableBinding;
    private MainViewModel Model;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Model = new ViewModelProvider(this).get(MainViewModel.class);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        //this is the only function call, loads stuff onto screen
        setContentView(variableBinding.getRoot());

        variableBinding.myButton.setOnClickListener(click ->
        {
            Model.editString.postValue(variableBinding.myEditText.getText().toString());
        });
        Model.editString.observe(this, s ->
        {
            variableBinding.myTextView.setText("Your edit text has " + s);
        });
        Model.isSelected.observe(this, selected ->
        {
            variableBinding.myCheckbox.setChecked((Boolean) selected);
            variableBinding.mySwitch.setChecked((Boolean) selected);
            variableBinding.myRadioButton.setChecked((Boolean) selected);
        });
        variableBinding.myCheckbox.setOnCheckedChangeListener((btn, isChecked) ->
        {
            Model.isSelected.postValue(isChecked);
            showToast("CheckBox clicked");
        });
        variableBinding.mySwitch.setOnCheckedChangeListener((btn, isChecked) ->
        {
            Model.isSelected.postValue(isChecked);
            showToast("Switch clicked");
        });
        variableBinding.myRadioButton.setOnCheckedChangeListener((btn, isChecked) ->
        {
            Model.isSelected.postValue(isChecked);
            showToast("RadioButton clicked");
        });
        variableBinding.myImageButton.setOnClickListener(i ->
        {
            showToast("The width = " + i.getWidth() + "And the height = " + i.getHeight());
        });
    }
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}