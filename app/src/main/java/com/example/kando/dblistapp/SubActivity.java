package com.example.kando.dblistapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by kando on 2017/01/27.
 */

public class SubActivity extends AppCompatActivity {

  private EditText textTitle;
  private EditText textBody;

  private ImageButton backButton;
  private ImageButton saveButton;
  private ImageButton previewButton;
  private ImageButton deleteButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sub);

    findViews();        // 各部品の結びつけ処理
    init();
    // 戻るボタンのアラートダイアログ
    final AlertDialog.Builder backAlertDlg = new AlertDialog.Builder(this);
    backAlertDlg.setMessage("前のページに戻ります");
    backAlertDlg.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            // List画面へ戻る
            finish();
          }
        });
    backAlertDlg.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            // 何もしない
          }
        });

    // 削除ボタンのアラートダイアログ
    final AlertDialog.Builder deleteAlertDlg = new AlertDialog.Builder(this);
    deleteAlertDlg.setMessage("データを削除します");
    deleteAlertDlg.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            // DBから削除してList画面に戻る処理
            //deleteDocment("Title01");
            finish();
          }
        });
    deleteAlertDlg.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            // 何もしない
          }
        });


    backButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //警告文を出し、OKならList画面へ戻り、Cancelなら何もしない
        backAlertDlg.create().show();
      }
    });

    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //Todo 書き込んだ内容をDBに保存する処理

        // キーボードを非表示
        InputMethodManager inputMethodManager =
            (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);

        // DBに登録
        //saveList();
      }
    });

    previewButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //Todo 書き込んだ内容を一時保存し、preview画面に値を渡して遷移
        Intent intent = new Intent(getApplication(), MainActivity.class);
        startActivity(intent);
        //startActivityForResult(intent, id_number);
      }
    });

    deleteButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //警告文を出し、yesならデータをDBから削除してList画面へ戻る。noなら何もしない。
        deleteAlertDlg.create().show();
      }
    });


  }


  // 各部品の結びつけ処理
  private void findViews() {
    textTitle = (EditText) findViewById(R.id.text_title);
    textBody = (EditText) findViewById(R.id.text_body);

    backButton = (ImageButton) findViewById(R.id.back_button);
    saveButton = (ImageButton) findViewById(R.id.save_button);
    previewButton = (ImageButton) findViewById(R.id.preview_button);
    deleteButton = (ImageButton) findViewById(R.id.delete_button);
  }

  private void init() {
    //ToDo 持ってきたidのデータからそれぞれ値を入れる
    textTitle.setText("ttt");
    textBody.setText("bbb");
  }

}
