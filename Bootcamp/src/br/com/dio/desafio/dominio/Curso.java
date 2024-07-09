package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {
    private int cargaHoraria;

    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double CalculadoraXP(double XP) {
        return XP * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    
    @Override
    public String toString() {
        return "Curso{" +
                "Título: '" + getTitulo() + '\'' +
                ", Descrição: '" + getDescricao() + '\'' +
                ", Carga horária: '" + cargaHoraria + '\'' +
                "}";
    }

}
