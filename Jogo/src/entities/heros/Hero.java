package entities.heros;

import entities.Habilidade;
import entities.Player;

public abstract class Hero extends Player {
    private String classe;
    private Habilidade habilidadeEspecial;
    private int dinheiro;

    public Hero(String nome, int hp, int forcaAtaque, int defesa, int destreza, int velocidade, String classe, Habilidade habilidadeEspecial, int dinheiro) {
        super(nome, hp, forcaAtaque, defesa, destreza, velocidade);
        this.classe = classe;
        this.habilidadeEspecial = habilidadeEspecial;
        this.dinheiro = dinheiro;
    }

    public void equiparArma(Item arma) {
        if (arma.getTipo().equals("Arma")) {
            this.forcaAtaque += arma.getBonusAtaque(); // Aumenta o ataque do herói
            System.out.println("Você equipou " + arma.getNome() + "! Força de ataque aumentada para " + this.forcaAtaque + ".");
        } else {
            System.out.println("Este item não é uma arma.");
        }
    }

    public void equiparArmadura(Item armadura) {
        if (armadura.getTipo().equals("Defesa")) {
            this.defesa += armadura.getBonusDefesa(); // Aumenta a defesa do herói
            System.out.println("Você equipou " + armadura.getNome() + "! Defesa aumentada para " + this.defesa + ".");
        } else {
            System.out.println("Este item não é uma armadura.");
        }
    }

    public void curar(int quantidade) {
        this.hp += quantidade; // Aumenta a vida do herói
        System.out.println(this.nome + " recuperou " + quantidade + " de vida. Vida atual: " + this.hp);
    }

    public int getDinheiro() {
        return dinheiro;
    }

    // Método para gastar dinheiro (já existente)
    public void gastarDinheiro(int valor) {
        if (dinheiro >= valor) {
            dinheiro -= valor;
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Dinheiro insuficiente.");
        }
    }

    // Método para adicionar dinheiro
    public void adicionarDinheiro(int valor) {
        this.dinheiro += valor;  // Adiciona o valor ao saldo de dinheiro
        System.out.println("Você ganhou " + valor + " moedas! Dinheiro atual: " + this.dinheiro);
    }

    public String getClasse() {
        return classe;
    }

    public Habilidade getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    public void mostrarDinheiro() {
        System.out.println("Dinheiro disponível: " + dinheiro);
    }
}
