package com.example.wzr.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button:
//                        String inputText = editText.getText().toString();
//                        Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
//                        imageView.setImageResource(R.drawable.img_2);
//                        if (progressBar.getVisibility() == View.GONE)
//                            progressBar.setVisibility(View.VISIBLE);
//                        else
//                            progressBar.setVisibility(View.GONE);
//                        int progress = progressBar.getProgress();
//                        progress = progress + 10;
//                        progressBar.setProgress(progress);

//                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                        dialog.setTitle("This is a Dialog");
//                        dialog.setMessage("Something important");
//                        dialog.setCancelable(false); //可否使用返回键关闭
//                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                            }
//                        });
//                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                            }
//                        });
//                        dialog.show();

                        break;
                    default:
                        break;
                }
            }
        });
    }
}
