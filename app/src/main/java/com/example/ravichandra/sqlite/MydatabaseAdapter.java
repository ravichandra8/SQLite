package com.example.ravichandra.sqlite;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MydatabaseAdapter {
    String result;
    sqlhelper sqlhelper;

    static class sqlhelper extends SQLiteOpenHelper {

        private static final String userreg="CREATE TABLE userreg (id VARCHAR(255) PRIMARY KEY,username VARCHAR(255),email VARCHAR(255),password VARCHAR(255));";

        private static final String name = "demo";
        private static final int version = 1;

        private Context context;

        public sqlhelper(Context context) {
            super(context, name, null, version);
            this.context = context;
        }

        public void onCreate(SQLiteDatabase db) {
            try {

                db.execSQL(userreg);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS userreg");

            onCreate(db);

        }
    }

    public MydatabaseAdapter(Context context) {
        this.sqlhelper = new sqlhelper(context);
    }

    //dial100count-insert

//    public void dial100count(String id,String acceptstate,String acceptdate,String seenstate,String status) {
//        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
//        ContentValues values;
//
//        if (sd.query("dial100count", new String[]{"id"}, "id=?", new String[]{id}, null, null, null).getCount() > 0) {
//            values = new ContentValues();
//            values.put("id", id);
//            values.put("acceptvis", acceptstate);
//            values.put("acceptdate", acceptdate);
//            values.put("seenvis", seenstate);
//            values.put("status", status);
//            sd.update("dial100count", values, "id=?", new String[]{id});
//        }
//        else
//        {
//
//            values = new ContentValues();
//            values.put("id", id);
//
//            values.put("acceptvis", acceptstate);
//            values.put("acceptdate", acceptdate);
//            values.put("seenvis", seenstate);
//            values.put("status", status);
//            sd.insert("dial100count", null, values);
//
//        }
//
//
//
//        sd.close();
//    }
//
//    //update dial100 acceptancestate
//
////    public void dial100accept(String id,String acceptvis) {
////        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
////        ContentValues values;
////
////
////
////
////
////        sd.close();
////    }
////
//    //dial100 update seen
//
//    public void dial100seen(String id,String seenvis) {
//        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
//        ContentValues values;
//
//        if (sd.query("dial100count", new String[]{"id"}, "id=?", new String[]{id}, null, null, null).getCount() > 0) {
//            values = new ContentValues();
//            values.put("seenvis", seenvis);
//
//            sd.update("dial100count", values, "id=?", new String[]{id});
//        }
//
//
//
//
//        sd.close();
//    }
//
//    //dial100count-select
//    public Cursor getdial100() {
//        return this.sqlhelper.getWritableDatabase().query("dial100count", new String[]{"id","acceptvis","acceptdate","seenvis"}, null, null, null, null, null, null);
//    }
//    //dial100count-delete
//    public void deletedial100(String id) {
//        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
//        sd.delete("dial100count", "id LIKE ? ", new String[]{id});
//        sd.close();
//    }


    //all notification
    //all notification
    public long insertdata(String id,String name,String email,String password) {
        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
        ContentValues values;

        values = new ContentValues();
        values.put("id", id);

        values.put("username", name);

        values.put("email", email);
        values.put("password", password);



        long status=sd.insert("userreg", null, values);

       return status;
    }

    public Cursor getalldata()
    {
        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
        return sd.query("userreg",new String[]{"id","username","email","password"},null,null,null,null,null);
    }

//    public Cursor getallnotify() {
//        return this.sqlhelper.getWritableDatabase().query("allnotify", new String[]{"id","type","username","mobileno","role","address","lat","longi"}, null, null, null, null, null, null);
//    }
//
//
//    public void delteallnotify(String id) {
//        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
//        sd.delete("allnotify", "id LIKE ? ", new String[]{id});
//        sd.close();
//    }
//
//
//
//
//
//    public void insertbuzz(String id,String newid) {
//        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
//        ContentValues values;
//        if (sd.query("buzz", new String[]{"id"}, "id=?", new String[]{id}, null, null, null).getCount() > 0) {
//            values = new ContentValues();
//            values.put("id", newid);
//
//            sd.update("buzz", values, "id=?", new String[]{id});
//        } else {
//            values = new ContentValues();
//            values.put("id", id);
//
//            sd.insert("buzz", null, values);
//        }
//        sd.close();
//    }
//
//    public Cursor getbuzzid() {
//        return this.sqlhelper.getWritableDatabase().query("buzz", new String[]{"id"}, null, null, null, null, null, null);
//    }
//
//
//    public void insertincident(String id,String newid) {
//        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
//        ContentValues values;
//        if (sd.query("incidence", new String[]{"id"}, "id=?", new String[]{id}, null, null, null).getCount() > 0) {
//            values = new ContentValues();
//            values.put("id", newid);
//
//            sd.update("incidence", values, "id=?", new String[]{id});
//        } else {
//            values = new ContentValues();
//            values.put("id", id);
//
//            sd.insert("incidence", null, values);
//        }
//        sd.close();
//    }
//
//    public Cursor getincident() {
//        return this.sqlhelper.getWritableDatabase().query("incidence", new String[]{"id"}, null, null, null, null, null, null);
//    }
//
//
//
//    public void dial100insert(String id,String newid) {
//        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
//        ContentValues values;
//        if (sd.query("dial100", new String[]{"id"}, "id=?", new String[]{id}, null, null, null).getCount() > 0) {
//            values = new ContentValues();
//            values.put("id", newid);
//
//            sd.update("dial100", values, "id=?", new String[]{id});
//        } else {
//            values = new ContentValues();
//            values.put("id", id);
//
//            sd.insert("dial100", null, values);
//        }
//        sd.close();
//    }
//
//    public Cursor getdial100count() {
//        return this.sqlhelper.getWritableDatabase().query("dial100", new String[]{"id"}, null, null, null, null, null, null);
//    }
//
////    public Cursor getBenefatorData(String benName, String benContact, String benEmail) {
////        return this.sqlhelper.getWritableDatabase().query("Benefactory", new String[]{"contactno", "email", "name", "relation"}, "name LIKE ? AND contactno LIKE ? AND email LIKE ?", new String[]{benName, benContact, benEmail}, null, null, null);
////    }
//
////    public void deleteBenefatorData(String benName, String benContact, String benEmail) {
////        SQLiteDatabase sd = this.sqlhelper.getWritableDatabase();
////        sd.delete("Benefactory", "name LIKE ? AND contactno LIKE ? AND email LIKE ?", new String[]{benName, benContact, benEmail});
////        sd.close();
////    }
//
////    public Cursor checkBenContact() {
////        return this.sqlhelper.getWritableDatabase().query("Benefactory", new String[]{"contactno"}, null, null, null, null, null);
////    }
}
