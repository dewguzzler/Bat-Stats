package com.gorecki.batstats;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BatStatsDatabase {

	public static final int DATABASE_VERSION = 2;
	public static final String DATABASE_NAME = "savedsearchesdb";
	public static final String DATABASE_TABLE = "SavedSearches";

	public static final String KEY_ROWID = "_id";
	public static final int INDEX_ROWID = 0;
	public static final String KEY_LASTNAME = "Last Name";
	public static final int INDEX_LASTNAME = 1;
	public static final String KEY_FIRSTNAME = "First Name";
	public static final int INDEX_FIRSTNAME = 2;
	public static final String KEY_AVERAGE = "Average";
	public static final int INDEX_AVERAGE = 3;
	public static final String KEY_HITS = "Hits";
	public static final int INDEX_HITS = 4;
	public static final String KEY_DOUBLES = "doubles";
	public static final int INDEX_DOUBLES = 5;
    public static final String KEY_TRIPLES = "triples";
	public static final int INDEX_TRIPLES = 6;
    public static final String KEY_HOMERUNS = "homeruns";
	public static final int INDEX_HOMERUNS = 7;
    public static final String KEY_WALKS = "walks";
	public static final int INDEX_WALKS = 8;
    public static final String KEY_HBP = "hbp";
	public static final int INDEX_HBP = 9;
    public static final String KEY_RBI = "rbi";
	public static final int INDEX_RBI = 10;
    public static final String KEY_OBP = "obp";
	public static final int INDEX_OBP = 11;
    public static final String KEY_RUNS = "runs";
	public static final int INDEX_RUNS = 12;
    public static final String KEY_STRIKEOUTS = "strikeouts";
	public static final int INDEX_STRIKEOUTS = 13;
    public static final String KEY_GROUNDOUTS = "groundouts";
	public static final int INDEX_GROUNDOUTS = 14;
    public static final String KEY_FLYOUTS = "flyouts";
	public static final int INDEX_FLYOUTS = 15;
    public static final String KEY_LINEOUTS = "lineouts";
	public static final int INDEX_LINEOUTS = 16;
    public static final String KEY_SACBUNTS = "sacbunts";
	public static final int INDEX_SACBUNTS = 17;
    public static final String KEY_SACFLYS = "sacflys";
	public static final int INDEX_SACFLYS = 18;
    public static final String KEY_STOLENBASES = "stolenbases";
	public static final int INDEX_STOLENBASES = 19;
    public static final String KEY_CAUGHTSTEALING = "caughtstealing";
	public static final int INDEX_CAUGHTSTEALING = 20;
    public static final String KEY_SBPERCENT = "sbpercent";
	public static final int INDEX_SBPERCENT = 21;
    public static final String KEY_ROE = "roe";
	public static final int INDEX_ROE = 22;
    public static final String KEY_SLUGGINGPERCENT = "slugginpercent";
	public static final int INDEX_SLUGGINGPERCENT = 23;

	public static final String[] KEYS_ALL = { BatStatsDatabase.KEY_ROWID,
		BatStatsDatabase.KEY_LASTNAME, BatStatsDatabase.KEY_FIRSTNAME };

	private Context context;
	private SQLiteDatabase database;
	private BatStatsDatabaseHelper helper;
	private static BatStatsDatabase instance = null;

	public BatStatsDatabase(Context context) {
		this.context = context;
	}

	public void open() throws SQLException {
		helper = new BatStatsDatabaseHelper(context);
		database = helper.getWritableDatabase();
	}

	public void close() {
		helper.close();
		helper = null;
		database = null;
	}

	public long createRow(ContentValues values) {
		return database.insert(DATABASE_TABLE, null, values);
	}

	public boolean updateRow(long rowId, ContentValues values) {
		return database.update(DATABASE_TABLE, values,
				BatStatsDatabase.KEY_ROWID + "=" + rowId, null) > 0;
	}

	public boolean deleteRow(long rowId) {
		return database.delete(DATABASE_TABLE, BatStatsDatabase.KEY_ROWID
				+ "=" + rowId, null) > 0;
	}

	public Cursor queryAllByRowID() {
		return database.query(DATABASE_TABLE, KEYS_ALL, null, null, null, null,
				" ROWID");
	}

	public Cursor queryAllByAscending() {
		return database.query(DATABASE_TABLE, KEYS_ALL, null, null, null, null,
				BatStatsDatabase.KEY_LASTNAME + " ASC");
	}
	
		

	public Cursor query(long rowId) throws SQLException {
		Cursor cursor = database.query(true, DATABASE_TABLE, KEYS_ALL,
				KEY_ROWID + "=" + rowId, null, null, null, null, null);
		cursor.moveToFirst();
		return cursor;
	}

	public Cursor queryUrlByRowId(int rowId) throws SQLException {
		Cursor cursor = database.query(true, DATABASE_TABLE, KEYS_ALL,
				KEY_ROWID + "=" + rowId, null, null, null, null, null);
		cursor.moveToFirst();
		return cursor;
	}

	/**@Method to return url when passed in a rowId
	 * 
	 * @param rowId
	 * @return name
	 */
	public String getName(long rowId) {
		String[] columns = new String[] { KEY_FIRSTNAME };
		String name = null;
		Cursor c = database.query(true, DATABASE_TABLE, columns, KEY_ROWID + "=" + rowId, null, null, null,
				null, null);
		c.moveToFirst();
		while (!c.isAfterLast()) {
			
			name = c.getString(c.getColumnIndex(KEY_FIRSTNAME));
			c.moveToNext();
		}
		c.close();
		return name;
	}

	public ContentValues createContentValues(String last_first, String url) {
		ContentValues values = new ContentValues();
		values.put(BatStatsDatabase.KEY_LASTNAME, last_first);
		values.put(BatStatsDatabase.KEY_FIRSTNAME, url);
		return values;
	}

	public static class BatStatsDatabaseHelper extends SQLiteOpenHelper {

		public static void init(Context context) {
			if (null == instance) {
				instance = new BatStatsDatabase(context);
			}
		}

		private static final String DATABASE_CREATE = "create table "
				+ DATABASE_TABLE + " (" + BatStatsDatabase.KEY_ROWID
				+ " integer primary key autoincrement, "
				+ BatStatsDatabase.KEY_LASTNAME + " text not null, "
				+ BatStatsDatabase.KEY_FIRSTNAME + " text not null " + ");";

		public BatStatsDatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS SavedSearches");
			onCreate(db);
		}

	}

}
