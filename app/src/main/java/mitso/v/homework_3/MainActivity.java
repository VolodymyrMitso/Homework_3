package mitso.v.homework_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText first;
    EditText second;
    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button minus;
        Button plus;

        minus = (Button) findViewById(R.id.v_minusButton);
        plus = (Button) findViewById(R.id.v_plusButton);
        first = (EditText) findViewById(R.id.v_firstInput);
        second = (EditText) findViewById(R.id.v_secondInput);
        screen = (TextView) findViewById(R.id.v_screen);

        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String firstString = String.valueOf(first.getText());
        String secondString = String.valueOf(second.getText());
        int result;
        int firstInt;
        int secondInt;
        switch (v.getId()) {
            case R.id.v_plusButton:
                if (isStringAnInt(firstString) && isStringAnInt(secondString)) {
                    firstInt = Integer.parseInt(firstString);
                    secondInt = Integer.parseInt(secondString);
                    result = firstInt + secondInt;
                    String string = String.valueOf(firstInt) + " + " + String.valueOf(secondInt) + " = " + String.valueOf(result);
                    screen.setTextColor(getResources().getColor(R.color.c_normalTextColor));
                    screen.setText(string);
                } else {
                    screen.setTextColor(getResources().getColor(R.color.c_badTextColor));
                    screen.setText(getResources().getString(R.string.s_warning));
                }
                break;
            case R.id.v_minusButton:
                if (isStringAnInt(firstString) && isStringAnInt(secondString)) {
                    firstInt = Integer.parseInt(firstString);
                    secondInt = Integer.parseInt(secondString);
                    result = firstInt - secondInt;
                    String string = String.valueOf(firstInt) + " - " + String.valueOf(secondInt) + " = " + String.valueOf(result);
                    screen.setTextColor(getResources().getColor(R.color.c_normalTextColor));
                    screen.setText(string);
                } else {
                    screen.setTextColor(getResources().getColor(R.color.c_badTextColor));
                    screen.setText(getResources().getString(R.string.s_warning));
                }
        }
    }

    private static boolean isStringAnInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
