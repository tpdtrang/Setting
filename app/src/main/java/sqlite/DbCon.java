package sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by DoanTrang on 5/24/2018.
 */

public class DbCon {
    Context context;
    SQLiteDatabase db;
    DbHelper dbHelper;

    public DbCon(Context context) {
        this.context = context;
    }
    public DbCon open(){
        try{
            dbHelper=new DbHelper(context);
            db=dbHelper.getWritableDatabase();
            //Toast.makeText(context,"Tao thanh cong", Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            return this;
        }

    }
    public void close(){
        db.close();
    }
    public void insert(String ykien){
        String query="insert into mycontact values (null,'"+ykien+"')";
        db.execSQL(query);
        Toast.makeText(context, "Thêm thành công", Toast.LENGTH_LONG).show();
        db.close();
    }
    public Cursor getAll(){
        Cursor c=null;
        c=db.rawQuery("select * from mycontact order by id desc ",null);
        return c;
    }

    public static class DbHelper extends SQLiteOpenHelper {
        public  static final String DB_NAME="contact.db";
        public static final String Name_Table="mycontact";
        public static final String CREATE_TABLE ="Create table mycontact(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ykien text)";
        public DbHelper(Context context) {
            super(context, DB_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Name_Table);
            onCreate(sqLiteDatabase);

        }
    }

}
