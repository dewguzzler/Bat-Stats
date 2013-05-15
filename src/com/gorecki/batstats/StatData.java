package com.gorecki.batstats;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.provider.BaseColumns;

public class StatData extends SQLiteOpenHelper {
    
    private static final String DATABASE_NAME = "statdata.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "stats";

    public static final String _ID = BaseColumns._ID;
    public static final String AVERAGE = "average";
    public static final String HITS = "hits";
    public static final String SINGLES = "singles";
    public static final String DOUBLES = "doubles";
    public static final String TRIPLES = "triples";
    public static final String HOMERUNS = "homeruns";
    public static final String WALKS = "walks";
    public static final String HBP = "hbp";
    public static final String RBI = "rbi";
    public static final String OBP = "obp";
    public static final String RUNS = "runs";
    public static final String STRIKEOUTS = "strikeouts";
    public static final String GROUNDOUTS = "groundouts";
    public static final String FLYOUTS = "flyouts";
    public static final String LINEOUTS = "lineouts";
    public static final String SACBUNTS = "sacbunts";
    public static final String SACFLYS = "sacflys";
    public static final String STOLENBASES = "stolenbases";
    public static final String CAUGHTSTEALING = "caughtstealing";
    public static final String SBPERCENT = "sbpercent";
    public static final String ROE = "roe";
    public static final String SLUGGINGPERCENT = "slugginpercent";

    public StatData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("deprecation")
    public Cursor all(Activity activity) {
        String[] from = { _ID, AVERAGE, HITS, SINGLES, DOUBLES, TRIPLES, HOMERUNS, WALKS, HBP, RBI, OBP, RUNS, STRIKEOUTS,
                GROUNDOUTS, FLYOUTS, LINEOUTS, SACBUNTS, SACFLYS, STOLENBASES, CAUGHTSTEALING, SBPERCENT, ROE, SLUGGINGPERCENT};
        String order = _ID;

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, from, null, null, null, null, order);
        activity.startManagingCursor(cursor);

        return cursor;
      }

    public StatData(Context context, String name, CursorFactory factory, int version,
            DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     // CREATE TABLE teas (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, brew_time INTEGER);
        String sql =
          "CREATE TABLE " + TABLE_NAME + " ("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + AVERAGE + " NUMERIC, "
            + HITS + " INTEGER, "
            + SINGLES + " INTEGER, "
            + DOUBLES + " INTEGER, "
            + TRIPLES + " INTEGER, "
            + HOMERUNS + " INTEGER, "
            + WALKS + " INTEGER, "
            + HBP + " INTEGER, "
            + RBI + " INTEGER, "
            + OBP + " INTEGER, "
            + RUNS + " INTEGER, "
            + STRIKEOUTS + " INTEGER, "
            + GROUNDOUTS + " INTEGER, "
            + FLYOUTS + " INTEGER, "
            + LINEOUTS + " INTEGER, "
            + SACBUNTS + " INTEGER, "
            + SACFLYS + " INTEGER, "
            + STOLENBASES + " INTEGER, "
            + CAUGHTSTEALING + " INTEGER, "
            + SBPERCENT + " INTEGER, "
            + ROE + " INTEGER, "
            + SLUGGINGPERCENT + " NUMERIC "
            + ");";

        
        db.execSQL(sql);

    }
    
    public void insert(String name, int stat) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(name, stat);

        db.insertOrThrow(TABLE_NAME, null, values);
      }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

}
