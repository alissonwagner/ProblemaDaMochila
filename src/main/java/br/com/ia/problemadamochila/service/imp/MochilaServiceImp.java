package br.com.ia.problemadamochila.service.imp;

import br.com.ia.problemadamochila.ParametrosForm;
import br.com.ia.problemadamochila.bo.ItemBO;
import br.com.ia.problemadamochila.bo.MochilaBO;
import br.com.ia.problemadamochila.service.MochilaService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("mochilaService")
public class MochilaServiceImp implements MochilaService{
    
    @Override
    public List<MochilaBO> geraPopulacaoInicial(ParametrosForm params){
        List<MochilaBO> populacao = new ArrayList<>();
        
        for(int i = 0; i < params.getPopulacao(); i++){
            populacao.add(geraMochilaAleatoria(params));
        }
        
        populacao = calculaFitnessDaPopulacao(populacao, params.getPesoMaxMochila());
        
        return populacao;
    }
    
    @Override
    public List<MochilaBO> calculaFitnessDaPopulacao(List<MochilaBO> populacao, BigDecimal pesoMax){
        populacao.stream().forEach((mochila) -> {
            mochila.setFitness(calculaFitnessMochila(mochila, pesoMax));
        });
        
        return populacao;
    }
    
    /**
     * Se a mochila extrapola o limite de peso, o peso dela no cálculo do fitness será 20% maior que o das mochilas no padrão
     * O fitness será a razão entre o valor e o peso
    */
    private BigDecimal calculaFitnessMochila (MochilaBO mochila, BigDecimal pesoMax){
        BigDecimal fitness;
        BigDecimal peso = mochila.getPeso();
        
        if(mochila.getPeso().compareTo(pesoMax) == 1){
            peso = mochila.getPeso().multiply(new BigDecimal("1.2"));
        }
        
        fitness = mochila.getValor().divide(peso, 2,RoundingMode.HALF_UP);
        
        return fitness;
    }
    
    private MochilaBO geraMochilaAleatoria(ParametrosForm params){
        MochilaBO mochila = new MochilaBO();
        List<ItemBO> itensMochila = new ArrayList<>();
        BigDecimal valor = BigDecimal.ZERO;
        BigDecimal peso = BigDecimal.ZERO;
        
        for (int i = 0; i < params.getItensMochila(); i++) {
            ItemBO item = new ItemBO(params.getPesoMinObj(), params.getPesoMaxObj(), params.getVlMinObj(), params.getVlMaxObj());
            itensMochila.add(item);
            peso = peso.add(item.getPeso());
            valor = valor.add(item.getValor());
        }
        
        mochila.setItens(itensMochila);
        mochila.setValor(valor);
        mochila.setPeso(peso);
        
        return mochila;
    }
}
