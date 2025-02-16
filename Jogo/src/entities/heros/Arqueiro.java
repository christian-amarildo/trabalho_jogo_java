package entities.heros;

import Enums.ResultadoAtaque;
import entities.Habilidade;
import entities.Player;

public class Arqueiro extends Hero {
    public Arqueiro(String nome, int hp, int forcaAtaque, int defesa, int destreza, int velocidade, String classe, Habilidade habilidadeEspecial, int dinheiro) {
        super(nome, hp, forcaAtaque, defesa, destreza, velocidade, classe, habilidadeEspecial, dinheiro);
    }
}