package com.example.kando.dblistapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private ArrayAdapter<String> adapter;       // ArrayAdapter
  private ArrayList<String> items;            // ArrayList
  private ListView itemList;                    // ListView

  private static final String[] titles = {
      // Scenes of Isle of Wight
      "Title01",
      "Title02",
      "Title03",
      "Title04",
      "Title05",
  };
  private static final int[] no = {
      // Scenes of Isle of Wight
      1,
      2,
      3,
      4,
      5,
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViews();            // 各部品の結び付け

    // ArrayListを生成
    items = new ArrayList<>();


    // ArrayAdapterのコンストラクタ
    adapter = new ArrayAdapter<>
//        (this, android.R.layout.simple_list_item_1, items);
          (this, android.R.layout.simple_list_item_1, titles);

    itemList.setAdapter(adapter);     //ListViewにアダプターをセット(=表示)


    // リストタップ時の遷移処理
    itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      public void onItemClick(AdapterView<?> parent,
                              View view, int pos, long id) {
        // 選択アイテムを取得
        ListView listView = (ListView) parent;
        String item = (String) listView.getItemAtPosition(pos);

        // 通知ダイアログを表示
        Log.v("ListView", "selected pos=" + pos + " id=" + id);
        Toast.makeText(MainActivity.this,
            item, Toast.LENGTH_SHORT
        ).show();

        Intent intent = new Intent(getApplication(), SubActivity.class);
        startActivityForResult(intent, (int) id);
      }
    });
  }


  /**
   * 各部品の結びつけ処理
   * findViews()
   */
  private void findViews() {
    itemList = (ListView) findViewById(R.id.itemList);       // ドキュメント一覧用のListView
  }

}
