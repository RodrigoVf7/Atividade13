package br.edu.fateczl.atividade13.Persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.atividade13.model.Aluguel;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class AluguelDao implements ICRUDDao<Aluguel> {
    private SQLiteDatabase db;
    private SQLiteHelper helper;

    public AluguelDao(Context context) {
        helper = new SQLiteHelper(context);
    }

    public void open() {
        db = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
    }

    @Override
    public void insert(Aluguel aluguel) {
        ContentValues values = new ContentValues();
        values.put("exemplarCodigo", aluguel.getExemplarCodigo());
        values.put("alunoRA", aluguel.getAlunoRA());
        values.put("dataRetirada", aluguel.getDataRetirada().toString());
        values.put("dataDevolucao", aluguel.getDataDevolucao().toString());

        db.insert("Aluguel", null, values);
    }

    @Override
    public void update(Aluguel aluguel) {
        ContentValues values = new ContentValues();
        values.put("exemplarCodigo", aluguel.getExemplarCodigo());
        values.put("alunoRA", aluguel.getAlunoRA());
        values.put("dataRetirada", aluguel.getDataRetirada().toString());
        values.put("dataDevolucao", aluguel.getDataDevolucao().toString());

        db.update("Aluguel", values, "exemplarCodigo = ? AND alunoRA = ?",
                new String[]{String.valueOf(aluguel.getExemplarCodigo()), String.valueOf(aluguel.getAlunoRA())});
    }

    @Override
    public void delete(Aluguel aluguel) throws SQLException {
        db.delete("Aluguel", "exemplarCodigo = ? AND alunoRA = ?",
                new String[]{String.valueOf(aluguel.getExemplarCodigo()), String.valueOf(aluguel.getAlunoRA())});
    }

    @Override
    public Aluguel findOne(int id) throws SQLException {
        Cursor cursor = db.rawQuery("SELECT * FROM Aluguel WHERE exemplarCodigo = ?", new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()) {
            Aluguel aluguel = new Aluguel(
                    cursor.getInt(cursor.getColumnIndexOrThrow("exemplarCodigo")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("alunoRA")),
                    cursor.getString(cursor.getColumnIndexOrThrow("dataRetirada")),
                    cursor.getString(cursor.getColumnIndexOrThrow("dataDevolucao"))
            );
            return aluguel;
        }
        return null;
    }

    @Override
    public List<Aluguel> findAll() throws SQLException {
        List<Aluguel> alugueis = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Aluguel", null);
        while (cursor.moveToNext()) {
            Aluguel aluguel = new Aluguel(
                    cursor.getInt(cursor.getColumnIndexOrThrow("exemplarCodigo")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("alunoRA")),
                    cursor.getString(cursor.getColumnIndexOrThrow("dataRetirada")),
                    cursor.getString(cursor.getColumnIndexOrThrow("dataDevolucao"))
            );
            alugueis.add(aluguel);
        }
        return alugueis;
    }
}

