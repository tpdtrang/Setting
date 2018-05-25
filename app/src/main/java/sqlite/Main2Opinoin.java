package sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.trang.settings.R;

public class Main2Opinoin extends AppCompatActivity {
    EditText edtsave;
    Button btnsave;
    DbCon dbCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_opinoin);

        init();
        dbCon=new DbCon(this);
        dbCon.open();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbCon.insert(edtsave.getText().toString().trim());
                finish();
            }
        });

    }
    public void init(){
        btnsave=findViewById(R.id.btnsave);
        edtsave=findViewById(R.id.edtsave);
    }


}
