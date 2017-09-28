package tru.comp2160_assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    protected double previousInput;
    protected String operator;
    public TextView input_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_string = (TextView) findViewById(R.id.input_string);
    }

    public double getCurrentInput()
    {
        if(input_string.getText() != null) {
            return Double.parseDouble(input_string.getText().toString());
        }
        return;
    }

    public double getPreviousInput()
    {
        return previousInput;
    }

    public void setPreviousInput(double value)
    {
        previousInput = value;
    }

    public String getOperator()
    {
        return operator;
    }

    public void setOperator(String op)
    {
        operator = op;
    }

    public void numericInput(View v)
    {
        TextView input_string = (TextView) findViewById(R.id.input_string);
        Button this_button = (Button) v;

        String input = (String) this_button.getText();
        String prev = (String) input_string.getText();
        String new_text = prev;
//        String char_list = "+x/";
//        char last_char = prev.charAt(prev.length() -1);

        if(prev.length() < 13)
        {
            new_text = prev + input;
        }

        input_string.setText(new_text);
    }

    public void del(View v)
    {
        TextView input_string = (TextView) findViewById(R.id.input_string);
        String prev = (String) input_string.getText();

        if(prev != null && prev.length() > 0)
        {
            prev = prev.substring(0, prev.length() - 1);
        }

        input_string.setText(prev);
    }

    public void clear(View v)
    {
        TextView input_string = (TextView) findViewById(R.id.input_string);
        input_string.setText(null);
    }

    public void calculate(View v)
    {
        Toast.makeText(getApplicationContext(), String.valueOf(getCurrentInput()), Toast.LENGTH_SHORT).show();
    }

    public void operatorInput(View v)
    {
        if(getCurrentInput() == 0.00);
    }
}
