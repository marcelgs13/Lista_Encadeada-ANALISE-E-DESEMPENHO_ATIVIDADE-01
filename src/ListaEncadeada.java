public class ListaEncadeada {
    No cabeca;
    // Método para remover a primeira ocorrência de um elemento com valor igual a 'numero'
    public void remover(int numero) {
        if (cabeca == null) {
            System.out.println("Lista vazia");
            return;
        }
        if (cabeca.dado == numero) {
            cabeca = cabeca.proximo;
            return;
        }
        // Procura pelo elemento para remover
        No atual = cabeca;
        while (atual.proximo != null) {
            if (atual.proximo.dado == numero) {
                atual.proximo = atual.proximo.proximo;// Remove o nó e atualiza o ponteiro para o próximo nó
                return;
            }
            atual = atual.proximo;
        }
        System.out.println("Elemento não encontrado: " + numero);
    }
    // Método para inserir um novo elemento no final da lista
    public void inserirNoFinal(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
            return;
        }
        No atual = cabeca;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public void imprimirLista() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
    // Método para inserir um novo elemento em uma posição específica da lista
    public void adicionarNaPosicao(int posicao, int dado) {
        // Caso a posição seja o início, insere o nó como cabeça
        if (posicao == 1) {
            No novoNo = new No(dado);
            novoNo.proximo = cabeca;
            cabeca = novoNo;
            return;
        }
        // Percorre até a posição anterior à posição de inserção
        No atual = cabeca;
        for (int i = 1; i < posicao - 1 && atual != null; i++) {
            atual = atual.proximo;
        }
        // Verifica se a posição é válida
        if (atual == null) {
            System.out.println("Posição fora do alcance");
            return;
        }
        // Insere o novo nó na posição especificada
        No novoNo = new No(dado);
        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;
    }
}