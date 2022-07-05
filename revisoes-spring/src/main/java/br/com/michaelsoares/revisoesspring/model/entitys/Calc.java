package br.com.michaelsoares.revisoesspring.model.entitys;

public class Calc {
    private int a;
    private int b;
    private int resultado;
    private String op;
    public Calc() {}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	

    public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public void somar() {
    	setResultado(getA()+getB());
    }
    
    public void sub() {
    	setResultado(getA()-getB());
    }
    
}
