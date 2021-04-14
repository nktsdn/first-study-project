package Task4_2;

public class Sweets {
    private String name;
    private double weight;
    private double price;
    private String uniqueParameter;

    public Sweets(String name, double weight, double price, String uniqueParameter) {
        this.name = name;
        this.weight =  weight;
        this.price = price;
        this.uniqueParameter = uniqueParameter;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }


    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }


    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }


    public String getUniqueParameter(){
        return uniqueParameter;
    }
    public void setUniqueParameter(String uniqueParameter){
        this.uniqueParameter = uniqueParameter;
    }
}
