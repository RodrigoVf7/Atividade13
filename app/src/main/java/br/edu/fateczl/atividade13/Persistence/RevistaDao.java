package br.edu.fateczl.atividade13.Persistence;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

import br.edu.fateczl.atividade13.model.Revista;

public class RevistaDao implements ICRUDDao<Revista> {
    private SQLiteDatabase db;
    private SQLiteHelper helper;

    public RevistaDao(Context context) {
        helper = new SQLiteHelper(context);
    }

    public void open() {
        db = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
    }

    @Override
    public void insert(Revista revista) {
        ContentValues values = new ContentValues();
        values.put("codigo", revista.getCodigo());
        values.put("qtPaginas", revista.getQtdPaginas());
        values.put("nome", revista.getNome());
        values.put("isbn", revista.getIsbn());
        values.put("edicao", revista.getEdicao());

        db.insert("Revista", null, values);
    }

    @Override
    public void update(Revista revista) {
        ContentValues values = new ContentValues();
        values.put("nome", revista.getNome());
        values.put("qtPaginas", revista.getQtdPaginas());
        values.put("isbn", revista.getIsbn());
        values.put("edicao", revista.getEdicao());

        db.update("Revista", values, "codigo = ?", new String[]{String.valueOf(revista.getCodigo())});
    }

    @Override
    public void delete(Revista revista) throws SQLException {
        db.delete("Revista", "codigo = ?", new String[]{String.valueOf(revista.getCodigo())});
    }

    @Override
    public Revista findOne(int id) throws SQLException {
        Cursor cursor = db.rawQuery("SELECT * FROM Revista WHERE codigo = ?", new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()) {
            Revista revista = new Revista(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codigo")),   // Código
                    cursor.getString(cursor.getColumnIndexOrThrow("nome")),   // Nome
                    cursor.getInt(cursor.getColumnIndexOrThrow("qtPaginas")), // Quantidade de Páginas
                    cursor.getString(cursor.getColumnIndexOrThrow("isbn")),   // ISBN
                    cursor.getInt(cursor.getColumnIndexOrThrow("edicao"))    // Edição
            );
            cursor.close();
            return revista;
        }
        cursor.close();
        return null;
    }


    @Override
    public List<Revista> findAll() throws SQLException {
        List<Revista> revistas = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Exemplar e JOIN Revista r ON e.codigo = r.codigo", null);

        while (cursor.moveToNext()) {

            Revista revista = new Revista(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codigo")),   // Código
                    cursor.getString(cursor.getColumnIndexOrThrow("nome")),   // Nome
                    cursor.getInt(cursor.getColumnIndexOrThrow("qtPaginas")), // Quantidade de páginas
                    cursor.getString(cursor.getColumnIndexOrThrow("isbn")),   // ISBN
                    cursor.getInt(cursor.getColumnIndexOrThrow("edicao"))    // Edição
            );
            revistas.add(revista);
        }
        cursor.close();
        return revistas;
    }

}

