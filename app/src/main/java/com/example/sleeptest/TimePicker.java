package com.example.sleeptest;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

//source: Coding in Flow tutorial with Time picker dialog

public class TimePicker extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //get real time from current device
        Calendar current = Calendar.getInstance();
        int hr = current.get(Calendar.HOUR_OF_DAY);
        int min = current.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),(TimePickerDialog.OnTimeSetListener) getActivity(), hr, min, android.text.format.DateFormat.is24HourFormat(getActivity()));
    }
}
