package br.edu.fateczl.atividade13.Persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "biblioteca.db";
    private static final int DATABASE_VERSION = 1;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tabela Exemplar (Mãe)
        db.execSQL("CREATE TABLE Exemplar (" +
                "codigo INTEGER PRIMARY KEY, " +
                "nome VARCHAR(30), " +
                "qtPaginas INTEGER)");

        // Tabela Livro (Filha)
        db.execSQL("CREATE TABLE Livro (" +
                "codigo INTEGER PRIMARY KEY, " +
                "isbn CHAR(13), " +
                "edicao INTEGER, " +
                "FOREIGN KEY(codigo) REFERENCES Exemplar(codigo))");

        // Tabela Revista (Filha)
        db.execSQL("CREATE TABLE Revista (" +
                "codigo INTEGER PRIMARY KEY, " +
                "issn CHAR(8), " +
                "FOREIGN KEY(codigo) REFERENCES Exemplar(codigo))");

        // Tabela Aluno
        db.execSQL("CREATE TABLE Aluno (" +
                "ra INTEGER PRIMARY KEY, " +
                "nome VARCHAR(100), " +
                "email VARCHAR(50))");

        // Tabela Aluguel
        db.execSQL("CREATE TABLE Aluguel (" +
                "exemplarCodigo INTEGER, " +
                "alunoRA INTEGER, " +
                "data_retirada VARCHAR(10), " +
                "data_devolucao VARCHAR(10), " +
                "PRIMARY KEY(exemplarCodigo, alunoRA), " +
                "FOREIGN KEY(exemplarCodigo) REFERENCES Exemplar(codigo), " +
                "FOREIGN KEY(alunoRA) REFERENCES Aluno(ra))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Aluguel");
        db.execSQL("DROP TABLE IF EXISTS Livro");
        db.execSQL("DROP TABLE IF EXISTS Revista");
        db.execSQL("DROP TABLE IF EXISTS Aluno");
        db.execSQL("DROP TABLE IF EXISTS Exemplar");
        onCreate(db);
    }
}

