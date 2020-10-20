package lista;

public class ListaDuplamenteEncadeada implements TListaMiniProjeto {

	private Node initialNode;
	
	@Override
	public void add(String s) throws Exception {
		
	}

	@Override
	public String removeIndex(int i) throws Exception {
		return null;
	}

	@Override
	public void removeElem(String s) throws Exception {
		
	}

	@Override
	public String previous(String s) throws Exception {
		return null;
	}

	@Override
	public int index(String s) throws Exception {
		return 0; // TODO próximo a ser feito
	}

	@Override
	public String elemen(int i) throws Exception {
		return null; // TODO próximo a ser feito
	}

	@Override
	public int size() {
		return 0; // TODO próximo a ser feito
	}

	@Override
	public String first() {
		return size() == 0 && initialNode != null ? initialNode.getDado() : null; // O primeiro dado é o dado do nó inicial 
	}

	@Override
	public String last() {
		return null; // TODO próximo a ser feito
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
		ListaDuplamenteEncadeada l = new ListaDuplamenteEncadeada();
		System.out.println(l.first());
	}
}
