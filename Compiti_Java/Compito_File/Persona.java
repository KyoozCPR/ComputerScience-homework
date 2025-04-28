public class Persona implements Comparable<Persona>{
    private int age;
    private String nome;

    public String getNome() {
        return nome;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException("Età non valida");
        }
        else {
            this.age = age;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Persona(int age, String nome){
        setAge(age);
        setNome(nome);
    }

    @Override
    public String toString(){
        return this.nome + "@" + this.age;
    }

    @Override
    public int compareTo(Persona p){
        int value = this.age-p.age;
        if (value == 0){
            return this.nome.compareToIgnoreCase(p.nome);
        }
        return value;
    }


}
