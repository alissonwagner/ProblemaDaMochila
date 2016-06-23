package br.com.ia.problemadamochila.enums;

public enum DefaultsEnum {
	ITEM_PESO_MAX("5"),
	ITEM_PESO_MIN("0.5"),
	ITEM_VALOR_MIN("1"),
	ITEM_VALOR_MAX("10");
	
	private final Double valor;

	private DefaultsEnum(String valor) {
		this.valor = Double.parseDouble(valor);
	}

	public Double getValor() {
		return valor;
	}
}
