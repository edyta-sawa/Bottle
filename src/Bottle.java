public class Bottle {
        private double howManyLiters;

        double getHowManyLiters() {
            return howManyLiters;
        }

        boolean pour(double amount, double capacity) {
            if (capacity >= amount) {
                this.howManyLiters += amount;
            } else {
                System.out.println("Too much.");
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

        void pourOver(double amount, Bottle where, double capacity) {
            if (this.pourOut(amount)
                    && where.pour(amount, capacity))
            {
                System.out.println("Done.");
            }
            else {
                System.out.println("Wrong proportion.");
            }
        }

        Bottle(double howManyLiters) {
            this.howManyLiters = howManyLiters;
        }

    public static void main(String[] args) {
        Bottle[] bottles = new Bottle[50];

        for (int i=0; i < bottles.length; i++) {
            bottles[i] = new Bottle(i);
        }

        bottles[0].pour(0.7, 0.7);
        bottles[1].pourOver(0.4, bottles[2], 2.5);

        System.out.println(bottles[0].getHowManyLiters());
        System.out.println(bottles[1].getHowManyLiters());
        System.out.println(bottles[2].getHowManyLiters());
    }
}
