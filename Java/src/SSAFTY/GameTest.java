package SSAFTY;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("���������� ������ �����մϴ�. �Ʒ� ���� �� �ϳ��� ������.\n");
		System.out.println("1.5�� 3��");
		System.out.println("2.3�� 2��");
		System.out.println("3.1�� 1��\n");
		System.out.print("��ȣ�� �Է��ϼ���.");
		
		int num = sc.nextInt();
		int win = 3;
		int lose = 3;

		if (num == 2) {
			win = 2;
			lose = 2;
		}
		else if (num == 3) {
			win = 1;
			lose = 1;
		}
		
		while (true) {
			int client_choice_num=0;
			String client_choice;
			
			System.out.print("���������� �� �ϳ� �Է�: ");
			client_choice_num = sc.nextInt();
			
			int computer_choice_num = (int)(Math.random() * 3) + 1;
			
			if (client_choice_num == 1 & computer_choice_num==2) {
				lose -= 1;
				System.out.println("�����ϴ�!!!");
			}	else if (client_choice_num == 1 & computer_choice_num==3) {
				win -= 1;
				System.out.println("�̰���ϴ�!!!");
			}	else if (client_choice_num == 2 & computer_choice_num==1) {
				win -= 1;
				System.out.println("�̰���ϴ�!!!");
			}	else if (client_choice_num == 2 & computer_choice_num==3) {
				lose -= 1;
				System.out.println("�����ϴ�!!!");
			}	else if (client_choice_num == 3 & computer_choice_num==1) {
				lose -= 1;
				System.out.println("�����ϴ�!!!");
			}	else if (client_choice_num == 3 & computer_choice_num==2) {
				win -= 1;
				System.out.println("�̰���ϴ�!!!");
			}	else {
				System.out.println("�����ϴ�!!!");
			}
			
			
			if (win==0) {
				System.out.println("###����� ��!!!");
				break;
			}
			else if (lose==0) {
				System.out.println("###��ǻ�� ��!!!");
				break;
			}
		}
		
		

	}

}
