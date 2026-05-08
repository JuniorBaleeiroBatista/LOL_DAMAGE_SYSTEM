import java.util.Scanner;

public class DanoInArmor{
    public static void main(String[] args){
        int ad = 0;
        int danoPorAA = 0;
        double danoCausado = 0;
        double armorpen = 0;
        int armor = 0;
        double armorMenosPen = 0;
        int letalidade = 0;
        double armorFinal = 0;
        double chanceCrit = 0;
        double danoCrit = 0;
        double vidaInimigo = 0;
        double vidaPerdida = 0;
        double vidaInimigoAtual= 0;
        int ataques = 0;

        Scanner leitura = new Scanner(System.in);

        System.out.println("Com quanto de AD seu campeão está? ");
        ad = leitura.nextInt();
        System.out.println("Com quanto de chance de acerto critico seu campeão está? ");
        chanceCrit = leitura.nextDouble();
        chanceCrit = chanceCrit/100;
        int crits = 0;  
        System.out.println("Com quanto de penetração de armadura seu campeão está? ");
        armorpen = leitura.nextDouble();
        armorpen = armorpen/100;
        System.out.println("Com quanto de letalidade seu campeão está? ");
        letalidade = leitura.nextInt();
        System.out.println("Quanto de vida tem o seu inimigo? ");
        vidaInimigo = leitura.nextDouble();
        System.out.println("Com quanto de armadura o campeão inimigo está? ");
        armor = leitura.nextInt();
        armorMenosPen = armor * (1 - armorpen);
        System.out.println("Com base na sua penetração de armadura você deixa o inimigo com " +armorMenosPen);
        armorFinal = armorMenosPen - letalidade;
        System.out.println("Com base em toda a sua penetração de armadura você deixa o inimigo com " +armorFinal);
        danoPorAA = (int) (ad * (100 / (100 + armorFinal)));;
        danoCrit = danoPorAA*2;
        System.out.println("Então você vai dar "+danoPorAA + " por auto attack e seu dano por acerto critico é " + danoCrit);

        System.out.println("Escolha um dos 3 itens para modificar seu dano: ");
        System.out.println("1 - Espada do Rei (Causa dano conforme maior a vida máxima do inimigo)");
        System.out.println("2 - Gume do Infinito (Faz com que seus acertos criticos cause 30% a mais de dano)");
        System.out.println("3 - Coletora (Casa dano quanto menor a vida atual do inimigo)");
        System.out.println("Digite o número do item que você deseja: ");
        int item = leitura.nextInt();

        boolean espadaDoReiEscolhida = item == 1;
        boolean gumeDoInfinitoEscolhido = item == 2;;
        boolean coletoraEscolhida = item == 3;

        vidaInimigoAtual = vidaInimigo;
        ataques = 0;
        crits = 0;
        while (vidaInimigoAtual > 0){
            double random = Math.random();
            if (random < chanceCrit){
                danoCausado = danoCrit;
                crits++;

                if(gumeDoInfinitoEscolhido){
                    danoCausado = danoCrit * 2.3;
                }
            }
            else{
                danoCausado = danoPorAA;
            }
            if(espadaDoReiEscolhida){
                vidaPerdida = vidaInimigo - vidaInimigoAtual;
                danoCausado += 0.1 * vidaInimigo; 
            }
            if (coletoraEscolhida){
                vidaPerdida = vidaInimigo - vidaInimigoAtual;
                danoCausado += 0.1 * vidaPerdida;
            }

            vidaInimigoAtual -= danoCausado;
            ataques++;
            System.out.println("Ataque "+ ataques + " causou " + danoCausado + " de dano");
            System.out.println("O inimigo ficou com " + vidaInimigoAtual + " de vida");

        }
        System.out.println("Você precisou de: " +ataques + " ataques para eliminar o inimigo, sendo que você teve " + crits + " acertos críticos");

    }
}