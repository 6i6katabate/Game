package com.elsys;

import java.util.ArrayList;

public abstract class Character {
    protected int currentHP;
    protected int maxHP;
    protected int intellect;
    protected int dextetiry;

    private int inventorySize;
    private int hotbarSize;

    private Item inventory[] = new Item[10];
    private Item hotbar[] = new Item[3];

    Character (int currentHP, int maxHP, int intellect, int dextetiry){
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        this.intellect = intellect;
        this.dextetiry = dextetiry;
        this.inventorySize = 0;
        this.hotbarSize = 0;
    }

    public int getCurrentHP(){
        return this.currentHP;
    }

    public int getMaxHP(){
        return this.maxHP;
    }

    public int getIntellect(){
        return this.intellect;
    }

    public int getDextetiry() {
        return this.dextetiry;
    }

    public void setCurrentHP(int currentHP){
        this.currentHP = currentHP;
    }

    protected abstract String getCharacterClass();

    @Override
    public String toString(){
        String out;
        if (this instanceof Mage){
            out = getCharacterClass() + "(" + this.currentHP + "/" + this.getMaxHP() +" hp, " + ((Mage) this).getCurrentMana() + "/" + ((Mage) this).getMaxMana() + " mana) ";
        }
        else {
            out = getCharacterClass() + "(" + this.currentHP + "/" + getMaxHP() + " hp) ";
        }
        return out;
    }

    public void pick (Item newItem) throws Exception{
        if (newItem.getIfPicked() == true){
            // ako predmetut veche e vzet ot nqkogo hvurlq exception
            throw new Exception("The item is already picked!\n");
        }

        if (this.inventorySize== 10 && this.hotbarSize == 3){
            // ako inventarut na geroq e pulen hvurlq exception
            throw new Exception("Your inventory is full!\n");
        }

        this.inventory[inventorySize] = newItem;
        this.inventorySize++;
        if (newItem instanceof Equipable && (hotbarSize < 3)){
            this.hotbar[this.hotbarSize] = newItem;
            this.hotbarSize++;
        }
        newItem.setIfPicked(true);

        System.out.println(this.toString() + "picked " + newItem.getType());
    }

    public void useAt (int index, Character target) throws Exception{
        if (index < 1 || index > 3){
            throw new Exception("There is no item on that slot!\n");
        }
        // izpolzvaemite itemi imat indexi ot 1 do 3
        // ako podadem index izvun tozi range se hvurq exception

        if (this.hotbar[index - 1] instanceof Consumable){
            System.out.println(this.toString() + "used " + this.hotbar[index - 1].getType());
            ((Consumable) this.hotbar[index - 1]).consume(this);
            for (int i = index; i < 3; i++) {
                this.hotbar[i - 1] = this.hotbar[i];
            }
            this.hotbarSize--;
            this.hotbar[this.hotbarSize] = null;
            return;
            // izpolzvane na dadeniq item (ako toi e Consumable
            // sled kato itema bude izpolzvam ostanalite itemi
            // se prepodrajdat v hotbar-a
        }


        if (this.hotbar[index - 1] instanceof Usable){
            if (this.hotbar[index - 1] instanceof Note){

            }
            else {
                System.out.println(this.toString() + "used " + this.hotbar[index - 1].getType() + " on " + target.toString());
            }
            ((Usable) this.hotbar[index - 1]).use(this, target);
        }
    }
}
