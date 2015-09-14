package program.com.contactsdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by faith on 9/12/15.
 */
public class UserDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="USERINFO.DB";
    private static final int DATABASE_VERSION=1;
    private static  final String CREATE_QUERY="CREATE TABLE "+ UserContact.NewUserInfo.TABLE_NAME+
            "("+ UserContact.NewUserInfo.USER_NAME+" TEXT,"+
            UserContact.NewUserInfo.USER_MOB+" TEXT,"+
            UserContact.NewUserInfo.USER_EMAIL+" TEXT);";

    public UserDBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","DATABASE CREATED/ OPENED ...");

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","TABLE CREATED...");
    }

    public void addInformations(String name,String  mob,String email,SQLiteDatabase db)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(UserContact.NewUserInfo.USER_NAME,name);
        contentValues.put(UserContact.NewUserInfo.USER_MOB,mob);
        contentValues.put(UserContact.NewUserInfo.USER_EMAIL,email);
        db.insert(UserContact.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "one row inserted...");
    }
    public Cursor getInformations(SQLiteDatabase db)
    {
    Cursor cursor;
        String[] projectons= {UserContact.NewUserInfo.USER_NAME, UserContact.NewUserInfo.USER_MOB, UserContact.NewUserInfo.USER_EMAIL};
       cursor= db.query(UserContact.NewUserInfo.TABLE_NAME,projectons,null,null,null,null,null);
        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
