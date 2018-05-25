package sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.trang.settings.R;

import java.util.ArrayList;

public class MainOpinion extends AppCompatActivity {
    Button btnadd;
    ListView lvadd;
    DbCon dbCon;
    DbCon.DbHelper helper= new DbCon.DbHelper(this);
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_opinion);
        init();
        dbCon=new DbCon(this);
        dbCon.open();
        //dbCon.insert();
        getData();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainOpinion.this,Main2Opinoin.class),100);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){
            getData();

        }
    }

    public void getData(){
        arrayList.clear();
        Cursor cursor = null;
        cursor=dbCon.getAll();
        String ykien=" ";
        while (cursor.moveToNext()){
            ykien=cursor.getString(1);
            arrayList.add(ykien);
        }
        ArrayAdapter adapter=new ArrayAdapter(MainOpinion.this,android.R.layout.simple_list_item_1,arrayList);
//
        lvadd.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public void init() {
        btnadd = (Button) findViewById(R.id.btnadd);
        lvadd = (ListView) findViewById(R.id.lvadd);
        arrayList=new ArrayList<>();
    }

}
