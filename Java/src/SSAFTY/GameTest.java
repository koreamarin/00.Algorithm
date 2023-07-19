package SSAFTY;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.\n");
		System.out.println("1.5판 3승");
		System.out.println("2.3판 2승");
		System.out.println("3.1판 1승\n");
		System.out.print("번호를 입력하세요.");
		
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
			
			System.out.print("가위바위보 중 하나 입력: ");
			client_choice_num = sc.nextInt();
			
			int computer_choice_num = (int)(Math.random() * 3) + 1;
			
			if (client_choice_num == 1 & computer_choice_num==2) {
				lose -= 1;
				System.out.println("졌습니다!!!");
			}	else if (client_choice_num == 1 & computer_choice_num==3) {
				win -= 1;
				System.out.println("이겼습니다!!!");
			}	else if (client_choice_num == 2 & computer_choice_num==1) {
				win -= 1;
				System.out.println("이겼습니다!!!");
			}	else if (client_choice_num == 2 & computer_choice_num==3) {
				lose -= 1;
				System.out.println("졌습니다!!!");
			}	else if (client_choice_num == 3 & computer_choice_num==1) {
				lose -= 1;
				System.out.println("졌습니다!!!");
			}	else if (client_choice_num == 3 & computer_choice_num==2) {
				win -= 1;
				System.out.println("이겼습니다!!!");
			}	else {
				System.out.println("비겼습니다!!!");
			}
			
			
			if (win==0) {
				System.out.println("###사용자 승!!!");
				break;
			}
			else if (lose==0) {
				System.out.println("###컴퓨터 승!!!");
				break;
			}
		}
		
		

	}

}
