package com.example.coursjavabdd; // A remplacer par votre package

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class NotesDataSource {

    // Champs de la base de données
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_PRENOM,
            MySQLiteHelper.COLUMN_MATHS,
            MySQLiteHelper.COLUMN_SVT,
            MySQLiteHelper.COLUMN_HISTOIRE,
    }; //ajouter vos colonnes...

    public NotesDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Notes createNotes(String prenom, float maths, float svt, float histoire) { // ajouter vos variables. Perso, j'ai utilisé des float pour les notes (décimaux)
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_PRENOM, prenom);
        values.put(MySQLiteHelper.COLUMN_MATHS, maths);
        values.put(MySQLiteHelper.COLUMN_SVT, svt);
        values.put(MySQLiteHelper.COLUMN_HISTOIRE, histoire);
		// ajouter vos valeurs...
		
        long insertId = database.insert(MySQLiteHelper.TABLE_NAME, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Notes newNotes = cursorToNotes(cursor);
        cursor.close();
        return newNotes;
    }

    public List<Notes> getAllNotes() {
        List<Notes> notes = new ArrayList<Notes>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Notes note = cursorToNotes(cursor);
            notes.add(note);
            cursor.moveToNext();
        }

        cursor.close();
        return notes;
    }

    private Notes cursorToNotes(Cursor cursor) {
        Notes notes = new Notes();
        notes.setId(cursor.getLong(0));
        notes.setPrenom(cursor.getString(1));
        notes.setMaths(cursor.getFloat(2));
        notes.setSvt(cursor.getFloat(3));
        notes.setHistoire(cursor.getFloat(4));
        // Ajouter vos setters
        return notes;
    }
}