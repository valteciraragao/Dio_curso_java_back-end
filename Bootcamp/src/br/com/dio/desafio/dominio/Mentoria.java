package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Mentoria extends Conteudo{
    private LocalDate dataInicio;
    private LocalTime horaInicio;

    public Mentoria(String titulo, String descricao, LocalDate dataInicio, LocalTime horaInicio) {
        super(titulo, descricao);
        this.dataInicio = dataInicio;
        this.horaInicio = horaInicio;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    

    
    @Override
    public double CalculadoraXP(double XP) {
        return XP + 30d;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    @Override
    public String toString() {
        return "Mentoria{" +
                "Título: '" + getTitulo() + '\'' +
                ", Descrição: '" + getDescricao() + '\'' +
                ", Data: '" + dataInicio + '\'' +
                ", Hora: '" + horaInicio + 
                "}";
    }
}
