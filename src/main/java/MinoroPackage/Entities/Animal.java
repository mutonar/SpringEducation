package MinoroPackage.Entities;

public abstract class Animal  implements  Animals{
    String name = "";
    private int Weight;

    public String getName(){
        return  name;
    }

    @Override
    public int getWeight() {
        return  Weight;
    }
    @Override
    public void setWeight(int Weight) {
        this.Weight = Weight;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

}
