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

    protected Double previousInput = Double.NaN;
    protected String operator = "";
    public TextView input_string;
    public TextView input_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_string = (TextView) findViewById(R.id.input_string);
        input_prev = (TextView) findViewById(R.id.input_previous);
    }

    public Double getCurrentInput()
    {
        if(input_string.getText() != "") {
            return Double.parseDouble(input_string.getText().toString());
        }
        return Double.NaN;
    }

    public Double getPreviousInput()
    {
        return previousInput;
    }

    public void setPreviousInput(Double value)
    {
        if(value == null)
        {
            previousInput = Double.NaN;
            input_prev.setText(null);
        } else {
            previousInput = value;
            input_prev.setText(String.valueOf(value));
        }

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
        try {
            Button this_button = (Button) v;

            String input = this_button.getText().toString();
            String prev = input_string.getText().toString();
            String new_text = prev;

            if (prev.length() < 13) {
                if(input.equals("."))
                {
                    if(prev.length() == 0 || (prev.indexOf(".") > 0))
                        new_text = prev;
                    else
                        new_text = prev + input;
                } else {
                    new_text = prev + input;
                }
            }

            input_string.setText(new_text);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void del(View v)
    {
        String prev = (String) input_string.getText();

        if(prev != null && prev.length() > 0)
        {
            prev = prev.substring(0, prev.length() - 1);
        }

        input_string.setText(prev);
    }

    public void clear(View v)
    {
        input_string.setText(null);
        setPreviousInput(null);
        setOperator(null);
    }

    public void equals(View v)
    {
        try {
            if(!getPreviousInput().isNaN() && (getPreviousInput() != null) && !getCurrentInput().isNaN() && (getCurrentInput() != null))
            {
                calculate();
            }

            setPreviousInput(getCurrentInput());
            input_string.setText(null);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void calculate()
    {
        Double value1 = getPreviousInput();
        Double value2 = getCurrentInput();
        Double val;

        switch(getOperator())
        {
            case "+":
                val = value1 + value2;
                break;
            case "-":
                val = value1 - value2;
                break;
            case "/":
                if(value1 == 0.0 || value2 == 0.0)
                {
                    val = 0.0;
                } else {
                    val = value1 / value2;
                }
                break;
            case "x":
                val = value1 * value2;
                break;
            default:
                val = value1 + value2;
        }

        input_string.setText(String.format("%.4f", val));
    }

    public void operatorInput(View v)
    {
        try {
            Button this_button = (Button) v;
            String op = this_button.getText().toString();

            if(getCurrentInput().isNaN() || (getCurrentInput() == null))
            {
                if(getPreviousInput().isNaN() || (getPreviousInput() == null))
                {
                    if(op.equals("-"))
                    {
                        numericInput(v);
                    }
                } else {
                    setOperator(op);
                }
            } else {
                if(!getPreviousInput().isNaN() && getPreviousInput() != null)
                {
                    calculate();
                }

                setPreviousInput(getCurrentInput());
                input_string.setText(null);
                setOperator(op);
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}
