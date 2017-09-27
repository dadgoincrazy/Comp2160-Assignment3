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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numeric_input(View v)
    {
        TextView input_string = (TextView) findViewById(R.id.input_string);
        Button this_button = (Button) v;

        String input = (String) this_button.getText();
        String prev = (String) input_string.getText();
        String new_text = prev;
        String char_list = "+x/";
        char last_char = prev.charAt(prev.length() -1);

        if(prev.length() < 13)
        {
            if(char_list.contains(String.valueOf(last_char)))
            {
                if(char_list.contains(input))
                {
                    
                }
            }

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
}
