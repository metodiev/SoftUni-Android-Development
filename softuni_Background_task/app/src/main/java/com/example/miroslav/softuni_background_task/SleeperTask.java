package com.example.miroslav.softuni_background_task;

import android.os.AsyncTask;
import android.widget.TextView;

public class SleeperTask extends AsyncTask<Integer, Integer, String> {

    TextView txtProgress;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        txtProgress.setText("Starting");

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        txtProgress.setText(s);
    }

    @Override
    protected String doInBackground(Integer... ints) {
        for (int i = 0; i < ints[0]; i++) {
            try {
                Thread.sleep(1000);

                publishProgress(i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "The task has ended";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int iteration = values[0];
        txtProgress.setText(String.valueOf(iteration));

    }

    public void setTxtProgress(TextView txtProgress) {
        this.txtProgress = txtProgress;
    }
}
