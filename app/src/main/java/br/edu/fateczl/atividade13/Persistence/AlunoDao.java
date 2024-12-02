package br.edu.fateczl.atividade13.Persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.atividade13.model.Aluno;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class AlunoDao implements ICRUDDao<Aluno> {
    private SQLiteDatabase db;
    private SQLiteHelper helper;

    public AlunoDao(Context context) {
        helper = new SQLiteHelper(context);
    }

    public void open() {
        db = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
    }

    @Override
    public void insert(Aluno aluno) {
        ContentValues values = new ContentValues();
        values.put("ra", aluno.getRa());
        values.put("nome", aluno.getNome());
        values.put("email", aluno.getEmail());

        db.insert("Aluno", null, values);
    }

    @Override
    public void update(Aluno aluno) {
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("email", aluno.getEmail());

        db.update("Aluno", values, "ra = ?", new String[]{String.valueOf(aluno.getRa())});
    }

    @Override
    public void delete(Aluno aluno) throws SQLException {
        db.delete("Aluno", "ra = ?", new String[]{String.valueOf(aluno.getRa())});
    }

    @Override
    public Aluno findOne(int id) throws SQLException {
        Cursor cursor = db.rawQuery("SELECT * FROM Aluno WHERE ra = ?", new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()) {
            Aluno aluno = new Aluno(
                    cursor.getInt(cursor.getColumnIndexOrThrow("ra")),
                    cursor.getString(cursor.getColumnIndexOrThrow("nome")),
                    cursor.getString(cursor.getColumnIndexOrThrow("email"))
            );
            return aluno;
        }
        return null;
    }

    @Override
    public List<Aluno> findAll() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Aluno", null);
        while (cursor.moveToNext()) {
            Aluno aluno = new Aluno(
                    cursor.getInt(cursor.getColumnIndexOrThrow("ra")),
                    cursor.getString(cursor.getColumnIndexOrThrow("nome")),
                    cursor.getString(cursor.getColumnIndexOrThrow("email"))
            );
            alunos.add(aluno);
        }
        return alunos;
    }
}

