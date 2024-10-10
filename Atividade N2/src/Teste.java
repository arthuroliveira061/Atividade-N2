class ProvaUniversidade {
    protected double notaAV1;
    protected double notaAV2;

    public ProvaUniversidade(double notaAV1, double notaAV2) {
        if (notaAV1 < 0 || notaAV1 > 10 || notaAV2 < 0 || notaAV2 > 10) {
            throw new IllegalArgumentException("As notas devem estar entre 0 e 10.");
        }
        this.notaAV1 = notaAV1;
        this.notaAV2 = notaAV2;
    }

    public double calcularMedia() {
        return (notaAV1 + notaAV2) / 2;
    }
}

class ProvaUCB extends ProvaUniversidade {

    public ProvaUCB(double notaAV1, double notaAV2) {
        super(notaAV1, notaAV2);
    }

    public boolean foiAprovado() {
        double media = calcularMedia();
        return media >= 7;
    }
}

class ProvaFafifo extends ProvaUniversidade {

    public ProvaFafifo(double notaAV1, double notaAV2) {
        super(notaAV1, notaAV2);
    }

    public boolean foiAprovado() {
        double media = calcularMedia();
        return media >= 6;
    }
}

public class Teste {

    public static void verificarAprovacao(ProvaUniversidade prova, String instituicao) {
        if (prova instanceof ProvaUCB && ((ProvaUCB) prova).foiAprovado()) {
            System.out.println("O aluno foi aprovado na " + instituicao + ".");
        } else if (prova instanceof ProvaFafifo && ((ProvaFafifo) prova).foiAprovado()) {
            System.out.println("O aluno foi aprovado na " + instituicao + ".");
        } else {
            System.out.println("O aluno não foi aprovado na " + instituicao + ".");
        }
    }

    public static void main(String[] args) {
        ProvaUCB provaUCB = new ProvaUCB(8.0, 7.0);
        verificarAprovacao(provaUCB, "UCB");

        ProvaFafifo provaFafifo = new ProvaFafifo(5.5, 6.5);
        verificarAprovacao(provaFafifo, "Fafifo");
    }
}