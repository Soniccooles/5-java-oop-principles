package com.example.task02;

public class DiscountBill extends Bill {
    private final double discount;

    public double getDiscount() { return discount; }

    public double getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }

    public DiscountBill(double discount) {
        if (discount < 0 || discount > 1) throw new IllegalArgumentException("Укажите скидку от 0 до 1 не включительно");
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        return (long)(super.getPrice() - super.getPrice()*discount);
    }

    public String toString() {
        return super.toString() + "\n" + "со скидкой " + getDiscount() * 100 + "%";
    }

}
