package org.example;

class MyDeque<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tamanio;

    public MyDeque() {
        this.inicio = null;
        this.fin = null;
        this.tamanio = 0;
    }

    public void addFirst (T dato){
        Nodo<T> nuevo = new Nodo<>(dato);

        if (isEmpty()){
            inicio = fin = nuevo;
        } else {
            nuevo.siguiente = inicio;
            nuevo.anterior = fin;
            inicio = nuevo;
        }
        tamanio ++;
    }

    public void addLast(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);

        if (isEmpty()){
            inicio = fin = nuevo;
        } else{
            fin.siguiente = nuevo;
            fin.anterior = fin;
            fin = nuevo;
        }
        tamanio ++;
    }

    public T removeFirst(){

        if(isEmpty()){
            System.out.println("Deque esta vacio");
            return null;
        }
        T dato = inicio.dato;

        if(inicio == fin){
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        tamanio --;
        return dato;
    }

    public T removeLast() {
        if (isEmpty() || fin == null) {
            System.out.println("Deque vacío");
            return null;
        }

        T dato = fin.dato;

        if (inicio == fin) {
            inicio = fin = null;
        } else {
            fin = fin.anterior;

            if (fin != null) {
                fin.siguiente = null;
            }
        }

        tamanio--;
        return dato;
    }

    public boolean isEmpty(){
        return tamanio == 0;
    }

    public T peekFirst() {
        return isEmpty() ? null : inicio.dato;
    }

    public T peekLast() {
        return isEmpty() ? null : fin.dato;
    }

    public int tamanio(){
        return tamanio;
    }

    public void mostrar() {
        Nodo<T> actual = inicio;
        while (actual != null) {
            System.out.print(actual.dato + " --> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
