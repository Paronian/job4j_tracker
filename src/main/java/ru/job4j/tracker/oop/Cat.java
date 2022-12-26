package ru.job4j.tracker.oop;

public class Cat {
    private String food;
    private String name;

    public void giveNick(String nick){
        this.name = nick;
    }

    public void show() {
        System.out.println("It's name is " + this.name + ". It's ate a " + this.food);
        //System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black Cat");
        black.show();
    }
}
