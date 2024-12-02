package br.edu.fateczl.atividade13.model;

import android.os.Build;
import java.time.LocalDate;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class Aluguel {
    private int exemplarCodigo;
    private int alunoRA;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;

    public Aluguel(int exemplarCodigo, int alunoRA, String dataRetirada, String dataDevolucao) {
        this.exemplarCodigo = exemplarCodigo;
        this.alunoRA = alunoRA;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.dataRetirada = LocalDate.parse(dataRetirada);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.dataDevolucao = LocalDate.parse(dataDevolucao);
        }
    }

    public int getExemplarCodigo() {
        return exemplarCodigo;
    }

    public void setExemplarCodigo(int exemplarCodigo) {
        this.exemplarCodigo = exemplarCodigo;
    }

    public int getAlunoRA() {
        return alunoRA;
    }

    public void setAlunoRA(int alunoRA) {
        this.alunoRA = alunoRA;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "exemplarCodigo=" + exemplarCodigo +
                ", alunoRA=" + alunoRA +
                ", dataRetirada=" + dataRetirada +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }
}

