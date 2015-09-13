package program.com.contactsdb;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PublicKey;


public class MainActivity extends Activity {
        EditText ContacName, ContactMObile, ContactEmail;
        Context context=this;
        UserDBHelper userDBHelper;
        SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContacName=(EditText)findViewById(R.id.edt1);
        ContactMObile =(EditText)findViewById(R.id.edt2);
        ContactEmail=(EditText)findViewById(R.id.edt3);
    }

    public void addContact(View view)
    {
        String name=ContacName.getText().toString();
        String mob=ContactMObile.getText().toString();
        String email=ContactEmail.getText().toString();
        userDBHelper=new UserDBHelper(context);
        sqLiteDatabase=userDBHelper.getWritableDatabase();
        userDBHelper.addInformations(name,mob,email,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Saved", Toast.LENGTH_LONG).show();
        userDBHelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
