package com.elsys;

public class Mage extends Character {
    private int currentMana;
    private final int maxMana;

    // osven health, intellect i dexterity
    // mage-a ima i mana koqto se izpolzva za izpolzvaneto na scroll-a
    // (ako mage-a nqma mana ne moje da izpolzva scroll-a)

    public Mage(){
        super(60, 60, 10, 5);
        this.currentMana = 80;
        this.maxMana = 80;
    }

    public int getCurrentMana(){
        return this.currentMana;
    }

    public int getMaxMana(){
        return this.maxMana;
    }

    public void setCurrentMana(int currentMana){
        this.currentMana = currentMana;
    }

    @Override
    protected String getCharacterClass(){
        return "Mage";
    }
}
