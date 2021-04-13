public class Task4_1 {
    public static void main(String[] args) {

        final int lengthMass=20;
        int max=-11; //границы для
        int min=11;    //интервала от -10 до 10
        int maxIndex=0;
        int minIndex=0;
        int[] mass = new int[lengthMass];

        for (int i=0;i<mass.length;i++){
            mass[i]=(int)(Math.random()*21)-10; //заполняем массив рандомными числами от -10 до 10
            System.out.print(mass[i]+" "); //выводим массив
        }

        for (int i=0;i<mass.length;i++) {
            if ((mass[i] < 0) && (mass[i]>max)){
                max=mass[i]; //находим макс отрицательное числов в массиве
                maxIndex=i;
            }
        }
        for (int i=0;i<mass.length;i++) {
            if ((mass[i] > 0) && (mass[i]<min)){
                min=mass[i]; //находим минимальное положительное числов в массиве
                minIndex=i;
            }
        }


        if (max==0 || min==0) System.out.println("В массиве все значения отрицательные или все положительные");
        else {
            mass[maxIndex]=min; //меняем
            mass[minIndex]=max; //      значения местами
        }

        System.out.println();
        for (int i=0;i<mass.length;i++){
            System.out.print(mass[i]+" "); //выводим новый массив
        }
    }

}
