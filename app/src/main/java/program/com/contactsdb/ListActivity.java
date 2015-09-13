package program.com.contactsdb;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class ListActivity extends Activity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDBHelper userDBHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView =(ListView)findViewById(R.id.listview);
        listDataAdapter=new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        userDBHelper= new UserDBHelper(getApplicationContext());
        sqLiteDatabase=userDBHelper.getReadableDatabase();
        cursor= userDBHelper.getInformations(sqLiteDatabase);
        if (cursor.moveToFirst()){
            do {
                String name, mob, email;
                name=cursor.getString(0);
                mob=cursor.getString(1);
                email=cursor.getString(2);

                DataProvider dataProvider=new DataProvider(name,mob,email);
                listDataAdapter.add(dataProvider);

            }while (cursor.moveToNext());
        }

    }



}
