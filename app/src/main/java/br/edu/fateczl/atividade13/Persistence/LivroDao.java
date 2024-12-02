package br.edu.fateczl.atividade13.Persistence;

import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.atividade13.model.Livro;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class LivroDao implements ICRUDDao<Livro> {
    private SQLiteDatabase db;
    private SQLiteHelper helper;

    public LivroDao(Context context) {
        helper = new SQLiteHelper(context);
    }

    // Abre o banco de dados para escrita
    public void open() {
        db = helper.getWritableDatabase();
    }

    // Fecha o banco de dados
    public void close() {
        helper.close();
    }

    @Override
    public void insert(Livro livro) {
        ContentValues valuesExemplar = new ContentValues();
        valuesExemplar.put("codigo", livro.getCodigo());
        valuesExemplar.put("nome", livro.getNome()); // Atributo de Exemplar
        valuesExemplar.put("qtPaginas", livro.getQtdPaginas()); // Método de Exemplar

        ContentValues valuesLivro = new ContentValues();
        valuesLivro.put("codigo", livro.getCodigo()); // FK e PK em Livro
        valuesLivro.put("isbn", livro.getISBN());
        valuesLivro.put("edicao", livro.getEdicao());

        // Insere no Exemplar primeiro (entidade mãe)
        db.insert("Exemplar", null, valuesExemplar);
        // Insere no Livro depois (entidade filha)
        db.insert("Livro", null, valuesLivro);
    }

    @Override
    public void delete(Livro livro) throws SQLException {
        db.delete("Livro", "codigo = ?", new String[]{String.valueOf(livro.getCodigo())});
        db.delete("Exemplar", "codigo = ?", new String[]{String.valueOf(livro.getCodigo())});
    }

    @Override
    public void update(Livro livro) throws SQLException {
        ContentValues valuesExemplar = new ContentValues();
        valuesExemplar.put("nome", livro.getNome());
        valuesExemplar.put("qtPaginas", livro.getQtdPaginas());

        ContentValues valuesLivro = new ContentValues();
        valuesLivro.put("isbn", livro.getISBN());
        valuesLivro.put("edicao", livro.getEdicao());

        db.update("Exemplar", valuesExemplar, "codigo = ?", new String[]{String.valueOf(livro.getCodigo())});
        db.update("Livro", valuesLivro, "codigo = ?", new String[]{String.valueOf(livro.getCodigo())});
    }

    @Override
    public Livro findOne(int id) throws SQLException {
        Cursor cursor = db.rawQuery(
                "SELECT * FROM Exemplar e JOIN Livro l ON e.codigo = l.codigo WHERE e.codigo = ?",
                new String[]{String.valueOf(id)}
        );

        Livro livro = null;
        if (cursor != null && cursor.moveToFirst()) {
            livro = new Livro(
                    cursor.getInt(cursor.getColumnIndexOrThrow("codigo")),
                    cursor.getString(cursor.getColumnIndexOrThrow("nome")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("qtPaginas")),
                    cursor.getString(cursor.getColumnIndexOrThrow("isbn")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("edicao"))
            );
        }
        if (cursor != null) {
            cursor.close();
        }
        return livro;
    }

    @Override
    public List<Livro> findAll() throws SQLException {
        List<Livro> livros = new ArrayList<>();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM Exemplar e JOIN Livro l ON e.codigo = l.codigo", null
        );

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Livro livro = new Livro(
                        cursor.getInt(cursor.getColumnIndexOrThrow("codigo")),
                        cursor.getString(cursor.getColumnIndexOrThrow("nome")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("qtPaginas")),
                        cursor.getString(cursor.getColumnIndexOrThrow("isbn")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("edicao"))
                );
                livros.add(livro);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return livros;
    }
}




