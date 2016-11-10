package com.example.dou.dialogfragmentexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mRadioGroup;
    private Button mButton;

    public static final int RADIO_ALTER = 1;
    public static final int RADIO_DATE = 2;
    public static final int RADIO_TIME = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        mButton = (Button)findViewById(R.id.choicebutton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resId = mRadioGroup.getCheckedRadioButtonId();
                MyDialogFragment myDialogFragment = null;

                switch (resId){

                    case R.id.radioalter:
                        myDialogFragment = MyDialogFragment.getInstance(RADIO_ALTER);
                        break;
                    case R.id.radiodate:
                        myDialogFragment = MyDialogFragment.getInstance(RADIO_DATE);
                        break;
                    case R.id.radiotime:
                        myDialogFragment = MyDialogFragment.getInstance(RADIO_TIME);
                        break;
                    default:

                        break;
                }
                if(myDialogFragment != null){
                    myDialogFragment.show(getFragmentManager(),"信息");
                }
            }
        });
    }
}
