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
 

        vidaInimigoAtual = vidaInimigo;
        ataques = 0;
        crits = 0;
        while (vidaInimigoAtual > 0){
            double random = Math.random();
            if (random < chanceCrit){
                danoCausado = danoCrit;
                crits++;
            }
            else{
                danoCausado = danoPorAA;
            }

            vidaInimigoAtual -= danoCausado;
            ataques++;
            System.out.println("Ataque "+ ataques + " causou " + danoCausado + "de dano");
            System.out.println("O inimigo ficou com " + vidaInimigoAtual + " de vida");

        }
        System.out.println("Você precisou de: " +ataques + " ataques para eliminar o inimigo, sendo que você teve " + crits + " acertos críticos");

    }
}