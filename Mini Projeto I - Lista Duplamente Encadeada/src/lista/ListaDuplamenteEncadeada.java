package lista;

public class ListaDuplamenteEncadeada implements TListaMiniProjeto {

	// Primeiro Node da lista
	private Node initialNode;
	
	// A cada incremento ou decremento na lista, atualiza-se o valor deste atributo
	private int size;
	
	@Override
	public void add(String s) throws Exception {
		if(isNodePresente(s)) {
			throw new Exception("Elemento já presente na lista");
		}
	}

	@Override
	public String removeIndex(int i) throws Exception {
		validarSize();
		
		return null;
	}

	@Override // Implementado TODO testar com urgência
	public void removeElem(String s) throws Exception {
		validarSize();
		if(!isNodePresente(s)) {
			throw new Exception("Elemento não encontrado na lista");
		}
		
		Node anterior = null;
		Node aux = initialNode;
		while(aux != null) {
			if(aux.getDado().equals(s)) {
				if(aux == initialNode) { // Se o elemento a ser removido for o inicial
					initialNode = initialNode.getNextNode();
					initialNode.setPreviousNode(null);
				} else {
					aux.getNextNode().setPreviousNode(anterior);
					anterior.setNextNode(aux.getNextNode());
				}
				aux.setPreviousNode(null); // O elemento a ser removido perde a referência para seu antecessor
				aux.setNextNode(null); // A referência do auxiliar para seu próximo deve ser perdida
				size--; // Se um elemento for removido, o valor de size deve perder uma unidade
			}
			anterior = aux;
			aux = aux.getNextNode();
		}
	}
	
	/**
	 * Este método faz uso do método index para validar a presença de um node na lista
	 * @param s dado do node que se deseja validar a existência na lista
	 * @return true para elemento encontrado e false caso contrário
	 */
	private boolean isNodePresente(String s) {
		try {
			index(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override // Implementado usar apontador para Node anterior
	public String previous(String s) throws Exception {
		validarSize();
		int index = index(s);
		
		Node previous = null;
		Node aux = initialNode;
		
		for(int i = 0; i < index; i++) {
			previous = aux;
			aux = aux.getNextNode();
		}
		return previous.getDado();
	}
	
	/**
	 * Método usado pela próprica classe que verifica se há elementos na lista
	 * com base no valor atual do size.
	 * @throws Exception quando o valor de size indicar que não há elementos na lista
	 */
	private void validarSize() throws Exception {
		if(size <= 0)
			throw new Exception("Esta lista não possui nenhum elemento");
	}

	@Override // Implementado
	public int index(String s) throws Exception {
		validarSize();
		Node aux = initialNode;
		for (int i = 0; i < size; i++) {
			if(aux.getDado().equals(s)) {
				return i;
			}
			aux = aux.getNextNode();
		}
		
		throw new Exception("Elemento não encontrado");
	}

	@Override // Implementado
	public String elemen(int i) throws Exception {
		if(i >= size && i < 0) {
			throw new Exception("Esta lista não possui este índice.");
		}
		
		Node aux = initialNode;
		int contador = 0;
		while(aux != null) {	
			if(contador++ == i)
				return aux.getDado();
			aux = aux.getNextNode();
		}
		return null;
	}

	@Override // Implementado
	public int size() {
		return size;
	}

	@Override // Implementado
	public String first() {
		return size != 0 ? initialNode.getDado() : null; // O primeiro dado é o dado do nó inicial 
	}

	@Override // Implementado
	public String last() {
		if(initialNode == null) {
			return null;
		} else {
			
			Node aux = initialNode; // Node auxiliar para iterar sobre a lista
			while(aux.getNextNode() != null) { // Parará no último node da lista
				aux = aux.getNextNode();
			}
			// Retornará o dado do último elemento da lista
			return aux.getDado();
		}
	}

	@Override // Implementado
	public void print() {
		System.out.print("LISTA -> ");

		Node aux = initialNode; // Nó auxiliar para iterar sobre a lista
		while(aux != null) {
			System.out.print(aux.getDado() + " -> ");
			aux = aux.getNextNode();
		}
		System.out.println("NULL");
	}
	
	public static void main(String[] args) {
		ListaDuplamenteEncadeada l = new ListaDuplamenteEncadeada();
		System.out.println(l.size());
	}
}
