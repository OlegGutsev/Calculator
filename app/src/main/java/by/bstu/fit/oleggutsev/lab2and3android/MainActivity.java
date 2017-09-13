package by.bstu.fit.oleggutsev.lab2and3android;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private float mNumber;
    private String operation = "";

    private EditText mInterfaceEditText;
    private TextView mSecondInterfaceTextView;

    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;
    private Button mButtonFour;
    private Button mButtonFive;
    private Button mButtonSix;
    private Button mButtonSeven;
    private Button mButtonEight;
    private Button mButtonNine;
    private Button mButtonZero;

    private Button mButtonDot;
    private Button mButtonEqual;
    private Button mButtonDelete;
    private Button mButtonDivide;
    private Button mButtonMultiply;
    private Button mButtonMinus;
    private Button mButtonPlus;

    private Binary mBinaryOperation;
    private Operations mOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOperations = new Operations();

        mInterfaceEditText = (EditText) findViewById(R.id.InterfaceEditText);
        mSecondInterfaceTextView = (TextView) findViewById(R.id.SecondInterfaceTextView);

        mButtonOne = (Button) findViewById(R.id.button1);
        mButtonTwo = (Button) findViewById(R.id.button2);
        mButtonThree = (Button) findViewById(R.id.button3);
        mButtonFour = (Button) findViewById(R.id.button4);
        mButtonFive = (Button) findViewById(R.id.button5);
        mButtonSix = (Button) findViewById(R.id.button6);
        mButtonSeven = (Button) findViewById(R.id.button7);
        mButtonEight = (Button) findViewById(R.id.button8);
        mButtonNine = (Button) findViewById(R.id.button9);
        mButtonZero = (Button) findViewById(R.id.button0);

        mButtonDot = (Button) findViewById(R.id.buttonDot);
        mButtonEqual = (Button) findViewById(R.id.buttonEqual);
        mButtonDelete = (Button) findViewById(R.id.buttonDel);
        mButtonDivide = (Button) findViewById(R.id.buttonDivide);
        mButtonMultiply = (Button) findViewById(R.id.buttonMultiply);
        mButtonMinus = (Button) findViewById(R.id.buttonMinus);
        mButtonPlus = (Button) findViewById(R.id.buttonPlus);


    }

    public void Number_Click(View view) {
        mSecondInterfaceTextView.setText("");
        mButtonDelete.setText(R.string.del_operation);
        switch (view.getId()) {
            case R.id.button1:
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonOne.getText());

                break;
            case R.id.button2:
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonTwo.getText());
                break;
            case R.id.button3:
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonThree.getText());
                break;
            case R.id.button4:
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonFour.getText());
                break;
            case R.id.button5:
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonFive.getText());
                break;
            case R.id.button6:
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonSix.getText());
                break;
            case R.id.button7:
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonSeven.getText());
                break;
            case R.id.button8:
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonEight.getText());
                break;
            case R.id.button9:
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonNine.getText());
                break;
            case R.id.button0:
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonZero.getText());
                break;
        }
    }

    public void AddOperation_Click(View view) {
        mSecondInterfaceTextView.setText("");
        mButtonDelete.setText(R.string.del_operation);
        switch (view.getId()) {
            case R.id.buttonDot:
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonDot.getText());
                break;
            case R.id.buttonEqual:
                switch (operation) {
                    case "+":
                        mNumber += getSecondNumber("+");
                        break;
                    case "-":
                        mNumber -= getSecondNumber("-");
                        break;
                    case "*":
                        mNumber *= getSecondNumber("*");
                        break;
                    case "/":
                        try {
                            mNumber /= getSecondNumber("/");
                            if (mNumber == Double.POSITIVE_INFINITY ||
                                    mNumber == Double.NEGATIVE_INFINITY) {
                                throw new ArithmeticException();
                            }
                        } catch (ArithmeticException ex) {
                            mSecondInterfaceTextView.setText("На 0 делить нельзя");
                            mNumber = 0;
                        }
                        break;
                }
                String mNumberString = String.valueOf(mNumber);
                mInterfaceEditText.setText(mNumberString
                        .indexOf(".") < 0 ? mNumberString : mNumberString
                        .replaceAll("0*$", "")
                        .replaceAll("\\.$", ""));
                mButtonDelete.setText("CLR");
                break;
            case R.id.buttonDivide:
                operation = mOperations.mDictionaryBinary.get(Binary.DIVIDE);
                mNumber = Float.parseFloat(mInterfaceEditText.getText().toString());
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonDivide.getText());
                break;
            case R.id.buttonMultiply:
                operation = mOperations.mDictionaryBinary.get(Binary.MULTIPLY);
                mNumber = Float.parseFloat(mInterfaceEditText.getText().toString());
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonMultiply.getText());
                break;
            case R.id.buttonMinus:
                operation = mOperations.mDictionaryBinary.get(Binary.MINUS);
                mNumber = Float.parseFloat(mInterfaceEditText.getText().toString());
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonMinus.getText());
                break;
            case R.id.buttonPlus:
                Log.d("TAG", mOperations.mDictionaryBinary.get(Binary.PLUS));
                operation = mOperations.mDictionaryBinary.get(Binary.PLUS);
                mNumber = Float.parseFloat(mInterfaceEditText.getText().toString());
                mInterfaceEditText.setText(mInterfaceEditText.getText() + "" + mButtonPlus.getText());
                break;
        }

    }

    private float getSecondNumber(String op) {
        String num = mInterfaceEditText
                .getText()
                .toString()
                .substring(mInterfaceEditText
                                .getText()
                                .toString()
                                .indexOf(op) + 1,
                        mInterfaceEditText
                                .length());
        return Float.parseFloat(num);
    }

    public void DeleteOrClear_Click(View view) {
        if (mButtonDelete.getText() == "CLR") {
            mInterfaceEditText.getText().clear();
            mButtonDelete.setText(R.string.del_operation);
        } else {
            if (mInterfaceEditText.getText().toString() == "")
                return;
            else mInterfaceEditText.setText(mInterfaceEditText
                    .getText()
                    .toString()
                    .substring(0, mInterfaceEditText.getText().length() - 1));
        }

    }
}
