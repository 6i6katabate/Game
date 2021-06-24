package com.elsys;

// klasa Character ima bar i hotbar kato bar e mqstoto kudeto sa podredeni vsichki itemi
// a na hotbar-a sa podredeni predmetite koito sa prednaznacheni za burzo polzvane

// klasovete Mage i Archer extendvat abstraktniq klas Character
// kato vseki ot tqh ima suotvetno za tqh orujie (Scroll i Mage)
// koito extendvat abstraktniq klas Item
// vseki ot geroite moje da vzeme orujieto na drugiq no nqma da moje da go izpolzva
// klasa Potion (otnovo extendva Item) e obsht za dvata geroq kato toi sluji za
// vazvrushtane na mana/health


// ima 3 klasa koito sa interface-i (Consumable, Equipable i Usable)
// te slujat za da se opredeli dali nqkoi item moje da bude izpolzvan (Usable)
// dali moje da bude slojen v hotbar-a (Equipable)
// i dali trqbva da izchezne sled kato bude izpolzvan (Consumable)

public class Main {
    public static void main (String[] args){
        try {
            Mage mage = new Mage();
            Archer archer = new Archer();

            // suzdavame po edin ot geroi ot dvata klasa

            Scroll scroll = new Scroll(50, 50);
            Bow bow = new Bow(30);

            // suzdavme orujiq za geroite

            Potion p1 = new Potion(20, 30);
            Potion p2 = new Potion(10, 10);
            Potion p3 = new Potion(15, 15);
            Note n1 = new Note("You are a worthy opponent, but in the end the better one won!");
            Note n2 = new Note("Come here and fight me!");

            // suzdavame potion-i i note-ove

            mage.pick(scroll);
            mage.pick(p1);
            mage.pick(n1);

            archer.pick(bow);
            archer.pick(p3);
            archer.pick(n2);

            // "razdavame" napravenite predmeti na dvata geroq

            archer.useAt(3, mage);

            mage.useAt(1, archer);
            archer.useAt(2, archer);
            archer.useAt(1, mage);
            mage.useAt(1, archer);
            mage.useAt(2, mage);
            mage.useAt(1,archer);

            mage.useAt(2, archer);

            // napravena e ilustraciq na primerna bitka koqto pokazva primeri za izpolzvaneto
            // na vseki edin ot napravenite klasove
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
