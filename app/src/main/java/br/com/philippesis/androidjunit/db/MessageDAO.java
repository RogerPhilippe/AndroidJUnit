package br.com.philippesis.androidjunit.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    private DatabaseHandler dbHandler;

    public boolean insert(Context context, Message message) {

        boolean status = false;
        // Save message
        dbHandler = new DatabaseHandler(context);
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MessageEnum.MESSAGE.getValue(), message.getMessage());
        values.put(MessageEnum.STATUS.getValue(), message.getStatus());
        // Try insert
        try {
            status = db.insert(MessageEnum.TABLE_NAME.getValue(), null, values) != -1;
        } catch (Exception ex) {
            Log.e("DAOError", "Erro ao tentar inserir mensagem!", ex); }
        db.close();
        return status;
    }

    public Message findById(Context context, int id) {

        Message message = new Message();

        dbHandler = new DatabaseHandler(context);

        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String selectOneQuery = "SELECT * FROM "+MessageEnum.TABLE_NAME.getValue()+
                " WHERE "+MessageEnum.ID.getValue()+" = "+id+
                " AND "+MessageEnum.STATUS.getValue()+" = 1";
        Cursor cursor = db.rawQuery(selectOneQuery, null);
        if (cursor != null && cursor.moveToFirst()) {
            message = handlerCursor(cursor);
            cursor.close();
        }
        db.close();
        return message;

    }

    public List<Message> findAll(Context context) {
        dbHandler = new DatabaseHandler(context);
        List<Message> messages = new ArrayList<>();
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+MessageEnum.TABLE_NAME.getValue()+
                " WHERE "+MessageEnum.STATUS.getValue()+" = 1";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Message message = handlerCursor(cursor);
                messages.add(message);
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return messages;
    }

    public boolean delete(Context context, Message message) {
        boolean status = false;
        int id = message.getId();

        dbHandler = new DatabaseHandler(context);
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String deleteQuery = "UPDATE " + MessageEnum.TABLE_NAME.getValue() +
                " SET " + MessageEnum.STATUS.getValue() + " = 0 " +
                " WHERE " + MessageEnum.ID.getValue() + " = "+id;

        Cursor cursor = db.rawQuery(deleteQuery, null);

        if (cursor != null) {
            cursor.moveToFirst();
            status = true;
            cursor.close();
        }
        db.close();
        return status;
    }

    public boolean update(Context context, Message message) {

        boolean status = false;

        int id = message.getId();
        String msg = message.getMessage();
        int newStatus = message.getStatus();

        dbHandler = new DatabaseHandler(context);
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String updateQuery = "UPDATE "+MessageEnum.TABLE_NAME.getValue()+
                " SET "+MessageEnum.MESSAGE.getValue()+ " = '"+msg+"', "+
                MessageEnum.STATUS.getValue()+" = "+newStatus+
                " WHERE "+MessageEnum.ID.getValue()+" = "+id;

        Cursor cursor = db.rawQuery(updateQuery, null);

        if (cursor != null && cursor.moveToFirst()) {
            status = true;
            cursor.close();
        }
        db.close();

        return status;
    }

    Message handlerCursor(Cursor cursor) {
        Message message = new Message();
        message.setId(cursor.getInt(cursor.getColumnIndex(MessageEnum.ID.getValue())));
        message.setMessage(cursor.getString(cursor.getColumnIndex(MessageEnum.MESSAGE.getValue())));
        message.setStatus(cursor.getInt(cursor.getColumnIndex(MessageEnum.STATUS.getValue())));
        return message;
    }

}
