import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by shreyas.b1 on 12/08/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        System.out.println("Enter the size of the array");
        try {
            n = Integer.parseInt(scan.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input "+e.getMessage());
            System.exit(-1);
        }
        if (n > 0) {
            int arr[] = new int[n];
            System.out.println("Enter the elements");
            for(int i=0;i<n;i++){
                try {
                    arr[i] = scan.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("Invalid input "+e.getMessage());
                    System.exit(-1);
                }
            }
            System.out.println("Select the algorithm you want");
            System.out.println("-----------------\n1.)Selection Main\n2.)Bubble Main\n3.)Insertion Main\n4.)Merge Main\n5.)QuickSort\n");
            int choice=0;
            try {
                choice =scan.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Invalid input"+e.getMessage());
                System.exit(-1);
            }
            Sort sort =new Sort();
            switch (choice){
                case 1:arr=sort.selectionSort(arr);
                        break;
                case 2:arr=sort.bubbleSort(arr);
                        break;
                case 3:arr=sort.selectionSort(arr);
                        break;
                case 4:arr=sort.mergeSort(arr);
                        break;
                case 5:arr=sort.quickSort(arr);
                        break;
                default:
                    System.out.println("Invalid option");
                    System.exit(-1);

            }
            for(int i:arr) {
                System.out.print(i+" ");
            }
        }
    }
}
