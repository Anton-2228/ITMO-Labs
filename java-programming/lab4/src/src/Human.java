package src;

import src.En.Condition;
import src.Inter.Feelings;
import src.Inter.Move;
import src.Inter.Sentiments;
import src.Inter.Think;

import java.util.ArrayList;

public class Human extends Creature implements Move<Location> {

    private String name;
    private int growth;
    private String location;
    private int id;
    private static int co = 0;
    private Inventory inventory = new Inventory();

    public Human(ArrayList<Condition> a, String b, Location c, int growth) {
        this.id = co;
        co += 1;
        this.name = b;
        this.currentCondition = a;
        this.location = c.getName();
        this.growth = growth;
        c.logIn(this);
    }
    public Think decide = new Think() {
        @Override
        public void doing(String a) {
            System.out.println(Human.this.name + " решил " + a);
        }
    };

    public Think think = new Think() {
        @Override
        public void doing(String a) {
            System.out.println(Human.this.name + " подумал, что " + a);
        }
    };

    public Inventory getInventory() {
        return inventory;
    }

    public int getGrowth() {
        return growth;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return id;
    };

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        } else {
            Human a = (Human) obj;
            return this.id == a.id;
        }
    }


    @Override
    public void goTo(Location a) {
        a.logIn(this);
        this.location = a.getName();
        System.out.println(this.name + " вошел в " + a.getName());
    }

    @Override
    public void goOut(Location a) {
        a.logIn(this);
        this.location = "";
        System.out.println(this.name + " вышел из " + a.getName());
    }

    @Override
    public void hit(String a) {
        class HitTree {
            public void crashed() {
                for (int i = 5; i > 0; i--) {
                    if (Math.random() >= 0.7) {
                        System.out.println(Human.this.name + " ударился об " + a);
                    }
                }
            }
        }
        HitTree hit = new HitTree();
        hit.crashed();
    }

    @Override
    public void move() {
        System.out.println(this.name + " начал идти");
    }

    @Override
    public void workOut(String a) {
        System.out.println(this.name + " начал " + a);
        try {
            this.conditionAdd(Condition.Warm);
        } catch (ExistConditionException e) {
            System.out.println("Человеку уже тепло");
        }
        this.conditionRemove(Condition.Frozen);
    }

    @Override
    public void eat(String a, int b) {
        if (b == 1) {
            this.conditionRemove(Condition.Hunger);
        }
        System.out.println(this.name + " начал есть " + a);
    }

    @Override
    public void putAwayItem(Item a, Inventory b) {
        // ДОБАВИТЬ ЭКСЕПШН
        if (this.inventory.getItems().contains(a)) {
            a.changeLocate(b);
            System.out.println(this.name + " убрал " + a.getName());
        } else {
            throw new ObjectLocationExeption("Объект не в инвентаре");
        }
    }
    @Override
    public void getIt(Item a) {
        if (!this.inventory.getItems().contains(a)) {
            if (a.getLocation() != null) {
                System.out.println(this.name + " взял " + a.getName());
            }
            a.changeLocate(this.inventory);
        } else {
            throw new ObjectLocationExeption("Объект уже в инвентаре");
        }
    }

    private Feelings feelings = new Feeling();
    public void feel() {
        ArrayList<Condition> a = Human.this.currentCondition;
        String b = "";
        for (Condition i : a) {
            b += i.name() + ", ";
        }
        System.out.println(Human.this.name + " сейчас " + b);
    }

    //public Sentiment getSentiment() {
    //    return sentiment;
    //}

    public Feelings getFeelings() {
        return feelings;
    }

    public static class Sentiment implements Sentiments {

        @Override
        public void awareness(Human c, String a, String b) {
            System.out.println(c.name + " осознал, что " + a + " не " + a + " а, " + b);
        }
        @Override
        public void regret(Human c, String a){
            System.out.println(c.name + " жалел о том, что" + a);
        }
    }

    public class Feeling implements Feelings {
        @Override
        public void feelPain(String a, int b) {
            String power = "неопределенная";
            if (b <= 3) {
                power = "слабая";
            } else if (b > 3 && b <=7) {
                power = "средняя";
            } else if (b <= 10) {
                power = "сильная";
            }
            System.out.println(Human.this.name + " чувствует боль в " + a + ". Боль " + power);
        }

        @Override
        public void saw(String a) {
            System.out.println(Human.this.name + " увидел " + a);
        }

        @Override
        public void heard(String a) {
            System.out.println(Human.this.name + "услышал " + a);
        }
    }
}
