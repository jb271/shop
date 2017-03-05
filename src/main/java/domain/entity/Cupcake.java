package domain.entity;

public class Cupcake {
    private final int id;
    private int topping;
    private int bottom;

    public Cupcake(int id, int topping, int bottom) {
        this.id = id;
        this.topping = topping;
        this.bottom = bottom;
    }

    public int getId() {
        return id;
    }

    public int getTopping() {
        return topping;
    }

    public void setTopping(int topping) {
        this.topping = topping;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
}
