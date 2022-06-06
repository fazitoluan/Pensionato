import java.util.Locale;
import java.util.Scanner;
import entities.Room;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		Room[] vet = new Room[10];
		
		System.out.print("Digite o numero de pessoas que irao alugar quartos: ");
		int n = scan.nextInt();
		
		for (int i = 0; i<n; i++) {
			int atual = i+1;
			
			scan.nextLine();
			System.out.print("Digite o nome da pessoa " + atual + ": ");
			String name = scan.nextLine();
			
			System.out.print("Digite o email da pessoa " + atual + ": ");
			String email = scan.next();
			scan.nextLine();
			
			System.out.print("Digite o numero do quarto da pessoa " + atual + ": ");
			int room = scan.nextInt();
			while(room>n || room<=0) {
				System.out.print("O quarto "+ room + " nao existe, digite um novo quarto para a pessoa " + atual + " :");
				room = scan.nextInt();
			}
			
			if(vet[room-1] == null) {
				vet[room-1] = new Room(name, email, room);
			} else {
				System.out.println("AVISO: O quarto " + room + " ja esta ocupado, inicie o cadastro novamente.");
				i--;
			}		
			System.out.println("=================================================================");
		}
		
		for (int i = 0; i<10; i++) {
			if (vet[i] != null) {
				System.out.println();
				System.out.println(vet[i].toString());
			}
		}
		
		scan.close();
	}

}
