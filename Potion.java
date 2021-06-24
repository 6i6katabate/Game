package com.elsys;

// potion-a e sredstvo za vuzvrushtane na health/mana na geroq koito q izpolzva

public class Potion extends Item implements Equipable, Consumable {
    private final int potMana;
    private final int potHP;

    public Potion(int potMana, int potHP){
        super("Potion");
        this.potMana = potMana;
        this.potHP = potHP;
    }

    @Override
    public String consume(Character user){
    	String output = "";
        int currentHP = user.getCurrentHP() + this.potHP;
        user.setCurrentHP(currentHP);
        if (currentHP > user.getMaxHP()){
            // sled kato pribavim healta ot potion-a kum segashniq na geroq
            // trqbva da proverim dali toi ne e stanal poveche ot max healtha-a mu
            // i ako e stanal poveche go setvame na max health
            user.setCurrentHP(user.getMaxHP());
        }
        output+=("\n"+"+" + this.potHP + " HP");

        if (user instanceof Mage){
            // poneje mana ima samo mage-a pravim proverka dali geroq e instanciq na Mage
            int currentMana = ((Mage) user).getCurrentMana() + this.potMana;
            ((Mage) user).setCurrentMana(currentMana);
            if (currentMana > ((Mage) user).getMaxMana()){
                // tuk ima sushtata proverka kato tazi za health-a
                ((Mage) user).setCurrentMana(((Mage) user).getMaxMana());
            }
            output+=("\n"+"+" + this.potMana + " Mana");
        }
        output+=("\n"+user.toString());
        
        return output;
    }

}
