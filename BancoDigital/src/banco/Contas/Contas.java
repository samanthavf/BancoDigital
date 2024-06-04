package banco.Contas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import banco.Caixa.Caixa;
import banco.Clientes.Clientes;

public class Contas implements ContasInter{
	private static final int NUMERO_AGENCIA = 1;
	private static int SEQUENCIAL = 1;
	private Scanner sc = new Scanner(System.in);
	private Caixa caixa = new Caixa();
	private List<Clientes> clientesList = new ArrayList<>();	
	
	protected int numero;
	protected int agencia;
	protected double saldo;
	protected Clientes cliente;
		
	public Contas() {
		this.agencia = Contas.NUMERO_AGENCIA;
		this.numero = SEQUENCIAL++;
	}
	
	protected void criarConta() {
		System.out.println("Digite seu nome: ");
		String nome = sc.next();
		
		Clientes cliente = new Clientes();
		cliente.setName(nome);
		cliente.setNumero(getNumero());
		this.cliente = cliente;
		this.numero = cliente.getNumero();
		clientesList.add(cliente);
		voltar();
		
	}
	

	@Override
	public void depositar() {
		System.out.println("Valor de depósito: ");
		double valorDeposito = sc.nextDouble();
		this.saldo += valorDeposito;
		voltar();
		
	}

	@Override
	public void sacar() {
		System.out.println("Valor de saque: ");
		double valorSaque = sc.nextDouble();
		if (getSaldo() != 0) {
			this.saldo -= valorSaque;
		}else {
			System.out.println("Saldo Insuficiente");
		}
		voltar();
	}

	@Override
	public void transferencia() {
		System.out.println("Agência destino: ");
		int agenciaDestino = sc.nextInt();
		
		System.out.println("Conta destino: ");
		int contaDestino = sc.nextInt();
		
		if (existeContaDestino(contaDestino, agenciaDestino)) {
			
		}
		
				System.out.println("Valor de transferência: ");
				double valorTransferir = sc.nextDouble();
				this.saldo -= valorTransferir;
				voltar();
	}
	
	 private boolean existeContaDestino(int numeroConta, int agenciaDestino) {
		 for (Clientes clientes : clientesList) {
			 System.out.println("Validando ...");
			if (clientes.getNumero() == numeroConta && getAgencia() == agenciaDestino) {
				return true;
			}
		}
		 return false;
	 }
	
	@Override
	public void imprimirExtrato() {
		System.out.println("------EXTRATO------");
		System.out.println(String.format("Titular: %s", cliente.getName()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		voltar();
	}
	
	private void voltar(){
		caixaEletronico();
	}
	
	protected void caixaEletronico() {
		System.out.println("------------------------ BANCO -----------------------");
		System.out.println("| OPERAÇÃO 1 - DEPOSITO      |");
		System.out.println("| OPERAÇÃO 2 - SACAR         |");
		System.out.println("| OPERAÇÃO 3 - TRANSFERIR    |");
		System.out.println("| OPERAÇÃO 4 - EXTRATO       |");
		System.out.println("| OPERAÇÃO 0 - ENCERRAR      |");
		System.out.println("| OPERAÇÃO 9 - VOLTAR        |");
		
		int operacao = sc.nextInt();
		switch (operacao) {
			case 1:
			    depositar();
			break;
			
			case 2:
				sacar();
			break;
			
			case 3:
				transferencia();
			break;
			
			case 4:
				imprimirExtrato();
			break;
			
			case 0:
				System.out.println("Operações ecerradas");
				sc.close();
				System.exit(0);
			break;
			
			case 9:
				caixa.caixa();
			break;

		default:
			System.out.println("Unexpected value: " + operacao);
			sc.close();
			System.exit(0);
		}
	}
	
	public int getNumero() {
		return numero;
	}

	 public int getAgencia() {
			return agencia;
		}

	public double getSaldo() {
			return saldo;
		}
}
