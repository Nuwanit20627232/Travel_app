package Detabes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class DBhander extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public DBhander(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);


    }
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PlanTriplanka.Users.TABLE_NAME + " (" +
                    PlanTriplanka.Users._ID + " INTEGER PRIMARY KEY," +

                    PlanTriplanka.Users.COLUMN_1+ " TEXT," +
                    PlanTriplanka.Users.COLUMN_2+ " TEXT," +
                    PlanTriplanka.Users.COLUMN_3+ " TEXT," +
                    PlanTriplanka.Users.COLUMN_4+ " TEXT,)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PlanTriplanka.Users.TABLE_NAME;

    public long addInfo (String groupname,String placeofvisit,String traveldate,String traveltime){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(PlanTriplanka.Users.COLUMN_1, groupname);
        values.put(PlanTriplanka.Users.COLUMN_2, placeofvisit);
        values.put(PlanTriplanka.Users.COLUMN_3, traveldate);
        values.put(PlanTriplanka.Users.COLUMN_4, traveltime);

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(PlanTriplanka.Users.TABLE_NAME, null, values);

        return newRowId;


    }
    public Boolean updateInfo (String groupname,String placeofvisit,String traveldate,String traveltime) {

        SQLiteDatabase db = getWritableDatabase();

// New value for one column

        ContentValues values = new ContentValues();
        values.put(PlanTriplanka.Users.COLUMN_2,placeofvisit );
        values.put(PlanTriplanka.Users.COLUMN_3,traveldate );
        values.put(PlanTriplanka.Users.COLUMN_4,traveltime );


// Which row to update, based on the title
        String selection = PlanTriplanka.Users.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { "groupname" };

        int count = db.update(
                PlanTriplanka.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if (count >=1) {
            return true;
        }
        else {
            return false;
        }

    }
    public  void deleteInfo (String groupname){
        SQLiteDatabase db = getWritableDatabase();
        // Define 'where' part of query.
        String selection = PlanTriplanka.Users.COLUMN_1 + " LIKE ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = { "groupname" };
// Issue SQL statement.
        int deletedRows = db.delete(PlanTriplanka.Users.TABLE_NAME, selection, selectionArgs);

    }
    public List readAllinfo ( ){
        String groupname= "nuwan";

        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                PlanTriplanka.Users.COLUMN_1,
                PlanTriplanka.Users.COLUMN_2,
                PlanTriplanka.Users.COLUMN_3,
                PlanTriplanka.Users.COLUMN_4,


        };

// Filter results WHERE "title" = 'My Title'
        String selection = PlanTriplanka.Users.COLUMN_1 + " = ?";
        String[] selectionArgs = { groupname };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                PlanTriplanka.Users.COLUMN_1+ " ASC";

        Cursor cursor = db.query(
                PlanTriplanka.Users.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        List groupnames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String user = cursor.getString(
                    cursor.getColumnIndexOrThrow(PlanTriplanka.Users.COLUMN_1));
            groupnames.add(user);
        }
        cursor.close();
        return groupnames;

    }


    public List readAllinfo ( String groupname) {


        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                PlanTriplanka.Users.COLUMN_1,
                PlanTriplanka.Users.COLUMN_2,
                PlanTriplanka.Users.COLUMN_3,
                PlanTriplanka.Users.COLUMN_4,


        };

// Filter results WHERE "title" = 'My Title'
        String selection = PlanTriplanka.Users.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = {groupname};

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                PlanTriplanka.Users.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                PlanTriplanka.Users.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        List userinfo = new ArrayList<>();
        while (cursor.moveToNext()) {
            String user = cursor.getString(cursor.getColumnIndexOrThrow(PlanTriplanka.Users.COLUMN_1));
            String  placeofvisit = cursor.getString(cursor.getColumnIndexOrThrow(PlanTriplanka.Users.COLUMN_2));
            String traveldate = cursor.getString(cursor.getColumnIndexOrThrow(PlanTriplanka.Users.COLUMN_3));
            String traveltime = cursor.getString(cursor.getColumnIndexOrThrow(PlanTriplanka.Users.COLUMN_4));
            userinfo.add(user);//0
            userinfo.add(placeofvisit);//1
            userinfo.add(traveldate);//2
            userinfo.add(traveltime);//3
        }
        cursor.close();
        return userinfo;

    }
}