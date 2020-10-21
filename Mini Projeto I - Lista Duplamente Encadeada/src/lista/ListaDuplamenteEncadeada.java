package lista;

public class ListaDuplamenteEncadeada implements TListaMiniProjeto {

	// Primeiro Node da lista
	private Node initialNode;
	
	// A cada incremento ou decremento na lista, atualiza-se o valor deste atributo
	private int size;
	
	@Override // Implementado
	public void add(String s) throws Exception {
		if(isNodePresente(s)) {
			throw new Exception("Elemento já presente na lista");
		}
		
		Node node = new Node(s);
		Node aux = initialNode;
		
		if(size == 0) {	// Insersão no começo
			initialNode = node;
			node.setPreviousNode(null);
		} else { // Insersão nas demais posições
			while(aux.getNextNode() != null) {
				aux = aux.getNextNode();
			}
			aux.setNextNode(node);
			node.setPreviousNode(aux);
		}
		size++;
	}

	@Override // Implementado
	public String removeIndex(int i) throws Exception {
		validarSize();
		
		Node aux = initialNode;
		for (int j = 0; j <= i; j++) {
			if(j == i) {
				Node removido = aux;
				removeElem(aux.getDado());
				return removido.getDado();
			}
			aux = aux.getNextNode();
		}
		return null;
	}

	@Override // Implementado
	public void removeElem(String s) throws Exception {
		validarSize();
		if(!isNodePresente(s)) {
			throw new Exception("Elemento não encontrado na lista");
		}
		
		Node aux = initialNode;
		while(aux != null) {
			if(aux.getDado().equals(s)) {
				if(aux == initialNode) { // Se o elemento a ser removido for o inicial
					initialNode = initialNode.getNextNode();
					initialNode.setPreviousNode(null);
				
				} else if(aux.getNextNode() == null) { // Se o elemento a ser removido for o último
					aux.getPreviousNode().setNextNode(null);
					
				} else { // Se o elemento a ser removido for um intermediário
					aux.getNextNode().setPreviousNode(aux.getPreviousNode());
					aux.getPreviousNode().setNextNode(aux.getNextNode());
				}
				
				// Para concluir a remoção (tanto do primeiro, ultimo ou intermediário) do elemento,
				// é conveniente fazer seus apontadores apontar para null.
				aux.setPreviousNode(null); // O elemento a ser removido perde a referência para seu antecessor
				aux.setNextNode(null); // A referência do auxiliar para seu próximo deve ser perdida
				size--; // Se um elemento for removido, o valor de size deve perder uma unidade
			}
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
			validarSize();
			index(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override // Implementado
	public String previous(String s) throws Exception {
		validarSize();
		
		if(isNodePresente(s)) {
			Node aux = initialNode;
			
			while(aux != null) {
				if(aux.getDado().equals(s))
					return aux.getPreviousNode().getDado();
				
				aux = aux.getNextNode();
			}
		}
		throw new Exception("Elemento não encontrado na lista");
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
		
		ListaDuplamenteEncadeada encadeada = new ListaDuplamenteEncadeada();
		Node node0 = new Node("n");
		Node node1 = new Node("y");
		Node node2 = new Node("c");
		Node node3 = new Node("o");
		Node node4 = new Node("l");
		Node node5 = new Node("a");
		Node node6 = new Node("s");
		
		node0.setNextNode(node1);
		node1.setNextNode(node2);
		node2.setNextNode(node3);
		node3.setNextNode(node4);
		node4.setNextNode(node5);
		node5.setNextNode(node6);
		
		node1.setPreviousNode(node0);
		node2.setPreviousNode(node1);
		node3.setPreviousNode(node2);
		node4.setPreviousNode(node3);
		node5.setPreviousNode(node4);
		node6.setPreviousNode(node5);
		
		encadeada.initialNode = node0;
		encadeada.print();
		encadeada.size = 7;
		try {
			System.out.println(encadeada.removeIndex(6));
			encadeada.print();
			System.out.println(encadeada.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}













