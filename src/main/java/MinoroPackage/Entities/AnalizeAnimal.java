package MinoroPackage.Entities;

public class AnalizeAnimal
{
    Animal animal;
    public AnalizeAnimal(){

    }
    // Все как в учебники патернов
    public AnalizeAnimal(Animal animal){
        this.animal = animal;
    }

    public void setAnimal(Animal animal){ // меняем животное
        this.animal = animal;
    }

    public String getAnimalName() {
        return animal.getName();
    }
    public void setName(String name) {
        animal.setName(name);
    }

    public void setWeight(int Weight) {
        animal.setWeight(Weight);
    }
    public int getWeight() {
        return  animal.getWeight();
    }
}
