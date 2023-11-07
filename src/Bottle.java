public class Bottle {
        private double howManyLiters;

        double getHowManyLiters() {
            return howManyLiters;
        }

        boolean pour(double amount, double capacity) {
            if (capacity >= amount
                    && this.howManyLiters + amount <= capacity) {
                this.howManyLiters += amount;
            } else {
                return false;
            }

            return true;
        }

        boolean pourOut (double amount) {
            if (this.howManyLiters >= amount) {
                this.howManyLiters -= amount;
            }
            else return false;

            return true;
        }

        int conditionsPourOver (double amount, Bottle where, double capacity) {
            if (capacity >= amount
                    && where.howManyLiters + amount <= capacity
                    && this.howManyLiters >= amount) {
                return 1;  // all
            } else if (capacity >= amount
                    && where.howManyLiters + amount > capacity
                    && capacity - where.howManyLiters > 0
                    && where.howManyLiters + amount - capacity > 0) {
                return 2;
            } else return 0;
        }

        void pourOver(double amount, Bottle where, double capacity) {
            if (this.conditionsPourOver(amount, where, capacity) == 1)
            {where.pour(amount, capacity);
                this.pourOut(amount);
            } else if (this.conditionsPourOver(amount, where, capacity) == 2) {
                double moreVal = where.howManyLiters + amount - capacity;
                double pourVal = amount - moreVal;
                where.pour(pourVal, capacity);
                this.pourOut(pourVal);
            } else {
                System.out.println("Wrong proportion.");
            }
        }

        Bottle(double howManyLiters) {
            this.howManyLiters = howManyLiters;
        }

    public static void main(String[] args) {
        Bottle[] bottles = new Bottle[50];

        for (int i=0; i < bottles.length; i++) {
            bottles[i] = new Bottle(2);
        }

        bottles[0].pour(0.7, 2.7);
        bottles[0].pourOut(0.2);
        bottles[1].pourOver(1, bottles[2], 2.8);

        System.out.println(bottles[0].getHowManyLiters());
        System.out.println(bottles[1].getHowManyLiters());
        System.out.println(bottles[2].getHowManyLiters());
    }
}
