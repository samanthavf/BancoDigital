package banco.Caixa;

import java.util.Scanner;

import banco.Contas.ContaCorrente;
import banco.Contas.ContaPoupanca;

public class Caixa {
	private Scanner sc = new Scanner(System.in);
	
	public void caixa() {
		System.out.println("------------------------ BANCO -----------------------");
		System.out.println("| OPERAÇÃO 1 - CONTA POUPANCA|");
		System.out.println("| OPERAÇÃO 2 - CONTA CORRENTE|");
		
		
		int operacao = sc.nextInt();
				
				switch (operacao) {
				case 1: 
					ContaPoupanca cp = new ContaPoupanca();
					cp.contaPoupanca();
					break;
					
					case 2: 
						ContaCorrente cc = new ContaCorrente();
						cc.contaCorrente();
						break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + operacao);
				}
	}
	
}
