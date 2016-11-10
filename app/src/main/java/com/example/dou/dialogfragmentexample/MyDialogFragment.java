package com.example.dou.dialogfragmentexample;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Dou on 2016/4/26.
 */
public class MyDialogFragment extends DialogFragment {
    public static MyDialogFragment getInstance(int Type){
        MyDialogFragment dialogFragment = new MyDialogFragment();
        Bundle budle = new Bundle();
        budle.putInt("DialogType", Type);
        dialogFragment.setArguments(budle);
        return dialogFragment;
    }
    private class MyDatePickerDialog extends DatePickerDialog{

        public MyDatePickerDialog(Context context, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
            super(context, callBack, year, monthOfYear, dayOfMonth);
        }

        @Override
        protected void onStop() {
            //
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int Dailog_Type = getArguments().getInt("DialogType");

        switch (Dailog_Type){
            case MainActivity.RADIO_ALTER:
                //在任何fragment中都可以通过getActivity获得它所附着的Activity引用（context 上下文）
                return new AlertDialog.Builder(getActivity()).setIcon(R.drawable.test)
                        //调用时传入title
                        .setTitle(getTag())
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
            case MainActivity.RADIO_DATE:
                Calendar cl = Calendar.getInstance();
                int year = cl.get(Calendar.YEAR);
                int month = cl.get(Calendar.MONTH);
                int day = cl.get(Calendar.DAY_OF_MONTH);
                return new MyDatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    //用户选择的year/month/day
                    //在java中month用0到11表示
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        TextView textView = (TextView)getActivity().findViewById(R.id.displaydailog);
                        textView.setText(year + "年 "+ (monthOfYear+1) +"月 " + dayOfMonth +"日");
                    }
                },year,month,day);
            case MainActivity.RADIO_TIME:
                Calendar c2 = Calendar.getInstance();
                final int hour = c2.get(Calendar.HOUR);
                int min = c2.get(Calendar.MINUTE);
                return new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TextView textView = (TextView)getActivity().findViewById(R.id.displaydailog);
                        textView.setText(hourOfDay + "小时 " + minute +"分");
                    }
                },hour,min,true);
            default:

                break;
        }
        return null;
    }
}
