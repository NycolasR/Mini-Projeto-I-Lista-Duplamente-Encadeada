package lista;

public class ListaDuplamenteEncadeada implements TListaMiniProjeto {

	// Primeiro Node da lista
	private Node initialNode;
	
	@Override
	public void add(String s) throws Exception {
		Node node = new Node(s);
		Node aux = initialNode;
		
		if(size() == 0) { // Insersão no começo
			initialNode = node;
			node.setPreviousNode(null);
			
		} else { // Insersão nas demais posições
			
			while(aux.getNextNode() != null) {
				
				if(aux.getDado().equals(s))
					throw new Exception("Elemento já presente na lista");
				aux = aux.getNextNode();
			}
			aux.setNextNode(node);
			node.setPreviousNode(aux);
		}
	}

	@Override
	public String removeIndex(int i) throws Exception {
		validarSize();
		
		Node aux = initialNode;
		for (int j = 0; j <= i; j++) {
			if(j == i) {
				excluirNode(aux);
				return aux.getDado();
			}
			aux = aux.getNextNode();
		}
		return null;
	}

	/**
	 * Método usado para excluir um elemento da lista.
	 * Este método está sendo usado por ambos métodos de remoção implementados
	 * pela interface TListaMiniProjeto.
	 * @param node node a sex excluído da lista
	 */
	private void excluirNode(Node node) {
		if(node == initialNode) { // Se o elemento a ser removido for o inicial
			initialNode = initialNode.getNextNode();
		
		} else if(node.getNextNode() == null) { // Se o elemento a ser removido for o último
			node.getPreviousNode().setNextNode(null);
			
		} else { // Se o elemento a ser removido for um intermediário
			node.getNextNode().setPreviousNode(node.getPreviousNode());
			node.getPreviousNode().setNextNode(node.getNextNode());
		}
		
		// Para concluir a remoção (tanto do primeiro, ultimo ou intermediário) do elemento,
		// é conveniente fazer seus apontadores apontar para null.
		node.setPreviousNode(null); // O elemento a ser removido perde a referência para seu antecessor
		node.setNextNode(null); // A referência do auxiliar para seu próximo deve ser perdida
	}

	@Override
	public void removeElem(String s) throws Exception {
		validarSize();
		
		Node aux = initialNode;
		while(aux != null) {
			if(aux.getDado().equals(s)) {
				excluirNode(aux);
				return;
			}
			aux = aux.getNextNode();
		}
		// Se a execução chegou até aqui, o elemento especificado não foi encontrado
		throw new Exception("Elemento não encontrado na lista");
	}

	@Override
	public String previous(String s) throws Exception {
		validarSize();
		
		Node aux = initialNode;
			
		while(aux != null) {
			if(aux.getDado().equals(s)) {				
				if(aux == initialNode)
					throw new Exception("Este é o primeiro elemento da lista, logo, ele não possui um antecessor.");
				return aux.getPreviousNode().getDado();
			}
			aux = aux.getNextNode();
		}
		// Se a execução chegou até aqui, o elemento especificado não foi encontrado
		throw new Exception("Elemento não encontrado na lista");
	}
	
	/**
	 * Método usado pela próprica classe que verifica se há elementos na lista
	 * com base no valor atual do size.
	 * @throws Exception quando o valor de size indicar que não há elementos na lista
	 */
	private void validarSize() throws Exception {
		if(size() <= 0)
			throw new Exception("Esta lista não possui nenhum elemento");
	}

	@Override
	public int index(String s) throws Exception {
		validarSize();
		Node aux = initialNode;
		for (int i = 0; i < size(); i++) {
			if(aux.getDado().equals(s)) {
				return i;
			}
			aux = aux.getNextNode();
		}
		// Se a execução chegou até aqui, o elemento especificado não foi encontrado
		throw new Exception("Elemento não encontrado na lista");
	}

	@Override
	public String elemen(int i) throws Exception {
		if(i >= size() || i < 0) {
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

	@Override
	public int size() {
		int size = 0;
		
		Node aux = initialNode;
		while(aux != null) {
			size++;
			aux = aux.getNextNode();
		}
		
		return size;
	}

	@Override
	public String first() {
		return size() != 0 ? initialNode.getDado() : null; // O primeiro dado é o dado apontado pelo nó inicial 
	}

	@Override
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

	@Override
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
//		encadeada.size = 7;
		try {
			System.out.println(encadeada.removeIndex(6));
			encadeada.print();
			System.out.println(encadeada.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}













