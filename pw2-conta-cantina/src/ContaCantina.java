public class ContaCantina {
    private TipoContaEnum tipoConta;
    private double saldo;
    private double limite;
    private double saldoMinimo;

    public ContaCantina(double saldo) {
        this.saldo = saldo;
        this.tipoConta = TipoContaEnum.ALUNO;
        this.saldoMinimo = 10;
    }

    public ContaCantina(TipoContaEnum tipoConta, double saldo) {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        if(tipoConta == TipoContaEnum.PROFESSOR){
            this.limite = 100;
        }
    }
    public void emitirAlertaSaldoBaixo(){
        if(this.saldo <= this.saldoMinimo){
            System.out.println("ALERTA DE SALDO BAIXO: R$ " + this.saldo);
        }
        else {
            System.out.println("Saldo: R$ " + this.saldo);
        }
    }
    public void debitar(double valor){
        if(this.tipoConta == TipoContaEnum.DIRETOR){
            this.saldo -= valor;
            emitirAlertaSaldoBaixo();
        } else if(this.tipoConta == TipoContaEnum.PROFESSOR && this.saldo > valor && valor < (this.saldo + this.limite)){
            this.saldo -= valor;
            emitirAlertaSaldoBaixo();
        }
        else if(this.tipoConta == TipoContaEnum.ALUNO && this.saldo > valor){
            this.saldo -= valor;
            emitirAlertaSaldoBaixo();
        }
        else{
            System.out.println("Conta sem saldo suficiente");
        }
    }
    public void creditar(double valor){
        if(this.tipoConta == TipoContaEnum.ALUNO && valor > 100){
            valor += 5;
        }
        this.saldo += valor;
        emitirAlertaSaldoBaixo();
    }

    public void setSaldoMinimo(double saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
        emitirAlertaSaldoBaixo();
    }
}
