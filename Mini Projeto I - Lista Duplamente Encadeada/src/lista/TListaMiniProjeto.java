package lista;

public interface TListaMiniProjeto {

	/**
	 * esse metodo insere a entrada na lista. No caso de listas ordenadas, a insercao
	 * acontece na posicao adequada. No caso de listas desordenadas, a insercao acontece 
	 * no final da lista.
	 * @param s valor a ser guardado na lista
	 * @throws Exception nao deve ser possivel inserir valores repetidos dentro da lista
	 */
	public void add(String s) throws Exception;
	
	/**
	 * o metodo remove o elemento que esta guardado no indice passado por parametro (comecando de 0)
	 * @param indice do qual o elemento sera removido
	 * @return retorna o elemento que foi removido da lista
	 * @throws Exception o m�todo lanca uma excecao caso o indice passado nao exista na lista atualmente
	 */
	public String removeIndex(int i) throws Exception;
	
	/**
	 * o metodo remove da lista o elemento que foi passado por parametro
	 * @param s elemento a ser removido da lista
	 * @throws Exception o metodo lanca uma excecao caso o elemento n�o faca parte da lista
	 */
	public void removeElem(String s) throws Exception;
	
	/**
	 * retorna o antecessor de um elemento na lista
	 * @param s elemento que se deseja consultar o antecessor
	 * @return o metodo retorna o antecessor do elemento passado por parametro
	 * @throws Exception o metodo lanca uma excecao caso o elemento recebido por parametro 
	 * nao faca parte da lista ou nao possua antecessor (seja o primeiro)
	 */
	public String previous(String s) throws Exception;
	
	/**
	 * o metodo retorna o indice do elemento recebido por parametro dentro da lista (comecando de 0)
	 * @param s elemento que se deseja consultar o indice
	 * @return retorna o indice do elemento recebido por parametro
	 * @throws Exception lanca uma excecao caso o elemento recebido nao faca parte da lista
	 */
	public int index(String s) throws Exception;
	
	/**
	 * o metodo retorna o elemento da lista que esta posicionado no indice recebido por parametro (comecando de 0)
	 * @param i indice cujo elemento se deseja consultar
	 * @return reteorna o elemento da lista que esta posicionado no indice recebido
	 * @throws Exception lanca uma excecao caso a lista nao possua esse indice
	 */
	public String elemen(int i) throws Exception;

	/**
	 * @return retorna o tamanho atual da lista
	 */
	public int size();
	
	/**
	 * @return retorna o primeiro elemento da lista (null caso a lista esteja vazia)
	 */
	public String first();

	/**
	 * @return retorna o ultimo elemento da lista (null caso a lista esteja vazia)
	 */
	public String last();

	/**
	 * imprimi no console a lista dos elementos, seguindo o seguinte padrao:
	 * (lista com elementos) LISTA -> "ABC" -> "BCA" -> NULL
	 * (lista vazia) LISTA -> NULL
	 */
	public void print();
}
