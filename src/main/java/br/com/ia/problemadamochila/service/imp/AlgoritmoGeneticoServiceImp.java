package br.com.ia.problemadamochila.service.imp;

import br.com.ia.problemadamochila.ParametrosForm;
import br.com.ia.problemadamochila.bo.ItemBO;
import br.com.ia.problemadamochila.bo.MochilaBO;
import br.com.ia.problemadamochila.service.AlgoritmoGeneticoService;
import br.com.ia.problemadamochila.service.MochilaService;
import br.com.ia.problemadamochila.to.ResultadoTO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("algoritmoGeneticoService")
public class AlgoritmoGeneticoServiceImp implements AlgoritmoGeneticoService {

    @Autowired
    private MochilaService mochilaService;

    @Override
    public Set<ResultadoTO> execute(ParametrosForm form) {
        MochilaBO mochilaAceitavel = null;
        Set<ResultadoTO> resultado = new TreeSet<>();
        Integer iteracoes = 1;
        BigDecimal txAceitacao = new BigDecimal(form.getTxAceitacao()).divide(new BigDecimal(100));
        BigDecimal aceite = new BigDecimal(form.getVlIdeal()).multiply(txAceitacao);
        
        List<MochilaBO> populacao = mochilaService.geraPopulacaoInicial(form);

        mochilaAceitavel = getMochilaPorAceite(populacao, aceite, form.getPesoMaxMochila());
        
        if(mochilaAceitavel != null){
            resultado.add(new ResultadoTO(iteracoes, mochilaAceitavel.getValor(), mochilaAceitavel.getPeso(), mochilaAceitavel.getFitness()));
        }
        
        while (mochilaAceitavel == null && iteracoes <= form.getIteracoes()) {            
            populacao = getListaEvolucao(populacao, form);
            populacao = mochilaService.calculaFitnessDaPopulacao(populacao, form.getPesoMaxMochila());
            mochilaAceitavel = getMochilaPorAceite(populacao, aceite, form.getPesoMaxMochila());
            
            if(mochilaAceitavel == null){
                MochilaBO melhorMochila = getMelhorMochila(populacao);
                resultado.add(new ResultadoTO(iteracoes, melhorMochila.getValor(), melhorMochila.getPeso(), melhorMochila.getFitness()));
            } else {
                resultado.add(new ResultadoTO(iteracoes, mochilaAceitavel.getValor(), mochilaAceitavel.getPeso(), mochilaAceitavel.getFitness()));
            }
            
            iteracoes++;
        }

        return resultado;
    }
    
    private List<MochilaBO> getListaEvolucao(List<MochilaBO> populacao, ParametrosForm form){
        Integer qntPais = form.getIntGer();
        List<MochilaBO> pais = new ArrayList<>();
        BigDecimal fitnessTotal = getFitnessTotal(populacao);
        
        for(int i = 0; i < qntPais; i++){
            MochilaBO pai = getPaiRoleta(populacao, fitnessTotal, form.getPopulacao());
            pais.add(pai);
            populacao.remove(pai);
            fitnessTotal = fitnessTotal.subtract(pai.getFitness());
        }
        
        List<MochilaBO> filhos = crossover(pais);
        
        for (int i = 0; i < filhos.size(); i++) {
            int index = new Random().nextInt(populacao.size());
            populacao.remove(index);
        }
        
        filhos = mutacao(filhos, form);
        
        populacao.addAll(filhos);
        populacao.addAll(pais);
        
        return populacao;
    }
    
    private List<MochilaBO> crossover(List<MochilaBO> pais){
        List<MochilaBO> filhos = new ArrayList<>();

        Integer qntPais = pais.size();
        Integer qntFilhos = qntPais / 2;
        
        for (int i = 0; i < qntFilhos; i++) {
            MochilaBO filho = new MochilaBO();
            List<ItemBO> itensFilho = new ArrayList<>();
            MochilaBO mochilaPai = pais.get(i);
            MochilaBO mochilaMae = pais.get(i + qntFilhos);
            
            itensFilho.addAll(mochilaPai.getItens().subList(0, 5));
            itensFilho.addAll(mochilaMae.getItens().subList(5, 10));
            itensFilho.addAll(mochilaPai.getItens().subList(10, 15));
            
            filho.setItens(itensFilho);
            
            filhos.add(calculaPesoValorMochila(filho));
        }
        
        return filhos;
    }
    
    private List<MochilaBO> mutacao(List<MochilaBO> filhos, ParametrosForm form){
        List<MochilaBO> filhosMutados = new ArrayList<>();
        BigDecimal txAceitacao = new BigDecimal(form.getTxMutacao()).divide(new BigDecimal(100));
        BigDecimal qntMutacao = new BigDecimal(filhos.size()).multiply(txAceitacao).setScale(0, RoundingMode.HALF_UP);
        
        for (int i = 0; i < qntMutacao.intValue(); i++) {
            int index = new Random().nextInt(filhos.size());
            MochilaBO filhoMutacao = filhos.get(index);
            filhos.remove(filhoMutacao);
            
            int indexFilho = new Random().nextInt(filhoMutacao.getItens().size());
            List<ItemBO> itens = filhoMutacao.getItens();
            itens.remove(indexFilho);
            itens.add(new ItemBO(form.getPesoMinObj(), form.getPesoMaxObj(), form.getVlMinObj(), form.getVlMaxObj()));
            filhoMutacao.setItens(itens);
            
            filhosMutados.add(filhoMutacao);
        }
        
        filhos.addAll(filhosMutados);
        
        return filhos;
    }
    
    private MochilaBO calculaPesoValorMochila(MochilaBO mochila){
        BigDecimal peso = BigDecimal.ZERO;
        BigDecimal valor = BigDecimal.ZERO;
        
        for (ItemBO item : mochila.getItens()) {
            peso = peso.add(item.getPeso());
            valor = valor.add(item.getValor());
        }
        
        mochila.setPeso(peso);
        mochila.setValor(valor);
        
        return mochila;
    }

    private MochilaBO getMochilaPorAceite(List<MochilaBO> lista, BigDecimal aceiteValor, BigDecimal aceitePeso) {
        Set<MochilaBO> listaOrdenada = new TreeSet<>(lista);
        MochilaBO retorno = null;

        for (MochilaBO mochila : listaOrdenada) {
            if (mochila.getValor().compareTo(aceiteValor) != -1 && mochila.getPeso().compareTo(aceitePeso) != 1) {
                retorno = mochila;
                break;
            }
        }

        return retorno;
    }

    private MochilaBO getPaiRoleta(List<MochilaBO> lista, BigDecimal fitnessTotal, Integer tamanhoPopulacao) {
        Random random = new Random();
        BigDecimal randNum = new BigDecimal(random.nextDouble()).multiply(fitnessTotal).setScale(2, RoundingMode.HALF_UP);
        int i;

        for (i = 0; i < tamanhoPopulacao && randNum.compareTo(BigDecimal.ZERO) > 0; ++i) {
            randNum = randNum.subtract(lista.get(i).getFitness());
        }

        return lista.get(i - 1);
    }
    
    private BigDecimal getFitnessTotal(List<MochilaBO> lista){
        BigDecimal retorno = BigDecimal.ZERO;
        
        for (MochilaBO item : lista) {
            retorno = retorno.add(item.getFitness());
        }
        
        return retorno;
    }
    
    private MochilaBO getMelhorMochila(List<MochilaBO> lista){
        Set<MochilaBO> listaOrdenada = new TreeSet<>(lista);
        return listaOrdenada.iterator().next();
    }
}