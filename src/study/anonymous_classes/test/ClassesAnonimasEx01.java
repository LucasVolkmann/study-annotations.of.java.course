package study.anonymous_classes.test;

class Animal{
    public void walk(){
        System.out.println("Animal andando");
    }
}

class Cachorro extends Animal{
    @Override
    public void walk() {
        System.out.println("Cachorro andando");
    }
}


public class ClassesAnonimasEx01 {
    public static void main(String[] args) {

        Cachorro cachorro = new Cachorro();
        cachorro.walk();

        //Pode ser trocado por:
        Animal cachorro2 = new Animal(){

            /*

                Isso aqui é uma classe anônima.

                E é uma subclasse de animal (por isso posso
                acessar o método walk)

                Qualquer método CRIADO na classe anônima, não
                poderá ser chamado diretamente, somente pelo método
                sobrescrito. Porque a variável de ref não contém esse
                método

            */

            @Override
            public void walk() {
                System.out.println("Cachorro2 andando");
                jump();
            }

            public void jump(){
                // Só posso chamar em algum método que já existe na classe Animal
                System.out.println("Cachorro 2 pulando");
            }

        };
        cachorro2.walk();

    }
}
