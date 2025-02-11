package entities.heros;

import Enums.ResultadoAtaque;
import entities.Habilidade;
import entities.Player;

public class Guerreiro extends Hero {
    public Guerreiro(String nome, int hp, int forcaAtaque, int defesa, int destreza, int velocidade, String classe, Habilidade habilidadeEspecial, int dinheiro) {
        super(nome, hp, forcaAtaque, defesa, destreza, velocidade, classe, habilidadeEspecial, dinheiro);
    }

    @Override
    public ResultadoAtaque realizarAtaque(Player alvo) {
        double chanceAcerto = Math.random() * 100;

        if (chanceAcerto <= this.destreza) {
            int dano = this.forcaAtaque - (int) (alvo.getDefesa() * 0.5);
            if (dano < 0) dano = 0;
            alvo.receberDano(dano);
            return ResultadoAtaque.ACERTOU;
        } else if (chanceAcerto > 80) {
            int dano = (int) ((this.forcaAtaque - alvo.getDefesa()) * 1.25);
            if (dano < 0) dano = 0;
            alvo.receberDano(dano);
            return ResultadoAtaque.CRITICAL_HIT;
        }

        return ResultadoAtaque.ERROU;
    }
}