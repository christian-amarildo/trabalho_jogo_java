package entities.heros;

import entities.Habilidade;
import entities.Player;

import java.util.List;

public abstract class Hero extends Player {
    private String classe;
    private Habilidade habilidadeEspecial;
    private int dinheiro;
    private boolean emBatalha = false;

    public Hero(String nome, int hp, int forcaAtaque, int defesa, int destreza, int velocidade, String classe, Habilidade habilidadeEspecial, int dinheiro) {
        super(nome, hp, forcaAtaque, defesa, destreza, velocidade);
        this.classe = classe;
        this.habilidadeEspecial = habilidadeEspecial;
        this.dinheiro = dinheiro;
    }

    public static void curarTodosOsHerois(List<Hero> herois, int quantidade) {
        for (Hero heroi : herois) {
            heroi.curar(quantidade); // Cura cada herói
        }
    }

    public static void aumentarForcaAtaqueTodosOsHerois(List<Hero> herois, int aumento) {
        for (Hero heroi : herois) {
            heroi.aumentarForcaAtaque(aumento); // Aumenta a força de ataque de cada herói
        }
    }

    public static void aumentarDefesaTodosOsHerois(List<Hero> herois, int aumento) {
        for (Hero heroi : herois) {
            heroi.aumentarDefesa(aumento); // Aumenta a defesa de cada herói
        }
    }

    // Método para aumentar a força de ataque do herói
    public void aumentarForcaAtaque(int aumento) {
        this.forcaAtaque += aumento;
        System.out.println(this.nome + " teve sua força de ataque aumentada para " + this.forcaAtaque);
    }

    // Método para aumentar a defesa do herói
    public void aumentarDefesa(int aumento) {
        this.defesa += aumento;
        System.out.println(this.nome + " teve sua defesa aumentada para " + this.defesa);
    }

    public void curar(int quantidade) {
        this.hp += quantidade; // Aumenta a vida do herói
        System.out.println(this.nome + " recuperou " + quantidade + " de vida. Vida atual: " + this.hp);
    }

    public void verificaHPEmBatalha() {
        if(getHp() <= 0) {
            System.out.println("\nVocê está sem HP, se recupere antes de lutar!");
            setEmBatalha(false);
        }
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void gastarDinheiro(int valor) {
        if (dinheiro >= valor) {
            dinheiro -= valor;
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Dinheiro insuficiente.");
        }
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

    public boolean getEmBatalha() {
        return this.emBatalha;
    }

    public void setEmBatalha(boolean emBatalha) {
        this.emBatalha = emBatalha;
    }
}