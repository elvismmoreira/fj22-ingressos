package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {
	
	private List<Sessao> sessoesDaSala;
	
	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}

	private boolean horarioIsConflitante(Sessao sessaoExixtente, Sessao sessaoNova) {
		
		LocalDate hoje = LocalDate.now();
		
		LocalDateTime horarioSessaoExistente = sessaoExistente.getHorario().atDate(hoje);
		LocalDateTime horarioSessaoNova = sessaoNova.getHorario().atDate(hoje);
		
		boolean terminaAntes = sessaoNova.getHorarioTermino()
				              .isBefore(horarioExistente);
		boolean comecaDepois = sessaoExistente.getHorarioTermino()
				              .isBefore(horarioNova);
		
		if (terminaAntes || comecaDepois) {
			return false;
		}
		return true;
	}
	
	public boolean cabe(Sessao sessaoNova) {
		
		return sessoesDaSala.parallelStream().noneMatch(sessaoExixtente ->
		                                      horarioIsConflitante(sessaoExistente, sessaoNova));
	}
	
	
	
}
