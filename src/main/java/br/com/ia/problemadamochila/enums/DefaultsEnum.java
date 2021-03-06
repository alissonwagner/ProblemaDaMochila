package br.com.ia.problemadamochila.enums;

public enum DefaultsEnum {
        TAXA_MUTACAO("30"),
        POPULACAO("500"),
        ITERACOES("5000"),
        INTERVALO_GERACAO("150"),
	ITEM_PESO_MAX("2"),
	ITEM_PESO_MIN("1"),
	ITEM_VALOR_MIN("1"),
	ITEM_VALOR_MAX("100"),
        ITENS_MOCHILA("15"),
        MOCHILA_PESO_MAX("20"),
        MOCHILA_VALOR_IDEAL("1500"),
        MOCHILA_TAXA_ACEIT("90");
	
	private final String valor;

	private DefaultsEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
